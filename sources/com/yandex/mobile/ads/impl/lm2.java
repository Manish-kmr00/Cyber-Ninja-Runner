package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.nativeads.NativeAdImageLoadingListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class lm2 implements rt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NativeAdImageLoadingListener f9540a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            lm2.this.f9540a.onFinishLoadingImages();
            return Unit.INSTANCE;
        }
    }

    public lm2(NativeAdImageLoadingListener imageLoadingListener) {
        Intrinsics.checkNotNullParameter(imageLoadingListener, "imageLoadingListener");
        this.f9540a = imageLoadingListener;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof lm2) && Intrinsics.areEqual(this.f9540a, ((lm2) obj).f9540a);
    }

    public final int hashCode() {
        return this.f9540a.hashCode();
    }

    @Override // com.yandex.mobile.ads.impl.rt
    public final void onFinishLoadingImages() {
        new CallbackStackTraceMarker(new a());
    }

    public final String toString() {
        return "YandexNativeAdImageLoadingListenerAdapter(imageLoadingListener=" + this.f9540a + ")";
    }
}
