package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class oj2 implements Runnable {
    private final int b;
    private final String c;
    private final bh0 d;

    public oj2(int i, String str, bh0 htmlWebViewRenderer) {
        Intrinsics.checkNotNullParameter(htmlWebViewRenderer, "htmlWebViewRenderer");
        this.b = i;
        this.c = str;
        this.d = htmlWebViewRenderer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a(this.b, this.c);
    }
}
