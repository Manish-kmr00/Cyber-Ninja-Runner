package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.instream.InstreamAdBreakEventListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class ul2 implements kt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InstreamAdBreakEventListener f10402a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ul2.this.f10402a.onInstreamAdBreakCompleted();
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ul2.this.f10402a.onInstreamAdBreakError(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function0<Unit> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ul2.this.f10402a.onInstreamAdBreakPrepared();
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function0<Unit> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ul2.this.f10402a.onInstreamAdBreakStarted();
            return Unit.INSTANCE;
        }
    }

    public ul2(InstreamAdBreakEventListener adBreakEventListener) {
        Intrinsics.checkNotNullParameter(adBreakEventListener, "adBreakEventListener");
        this.f10402a = adBreakEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.kt0
    public final void onInstreamAdBreakCompleted() {
        new CallbackStackTraceMarker(new a());
    }

    @Override // com.yandex.mobile.ads.impl.kt0
    public final void onInstreamAdBreakError(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        new CallbackStackTraceMarker(new b(reason));
    }

    @Override // com.yandex.mobile.ads.impl.kt0
    public final void onInstreamAdBreakPrepared() {
        new CallbackStackTraceMarker(new c());
    }

    @Override // com.yandex.mobile.ads.impl.kt0
    public final void onInstreamAdBreakStarted() {
        new CallbackStackTraceMarker(new d());
    }
}
