package com.smaato.sdk.core;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;
import android.preference.PreferenceManager;
import android.util.Log;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.smaato.sdk.core.ad.GeoInfo;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.appconfigcheck.AppConfigChecker;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.framework.CoreModuleLoaderInterface;
import com.smaato.sdk.core.framework.SdkInitialisationObserver;
import com.smaato.sdk.core.framework.SimpleModuleInterface;
import com.smaato.sdk.core.gdpr.IabCmpV2DataStorage;
import com.smaato.sdk.core.gdpr.SomaGdprData;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.gdpr.SubjectToGdpr;
import com.smaato.sdk.core.gpp.SomaGppData;
import com.smaato.sdk.core.init.BaseDiRegistryUtils;
import com.smaato.sdk.core.init.BaseModuleValidationUtils;
import com.smaato.sdk.core.lgpd.SomaLgpdData;
import com.smaato.sdk.core.lgpd.SomaLgpdDataSource;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.ConnectionStatusWatcher;
import com.smaato.sdk.core.remoteconfig.global.GenericConfig;
import com.smaato.sdk.core.remoteconfig.global.GenericConfigProvider;
import com.smaato.sdk.core.util.AppMetaData;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.UUIDProvider;
import com.smaato.sdk.core.util.appbackground.AppBackgroundDetector;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.fi.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ServiceLoader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class SmaatoSdk {
    public static final String KEY_AUDIT_FLAGS = "audit";
    public static final String KEY_DEEPLINK = "deeplinking";
    public static final String KEY_FCID = "fcid";
    public static final String KEY_GDPR_APPLICABLE = "gdpr";
    public static final String KEY_GDPR_CONSENT = "gdpr_cs";
    public static final String KEY_GEO_LOCATION = "geo";
    public static final String KEY_GPP_CONSENT = "gpp";
    public static final String KEY_GPP_SID = "gpp_sid";
    public static final String KEY_LGPD_APPLICABLE = "lgpd";
    public static final String KEY_LGPD_CONSENT = "lgpdConsentEnabled";
    public static final String KEY_SDK_VERSION = "sdkVersion";
    private static volatile SmaatoInstance instance;

    public interface SmaatoSdkInitialisationListener {
        void onInitialisationFailure(String str);

        void onInitialisationSuccess();
    }

    private SmaatoSdk() {
    }

    public static void init(Application application, String str) {
        init(application, Config.builder().build(), str);
    }

    public static void init(Application application, Config config, String str) {
        ClassLoader classLoader = application.getClassLoader();
        init(application, ServiceLoader.load(SimpleModuleInterface.class, classLoader), ServiceLoader.load(CoreModuleLoaderInterface.class, classLoader), ServiceLoader.load(SdkInitialisationObserver.class, classLoader), str, config, true, null);
    }

    public static void init(Application application, Config config, String str, SmaatoSdkInitialisationListener smaatoSdkInitialisationListener) {
        ClassLoader classLoader = application.getClassLoader();
        init(application, ServiceLoader.load(SimpleModuleInterface.class, classLoader), ServiceLoader.load(CoreModuleLoaderInterface.class, classLoader), ServiceLoader.load(SdkInitialisationObserver.class, classLoader), str, config, true, smaatoSdkInitialisationListener);
    }

    static void init(Application application, Iterable<SimpleModuleInterface> iterable, Iterable<CoreModuleLoaderInterface> iterable2, Iterable<SdkInitialisationObserver> iterable3, String str, Config config, boolean z, SmaatoSdkInitialisationListener smaatoSdkInitialisationListener) {
        Objects.requireNonNull(application, "Parameter application cannot be null for SmaatoSdk::init");
        Objects.requireNonNull(str, "Parameter publisherId cannot be null for SmaatoSdk::init");
        if (str.isEmpty()) {
            if (smaatoSdkInitialisationListener != null) {
                smaatoSdkInitialisationListener.onInitialisationFailure("Parameter publisherId cannot be empty for SmaatoSdk::init");
                return;
            }
            throw new IllegalArgumentException("Parameter publisherId cannot be empty for SmaatoSdk::init");
        }
        if (instance == null) {
            synchronized (SmaatoSdk.class) {
                if (instance == null) {
                    if (config == null) {
                        config = Config.builder().build();
                        Log.w(LogDomain.CORE.name(), String.format("null config parameter is ignored, a default config is used instead (logLevel: %s, httpsOnly: %b)", config.getConsoleLogLevel(), Boolean.valueOf(config.isHttpsOnly())));
                    }
                    Config config2 = config;
                    List validModuleInterfaces = BaseModuleValidationUtils.getValidModuleInterfaces(getVersion(), iterable);
                    List<CoreModuleLoaderInterface> validModuleInterfaces2 = BaseModuleValidationUtils.getValidModuleInterfaces(getVersion(), iterable2);
                    ArrayList arrayList = new ArrayList();
                    for (CoreModuleLoaderInterface coreModuleLoaderInterface : validModuleInterfaces2) {
                        coreModuleLoaderInterface.setApplication(application);
                        arrayList.add(coreModuleLoaderInterface.getExpectedManifestEntries());
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(BaseDiRegistryUtils.getDiOfModules(validModuleInterfaces));
                    arrayList2.addAll(BaseDiRegistryUtils.getDiOfModules(validModuleInterfaces2));
                    SmaatoInstance smaatoInstance = new SmaatoInstance(application, config2, arrayList2, arrayList, str);
                    if (z && !isAppConfiguredProperly(smaatoInstance)) {
                        return;
                    }
                    try {
                        smaatoInstance.getDiConstructor().get(AppBackgroundDetector.class);
                        smaatoInstance.getDiConstructor().get(ConnectionStatusWatcher.class);
                    } catch (Exception e) {
                        Log.e("SmaatoSdk", "Error when instantiating AppBackgroundDetector and ConnectionStatusWatcher", e);
                    }
                    instance = smaatoInstance;
                }
            }
        }
        Iterator<SdkInitialisationObserver> it = iterable3.iterator();
        while (it.hasNext()) {
            it.next().onInitialised();
        }
        if (smaatoSdkInitialisationListener != null) {
            if (isSmaatoSdkInitialised()) {
                smaatoSdkInitialisationListener.onInitialisationSuccess();
            } else {
                smaatoSdkInitialisationListener.onInitialisationFailure("Smaato Sdk could not be initialised please check all params");
            }
        }
    }

    static void init(SmaatoInstance smaatoInstance) {
        instance = smaatoInstance;
    }

    private static boolean isAppConfiguredProperly(SmaatoInstance smaatoInstance) {
        DiConstructor diConstructor = smaatoInstance.getDiConstructor();
        boolean zIsAppConfiguredProperly = ((AppConfigChecker) diConstructor.get(AppConfigChecker.class)).check().isAppConfiguredProperly();
        if (!zIsAppConfiguredProperly) {
            ((Logger) diConstructor.get(Logger.class)).error(LogDomain.CORE, "Cannot initialize SmaatoSdk. Check specific reason(s) in the error/warning message(s) above.", new Object[0]);
        }
        return zIsAppConfiguredProperly;
    }

    public static String getVersion() {
        return "22.7.2";
    }

    public static String getKeywords() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return null;
        }
        return initializedSmaatoInstance.getKeywords();
    }

    public static void setKeywords(String str) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setKeywords(str);
        }
    }

    public static String getSearchQuery() {
        return (String) Objects.transformOrNull(getInitializedSmaatoInstance(), new Function() { // from class: com.smaato.sdk.core.SmaatoSdk$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Object apply(Object obj) {
                return ((SmaatoInstance) obj).getSearchQuery();
            }
        });
    }

    public static void setSearchQuery(final String str) {
        Objects.onNotNull(getInitializedSmaatoInstance(), new Consumer() { // from class: com.smaato.sdk.core.SmaatoSdk$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((SmaatoInstance) obj).setSearchQuery(str);
            }
        });
    }

    public static Gender getGender() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return null;
        }
        return initializedSmaatoInstance.getGender();
    }

    public static void setGender(Gender gender) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setGender(gender);
        }
    }

    public static Integer getAge() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return null;
        }
        return initializedSmaatoInstance.getAge();
    }

    public static void setAge(Integer num) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setAge(num);
        }
    }

    public static LatLng getLatLng() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return null;
        }
        return initializedSmaatoInstance.getLatLng();
    }

    public static void setLatLng(LatLng latLng) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return;
        }
        if (latLng != null && !latLng.isValid()) {
            Log.e(LogDomain.CORE.name(), "Provided location is invalid and will be discarded: " + latLng);
            initializedSmaatoInstance.setLatLng(null);
        } else {
            initializedSmaatoInstance.setLatLng(latLng);
        }
    }

    public static boolean isGPSEnabled() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        return initializedSmaatoInstance != null && initializedSmaatoInstance.isGPSEnabled();
    }

    public static void setGPSEnabled(boolean z) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setGPSEnabled(z);
        }
    }

    public static Boolean isLGPDConsentEnabled() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            return initializedSmaatoInstance.isLgpdConsentEnabled();
        }
        return null;
    }

    public static void setLgpdConsentEnabled(Boolean bool) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setLgpdConsentEnabled(bool);
        }
    }

    public static String getPublisherId() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return null;
        }
        return initializedSmaatoInstance.getPublisherId();
    }

    public static String getRegion() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return null;
        }
        return initializedSmaatoInstance.getRegion();
    }

    public static void setRegion(String str) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setRegion(str);
        }
    }

    public static String getZip() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return null;
        }
        return initializedSmaatoInstance.getZip();
    }

    public static void setZip(String str) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setZip(str);
        }
    }

    public static void setUnityVersion(String str) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setUnityVersion(str);
        }
    }

    public static String collectSignals(Context context) {
        SomaLgpdDataSource somaLgpdDataSource;
        SomaGdprDataSource somaGdprDataSource;
        SomaGppData somaGppData;
        GenericConfig configuration;
        IabCmpV2DataStorage iabCmpV2DataStorage = new IabCmpV2DataStorage(PreferenceManager.getDefaultSharedPreferences(context));
        SubjectToGdpr subjectToGdpr = iabCmpV2DataStorage.getSubjectToGdpr();
        String consentString = iabCmpV2DataStorage.getConsentString();
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            somaLgpdDataSource = (SomaLgpdDataSource) initializedSmaatoInstance.getDiConstructor().get(SomaLgpdDataSource.class);
            somaGdprDataSource = (SomaGdprDataSource) initializedSmaatoInstance.getDiConstructor().get(SomaGdprDataSource.class);
            somaGppData = (SomaGppData) initializedSmaatoInstance.getDiConstructor().get(SomaGppData.class);
            configuration = ((GenericConfigProvider) initializedSmaatoInstance.getDiConstructor().get(GenericConfigProvider.class)).getConfiguration();
        } else {
            somaLgpdDataSource = null;
            somaGdprDataSource = null;
            somaGppData = null;
            configuration = null;
        }
        SomaLgpdData somaLgpdData = somaLgpdDataSource != null ? somaLgpdDataSource.getSomaLgpdData() : null;
        SomaGdprData somaGdprData = somaGdprDataSource != null ? somaGdprDataSource.getSomaGdprData() : null;
        int iIntValue = configuration != null ? configuration.getConfigProperties().getSessionIdFrequencyMin().intValue() : 1440;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_DEEPLINK, 1);
            jSONObject.put("sdkVersion", getVersion());
            jSONObject.put(KEY_FCID, new UUIDProvider(context, Integer.valueOf(iIntValue)).getUuid());
            jSONObject.put("gdpr", getGdprApplicableValue(subjectToGdpr, somaGdprData));
            if (!consentString.isEmpty()) {
                jSONObject.put(KEY_GDPR_CONSENT, consentString);
            }
            if (somaGppData != null) {
                if (somaGppData.getGppString() != null && !somaGppData.getGppString().isEmpty()) {
                    jSONObject.put("gpp", somaGppData.getGppString());
                }
                if (somaGppData.getGppSid() != null && !somaGppData.getGppSid().isEmpty()) {
                    jSONObject.put("gpp_sid", somaGppData.getGppSid());
                }
            }
            jSONObject.put("lgpd", (somaLgpdData == null || !somaLgpdData.isLgpdEnabled()) ? 0 : 1);
            JSONObject geoLocationJson = getGeoLocationJson();
            JSONObject auditJsonObject = getAuditJsonObject();
            if (initializedSmaatoInstance == null || initializedSmaatoInstance.isLgpdConsentEnabled() == null) {
                jSONObject.put(KEY_LGPD_CONSENT, 1);
            } else {
                jSONObject.put(KEY_LGPD_CONSENT, initializedSmaatoInstance.isLgpdConsentEnabled().booleanValue() ? 1 : 0);
            }
            if (geoLocationJson != null) {
                jSONObject.put("geo", geoLocationJson);
            }
            jSONObject.put("playableSupported", 1);
            jSONObject.put(KEY_AUDIT_FLAGS, auditJsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(LogDomain.CORE.name(), "Collect signal Json Parsing exception", e);
        }
        return jSONObject.toString().replace("\"", "\\\"");
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.SmaatoSdk$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$gdpr$SubjectToGdpr;

        static {
            int[] iArr = new int[SubjectToGdpr.values().length];
            $SwitchMap$com$smaato$sdk$core$gdpr$SubjectToGdpr = iArr;
            try {
                iArr[SubjectToGdpr.CMP_GDPR_ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$gdpr$SubjectToGdpr[SubjectToGdpr.CMP_GDPR_UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static int getGdprApplicableValue(SubjectToGdpr subjectToGdpr, SomaGdprData somaGdprData) {
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$core$gdpr$SubjectToGdpr[subjectToGdpr.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 && somaGdprData != null) {
            return Boolean.TRUE.equals(somaGdprData.isGdprEnabled()) ? 1 : 0;
        }
        return 0;
    }

    public static String getLanguage() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return null;
        }
        return initializedSmaatoInstance.getLanguage();
    }

    public static void setLanguage(String str) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setLanguage(str);
        }
    }

    public static boolean getCoppa() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        return initializedSmaatoInstance != null && initializedSmaatoInstance.getCoppa();
    }

    public static void setCoppa(boolean z) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setCoppa(z);
        }
    }

    public static boolean isAgeRestrictedUser() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        return initializedSmaatoInstance != null && initializedSmaatoInstance.isAgeRestrictedUser();
    }

    public static void setAgeRestrictedUser(boolean z) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setAgeRestrictedUser(z);
        }
    }

    public static boolean isWatermarkEnabled() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        return initializedSmaatoInstance != null && initializedSmaatoInstance.isWatermarkEnabled();
    }

    public static void setWatermarkEnabled(boolean z) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setWatermarkEnabled(z);
        }
    }

    public static String getUsPrivacyString() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        return initializedSmaatoInstance == null ? "" : initializedSmaatoInstance.getUsPrivacyString();
    }

    public static boolean isCompanionAdSkippable() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        return initializedSmaatoInstance != null && initializedSmaatoInstance.isCompanionAdSkippable();
    }

    public static void setIsCompanionAdSkippable(boolean z) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance != null) {
            initializedSmaatoInstance.setIsCompanionAdSkippable(z);
        }
    }

    public static AdContentRating getAdContentRating() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return null;
        }
        return initializedSmaatoInstance.getAdContentRating();
    }

    public static String getUnityVersion() {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        return initializedSmaatoInstance == null ? "" : initializedSmaatoInstance.getUnityVersion();
    }

    public static ExtensionConfiguration getExtensionConfiguration(Class<? extends ExtensionConfiguration> cls) {
        SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
        if (initializedSmaatoInstance == null) {
            return null;
        }
        for (ExtensionConfiguration extensionConfiguration : initializedSmaatoInstance.getExtensionConfigurations()) {
            if (cls.isInstance(extensionConfiguration)) {
                return extensionConfiguration;
            }
        }
        return null;
    }

    public static boolean isSmaatoSdkInitialised() {
        return instance != null;
    }

    private static SmaatoInstance getInitializedSmaatoInstance() {
        SmaatoInstance smaatoInstance = instance;
        if (smaatoInstance != null) {
            return smaatoInstance;
        }
        Log.e(LogDomain.CORE.name(), "SmaatoSdk.init() should be called first.");
        return null;
    }

    private static JSONObject getGeoLocationJson() {
        GeoInfo geoInfo;
        try {
            SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
            if (initializedSmaatoInstance == null || (geoInfo = ((RequestInfoProvider) initializedSmaatoInstance.getDiConstructor().get(RequestInfoProvider.class)).getGeoInfo(null)) == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", Integer.parseInt(geoInfo.getGeoType().toString()));
            Locale locale = Locale.ENGLISH;
            jSONObject.put("lat", String.format(locale, "%.2f", Double.valueOf(geoInfo.getLatLng().getLatitude())));
            jSONObject.put(POBConstants.KEY_LONGITUDE, String.format(locale, "%.2f", Double.valueOf(geoInfo.getLatLng().getLongitude())));
            String region = getRegion();
            if (region != null && !region.isEmpty()) {
                jSONObject.put("region", region);
            }
            String zip = getZip();
            if (zip != null && !zip.isEmpty()) {
                jSONObject.put(POBCommonConstants.ZIP_PARAM, zip);
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject getAuditJsonObject() {
        LocationManager locationManager;
        AppMetaData appMetaData;
        JSONObject jSONObject = new JSONObject();
        try {
            SmaatoInstance initializedSmaatoInstance = getInitializedSmaatoInstance();
            if (initializedSmaatoInstance != null) {
                locationManager = (LocationManager) initializedSmaatoInstance.getDiConstructor().get(LocationManager.class);
                appMetaData = (AppMetaData) initializedSmaatoInstance.getDiConstructor().get(AppMetaData.class);
            } else {
                locationManager = null;
                appMetaData = null;
            }
            Config configBuild = Config.builder().build();
            jSONObject.put("gpsEnabled", isGPSEnabled() ? 1 : 0);
            jSONObject.put("requireCoppaCompliantAds", getCoppa() ? 1 : 0);
            int i = 0;
            jSONObject.put("locationServicesEnabled", locationManager != null ? 1 : 0);
            if (appMetaData != null && appMetaData.isPermissionGranted("android.permission.ACCESS_COARSE_LOCATION")) {
                i = 1;
            }
            jSONObject.put("userAuthorisedLocation", i);
            jSONObject.put("httpsOnly", configBuild.isHttpsOnly() ? 1 : 0);
            jSONObject.put("sessionTrackingEnabled", !configBuild.sessionTrackingDisabled() ? 1 : 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static void reset() {
        instance = null;
    }
}
