package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class oo2 {
    public static void a(mn2 mn2Var) {
        if (!mn2Var.h()) {
            throw new IllegalStateException("AdSession is not started");
        }
        if (mn2Var.k()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }
}
