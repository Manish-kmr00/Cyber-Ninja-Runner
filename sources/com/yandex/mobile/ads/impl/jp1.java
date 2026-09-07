package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class jp1 {
    public static final ip1 a(ip1 ip1Var, ip1 ip1Var2) {
        Intrinsics.checkNotNullParameter(ip1Var, "<this>");
        if (ip1Var2 == null) {
            return new ip1((Map<String, ? extends Object>) ip1Var.b(), ip1Var.a());
        }
        f fVarA = ip1Var.a();
        if (fVarA == null) {
            fVarA = ip1Var2.a();
        }
        return new ip1((Map<String, ? extends Object>) MapsKt.plus(ip1Var.b(), ip1Var2.b()), fVarA);
    }
}
