package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class p81 implements s51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f9902a = new CopyOnWriteArrayList();
    private boolean b;

    public final void a(o81 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f9902a.add(listener);
        if (this.b) {
            listener.b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.s51
    public final void b() {
        this.b = true;
        Iterator it = this.f9902a.iterator();
        while (it.hasNext()) {
            ((s51) it.next()).b();
        }
    }

    public final void b(o81 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f9902a.remove(listener);
    }

    @Override // com.yandex.mobile.ads.impl.s51
    public final void a() {
        this.b = false;
        Iterator it = this.f9902a.iterator();
        while (it.hasNext()) {
            ((s51) it.next()).a();
        }
    }
}
