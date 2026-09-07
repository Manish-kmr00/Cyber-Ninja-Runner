package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.nativeads.ClosableNativeAdEventListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class pl2 implements pt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClosableNativeAdEventListener f9937a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            pl2.this.f9937a.closeNativeAd();
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            pl2.this.f9937a.onAdClicked();
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function0<Unit> {
        final /* synthetic */ ql2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ql2 ql2Var) {
            super(0);
            this.c = ql2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            pl2.this.f9937a.onImpression(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function0<Unit> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            pl2.this.f9937a.onLeftApplication();
            return Unit.INSTANCE;
        }
    }

    static final class e extends Lambda implements Function0<Unit> {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            pl2.this.f9937a.onReturnedToApplication();
            return Unit.INSTANCE;
        }
    }

    public pl2(ClosableNativeAdEventListener adEventListener) {
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        this.f9937a = adEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void closeNativeAd() {
        new CallbackStackTraceMarker(new a());
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onAdClicked() {
        new CallbackStackTraceMarker(new b());
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onLeftApplication() {
        new CallbackStackTraceMarker(new d());
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onReturnedToApplication() {
        new CallbackStackTraceMarker(new e());
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void a(t4 t4Var) {
        new CallbackStackTraceMarker(new c(t4Var != null ? new ql2(t4Var) : null));
    }
}
