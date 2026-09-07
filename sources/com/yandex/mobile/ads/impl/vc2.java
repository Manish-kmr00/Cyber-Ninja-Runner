package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class vc2 implements uc2, wc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f10472a = new LinkedHashSet();
    private final LinkedHashSet b = new LinkedHashSet();

    public final void a(uc2... newProgressChangeListeners) {
        Intrinsics.checkNotNullParameter(newProgressChangeListeners, "newProgressChangeListeners");
        CollectionsKt.addAll(this.f10472a, newProgressChangeListeners);
    }

    public final void a(wc2... newProgressLifecycleListeners) {
        Intrinsics.checkNotNullParameter(newProgressLifecycleListeners, "newProgressLifecycleListeners");
        CollectionsKt.addAll(this.b, newProgressLifecycleListeners);
    }

    @Override // com.yandex.mobile.ads.impl.wc2
    public final void b() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((wc2) it.next()).b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        Iterator it = this.f10472a.iterator();
        while (it.hasNext()) {
            ((uc2) it.next()).a(j, j2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.wc2
    public final void a() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((wc2) it.next()).a();
        }
    }
}
