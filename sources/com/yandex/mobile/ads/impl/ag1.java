package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class ag1 extends IOException {
    public final boolean b;
    public final int c;

    public static ag1 a(String str, IllegalArgumentException illegalArgumentException) {
        return new ag1(str, illegalArgumentException, true, 0);
    }

    protected ag1(String str, Exception exc, boolean z, int i) {
        super(str, exc);
        this.b = z;
        this.c = i;
    }

    public static ag1 a(String str, Exception exc) {
        return new ag1(str, exc, true, 1);
    }

    public static ag1 a(String str) {
        return new ag1(str, null, false, 1);
    }
}
