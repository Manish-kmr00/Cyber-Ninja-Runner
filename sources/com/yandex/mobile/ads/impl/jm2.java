package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.nativeads.NativeAdEventListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class jm2 implements pt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NativeAdEventListener f9334a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            jm2.this.f9334a.onAdClicked();
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ ql2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ql2 ql2Var) {
            super(0);
            this.c = ql2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            jm2.this.f9334a.onImpression(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function0<Unit> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            jm2.this.f9334a.onLeftApplication();
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function0<Unit> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            jm2.this.f9334a.onReturnedToApplication();
            return Unit.INSTANCE;
        }
    }

    public jm2(NativeAdEventListener nativeAdEventListener) {
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        this.f9334a = nativeAdEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void closeNativeAd() {
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onAdClicked() {
        new CallbackStackTraceMarker(new a());
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onLeftApplication() {
        new CallbackStackTraceMarker(new c());
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void onReturnedToApplication() {
        new CallbackStackTraceMarker(new d());
    }

    @Override // com.yandex.mobile.ads.impl.pt
    public final void a(t4 t4Var) {
        new CallbackStackTraceMarker(new b(t4Var != null ? new ql2(t4Var) : null));
    }
}
