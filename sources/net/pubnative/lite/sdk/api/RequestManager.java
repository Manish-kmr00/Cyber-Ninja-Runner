package net.pubnative.lite.sdk.api;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import net.pubnative.lite.sdk.AdCache;
import net.pubnative.lite.sdk.CacheListener;
import net.pubnative.lite.sdk.DeviceInfo;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.analytics.ReportingController;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.AdRequest;
import net.pubnative.lite.sdk.models.AdRequestFactory;
import net.pubnative.lite.sdk.models.AdSize;
import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.models.PNAdRequest;
import net.pubnative.lite.sdk.models.PNAdRequestFactory;
import net.pubnative.lite.sdk.models.request.OpenRTBAdRequest;
import net.pubnative.lite.sdk.utils.AdTopicsAPIManager;
import net.pubnative.lite.sdk.utils.AtomManager;
import net.pubnative.lite.sdk.utils.CheckUtils;
import net.pubnative.lite.sdk.utils.HeaderBiddingUtils;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.PNInitializationHelper;
import net.pubnative.lite.sdk.utils.PrebidUtils;
import net.pubnative.lite.sdk.utils.json.JsonOperations;
import net.pubnative.lite.sdk.vpaid.VideoAdCache;
import net.pubnative.lite.sdk.vpaid.VideoAdCacheItem;
import net.pubnative.lite.sdk.vpaid.VideoAdProcessor;
import net.pubnative.lite.sdk.vpaid.response.AdParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class RequestManager {
    private static final String TAG = "RequestManager";
    final JSONObject jsonCacheParams;
    private AdCache mAdCache;
    private final AdRequestFactory mAdRequestFactory;
    private AdSize mAdSize;
    private ApiClient mApiClient;
    private String mAppToken;
    private boolean mAutoCacheOnLoad;
    private boolean mCacheFinished;
    private boolean mCacheStarted;
    private Long mCacheTimeMilliseconds;
    private String mCustomUrl;
    private DeviceInfo mDeviceInfo;
    private final PNInitializationHelper mInitializationHelper;
    private IntegrationType mIntegrationType;
    private boolean mIsDestroyed;
    private final JSONObject mPlacementParams;
    private final ReportingController mReportingController;
    private RequestListener mRequestListener;
    private Long mRequestTimeMilliseconds;
    private VideoAdCache mVideoCache;
    private String mZoneId;

    public static final class AdFormat {
        public static final String HTML = "html";
        public static final String VIDEO = "video";
    }

    public interface RequestListener {
        void onRequestFail(Throwable th);

        void onRequestSuccess(Ad ad);
    }

    public boolean isRewarded() {
        return false;
    }

    public RequestManager() {
        this(null);
    }

    public RequestManager(AdSize adSize) {
        this(HyBid.getApiClient(), HyBid.getDeviceInfo(), HyBid.getAdCache(), HyBid.getVideoAdCache(), new PNAdRequestFactory(), HyBid.getReportingController(), adSize, new PNInitializationHelper());
    }

    public RequestManager(ApiClient apiClient, AdRequestFactory adRequestFactory) {
        this(null, apiClient, adRequestFactory);
    }

    public RequestManager(AdSize adSize, ApiClient apiClient, AdRequestFactory adRequestFactory) {
        this(apiClient, HyBid.getDeviceInfo(), HyBid.getAdCache(), HyBid.getVideoAdCache(), adRequestFactory, HyBid.getReportingController(), adSize, new PNInitializationHelper());
    }

    RequestManager(ApiClient apiClient, DeviceInfo deviceInfo, AdCache adCache, VideoAdCache videoAdCache, AdRequestFactory adRequestFactory, ReportingController reportingController, AdSize adSize, PNInitializationHelper pNInitializationHelper) {
        this.mIntegrationType = IntegrationType.STANDALONE;
        this.mAutoCacheOnLoad = true;
        this.mCacheStarted = false;
        this.mCacheFinished = false;
        this.mRequestTimeMilliseconds = 0L;
        this.mCacheTimeMilliseconds = 0L;
        this.mApiClient = apiClient;
        this.mDeviceInfo = deviceInfo;
        this.mAdCache = adCache;
        this.mVideoCache = videoAdCache;
        this.mReportingController = reportingController;
        this.mAdRequestFactory = adRequestFactory;
        this.mInitializationHelper = pNInitializationHelper;
        JSONObject jSONObject = new JSONObject();
        this.mPlacementParams = jSONObject;
        if (adSize == null) {
            this.mAdSize = AdSize.SIZE_320x50;
        } else {
            this.mAdSize = adSize;
        }
        JsonOperations.putJsonString(jSONObject, Reporting.Key.AD_SIZE, this.mAdSize.toString());
        JsonOperations.putJsonString(jSONObject, "integration_type", IntegrationType.HEADER_BIDDING.getCode());
        JSONObject jSONObject2 = new JSONObject();
        this.jsonCacheParams = jSONObject2;
        String str = this.mAppToken;
        if (str == null || TextUtils.isEmpty(str)) {
            this.mAppToken = HyBid.getAppToken();
        }
        try {
            jSONObject2.put(Reporting.Key.APP_TOKEN, this.mAppToken);
        } catch (JSONException e) {
            e.printStackTrace();
            HyBid.reportException((Exception) e);
        }
    }

    public void setRequestListener(RequestListener requestListener) {
        this.mRequestListener = requestListener;
    }

    public void setAppToken(String str) {
        this.mAppToken = str;
    }

    public void setZoneId(String str) {
        this.mZoneId = str;
    }

    public void setCustomUrl(String str) {
        this.mCustomUrl = str;
    }

    public void setAdSize(AdSize adSize) {
        this.mAdSize = adSize;
        if (adSize != null) {
            JsonOperations.putJsonString(this.mPlacementParams, Reporting.Key.AD_SIZE, adSize.toString());
        } else {
            JsonOperations.removeJsonValue(this.mPlacementParams, Reporting.Key.AD_SIZE);
        }
    }

    public void requestAd() {
        if (CheckUtils.NoThrow.checkArgument(this.mInitializationHelper.isInitialized(), "HyBid SDK has not been initialized. Please call HyBid#initialize in your application's onCreate method.") && CheckUtils.NoThrow.checkNotNull(HyBid.getDeviceInfo(), "HyBid SDK has not been initialized yet. Please call HyBid#initialize in your application's onCreate method.") && CheckUtils.NoThrow.checkNotNull(HyBid.getUserDataManager(), "HyBid SDK has not been initialized yet. Please call HyBid#initialize in your application's onCreate method.") && CheckUtils.NoThrow.checkNotNull(this.mZoneId, "zone id cannot be null") && CheckUtils.NoThrow.checkArgument(!this.mIsDestroyed, "RequestManager has been destroyed")) {
            if (HyBid.isTestMode()) {
                Logger.w(TAG, "You are using Verve HyBid SDK on test mode. Please disable test mode before submitting your application for production.");
            }
            this.mCacheStarted = false;
            this.mCacheFinished = false;
            this.mAdRequestFactory.createAdRequest(TextUtils.isEmpty(this.mAppToken) ? null : this.mAppToken, this.mZoneId, getAdSize(), isRewarded(), false, new AdRequestFactory.Callback() { // from class: net.pubnative.lite.sdk.api.RequestManager$$ExternalSyntheticLambda0
                @Override // net.pubnative.lite.sdk.models.AdRequestFactory.Callback
                public final void onRequestCreated(AdRequest adRequest) {
                    this.f$0.m9552lambda$requestAd$0$netpubnativelitesdkapiRequestManager(adRequest);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$requestAd$0$net-pubnative-lite-sdk-api-RequestManager, reason: not valid java name */
    /* synthetic */ void m9552lambda$requestAd$0$netpubnativelitesdkapiRequestManager(AdRequest adRequest) {
        requestAdFromApi(adRequest);
        if (adRequest != null) {
            try {
                this.jsonCacheParams.put(Reporting.Key.AD_REQUEST, adRequest.toString());
            } catch (JSONException e) {
                e.printStackTrace();
                HyBid.reportException((Exception) e);
            }
        }
    }

    public PNInitializationHelper getInitializationHelper() {
        return this.mInitializationHelper;
    }

    void requestAdFromApi(AdRequest adRequest) {
        if (this.mApiClient == null) {
            this.mApiClient = HyBid.getApiClient();
        }
        if (this.mDeviceInfo == null) {
            this.mDeviceInfo = HyBid.getDeviceInfo();
        }
        try {
            this.jsonCacheParams.put("timestamp", String.valueOf(System.currentTimeMillis()));
        } catch (JSONException e) {
            e.printStackTrace();
            HyBid.reportException((Exception) e);
        }
        Logger.d(TAG, "Requesting ad for zone id: " + adRequest.zoneId);
        if (adRequest instanceof PNAdRequest) {
            reportAdRequest((PNAdRequest) adRequest);
        } else {
            reportAdRequest((OpenRTBAdRequest) adRequest);
        }
        if (!TextUtils.isEmpty(this.mCustomUrl)) {
            this.mApiClient.setCustomUrl(this.mCustomUrl);
        }
        this.mApiClient.getAd(adRequest, this.mDeviceInfo.getUserAgent(), new AnonymousClass1(adRequest));
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.api.RequestManager$1, reason: invalid class name */
    class AnonymousClass1 implements ApiClient.AdRequestListener {
        final /* synthetic */ AdRequest val$adRequest;

        AnonymousClass1(AdRequest adRequest) {
            this.val$adRequest = adRequest;
        }

        @Override // net.pubnative.lite.sdk.api.ApiClient.AdRequestListener
        public void onSuccess(Ad ad) {
            if (RequestManager.this.mIsDestroyed) {
                return;
            }
            Logger.d(RequestManager.TAG, "Received ad response for zone id: " + this.val$adRequest.zoneId);
            RequestManager requestManager = RequestManager.this;
            requestManager.reportAdResponse(this.val$adRequest, ad, requestManager.mIntegrationType);
            RequestManager.this.processAd(this.val$adRequest, ad);
        }

        @Override // net.pubnative.lite.sdk.api.ApiClient.AdRequestListener
        public void onFailure(final Throwable th) {
            if (RequestManager.this.mIsDestroyed) {
                return;
            }
            Logger.w(RequestManager.TAG, th.getMessage());
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.pubnative.lite.sdk.api.RequestManager$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9553lambda$onFailure$0$netpubnativelitesdkapiRequestManager$1(th);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onFailure$0$net-pubnative-lite-sdk-api-RequestManager$1, reason: not valid java name */
        /* synthetic */ void m9553lambda$onFailure$0$netpubnativelitesdkapiRequestManager$1(Throwable th) {
            if (RequestManager.this.mRequestListener != null) {
                RequestManager.this.mRequestListener.onRequestFail(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processAd(AdRequest adRequest, Ad ad) {
        AdCache adCache = this.mAdCache;
        if (adCache == null || adCache != HyBid.getAdCache()) {
            this.mAdCache = HyBid.getAdCache();
        }
        VideoAdCache videoAdCache = this.mVideoCache;
        if (videoAdCache == null || videoAdCache != HyBid.getVideoAdCache()) {
            this.mVideoCache = HyBid.getVideoAdCache();
        }
        ad.setZoneId(adRequest.zoneId);
        this.mAdCache.put(adRequest.zoneId, ad);
        AdTopicsAPIManager.setTopicsAPIEnabled(this.mApiClient.getContext(), ad);
        AtomManager.setAtomEnabled(this.mApiClient.getContext(), ad);
        int i = ad.assetgroupid;
        if (i == 4 || i == 15) {
            if (this.mAutoCacheOnLoad) {
                cacheAd(ad);
                return;
            }
            RequestListener requestListener = this.mRequestListener;
            if (requestListener != null) {
                requestListener.onRequestSuccess(ad);
                return;
            }
            return;
        }
        RequestListener requestListener2 = this.mRequestListener;
        if (requestListener2 != null) {
            requestListener2.onRequestSuccess(ad);
        }
    }

    public void cacheAd(Ad ad) {
        cacheAd(ad, null);
    }

    public void cacheAd(final Ad ad, final CacheListener cacheListener) {
        if (ad == null || TextUtils.isEmpty(ad.getVast()) || this.mCacheStarted || this.mCacheFinished) {
            if (cacheListener != null) {
                cacheListener.onCacheSuccess();
                return;
            }
            return;
        }
        this.mCacheStarted = true;
        this.mCacheFinished = false;
        try {
            this.jsonCacheParams.put("ad_type", "VAST");
            this.jsonCacheParams.put("vast", ad.getVast());
        } catch (JSONException e) {
            e.printStackTrace();
            HyBid.reportException((Exception) e);
        }
        this.mRequestTimeMilliseconds = Long.valueOf(System.currentTimeMillis());
        new VideoAdProcessor().process(this.mApiClient.getContext(), ad.getVast(), getAdSize(), new VideoAdProcessor.Listener() { // from class: net.pubnative.lite.sdk.api.RequestManager.2
            @Override // net.pubnative.lite.sdk.vpaid.VideoAdProcessor.Listener
            public void onCacheSuccess(AdParams adParams, String str, EndCardData endCardData, String str2, List<String> list) {
                if (RequestManager.this.mIsDestroyed) {
                    return;
                }
                RequestManager.this.mCacheTimeMilliseconds = Long.valueOf(System.currentTimeMillis());
                if (list != null && !list.isEmpty()) {
                    JsonOperations.putStringArray(RequestManager.this.mPlacementParams, Reporting.Key.OM_VENDORS, list);
                }
                try {
                    RequestManager.this.jsonCacheParams.put(Reporting.Key.CACHE_TIME, String.valueOf(RequestManager.this.mCacheTimeMilliseconds.longValue() - RequestManager.this.mRequestTimeMilliseconds.longValue()));
                } catch (JSONException e2) {
                    Logger.w(RequestManager.TAG, e2.getMessage());
                    HyBid.reportException((Exception) e2);
                }
                RequestManager.this.reportAdCache();
                ad.setHasEndCard((adParams.getEndCardList() == null || adParams.getEndCardList().isEmpty()) ? false : true);
                RequestManager.this.mVideoCache.put(ad.getZoneId(), new VideoAdCacheItem(adParams, str, endCardData, str2));
                RequestManager.this.mCacheStarted = false;
                RequestManager.this.mCacheFinished = true;
                if (RequestManager.this.mAutoCacheOnLoad && RequestManager.this.mRequestListener != null) {
                    RequestManager.this.mRequestListener.onRequestSuccess(ad);
                    return;
                }
                CacheListener cacheListener2 = cacheListener;
                if (cacheListener2 != null) {
                    cacheListener2.onCacheSuccess();
                }
            }

            @Override // net.pubnative.lite.sdk.vpaid.VideoAdProcessor.Listener
            public void onCacheError(Throwable th) {
                if (RequestManager.this.mIsDestroyed) {
                    return;
                }
                Logger.w(RequestManager.TAG, th.getMessage());
                RequestManager.this.mCacheStarted = false;
                RequestManager.this.mCacheFinished = false;
                if (RequestManager.this.mAutoCacheOnLoad && RequestManager.this.mRequestListener != null) {
                    RequestManager.this.mRequestListener.onRequestFail(th);
                    return;
                }
                CacheListener cacheListener2 = cacheListener;
                if (cacheListener2 != null) {
                    cacheListener2.onCacheFailed(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAdCache() {
        if (this.mReportingController == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType(Reporting.EventType.CACHE);
        reportingEvent.setPlatform("android");
        reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
        JsonOperations.mergeJsonObjects(this.jsonCacheParams, getPlacementParams());
        reportingEvent.mergeJSONObject(this.jsonCacheParams);
        this.mReportingController.reportEvent(reportingEvent);
    }

    private void reportAdRequest(PNAdRequest pNAdRequest) {
        if (this.mReportingController == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType("request");
        reportingEvent.setPlatform("android");
        reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
        reportingEvent.setTimestamp(String.valueOf(System.currentTimeMillis()));
        if (getAdSize() != null) {
            reportingEvent.setAdSize(getAdSize().toString());
        }
        reportingEvent.setPlacementId(pNAdRequest.zoneId);
        reportingEvent.setSessionDuration(pNAdRequest.sessionduration);
        reportingEvent.setImpDepth(pNAdRequest.impdepth);
        reportingEvent.setAgeOfApp(pNAdRequest.ageofapp);
        reportingEvent.setRequestType("apiv3");
        this.mReportingController.reportEvent(reportingEvent);
    }

    private void reportAdRequest(OpenRTBAdRequest openRTBAdRequest) {
        if (this.mReportingController == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType("request");
        reportingEvent.setPlatform("android");
        reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(this.mIntegrationType));
        reportingEvent.setTimestamp(String.valueOf(System.currentTimeMillis()));
        if (getAdSize() != null) {
            reportingEvent.setAdSize(getAdSize().toString());
        }
        reportingEvent.setPlacementId(openRTBAdRequest.zoneId);
        reportingEvent.setRequestType("ortb");
        this.mReportingController.reportEvent(reportingEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00b4  */
    public void reportAdResponse(AdRequest adRequest, Ad ad, IntegrationType integrationType) {
        if (this.mReportingController == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType("response");
        reportingEvent.setPlatform("android");
        reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(integrationType));
        reportingEvent.setTimestamp(String.valueOf(System.currentTimeMillis()));
        if (getAdSize() != null) {
            reportingEvent.setAdSize(getAdSize().toString());
        }
        reportingEvent.setPlacementId(adRequest.zoneId);
        reportingEvent.setImpId(ad.getSessionId());
        reportingEvent.setCampaignId(ad.getCampaignId());
        reportingEvent.setConfigId(ad.getConfigId());
        reportingEvent.setCustomString(Reporting.Key.BID_PRICE, HeaderBiddingUtils.getBidFromPoints(ad.getECPM(), PrebidUtils.KeywordMode.THREE_DECIMALS));
        int i = ad.assetgroupid;
        if (i == 4) {
            reportingEvent.setAdFormat("banner");
            reportingEvent.setCreativeType("video");
        } else if (i == 8 || i == 10 || i == 12) {
            reportingEvent.setAdFormat("banner");
            reportingEvent.setCreativeType(Reporting.CreativeType.STANDARD);
        } else if (i != 15) {
            switch (i) {
                case 21:
                case 22:
                case 23:
                case 29:
                    if (isRewarded()) {
                        reportingEvent.setAdFormat("rewarded");
                    } else {
                        reportingEvent.setAdFormat("fullscreen");
                    }
                    reportingEvent.setCreativeType(Reporting.CreativeType.STANDARD);
                    break;
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                    reportingEvent.setAdFormat("banner");
                    reportingEvent.setCreativeType(Reporting.CreativeType.STANDARD);
                    break;
                default:
                    reportingEvent.setAdFormat("native");
                    break;
            }
        } else {
            if (isRewarded()) {
                reportingEvent.setAdFormat("rewarded");
            } else {
                reportingEvent.setAdFormat("fullscreen");
            }
            reportingEvent.setCreativeType("video");
        }
        this.mReportingController.reportEvent(reportingEvent);
    }

    public void setMediationVendor(String str) {
        AdRequestFactory adRequestFactory = this.mAdRequestFactory;
        if (adRequestFactory != null) {
            adRequestFactory.setMediationVendor(str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JsonOperations.putJsonString(this.mPlacementParams, Reporting.Key.MEDIATION_VENDOR, str);
        }
    }

    public void setIntegrationType(IntegrationType integrationType) {
        if (integrationType != null) {
            this.mIntegrationType = integrationType;
        }
        AdRequestFactory adRequestFactory = this.mAdRequestFactory;
        if (adRequestFactory != null) {
            adRequestFactory.setIntegrationType(integrationType);
            JsonOperations.putJsonString(this.mPlacementParams, "integration_type", integrationType.getCode());
        }
    }

    public void setAdFormat(String str) {
        AdRequestFactory adRequestFactory = this.mAdRequestFactory;
        if (adRequestFactory != null) {
            adRequestFactory.setAdFormat(str);
        }
    }

    public void destroy() {
        this.mRequestListener = null;
        this.mIsDestroyed = true;
    }

    public AdSize getAdSize() {
        return this.mAdSize;
    }

    public boolean isAutoCacheOnLoad() {
        return this.mAutoCacheOnLoad;
    }

    public void setAutoCacheOnLoad(boolean z) {
        this.mAutoCacheOnLoad = z;
    }

    public JSONObject getPlacementParams() {
        JSONObject placementParams;
        JSONObject jSONObject = new JSONObject();
        JsonOperations.mergeJsonObjects(jSONObject, this.mPlacementParams);
        if (getAdSize() != null) {
            JsonOperations.putJsonString(jSONObject, Reporting.Key.AD_SIZE, getAdSize().toString());
        }
        JsonOperations.putJsonBoolean(jSONObject, Reporting.Key.OM_ENABLED, HyBid.isViewabilityMeasurementActivated() && HyBid.getViewabilityManager() != null);
        ApiClient apiClient = this.mApiClient;
        if (apiClient != null && (placementParams = apiClient.getPlacementParams()) != null) {
            JsonOperations.mergeJsonObjects(jSONObject, placementParams);
        }
        return jSONObject;
    }

    public IntegrationType getIntegrationType() {
        return this.mIntegrationType;
    }
}
