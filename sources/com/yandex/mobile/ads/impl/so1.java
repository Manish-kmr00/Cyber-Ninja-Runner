package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes7.dex */
public interface so1 {
    static int a(int i) {
        return i & 128;
    }

    static int a(int i, int i2, int i3) {
        return i | i2 | i3 | 128;
    }

    static int b(int i) {
        return i & 64;
    }

    int a(gc0 gc0Var) throws j60;

    int f() throws j60;

    String getName();
}
