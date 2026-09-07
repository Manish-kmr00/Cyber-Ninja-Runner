package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.common.AdRequestError;
import com.yandex.mobile.ads.nativeads.SliderAdLoadListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class zm2 implements hu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SliderAdLoadListener f10831a;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ AdRequestError c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AdRequestError adRequestError) {
            super(0);
            this.c = adRequestError;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            zm2.this.f10831a.onSliderAdFailedToLoad(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ com.yandex.mobile.ads.nativeads.i c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(com.yandex.mobile.ads.nativeads.i iVar) {
            super(0);
            this.c = iVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            zm2.this.f10831a.onSliderAdLoaded(this.c);
            return Unit.INSTANCE;
        }
    }

    public zm2(SliderAdLoadListener loadListener) {
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        this.f10831a = loadListener;
    }

    @Override // com.yandex.mobile.ads.impl.hu
    public final void a(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        new CallbackStackTraceMarker(new a(new AdRequestError(error.b(), error.d(), error.a())));
    }

    @Override // com.yandex.mobile.ads.impl.hu
    public final void a(uz1 sliderAd) {
        Intrinsics.checkNotNullParameter(sliderAd, "sliderAd");
        new CallbackStackTraceMarker(new b(new com.yandex.mobile.ads.nativeads.i(sliderAd, new com.yandex.mobile.ads.nativeads.g())));
    }
}
