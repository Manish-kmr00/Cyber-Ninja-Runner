package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.publisher.RewardedInterstitialAdShowListener;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class g0 {

    public static final class a extends Lambda implements Function1<com.moloco.sdk.internal.ortb.model.o, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6193a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g invoke(com.moloco.sdk.internal.ortb.model.o oVar) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g gVarB;
            return (oVar == null || (gVarB = com.moloco.sdk.internal.d.b(oVar)) == null) ? com.moloco.sdk.internal.d.b() : gVarB;
        }
    }

    public static final class b implements RewardedInterstitialAdShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6194a = "RewardedInterstitialAdShowListenerImpl";
        public boolean b;
        public final /* synthetic */ Function0<Boolean> c;
        public final /* synthetic */ RewardedInterstitialAdShowListener d;
        public final /* synthetic */ boolean e;

        public b(Function0<Boolean> function0, RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, boolean z) {
            this.c = function0;
            this.d = rewardedInterstitialAdShowListener;
            this.e = z;
        }

        public final void a(MolocoAd molocoAd) {
            if (this.b) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f6194a, "issuing of reward is already handled", false, 4, null);
                return;
            }
            this.b = true;
            if (!Intrinsics.areEqual(this.c.invoke(), Boolean.FALSE)) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f6194a, "reward can't be issued: ad was forcibly closed or ad was missing", false, 4, null);
            } else {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f6194a, "issuing of reward...", false, 4, null);
                onUserRewarded(molocoAd);
            }
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdClicked(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            this.d.onAdClicked(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdHidden(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            a(molocoAd);
            this.d.onAdHidden(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdShowFailed(MolocoAdError molocoAdError) {
            Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
            this.d.onAdShowFailed(molocoAdError);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdShowSuccess(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            this.d.onAdShowSuccess(molocoAd);
            if (this.e) {
                onRewardedVideoStarted(molocoAd);
            }
        }

        @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
        public void onRewardedVideoCompleted(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            a(molocoAd);
            this.d.onRewardedVideoCompleted(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
        public void onRewardedVideoStarted(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            this.d.onRewardedVideoStarted(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
        public void onUserRewarded(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            this.d.onUserRewarded(molocoAd);
        }
    }

    public static final RewardedInterstitialAd a(Context context, com.moloco.sdk.internal.services.f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adUnitId, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, t<RewardedInterstitialAdShowListener> adDataHolder, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t watermark, com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(adDataHolder, "adDataHolder");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        return new f0(new u(context, appLifecycleTrackerService, customUserEventBuilderService, adUnitId, persistentHttpRequest, externalLinkHandler, a.f6193a, adDataHolder, AdFormatType.REWARDED, watermark, adCreateLoadTimeoutManager), adUnitId);
    }

    public static final RewardedInterstitialAdShowListener a(RewardedInterstitialAdShowListener listenerTracker, boolean z, Function0<Boolean> isAdForciblyClosed) {
        Intrinsics.checkNotNullParameter(listenerTracker, "listenerTracker");
        Intrinsics.checkNotNullParameter(isAdForciblyClosed, "isAdForciblyClosed");
        return new b(isAdForciblyClosed, listenerTracker, z);
    }

    public static final RewardedInterstitialAdShowListener a(RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, Function0<com.moloco.sdk.internal.ortb.model.q> provideSdkEvents) {
        Intrinsics.checkNotNullParameter(provideSdkEvents, "provideSdkEvents");
        return new h0(rewardedInterstitialAdShowListener, provideSdkEvents, com.moloco.sdk.internal.y.a());
    }
}
