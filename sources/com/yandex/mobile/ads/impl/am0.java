package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class am0 implements dd2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ub2 f8418a;

    public am0(do0 videoAd, ub2 infoDataProvider) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(infoDataProvider, "infoDataProvider");
        this.f8418a = infoDataProvider;
    }

    @Override // com.yandex.mobile.ads.impl.dd2.b
    public final ip1 a() {
        ip1 ip1Var = new ip1(new LinkedHashMap(), 2);
        ip1Var.b(this.f8418a.a(), "product_type");
        return ip1Var;
    }
}
