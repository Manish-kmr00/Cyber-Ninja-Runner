package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.instream.InstreamAdLoadListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class yl2 implements ft {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InstreamAdLoadListener f10751a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            yl2.this.f10751a.onInstreamAdFailedToLoad(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ sl2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(sl2 sl2Var) {
            super(0);
            this.c = sl2Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            yl2.this.f10751a.onInstreamAdLoaded(this.c);
            return Unit.INSTANCE;
        }
    }

    public yl2(InstreamAdLoadListener yandexAdLoadListener) {
        Intrinsics.checkNotNullParameter(yandexAdLoadListener, "yandexAdLoadListener");
        this.f10751a = yandexAdLoadListener;
    }

    @Override // com.yandex.mobile.ads.impl.ft
    public final void onInstreamAdFailedToLoad(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        new CallbackStackTraceMarker(new a(reason));
    }

    @Override // com.yandex.mobile.ads.impl.ft
    public final void a(bt instreamAd) {
        Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
        new CallbackStackTraceMarker(new b(new sl2(instreamAd)));
    }
}
