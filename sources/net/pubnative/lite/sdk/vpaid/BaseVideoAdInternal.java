package net.pubnative.lite.sdk.vpaid;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.HyBidError;
import net.pubnative.lite.sdk.HyBidErrorCode;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.CustomCTAData;
import net.pubnative.lite.sdk.models.CustomEndCardDisplay;
import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.presenter.AdPresenter;
import net.pubnative.lite.sdk.utils.AdCustomCTAManager;
import net.pubnative.lite.sdk.utils.AdEndCardManager;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.PNBitmapDownloader;
import net.pubnative.lite.sdk.viewability.HyBidViewabilityNativeVideoAdSession;
import net.pubnative.lite.sdk.vpaid.enums.VastError;
import net.pubnative.lite.sdk.vpaid.helpers.AssetsLoader;
import net.pubnative.lite.sdk.vpaid.helpers.ErrorLog;
import net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer;
import net.pubnative.lite.sdk.vpaid.models.vpaid.AdSpotDimensions;
import net.pubnative.lite.sdk.vpaid.response.AdParams;
import net.pubnative.lite.sdk.vpaid.response.VastProcessor;

/* JADX INFO: loaded from: classes4.dex */
abstract class BaseVideoAdInternal {
    private static final String LOG_TAG = "BaseVideoAdInternal";
    protected final boolean isFullscreen;
    private final boolean isInterstitial;
    private Ad mAd;
    private AdCloseButtonListener mAdCloseButtonListener;
    private VideoAdController mAdController;
    private long mAdLoadingStartTime;
    private int mAdState;
    private final AssetsLoader mAssetsLoader;
    private VideoAdCacheItem mCacheItem;
    private CloseButtonListener mCloseButtonListener;
    private final Context mContext;
    private SimpleTimer mExpirationTimer;
    private SimpleTimer mFetcherTimer;
    AdPresenter.ImpressionListener mImpressionListener;
    private boolean mIsReady;
    private SimpleTimer mPrepareTimer;
    private final String mVastData;
    private VideoAdListener mVideoAdListener;
    private final HyBidViewabilityNativeVideoAdSession mViewabilityAdSession;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsRewarded = false;

    abstract void dismiss();

    abstract int getAdFormat();

    abstract AdSpotDimensions getAdSpotDimensions();

    BaseVideoAdInternal(Context context, Ad ad, boolean z, boolean z2, AdPresenter.ImpressionListener impressionListener, AdCloseButtonListener adCloseButtonListener) throws Exception {
        String vast = ad.getVast();
        if (context == null || TextUtils.isEmpty(vast)) {
            throw new HyBidError(HyBidErrorCode.VAST_PLAYER_ERROR);
        }
        this.mAd = ad;
        this.mAdState = 200;
        this.mContext = context;
        this.mVastData = vast;
        this.mAssetsLoader = new AssetsLoader();
        this.isInterstitial = z;
        this.isFullscreen = z2;
        this.mViewabilityAdSession = new HyBidViewabilityNativeVideoAdSession(HyBid.getViewabilityManager());
        this.mImpressionListener = impressionListener;
        this.mAdCloseButtonListener = adCloseButtonListener;
    }

    Ad getAd() {
        return this.mAd;
    }

    Context getContext() {
        return this.mContext;
    }

    VideoAdListener getAdListener() {
        return this.mVideoAdListener;
    }

    void setAdListener(VideoAdListener videoAdListener) {
        this.mVideoAdListener = videoAdListener;
    }

    VideoAdController getAdController() {
        return this.mAdController;
    }

    int getAdState() {
        return this.mAdState;
    }

    void setAdState(int i) {
        this.mAdState = i;
    }

    boolean isReady() {
        return this.mIsReady;
    }

    boolean isRewarded() {
        return this.mIsRewarded;
    }

    public Boolean isInterstitial() {
        return Boolean.valueOf(this.isInterstitial);
    }

    void setRewarded(boolean z) {
        this.mIsRewarded = z;
    }

    void setAdCloseButtonListener(CloseButtonListener closeButtonListener) {
        this.mCloseButtonListener = closeButtonListener;
    }

    public void setVideoCacheItem(VideoAdCacheItem videoAdCacheItem) {
        this.mCacheItem = videoAdCacheItem;
    }

    void initAdLoadingStartTime() {
        this.mAdLoadingStartTime = System.currentTimeMillis();
    }

    void setReady() {
        this.mIsReady = false;
    }

    protected HyBidViewabilityNativeVideoAdSession getViewabilityAdSession() {
        return this.mViewabilityAdSession;
    }

    protected VideoAdCacheItem getCacheItem() {
        return this.mCacheItem;
    }

    void releaseAdController() {
        Logger.d(LOG_TAG, "Release ViewControllerVast");
        VideoAdController videoAdController = this.mAdController;
        if (videoAdController != null) {
            videoAdController.destroy();
            this.mAdController = null;
        }
    }

    void runOnUiThread(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    private void startExpirationTimer() {
        if (this.mExpirationTimer != null) {
            return;
        }
        SimpleTimer simpleTimer = new SimpleTimer(600000L, new SimpleTimer.Listener() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal.1
            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onTick(long j) {
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onFinish() {
                BaseVideoAdInternal.this.onAdExpired();
            }
        });
        this.mExpirationTimer = simpleTimer;
        simpleTimer.start();
        Logger.d(LOG_TAG, "Start schedule expiration");
    }

    void stopExpirationTimer() {
        if (this.mExpirationTimer != null) {
            Logger.d(LOG_TAG, "Stop schedule expiration");
            this.mExpirationTimer.cancel();
            this.mExpirationTimer = null;
        }
    }

    private void startPrepareTimer() {
        if (this.mPrepareTimer != null) {
            return;
        }
        SimpleTimer simpleTimer = new SimpleTimer(15000L, new SimpleTimer.Listener() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal.2
            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onTick(long j) {
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onFinish() {
                BaseVideoAdInternal.this.mPrepareTimer = null;
                if (BaseVideoAdInternal.this.mAdController != null && (BaseVideoAdInternal.this.mAdController instanceof VideoAdControllerVpaid)) {
                    ErrorLog.postError(BaseVideoAdInternal.this.getContext(), VastError.FILE_NOT_FOUND);
                    BaseVideoAdInternal.this.m9841xa06e744c(new PlayerInfo("Problem with js file"));
                }
                BaseVideoAdInternal.this.cancelFetcher();
            }
        });
        this.mPrepareTimer = simpleTimer;
        simpleTimer.start();
        Logger.d(LOG_TAG, "Start prepare timer");
    }

    private void stopPrepareTimer() {
        Logger.d(LOG_TAG, "Stop prepare timer");
        SimpleTimer simpleTimer = this.mPrepareTimer;
        if (simpleTimer != null) {
            simpleTimer.cancel();
            this.mPrepareTimer = null;
        }
    }

    void proceedLoad(IntegrationType integrationType) {
        VideoAdCacheItem videoAdCacheItem = this.mCacheItem;
        if (videoAdCacheItem != null) {
            prepare(videoAdCacheItem.getAdParams(), this.mVastData, integrationType);
        } else {
            fetchAd(integrationType);
        }
    }

    void startFetcherTimer() {
        if (this.mFetcherTimer != null) {
            return;
        }
        SimpleTimer simpleTimer = new SimpleTimer(180000L, new SimpleTimer.Listener() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal.3
            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onTick(long j) {
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onFinish() {
                BaseVideoAdInternal.this.cancelFetcher();
                ErrorLog.postError(BaseVideoAdInternal.this.getContext(), VastError.TIMEOUT);
                BaseVideoAdInternal.this.m9841xa06e744c(new PlayerInfo("Ad processing timeout"));
            }
        });
        this.mFetcherTimer = simpleTimer;
        simpleTimer.start();
        Logger.d(LOG_TAG, "Start fetcher timer");
    }

    void stopFetcherTimer() {
        Logger.d(LOG_TAG, "Stop fetcher timer");
        SimpleTimer simpleTimer = this.mFetcherTimer;
        if (simpleTimer != null) {
            simpleTimer.cancel();
            this.mFetcherTimer = null;
        }
    }

    void cancelFetcher() {
        Logger.d(LOG_TAG, "Cancel ad fetcher");
        this.mAssetsLoader.breakLoading();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void fetchAd(final IntegrationType integrationType) {
        new VastProcessor(getContext(), getAdSpotDimensions()).parseResponse(this.mVastData, new VastProcessor.Listener() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal.4
            @Override // net.pubnative.lite.sdk.vpaid.response.VastProcessor.Listener
            public void onParseSuccess(AdParams adParams, String str) {
                BaseVideoAdInternal.this.prepare(adParams, str, integrationType);
            }

            @Override // net.pubnative.lite.sdk.vpaid.response.VastProcessor.Listener
            public void onParseError(PlayerInfo playerInfo) {
                BaseVideoAdInternal.this.onAdLoadFailInternal(playerInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepare(final AdParams adParams, String str, final IntegrationType integrationType) {
        if (adParams.isVpaid()) {
            ErrorLog.postError(getContext(), VastError.VAST_VERSION_NOT_SUPPORTED);
            m9841xa06e744c(new PlayerInfo("Unsupported ad format"));
            return;
        }
        final CustomCTAData customCTAData = getCustomCTAData();
        if (customCTAData != null && customCTAData.getIconURL() != null) {
            new PNBitmapDownloader().download(customCTAData.getIconURL(), new PNBitmapDownloader.DownloadListener() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal.5
                @Override // net.pubnative.lite.sdk.utils.PNBitmapDownloader.DownloadListener
                public void onDownloadFinish(String str2, Bitmap bitmap) {
                    if (bitmap != null) {
                        customCTAData.setBitmap(bitmap);
                    }
                    BaseVideoAdInternal.this.prepareAdController(adParams, integrationType, customCTAData);
                }

                @Override // net.pubnative.lite.sdk.utils.PNBitmapDownloader.DownloadListener
                public void onDownloadFailed(String str2, Exception exc) {
                    BaseVideoAdInternal.this.prepareAdController(adParams, integrationType, (CustomCTAData) null);
                }
            });
        } else {
            prepareAdController(adParams, integrationType, (CustomCTAData) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareAdController(AdParams adParams, IntegrationType integrationType, CustomCTAData customCTAData) {
        if (customCTAData == null) {
            customCTAData = getCustomCTAData();
        }
        this.mAdController = new VideoAdControllerVast(this, adParams, getViewabilityAdSession(), this.isFullscreen, this.mImpressionListener, this.mAdCloseButtonListener, customCTAData, getCustomCTADelay(), integrationType);
        VideoAdCacheItem videoAdCacheItem = this.mCacheItem;
        if (videoAdCacheItem != null) {
            prepareAdController(videoAdCacheItem.getVideoFilePath(), this.mCacheItem.getEndCardData(), this.mCacheItem.getEndCardFilePath());
        } else {
            this.mAssetsLoader.load(adParams, this.mContext, createAssetsLoadListener());
        }
    }

    private Integer getCustomCTADelay() {
        return getAd() != null ? AdCustomCTAManager.getCustomCtaDelay(getAd()) : AdCustomCTAManager.CUSTOM_CTA_DELAY_DEFAULT;
    }

    private CustomCTAData getCustomCTAData() {
        if (getAd() == null || !AdCustomCTAManager.isAbleShow(getAd()).booleanValue()) {
            return null;
        }
        return getAd().getCustomCta(getContext());
    }

    private AssetsLoader.OnAssetsLoaded createAssetsLoadListener() {
        return new AssetsLoader.OnAssetsLoaded() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal.6
            @Override // net.pubnative.lite.sdk.vpaid.helpers.AssetsLoader.OnAssetsLoaded
            public void onAssetsLoaded(String str, EndCardData endCardData, String str2) {
                BaseVideoAdInternal.this.prepareAdController(str, endCardData, str2);
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.AssetsLoader.OnAssetsLoaded
            public void onError(PlayerInfo playerInfo) {
                BaseVideoAdInternal.this.onAdLoadFailInternal(playerInfo);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareAdController(String str, EndCardData endCardData, String str2) {
        VideoAdController videoAdController = this.mAdController;
        if (videoAdController == null) {
            onAdLoadFailInternal(new PlayerInfo("Error during video loading"));
            ErrorLog.postError(getContext(), VastError.UNDEFINED);
            Logger.d(LOG_TAG, "VideoAdController == null, after onAssetsLoaded success");
            return;
        }
        videoAdController.setVideoFilePath(str);
        if (getAd() != null) {
            EndCardData customEndCard = getAd().getCustomEndCard();
            if (AdEndCardManager.shouldShowEndcard(getAd())) {
                this.mAdController.addEndCardData(endCardData);
                if (AdEndCardManager.shouldShowCustomEndcard(getAd()) && getAd().getCustomEndCardDisplay().equals(CustomEndCardDisplay.EXTENSION) && !customEndCard.getContent().isEmpty()) {
                    this.mAdController.addEndCardData(customEndCard);
                    this.mVideoAdListener.onAdCustomEndCardFound();
                }
            } else if (AdEndCardManager.shouldShowCustomEndcard(getAd()) && !customEndCard.getContent().isEmpty()) {
                this.mAdController.addEndCardData(customEndCard);
                this.mVideoAdListener.onAdCustomEndCardFound();
            }
        }
        this.mAdController.setEndCardFilePath(str2);
        runOnUiThread(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9842xeaaf5a45();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$prepareAdController$0$net-pubnative-lite-sdk-vpaid-BaseVideoAdInternal, reason: not valid java name */
    /* synthetic */ void m9842xeaaf5a45() {
        startPrepareTimer();
        this.mAdController.prepare(createOnPrepareListener());
    }

    private VideoAdController.OnPreparedListener createOnPrepareListener() {
        return new VideoAdController.OnPreparedListener() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal$$ExternalSyntheticLambda0
            @Override // net.pubnative.lite.sdk.vpaid.VideoAdController.OnPreparedListener
            public final void onPrepared() {
                this.f$0.m9840xac09d0a();
            }
        };
    }

    /* JADX INFO: renamed from: lambda$createOnPrepareListener$1$net-pubnative-lite-sdk-vpaid-BaseVideoAdInternal, reason: not valid java name */
    /* synthetic */ void m9840xac09d0a() {
        if (getAdState() == 202) {
            Logger.d(LOG_TAG, "Creative call unexpected AdLoaded");
        } else {
            stopPrepareTimer();
            onAdLoadSuccessInternal();
        }
    }

    void onAdLoadFailInternal(final PlayerInfo playerInfo) {
        runOnUiThread(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9841xa06e744c(playerInfo);
            }
        });
    }

    void onAdLoadSuccessInternal() {
        runOnUiThread(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onAdLoadSuccess();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdExpired() {
        Logger.d(LOG_TAG, "Ad content is expired");
        this.mExpirationTimer = null;
        this.mIsReady = false;
        this.mAdState = 200;
        this.mAssetsLoader.breakLoading();
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onAdExpired();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onAdLoadFail, reason: merged with bridge method [inline-methods] */
    public void m9841xa06e744c(PlayerInfo playerInfo) {
        String str = LOG_TAG;
        Logger.d(str, "Ad fails to load: " + playerInfo.getMessage());
        this.mAdState = 200;
        this.mIsReady = false;
        stopFetcherTimer();
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onAdLoadFail(playerInfo);
        } else {
            Logger.w(str, "Warning: empty listener");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadSuccess() {
        startExpirationTimer();
        long jCurrentTimeMillis = System.currentTimeMillis() - this.mAdLoadingStartTime;
        String str = LOG_TAG;
        Logger.d(str, "Ad successfully loaded (" + jCurrentTimeMillis + "ms)");
        this.mIsReady = true;
        this.mAdState = 200;
        stopFetcherTimer();
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onAdLoadSuccess();
        } else {
            Logger.w(str, "Warning: empty listener");
        }
    }

    void onAdDidReachEnd() {
        Logger.d(LOG_TAG, "Video reach end");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onAdDidReachEnd();
        }
    }

    void onAdLeaveApp() {
        Logger.d(LOG_TAG, "adLeaveApp");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onLeaveApp();
        }
    }

    void onAdClicked() {
        Logger.d(LOG_TAG, "Ad received click event");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onAdClicked();
        }
    }

    void onCustomEndCardShow(String str) {
        Logger.d(LOG_TAG, "Ad received custom end card impression event");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onCustomEndCardShow(str);
        }
    }

    void onDefaultEndCardShow(String str) {
        Logger.d(LOG_TAG, "Ad received custom end card impression event");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onDefaultEndCardShow(str);
        }
    }

    void onCustomEndCardClick(String str) {
        Logger.d(LOG_TAG, "Ad received custom end card click event");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onCustomEndCardClick(str);
        }
    }

    void onDefaultEndCardClick(String str) {
        Logger.d(LOG_TAG, "Ad received default end card click event");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onDefaultEndCardClick(str);
        }
    }

    void onCustomCTAClick(boolean z) {
        Logger.d(LOG_TAG, "Ad received custom CTA click event");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onCustomCTACLick(z);
        }
    }

    void onCustomCTAShow() {
        Logger.d(LOG_TAG, "Ad received custom CTA show event");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onCustomCTAShow();
        }
    }

    void onCustomCTALoadFail() {
        Logger.d(LOG_TAG, "Ad received custom CTA load fail event");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onCustomCTALoadFail();
        }
    }

    void onEndCardLoadSuccess(Boolean bool) {
        Logger.d(LOG_TAG, "EndCard loading success");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onEndCardLoadSuccess(bool);
        }
    }

    void onEndCardLoadFail(Boolean bool) {
        Logger.d(LOG_TAG, "EndCard loading failed");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onEndCardLoadFail(bool);
        }
    }

    void onAdSkipped() {
        Logger.d(LOG_TAG, "onAdSkipped");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onAdSkipped();
        }
    }

    void onAdCloseButtonVisible() {
        CloseButtonListener closeButtonListener = this.mCloseButtonListener;
        if (closeButtonListener != null) {
            closeButtonListener.onCloseButtonVisible();
        }
    }

    void onEndCardSkipped(Boolean bool) {
        Logger.d(LOG_TAG, "onEndCardSkipped");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onEndCardSkipped(bool);
        }
    }

    public void onEndCardClosed(Boolean bool) {
        Logger.d(LOG_TAG, "onEndCardClosed");
        VideoAdListener videoAdListener = this.mVideoAdListener;
        if (videoAdListener != null) {
            videoAdListener.onEndCardClosed(bool);
        }
    }
}
