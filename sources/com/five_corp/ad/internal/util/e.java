package com.five_corp.ad.internal.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f1559a = new h();

    public final void a(Object obj) {
        synchronized (this.b) {
            this.f1559a.f1561a.add(new WeakReference(obj));
        }
    }

    public final ArrayList a() {
        ArrayList arrayList;
        synchronized (this.b) {
            h hVar = this.f1559a;
            hVar.getClass();
            arrayList = new ArrayList();
            hVar.a(arrayList);
        }
        return arrayList;
    }
}
