package net.pubnative.lite.sdk.vpaid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.presenter.AdPresenter;
import net.pubnative.lite.sdk.utils.AdAudioStateManager;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.viewability.HyBidViewabilityFriendlyObstruction;
import net.pubnative.lite.sdk.vpaid.enums.AudioState;
import net.pubnative.lite.sdk.vpaid.models.vpaid.AdSpotDimensions;
import net.pubnative.lite.sdk.vpaid.utils.Utils;

/* JADX INFO: loaded from: classes11.dex */
public class VideoAd extends BaseVideoAd {
    private static final String LOG_TAG = "VideoAd";
    private volatile VideoAdView mBannerView;
    private boolean mIsAdStarted;
    VastActivityInteractor vastActivityInteractor;

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    int getAdFormat() {
        return 1000;
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd
    public /* bridge */ /* synthetic */ void clearCache() {
        super.clearCache();
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public /* bridge */ /* synthetic */ Boolean isInterstitial() {
        return super.isInterstitial();
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd
    public /* bridge */ /* synthetic */ boolean isLoading() {
        return super.isLoading();
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd, net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public /* bridge */ /* synthetic */ boolean isReady() {
        return super.isReady();
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd, net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public /* bridge */ /* synthetic */ boolean isRewarded() {
        return super.isRewarded();
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd
    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd
    public /* bridge */ /* synthetic */ void load(IntegrationType integrationType) {
        super.load(integrationType);
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public /* bridge */ /* synthetic */ void onEndCardClosed(Boolean bool) {
        super.onEndCardClosed(bool);
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd, net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public /* bridge */ /* synthetic */ void setAdCloseButtonListener(CloseButtonListener closeButtonListener) {
        super.setAdCloseButtonListener(closeButtonListener);
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd, net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public /* bridge */ /* synthetic */ void setAdListener(VideoAdListener videoAdListener) {
        super.setAdListener(videoAdListener);
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd
    public /* bridge */ /* synthetic */ void setDebugMode(boolean z) {
        super.setDebugMode(z);
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd, net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public /* bridge */ /* synthetic */ void setRewarded(boolean z) {
        super.setRewarded(z);
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public /* bridge */ /* synthetic */ void setVideoCacheItem(VideoAdCacheItem videoAdCacheItem) {
        super.setVideoCacheItem(videoAdCacheItem);
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd
    public /* bridge */ /* synthetic */ void useMobileNetworkForCaching(boolean z) {
        super.useMobileNetworkForCaching(z);
    }

    public VideoAd(Context context, Ad ad, boolean z, boolean z2, AdPresenter.ImpressionListener impressionListener) throws Exception {
        super(context, ad, z, z2, impressionListener, null);
        this.mIsAdStarted = false;
    }

    public VideoAd(Context context, Ad ad, boolean z, boolean z2, AdPresenter.ImpressionListener impressionListener, AdCloseButtonListener adCloseButtonListener) throws Exception {
        super(context, ad, z, z2, impressionListener, adCloseButtonListener);
        this.mIsAdStarted = false;
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    AdSpotDimensions getAdSpotDimensions() {
        if (this.mBannerView != null) {
            return new AdSpotDimensions(this.mBannerView.getWidth(), this.mBannerView.getHeight());
        }
        return null;
    }

    public void bindView(VideoAdView videoAdView) {
        if (videoAdView != null) {
            Logger.d(LOG_TAG, "Bind view (visibility: " + videoAdView.getVisibility() + ")");
            this.mBannerView = videoAdView;
        } else {
            Logger.e(LOG_TAG, "Bind view is null");
        }
    }

    public void show() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.vastActivityInteractor = VastActivityInteractor.getInstance();
        handler.postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.VideoAd.1
            @Override // java.lang.Runnable
            public void run() {
                VideoAd.this.runOnUiThread(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.VideoAd.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoAd.this.vastActivityInteractor.isDependentOnActivityLifecycle()) {
                            if (VideoAd.this.vastActivityInteractor.isActivityVisible()) {
                                showAd();
                                return;
                            }
                            return;
                        }
                        showAd();
                    }

                    private void showAd() {
                        Logger.d(VideoAd.LOG_TAG, "Banner did start showing ad");
                        if (VideoAd.this.getAdState() == 202) {
                            Logger.d(VideoAd.LOG_TAG, "Banner already displays on screen");
                            return;
                        }
                        if (VideoAd.this.isReady() && VideoAd.this.mBannerView != null) {
                            VideoAd.this.setAdState(202);
                            VideoAd.this.stopExpirationTimer();
                            if (VideoAd.this.getAdController() != null) {
                                synchronized (this) {
                                    if (VideoAd.this.getAdController() != null && VideoAd.this.getAdController().getAdParams() != null) {
                                        VideoAd.this.getViewabilityAdSession().initAdSession(VideoAd.this.mBannerView, VideoAd.this.getAdController().getAdParams().getVerificationScriptResources());
                                        VideoAd.this.getAdController().buildVideoAdView(VideoAd.this.mBannerView);
                                        for (HyBidViewabilityFriendlyObstruction hyBidViewabilityFriendlyObstruction : VideoAd.this.getAdController().getViewabilityFriendlyObstructions()) {
                                            VideoAd.this.getViewabilityAdSession().addFriendlyObstruction(hyBidViewabilityFriendlyObstruction.getView(), hyBidViewabilityFriendlyObstruction.getPurpose(), hyBidViewabilityFriendlyObstruction.getReason());
                                        }
                                        VideoAd.this.getViewabilityAdSession().fireLoaded();
                                        VideoAd.this.getAdController().playAd();
                                        VideoAd.this.validateAudioState();
                                    }
                                }
                            } else {
                                Logger.e(VideoAd.LOG_TAG, "getAdController() is null and can not set attributes to banner view ");
                                if (VideoAd.this.getAdListener() != null) {
                                    VideoAd.this.getAdListener().onAdLoadFail(new PlayerInfo("getAdController() is null and can not set attributes to banner view "));
                                }
                            }
                        } else {
                            Logger.e(VideoAd.LOG_TAG, "Banner is not ready");
                        }
                        VideoAd.this.mIsAdStarted = true;
                    }
                });
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateAudioState() {
        int i = AnonymousClass2.$SwitchMap$net$pubnative$lite$sdk$vpaid$enums$AudioState[AdAudioStateManager.getAudioState(getAd(), this.isFullscreen).ordinal()];
        if (i == 1 || i == 2 || (i == 3 && Utils.isPhoneMuted(getContext()))) {
            getAdController().toggleMute();
        }
    }

    /* JADX INFO: renamed from: net.pubnative.lite.sdk.vpaid.VideoAd$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$pubnative$lite$sdk$vpaid$enums$AudioState;

        static {
            int[] iArr = new int[AudioState.values().length];
            $SwitchMap$net$pubnative$lite$sdk$vpaid$enums$AudioState = iArr;
            try {
                iArr[AudioState.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$vpaid$enums$AudioState[AudioState.MUTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$pubnative$lite$sdk$vpaid$enums$AudioState[AudioState.ON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void onBannerHide() {
        Logger.d(LOG_TAG, "Ad disappeared from screen");
        setReady();
        setAdState(200);
        if (getAdListener() != null) {
            getAdListener().onAdDismissed(getAdController().getProgress());
        }
    }

    @Override // net.pubnative.lite.sdk.vpaid.BaseVideoAd, net.pubnative.lite.sdk.vpaid.BaseVideoAdInternal
    public void dismiss() {
        runOnUiThread(new Runnable() { // from class: net.pubnative.lite.sdk.vpaid.VideoAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9847lambda$dismiss$0$netpubnativelitesdkvpaidVideoAd();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$dismiss$0$net-pubnative-lite-sdk-vpaid-VideoAd, reason: not valid java name */
    /* synthetic */ void m9847lambda$dismiss$0$netpubnativelitesdkvpaidVideoAd() {
        String str = LOG_TAG;
        Logger.d(str, "Video will be dismissed");
        if (getAdState() == 202) {
            if (this.mBannerView != null) {
                this.mBannerView.setVisibility(8);
                this.mBannerView.removeAllViews();
            }
            if (getAdController() != null) {
                getAdController().dismiss();
            }
            onBannerHide();
            return;
        }
        Logger.e(str, "Can't dismiss ad, it's not displaying");
    }

    public void resume() {
        if (getAdController() == null || !isReady()) {
            return;
        }
        getAdController().resume();
    }

    public void resumeEndCardCloseButtonTimer() {
        Logger.d(LOG_TAG, "resume End Card Timer");
        if (getAdController() != null) {
            getAdController().resumeEndCardCloseButtonTimer();
        }
    }

    public void pauseEndCardCloseButtonTimer() {
        Logger.d(LOG_TAG, "pause End Card Timer");
        if (getAdController() != null) {
            getAdController().pauseEndCardCloseButtonTimer();
        }
    }

    public void pause() {
        if (getAdController() != null) {
            getAdController().pause();
        }
    }

    public boolean isAdStarted() {
        return this.mIsAdStarted;
    }

    public void skip() {
        getAdController().skipVideo();
    }

    public void closeVideo() {
        getAdController().closeSelf();
    }
}
