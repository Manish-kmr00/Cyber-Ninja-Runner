package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.banner.ClosableBannerAdEventListener;
import com.yandex.mobile.ads.common.AdRequestError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
public final class ol2 implements vs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClosableBannerAdEventListener f9832a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ClosableBannerAdEventListener closableBannerAdEventListener = ol2.this.f9832a;
            if (closableBannerAdEventListener != null) {
                closableBannerAdEventListener.closeBannerAd();
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
            ClosableBannerAdEventListener closableBannerAdEventListener = ol2.this.f9832a;
            if (closableBannerAdEventListener != null) {
                closableBannerAdEventListener.onAdClicked();
            }
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function0<Unit> {
        final /* synthetic */ AdRequestError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AdRequestError adRequestError) {
            super(0);
            this.c = adRequestError;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ClosableBannerAdEventListener closableBannerAdEventListener = ol2.this.f9832a;
            if (closableBannerAdEventListener != null) {
                closableBannerAdEventListener.onAdFailedToLoad(this.c);
            }
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function0<Unit> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ClosableBannerAdEventListener closableBannerAdEventListener = ol2.this.f9832a;
            if (closableBannerAdEventListener != null) {
                closableBannerAdEventListener.onAdLoaded();
            }
            return Unit.INSTANCE;
        }
    }

    static final class e extends Lambda implements Function0<Unit> {
        final /* synthetic */ ql2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ql2 ql2Var) {
            super(0);
            this.c = ql2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ClosableBannerAdEventListener closableBannerAdEventListener = ol2.this.f9832a;
            if (closableBannerAdEventListener != null) {
                closableBannerAdEventListener.onImpression(this.c);
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
            ClosableBannerAdEventListener closableBannerAdEventListener = ol2.this.f9832a;
            if (closableBannerAdEventListener != null) {
                closableBannerAdEventListener.onLeftApplication();
            }
            return Unit.INSTANCE;
        }
    }

    static final class g extends Lambda implements Function0<Unit> {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ClosableBannerAdEventListener closableBannerAdEventListener = ol2.this.f9832a;
            if (closableBannerAdEventListener != null) {
                closableBannerAdEventListener.onReturnedToApplication();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void closeBannerAd() {
        new CallbackStackTraceMarker(new a());
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void onAdClicked() {
        new CallbackStackTraceMarker(new b());
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void onAdLoaded() {
        new CallbackStackTraceMarker(new d());
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void onLeftApplication() {
        new CallbackStackTraceMarker(new f());
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void onReturnedToApplication() {
        new CallbackStackTraceMarker(new g());
    }

    public ol2(ClosableBannerAdEventListener closableBannerAdEventListener) {
        this.f9832a = closableBannerAdEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(error, "error");
        new CallbackStackTraceMarker(new c(new AdRequestError(error.b(), error.d(), error.a())));
    }

    @Override // com.yandex.mobile.ads.impl.vs
    public final void a(t4 t4Var) {
        new CallbackStackTraceMarker(new e(t4Var != null ? new ql2(t4Var) : null));
    }
}
