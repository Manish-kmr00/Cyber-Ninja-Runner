package com.smaato.sdk.banner.viewmodel;

import com.smaato.sdk.banner.ad.AutoReloadInterval;
import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.model.BannerAdRequest;
import com.smaato.sdk.banner.widget.BannerError;
import com.smaato.sdk.banner.widget.BannerView;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdRequest;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository;
import com.smaato.sdk.core.mvvm.viewmodel.AdStatus;
import com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.appbackground.AppBackgroundAwareScheduler;
import com.smaato.sdk.core.util.fi.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class BannerViewModel extends SmaatoSdkViewModel {
    private static final Map ERROR_MAP;
    Object appIsOnlineNotification;
    private AutoReloadInterval autoReloadInterval;
    AppBackgroundAwareScheduler autoReloadScheduler;
    private BannerView.EventListener bannerViewEventListener;
    private WeakReference bannerViewReference;
    private BannerAdRequest lastBannerAdRequest;
    private final Logger logger;
    private boolean reloadAdOnViewFocusChange;

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onVideoPlayerBuildError(SomaException somaException) {
    }

    static {
        HashMap map = new HashMap();
        ERROR_MAP = map;
        map.put(SomaException.Type.NO_CONTENT, BannerError.NO_AD_AVAILABLE);
        map.put(SomaException.Type.BAD_REQUEST, BannerError.INVALID_REQUEST);
        map.put(SomaException.Type.AGE_RESTRICTED_USER, BannerError.AGE_RESTRICTED);
        map.put(SomaException.Type.BAD_RESPONSE, BannerError.INTERNAL_ERROR);
        map.put(SomaException.Type.TIMEOUT_ERROR, BannerError.NETWORK_ERROR);
        map.put(SomaException.Type.CREATIVE_EXPIRED, BannerError.CREATIVE_RESOURCE_EXPIRED);
    }

    public BannerViewModel(SmaatoSdkRepository smaatoSdkRepository, Logger logger) {
        super(smaatoSdkRepository, logger);
        this.autoReloadInterval = AutoReloadInterval.DEFAULT;
        this.bannerViewReference = new WeakReference(null);
        this.bannerViewEventListener = new BannerView.EventListener() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel.1
        };
        this.logger = logger;
    }

    public BannerAdSize getBannerAdSize() {
        BannerAdRequest bannerAdRequest = this.lastBannerAdRequest;
        if (bannerAdRequest != null) {
            return bannerAdRequest.getBannerAdSize();
        }
        return null;
    }

    public AutoReloadInterval getAutoReloadInterval() {
        return this.autoReloadInterval;
    }

    public void setAutoReloadInterval(AutoReloadInterval autoReloadInterval) {
        this.autoReloadInterval = autoReloadInterval;
    }

    public void setBannerViewEventListener(BannerView.EventListener eventListener) {
        if (eventListener == null) {
            this.bannerViewEventListener = new BannerView.EventListener() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel.2
            };
        } else {
            this.bannerViewEventListener = eventListener;
        }
    }

    public void setBannerView(BannerView bannerView) {
        this.bannerViewReference = new WeakReference(bannerView);
    }

    public void loadAd(String str, AdFormat adFormat, BannerAdSize bannerAdSize, String str2) {
        if (this.adStatus == AdStatus.LOADING) {
            return;
        }
        this.reloadAdOnViewFocusChange = false;
        loadAd(new BannerAdRequest(createAdRequest(str, adFormat, str2), bannerAdSize));
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onAdImpressed() {
        super.onAdImpressed();
        stopTTLTimer();
        startAutoReload();
        final BannerView.EventListener eventListener = this.bannerViewEventListener;
        Objects.requireNonNull(eventListener);
        notifyBannerViewEventListener(new Consumer() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdImpression((BannerView) obj);
            }
        });
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void executeCtaLink(String str, final Consumer<Boolean> consumer) {
        stopAutoReload();
        super.executeCtaLink(str, new Consumer() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5506x1e910a9(consumer, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$executeCtaLink$2$com-smaato-sdk-banner-viewmodel-BannerViewModel, reason: not valid java name */
    /* synthetic */ void m5506x1e910a9(Consumer consumer, final Boolean bool) {
        if (bool.booleanValue()) {
            com.smaato.sdk.core.util.Objects.onNotNull(this.lastAdRequest, new Consumer() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5505x2d5dca7((AdRequest) obj);
                }
            });
        } else {
            AdRequest adRequest = this.lastAdRequest;
            if (adRequest != null && adRequest.getUBUniqueId() == null) {
                startReloadImmediately();
            }
        }
        com.smaato.sdk.core.util.Objects.onNotNull(consumer, new Consumer() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(bool);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$executeCtaLink$0$com-smaato-sdk-banner-viewmodel-BannerViewModel, reason: not valid java name */
    /* synthetic */ void m5505x2d5dca7(AdRequest adRequest) {
        this.reloadAdOnViewFocusChange = adRequest.getUBUniqueId() == null;
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onRichMediaWebViewExpanded() {
        stopAutoReload();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onRichMediaWebViewUnloaded() {
        if (TextUtils.isEmpty(this.mediationNetworkName)) {
            startReloadImmediately();
        } else {
            notifyBannerViewEventListener(BannerError.AD_UNLOADED);
        }
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onRichMediaWebViewResized() {
        stopAutoReload();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onRichMediaWebViewCollapsed() {
        startAutoReload();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onFailedToCreateContentView(Exception exc) {
        super.onFailedToCreateContentView(exc);
        notifyInternalError();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onRichMediaAdRendererProcessGone() {
        startReloadImmediately();
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onExecuteCtaLinkSuccess() {
        super.onExecuteCtaLinkSuccess();
        final BannerView.EventListener eventListener = this.bannerViewEventListener;
        Objects.requireNonNull(eventListener);
        notifyBannerViewEventListener(new Consumer() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdClicked((BannerView) obj);
            }
        });
    }

    @Override // com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel
    public void onAdExpired() {
        if (this.adStatus != AdStatus.DISPLAYED) {
            final BannerView.EventListener eventListener = this.bannerViewEventListener;
            Objects.requireNonNull(eventListener);
            notifyBannerViewEventListener(new Consumer() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda7
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    eventListener.onAdTTLExpired((BannerView) obj);
                }
            });
        }
    }

    public void onDestroy() {
        this.bannerViewReference = new WeakReference(null);
        this.smaatoSdkRepository.stopOMTracking(this.omViewabilityTracker);
        this.omViewabilityTracker = null;
        Object obj = this.appIsOnlineNotification;
        if (obj != null) {
            this.smaatoSdkRepository.cancelAppOnlineNotification(obj);
        }
        stopTTLTimer();
        stopAutoReload();
    }

    public void onWindowFocusChanged(boolean z) {
        if (z && this.reloadAdOnViewFocusChange) {
            startReloadImmediately();
        }
    }

    private void loadAd(BannerAdRequest bannerAdRequest) {
        super.onLoadAd();
        this.lastBannerAdRequest = bannerAdRequest;
        this.lastAdRequest = bannerAdRequest.getAdRequest();
        stopAutoReload();
        this.smaatoSdkRepository.loadAd(bannerAdRequest, new Consumer() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.onAdLoadingSucceeded((AdResponse) obj);
            }
        }, new Consumer() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.onAdLoadingFailed((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadingSucceeded(AdResponse adResponse) {
        super.onAdLoadingSucceeded();
        this.lastAdResponse = adResponse;
        if (notifyViewModelListener(adResponse)) {
            if (adResponse.getCsmObject() == null) {
                startTtlTimer(adResponse.getTtlMs());
            }
            final BannerView.EventListener eventListener = this.bannerViewEventListener;
            Objects.requireNonNull(eventListener);
            notifyBannerViewEventListener(new Consumer() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    eventListener.onAdLoaded((BannerView) obj);
                }
            });
            return;
        }
        notifyInternalError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadingFailed(Throwable th) {
        super.onAdLoadingFailed();
        this.smaatoSdkRepository.stopOMTracking(this.omViewabilityTracker);
        if (this.smaatoSdkRepository.appIsOnline()) {
            notifyBannerViewEventListener(getBannerError(th));
            startAutoReload();
        } else {
            notifyBannerViewEventListener(BannerError.NETWORK_ERROR);
            startReloadIfAppIsOnlineAgain();
        }
    }

    private BannerError getBannerError(Throwable th) {
        BannerError bannerError;
        if (th instanceof AdResponseParser.ParsingException) {
            bannerError = BannerError.INTERNAL_ERROR;
        } else {
            bannerError = th instanceof SomaException ? (BannerError) ERROR_MAP.get(((SomaException) th).getType()) : null;
        }
        return bannerError == null ? BannerError.NO_AD_AVAILABLE : bannerError;
    }

    private void startReloadIfAppIsOnlineAgain() {
        if (this.appIsOnlineNotification == null) {
            this.appIsOnlineNotification = this.smaatoSdkRepository.notifyIfAppIsOnline(new Runnable() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5508x85718635();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$startReloadIfAppIsOnlineAgain$3$com-smaato-sdk-banner-viewmodel-BannerViewModel, reason: not valid java name */
    /* synthetic */ void m5508x85718635() {
        this.smaatoSdkRepository.cancelAppOnlineNotification(this.appIsOnlineNotification);
        this.appIsOnlineNotification = null;
        startReloadImmediately();
    }

    private void notifyInternalError() {
        notifyBannerViewEventListener(BannerError.INTERNAL_ERROR);
    }

    private void notifyBannerViewEventListener(final BannerError bannerError) {
        notifyBannerViewEventListener(new Consumer() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5507x5f4a1150(bannerError, (BannerView) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$notifyBannerViewEventListener$4$com-smaato-sdk-banner-viewmodel-BannerViewModel, reason: not valid java name */
    /* synthetic */ void m5507x5f4a1150(BannerError bannerError, BannerView bannerView) {
        this.bannerViewEventListener.onAdFailedToLoad(bannerView, bannerError);
    }

    private void notifyBannerViewEventListener(final Consumer consumer) {
        final BannerView bannerView = (BannerView) this.bannerViewReference.get();
        if (bannerView != null) {
            Threads.ensureInvokedOnHandlerThread(this.uiHandler, new Runnable() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    consumer.accept(bannerView);
                }
            });
        }
    }

    private synchronized void startAutoReload() {
        if (this.autoReloadInterval == AutoReloadInterval.DISABLED) {
            return;
        }
        if (this.autoReloadScheduler == null) {
            AppBackgroundAwareScheduler appBackgroundAwareScheduler = new AppBackgroundAwareScheduler(createAdReloader());
            this.autoReloadScheduler = appBackgroundAwareScheduler;
            appBackgroundAwareScheduler.schedule(((long) this.autoReloadInterval.getSeconds()) * 1000);
        }
    }

    private synchronized void stopAutoReload() {
        AppBackgroundAwareScheduler appBackgroundAwareScheduler = this.autoReloadScheduler;
        if (appBackgroundAwareScheduler != null) {
            appBackgroundAwareScheduler.cancel();
            this.autoReloadScheduler = null;
        }
    }

    private synchronized void startReloadImmediately() {
        stopAutoReload();
        createAdReloader().run();
    }

    private Runnable createAdReloader() {
        return new Runnable() { // from class: com.smaato.sdk.banner.viewmodel.BannerViewModel$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5504x4d4ddbdd();
            }
        };
    }

    /* JADX INFO: renamed from: lambda$createAdReloader$6$com-smaato-sdk-banner-viewmodel-BannerViewModel, reason: not valid java name */
    /* synthetic */ void m5504x4d4ddbdd() {
        BannerAdRequest bannerAdRequest = this.lastBannerAdRequest;
        if (bannerAdRequest != null) {
            loadAd(bannerAdRequest);
        } else {
            this.logger.info(LogDomain.BANNER, "Skipping ad autoreload as last banner ad request is null", new Object[0]);
        }
    }
}
