package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.publisher.RewardedInterstitialAdShowListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class f0 implements RewardedInterstitialAd, r, FullscreenAd<RewardedInterstitialAdShowListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u<RewardedInterstitialAdShowListener> f6189a;
    public final String b;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RewardedInterstitialAdShowListener f6190a;
        public final /* synthetic */ f0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, f0 f0Var) {
            super(1);
            this.f6190a = rewardedInterstitialAdShowListener;
            this.b = f0Var;
        }

        public final void a(boolean z) {
            this.f6190a.onRewardedVideoCompleted(MolocoAdKt.createAdInfo$default(this.b.b, null, 2, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            a(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Boolean> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return f0.this.f6189a.e();
        }
    }

    public static final class c extends Lambda implements Function0<com.moloco.sdk.internal.ortb.model.q> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.internal.ortb.model.q invoke() {
            return f0.this.f6189a.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0(u<? super RewardedInterstitialAdShowListener> fullscreenAd, String adUnitId) {
        Intrinsics.checkNotNullParameter(fullscreenAd, "fullscreenAd");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.f6189a = fullscreenAd;
        this.b = adUnitId;
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        this.f6189a.destroy();
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.f6189a.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.f6189a.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        this.f6189a.load(bidResponseJson, listener);
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.f6189a.setCreateAdObjectStartTime(j);
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void show(RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener) {
        RewardedInterstitialAdShowListener rewardedInterstitialAdShowListenerA = g0.a(g0.a(rewardedInterstitialAdShowListener, new c()), this.f6189a.b() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h.VAST, new b());
        this.f6189a.a(new a(rewardedInterstitialAdShowListenerA, this));
        this.f6189a.show(rewardedInterstitialAdShowListenerA);
    }
}
