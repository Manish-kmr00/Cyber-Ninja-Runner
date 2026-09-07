package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tr1 {
    public static vc0 a(ul1 progressListener, j91 nativeMediaContent, y42 timeProviderContainer) {
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        za1 za1VarA = nativeMediaContent.a();
        ec1 ec1VarB = nativeMediaContent.b();
        if (za1VarA != null) {
            return new nb1(za1VarA, progressListener, timeProviderContainer, timeProviderContainer.e(), timeProviderContainer.a());
        }
        if (ec1VarB != null) {
            return null;
        }
        int i = ig1.f9217a;
        return new a91(progressListener, timeProviderContainer, ig1.a.a(false), timeProviderContainer.e(), timeProviderContainer.a(), timeProviderContainer.d());
    }
}
