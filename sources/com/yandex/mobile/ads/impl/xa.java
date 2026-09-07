package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class xa implements vg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hp1.c f10634a;
    private final String b;

    public xa(hp1.c status, String str) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.f10634a = status;
        this.b = str;
    }

    @Override // com.yandex.mobile.ads.impl.vg1
    public final Map<String, Object> a(long j) {
        ip1 ip1Var = new ip1((Map) null, 3);
        ip1Var.b(this.b, "adapter");
        ip1Var.b(this.f10634a.a(), "status");
        ip1Var.b(Long.valueOf(j), "duration");
        return ip1Var.b();
    }
}
