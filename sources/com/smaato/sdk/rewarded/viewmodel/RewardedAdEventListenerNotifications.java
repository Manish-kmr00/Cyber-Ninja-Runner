package com.smaato.sdk.rewarded.viewmodel;

import android.os.Handler;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.interstitial.InterstitialAdBase;
import com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface;
import com.smaato.sdk.rewarded.EventListener;
import com.smaato.sdk.rewarded.RewardedError;
import com.smaato.sdk.rewarded.RewardedInterstitialAd;
import com.smaato.sdk.rewarded.RewardedRequestError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes12.dex */
public class RewardedAdEventListenerNotifications implements EventListenerNotificationsInterface {
    private static final Map ERROR_MAP;
    private final Logger logger;
    private RewardedInterstitialAd rewardedInterstitialAd;
    private WeakReference eventListener = new WeakReference(null);
    private final Handler uiHandler = Threads.newUiHandler();

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdOpened() {
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdUnloaded() {
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onImpression() {
    }

    static {
        HashMap map = new HashMap();
        ERROR_MAP = map;
        map.put(SomaException.Type.NO_CONTENT, RewardedError.NO_AD_AVAILABLE);
        map.put(SomaException.Type.BAD_REQUEST, RewardedError.INVALID_REQUEST);
        map.put(SomaException.Type.BAD_RESPONSE, RewardedError.INTERNAL_ERROR);
        map.put(SomaException.Type.TIMEOUT_ERROR, RewardedError.NETWORK_ERROR);
        map.put(SomaException.Type.CREATIVE_EXPIRED, RewardedError.CREATIVE_RESOURCE_EXPIRED);
        map.put(SomaException.Type.AGE_RESTRICTED_USER, RewardedError.AGE_RESTRICTED);
    }

    public RewardedAdEventListenerNotifications(Logger logger) {
        this.logger = logger;
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void setEventListener(Object obj) {
        if (obj instanceof EventListener) {
            this.eventListener = new WeakReference((EventListener) obj);
        } else {
            this.logger.error(LogDomain.INTERSTITIAL, "Listener is not of type EventListener (Rewarded)", new Object[0]);
        }
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void setAd(InterstitialAdBase interstitialAdBase) {
        if (interstitialAdBase instanceof RewardedInterstitialAd) {
            this.rewardedInterstitialAd = (RewardedInterstitialAd) interstitialAdBase;
        } else {
            this.logger.error(LogDomain.INTERSTITIAL, "Ad is not of type interstitial ad", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: lambda$onAdLoaded$0$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5638x75503708(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdLoaded((RewardedInterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdLoaded() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5638x75503708((EventListener) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onInternalError() {
        notifyEventListener(RewardedError.INTERNAL_ERROR);
    }

    /* JADX INFO: renamed from: lambda$onAdClosed$1$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5635x56cd9660(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdClosed((RewardedInterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdClosed() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5635x56cd9660((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAdClicked$2$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5634x674c942(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdClicked((RewardedInterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdClicked() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda20
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5634x674c942((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAdTtlExpired$3$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5641xec9ad811(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdTTLExpired((RewardedInterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdTtlExpired() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5641xec9ad811((EventListener) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdLoadingException(Throwable th) {
        notifyEventListener(getInterstitialError(th));
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onNetworkError() {
        notifyEventListener(RewardedError.NETWORK_ERROR);
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onInvalidRequest(String str, String str2) {
        notifyEventListener(RewardedError.INVALID_REQUEST, str, str2);
    }

    /* JADX INFO: renamed from: lambda$onAdStarted$4$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5640xba6717e6(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda19
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdStarted((RewardedInterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdStarted() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5640xba6717e6((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAdReward$5$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5639x1cff5f79(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda10
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onAdReward((RewardedInterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdReward() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5639x1cff5f79((EventListener) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onAdError(final Throwable th) {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5637x4502e89c(th, (EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onAdError$7$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5637x4502e89c(final Throwable th, final EventListener eventListener) {
        if (this.rewardedInterstitialAd == null) {
            this.logger.error(LogDomain.INTERSTITIAL, "Cannot call onAdError method, interstitial ad is null", new Object[0]);
        } else {
            Threads.ensureInvokedOnHandlerThread(this.uiHandler, new Runnable() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5636xc2b833bd(eventListener, th);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onAdError$6$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5636xc2b833bd(EventListener eventListener, Throwable th) {
        eventListener.onAdError(this.rewardedInterstitialAd, getInterstitialExecutionError(th));
    }

    /* JADX INFO: renamed from: lambda$onCompanionAdImpressed$8$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5643x449946f9(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onCompanionAdImpressed((RewardedInterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onCompanionAdImpressed() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5643x449946f9((EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCompanionAdClicked$9$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5642x1197c10f(final EventListener eventListener) {
        Objects.requireNonNull(eventListener);
        notifyEventListener(new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                eventListener.onCompanionAdClicked((RewardedInterstitialAd) obj);
            }
        });
    }

    @Override // com.smaato.sdk.interstitial.viewmodel.EventListenerNotificationsInterface
    public void onCompanionAdClicked() {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5642x1197c10f((EventListener) obj);
            }
        });
    }

    private void notifyEventListener(RewardedError rewardedError) {
        String publisherId = SmaatoSdk.getPublisherId();
        RewardedInterstitialAd rewardedInterstitialAd = this.rewardedInterstitialAd;
        notifyEventListener(rewardedError, publisherId, rewardedInterstitialAd != null ? rewardedInterstitialAd.getAdSpaceId() : null);
    }

    private void notifyEventListener(final RewardedError rewardedError, final String str, final String str2) {
        com.smaato.sdk.core.util.Objects.onNotNull((EventListener) this.eventListener.get(), new Consumer() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5632x1b201b1c(rewardedError, str, str2, (EventListener) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$notifyEventListener$11$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5632x1b201b1c(RewardedError rewardedError, String str, String str2, final EventListener eventListener) {
        final RewardedRequestError rewardedRequestError = new RewardedRequestError(rewardedError, str, str2);
        Threads.ensureInvokedOnHandlerThread(this.uiHandler, new Runnable() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                eventListener.onAdFailedToLoad(rewardedRequestError);
            }
        });
    }

    private void notifyEventListener(final Consumer consumer) {
        if (this.rewardedInterstitialAd == null) {
            this.logger.error(LogDomain.INTERSTITIAL, "Cannot call Interstial.EventListener method, interstitial ad is null", new Object[0]);
        } else {
            Threads.ensureInvokedOnHandlerThread(this.uiHandler, new Runnable() { // from class: com.smaato.sdk.rewarded.viewmodel.RewardedAdEventListenerNotifications$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5633x9d6acffb(consumer);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$notifyEventListener$12$com-smaato-sdk-rewarded-viewmodel-RewardedAdEventListenerNotifications, reason: not valid java name */
    /* synthetic */ void m5633x9d6acffb(Consumer consumer) {
        consumer.accept(this.rewardedInterstitialAd);
    }

    private RewardedError getInterstitialError(Throwable th) {
        RewardedError rewardedError = th instanceof SomaException ? (RewardedError) ERROR_MAP.get(((SomaException) th).getType()) : null;
        return rewardedError == null ? RewardedError.NO_AD_AVAILABLE : rewardedError;
    }

    private RewardedError getInterstitialExecutionError(Throwable th) {
        RewardedError rewardedError = th instanceof SomaException ? (RewardedError) ERROR_MAP.get(((SomaException) th).getType()) : null;
        return rewardedError == null ? RewardedError.INTERNAL_ERROR : rewardedError;
    }
}
