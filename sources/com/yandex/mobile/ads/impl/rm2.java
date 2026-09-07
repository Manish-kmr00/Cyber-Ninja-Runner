package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.common.AdRequestError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
public final class rm2 implements st {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.yandex.mobile.ads.nativeads.a f10123a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ AdRequestError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AdRequestError adRequestError) {
            super(0);
            this.c = adRequestError;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            rm2.this.f10123a.onAdFailedToLoad(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ com.yandex.mobile.ads.nativeads.e c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(com.yandex.mobile.ads.nativeads.e eVar) {
            super(0);
            this.c = eVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            rm2.this.f10123a.onAdLoaded(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function0<Unit> {
        c(com.yandex.mobile.ads.nativeads.e eVar) {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            rm2.this.f10123a.a();
            return Unit.INSTANCE;
        }
    }

    public rm2(com.yandex.mobile.ads.nativeads.a loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        this.f10123a = loadListener;
    }

    @Override // com.yandex.mobile.ads.impl.st
    public final void b(m61 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        new CallbackStackTraceMarker(new c(new com.yandex.mobile.ads.nativeads.e(nativeAd)));
    }

    @Override // com.yandex.mobile.ads.impl.st
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(error, "error");
        new CallbackStackTraceMarker(new a(new AdRequestError(error.b(), error.d(), error.a())));
    }

    @Override // com.yandex.mobile.ads.impl.st
    public final void a(m61 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        new CallbackStackTraceMarker(new b(new com.yandex.mobile.ads.nativeads.e(nativeAd)));
    }
}
