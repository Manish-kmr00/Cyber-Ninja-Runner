package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import com.amazon.aps.ads.ApsLog;
import com.amazon.aps.ads.ApsMigrationUtil;
import com.amazon.aps.ads.model.ApsLogLevel;
import com.amazon.aps.ads.privacy.ApsPrivacyManager;
import com.amazon.aps.ads.util.ApsUtils;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class AdRegistration {
    private static final String LOGTAG = "AdRegistration";
    private static AdRegistration adRegistrationInstance;
    private static CMPFlavor cmpFlavor;
    private static boolean consentStringDirty;
    private static ConsentStatus currentConsentStatus;
    private static String currentVendorListString;
    private static Map<String, String> customDictionary;
    private static JSONObject dsaTransparencyData;
    private static HashMap<String, SlotGroup> groups;
    private static boolean isOmSdkActivated;
    private static String lastSeenNonIABEncodedConsentString;
    private static boolean locationEnabled;
    private static String mAppKey;
    private static Context mContext;
    static List<String> providersProprietaryKeys;
    private static String sdkDistributionPlace;
    private static boolean testMode;
    private ActivityMonitor activityMonitor;
    private static Integer initCount = 0;
    static MRAIDPolicy mraidPolicy = MRAIDPolicy.AUTO_DETECT;
    static String[] serverlessMarkers = {"com.amazon.admob_adapter.APSAdMobCustomBannerEvent", "com.amazon.mopub_adapter.APSMopubCustomBannerEvent", "com.applovin.mediation.adapters.AmazonAdMarketplaceMediationAdapter"};
    private static Map<String, DTBCacheData> adMobRequestIdMap = new HashMap();
    private Set<AdProvider> providers = new HashSet();
    private EventDistributor eventDistributor = new EventDistributor();

    @Deprecated
    public enum CMPFlavor {
        CMP_NOT_DEFINED,
        GOOGLE_CMP,
        MOPUB_CMP,
        ADMOB_CMP
    }

    @Deprecated
    public enum ConsentStatus {
        CONSENT_NOT_DEFINED,
        EXPLICIT_YES,
        EXPLICIT_NO,
        UNKNOWN
    }

    private ActivityMonitor getActivityMonitor() {
        return this.activityMonitor;
    }

    private void setActivityMonitor(ActivityMonitor activityMonitor) {
        this.activityMonitor = activityMonitor;
    }

    public static Activity getCurrentActivity() {
        return adRegistrationInstance.getActivityMonitor().getCurrentActivity();
    }

    public static void addProvider(AdProvider adProvider) {
        if (adRegistrationInstance != null) {
            Class<?> cls = adProvider.getClass();
            Iterator<AdProvider> it = adRegistrationInstance.providers.iterator();
            while (it.hasNext()) {
                if (it.next().getClass().equals(cls)) {
                    return;
                }
            }
            adRegistrationInstance.providers.add(adProvider);
            appendProprietaryProviderKeys(adProvider.getProprietaryKeys());
            return;
        }
        throw new IllegalStateException("Instance must be initialized prior to adding providers");
    }

    @Deprecated
    public static EventDistributor getEventDistributer() {
        AdRegistration adRegistration = adRegistrationInstance;
        if (adRegistration != null) {
            return adRegistration.eventDistributor;
        }
        throw new IllegalStateException("Instance must be initialized prior using getEventDistributer API");
    }

    public static Set<AdProvider> getAdProviders() {
        AdRegistration adRegistration = adRegistrationInstance;
        if (adRegistration != null) {
            return adRegistration.providers;
        }
        return null;
    }

    static void appendProprietaryProviderKeys(String[] strArr) {
        if (providersProprietaryKeys == null) {
            providersProprietaryKeys = new ArrayList();
        }
        for (String str : strArr) {
            providersProprietaryKeys.add(str);
        }
    }

    public static List<String> getProprietaryProviderKeys() {
        if (providersProprietaryKeys == null) {
            providersProprietaryKeys = new ArrayList();
        }
        return providersProprietaryKeys;
    }

    private AdRegistration(String str, Context context) throws IllegalArgumentException {
        if (context == null || str == null || "".equals(str.trim())) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid parameters for initialization. SDK initialize failed due to invalid registration parameters");
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Invalid parameters for initialization. SDK initialize failed due to invalid registration parameters");
            throw illegalArgumentException;
        }
        try {
            Class.forName("com.amazon.aps.shared.APSAnalytics");
            Class.forName("com.iabtcf.decoder.TCString");
            Class.forName("com.iabtcf.v2.PublisherRestriction");
            if (Build.VERSION.SDK_INT >= 26 && WebView.getCurrentWebViewPackage() == null) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("No WebView Installed");
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "No WebView Installed");
                throw illegalArgumentException2;
            }
            mAppKey = str;
            Context applicationContext = context.getApplicationContext();
            mContext = applicationContext;
            APSAnalytics.init(applicationContext);
            APSAnalytics.setVersion(getVersion());
            ApsUtils.INSTANCE.setupMetrics(mContext);
            DtbSharedPreferences dtbSharedPreferencesCreateInstance = DtbSharedPreferences.createInstance();
            context.checkCallingOrSelfPermission("android.permission.INTERNET");
            if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
                DtbLog.error(LOGTAG, "Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
            }
            String versionInUse = dtbSharedPreferencesCreateInstance.getVersionInUse();
            if (versionInUse == null || DtbCommonUtils.isNullOrEmpty(versionInUse)) {
                dtbSharedPreferencesCreateInstance.setVersionInUse(DtbConstants.SDK_VERSION);
            }
            DtbOmSdkSessionManager.activateOMSDK(mContext);
            currentConsentStatus = ConsentStatus.CONSENT_NOT_DEFINED;
            cmpFlavor = CMPFlavor.CMP_NOT_DEFINED;
            consentStringDirty = false;
            customDictionary = new HashMap();
            JSONObject jSONObjectLoadJsonFromAsset = DTBAdUtil.loadJsonFromAsset("aps_distribution_marker.json");
            if (jSONObjectLoadJsonFromAsset != null) {
                try {
                    sdkDistributionPlace = jSONObjectLoadJsonFromAsset.getString("distribution");
                } catch (Exception unused) {
                    DtbLog.warn("Unable to get distribution place value");
                }
            }
        } catch (ClassNotFoundException unused2) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Missing the dependency libraries - Ex; com.iabtcf:iabtcf-decoder:2.0.10. For further details, please refer to our Android SDK documentation.");
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Missing the dependency libraries - Ex; com.iabtcf:iabtcf-decoder:2.0.10. For further details, please refer to our Android SDK documentation.");
            throw illegalArgumentException3;
        }
    }

    public static void setDsaTransparency(JSONObject jSONObject) {
        dsaTransparencyData = jSONObject;
    }

    public static JSONObject getDsaTransparencyData() {
        return dsaTransparencyData;
    }

    public static String getAppKey() {
        return mAppKey;
    }

    public static boolean isInitialized() {
        return adRegistrationInstance != null;
    }

    public static AdRegistration getInstance(String str, Context context) throws IllegalArgumentException {
        if (DtbCommonUtils.isNullOrEmpty(str) || context == null) {
            ApsMetrics.customEvent(ApsMigrationUtil.getIsApsInitCalled() ? "apsInitCallFailed" : "initCallFailed", str, null);
        }
        if (!isInitialized()) {
            ApsPrivacyManager.INSTANCE.init(context);
            adRegistrationInstance = new AdRegistration(str, context);
            ApsPrivacyManager.INSTANCE.removeStoragesByApsIfNoConsent();
            DTBMetricsConfiguration.getInstance();
            if (DTBMetricsConfiguration.getInstance().isFeatureEnabled(DTBMetricsConfiguration.FEATURE_CONFIG_IN_INIT)) {
                DtbDeviceRegistration.verifyRegistration();
            }
        } else if (str != null && !str.equals(mAppKey)) {
            mAppKey = str;
            DtbSharedPreferences.createInstance();
        }
        adRegistrationInstance.setActivityMonitor(new ActivityMonitor(context));
        String str2 = ApsMigrationUtil.getIsApsInitCalled() ? "apsInitCall" : "initCall";
        Integer numValueOf = Integer.valueOf(initCount.intValue() + 1);
        initCount = numValueOf;
        ApsMetrics.customEvent(str2, String.valueOf(numValueOf), null);
        return adRegistrationInstance;
    }

    @Deprecated
    public static void setAppKey(String str) throws IllegalArgumentException {
        if (!isInitialized()) {
            throw new IllegalStateException("mDTB was not initialized, please use AdRegistration.getInstance(...) before using other SDK calls");
        }
        if (!DtbCommonUtils.isNullOrEmpty(str)) {
            mAppKey = str;
            DtbSharedPreferences.createInstance();
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid parameters:appKey for initialization.");
            DtbLog.fatal(LOGTAG, "mDTB SDK initialize failed due to invalid registration parameter:appKey.", illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    @Deprecated
    public static void setContext(Context context) {
        if (context != null) {
            mContext = context.getApplicationContext();
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid parameters:context for initialization.");
            DtbLog.fatal(LOGTAG, "mDTB SDK initialize failed due to invalid registration parameter:context.", illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static void setMRAIDPolicy(MRAIDPolicy mRAIDPolicy) {
        mraidPolicy = mRAIDPolicy;
        DTBAdRequest.resetMraid();
    }

    public static MRAIDPolicy getMRAIDPolicy() {
        return mraidPolicy;
    }

    public static void setMRAIDSupportedVersions(String[] strArr) {
        DTBAdRequest.setMRAIDSupportedVersions(strArr);
    }

    public static void enableLogging(boolean z) {
        try {
            if (z) {
                DtbLog.setLogLevel(DTBLogLevel.All);
                ApsLog.setLogLevel(ApsLogLevel.values()[DTBLogLevel.All.intValue()]);
            } else {
                DtbLog.setLogLevel(DTBLogLevel.Error);
                ApsLog.setLogLevel(ApsLogLevel.values()[DTBLogLevel.Error.intValue()]);
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute enableLogging method", e);
        }
    }

    public static void enableLogging(boolean z, DTBLogLevel dTBLogLevel) {
        try {
            if (z) {
                DtbLog.setLogLevel(dTBLogLevel);
                ApsLog.setLogLevel(ApsLogLevel.values()[dTBLogLevel.intValue()]);
            } else {
                DtbLog.setLogLevel(DTBLogLevel.Error);
            }
        } catch (RuntimeException e) {
            DtbLog.error(LOGTAG, "Fail to execute enableLogging method with logLevel argument");
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute enableLogging method with logLevel argument", e);
        }
    }

    public static void enableTesting(boolean z) {
        try {
            if (!z) {
                testMode = false;
            } else if (!DTBAdUtil.isInstalledFromAppStore(mContext)) {
                testMode = z;
                DtbLog.enableCallerInfo(z);
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute enableTesting method", e);
        }
    }

    public static boolean isTestMode() {
        return testMode;
    }

    public static void useGeoLocation(boolean z) {
        locationEnabled = z;
    }

    public static boolean isLocationEnabled() {
        return locationEnabled;
    }

    public static String getVersion() {
        return DtbCommonUtils.getSDKVersion();
    }

    static String getSDKDistributionPlace() {
        return sdkDistributionPlace;
    }

    static String[] getServerlessMarkers() {
        return serverlessMarkers;
    }

    @Deprecated
    public static void setServerlessMarkers(String[] strArr) {
        serverlessMarkers = strArr;
    }

    public static class SlotGroup {
        String name;
        Set<DTBAdSize> slots;

        public SlotGroup(String str) {
            if (DtbCommonUtils.isNullOrEmpty(str)) {
                throw new IllegalArgumentException("Slot Group name cannot be null or empty");
            }
            this.name = str;
            this.slots = new HashSet();
        }

        public void addSlot(DTBAdSize dTBAdSize) {
            try {
                for (DTBAdSize dTBAdSize2 : this.slots) {
                    if (dTBAdSize2.getWidth() == dTBAdSize.getWidth() && dTBAdSize2.getHeight() == dTBAdSize.getHeight() && dTBAdSize2.getDTBAdType() == dTBAdSize.getDTBAdType()) {
                        return;
                    }
                }
                this.slots.add(dTBAdSize);
            } catch (RuntimeException e) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute addSlot method in SlotGroup class", e);
            }
        }

        DTBAdSize getSizeBySlotUUID(String str) {
            for (DTBAdSize dTBAdSize : this.slots) {
                if (dTBAdSize.getSlotUUID().equals(str)) {
                    return dTBAdSize;
                }
            }
            return null;
        }

        public DTBAdSize getSizeByWidthAndHeight(int i, int i2) {
            return getSizeByWidthHeightType(i, i2, AdType.DISPLAY);
        }

        public DTBAdSize getSizeByWidthHeightType(int i, int i2, AdType adType) {
            try {
                for (DTBAdSize dTBAdSize : this.slots) {
                    if (dTBAdSize.getHeight() == i2 && dTBAdSize.getWidth() == i && dTBAdSize.getDTBAdType() == adType) {
                        return dTBAdSize;
                    }
                }
                return null;
            } catch (RuntimeException e) {
                APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute getSizeByWidthHeightType method in SlotGroup class", e);
                return null;
            }
        }

        public DTBAdSize getSizeByBannerType(DTBBannerType dTBBannerType) {
            try {
                int i = AnonymousClass1.$SwitchMap$com$amazon$device$ads$DTBBannerType[dTBBannerType.ordinal()];
                if (i == 1) {
                    return getSizeByWidthAndHeight(320, 50);
                }
                if (i != 2) {
                    return null;
                }
                return getSizeByWidthAndHeight(728, 90);
            } catch (RuntimeException e) {
                APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute getSizeByBannerType method in SlotGroup class", e);
                return null;
            }
        }

        public DTBAdSize getSizeBySlotType(DTBSlotType dTBSlotType) {
            try {
                int i = AnonymousClass1.$SwitchMap$com$amazon$device$ads$DTBSlotType[dTBSlotType.ordinal()];
                int i2 = 50;
                int i3 = 320;
                if (i == 1) {
                    return getSizeByWidthAndHeight(320, 50);
                }
                if (i == 2) {
                    return getSizeByWidthAndHeight(300, 250);
                }
                if (i == 3) {
                    return getSizeByWidthAndHeight(728, 90);
                }
                if (i != 4) {
                    return null;
                }
                if (DtbDeviceDataRetriever.isTablet()) {
                    i2 = 90;
                    i3 = 728;
                }
                return getSizeByWidthAndHeight(i3, i2);
            } catch (RuntimeException e) {
                APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute getSizeBySlotType method in SlotGroup class", e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.amazon.device.ads.AdRegistration$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$ads$DTBBannerType;
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$ads$DTBSlotType;

        static {
            int[] iArr = new int[DTBSlotType.values().length];
            $SwitchMap$com$amazon$device$ads$DTBSlotType = iArr;
            try {
                iArr[DTBSlotType.SLOT_320_50.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$DTBSlotType[DTBSlotType.SLOT_300_250.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$DTBSlotType[DTBSlotType.SLOT_728_90.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$DTBSlotType[DTBSlotType.SLOT_SMART.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[DTBBannerType.values().length];
            $SwitchMap$com$amazon$device$ads$DTBBannerType = iArr2;
            try {
                iArr2[DTBBannerType.PHONE_BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$DTBBannerType[DTBBannerType.TABLET_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static void addSlotGroup(SlotGroup slotGroup) {
        try {
            if (groups == null) {
                groups = new HashMap<>();
            }
            groups.put(slotGroup.name, slotGroup);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute addSlotGroup method", e);
        }
    }

    public static SlotGroup getSlotGroup(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap<String, SlotGroup> map = groups;
            if (map != null) {
                return map.get(str);
            }
            return null;
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute getSlotGroup method", e);
            return null;
        }
    }

    static boolean hasAdapters() {
        for (String str : serverlessMarkers) {
            try {
                Class.forName(str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Deprecated
    public static boolean isConsentStatusUnknown() {
        try {
            return currentConsentStatus == ConsentStatus.CONSENT_NOT_DEFINED || currentConsentStatus == ConsentStatus.UNKNOWN || DtbSharedPreferences.getInstance().getVendorList() == null;
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute isConsentStatusUnknown method", e);
            return true;
        }
    }

    static ConsentStatus getConsentStatus() {
        if (!isInitialized()) {
            throw new IllegalStateException("mDTB was not initialized, please use AdRegistration.getInstance(...) before using other SDK calls");
        }
        String consentStatus = DtbSharedPreferences.getInstance().getConsentStatus();
        if (consentStatus == null) {
            return currentConsentStatus;
        }
        return ConsentStatus.valueOf(consentStatus);
    }

    static CMPFlavor getCMPFlavor() {
        if (!isInitialized()) {
            throw new IllegalStateException("mDTB was not initialized, please use AdRegistration.getInstance(...) before using other SDK calls");
        }
        String cMPFlavor = DtbSharedPreferences.getInstance().getCMPFlavor();
        if (cMPFlavor == null) {
            return cmpFlavor;
        }
        return CMPFlavor.valueOf(cMPFlavor);
    }

    @Deprecated
    public static void setVendorList(List<Integer> list) {
        if (!isInitialized()) {
            throw new IllegalStateException("mDTB was not initialized, please use AdRegistration.getInstance(...) before using other SDK calls");
        }
        try {
            if (list == null) {
                DtbLog.error(LOGTAG, "Set vendor list failed due to invalid vendor list parameters with value null.");
                return;
            }
            String stringFromVendorList = getStringFromVendorList(list);
            String str = currentVendorListString;
            if (str == null || !str.equals(stringFromVendorList)) {
                consentStringDirty = true;
                currentVendorListString = stringFromVendorList;
                DtbSharedPreferences.getInstance().saveVendorList(stringFromVendorList);
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute setVendorList method", e);
        }
    }

    @Deprecated
    public static void setConsentStatus(ConsentStatus consentStatus) {
        if (!isInitialized()) {
            throw new IllegalStateException("mDTB was not initialized, please use AdRegistration.getInstance(...) before using other SDK calls");
        }
        try {
            if (consentStatus == ConsentStatus.CONSENT_NOT_DEFINED) {
                DtbLog.error(LOGTAG, "Set consent status failed due to invalid consent status parameters. Not allowed to set consent not defined.");
                return;
            }
            ConsentStatus consentStatus2 = currentConsentStatus;
            if (consentStatus2 == null || consentStatus2 != consentStatus) {
                consentStringDirty = true;
                currentConsentStatus = consentStatus;
                DtbSharedPreferences.getInstance().saveConsentStatus(consentStatus.name());
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute setConsentStatus method", e);
        }
    }

    @Deprecated
    public static void setCMPFlavor(CMPFlavor cMPFlavor) {
        if (!isInitialized()) {
            throw new IllegalStateException("mDTB was not initialized, please use AdRegistration.getInstance(...) before using other SDK calls");
        }
        try {
            if (cMPFlavor == CMPFlavor.CMP_NOT_DEFINED) {
                DtbLog.error(LOGTAG, "Set cmp type failed due to invalid cmp type parameters. Not allowed to set cmp type to not defined.");
                return;
            }
            CMPFlavor cMPFlavor2 = cmpFlavor;
            if (cMPFlavor2 == null || cMPFlavor2 != cMPFlavor) {
                consentStringDirty = true;
                cmpFlavor = cMPFlavor;
                DtbSharedPreferences.getInstance().saveCMPFlavor(cMPFlavor.name());
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute setCMPFlavor method", e);
        }
    }

    static String getEncodedNonIABString() {
        String encodedNonIABConsentString;
        if (consentStringDirty) {
            String vendorList = DtbSharedPreferences.getInstance().getVendorList();
            String consentStatus = DtbSharedPreferences.getInstance().getConsentStatus();
            String cMPFlavor = DtbSharedPreferences.getInstance().getCMPFlavor();
            if (vendorList == null && consentStatus == null && cMPFlavor == null) {
                encodedNonIABConsentString = "";
            } else {
                encodedNonIABConsentString = DTBGDPREncoder.getEncodedNonIABConsentString(getVendorListFromString(vendorList));
                if (!DtbCommonUtils.isNullOrEmpty(encodedNonIABConsentString)) {
                    DtbSharedPreferences.getInstance().saveNonIABCustomConsent(encodedNonIABConsentString);
                }
            }
            consentStringDirty = false;
            lastSeenNonIABEncodedConsentString = encodedNonIABConsentString;
            return encodedNonIABConsentString;
        }
        return lastSeenNonIABEncodedConsentString;
    }

    @Deprecated
    public static void resetNonIAB() {
        try {
            DtbSharedPreferences.getInstance().removeCMPFlavor();
            DtbSharedPreferences.getInstance().removeConsentStatus();
            DtbSharedPreferences.getInstance().removeVendorList();
            DtbSharedPreferences.getInstance().removeNonIABCustomConsent();
            currentVendorListString = null;
            currentConsentStatus = ConsentStatus.CONSENT_NOT_DEFINED;
            cmpFlavor = CMPFlavor.CMP_NOT_DEFINED;
            consentStringDirty = false;
            lastSeenNonIABEncodedConsentString = null;
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute resetNonIAB method", e);
        }
    }

    private static String getStringFromVendorList(List<Integer> list) {
        return list.toString();
    }

    private static List<Integer> getVendorListFromString(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() > 2) {
            for (String str2 : str.substring(1, str.length() - 1).split(StringUtils.COMMA)) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str2.trim())));
            }
        }
        return arrayList;
    }

    public static void setAdNetworkInfo(DTBAdNetworkInfo dTBAdNetworkInfo) {
        try {
            addCustomAttribute(DtbConstants.MEDIATION_NAME, dTBAdNetworkInfo.getAdNetworkName());
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute addCustomAttribute method", e);
        }
    }

    public static void addCustomAttribute(String str, String str2) {
        if (!isInitialized() && !ApsMigrationUtil.isApsInitInProgress()) {
            throw new IllegalStateException("mDTB was not initialized, please use AdRegistration.getInstance(...) before using other SDK calls");
        }
        try {
            if (customDictionary == null) {
                customDictionary = new HashMap();
            }
            customDictionary.put(str, str2);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute addCustomAttribute method", e);
        }
    }

    public static void removeCustomAttribute(String str) {
        if (!isInitialized() && !ApsMigrationUtil.isApsInitInProgress()) {
            throw new IllegalStateException("mDTB was not initialized, please use AdRegistration.getInstance(...) before using other SDK calls");
        }
        try {
            if (DtbCommonUtils.isNullOrEmpty(customDictionary)) {
                return;
            }
            customDictionary.remove(str);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute removeCustomAttribute method", e);
        }
    }

    public static Map<String, String> getCustomDictionary() {
        return customDictionary;
    }

    public static Map<String, DTBCacheData> getAdMobCacheData() {
        return adMobRequestIdMap;
    }

    public static DTBCacheData getAdMobCache(String str) {
        if (DtbCommonUtils.isNullOrEmpty(str) || adMobRequestIdMap == null) {
            return null;
        }
        removeExpiredAdMobCache();
        return adMobRequestIdMap.get(str);
    }

    public static void addAdMobCache(String str, DTBCacheData dTBCacheData) {
        if (adMobRequestIdMap == null) {
            adMobRequestIdMap = new HashMap();
        }
        removeExpiredAdMobCache();
        synchronized (adMobRequestIdMap) {
            adMobRequestIdMap.put(str, dTBCacheData);
        }
    }

    public static void removeAdMobCache(String str) {
        Map<String, DTBCacheData> map = adMobRequestIdMap;
        if (map != null) {
            synchronized (map) {
                adMobRequestIdMap.remove(str);
            }
        }
    }

    static void removeExpiredAdMobCache() {
        Map<String, DTBCacheData> map = adMobRequestIdMap;
        if (map != null) {
            synchronized (map) {
                long time = new Date().getTime();
                Iterator<Map.Entry<String, DTBCacheData>> it = adMobRequestIdMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (time - it.next().getValue().getResponseTimeStamp() > 29000) {
                        it.remove();
                    }
                }
            }
        }
    }
}
