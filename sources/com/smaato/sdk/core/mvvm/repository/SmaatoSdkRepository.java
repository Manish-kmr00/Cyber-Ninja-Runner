package com.smaato.sdk.core.mvvm.repository;

import android.view.View;
import android.webkit.WebView;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.api.ApiParams;
import com.smaato.sdk.core.gdpr.PiiParam;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.linkhandler.LinkHandler;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import com.smaato.sdk.core.mvvm.model.csm.CsmException;
import com.smaato.sdk.core.mvvm.model.csm.CsmParameters;
import com.smaato.sdk.core.mvvm.model.csm.CsmRemoteSource;
import com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource;
import com.smaato.sdk.core.mvvm.model.soma.SomaAdRequest;
import com.smaato.sdk.core.mvvm.model.soma.SomaRemoteSource;
import com.smaato.sdk.core.mvvm.model.ub.UbRemoteSource;
import com.smaato.sdk.core.network.NetworkStateMonitor;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.openmeasurement.VideoProps;
import com.smaato.sdk.core.openmeasurement.ViewabilityTracker;
import com.smaato.sdk.core.simplehttp.SimpleHttpClient;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.violationreporter.AdQualityViolationReporter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes12.dex */
public class SmaatoSdkRepository {
    protected static final String VIOLATION_TYPE_TRACKER_URL_NOT_SECURE = "SOMAAdViolationSSLBeacon";
    AdQualityViolationReporter adQualityViolationReporter;
    private final ApiParams apiParams;
    private final CsmRemoteSource csmRemoteSource;
    protected final LinkHandler linkHandler;
    private final AtomicReference<Boolean> linkHandlingInProgress = new AtomicReference<>(Boolean.FALSE);
    private final Logger logger;
    private final NetworkStateMonitor networkStateMonitor;
    private final OMTrackingRemoteSource omTrackingRemoteSource;
    private final SimpleHttpClient simpleHttpClient;
    private final SomaGdprDataSource somaGdprDataSource;
    private final SomaRemoteSource somaRemoteSource;
    private final UbRemoteSource ubRemoteSource;

    public SmaatoSdkRepository(SomaRemoteSource somaRemoteSource, UbRemoteSource ubRemoteSource, CsmRemoteSource csmRemoteSource, SomaGdprDataSource somaGdprDataSource, NetworkStateMonitor networkStateMonitor, LinkHandler linkHandler, SimpleHttpClient simpleHttpClient, AdQualityViolationReporter adQualityViolationReporter, OMTrackingRemoteSource oMTrackingRemoteSource, Map<AdFormat, AdResponseParser> map, ApiParams apiParams, Logger logger) {
        this.somaRemoteSource = somaRemoteSource;
        this.ubRemoteSource = ubRemoteSource;
        this.csmRemoteSource = csmRemoteSource;
        this.somaGdprDataSource = somaGdprDataSource;
        this.networkStateMonitor = networkStateMonitor;
        this.linkHandler = linkHandler;
        this.simpleHttpClient = simpleHttpClient;
        this.adQualityViolationReporter = adQualityViolationReporter;
        this.omTrackingRemoteSource = oMTrackingRemoteSource;
        this.apiParams = apiParams;
        this.logger = logger;
        somaRemoteSource.setAdResponseParsers(map);
        if (ubRemoteSource != null) {
            ubRemoteSource.setAdResponseParsers(map);
        }
    }

    public void loadAd(final SomaAdRequest somaAdRequest, final Consumer<AdResponse> consumer, final Consumer<Throwable> consumer2) {
        if (somaAdRequest == null) {
            throw new NullPointerException("'somaAdRequest' specified as non-null is null");
        }
        if (consumer == null) {
            throw new NullPointerException("'onAdLoadingSucceeded' specified as non-null is null");
        }
        if (consumer2 == null) {
            throw new NullPointerException("'onAdLoadingFailed' specified as non-null is null");
        }
        if (SmaatoSdk.isAgeRestrictedUser()) {
            consumer2.accept(new SomaException(SomaException.Type.AGE_RESTRICTED_USER, "This user is age restriced ad loading is not allowed!"));
        } else {
            Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5557x3088247c(consumer2, somaAdRequest, consumer);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$loadAd$4$com-smaato-sdk-core-mvvm-repository-SmaatoSdkRepository, reason: not valid java name */
    /* synthetic */ void m5557x3088247c(final Consumer consumer, SomaAdRequest somaAdRequest, final Consumer consumer2) {
        AdResponse adResponseLoadAdFromSoma;
        if (!this.somaGdprDataSource.getSomaGdprData().isUsageAllowedFor(PiiParam.LOAD_ADS)) {
            Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    consumer.accept(new SomaException(SomaException.Type.BAD_REQUEST, "GDPR permissions do not allow ad loading!"));
                }
            });
            return;
        }
        try {
            String adSpaceId = somaAdRequest.getAdRequest().getAdSpaceId();
            String uBUniqueId = somaAdRequest.getAdRequest().getUBUniqueId();
            UbRemoteSource ubRemoteSource = this.ubRemoteSource;
            if (ubRemoteSource != null && ubRemoteSource.isUbRequest(adSpaceId, uBUniqueId)) {
                adResponseLoadAdFromSoma = loadAdFromUbCache(somaAdRequest);
            } else {
                adResponseLoadAdFromSoma = loadAdFromSoma(somaAdRequest);
            }
            if (adResponseLoadAdFromSoma == null) {
                Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        consumer.accept(new SomaException(SomaException.Type.BAD_REQUEST, "Invalid Request"));
                    }
                });
            } else {
                final AdResponse adResponseDownloadImageBitmapIfNeeded = downloadImageBitmapIfNeeded(adResponseLoadAdFromSoma);
                Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        consumer2.accept(adResponseDownloadImageBitmapIfNeeded);
                    }
                });
            }
        } catch (CsmException e) {
            loadAdFromCsmNetworkEvent(somaAdRequest, consumer2, consumer, e.somaCsmJson, e.csmParameters);
        } catch (Exception e2) {
            Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    consumer.accept(e2);
                }
            });
        }
    }

    public Object notifyIfAppIsOnline(final Runnable runnable) {
        NetworkStateMonitor.Callback callback = new NetworkStateMonitor.Callback() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository.1
            @Override // com.smaato.sdk.core.network.NetworkStateMonitor.Callback
            public void onNetworkStateChanged(boolean z) {
                if (z) {
                    SmaatoSdkRepository.this.networkStateMonitor.removeCallback(this);
                    runnable.run();
                }
            }
        };
        this.networkStateMonitor.addCallback(callback);
        return callback;
    }

    public void cancelAppOnlineNotification(Object obj) {
        if (obj instanceof NetworkStateMonitor.Callback) {
            this.networkStateMonitor.removeCallback((NetworkStateMonitor.Callback) obj);
        }
    }

    protected AdResponse loadAdFromSoma(SomaAdRequest somaAdRequest) throws IOException {
        this.logger.debug(LogDomain.CORE, "Loading ad from SOMA", new Object[0]);
        return this.somaRemoteSource.loadAd(somaAdRequest);
    }

    protected AdResponse loadAdFromUbCache(SomaAdRequest somaAdRequest) throws IOException {
        if (somaAdRequest == null) {
            throw new NullPointerException("'somaAdRequest' specified as non-null is null");
        }
        this.logger.debug(LogDomain.CORE, "Loading ad from ub cache network", new Object[0]);
        UbRemoteSource ubRemoteSource = this.ubRemoteSource;
        if (ubRemoteSource != null) {
            return ubRemoteSource.loadAd(somaAdRequest.getAdRequest().getAdSpaceId(), somaAdRequest.getAdRequest().getUBUniqueId());
        }
        return null;
    }

    private void loadAdFromCsmNetworkEvent(SomaAdRequest somaAdRequest, final Consumer<AdResponse> consumer, final Consumer<Throwable> consumer2, String str, CsmParameters csmParameters) {
        this.logger.debug(LogDomain.CORE, "Loading ad from csm network", new Object[0]);
        try {
            this.csmRemoteSource.loadAd(str, somaAdRequest, new Consumer() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda9
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            consumer.accept(adResponse);
                        }
                    });
                }
            }, new Consumer() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda10
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            consumer.accept(th);
                        }
                    });
                }
            }, csmParameters);
        } catch (Exception e) {
            Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    consumer2.accept(e);
                }
            });
        }
    }

    public void handleLink(final String str, final Consumer<Boolean> consumer) {
        if (str == null) {
            throw new NullPointerException("'url' specified as non-null is null");
        }
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.linkHandlingInProgress, Boolean.FALSE, Boolean.TRUE)) {
            this.linkHandler.m5551x29a88085(str, new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5553xbf7e1eeb(consumer);
                }
            }, new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5554xaa630ed(str, consumer);
                }
            });
        } else {
            Objects.onNotNull(consumer, new Consumer() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda14
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((Consumer) obj).accept(Boolean.FALSE);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$handleLink$11$com-smaato-sdk-core-mvvm-repository-SmaatoSdkRepository, reason: not valid java name */
    /* synthetic */ void m5553xbf7e1eeb(Consumer consumer) {
        this.linkHandlingInProgress.set(Boolean.FALSE);
        Objects.onNotNull(consumer, new Consumer() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(Boolean.TRUE);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleLink$13$com-smaato-sdk-core-mvvm-repository-SmaatoSdkRepository, reason: not valid java name */
    /* synthetic */ void m5554xaa630ed(String str, Consumer consumer) {
        this.logger.error(LogDomain.NATIVE, "Could not launch url: " + str, new Object[0]);
        this.linkHandlingInProgress.set(Boolean.FALSE);
        Objects.onNotNull(consumer, new Consumer() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((Consumer) obj).accept(Boolean.FALSE);
            }
        });
    }

    public void handleTrackerUrls(final List<String> list) {
        if (list == null) {
            throw new NullPointerException("'trackerUrls' specified as non-null is null");
        }
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5555x353049d7(list);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleTrackerUrls$15$com-smaato-sdk-core-mvvm-repository-SmaatoSdkRepository, reason: not valid java name */
    /* synthetic */ void m5555x353049d7(List list) {
        this.simpleHttpClient.fireAndForget(list);
    }

    public void handleTrackerUrlsAndReportFailures(final List<String> list, final String str, final String str2, final String str3) {
        if (list == null) {
            throw new NullPointerException("'trackerUrls' specified as non-null is null");
        }
        if (str == null) {
            throw new NullPointerException("'adSpaceId' specified as non-null is null");
        }
        if (str2 == null) {
            throw new NullPointerException("'sessionId' specified as non-null is null");
        }
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.mvvm.repository.SmaatoSdkRepository$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5556xcd4c19d2(list, str, str2, str3);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleTrackerUrlsAndReportFailures$16$com-smaato-sdk-core-mvvm-repository-SmaatoSdkRepository, reason: not valid java name */
    /* synthetic */ void m5556xcd4c19d2(List list, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        this.simpleHttpClient.fireAndTrackSuccess(list, arrayList, null);
        for (int i = 0; i < arrayList.size(); i++) {
            reportTrackerViolation((String) arrayList.get(i), list, str, str2, str3);
        }
    }

    public void reportRichMediaAdViolation(String str, String str2, String str3, String str4, List<String> list, String str5, String str6) {
        if (str == null) {
            throw new NullPointerException("'violationType' specified as non-null is null");
        }
        if (str2 == null) {
            throw new NullPointerException("'violatedUrl' specified as non-null is null");
        }
        if (str3 == null) {
            throw new NullPointerException("'adSpaceId' specified as non-null is null");
        }
        if (str4 == null) {
            throw new NullPointerException("'richMediaContent' specified as non-null is null");
        }
        if (list == null) {
            throw new NullPointerException("'clickTrackingUrls' specified as non-null is null");
        }
        if (str5 == null) {
            throw new NullPointerException("'sessionId' specified as non-null is null");
        }
        String publisherId = SmaatoSdk.getPublisherId();
        if (publisherId == null) {
            return;
        }
        this.adQualityViolationReporter.reportRichMediaAdViolation(str, publisherId, str3, this.apiParams.getBundle(), this.apiParams.getClient(), str2, str4, list, str5, str6);
    }

    public ViewabilityTracker getOMImageViewabilityTracker(AdContentView adContentView) {
        if (adContentView != null) {
            return this.omTrackingRemoteSource.getImageViewabilityTracker(adContentView);
        }
        throw new NullPointerException("'adContentView' specified as non-null is null");
    }

    public ViewabilityTracker getOMWebViewabilityTracker(AdContentView adContentView) {
        if (adContentView != null) {
            return this.omTrackingRemoteSource.getWebViewViewabilityTracker(adContentView);
        }
        throw new NullPointerException("'adContentView' specified as non-null is null");
    }

    public ViewabilityTracker getOMVideoViewabilityTracker(AdContentView adContentView) {
        return this.omTrackingRemoteSource.getOMVideoViewabilityTracker(adContentView);
    }

    public void trackOMAdLoaded(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackOMAdLoaded(viewabilityTracker);
    }

    public void trackOMImpression(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackOMImpression(viewabilityTracker);
    }

    public void trackOMUpdateView(ViewabilityTracker viewabilityTracker, WebView webView) {
        this.omTrackingRemoteSource.trackOMUpdateView(viewabilityTracker, webView);
    }

    public void stopOMTracking(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.stopOMTracking(viewabilityTracker);
    }

    public void registerFriendlyObstruction(ViewabilityTracker viewabilityTracker, View view) {
        if (view == null) {
            throw new NullPointerException("'view' specified as non-null is null");
        }
        this.omTrackingRemoteSource.registerFriendlyObstruction(viewabilityTracker, view);
    }

    public void removeFriendlyObstruction(ViewabilityTracker viewabilityTracker, View view) {
        if (view == null) {
            throw new NullPointerException("'view' specified as non-null is null");
        }
        this.omTrackingRemoteSource.removeFriendlyObstruction(viewabilityTracker, view);
    }

    public void trackOMVideoPlayerStateChange(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackOMVideoPlayerStateChange(viewabilityTracker);
    }

    public void trackOMVideoPlayerLoaded(ViewabilityTracker viewabilityTracker, VideoProps videoProps) {
        this.omTrackingRemoteSource.trackOMVideoPlayerLoaded(viewabilityTracker, videoProps);
    }

    public void trackOMVideoClicked(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackVideoClicked(viewabilityTracker);
    }

    public void trackOMVideoStarted(ViewabilityTracker viewabilityTracker, float f, float f2) {
        this.omTrackingRemoteSource.trackVideoStarted(viewabilityTracker, f, f2);
    }

    public void trackVideoFirstQuartileReached(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackVideoFirstQuartileReached(viewabilityTracker);
    }

    public void trackVideoMidpointReached(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackVideoMidpointReached(viewabilityTracker);
    }

    public void trackVideoThirdQuartileReached(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackVideoThirdQuartileReached(viewabilityTracker);
    }

    public void trackVideoCompleted(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackVideoCompleted(viewabilityTracker);
    }

    public void trackVideoPaused(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackVideoPaused(viewabilityTracker);
    }

    public void trackVideoResumed(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackVideoResumed(viewabilityTracker);
    }

    public void trackMute(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackMute(viewabilityTracker);
    }

    public void trackUnmute(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackUnmute(viewabilityTracker);
    }

    public void trackVideoSkipped(ViewabilityTracker viewabilityTracker) {
        this.omTrackingRemoteSource.trackVideoSkipped(viewabilityTracker);
    }

    public boolean appIsOnline() {
        return this.networkStateMonitor.isOnline();
    }

    protected AdResponse downloadImageBitmapIfNeeded(AdResponse adResponse) throws IOException {
        if (adResponse.getImageUrl() == null) {
            return adResponse;
        }
        return adResponse.buildUpon().setImageBitmap(this.simpleHttpClient.readBitmap(adResponse.getImageUrl())).build();
    }

    private void reportTrackerViolation(String str, List<String> list, String str2, String str3, String str4) {
        if (str == null) {
            throw new NullPointerException("'violatedUrl' specified as non-null is null");
        }
        if (list == null) {
            throw new NullPointerException("'trackingUrls' specified as non-null is null");
        }
        if (str2 == null) {
            throw new NullPointerException("'adSpaceId' specified as non-null is null");
        }
        if (str3 == null) {
            throw new NullPointerException("'sessionId' specified as non-null is null");
        }
        String publisherId = SmaatoSdk.getPublisherId();
        if (publisherId == null) {
            return;
        }
        this.adQualityViolationReporter.reportAdTrackerViolation(VIOLATION_TYPE_TRACKER_URL_NOT_SECURE, publisherId, str2, this.apiParams.getBundle(), this.apiParams.getClient(), str, "", list, str3, str4);
    }
}
