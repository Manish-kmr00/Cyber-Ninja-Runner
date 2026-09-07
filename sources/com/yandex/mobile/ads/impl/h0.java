package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {
    public static i0 a() {
        i0 i0Var;
        i0 i0Var2 = i0.g;
        if (i0Var2 != null) {
            return i0Var2;
        }
        synchronized (i0.f) {
            i0Var = i0.g;
            if (i0Var == null) {
                i0Var = new i0();
                i0.g = i0Var;
            }
        }
        return i0Var;
    }
}
