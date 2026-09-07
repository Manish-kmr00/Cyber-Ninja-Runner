package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8465a = new Object();
    private final ArrayList b = new ArrayList();

    public final void a() {
        ArrayList<el0> arrayList;
        synchronized (this.f8465a) {
            arrayList = new ArrayList(this.b);
            this.b.clear();
            Unit unit = Unit.INSTANCE;
        }
        for (el0 el0Var : arrayList) {
            if (el0Var != null) {
                el0Var.a();
            }
        }
    }

    public final void a(el0 initializationObserver) {
        Intrinsics.checkNotNullParameter(initializationObserver, "initializationObserver");
        synchronized (this.f8465a) {
            this.b.add(initializationObserver);
        }
    }
}
