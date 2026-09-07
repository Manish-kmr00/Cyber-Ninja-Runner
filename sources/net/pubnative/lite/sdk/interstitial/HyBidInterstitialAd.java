package net.pubnative.lite.sdk.interstitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.pubmatic.sdk.common.log.POBLogConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.CacheListener;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.HyBidError;
import net.pubnative.lite.sdk.HyBidErrorCode;
import net.pubnative.lite.sdk.VideoListener;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.api.InterstitialRequestManager;
import net.pubnative.lite.sdk.api.OpenRTBApiClient;
import net.pubnative.lite.sdk.api.RequestManager;
import net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter;
import net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenterFactory;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.AdSize;
import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.models.OpenRTBAdRequestFactory;
import net.pubnative.lite.sdk.models.Protocol;
import net.pubnative.lite.sdk.models.SkipOffset;
import net.pubnative.lite.sdk.network.PNHttpClient;
import net.pubnative.lite.sdk.prefs.SessionImpressionPrefs;
import net.pubnative.lite.sdk.utils.AdEndCardManager;
import net.pubnative.lite.sdk.utils.AdRequestRegistry;
import net.pubnative.lite.sdk.utils.AdTracker;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.MarkupUtils;
import net.pubnative.lite.sdk.utils.SignalDataProcessor;
import net.pubnative.lite.sdk.utils.SkipOffsetManager;
import net.pubnative.lite.sdk.utils.json.JsonOperations;
import net.pubnative.lite.sdk.vpaid.VideoAdCacheItem;
import net.pubnative.lite.sdk.vpaid.VideoAdProcessor;
import net.pubnative.lite.sdk.vpaid.response.AdParams;
import net.pubnative.lite.sdk.vpaid.vast.VastUrlUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class HyBidInterstitialAd implements RequestManager.RequestListener, InterstitialPresenter.Listener, VideoListener {
    private static final String TAG = "HyBidInterstitialAd";
    private static final long TIME_TO_EXPIRE = 1800000;
    private Ad mAd;
    private AdTracker mAdTracker;
    private final String mAppToken;
    private final Context mContext;
    private String mCustomUrl;
    private SkipOffset mHtmlSkipOffset;
    private long mInitialLoadTime;
    private long mInitialRenderTime;
    private boolean mIsDestroyed;
    private final Listener mListener;
    private RequestManager mORTBRequestManager;
    private JSONObject mPlacementParams;
    private InterstitialPresenter mPresenter;
    private boolean mReady;
    private RequestManager mRequestManager;
    private String mScreenIabCategory;
    private String mScreenKeywords;
    private SignalDataProcessor mSignalDataProcessor;
    private String mUserIntent;
    private VideoListener mVideoListener;
    private SkipOffset mVideoSkipOffset;
    private String mZoneId;

    public interface Listener {
        void onInterstitialClick();

        void onInterstitialDismissed();

        void onInterstitialImpression();

        void onInterstitialLoadFailed(Throwable th);

        void onInterstitialLoaded();
    }

    public HyBidInterstitialAd(Activity activity, Listener listener) {
        this((Context) activity, "", listener);
    }

    public HyBidInterstitialAd(Activity activity, String str, Listener listener) {
        this((Context) activity, str, listener);
    }

    public HyBidInterstitialAd(Context context, String str, Listener listener) {
        this(context, null, str, listener);
    }

    public HyBidInterstitialAd(Context context, String str, String str2, Listener listener) {
        this.mReady = false;
        this.mIsDestroyed = false;
        this.mInitialLoadTime = -1L;
        this.mInitialRenderTime = -1L;
        if (!HyBid.isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before creating a HyBidInterstitialAd");
        }
        this.mRequestManager = new InterstitialRequestManager();
        this.mORTBRequestManager = new RequestManager(new OpenRTBApiClient(context), new OpenRTBAdRequestFactory());
        this.mContext = context;
        this.mAppToken = str;
        this.mZoneId = str2;
        this.mListener = listener;
        this.mPlacementParams = new JSONObject();
        addReportingKey("zone_id", this.mZoneId);
        this.mHtmlSkipOffset = new SkipOffset(SkipOffsetManager.getDefaultHtmlInterstitialSkipOffset().intValue(), false);
        this.mVideoSkipOffset = new SkipOffset(SkipOffsetManager.getDefaultVideoWithoutEndCardSkipOffset().intValue(), false);
        this.mRequestManager.setIntegrationType(IntegrationType.STANDALONE);
        this.mORTBRequestManager.setIntegrationType(IntegrationType.STANDALONE);
    }

    public void load() {
        addReportingKey("timestamp", String.valueOf(System.currentTimeMillis()));
        if (HyBid.getAppToken() != null) {
            addReportingKey(Reporting.Key.APP_TOKEN, HyBid.getAppToken());
        }
        addReportingKey("ad_type", "fullscreen");
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null && requestManager.getAdSize() != null) {
            addReportingKey(Reporting.Key.AD_SIZE, this.mRequestManager.getAdSize().toString());
        }
        addReportingKey("integration_type", IntegrationType.STANDALONE);
        if (!HyBid.isInitialized()) {
            this.mInitialLoadTime = System.currentTimeMillis();
            invokeOnLoadFailed(new HyBidError(HyBidErrorCode.NOT_INITIALISED));
            return;
        }
        if (TextUtils.isEmpty(this.mZoneId)) {
            this.mInitialLoadTime = System.currentTimeMillis();
            invokeOnLoadFailed(new HyBidError(HyBidErrorCode.INVALID_ZONE_ID));
            return;
        }
        cleanup();
        this.mInitialLoadTime = System.currentTimeMillis();
        if (this.mRequestManager != null) {
            if (!TextUtils.isEmpty(this.mAppToken)) {
                this.mRequestManager.setAppToken(this.mAppToken);
            }
            this.mRequestManager.setZoneId(this.mZoneId);
            this.mRequestManager.setRequestListener(this);
            this.mRequestManager.requestAd();
        }
    }

    public void loadExchangeAd(String str) {
        addReportingKey("timestamp", String.valueOf(System.currentTimeMillis()));
        if (HyBid.getAppToken() != null) {
            addReportingKey(Reporting.Key.APP_TOKEN, HyBid.getAppToken());
        }
        addReportingKey("ad_type", "fullscreen");
        this.mORTBRequestManager.setAdSize(AdSize.SIZE_INTERSTITIAL);
        addReportingKey(Reporting.Key.AD_SIZE, this.mORTBRequestManager.getAdSize().toString());
        addReportingKey("integration_type", IntegrationType.STANDALONE);
        if (!HyBid.isInitialized()) {
            this.mInitialLoadTime = System.currentTimeMillis();
            invokeOnLoadFailed(new HyBidError(HyBidErrorCode.NOT_INITIALISED));
            return;
        }
        if (TextUtils.isEmpty(this.mZoneId)) {
            this.mInitialLoadTime = System.currentTimeMillis();
            invokeOnLoadFailed(new HyBidError(HyBidErrorCode.INVALID_ZONE_ID));
            return;
        }
        cleanup();
        this.mInitialLoadTime = System.currentTimeMillis();
        if (!TextUtils.isEmpty(this.mAppToken)) {
            this.mORTBRequestManager.setAppToken(this.mAppToken);
        }
        if (!TextUtils.isEmpty(str)) {
            this.mORTBRequestManager.setAdFormat(str);
        }
        this.mORTBRequestManager.setZoneId(this.mZoneId);
        this.mORTBRequestManager.setRequestListener(this);
        this.mORTBRequestManager.requestAd();
    }

    public void loadExchangeAd() {
        loadExchangeAd(null);
    }

    public boolean show() {
        if (this.mPresenter != null && this.mReady) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.mInitialRenderTime = jCurrentTimeMillis;
            long j = this.mInitialLoadTime;
            if (jCurrentTimeMillis < TIME_TO_EXPIRE + j || j == -1) {
                this.mPresenter.show();
                return true;
            }
            Logger.e(TAG, POBLogConstants.MSG_AD_EXPIRED_ERROR);
            cleanup();
            invokeOnLoadFailed(new HyBidError(HyBidErrorCode.EXPIRED_AD));
            return false;
        }
        Logger.e(TAG, "Can't display ad. Interstitial not ready.");
        return false;
    }

    public boolean isReady() {
        return this.mReady;
    }

    public void destroy() {
        cleanup();
        this.mIsDestroyed = true;
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null) {
            requestManager.destroy();
            this.mRequestManager = null;
        }
        RequestManager requestManager2 = this.mORTBRequestManager;
        if (requestManager2 != null) {
            requestManager2.destroy();
            this.mORTBRequestManager = null;
        }
    }

    private void cleanup() {
        this.mReady = false;
        this.mPlacementParams = new JSONObject();
        this.mInitialLoadTime = -1L;
        this.mInitialRenderTime = -1L;
        InterstitialPresenter interstitialPresenter = this.mPresenter;
        if (interstitialPresenter != null) {
            interstitialPresenter.destroy();
            this.mPresenter = null;
        }
        SignalDataProcessor signalDataProcessor = this.mSignalDataProcessor;
        if (signalDataProcessor != null) {
            signalDataProcessor.destroy();
            this.mSignalDataProcessor = null;
        }
    }

    public String getImpressionId() {
        Ad ad = this.mAd;
        if (ad != null) {
            return ad.getImpressionId();
        }
        return null;
    }

    public String getCreativeId() {
        Ad ad = this.mAd;
        if (ad != null) {
            return ad.getCreativeId();
        }
        return null;
    }

    public Integer getBidPoints() {
        Ad ad = this.mAd;
        return Integer.valueOf(ad != null ? ad.getECPM().intValue() : 0);
    }

    public void setCustomUrl(String str) {
        this.mCustomUrl = str;
    }

    public JSONObject getPlacementParams() {
        JSONObject placementParams;
        JSONObject placementParams2;
        JSONObject jSONObject = new JSONObject();
        JsonOperations.mergeJsonObjects(jSONObject, this.mPlacementParams);
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null && (placementParams2 = requestManager.getPlacementParams()) != null) {
            JsonOperations.mergeJsonObjects(jSONObject, placementParams2);
        }
        InterstitialPresenter interstitialPresenter = this.mPresenter;
        if (interstitialPresenter != null && (placementParams = interstitialPresenter.getPlacementParams()) != null) {
            JsonOperations.mergeJsonObjects(jSONObject, placementParams);
        }
        return jSONObject;
    }

    private void renderAd() {
        IntegrationType integrationType = IntegrationType.IN_APP_BIDDING;
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null) {
            integrationType = requestManager.getIntegrationType();
        }
        InterstitialPresenter interstitialPresenterCreateInterstitialPresenter = new InterstitialPresenterFactory(this.mContext, this.mZoneId).createInterstitialPresenter(this.mAd, this.mHtmlSkipOffset, this.mVideoSkipOffset, this, integrationType);
        this.mPresenter = interstitialPresenterCreateInterstitialPresenter;
        if (interstitialPresenterCreateInterstitialPresenter != null) {
            interstitialPresenterCreateInterstitialPresenter.setVideoListener(this);
            this.mPresenter.load();
        } else {
            invokeOnLoadFailed(new HyBidError(HyBidErrorCode.UNSUPPORTED_ASSET));
        }
    }

    public void prepare() {
        prepare(null);
    }

    public void prepare(CacheListener cacheListener) {
        Ad ad;
        RequestManager requestManager = this.mRequestManager;
        if (requestManager == null || (ad = this.mAd) == null) {
            return;
        }
        requestManager.cacheAd(ad, cacheListener);
    }

    public void prepareAd(String str) {
        if (!TextUtils.isEmpty(str)) {
            SignalDataProcessor signalDataProcessor = new SignalDataProcessor();
            this.mSignalDataProcessor = signalDataProcessor;
            signalDataProcessor.processSignalData(str, new SignalDataProcessor.Listener() { // from class: net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd.1
                @Override // net.pubnative.lite.sdk.utils.SignalDataProcessor.Listener
                public void onProcessed(Ad ad) {
                    if (ad != null) {
                        HyBidInterstitialAd.this.prepareAd(ad);
                    }
                }

                @Override // net.pubnative.lite.sdk.utils.SignalDataProcessor.Listener
                public void onError(Throwable th) {
                    HyBidInterstitialAd.this.invokeOnLoadFailed(th);
                }
            });
            return;
        }
        invokeOnLoadFailed(new HyBidError(HyBidErrorCode.INVALID_SIGNAL_DATA));
    }

    public void prepareAd(Ad ad) {
        if (ad != null) {
            this.mAd = ad;
            initializeAdTracker();
            checkRemoteConfigs();
            Ad ad2 = this.mAd;
            if (ad2 != null && ad2.getZoneId() != null && !this.mAd.getZoneId().equalsIgnoreCase(this.mZoneId)) {
                String zoneId = this.mAd.getZoneId();
                this.mZoneId = zoneId;
                JsonOperations.putJsonString(this.mPlacementParams, "zone_id", zoneId);
            } else if (this.mZoneId == null) {
                this.mZoneId = Protocol.VAST_1_0_WRAPPER;
            }
            IntegrationType integrationType = IntegrationType.IN_APP_BIDDING;
            RequestManager requestManager = this.mRequestManager;
            if (requestManager != null) {
                integrationType = requestManager.getIntegrationType();
            }
            InterstitialPresenter interstitialPresenterCreateInterstitialPresenter = new InterstitialPresenterFactory(this.mContext, this.mZoneId).createInterstitialPresenter(this.mAd, this.mHtmlSkipOffset, this.mVideoSkipOffset, this, integrationType);
            this.mPresenter = interstitialPresenterCreateInterstitialPresenter;
            if (interstitialPresenterCreateInterstitialPresenter != null) {
                interstitialPresenterCreateInterstitialPresenter.setVideoListener(this);
                this.mPresenter.load();
                return;
            } else {
                invokeOnLoadFailed(new HyBidError(HyBidErrorCode.UNSUPPORTED_ASSET));
                return;
            }
        }
        invokeOnLoadFailed(new HyBidError(HyBidErrorCode.INVALID_AD));
    }

    public void prepareCustomMarkup(String str) {
        prepareCustomMarkup("", str);
    }

    public void prepareCustomMarkup(String str, final String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.mZoneId = str;
            if (MarkupUtils.isVastXml(str2)) {
                if (TextUtils.isEmpty(this.mZoneId)) {
                    this.mZoneId = Protocol.VAST_1_0_WRAPPER;
                    JsonOperations.putJsonString(this.mPlacementParams, "zone_id", Protocol.VAST_1_0_WRAPPER);
                }
                final Ad.AdType adType = Ad.AdType.VIDEO;
                final int i = 15;
                new VideoAdProcessor().process(this.mContext, str2, null, new VideoAdProcessor.Listener() { // from class: net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd.2
                    @Override // net.pubnative.lite.sdk.vpaid.VideoAdProcessor.Listener
                    public void onCacheSuccess(AdParams adParams, String str3, EndCardData endCardData, String str4, List<String> list) {
                        if (HyBidInterstitialAd.this.mIsDestroyed) {
                            return;
                        }
                        if (list != null && !list.isEmpty()) {
                            JsonOperations.putStringArray(HyBidInterstitialAd.this.mPlacementParams, Reporting.Key.OM_VENDORS, list);
                        }
                        boolean z = (adParams.getEndCardList() == null || adParams.getEndCardList().isEmpty()) ? false : true;
                        VideoAdCacheItem videoAdCacheItem = new VideoAdCacheItem(adParams, str3, endCardData, str4);
                        HyBidInterstitialAd.this.mAd = new Ad(i, str2, adType);
                        HyBidInterstitialAd.this.mAd.setHasEndCard(z);
                        HyBidInterstitialAd.this.initializeAdTracker();
                        HyBid.getAdCache().put(HyBidInterstitialAd.this.mZoneId, HyBidInterstitialAd.this.mAd);
                        HyBid.getVideoAdCache().put(HyBidInterstitialAd.this.mZoneId, videoAdCacheItem);
                        HyBidInterstitialAd.this.checkRemoteConfigs();
                        IntegrationType integrationType = IntegrationType.IN_APP_BIDDING;
                        if (HyBidInterstitialAd.this.mRequestManager != null) {
                            integrationType = HyBidInterstitialAd.this.mRequestManager.getIntegrationType();
                        }
                        HyBidInterstitialAd.this.mPresenter = new InterstitialPresenterFactory(HyBidInterstitialAd.this.mContext, HyBidInterstitialAd.this.mZoneId).createInterstitialPresenter(HyBidInterstitialAd.this.mAd, HyBidInterstitialAd.this.mHtmlSkipOffset, HyBidInterstitialAd.this.mVideoSkipOffset, HyBidInterstitialAd.this, integrationType);
                        if (HyBidInterstitialAd.this.mPresenter != null) {
                            HyBidInterstitialAd.this.mPresenter.setVideoListener(HyBidInterstitialAd.this);
                            HyBidInterstitialAd.this.mPresenter.load();
                        } else {
                            HyBidInterstitialAd.this.invokeOnLoadFailed(new HyBidError(HyBidErrorCode.UNSUPPORTED_ASSET));
                        }
                    }

                    @Override // net.pubnative.lite.sdk.vpaid.VideoAdProcessor.Listener
                    public void onCacheError(Throwable th) {
                        if (HyBidInterstitialAd.this.mIsDestroyed) {
                            return;
                        }
                        Logger.w(HyBidInterstitialAd.TAG, "onCacheError", th);
                        HyBidInterstitialAd.this.invokeOnLoadFailed(th);
                    }
                });
            } else {
                if (TextUtils.isEmpty(this.mZoneId)) {
                    this.mZoneId = "3";
                }
                Ad ad = new Ad(21, str2, Ad.AdType.HTML);
                this.mAd = ad;
                ad.setZoneId(this.mZoneId);
                this.mAd.setHasEndCard(hasEndCard());
                initializeAdTracker();
                HyBid.getAdCache().put(this.mZoneId, this.mAd);
                checkRemoteConfigs();
                IntegrationType integrationType = IntegrationType.IN_APP_BIDDING;
                RequestManager requestManager = this.mRequestManager;
                if (requestManager != null) {
                    integrationType = requestManager.getIntegrationType();
                }
                InterstitialPresenter interstitialPresenterCreateInterstitialPresenter = new InterstitialPresenterFactory(this.mContext, this.mZoneId).createInterstitialPresenter(this.mAd, this.mHtmlSkipOffset, this.mVideoSkipOffset, this, integrationType);
                this.mPresenter = interstitialPresenterCreateInterstitialPresenter;
                if (interstitialPresenterCreateInterstitialPresenter != null) {
                    interstitialPresenterCreateInterstitialPresenter.setVideoListener(this);
                    this.mPresenter.load();
                } else {
                    invokeOnLoadFailed(new HyBidError(HyBidErrorCode.UNSUPPORTED_ASSET));
                }
            }
            JsonOperations.putJsonString(this.mPlacementParams, "zone_id", this.mZoneId);
            return;
        }
        invokeOnLoadFailed(new HyBidError(HyBidErrorCode.INVALID_ASSET));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRemoteConfigs() {
        Ad ad = this.mAd;
        if (ad == null) {
            return;
        }
        Integer hTMLSkipOffset = SkipOffsetManager.getHTMLSkipOffset(ad.getHtmlSkipOffset(), true);
        Integer videoSkipOffset = SkipOffsetManager.getVideoSkipOffset(this.mAd.getVideoSkipOffset(), null, null, Boolean.valueOf(hasEndCard()), true);
        if (hTMLSkipOffset != null) {
            this.mHtmlSkipOffset = new SkipOffset(hTMLSkipOffset.intValue(), SkipOffsetManager.isCustomInterstitialHTMLSkipOffset().booleanValue());
        }
        if (videoSkipOffset != null) {
            this.mVideoSkipOffset = new SkipOffset(videoSkipOffset.intValue(), SkipOffsetManager.isCustomInterstitialVideoSkipOffset().booleanValue());
        }
    }

    public void prepareVideoTag(String str) {
        prepareVideoTag("", str);
    }

    public void prepareVideoTag(final String str, String str2) {
        final String url = VastUrlUtils.formatURL(str2);
        HashMap map = new HashMap();
        String userAgent = HyBid.getDeviceInfo().getUserAgent();
        if (!TextUtils.isEmpty(userAgent)) {
            map.put("User-Agent", userAgent);
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        PNHttpClient.makeRequest(this.mContext, url, map, null, new PNHttpClient.Listener() { // from class: net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd.3
            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onSuccess(String str3, Map<String, List<String>> map2) {
                HyBidInterstitialAd.this.registerAdRequest(url, str3, jCurrentTimeMillis);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                HyBidInterstitialAd.this.prepareCustomMarkup(str, str3);
            }

            @Override // net.pubnative.lite.sdk.network.PNHttpClient.Listener
            public void onFailure(Throwable th) {
                Logger.e(HyBidInterstitialAd.TAG, "Request failed: " + th.toString());
                HyBidInterstitialAd.this.invokeOnLoadFailed(new HyBidError(HyBidErrorCode.INVALID_ASSET));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerAdRequest(String str, String str2, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        JsonOperations.putJsonString(this.mPlacementParams, Reporting.Key.AD_REQUEST, str);
        JsonOperations.putJsonString(this.mPlacementParams, Reporting.Key.AD_RESPONSE, str2);
        JsonOperations.putJsonLong(this.mPlacementParams, Reporting.Key.RESPONSE_TIME, jCurrentTimeMillis);
        AdRequestRegistry.getInstance().setLastAdRequest(str, str2, jCurrentTimeMillis);
    }

    protected void invokeOnLoadFinished() {
        long jCurrentTimeMillis = -1;
        if (this.mInitialLoadTime != -1) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.mInitialLoadTime;
            JsonOperations.putJsonLong(this.mPlacementParams, Reporting.Key.TIME_TO_LOAD, jCurrentTimeMillis);
        }
        if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType("load");
            reportingEvent.setAdFormat("fullscreen");
            reportingEvent.setPlatform("android");
            RequestManager requestManager = this.mRequestManager;
            if (requestManager != null) {
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(requestManager.getIntegrationType()));
            }
            reportingEvent.setCustomInteger(Reporting.Key.TIME_TO_LOAD, jCurrentTimeMillis);
            Ad ad = this.mAd;
            if (ad != null) {
                reportingEvent.setImpId(ad.getSessionId());
                reportingEvent.setCampaignId(this.mAd.getCampaignId());
                reportingEvent.setConfigId(this.mAd.getConfigId());
            }
            reportingEvent.mergeJSONObject(getPlacementParams());
            HyBid.getReportingController().reportEvent(reportingEvent);
        }
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onInterstitialLoaded();
        }
    }

    protected void invokeOnLoadFailed(Throwable th) {
        long jCurrentTimeMillis = -1;
        if (this.mInitialLoadTime != -1) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.mInitialLoadTime;
            JsonOperations.putJsonLong(this.mPlacementParams, Reporting.Key.TIME_TO_LOAD_FAILED, jCurrentTimeMillis);
        }
        if (HyBid.getReportingController() != null && HyBid.isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType(Reporting.EventType.LOAD_FAIL);
            reportingEvent.setAdFormat("fullscreen");
            reportingEvent.setPlatform("android");
            RequestManager requestManager = this.mRequestManager;
            if (requestManager != null) {
                reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(requestManager.getIntegrationType()));
            }
            reportingEvent.setCustomInteger(Reporting.Key.TIME_TO_LOAD, jCurrentTimeMillis);
            Ad ad = this.mAd;
            if (ad != null) {
                reportingEvent.setImpId(ad.getSessionId());
                reportingEvent.setCampaignId(this.mAd.getCampaignId());
                reportingEvent.setConfigId(this.mAd.getConfigId());
            }
            reportingEvent.mergeJSONObject(getPlacementParams());
            HyBid.getReportingController().reportEvent(reportingEvent);
        }
        if (th instanceof HyBidError) {
            HyBidError hyBidError = (HyBidError) th;
            if (hyBidError.getErrorCode() == HyBidErrorCode.NO_FILL) {
                Logger.w(TAG, th.getMessage());
            } else {
                Logger.e(TAG, th.getMessage());
            }
            sendLoadTracker(Integer.valueOf(hyBidError.getErrorCode().getCode()));
        } else {
            sendLoadTracker(Integer.valueOf(HyBidErrorCode.UNKNOWN_ERROR.getCode()));
        }
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onInterstitialLoadFailed(th);
        }
    }

    protected void invokeOnClick() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onInterstitialClick();
        }
    }

    protected void invokeOnImpression() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onInterstitialImpression();
        }
    }

    protected void invokeOnDismissed() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onInterstitialDismissed();
        }
    }

    public void setVideoListener(VideoListener videoListener) {
        this.mVideoListener = videoListener;
    }

    public void setMediationVendor(String str) {
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null) {
            requestManager.setMediationVendor(str);
        }
        RequestManager requestManager2 = this.mORTBRequestManager;
        if (requestManager2 != null) {
            requestManager2.setMediationVendor(str);
        }
    }

    public void setMediation(boolean z) {
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null) {
            requestManager.setIntegrationType(z ? IntegrationType.MEDIATION : IntegrationType.STANDALONE);
        }
        RequestManager requestManager2 = this.mORTBRequestManager;
        if (requestManager2 != null) {
            requestManager2.setIntegrationType(z ? IntegrationType.MEDIATION : IntegrationType.STANDALONE);
        }
    }

    public boolean isAutoCacheOnLoad() {
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null) {
            return requestManager.isAutoCacheOnLoad();
        }
        return true;
    }

    public void setAutoCacheOnLoad(boolean z) {
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null) {
            requestManager.setAutoCacheOnLoad(z);
        }
        RequestManager requestManager2 = this.mORTBRequestManager;
        if (requestManager2 != null) {
            requestManager2.setAutoCacheOnLoad(z);
        }
    }

    @Override // net.pubnative.lite.sdk.api.RequestManager.RequestListener
    public void onRequestSuccess(Ad ad) {
        if (ad == null) {
            invokeOnLoadFailed(new HyBidError(HyBidErrorCode.NULL_AD));
            return;
        }
        this.mAd = ad;
        initializeAdTracker();
        checkRemoteConfigs();
        renderAd();
    }

    @Override // net.pubnative.lite.sdk.api.RequestManager.RequestListener
    public void onRequestFail(Throwable th) {
        invokeOnLoadFailed(th);
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter.Listener
    public void onInterstitialLoaded(InterstitialPresenter interstitialPresenter) {
        this.mReady = true;
        invokeOnLoadFinished();
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter.Listener
    public void onInterstitialError(InterstitialPresenter interstitialPresenter) {
        invokeOnLoadFailed(new HyBidError(HyBidErrorCode.ERROR_RENDERING_INTERSTITIAL));
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter.Listener
    public void onInterstitialShown(InterstitialPresenter interstitialPresenter) {
        if (this.mInitialRenderTime != -1) {
            addReportingKey(Reporting.Key.RENDER_TIME, Long.valueOf(System.currentTimeMillis() - this.mInitialRenderTime));
        }
        reportAdRender("fullscreen", getPlacementParams());
        String str = this.mZoneId;
        if (str != null && !TextUtils.isEmpty(str) && this.mContext != null) {
            new SessionImpressionPrefs(this.mContext).insert(this.mZoneId);
        }
        invokeOnImpression();
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter.Listener
    public void onInterstitialClicked(InterstitialPresenter interstitialPresenter) {
        invokeOnClick();
    }

    @Override // net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenter.Listener
    public void onInterstitialDismissed(InterstitialPresenter interstitialPresenter) {
        invokeOnDismissed();
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoError(int i) {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoError(i);
        }
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoStarted() {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoStarted();
        }
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoDismissed(int i) {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoDismissed(i);
        }
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoFinished() {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoFinished();
        }
    }

    @Override // net.pubnative.lite.sdk.VideoListener
    public void onVideoSkipped() {
        VideoListener videoListener = this.mVideoListener;
        if (videoListener != null) {
            videoListener.onVideoSkipped();
        }
    }

    private void addReportingKey(String str, Object obj) {
        JSONObject jSONObject = this.mPlacementParams;
        if (jSONObject != null) {
            if (obj instanceof Long) {
                JsonOperations.putJsonLong(jSONObject, str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Integer) {
                JsonOperations.putJsonValue(jSONObject, str, (Integer) obj);
            } else if (obj instanceof Double) {
                JsonOperations.putJsonValue(jSONObject, str, (Double) obj);
            } else {
                JsonOperations.putJsonString(jSONObject, str, obj.toString());
            }
        }
    }

    public void reportAdRender(String str, JSONObject jSONObject) {
        if (HyBid.getReportingController() == null || !HyBid.isReportingEnabled().booleanValue()) {
            return;
        }
        ReportingEvent reportingEvent = new ReportingEvent();
        reportingEvent.setEventType(Reporting.EventType.RENDER);
        reportingEvent.setAdFormat(str);
        reportingEvent.setPlatform("android");
        RequestManager requestManager = this.mRequestManager;
        if (requestManager != null) {
            reportingEvent.setSdkVersion(HyBid.getSDKVersionInfo(requestManager.getIntegrationType()));
        }
        reportingEvent.setHasEndCard(hasEndCard());
        Ad ad = this.mAd;
        if (ad != null) {
            reportingEvent.setImpId(ad.getSessionId());
            reportingEvent.setCampaignId(this.mAd.getCampaignId());
            reportingEvent.setConfigId(this.mAd.getConfigId());
        }
        reportingEvent.mergeJSONObject(jSONObject);
        HyBid.getReportingController().reportEvent(reportingEvent);
    }

    public boolean hasEndCard() {
        Ad ad = this.mAd;
        if (ad != null) {
            return AdEndCardManager.isEndCardEnabled(ad).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeAdTracker() {
        if (this.mAd != null) {
            this.mAdTracker = new AdTracker(null, null, this.mAd.getBeacons(Ad.Beacon.SDK_EVENT), null, null);
        }
    }

    private void sendLoadTracker(Integer num) {
        AdTracker adTracker = this.mAdTracker;
        if (adTracker != null) {
            adTracker.trackSdkEvent(1, num);
        }
    }
}
