package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final el f8777a;

    public ea(el biddingSettings) {
        Intrinsics.checkNotNullParameter(biddingSettings, "biddingSettings");
        this.f8777a = biddingSettings;
    }

    public final b01 a(String str) {
        d01 d01VarD;
        List<a01> listE;
        Object next;
        d01 d01VarD2 = this.f8777a.d();
        if (d01VarD2 != null && (d01VarD = this.f8777a.d()) != null && (listE = d01VarD.e()) != null) {
            Iterator<T> it = listE.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((a01) next).d(), str));
            a01 a01Var = (a01) next;
            if (a01Var != null) {
                return new b01(d01VarD2.d(), a01Var.d(), a01Var.e());
            }
        }
        return null;
    }
}
