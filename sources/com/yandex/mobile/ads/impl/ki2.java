package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public class ki2 extends Exception {
    public final tc1 b;

    public ki2() {
        this.b = null;
    }

    public ki2(tc1 tc1Var) {
        this.b = tc1Var;
    }

    public ki2(Exception exc) {
        super("Failed to parse response", exc);
        this.b = null;
    }

    public ki2(String str) {
        super(str);
        this.b = null;
    }

    public ki2(Throwable th) {
        super(th);
        this.b = null;
    }
}
