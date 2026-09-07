package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class sz1 implements p41 {
    @Override // com.yandex.mobile.ads.impl.p41
    public final void a(Context context, o41 nativeAdBlock, pj0 imageProvider, n41 nativeAdBinderFactory, o51 nativeAdFactoriesProvider, a51 nativeAdControllers, c51 nativeAdCreationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeAdBinderFactory, "nativeAdBinderFactory");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(nativeAdCreationListener, "nativeAdCreationListener");
        nativeAdCreationListener.a(nativeAdBinderFactory.a(context, nativeAdBlock, imageProvider, nativeAdFactoriesProvider, nativeAdControllers));
    }
}
