package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.nativeads.NativeAdLoadListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class mm2 implements st {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NativeAdLoadListener f9657a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ AdRequestError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AdRequestError adRequestError) {
            super(0);
            this.c = adRequestError;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            mm2.this.f9657a.onAdFailedToLoad(this.c);
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
            mm2.this.f9657a.onAdLoaded(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function0<Unit> {
        final /* synthetic */ com.yandex.mobile.ads.nativeads.e c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(com.yandex.mobile.ads.nativeads.e eVar) {
            super(0);
            this.c = eVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            mm2.this.f9657a.onAdLoaded(this.c);
            return Unit.INSTANCE;
        }
    }

    public mm2(NativeAdLoadListener nativeAdLoadListener) {
        Intrinsics.checkNotNullParameter(nativeAdLoadListener, "nativeAdLoadListener");
        this.f9657a = nativeAdLoadListener;
    }

    @Override // com.yandex.mobile.ads.impl.st
    public final void b(m61 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        new CallbackStackTraceMarker(new c(new com.yandex.mobile.ads.nativeads.e(nativeAd)));
    }

    @Override // com.yandex.mobile.ads.impl.st
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        new CallbackStackTraceMarker(new a(new AdRequestError(error.b(), error.d(), error.a())));
    }

    @Override // com.yandex.mobile.ads.impl.st
    public final void a(m61 nativeAd) {
        Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
        new CallbackStackTraceMarker(new b(new com.yandex.mobile.ads.nativeads.e(nativeAd)));
    }
}
