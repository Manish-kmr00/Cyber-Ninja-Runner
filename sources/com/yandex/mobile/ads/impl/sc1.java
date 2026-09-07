package com.yandex.mobile.ads.impl;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class sc1 {
    @JvmStatic
    public static final pi2 a(o3 adConfiguration, si2 volleyResponseBodyParser) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(volleyResponseBodyParser, "volleyResponseBodyParser");
        vq1 responseBodyParser = new vq1(volleyResponseBodyParser);
        mi2 mi2Var = new mi2();
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(responseBodyParser, "responseBodyParser");
        return new pi2(adConfiguration, volleyResponseBodyParser, responseBodyParser, mi2Var, new zc1(adConfiguration, responseBodyParser, new p80(), new ez0(), new pr1(), new gs(), new lg0(), new qs0(), new md(), new p8()));
    }

    @JvmStatic
    public static final oi2 a() {
        return new oi2(new mi2(), new wc1());
    }
}
