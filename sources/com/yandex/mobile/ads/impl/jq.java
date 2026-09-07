package com.yandex.mobile.ads.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class jq implements y62 {
    @Override // com.yandex.mobile.ads.impl.y62
    public final lq a(ls0 localStorage, eq type) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Intrinsics.checkNotNullParameter(type, "type");
        if (type.a() == null || !localStorage.c(type.a())) {
            type = null;
        }
        if (type != null) {
            return b(localStorage, type);
        }
        return null;
    }

    private static lq b(ls0 ls0Var, eq eqVar) {
        lq cVar;
        String strA = eqVar.a();
        if (strA == null) {
            return null;
        }
        try {
            int iOrdinal = eqVar.ordinal();
            if (iOrdinal == 0) {
                cVar = new lq.c(ls0Var.d(strA));
            } else if (iOrdinal == 1) {
                cVar = new lq.d(ls0Var.d(strA));
            } else if (iOrdinal == 2) {
                cVar = new lq.b(ls0Var.a(strA, false));
            } else if (iOrdinal == 3) {
                cVar = new lq.e(ls0Var.d(strA));
            } else {
                if (iOrdinal != 4) {
                    if (iOrdinal == 5) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                cVar = new lq.f(ls0Var.d(strA));
            }
            return cVar;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y62
    public final lq a(ls0 localStorage, String v1) {
        eq eqVar;
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Intrinsics.checkNotNullParameter(v1, "key");
        if (!localStorage.c(v1)) {
            v1 = null;
        }
        if (v1 != null) {
            eq.d.getClass();
            Intrinsics.checkNotNullParameter(v1, "v1");
            eq[] eqVarArrValues = eq.values();
            int length = eqVarArrValues.length;
            for (int i = 0; i < length; i++) {
                eqVar = eqVarArrValues[i];
                if (!Intrinsics.areEqual(eqVar.a(), v1)) {
                }
            }
            eqVar = null;
        } else {
            eqVar = null;
        }
        if (eqVar != null) {
            return b(localStorage, eqVar);
        }
        return null;
    }
}
