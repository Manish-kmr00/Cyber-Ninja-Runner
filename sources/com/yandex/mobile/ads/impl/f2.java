package com.yandex.mobile.ads.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8861a = new Object();
    private final WeakHashMap<e2, Object> b = new WeakHashMap<>();

    public final void b(e2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f8861a) {
            this.b.remove(listener);
        }
    }

    public final void a() {
        HashSet hashSet;
        synchronized (this.f8861a) {
            hashSet = new HashSet(this.b.keySet());
            this.b.clear();
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((e2) it.next()).a();
        }
    }

    public final void a(e2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f8861a) {
            this.b.put(listener, null);
        }
    }
}
