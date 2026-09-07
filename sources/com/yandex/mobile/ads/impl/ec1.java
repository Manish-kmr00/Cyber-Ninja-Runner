package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ec1 implements ve1, o11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<fc1> f8784a = new CopyOnWriteArrayList<>();

    public final void a(fc1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f8784a.add(listener);
    }

    public final void b(fc1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f8784a.remove(listener);
    }

    @Override // com.yandex.mobile.ads.impl.ve1
    public final void c() {
    }

    @Override // com.yandex.mobile.ads.impl.o11
    public final void a() {
        Iterator<fc1> it = this.f8784a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ve1
    public final void a(boolean z) {
        Iterator<fc1> it = this.f8784a.iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }
}
