package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.appopenad.AppOpenAdEventListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class il2 implements ss {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppOpenAdEventListener f9241a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            AppOpenAdEventListener appOpenAdEventListener = il2.this.f9241a;
            if (appOpenAdEventListener != null) {
                appOpenAdEventListener.onAdClicked();
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
            AppOpenAdEventListener appOpenAdEventListener = il2.this.f9241a;
            if (appOpenAdEventListener != null) {
                appOpenAdEventListener.onAdDismissed();
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
            AppOpenAdEventListener appOpenAdEventListener = il2.this.f9241a;
            if (appOpenAdEventListener != null) {
                appOpenAdEventListener.onAdFailedToShow(this.c);
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
            AppOpenAdEventListener appOpenAdEventListener = il2.this.f9241a;
            if (appOpenAdEventListener != null) {
                appOpenAdEventListener.onAdImpression(this.c);
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
            AppOpenAdEventListener appOpenAdEventListener = il2.this.f9241a;
            if (appOpenAdEventListener != null) {
                appOpenAdEventListener.onAdShown();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ss
    public final void onAdClicked() {
        new CallbackStackTraceMarker(new a());
    }

    @Override // com.yandex.mobile.ads.impl.ss
    public final void onAdDismissed() {
        new CallbackStackTraceMarker(new b());
    }

    @Override // com.yandex.mobile.ads.impl.ss
    public final void onAdShown() {
        new CallbackStackTraceMarker(new e());
    }

    public il2(AppOpenAdEventListener appOpenAdEventListener) {
        this.f9241a = appOpenAdEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.ss
    public final void a(dy1 adError) {
        Intrinsics.checkNotNullParameter(adError, "adError");
        new CallbackStackTraceMarker(new c(new al2(adError.a())));
    }

    @Override // com.yandex.mobile.ads.impl.ss
    public final void a(t4 t4Var) {
        new CallbackStackTraceMarker(new d(t4Var != null ? new ql2(t4Var) : null));
    }
}
