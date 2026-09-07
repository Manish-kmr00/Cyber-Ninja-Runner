package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class je1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f9310a = new Object();
    private final WeakHashMap<ua2, Object> b = new WeakHashMap<>();

    public final void b() {
        ArrayList<ua2> arrayList;
        synchronized (this.f9310a) {
            arrayList = new ArrayList(this.b.keySet());
            this.b.clear();
            Unit unit = Unit.INSTANCE;
        }
        for (ua2 ua2Var : arrayList) {
            if (ua2Var != null) {
                ua2Var.a();
            }
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this.f9310a) {
            z = !this.b.isEmpty();
        }
        return z;
    }

    public final void b(ua2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f9310a) {
            this.b.remove(listener);
        }
    }

    public final void a(ua2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f9310a) {
            this.b.put(listener, null);
            Unit unit = Unit.INSTANCE;
        }
    }
}
