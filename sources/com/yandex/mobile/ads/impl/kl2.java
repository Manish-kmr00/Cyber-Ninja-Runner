package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.banner.BannerAdEventListener;
import com.yandex.mobile.ads.common.AdRequestError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
public final class kl2 implements vs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BannerAdEventListener f9430a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            BannerAdEventListener bannerAdEventListener = kl2.this.f9430a;
            if (bannerAdEventListener != null) {
                bannerAdEventListener.onAdClicked();
            }
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ AdRequestError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AdRequestError adRequestError) {
            super(0);
            this.c = adRequestError;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            BannerAdEventListener bannerAdEventListener = kl2.this.f9430a;
            if (bannerAdEventListener != null) {
                bannerAdEventListener.onAdFailedToLoad(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function0<Unit> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            BannerAdEventListener bannerAdEventListener = kl2.this.f9430a;
            if (bannerAdEventListener != null) {
                bannerAdEventListener.onAdLoaded();
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
            BannerAdEventListener bannerAdEventListener = kl2.this.f9430a;
            if (bannerAdEventListener != null) {
                bannerAdEventListener.onImpression(this.c);
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
            BannerAdEventListener bannerAdEventListener = kl2.this.f9430a;
            if (bannerAdEventListener != null) {
                bannerAdEventListener.onLeftApplication();
            }
            return Unit.INSTANCE;
        }
    }

    static final class f extends Lambda implements Function0<Unit> {
        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            BannerAdEventListener bannerAdEventListener = kl2.this.f9430a;
            if (bannerAdEventListener != null) {
                bannerAdEventListener.onReturnedToApplication();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void closeBannerAd() {
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void onAdClicked() {
        new CallbackStackTraceMarker(new a());
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void onAdLoaded() {
        new CallbackStackTraceMarker(new c());
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void onLeftApplication() {
        new CallbackStackTraceMarker(new e());
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void onReturnedToApplication() {
        new CallbackStackTraceMarker(new f());
    }

    public kl2(BannerAdEventListener bannerAdEventListener) {
        this.f9430a = bannerAdEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(error, "error");
        new CallbackStackTraceMarker(new b(new AdRequestError(error.b(), error.d(), error.a())));
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void a(t4 t4Var) {
        new CallbackStackTraceMarker(new d(t4Var != null ? new ql2(t4Var) : null));
    }
}
