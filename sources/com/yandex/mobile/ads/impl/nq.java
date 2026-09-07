package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes5.dex */
final class nq {
    static int a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }
}
