package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class fm2 implements lt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterstitialAdEventListener f8910a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            InterstitialAdEventListener interstitialAdEventListener = fm2.this.f8910a;
            if (interstitialAdEventListener != null) {
                interstitialAdEventListener.onAdClicked();
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
            InterstitialAdEventListener interstitialAdEventListener = fm2.this.f8910a;
            if (interstitialAdEventListener != null) {
                interstitialAdEventListener.onAdDismissed();
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
            InterstitialAdEventListener interstitialAdEventListener = fm2.this.f8910a;
            if (interstitialAdEventListener != null) {
                interstitialAdEventListener.onAdFailedToShow(this.c);
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
            InterstitialAdEventListener interstitialAdEventListener = fm2.this.f8910a;
            if (interstitialAdEventListener != null) {
                interstitialAdEventListener.onAdImpression(this.c);
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
            InterstitialAdEventListener interstitialAdEventListener = fm2.this.f8910a;
            if (interstitialAdEventListener != null) {
                interstitialAdEventListener.onAdShown();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.yandex.mobile.ads.impl.lt
    public final void onAdClicked() {
        new CallbackStackTraceMarker(new a());
    }

    @Override // com.yandex.mobile.ads.impl.lt
    public final void onAdDismissed() {
        new CallbackStackTraceMarker(new b());
    }

    @Override // com.yandex.mobile.ads.impl.lt
    public final void onAdShown() {
        new CallbackStackTraceMarker(new e());
    }

    public fm2(InterstitialAdEventListener interstitialAdEventListener) {
        this.f8910a = interstitialAdEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.lt
    public final void a(dy1 adError) {
        Intrinsics.checkNotNullParameter(adError, "adError");
        new CallbackStackTraceMarker(new c(new al2(adError.a())));
    }

    @Override // com.yandex.mobile.ads.impl.lt
    public final void a(t4 t4Var) {
        new CallbackStackTraceMarker(new d(t4Var != null ? new ql2(t4Var) : null));
    }
}
