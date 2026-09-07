package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import com.amazon.aps.ads.ApsAdFormatUtils;
import com.amazon.aps.ads.ApsAdRequest;
import com.amazon.aps.ads.model.ApsAdFormat;
import com.amazon.aps.ads.privacy.ApsPrivacyManager;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.aps.shared.metrics.ApsMetricsPerfEventModelBuilder;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.aps.shared.metrics.model.ApsMetricsPerfAaxBidEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsResult;
import com.json.b9;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidEnvironmentProperties;
import io.bidmachine.IABSharedPreference;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes7.dex */
public class DTBAdRequest implements DTBAdLoader {
    private static final String AAX_VIDEO_INVENTORY_TYPE = "inventoryType";
    private static final String AAX_VIDEO_SKIP_AFTER = "skipAfter";
    private static final int DEFAULT_RERESH_DURATION = 60;
    private static final String LOG_TAG = "DTBAdRequest";
    private static final int MIN_REFRESH_DURATION = 20;
    private static final String PJ_KEY = "pj";
    private static final long WEEK = 604800000;
    static JSONArray mRaidArray;
    private static JSONArray mRaidCustomArray;
    private static boolean mRaidDefined;
    private String aaxHostname;
    private volatile AdError adError;
    private DTBAdResponse adResponse;
    private final List<DTBAdSize> adSizes;
    private DTBAdCallback callback;
    private Context context;
    private String correlationId;
    private final Map<String, String> customTargets;
    private boolean isAutoRefresh;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private final Runnable mRefreshRunnable;
    private int refreshDuration;
    private boolean refreshFlag;
    private boolean requestHasBeenUsed;
    private final Map<String, String> sizeSlotUUIDMap;
    private String slotGroup;
    private long startLoadAdTime;
    private boolean submitMetrics;
    private static final String[] MRAID_VALID_VERSIONS = {"1.0", "2.0", MraidEnvironmentProperties.VERSION};
    private static Integer reqCount = 0;

    protected void onRequestFormed(HashMap<String, Object> map) {
    }

    private void increaseReqCount() {
        synchronized (reqCount) {
            reqCount = Integer.valueOf(reqCount.intValue() + 1);
        }
    }

    public DTBAdRequest(Context context) {
        this.adSizes = new ArrayList();
        this.customTargets = new HashMap();
        this.sizeSlotUUIDMap = new HashMap();
        this.adError = null;
        this.requestHasBeenUsed = false;
        this.submitMetrics = true;
        this.isAutoRefresh = false;
        this.refreshFlag = false;
        this.refreshDuration = 0;
        this.mRefreshRunnable = new Runnable() { // from class: com.amazon.device.ads.DTBAdRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4412lambda$new$0$comamazondeviceadsDTBAdRequest();
            }
        };
        this.slotGroup = null;
        this.correlationId = UUID.randomUUID().toString() + UUID.randomUUID().toString();
        if (context == null) {
            throw new IllegalArgumentException("unable to initialize ad request with null app context");
        }
        try {
            if (!AdRegistration.isInitialized()) {
                DtbLog.warn("mDTB was not initialized, please use AdRegistration.getInstance(...) before using other SDK calls");
                return;
            }
            if (AdRegistration.getContext() == null) {
                AdRegistration.setContext(context);
            }
            this.context = context;
            if (mRaidDefined) {
                return;
            }
            defineMraid();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to initialize DTBAdRequest class with context argument", e);
        }
    }

    public DTBAdRequest() {
        this.adSizes = new ArrayList();
        this.customTargets = new HashMap();
        this.sizeSlotUUIDMap = new HashMap();
        this.adError = null;
        this.requestHasBeenUsed = false;
        this.submitMetrics = true;
        this.isAutoRefresh = false;
        this.refreshFlag = false;
        this.refreshDuration = 0;
        this.mRefreshRunnable = new Runnable() { // from class: com.amazon.device.ads.DTBAdRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4412lambda$new$0$comamazondeviceadsDTBAdRequest();
            }
        };
        this.slotGroup = null;
        this.correlationId = UUID.randomUUID().toString() + UUID.randomUUID().toString();
        try {
            if (!AdRegistration.isInitialized()) {
                DtbLog.warn("mDTB was not initialized, please use AdRegistration.getInstance(...) before using other SDK calls");
                return;
            }
            if (this.context == null) {
                this.context = AdRegistration.getContext();
            }
            if (mRaidDefined) {
                return;
            }
            defineMraid();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to initialize DTBAdRequest class", e);
        }
    }

    public DTBAdRequest(DTBAdRequest dTBAdRequest) {
        ArrayList arrayList = new ArrayList();
        this.adSizes = arrayList;
        HashMap map = new HashMap();
        this.customTargets = map;
        HashMap map2 = new HashMap();
        this.sizeSlotUUIDMap = map2;
        this.adError = null;
        this.requestHasBeenUsed = false;
        this.submitMetrics = true;
        this.isAutoRefresh = false;
        this.refreshFlag = false;
        this.refreshDuration = 0;
        this.mRefreshRunnable = new Runnable() { // from class: com.amazon.device.ads.DTBAdRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4412lambda$new$0$comamazondeviceadsDTBAdRequest();
            }
        };
        this.slotGroup = null;
        this.correlationId = UUID.randomUUID().toString() + UUID.randomUUID().toString();
        arrayList.addAll(dTBAdRequest.adSizes);
        map.putAll(dTBAdRequest.customTargets);
        map2.putAll(dTBAdRequest.sizeSlotUUIDMap);
        this.adResponse = dTBAdRequest.adResponse;
        this.callback = dTBAdRequest.callback;
        this.context = dTBAdRequest.context;
        this.adError = dTBAdRequest.adError;
        this.requestHasBeenUsed = dTBAdRequest.requestHasBeenUsed;
        this.submitMetrics = dTBAdRequest.submitMetrics;
        this.isAutoRefresh = dTBAdRequest.isAutoRefresh;
        this.refreshFlag = dTBAdRequest.refreshFlag;
        this.refreshDuration = dTBAdRequest.refreshDuration;
        this.mHandler = dTBAdRequest.mHandler;
        this.mHandlerThread = dTBAdRequest.mHandlerThread;
        this.slotGroup = dTBAdRequest.slotGroup;
    }

    public DTBAdRequest(DTBAdRequest dTBAdRequest, String str) {
        this.adSizes = new ArrayList();
        this.customTargets = new HashMap();
        this.sizeSlotUUIDMap = new HashMap();
        this.adError = null;
        this.requestHasBeenUsed = false;
        this.submitMetrics = true;
        this.isAutoRefresh = false;
        this.refreshFlag = false;
        this.refreshDuration = 0;
        this.mRefreshRunnable = new Runnable() { // from class: com.amazon.device.ads.DTBAdRequest$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4412lambda$new$0$comamazondeviceadsDTBAdRequest();
            }
        };
        this.slotGroup = null;
        this.correlationId = UUID.randomUUID().toString() + UUID.randomUUID().toString();
        setAdSizes(dTBAdRequest.getAdSizes());
        setSlotGroup(dTBAdRequest.getSlotGroupName());
        setCustomTargets(dTBAdRequest.getCustomTargets());
    }

    static void resetMraid() {
        mRaidArray = null;
        mRaidDefined = false;
    }

    static void setMRAIDSupportedVersions(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            mRaidCustomArray = new JSONArray();
            List listAsList = Arrays.asList(MRAID_VALID_VERSIONS);
            for (String str : strArr) {
                if (str == null) {
                    DtbLog.error(LOG_TAG, "null custom version supplied");
                } else {
                    if (!listAsList.contains(str)) {
                        DtbLog.warn(LOG_TAG, "custom version \"" + str + "\" is not valid");
                    }
                    mRaidCustomArray.put(str);
                }
            }
        }
        resetMraid();
    }

    protected String[] dfpCandidateList() {
        return new String[]{"com.google.android.gms.common.GoogleApiAvailability", "com.google.android.gms.common.GoogleApiAvailabilityLight", "com.google.android.gms.common.GooglePlayServicesUtil", "com.google.android.gms.common.GooglePlayServicesUtilLight"};
    }

    protected void defineMraid() {
        DtbCommonUtils.APIVersion aPIVersion = new DtbCommonUtils.APIVersion();
        Integer integerFieldValue = null;
        for (String str : dfpCandidateList()) {
            if (integerFieldValue != null) {
                break;
            }
            integerFieldValue = DtbCommonUtils.getIntegerFieldValue(str, "GOOGLE_PLAY_SERVICES_VERSION_CODE");
        }
        if (integerFieldValue == null) {
            for (char c = 'a'; c <= 'z' && (integerFieldValue = DtbCommonUtils.getIntegerFieldValue("com.google.android.gms.common.zz" + c, "GOOGLE_PLAY_SERVICES_VERSION_CODE")) == null; c = (char) (c + 1)) {
            }
        }
        if (integerFieldValue != null) {
            int iIntValue = integerFieldValue.intValue() / 1000;
            aPIVersion.minorVersion = (iIntValue % 1000) / 100;
            aPIVersion.majorVersion = iIntValue / 1000;
            DtbLog.debug("Google DFP major version:" + aPIVersion.majorVersion + "minor version:" + aPIVersion.minorVersion);
        } else {
            DtbLog.debug("Not able to identify Google DFP version");
        }
        mRaidDefined = true;
        int i = AnonymousClass1.$SwitchMap$com$amazon$device$ads$MRAIDPolicy[AdRegistration.getMRAIDPolicy().ordinal()];
        if (i == 1) {
            if (isServerless() || integerFieldValue == null) {
                return;
            }
            useDFP(aPIVersion);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            mRaidArray = mRaidCustomArray;
        } else if (integerFieldValue != null) {
            useDFP(aPIVersion);
        }
    }

    /* JADX INFO: renamed from: com.amazon.device.ads.DTBAdRequest$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$ads$MRAIDPolicy;

        static {
            int[] iArr = new int[MRAIDPolicy.values().length];
            $SwitchMap$com$amazon$device$ads$MRAIDPolicy = iArr;
            try {
                iArr[MRAIDPolicy.AUTO_DETECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$MRAIDPolicy[MRAIDPolicy.DFP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$MRAIDPolicy[MRAIDPolicy.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$MRAIDPolicy[MRAIDPolicy.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected boolean isServerless() {
        for (String str : AdRegistration.getServerlessMarkers()) {
            try {
                Class.forName(str);
                JSONArray jSONArray = new JSONArray();
                mRaidArray = jSONArray;
                jSONArray.put("1.0");
                mRaidArray.put("2.0");
                mRaidArray.put(MraidEnvironmentProperties.VERSION);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void useDFP(DtbCommonUtils.APIVersion aPIVersion) {
        if (aPIVersion.majorVersion > 0) {
            JSONArray jSONArray = new JSONArray();
            mRaidArray = jSONArray;
            jSONArray.put("1.0");
            if ((aPIVersion.majorVersion == 7 && aPIVersion.minorVersion >= 8) || aPIVersion.majorVersion > 7) {
                mRaidArray.put("2.0");
            }
            if (aPIVersion.majorVersion >= 15) {
                mRaidArray.put(MraidEnvironmentProperties.VERSION);
            }
        }
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public void setSizes(DTBAdSize... dTBAdSizeArr) throws IllegalArgumentException {
        this.adSizes.clear();
        DtbLog.info(LOG_TAG, "Setting " + dTBAdSizeArr.length + " AdSize(s) to the ad request.");
        for (DTBAdSize dTBAdSize : dTBAdSizeArr) {
            if (dTBAdSize != null) {
                this.adSizes.add(dTBAdSize);
            } else {
                throw new IllegalArgumentException("DTBAdSize cannot be null.");
            }
        }
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public void putCustomTarget(String str, String str2) {
        try {
            this.customTargets.put(str, str2);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute putCustomTarget method", e);
        }
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public void setSlotGroup(String str) {
        this.slotGroup = str;
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public String getSlotGroupName() {
        return this.slotGroup;
    }

    void setAdSizes(List<DTBAdSize> list) {
        this.adSizes.clear();
        for (DTBAdSize dTBAdSize : list) {
            if (dTBAdSize != null) {
                this.adSizes.add(dTBAdSize);
            }
        }
    }

    public List<DTBAdSize> getAdSizes() {
        return this.adSizes;
    }

    Map<String, String> getCustomTargets() {
        return this.customTargets;
    }

    void setCustomTargets(Map<String, String> map) {
        this.customTargets.clear();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.customTargets.put(entry.getKey(), entry.getValue());
        }
    }

    public void setRefreshFlag(boolean z) {
        this.refreshFlag = z;
    }

    void recycle() {
        this.requestHasBeenUsed = false;
    }

    private void loadAd(DTBAdCallback dTBAdCallback, String str) throws DTBLoadException {
        AdRegistration.SlotGroup slotGroup = AdRegistration.getSlotGroup(this.slotGroup);
        if (slotGroup != null) {
            DTBAdSize sizeBySlotUUID = slotGroup.getSizeBySlotUUID(str);
            if (sizeBySlotUUID != null) {
                setSizes(sizeBySlotUUID);
                loadAd(dTBAdCallback);
                return;
            }
            throw new DTBLoadException("Slot group does not contain requested slotUUID");
        }
        throw new DTBLoadException("Slot group is not found");
    }

    private void loadAd(DTBAdCallback dTBAdCallback, int i, int i2) throws DTBLoadException {
        loadAd(dTBAdCallback, i, i2, AdType.DISPLAY);
    }

    private void loadAd(DTBAdCallback dTBAdCallback, int i, int i2, AdType adType) throws DTBLoadException {
        AdRegistration.SlotGroup slotGroup = AdRegistration.getSlotGroup(this.slotGroup);
        if (slotGroup != null) {
            DTBAdSize sizeByWidthHeightType = slotGroup.getSizeByWidthHeightType(i, i2, adType);
            if (sizeByWidthHeightType != null) {
                setSizes(sizeByWidthHeightType);
                loadAd(dTBAdCallback);
                return;
            }
            throw new DTBLoadException("Slot group does not contain required size of a given type");
        }
        throw new DTBLoadException("Slot group is not found");
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public void loadSmartBanner(DTBAdCallback dTBAdCallback) throws DTBLoadException {
        int i;
        int i2;
        try {
            this.startLoadAdTime = System.currentTimeMillis();
            if (DtbDeviceDataRetriever.isTablet()) {
                i = 728;
                i2 = 90;
            } else {
                i = 320;
                i2 = 50;
            }
            loadAd(dTBAdCallback, i, i2);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute loadSmartBanner method", e);
        }
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public void loadAd(DTBAdCallback dTBAdCallback) {
        try {
            this.startLoadAdTime = System.currentTimeMillis();
            this.callback = dTBAdCallback;
            if (this.adSizes.size() <= 0) {
                throw new IllegalArgumentException("Please set at least one ad size in the request.");
            }
            if (this.requestHasBeenUsed) {
                DtbLog.error(LOG_TAG, "This ad request object is already used for loading an ad. Please create a new instance to load the Ad.");
                return;
            }
            this.requestHasBeenUsed = true;
            if (DTBMetricsConfiguration.getInstance().isFeatureEnabled("clear_aaxHostName")) {
                removeAaxHostNameFromSharedPreferences();
            }
            DtbDeviceRegistration.verifyRegistration();
            for (DTBAdSize dTBAdSize : this.adSizes) {
                this.sizeSlotUUIDMap.put(dTBAdSize.getWidth() + VastAttributes.HORIZONTAL_POSITION + dTBAdSize.getHeight(), dTBAdSize.getSlotUUID());
            }
            try {
                if (this.mHandlerThread == null && this.isAutoRefresh && this.refreshDuration > 0) {
                    HandlerThread handlerThread = new HandlerThread("DtbHandlerThread");
                    this.mHandlerThread = handlerThread;
                    handlerThread.start();
                    this.mHandler = new Handler(this.mHandlerThread.getLooper());
                }
                internalLoadAd();
                increaseReqCount();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("seqCount", String.valueOf(reqCount));
                jSONObject.put("isGdprApplicable", ApsPrivacyManager.INSTANCE.isGdprConsentRequired());
                ApsMetrics.customEvent("bidCall", String.valueOf(DtbSharedPreferences.getInstance().isValidIdfaAvailable()), jSONObject);
            } catch (Exception e) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Unknown exception occured in DTB ad call.", e);
            }
        } catch (RuntimeException e2) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute loadAd method", e2);
        }
    }

    private void removeAaxHostNameFromSharedPreferences() {
        try {
            if (DtbConstants.REMOVE_AAX_END_POINT_FROM_SHARED_PREF.contains(DtbSharedPreferences.getInstance().getAaxHostname())) {
                DtbSharedPreferences.getInstance().removeAAXHostName();
            }
        } catch (Exception e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Exception while removing HostName from sharedPreference", e);
        }
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public void setAutoRefresh() {
        try {
            this.isAutoRefresh = true;
            setRefreshDuration(60);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute setAutoRefresh method", e);
        }
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public void setAutoRefresh(int i) {
        try {
            this.isAutoRefresh = true;
            setRefreshDuration(i);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute setAutoRefresh method with seconds argument", e);
        }
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public void pauseAutoRefresh() {
        this.isAutoRefresh = false;
        this.refreshFlag = false;
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public void resumeAutoRefresh() {
        try {
            setAutoRefresh(this.refreshDuration);
            m4412lambda$new$0$comamazondeviceadsDTBAdRequest();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute resumeAutoRefresh method", e);
        }
    }

    public int getRefreshDuration() {
        return this.refreshDuration;
    }

    private void setRefreshDuration(int i) {
        if (i < 20) {
            DtbLog.warn(LOG_TAG, "Defaulting auto refresh duration to 60 seconds.");
            this.refreshDuration = 60;
        } else {
            this.refreshDuration = i;
        }
    }

    @Override // com.amazon.device.ads.DTBAdLoader
    public void stop() {
        try {
            stopAutoRefresh();
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
                DtbLog.debug("Stopping DTB auto refresh");
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute stop method", e);
        }
    }

    private void internalLoadAd() {
        DtbLog.debug("Loading DTB ad.");
        DtbThreadService.getInstance().execute(new Runnable() { // from class: com.amazon.device.ads.DTBAdRequest$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4411lambda$internalLoadAd$1$comamazondeviceadsDTBAdRequest();
            }
        });
        DtbLog.debug("Dispatched the loadAd task on a background thread.");
    }

    /* JADX INFO: renamed from: lambda$internalLoadAd$1$com-amazon-device-ads-DTBAdRequest, reason: not valid java name */
    /* synthetic */ void m4411lambda$internalLoadAd$1$comamazondeviceadsDTBAdRequest() {
        DtbLog.info("Fetching DTB ad.");
        try {
            loadAdRequest();
            DtbLog.debug("DTB Ad call is complete");
        } catch (Exception unused) {
            DtbLog.error(LOG_TAG, "Unknown exception in DTB ad call process.");
        }
    }

    private void stopAutoRefresh() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.refreshFlag = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: refreshAd, reason: merged with bridge method [inline-methods] */
    public void m4412lambda$new$0$comamazondeviceadsDTBAdRequest() {
        Activity activity;
        if (!this.isAutoRefresh || this.refreshDuration <= 0) {
            return;
        }
        Context context = this.context;
        if (context instanceof Activity) {
            activity = (Activity) context;
            if (activity.isFinishing() || DtbCommonUtils.isActivityDestroyed(activity)) {
                DtbLog.info("Stopping DTB auto refresh...");
                stop();
                return;
            }
        } else {
            activity = null;
        }
        this.refreshFlag = true;
        if (activity != null && !activity.hasWindowFocus()) {
            DtbLog.debug("Skipping DTB auto refresh...activity not in focus");
            scheduleAdRefreshIfEnabled();
        } else {
            internalLoadAd();
        }
    }

    private void scheduleAdRefreshIfEnabled() {
        if (!this.isAutoRefresh || this.refreshDuration <= 0) {
            return;
        }
        stopAutoRefresh();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(this.mRefreshRunnable, ((long) this.refreshDuration) * 1000);
        }
    }

    private void addPrivacyParameters(Map<String, Object> map) {
        Context context = this.context;
        if (context != null) {
            addGDPRParametersFromPreferences(map, PreferenceManager.getDefaultSharedPreferences(context));
            HashMap<String, Object> mapAddGPPParametersFromPreferences = DtbCommonUtils.addGPPParametersFromPreferences(PreferenceManager.getDefaultSharedPreferences(this.context));
            if (!DtbCommonUtils.isNullOrEmpty(mapAddGPPParametersFromPreferences)) {
                try {
                    map.put(POBConstants.KEY_REGS, DtbCommonUtils.getParamsAsJson(mapAddGPPParametersFromPreferences));
                } catch (JSONException e) {
                    APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to get global privacy platform params", e);
                }
            }
            addDsaTransparencyParams(map);
        }
    }

    protected void addDsaTransparencyParams(Map<String, Object> map) {
        try {
            JSONObject jSONObject = map.containsKey(POBConstants.KEY_REGS) ? (JSONObject) map.get(POBConstants.KEY_REGS) : new JSONObject();
            if (!DtbCommonUtils.isNullOrEmpty(AdRegistration.getDsaTransparencyData())) {
                jSONObject.put(POBConstants.KEY_DSA, AdRegistration.getDsaTransparencyData());
            }
            if (DtbCommonUtils.isNullOrEmpty(jSONObject)) {
                return;
            }
            map.put(POBConstants.KEY_REGS, jSONObject);
        } catch (JSONException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "API Failure : Failed to add DSA Transparency params", e);
        }
    }

    protected void addGDPRParametersFromPreferences(Map<String, Object> map, SharedPreferences sharedPreferences) {
        JSONObject jSONObject = null;
        String string = sharedPreferences.getString(IABSharedPreference.IAB_SUBJECT_TO_GDPR, null);
        Object obj = sharedPreferences.contains("IABTCF_gdprApplies") ? sharedPreferences.getAll().get("IABTCF_gdprApplies") : null;
        String string2 = sharedPreferences.getString(IABSharedPreference.IAB_CONSENT_STRING, null);
        String string3 = sharedPreferences.getString("IABTCF_TCString", null);
        String encodedNonIABString = AdRegistration.getEncodedNonIABString();
        try {
            if (string3 != null || string2 != null) {
                jSONObject = new JSONObject();
                if (string3 != null) {
                    jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, string3);
                } else if (string2 != null) {
                    jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, string2);
                }
            } else if (encodedNonIABString != null) {
                jSONObject = new JSONObject();
                jSONObject.put(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, encodedNonIABString);
            }
            if (string != null || obj != null) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (obj != null) {
                    try {
                        if ((obj instanceof Integer) && (((Integer) obj).intValue() == 1 || ((Integer) obj).intValue() == 0)) {
                            jSONObject.put("e", obj);
                        } else if (((obj instanceof String) && ((String) obj).equals("1")) || ((String) obj).equals("0")) {
                            jSONObject.put("e", obj);
                        } else {
                            DtbLog.info("IABTCF_gdprApplies should be a 1 or 0 as per IAB guideline");
                        }
                    } catch (ClassCastException unused) {
                        DtbLog.info("IABTCF_gdprApplies should be a number as per IAB guideline");
                    }
                } else if (string != null) {
                    jSONObject.put("e", string);
                }
            }
            if (jSONObject == null || jSONObject.length() == 0) {
                return;
            }
            map.put("gdpr", jSONObject);
        } catch (JSONException unused2) {
            DtbLog.error("INVALID JSON formed for GDPR clause");
        }
    }

    protected void addLegoFlag(Map<String, Object> map, boolean z) {
        JSONObject jSONObject;
        if ((this instanceof ApsAdRequest) && z) {
            try {
                if (map.containsKey(PJ_KEY)) {
                    jSONObject = (JSONObject) map.get(PJ_KEY);
                } else {
                    jSONObject = new JSONObject();
                }
                jSONObject.put("api", ApsMetricsDataMap.APSMETRICS_FIELD_APS);
                map.put(PJ_KEY, jSONObject);
            } catch (RuntimeException | JSONException e) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error setting the isLego flag in ad request", e);
            }
        }
    }

    private String getAdSize(JSONObject jSONObject, List<DTBAdSize> list) {
        try {
            if (jSONObject.has("sz") && !DtbCommonUtils.isNullOrEmpty(jSONObject.getString("sz"))) {
                return jSONObject.getString("sz");
            }
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Invalid sz params from AAX Bid Response." + String.format("BidId = %s", this.adResponse.getBidId()));
            if (DTBMetricsConfiguration.getInstance().isFeatureEnabled(DTBMetricsConfiguration.FEATURE_ENABLE_DEFAULT_AD_SIZE)) {
                Iterator<DTBAdSize> it = list.iterator();
                if (it.hasNext()) {
                    DTBAdSize next = it.next();
                    if (next.isInterstitialAd()) {
                        return "9999x9999";
                    }
                    return next.getWidth() + VastAttributes.HORIZONTAL_POSITION + next.getHeight();
                }
                return "0x0";
            }
            return "0x0";
        } catch (Exception e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Failed to get ad size passed from bid Request", e);
            return "0x0";
        }
    }

    /* JADX WARN: Code duplicated, block: B:129:0x033e A[Catch: Exception -> 0x036e, JSONException -> 0x0370, TryCatch #15 {JSONException -> 0x0370, Exception -> 0x036e, blocks: (B:120:0x02eb, B:122:0x0305, B:124:0x030d, B:126:0x0319, B:128:0x0338, B:127:0x0329, B:129:0x033e, B:131:0x0355, B:132:0x036d), top: B:163:0x014f }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0355 A[Catch: Exception -> 0x036e, JSONException -> 0x0370, TryCatch #15 {JSONException -> 0x0370, Exception -> 0x036e, blocks: (B:120:0x02eb, B:122:0x0305, B:124:0x030d, B:126:0x0319, B:128:0x0338, B:127:0x0329, B:129:0x033e, B:131:0x0355, B:132:0x036d), top: B:163:0x014f }] */
    /* JADX WARN: Code duplicated, block: B:154:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:157:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0151 A[Catch: Exception -> 0x0372, JSONException -> 0x0377, TRY_LEAVE, TryCatch #11 {JSONException -> 0x0377, Exception -> 0x0372, blocks: (B:25:0x00ca, B:34:0x0111, B:36:0x0151, B:40:0x017f, B:42:0x0187, B:45:0x0194, B:47:0x019a, B:49:0x01a6, B:51:0x01ac, B:53:0x01cb, B:54:0x01cf, B:104:0x02bb), top: B:170:0x00ca }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0167 A[Catch: Exception -> 0x0109, JSONException -> 0x010d, TRY_ENTER, TRY_LEAVE, TryCatch #13 {JSONException -> 0x010d, Exception -> 0x0109, blocks: (B:28:0x00fd, B:38:0x0167, B:44:0x018d, B:56:0x01d5, B:80:0x023b, B:88:0x0268, B:92:0x027f, B:95:0x028e, B:102:0x02a5, B:99:0x029b), top: B:166:0x00fd }] */
    /* JADX WARN: Code duplicated, block: B:79:0x023a  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private void loadAdRequest() {
        boolean z;
        JSONObject jSONObject;
        boolean z2;
        DtbHttpClient dtbHttpClient;
        JSONObject jSONObject2;
        boolean z3;
        boolean z4;
        String str = AAX_VIDEO_INVENTORY_TYPE;
        if (this.isAutoRefresh) {
            Iterator<DTBAdSize> it = this.adSizes.iterator();
            while (true) {
                if (it.hasNext()) {
                    DTBAdSize next = it.next();
                    Iterator<DTBAdSize> it2 = it;
                    if (next.getDTBAdType() == AdType.INTERSTITIAL || next.getDTBAdType() == AdType.VIDEO) {
                        this.isAutoRefresh = false;
                        this.refreshFlag = false;
                        DtbLog.warn("Autorefresh could not be used for interstitial or video");
                    } else {
                        it = it2;
                    }
                }
            }
        }
        DtbMetrics dtbMetrics = new DtbMetrics();
        str = "bidResponse";
        String str2 = "crid";
        HashMap<String, Object> params = new DtbAdRequestParamsBuilder().getParams(this.context, this.adSizes, this.customTargets, this.refreshFlag);
        addPrivacyParameters(params);
        addMraidParameters(params);
        addLegoFlag(params, DTBMetricsConfiguration.getInstance().isFeatureEnabled(DTBMetricsConfiguration.FEATURE_ENABLE_APS_BID_FLAG));
        this.aaxHostname = DtbDebugProperties.getAaxHostName(DtbSharedPreferences.getInstance().getAaxHostname());
        Iterator<DTBAdSize> it3 = this.adSizes.iterator();
        while (it3.hasNext()) {
            if (AdType.VIDEO.equals(it3.next().getDTBAdType())) {
                String aaxVideoHostName = DtbSharedPreferences.getInstance().getAaxVideoHostName();
                if (!DtbCommonUtils.isNullOrEmpty(aaxVideoHostName)) {
                    this.aaxHostname = DtbDebugProperties.getAaxVideoHostName(aaxVideoHostName);
                }
            }
        }
        JSONObject jSONObject3 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("idfa", DtbSharedPreferences.getInstance().isValidIdfaAvailable());
                StringBuilder sb = new StringBuilder(this.aaxHostname + "/e/msdk/ads");
                if (DtbDebugProperties.getEncodedUrlParams().length() > 0) {
                    try {
                        sb.append('?').append(DtbDebugProperties.getEncodedUrlParams());
                        dtbHttpClient = new DtbHttpClient(sb.toString());
                        dtbHttpClient.setUseSecure(DtbDebugProperties.getIsSecure(true));
                        dtbHttpClient.addHeader("Accept", "application/json");
                        dtbHttpClient.addHeader("Content-Type", "application/json");
                        dtbHttpClient.setParams(params);
                        onRequestFormed(params);
                        dtbMetrics.startTimer(DtbMetric.AAX_BID_TIME);
                        dtbHttpClient.executePOST(DtbSharedPreferences.getInstance().getBidTimeout());
                        DtbLog.debug("Ad call completed.");
                        try {
                            if (!DtbCommonUtils.isNullOrEmpty(dtbHttpClient.getResponse())) {
                                DtbLog.debug("No response from Ad call.");
                                this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Response is null.");
                                throw new Exception("Response is null");
                            }
                            dtbMetrics.stopTimer(DtbMetric.AAX_BID_TIME);
                            jSONObject2 = (JSONObject) new JSONTokener(dtbHttpClient.getResponse()).nextValue();
                            if (jSONObject2 != null) {
                                DtbLog.debug("Bid Response:" + jSONObject2);
                            }
                            if (jSONObject2 == null && dtbHttpClient.getResponseCode() == 200) {
                                if (jSONObject2.has("instrPixelURL")) {
                                    dtbMetrics.setInstPxlUrl(jSONObject2.getString("instrPixelURL"));
                                }
                                if (jSONObject2.has("errorCode") && jSONObject2.getString("errorCode").equals("200") && jSONObject2.has("ads")) {
                                    JSONObject jSONObject4 = jSONObject2.getJSONObject("ads");
                                    DTBAdResponse dTBAdResponse = new DTBAdResponse();
                                    this.adResponse = dTBAdResponse;
                                    dTBAdResponse.setAdLoader(DtbCommonUtils.createAutoRefreshAdLoader(this));
                                    this.adResponse.setHostName(this.aaxHostname);
                                    if (jSONObject4.length() > 0) {
                                        Iterator<String> itKeys = jSONObject4.keys();
                                        while (itKeys.hasNext()) {
                                            String next2 = itKeys.next();
                                            JSONObject jSONObject5 = jSONObject4.getJSONObject(next2);
                                            this.adResponse.setBidId(jSONObject5.getString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
                                            if (jSONObject5.has("v")) {
                                                try {
                                                    if (jSONObject5.getBoolean("v")) {
                                                        z4 = true;
                                                        try {
                                                            try {
                                                                this.adResponse.setVideo(true);
                                                                if (jSONObject5.has(AAX_VIDEO_SKIP_AFTER)) {
                                                                    Object objOpt = jSONObject5.opt(AAX_VIDEO_SKIP_AFTER);
                                                                    if (objOpt instanceof Integer) {
                                                                        this.adResponse.setVideoSkipAfterDurationInSeconds(((Integer) objOpt).intValue());
                                                                    }
                                                                }
                                                                if (jSONObject5.has(AAX_VIDEO_INVENTORY_TYPE)) {
                                                                    this.adResponse.setVideoInventoryType(jSONObject5.getString(AAX_VIDEO_INVENTORY_TYPE));
                                                                }
                                                            } catch (JSONException e) {
                                                                e = e;
                                                                jSONObject3 = jSONObject;
                                                                z = z4;
                                                                str = str;
                                                                DtbLog.debug("Malformed response from ad call. " + e.getMessage());
                                                                this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Malformed response from ad call. ");
                                                                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Malformed response from ad call. ", e);
                                                                jSONObject = jSONObject3;
                                                                z2 = z;
                                                                if (this.adError == null) {
                                                                    DtbLog.debug("UNEXPECTED ERROR in ad call !!");
                                                                }
                                                                triggerCallBack(dtbMetrics);
                                                                if (z2) {
                                                                    ApsMetrics.customEvent(str, "false", jSONObject);
                                                                }
                                                            }
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            jSONObject3 = jSONObject;
                                                            z = z4;
                                                            str = str;
                                                            DtbLog.debug("Internal error occurred in ad call. " + e.getMessage());
                                                            this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Internal error occurred in ad call. ");
                                                            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Internal error occurred in ad call. ", e);
                                                            jSONObject = jSONObject3;
                                                            z2 = z;
                                                            if (this.adError == null) {
                                                                DtbLog.debug("UNEXPECTED ERROR in ad call !!");
                                                            }
                                                            triggerCallBack(dtbMetrics);
                                                            if (z2) {
                                                                ApsMetrics.customEvent(str, "false", jSONObject);
                                                            }
                                                        }
                                                    }
                                                } catch (JSONException e3) {
                                                    e = e3;
                                                    z4 = true;
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    z4 = true;
                                                    jSONObject3 = jSONObject;
                                                    z = z4;
                                                    str = str;
                                                    DtbLog.debug("Internal error occurred in ad call. " + e.getMessage());
                                                    this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Internal error occurred in ad call. ");
                                                    APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Internal error occurred in ad call. ", e);
                                                    jSONObject = jSONObject3;
                                                    z2 = z;
                                                    if (this.adError == null) {
                                                        DtbLog.debug("UNEXPECTED ERROR in ad call !!");
                                                    }
                                                    triggerCallBack(dtbMetrics);
                                                    if (z2) {
                                                        ApsMetrics.customEvent(str, "false", jSONObject);
                                                    }
                                                }
                                            }
                                            if (jSONObject5.has("kvp")) {
                                                try {
                                                    this.adResponse.setKvpDictionary(jSONObject5.getJSONObject("kvp"));
                                                } catch (JSONException e5) {
                                                    DtbLog.debug("Malformed kvp value from ad response: " + e5.getMessage());
                                                }
                                            }
                                            String adSize = getAdSize(jSONObject5, this.adSizes);
                                            if (jSONObject5.has("i")) {
                                                this.adResponse.setImpressionUrl(jSONObject5.getString("i"));
                                            }
                                            String str3 = str2;
                                            if (jSONObject5.has(str3)) {
                                                this.adResponse.setCrid(jSONObject5.getString(str3));
                                            }
                                            AdType adType = AdType.DISPLAY;
                                            if ("9999x9999".equals(adSize)) {
                                                adType = AdType.INTERSTITIAL;
                                            } else if (this.adResponse.isVideo()) {
                                                adType = AdType.VIDEO;
                                            }
                                            this.adResponse.putPricePoint(new DtbPricePoint(next2, adSize, this.sizeSlotUUIDMap.get(adSize), adType));
                                            str2 = str3;
                                        }
                                        this.adError = createAdError(AdError.ErrorCode.NO_ERROR, "Ad loaded successfully.");
                                        DtbLog.debug("Ad call response successfully processed.");
                                        str = str;
                                        try {
                                            ApsMetrics.customEvent(str, "true", jSONObject);
                                            z3 = false;
                                        } catch (JSONException e6) {
                                            e = e6;
                                            jSONObject3 = jSONObject;
                                            z = false;
                                            DtbLog.debug("Malformed response from ad call. " + e.getMessage());
                                            this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Malformed response from ad call. ");
                                            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Malformed response from ad call. ", e);
                                            jSONObject = jSONObject3;
                                            z2 = z;
                                        } catch (Exception e7) {
                                            e = e7;
                                            jSONObject3 = jSONObject;
                                            z = false;
                                            DtbLog.debug("Internal error occurred in ad call. " + e.getMessage());
                                            this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Internal error occurred in ad call. ");
                                            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Internal error occurred in ad call. ", e);
                                            jSONObject = jSONObject3;
                                            z2 = z;
                                        }
                                    } else {
                                        str = str;
                                        DtbLog.debug("No pricepoint returned from ad server");
                                        dtbMetrics.incrementMetric(DtbMetric.AAX_PUNTED);
                                        this.adError = createAdError(AdError.ErrorCode.NO_FILL, "No pricepoint returned from ad server.");
                                        z3 = true;
                                    }
                                    z2 = z3;
                                } else {
                                    if (jSONObject2.has("errorCode") && jSONObject2.getString("errorCode").equals("400")) {
                                        DtbLog.debug("Ad Server punted due to invalid request.");
                                        this.adError = createAdError(AdError.ErrorCode.REQUEST_ERROR, "Invalid request passed to AdServer.");
                                    } else {
                                        DtbLog.debug("No ad returned from ad server");
                                        this.adError = createAdError(AdError.ErrorCode.NO_FILL, "No Ad returned by AdServer.");
                                    }
                                    dtbMetrics.incrementMetric(DtbMetric.AAX_PUNTED);
                                }
                            } else {
                                DtbLog.debug("Ad call did not complete successfully.");
                                this.adError = createAdError(AdError.ErrorCode.NETWORK_ERROR, "Ad call did not complete successfully.");
                                dtbMetrics.incrementMetric(DtbMetric.AAX_NETWORK_FAILURE);
                            }
                            z2 = true;
                        } catch (JSONException e8) {
                            e = e8;
                            jSONObject3 = jSONObject;
                            z = true;
                        } catch (Exception e9) {
                            e = e9;
                            jSONObject3 = jSONObject;
                            z = true;
                            DtbLog.debug("Internal error occurred in ad call. " + e.getMessage());
                            this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Internal error occurred in ad call. ");
                            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Internal error occurred in ad call. ", e);
                            jSONObject = jSONObject3;
                            z2 = z;
                            if (this.adError == null) {
                                DtbLog.debug("UNEXPECTED ERROR in ad call !!");
                            }
                            triggerCallBack(dtbMetrics);
                            if (z2) {
                                ApsMetrics.customEvent(str, "false", jSONObject);
                            }
                        }
                    } catch (JSONException e10) {
                        e = e10;
                        jSONObject3 = jSONObject;
                        str = str;
                        z = true;
                    } catch (Exception e11) {
                        e = e11;
                        jSONObject3 = jSONObject;
                        str = str;
                        z = true;
                        DtbLog.debug("Internal error occurred in ad call. " + e.getMessage());
                        this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Internal error occurred in ad call. ");
                        APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Internal error occurred in ad call. ", e);
                        jSONObject = jSONObject3;
                        z2 = z;
                        if (this.adError == null) {
                            DtbLog.debug("UNEXPECTED ERROR in ad call !!");
                        }
                        triggerCallBack(dtbMetrics);
                        if (z2) {
                            ApsMetrics.customEvent(str, "false", jSONObject);
                        }
                    }
                    jSONObject3 = jSONObject;
                    z = true;
                    DtbLog.debug("Malformed response from ad call. " + e.getMessage());
                    this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Malformed response from ad call. ");
                    APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Malformed response from ad call. ", e);
                    jSONObject = jSONObject3;
                    z2 = z;
                } else {
                    dtbHttpClient = new DtbHttpClient(sb.toString());
                    dtbHttpClient.setUseSecure(DtbDebugProperties.getIsSecure(true));
                    dtbHttpClient.addHeader("Accept", "application/json");
                    dtbHttpClient.addHeader("Content-Type", "application/json");
                    dtbHttpClient.setParams(params);
                    onRequestFormed(params);
                    dtbMetrics.startTimer(DtbMetric.AAX_BID_TIME);
                    dtbHttpClient.executePOST(DtbSharedPreferences.getInstance().getBidTimeout());
                    DtbLog.debug("Ad call completed.");
                    if (!DtbCommonUtils.isNullOrEmpty(dtbHttpClient.getResponse())) {
                        DtbLog.debug("No response from Ad call.");
                        this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Response is null.");
                        throw new Exception("Response is null");
                    }
                    dtbMetrics.stopTimer(DtbMetric.AAX_BID_TIME);
                    jSONObject2 = (JSONObject) new JSONTokener(dtbHttpClient.getResponse()).nextValue();
                    if (jSONObject2 != null) {
                        DtbLog.debug("Bid Response:" + jSONObject2);
                    }
                    if (jSONObject2 == null) {
                        DtbLog.debug("Ad call did not complete successfully.");
                        this.adError = createAdError(AdError.ErrorCode.NETWORK_ERROR, "Ad call did not complete successfully.");
                        dtbMetrics.incrementMetric(DtbMetric.AAX_NETWORK_FAILURE);
                        z2 = true;
                    } else {
                        DtbLog.debug("Ad call did not complete successfully.");
                        this.adError = createAdError(AdError.ErrorCode.NETWORK_ERROR, "Ad call did not complete successfully.");
                        dtbMetrics.incrementMetric(DtbMetric.AAX_NETWORK_FAILURE);
                        z2 = true;
                    }
                    jSONObject3 = jSONObject;
                    z = true;
                    DtbLog.debug("Malformed response from ad call. " + e.getMessage());
                    this.adError = createAdError(AdError.ErrorCode.INTERNAL_ERROR, "Malformed response from ad call. ");
                    APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Malformed response from ad call. ", e);
                    jSONObject = jSONObject3;
                    z2 = z;
                }
            } catch (JSONException e12) {
                e = e12;
                str = str;
            } catch (Exception e13) {
                e = e13;
                str = str;
            }
        } catch (JSONException e14) {
            e = e14;
        } catch (Exception e15) {
            e = e15;
        }
        if (this.adError == null) {
            DtbLog.debug("UNEXPECTED ERROR in ad call !!");
        }
        triggerCallBack(dtbMetrics);
        if (z2) {
            ApsMetrics.customEvent(str, "false", jSONObject);
        }
    }

    private AdError createAdError(AdError.ErrorCode errorCode, String str) {
        AdError adError = new AdError(errorCode, str);
        adError.setAdLoader(DtbCommonUtils.createAutoRefreshAdLoader(this));
        return adError;
    }

    private void triggerCallBack(final DtbMetrics dtbMetrics) {
        scheduleAdRefreshIfEnabled();
        DtbLog.info(LOG_TAG, "Forwarding the error handling to view on main thread.");
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DTBAdRequest$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4413lambda$triggerCallBack$2$comamazondeviceadsDTBAdRequest(dtbMetrics);
            }
        });
        if (this.submitMetrics) {
            DtbMetrics.Submitter.INSTANCE.submitMetrics(dtbMetrics);
        }
    }

    public void setCorrelationId(String str) {
        this.correlationId = str;
    }

    public String getCorrelationId() {
        return this.correlationId;
    }

    private String getMediationName() {
        if (AdRegistration.getCustomDictionary().containsKey(DtbConstants.MEDIATION_NAME)) {
            return AdRegistration.getCustomDictionary().get(DtbConstants.MEDIATION_NAME);
        }
        return null;
    }

    private void sendBidEvent(long j) {
        ApsMetricsPerfAaxBidEvent apsMetricsPerfAaxBidEvent;
        String bidId;
        try {
            ApsMetricsPerfEventModelBuilder apsMetricsPerfEventModelBuilder = new ApsMetricsPerfEventModelBuilder();
            apsMetricsPerfEventModelBuilder.withCorrelationId(getCorrelationId());
            apsMetricsPerfEventModelBuilder.withMediationName(getMediationName());
            if (this.adError != null && this.adError.getCode() == AdError.ErrorCode.NO_ERROR) {
                DTBAdSize dTBAdSize = this.adResponse.getDTBAds().get(0);
                apsMetricsPerfAaxBidEvent = new ApsMetricsPerfAaxBidEvent(ApsMetricsResult.Success, this.aaxHostname);
                ApsAdFormat adFormat = ApsAdFormatUtils.getAdFormat(dTBAdSize.getDTBAdType(), dTBAdSize.getHeight(), dTBAdSize.getWidth());
                if (adFormat != null) {
                    apsMetricsPerfEventModelBuilder.withAdFormat(adFormat.toString());
                }
                bidId = this.adResponse.getBidId();
                apsMetricsPerfEventModelBuilder.withVideoFlag(this.adResponse.isVideo());
            } else {
                apsMetricsPerfAaxBidEvent = new ApsMetricsPerfAaxBidEvent(ApsMetricsResult.Failure, this.aaxHostname);
                bidId = null;
            }
            apsMetricsPerfAaxBidEvent.setRefreshFlag(Boolean.valueOf(this.isAutoRefresh));
            apsMetricsPerfAaxBidEvent.setStartTime(this.startLoadAdTime);
            apsMetricsPerfAaxBidEvent.setEndTime(j);
            apsMetricsPerfEventModelBuilder.withEvent(apsMetricsPerfAaxBidEvent);
            ApsMetrics.adEvent(bidId, apsMetricsPerfEventModelBuilder);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error in sending the bid event in ad request", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: executeCallback, reason: merged with bridge method [inline-methods] */
    public void m4413lambda$triggerCallBack$2$comamazondeviceadsDTBAdRequest(DtbMetrics dtbMetrics) {
        WrapperReport wrapperReportDetectWrapper;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.callback != null) {
            if (this.adError != null && this.adError.getCode() == AdError.ErrorCode.NO_ERROR) {
                DtbLog.debug("Invoking onSuccess() callback for pricepoints: [" + this.adResponse.getDefaultPricePoints() + b9.i.e);
                this.callback.onSuccess(this.adResponse);
                DtbLog.debug("Performing SDK wrapping detection. Will submit a report if needed.");
                if (wrapperDetectionNeeded() && (wrapperReportDetectWrapper = detectWrapper(this.callback)) != null) {
                    if (Math.random() <= DTBMetricsConfiguration.getClientConfigVal("wrapping_pixel", DTBMetricsConfiguration.WRAPPING_PIXEL_DEFAULT_VALUE.intValue(), "sample_rates").intValue() / 100.0f) {
                        HashMap map = new HashMap();
                        map.put("expected_package", wrapperReportDetectWrapper.expectedPackage);
                        map.put("wrapper_package", wrapperReportDetectWrapper.wrapperPackage);
                        DTBMetricsProcessor.getInstance().submitErrorReport("alert_sdk_wrapping_v2", map, DTBMetricReport.addBid(null, DtbCommonUtils.getHostNameFromUrl(dtbMetrics.getInstPxlUrl())));
                    }
                }
            } else {
                DtbLog.debug("Invoking onFailure() callback with errorCode: " + this.adError.getCode() + b9.i.d + this.adError.getMessage() + b9.i.e);
                this.callback.onFailure(this.adError);
            }
        } else {
            DtbLog.error("No callback -DTBAdCallback- provided to loadAd() to handle success or failure.");
        }
        sendBidEvent(jCurrentTimeMillis);
    }

    private void addMraidParameters(Map<String, Object> map) {
        JSONArray jSONArray = mRaidArray;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        map.put("mraid", mRaidArray);
    }

    class WrapperReport {
        String expectedPackage;
        String wrapperPackage;

        WrapperReport() {
        }
    }

    private WrapperReport detectWrapper(Object obj) {
        Context applicationContext = AdRegistration.getContext().getApplicationContext();
        try {
            String name = obj.getClass().getPackage().getName();
            String str = applicationContext.getApplicationInfo().packageName;
            StringTokenizer stringTokenizer = new StringTokenizer(name, ".");
            StringTokenizer stringTokenizer2 = new StringTokenizer(str, ".");
            if (stringTokenizer.countTokens() < 2 || stringTokenizer2.countTokens() < 2) {
                WrapperReport wrapperReport = new WrapperReport();
                wrapperReport.expectedPackage = str;
                wrapperReport.wrapperPackage = name;
                return wrapperReport;
            }
            for (int i = 0; i < 2; i++) {
                if (!stringTokenizer.nextToken().equals(stringTokenizer2.nextToken())) {
                    WrapperReport wrapperReport2 = new WrapperReport();
                    wrapperReport2.expectedPackage = name;
                    wrapperReport2.wrapperPackage = str;
                    return wrapperReport2;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean wrapperDetectionNeeded() {
        DtbSharedPreferences dtbSharedPreferences = DtbSharedPreferences.getInstance();
        Long wrapperDetectionLastPing = dtbSharedPreferences.getWrapperDetectionLastPing();
        long time = new Date().getTime();
        boolean z = true;
        if (wrapperDetectionLastPing != null && time - wrapperDetectionLastPing.longValue() <= WEEK) {
            z = false;
        }
        if (z) {
            dtbSharedPreferences.saveWrapperDetectionLastPing(time);
        }
        return z;
    }
}
