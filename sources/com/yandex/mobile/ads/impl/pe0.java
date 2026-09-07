package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class pe0 {
    private static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ls0 f9919a;

    public pe0(ls0 localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        this.f9919a = localStorage;
    }

    public final boolean a(lc lcVar) {
        String strA;
        boolean z = false;
        if (lcVar == null || (strA = lcVar.a()) == null) {
            return false;
        }
        synchronized (b) {
            String strD = this.f9919a.d("google_advertising_id_key");
            if (strD != null && !Intrinsics.areEqual(strA, strD)) {
                z = true;
            }
        }
        return z;
    }

    public final void b(lc lcVar) {
        String strD = this.f9919a.d("google_advertising_id_key");
        String strA = lcVar != null ? lcVar.a() : null;
        if (strD != null || strA == null) {
            return;
        }
        this.f9919a.a("google_advertising_id_key", strA);
    }
}
