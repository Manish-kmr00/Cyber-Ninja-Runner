package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class nn0 {
    public static mn0 a(cu1 cu1Var) {
        String value;
        mn0 mn0Var;
        if (cu1Var != null && (value = cu1Var.z()) != null) {
            mn0.c.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            mn0[] mn0VarArrValues = mn0.values();
            int length = mn0VarArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    mn0Var = null;
                    break;
                }
                mn0Var = mn0VarArrValues[i];
                if (Intrinsics.areEqual(mn0Var.b(), value)) {
                    break;
                }
                i++;
            }
            if (mn0Var != null) {
                return mn0Var;
            }
        }
        mn0.c.getClass();
        return mn0.d;
    }
}
