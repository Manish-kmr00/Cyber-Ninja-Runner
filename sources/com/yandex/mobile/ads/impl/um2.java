package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.rewarded.RewardedAdEventListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class um2 implements eu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RewardedAdEventListener f10408a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RewardedAdEventListener rewardedAdEventListener = um2.this.f10408a;
            if (rewardedAdEventListener != null) {
                rewardedAdEventListener.onAdClicked();
            }
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RewardedAdEventListener rewardedAdEventListener = um2.this.f10408a;
            if (rewardedAdEventListener != null) {
                rewardedAdEventListener.onAdDismissed();
            }
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function0<Unit> {
        final /* synthetic */ al2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(al2 al2Var) {
            super(0);
            this.c = al2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RewardedAdEventListener rewardedAdEventListener = um2.this.f10408a;
            if (rewardedAdEventListener != null) {
                rewardedAdEventListener.onAdFailedToShow(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function0<Unit> {
        final /* synthetic */ ql2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ql2 ql2Var) {
            super(0);
            this.c = ql2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RewardedAdEventListener rewardedAdEventListener = um2.this.f10408a;
            if (rewardedAdEventListener != null) {
                rewardedAdEventListener.onAdImpression(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    static final class e extends Lambda implements Function0<Unit> {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RewardedAdEventListener rewardedAdEventListener = um2.this.f10408a;
            if (rewardedAdEventListener != null) {
                rewardedAdEventListener.onAdShown();
            }
            return Unit.INSTANCE;
        }
    }

    static final class f extends Lambda implements Function0<Unit> {
        final /* synthetic */ sm2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(sm2 sm2Var) {
            super(0);
            this.c = sm2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RewardedAdEventListener rewardedAdEventListener = um2.this.f10408a;
            if (rewardedAdEventListener != null) {
                rewardedAdEventListener.onRewarded(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.yandex.mobile.ads.impl.eu
    public final void onAdClicked() {
        new CallbackStackTraceMarker(new a());
    }

    @Override // com.yandex.mobile.ads.impl.eu
    public final void onAdDismissed() {
        new CallbackStackTraceMarker(new b());
    }

    @Override // com.yandex.mobile.ads.impl.eu
    public final void onAdShown() {
        new CallbackStackTraceMarker(new e());
    }

    public um2(RewardedAdEventListener rewardedAdEventListener) {
        this.f10408a = rewardedAdEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.eu
    public final void a(dy1 adError) {
        Intrinsics.checkNotNullParameter(adError, "adError");
        new CallbackStackTraceMarker(new c(new al2(adError.a())));
    }

    @Override // com.yandex.mobile.ads.impl.eu
    public final void a(t4 t4Var) {
        new CallbackStackTraceMarker(new d(t4Var != null ? new ql2(t4Var) : null));
    }

    @Override // com.yandex.mobile.ads.impl.eu
    public final void a(or1 reward) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        new CallbackStackTraceMarker(new f(new sm2(reward)));
    }
}
