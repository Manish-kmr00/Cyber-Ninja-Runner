package com.smaato.sdk.core.mvvm.viewmodel;

import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.ad.AdType;
import com.smaato.sdk.core.ad.KeyValuePairs;
import com.smaato.sdk.core.linkhandler.LinkHandler$$ExternalSyntheticLambda4;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdRequest;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.openmeasurement.VideoProps;
import com.smaato.sdk.core.openmeasurement.ViewabilityTracker;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public abstract class SmaatoSdkViewModel {
    protected KeyValuePairs keyValuePairs;
    protected AdRequest lastAdRequest;
    protected AdResponse lastAdResponse;
    private final Logger logger;
    protected String mediationAdapterVersion;
    protected String mediationNetworkName;
    protected String mediationNetworkSDKVersion;
    protected Map<String, Object> objectExtras;
    protected ViewabilityTracker omViewabilityTracker;
    private Runnable onVideoImpressed;
    protected SmaatoSdkRepository smaatoSdkRepository;
    protected SmaatoSdkViewModelListener smaatoSdkViewModelListener;
    private Runnable ttlExpirationHandler;
    protected AdStatus adStatus = AdStatus.NOT_LOADED;
    protected final Handler uiHandler = Threads.newUiHandler();

    public void on100PercentVisible() {
    }

    public void on50PercentVisible() {
    }

    public abstract void onAdExpired();

    public void onCompanionAdImpressed() {
    }

    public abstract void onRichMediaAdRendererProcessGone();

    public void onRichMediaWebViewCollapsed() {
    }

    public void onRichMediaWebViewExpanded() {
    }

    public void onRichMediaWebViewResized() {
    }

    public abstract void onRichMediaWebViewUnloaded();

    public abstract void onVideoPlayerBuildError(SomaException somaException);

    protected SmaatoSdkViewModel(SmaatoSdkRepository smaatoSdkRepository, Logger logger) {
        this.smaatoSdkRepository = smaatoSdkRepository;
        this.logger = logger;
    }

    public void setViewModelListener(SmaatoSdkViewModelListener smaatoSdkViewModelListener) {
        if (smaatoSdkViewModelListener == null) {
            throw new NullPointerException("'smaatoSdkViewModelListener' specified as non-null is null");
        }
        this.smaatoSdkViewModelListener = smaatoSdkViewModelListener;
    }

    public void setMediationNetworkName(String str) {
        this.mediationNetworkName = str;
    }

    public void setMediationNetworkSDKVersion(String str) {
        this.mediationNetworkSDKVersion = str;
    }

    public void setMediationAdapterVersion(String str) {
        this.mediationAdapterVersion = str;
    }

    public KeyValuePairs getKeyValuePairs() {
        return this.keyValuePairs;
    }

    public void setKeyValuePairs(KeyValuePairs keyValuePairs) {
        this.keyValuePairs = keyValuePairs;
    }

    public void setObjectExtras(Map<String, Object> map) {
        this.objectExtras = map;
    }

    public String getSessionId() {
        AdResponse adResponse = this.lastAdResponse;
        if (adResponse != null) {
            return adResponse.getSessionId();
        }
        return null;
    }

    public String getCreativeId() {
        AdResponse adResponse = this.lastAdResponse;
        if (adResponse != null) {
            return adResponse.getSci();
        }
        return null;
    }

    public String getBundleId() {
        AdResponse adResponse = this.lastAdResponse;
        if (adResponse != null) {
            return adResponse.getBundleId();
        }
        return null;
    }

    public String getAdSpaceId() {
        AdRequest adRequest = this.lastAdRequest;
        if (adRequest != null) {
            return adRequest.getAdSpaceId();
        }
        return null;
    }

    public void onAdImpressed() {
        AdResponse adResponse = this.lastAdResponse;
        if (adResponse != null) {
            handleTrackerUrls(adResponse.getImpressionTrackingUrls());
        }
        this.adStatus = AdStatus.DISPLAYED;
        AdResponse adResponse2 = this.lastAdResponse;
        if (adResponse2 == null || adResponse2.getAdType() != AdType.RICH_MEDIA) {
            this.smaatoSdkRepository.trackOMImpression(this.omViewabilityTracker);
            Objects.onNotNull(this.onVideoImpressed, new LinkHandler$$ExternalSyntheticLambda4());
        }
    }

    public void reportRichMediaAdViolation(String str, String str2) {
        AdResponse adResponse;
        if (str == null) {
            throw new NullPointerException("'violationType' specified as non-null is null");
        }
        if (this.lastAdRequest == null || (adResponse = this.lastAdResponse) == null || adResponse.getRichMediaContent() == null) {
            return;
        }
        SmaatoSdkRepository smaatoSdkRepository = this.smaatoSdkRepository;
        if (str2 == null) {
            str2 = "";
        }
        smaatoSdkRepository.reportRichMediaAdViolation(str, str2, this.lastAdRequest.getAdSpaceId(), this.lastAdResponse.getRichMediaContent(), this.lastAdResponse.getClickTrackingUrls(), this.lastAdResponse.getSessionId(), this.lastAdResponse.getSci());
    }

    public void executeCtaLink(String str, final Consumer<Boolean> consumer) {
        AdResponse adResponse = this.lastAdResponse;
        if (adResponse == null) {
            Objects.onNotNull(consumer, new Consumer() { // from class: com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(Boolean.FALSE);
                }
            });
            return;
        }
        if (str == null) {
            str = adResponse.getClickUrl();
        }
        if (str == null) {
            Objects.onNotNull(consumer, new Consumer() { // from class: com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(Boolean.FALSE);
                }
            });
        } else {
            handleLink(str, new Consumer() { // from class: com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel$$ExternalSyntheticLambda5
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5566x58904763(consumer, (Boolean) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$executeCtaLink$3$com-smaato-sdk-core-mvvm-viewmodel-SmaatoSdkViewModel, reason: not valid java name */
    /* synthetic */ void m5566x58904763(Consumer consumer, final Boolean bool) {
        if (bool.booleanValue()) {
            onExecuteCtaLinkSuccess();
        }
        Objects.onNotNull(consumer, new Consumer() { // from class: com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(bool);
            }
        });
    }

    public void handleLink(String str, Consumer<Boolean> consumer) {
        if (str == null) {
            this.logger.error(LogDomain.CORE, "Link url is null", new Object[0]);
            consumer.accept(Boolean.FALSE);
        } else {
            this.smaatoSdkRepository.handleLink(str, consumer);
        }
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$ad$AdType;

        static {
            int[] iArr = new int[AdType.values().length];
            $SwitchMap$com$smaato$sdk$core$ad$AdType = iArr;
            try {
                iArr[AdType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdType[AdType.RICH_MEDIA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$ad$AdType[AdType.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void onAdContentViewCreated(AdContentView adContentView, AdType adType) {
        if (this.lastAdResponse != null) {
            int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$core$ad$AdType[adType.ordinal()];
            if (i == 1) {
                startOmImageAdTracking(adContentView);
            } else {
                if (i != 3) {
                    return;
                }
                startOmVideoAdTracking(adContentView);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$onFailedToCreateContentView$4$com-smaato-sdk-core-mvvm-viewmodel-SmaatoSdkViewModel, reason: not valid java name */
    /* synthetic */ void m5567xb228e820(String str) {
        this.logger.error(LogDomain.CORE, "Failed to create content view: " + str, new Object[0]);
    }

    public void onFailedToCreateContentView(Exception exc) {
        Objects.onNotNull(exc.getMessage(), new Consumer() { // from class: com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5567xb228e820((String) obj);
            }
        });
    }

    public void onRichMediaWebViewLoaded(AdContentView adContentView) {
        startOmWebViewTracking(adContentView);
    }

    public void registerFriendlyObstruction(View view) {
        if (view == null) {
            throw new NullPointerException("'view' specified as non-null is null");
        }
        this.smaatoSdkRepository.registerFriendlyObstruction(this.omViewabilityTracker, view);
    }

    public void removeFriendlyObstruction(View view) {
        if (view == null) {
            throw new NullPointerException("'view' specified as non-null is null");
        }
        this.smaatoSdkRepository.removeFriendlyObstruction(this.omViewabilityTracker, view);
    }

    public void onUpdateAdView(WebView webView) {
        this.smaatoSdkRepository.trackOMUpdateView(this.omViewabilityTracker, webView);
    }

    public void onVideoTrackLoaded(VideoProps videoProps) {
        this.smaatoSdkRepository.trackOMVideoPlayerStateChange(this.omViewabilityTracker);
        this.smaatoSdkRepository.trackOMVideoPlayerLoaded(this.omViewabilityTracker, videoProps);
    }

    public void stopOMVideoTracking() {
        this.smaatoSdkRepository.stopOMTracking(this.omViewabilityTracker);
    }

    public void onVideoClicked() {
        operationsForVideoAndCompanionClick();
    }

    public void onVideoStarted(float f, float f2, Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("'onVideoImpressed' specified as non-null is null");
        }
        this.smaatoSdkRepository.trackOMVideoStarted(this.omViewabilityTracker, f, f2);
        this.onVideoImpressed = runnable;
        if (this.adStatus == AdStatus.DISPLAYED) {
            runnable.run();
        }
    }

    public void onVideoFirstQuartileReached() {
        this.smaatoSdkRepository.trackVideoFirstQuartileReached(this.omViewabilityTracker);
    }

    public void onVideoMidpointReached() {
        this.smaatoSdkRepository.trackVideoMidpointReached(this.omViewabilityTracker);
    }

    public void onVideoThirdQuartileReached() {
        this.smaatoSdkRepository.trackVideoThirdQuartileReached(this.omViewabilityTracker);
    }

    public void onVideoCompleted() {
        this.smaatoSdkRepository.trackVideoCompleted(this.omViewabilityTracker);
    }

    public void onVideoPaused() {
        this.smaatoSdkRepository.trackVideoPaused(this.omViewabilityTracker);
    }

    public void onVideoResumed() {
        this.smaatoSdkRepository.trackVideoResumed(this.omViewabilityTracker);
    }

    public void onMuteClicked() {
        this.smaatoSdkRepository.trackMute(this.omViewabilityTracker);
    }

    public void onUnmuteClicked() {
        this.smaatoSdkRepository.trackUnmute(this.omViewabilityTracker);
    }

    public void onVideoSkipped() {
        this.smaatoSdkRepository.trackVideoSkipped(this.omViewabilityTracker);
    }

    public void onCompanionAdClicked() {
        operationsForVideoAndCompanionClick();
    }

    public void operationsForVideoAndCompanionClick() {
        this.smaatoSdkRepository.trackOMVideoClicked(this.omViewabilityTracker);
    }

    protected void onLoadAd() {
        this.adStatus = AdStatus.LOADING;
    }

    protected void onAdLoadingSucceeded() {
        this.adStatus = AdStatus.LOADED;
    }

    protected void onAdLoadingFailed() {
        this.adStatus = AdStatus.NOT_LOADED;
    }

    protected synchronized void startTtlTimer(Long l) {
        try {
            if (l == null) {
                this.logger.warning(LogDomain.CORE, "No TTL for ad!", new Object[0]);
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5568x2ce33b91();
                }
            };
            this.ttlExpirationHandler = runnable;
            this.uiHandler.postDelayed(runnable, l.longValue());
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: lambda$startTtlTimer$5$com-smaato-sdk-core-mvvm-viewmodel-SmaatoSdkViewModel, reason: not valid java name */
    /* synthetic */ void m5568x2ce33b91() {
        this.adStatus = AdStatus.EXPIRED;
        this.ttlExpirationHandler = null;
        onAdExpired();
    }

    protected AdRequest createAdRequest(String str, AdFormat adFormat, String str2) {
        if (str == null) {
            throw new NullPointerException("'adSpaceId' specified as non-null is null");
        }
        if (adFormat != null) {
            return AdRequest.builder().setAdSpaceId(str).setAdFormat(adFormat).setUBUniqueId(str2).setKeyValuePairs(this.keyValuePairs).setObjectExtras(this.objectExtras).setMediationAdapterVersion(this.mediationAdapterVersion).setMediationNetworkName(this.mediationNetworkName).setMediationNetworkSdkVersion(this.mediationNetworkSDKVersion).setOnCsmAdClicked(new Runnable() { // from class: com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onExecuteCtaLinkSuccess();
                }
            }).setOnCsmAdExpired(new Runnable() { // from class: com.smaato.sdk.core.mvvm.viewmodel.SmaatoSdkViewModel$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onAdExpired();
                }
            }).build();
        }
        throw new NullPointerException("'adFormat' specified as non-null is null");
    }

    protected boolean notifyViewModelListener(AdResponse adResponse) {
        if (adResponse == null) {
            throw new NullPointerException("'adResponse' specified as non-null is null");
        }
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$core$ad$AdType[adResponse.getAdType().ordinal()];
        if (i == 1) {
            if (adResponse.getImageBitmap() != null) {
                this.smaatoSdkViewModelListener.onImageAdLoaded(adResponse.getImageBitmap(), adResponse.getWidth().intValue(), adResponse.getHeight().intValue(), adResponse.getExtensions(), adResponse.getImpressionCountingType());
                return true;
            }
            if (adResponse.getCsmObject() == null) {
                return false;
            }
            this.smaatoSdkViewModelListener.onCsmAdObjectLoaded(adResponse.getCsmObject(), adResponse.getImpressionCountingType());
            return true;
        }
        if (i == 2) {
            if (adResponse.getRichMediaContent() == null) {
                return false;
            }
            this.smaatoSdkViewModelListener.onRichMediaAdLoaded(adResponse.getRichMediaContent(), adResponse.getWidth().intValue(), adResponse.getHeight().intValue(), adResponse.getImpressionCountingType());
            return true;
        }
        if (i != 3 || adResponse.getVastObject() == null) {
            return false;
        }
        this.smaatoSdkViewModelListener.onVideoAdLoaded(adResponse.getVastObject(), adResponse.getImpressionCountingType());
        return true;
    }

    protected void onExecuteCtaLinkSuccess() {
        AdResponse adResponse = this.lastAdResponse;
        if (adResponse != null) {
            handleTrackerUrls(adResponse.getClickTrackingUrls());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void stopTTLTimer() {
        Runnable runnable = this.ttlExpirationHandler;
        if (runnable != null) {
            this.uiHandler.removeCallbacks(runnable);
            this.ttlExpirationHandler = null;
        }
    }

    private void startOmImageAdTracking(AdContentView adContentView) {
        if (this.lastAdResponse != null) {
            ViewabilityTracker oMImageViewabilityTracker = this.smaatoSdkRepository.getOMImageViewabilityTracker(adContentView);
            this.omViewabilityTracker = oMImageViewabilityTracker;
            this.smaatoSdkRepository.trackOMAdLoaded(oMImageViewabilityTracker);
        }
    }

    private void startOmWebViewTracking(AdContentView adContentView) {
        ViewabilityTracker oMWebViewabilityTracker = this.smaatoSdkRepository.getOMWebViewabilityTracker(adContentView);
        this.omViewabilityTracker = oMWebViewabilityTracker;
        this.smaatoSdkRepository.trackOMAdLoaded(oMWebViewabilityTracker);
        this.smaatoSdkRepository.trackOMImpression(this.omViewabilityTracker);
    }

    private void startOmVideoAdTracking(AdContentView adContentView) {
        this.omViewabilityTracker = this.smaatoSdkRepository.getOMVideoViewabilityTracker(adContentView);
    }

    private void handleTrackerUrls(List<String> list) {
        if (list == null) {
            throw new NullPointerException("'trackerUrls' specified as non-null is null");
        }
        AdRequest adRequest = this.lastAdRequest;
        if (adRequest == null || this.lastAdResponse == null) {
            return;
        }
        this.smaatoSdkRepository.handleTrackerUrlsAndReportFailures(list, adRequest.getAdSpaceId(), this.lastAdResponse.getSessionId(), this.lastAdResponse.getSci());
    }
}
