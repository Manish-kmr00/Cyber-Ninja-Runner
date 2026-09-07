package com.yandex.mobile.ads.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class kq implements y62 {
    @Override // com.yandex.mobile.ads.impl.y62
    public final lq a(ls0 localStorage, eq type) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Intrinsics.checkNotNullParameter(type, "type");
        if (!localStorage.c(type.b())) {
            type = null;
        }
        if (type != null) {
            return b(localStorage, type);
        }
        return null;
    }

    private static lq b(ls0 ls0Var, eq eqVar) {
        lq cVar;
        String strB = eqVar.b();
        try {
            int iOrdinal = eqVar.ordinal();
            if (iOrdinal != 0) {
                boolean z = true;
                if (iOrdinal == 1) {
                    int iB = ls0Var.b(-1, strB);
                    Integer numValueOf = Integer.valueOf(iB);
                    if (iB == -1) {
                        numValueOf = null;
                    }
                    cVar = new lq.d(numValueOf != null ? String.valueOf(numValueOf.intValue()) : null);
                } else if (iOrdinal == 2) {
                    if (ls0Var.b(-1, strB) == -1) {
                        z = false;
                    }
                    cVar = new lq.b(z);
                } else if (iOrdinal == 3) {
                    cVar = new lq.e(ls0Var.d(strB));
                } else if (iOrdinal == 4) {
                    cVar = new lq.f(ls0Var.d(strB));
                } else {
                    if (iOrdinal != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    cVar = new lq.a(ls0Var.d(strB));
                }
            } else {
                cVar = new lq.c(ls0Var.d(strB));
            }
            return cVar;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y62
    public final lq a(ls0 localStorage, String v2) {
        eq eqVar;
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Intrinsics.checkNotNullParameter(v2, "key");
        if (!localStorage.c(v2)) {
            v2 = null;
        }
        if (v2 != null) {
            eq.d.getClass();
            Intrinsics.checkNotNullParameter(v2, "v2");
            eq[] eqVarArrValues = eq.values();
            int length = eqVarArrValues.length;
            for (int i = 0; i < length; i++) {
                eqVar = eqVarArrValues[i];
                if (!Intrinsics.areEqual(eqVar.b(), v2)) {
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
