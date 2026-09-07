package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class za1 implements fb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<fb1> f10805a = new CopyOnWriteArrayList<>();

    public final void a(fb1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10805a.add(listener);
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void b() {
        Iterator<fb1> it = this.f10805a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public final void b(fb1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10805a.remove(listener);
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void a(long j, long j2) {
        Iterator<fb1> it = this.f10805a.iterator();
        while (it.hasNext()) {
            it.next().a(j, j2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.fb1
    public final void a() {
        Iterator<fb1> it = this.f10805a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }
}
