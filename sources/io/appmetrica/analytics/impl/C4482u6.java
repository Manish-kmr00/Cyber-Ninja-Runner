package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.u6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4482u6 implements Ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f11793a = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.Ma
    public final void a(Throwable th, S s) {
        Iterator it = this.f11793a.iterator();
        while (it.hasNext()) {
            ((Ma) it.next()).a(th, s);
        }
    }

    public final void a(Ma... maArr) {
        CollectionsKt.addAll(this.f11793a, maArr);
    }

    public final void a(List<? extends Ma> list) {
        this.f11793a.addAll(list);
    }

    public final void a() {
        this.f11793a.clear();
    }
}
