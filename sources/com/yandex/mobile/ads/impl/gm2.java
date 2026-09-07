package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.interstitial.InterstitialAdLoadListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
public final class gm2 implements mt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterstitialAdLoadListener f9018a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ AdRequestError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AdRequestError adRequestError) {
            super(0);
            this.c = adRequestError;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            InterstitialAdLoadListener interstitialAdLoadListener = gm2.this.f9018a;
            if (interstitialAdLoadListener != null) {
                interstitialAdLoadListener.onAdFailedToLoad(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ em2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(em2 em2Var) {
            super(0);
            this.c = em2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            InterstitialAdLoadListener interstitialAdLoadListener = gm2.this.f9018a;
            if (interstitialAdLoadListener != null) {
                interstitialAdLoadListener.onAdLoaded(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    public gm2(InterstitialAdLoadListener interstitialAdLoadListener) {
        this.f9018a = interstitialAdLoadListener;
    }

    @Override // com.yandex.mobile.ads.impl.mt
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(error, "error");
        new CallbackStackTraceMarker(new a(new AdRequestError(error.b(), error.d(), error.a())));
    }

    @Override // com.yandex.mobile.ads.impl.mt
    public final void a(kt interstitialAd) {
        Intrinsics.checkNotNullParameter(interstitialAd, "interstitialAd");
        new CallbackStackTraceMarker(new b(new em2(interstitialAd, new bl2())));
    }
}
