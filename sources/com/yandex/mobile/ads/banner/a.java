package com.yandex.mobile.ads.banner;

import com.yandex.mobile.ads.impl.ws;
import com.yandex.mobile.ads.impl.zy1;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    @JvmStatic
    public static final ws a(BannerAdSize adSize) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        zy1 b = adSize.getB();
        Intrinsics.checkNotNullExpressionValue(b, "getSizeInfo(...)");
        return new ws(b);
    }
}
