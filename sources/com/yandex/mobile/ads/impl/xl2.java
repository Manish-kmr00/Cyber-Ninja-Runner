package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.instream.InstreamAdListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
public final class xl2 implements pl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InstreamAdListener f10665a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            xl2.this.f10665a.onError(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            xl2.this.f10665a.onInstreamAdCompleted();
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function0<Unit> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            xl2.this.f10665a.onInstreamAdPrepared();
            return Unit.INSTANCE;
        }
    }

    public xl2(InstreamAdListener instreamAdListener) {
        Intrinsics.checkNotNullParameter(instreamAdListener, "instreamAdListener");
        this.f10665a = instreamAdListener;
    }

    @Override // com.yandex.mobile.ads.impl.pl0
    public final void onError(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        new CallbackStackTraceMarker(new a(reason));
    }

    @Override // com.yandex.mobile.ads.impl.pl0
    public final void onInstreamAdCompleted() {
        new CallbackStackTraceMarker(new b());
    }

    @Override // com.yandex.mobile.ads.impl.pl0
    public final void onInstreamAdPrepared() {
        new CallbackStackTraceMarker(new c());
    }
}
