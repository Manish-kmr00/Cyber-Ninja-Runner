package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ju0 {
    private static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ku0 f9351a;
    private final iu0 b;

    public ju0(ls0 localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        this.f9351a = new ku0(localStorage);
        this.b = new iu0();
    }

    public final String a() {
        String strA;
        synchronized (c) {
            strA = this.f9351a.a();
            if (strA == null) {
                this.b.getClass();
                strA = iu0.a();
                this.f9351a.a(strA);
            }
        }
        return strA;
    }
}
