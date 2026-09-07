package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.InstreamAd;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class jt {
    public static bt a(InstreamAd instreamAd) {
        Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
        if (instreamAd instanceof sl2) {
            return ((sl2) instreamAd).a();
        }
        throw new IllegalArgumentException("You should pass InstreamAd received from InstreamAdLoader");
    }
}
