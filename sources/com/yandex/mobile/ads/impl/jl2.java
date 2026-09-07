package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.appopenad.AppOpenAdLoadListener;
import com.yandex.mobile.ads.common.AdRequestError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
public final class jl2 implements ts {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppOpenAdLoadListener f9332a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ AdRequestError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AdRequestError adRequestError) {
            super(0);
            this.c = adRequestError;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            AppOpenAdLoadListener appOpenAdLoadListener = jl2.this.f9332a;
            if (appOpenAdLoadListener != null) {
                appOpenAdLoadListener.onAdFailedToLoad(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ hl2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(hl2 hl2Var) {
            super(0);
            this.c = hl2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            AppOpenAdLoadListener appOpenAdLoadListener = jl2.this.f9332a;
            if (appOpenAdLoadListener != null) {
                appOpenAdLoadListener.onAdLoaded(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    public jl2(AppOpenAdLoadListener appOpenAdLoadListener) {
        this.f9332a = appOpenAdLoadListener;
    }

    @Override // com.yandex.mobile.ads.impl.ts
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(error, "error");
        new CallbackStackTraceMarker(new a(new AdRequestError(error.b(), error.d(), error.a())));
    }

    @Override // com.yandex.mobile.ads.impl.ts
    public final void a(rs appOpenAd) {
        Intrinsics.checkNotNullParameter(appOpenAd, "appOpenAd");
        new CallbackStackTraceMarker(new b(new hl2(appOpenAd, new bl2())));
    }
}
