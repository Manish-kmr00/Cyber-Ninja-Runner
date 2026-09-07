package com.smaato.sdk.interstitial.viewmodel;

import android.os.Handler;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.interstitial.EventListener;
import com.smaato.sdk.interstitial.InterstitialAd;
import com.smaato.sdk.interstitial.InterstitialAdBase;
import com.smaato.sdk.interstitial.InterstitialError;
import com.smaato.sdk.interstitial.InterstitialRequestError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class EventListenerNotifications implements EventListenerNotificationsInterface {
    private static final Map ERROR_MAP;
    private InterstitialAd interstitialAd;
    private final Logger logger;
    private WeakReference eventListener = new WeakReference(null);
    private final Handler uiHandler = Threads.newUiHandler();

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdReward() {
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdStarted() {
    }

    static {
        HashMap map = new HashMap();
        ERROR_MAP = map;
        map.put(SomaException.Type.NO_CONTENT, InterstitialError.NO_AD_AVAILABLE);
        map.put(SomaException.Type.BAD_REQUEST, InterstitialError.INVALID_REQUEST);
        map.put(SomaException.Type.BAD_RESPONSE, InterstitialError.INTERNAL_ERROR);
        map.put(SomaException.Type.AGE_RESTRICTED_USER, InterstitialError.AGE_RESTRICTED);
        map.put(SomaException.Type.TIMEOUT_ERROR, InterstitialError.NETWORK_ERROR);
        map.put(SomaException.Type.CREATIVE_EXPIRED, InterstitialError.CREATIVE_RESOURCE_EXPIRED);
    }

    public EventListenerNotifications(Logger logger) {
        this.logger = logger;
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void setEventListener(Object obj) {
        if (obj instanceof EventListener) {
            this.eventListener = new WeakReference((EventListener) obj);
        } else {
            this.logger.error(LogDomain.INTERSTITIAL, "Listener is not of type EventListener (Interstitial)", new Object[0]);
        }
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void setAd(InterstitialAdBase interstitialAdBase) {
        if (interstitialAdBase instanceof InterstitialAd) {
            this.interstitialAd = (InterstitialAd) interstitialAdBase;
        } else {
            this.logger.error(LogDomain.INTERSTITIAL, "Ad is not of type interstitial ad", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: lambda$onAdLoaded$0$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5609xfe225ab9(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdLoaded((InterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdLoaded() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5609xfe225ab9((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onImpression$1$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5615xac26fe37(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdImpression((InterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onImpression() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5615xac26fe37((EventListener) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdUnloaded() {
        notifyAdLoadingError(InterstitialError.AD_UNLOADED);
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onInternalError() {
        notifyAdLoadingError(InterstitialError.INTERNAL_ERROR);
    }

    /* JADX INFO: renamed from: lambda$onAdOpened$2$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5611x6f626813(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdOpened((InterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdOpened() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5611x6f626813((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAdClosed$3$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5606x77ef2c4f(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdClosed((InterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdClosed() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda20
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5606x77ef2c4f((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAdClicked$4$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5605xf626b0b1(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdClicked((InterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdClicked() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5605xf626b0b1((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAdTtlExpired$5$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5612x3a77c6c0(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdTTLExpired((InterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdTtlExpired() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5612x3a77c6c0((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAdLoadingException$6$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5610xf77e6505(Throwable th, EventListener eventListener) {
        notifyAdLoadingError(getInterstitialLoadingError(th));
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdLoadingException(final Throwable th) {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda19
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5610xf77e6505(th, (EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onNetworkError$7$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5617x9f7ce1e0(EventListener eventListener) {
        notifyAdLoadingError(InterstitialError.NETWORK_ERROR);
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onNetworkError() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5617x9f7ce1e0((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onInvalidRequest$8$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5616xfa93dc21(String str, String str2, EventListener eventListener) {
        notifyAdLoadingError(InterstitialError.INVALID_REQUEST, str, str2);
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onInvalidRequest(final String str, final String str2) {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda21
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5616xfa93dc21(str, str2, (EventListener) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdError(final Throwable th) {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5607xe9b2b10f(th, (EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAdError$10$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5607xe9b2b10f(final Throwable th, final EventListener eventListener) {
        if (this.interstitialAd == null) {
            this.logger.error(LogDomain.INTERSTITIAL, "Cannot call onAdError method, interstitial ad is null", new Object[0]);
        } else {
            Threads.ensureInvokedOnHandlerThread(this.uiHandler, new Runnable() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5608x442ddb8b(eventListener, th);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onAdError$9$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5608x442ddb8b(EventListener eventListener, Throwable th) {
        eventListener.onAdError(this.interstitialAd, getInterstitialExecutionError(th));
    }

    /* JADX INFO: renamed from: lambda$onCompanionAdImpressed$11$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5614x263618f0(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onCompanionAdImpressed((InterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onCompanionAdImpressed() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5614x263618f0((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCompanionAdClicked$12$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5613x33b3578(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onCompanionAdClicked((InterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onCompanionAdClicked() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda23
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5613x33b3578((EventListener) obj);
            }
        });
    }

    private void notifyAdLoadingError(InterstitialError interstitialError) {
        String publisherId = SmaatoSdk.getPublisherId();
        InterstitialAd interstitialAd = this.interstitialAd;
        notifyAdLoadingError(interstitialError, publisherId, interstitialAd != null ? interstitialAd.getAdSpaceId() : null);
    }

    private void notifyAdLoadingError(final InterstitialError interstitialError, final String str, final String str2) {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5603xa5c555b7(interstitialError, str, str2, (EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$notifyAdLoadingError$14$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5603xa5c555b7(InterstitialError interstitialError, String str, String str2, EventListener eventListener) {
        final InterstitialRequestError interstitialRequestError = new InterstitialRequestError(interstitialError, str, str2);
        Threads.ensureInvokedOnHandlerThread(this.uiHandler, new Runnable() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5602x3b95cd98(interstitialRequestError);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$notifyAdLoadingError$13$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5602x3b95cd98(InterstitialRequestError interstitialRequestError) {
        ((EventListener) this.eventListener.get()).onAdFailedToLoad(interstitialRequestError);
    }

    private void notifyEventListener(final Consumer consumer) {
        if (this.interstitialAd == null) {
            this.logger.error(LogDomain.INTERSTITIAL, "Cannot call Interstial.EventListener method, interstitial ad is null", new Object[0]);
        } else {
            Threads.ensureInvokedOnHandlerThread(this.uiHandler, new Runnable() { // from class: com.smaato.sdk.interstitial.viewmodel.EventListenerNotifications$$ExternalSyntheticLambda22
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5604x4f21fe49(consumer);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$notifyEventListener$15$com-smaato-sdk-interstitial-viewmodel-EventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5604x4f21fe49(Consumer consumer) {
        consumer.accept(this.interstitialAd);
    }

    private InterstitialError getInterstitialLoadingError(Throwable th) {
        InterstitialError interstitialError = th instanceof SomaException ? (InterstitialError) ERROR_MAP.get(((SomaException) th).getType()) : null;
        return interstitialError == null ? InterstitialError.NO_AD_AVAILABLE : interstitialError;
    }

    private InterstitialError getInterstitialExecutionError(Throwable th) {
        InterstitialError interstitialError = th instanceof SomaException ? (InterstitialError) ERROR_MAP.get(((SomaException) th).getType()) : null;
        return interstitialError == null ? InterstitialError.INTERNAL_ERROR : interstitialError;
    }
}
