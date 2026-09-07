package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ku0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ls0 f9449a;
    private final Object b;
    private String c;

    public ku0(ls0 localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        this.f9449a = localStorage;
        this.b = new Object();
    }

    public final String a() {
        String str;
        synchronized (this.b) {
            if (this.c == null) {
                this.c = this.f9449a.d("YmadMauid");
            }
            str = this.c;
        }
        return str;
    }

    public final void a(String mauid) {
        Intrinsics.checkNotNullParameter(mauid, "mauid");
        synchronized (this.b) {
            this.c = mauid;
            this.f9449a.a("YmadMauid", mauid);
            Unit unit = Unit.INSTANCE;
        }
    }
}
