package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class rv extends IOException {
    public static final /* synthetic */ int c = 0;
    public final int b;

    public rv(int i) {
        this.b = i;
    }

    public rv(int i, String str) {
        super(str);
        this.b = i;
    }

    public rv(int i, String str, Throwable th) {
        super(str, th);
        this.b = i;
    }

    public rv(Throwable th, int i) {
        super(th);
        this.b = i;
    }
}
