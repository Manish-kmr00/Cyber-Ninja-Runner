package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h6 implements z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9065a;

    public h6(List<m6> adPodItems) {
        Intrinsics.checkNotNullParameter(adPodItems, "adPodItems");
        Iterator<T> it = adPodItems.iterator();
        long jA = 0;
        while (it.hasNext()) {
            jA += ((m6) it.next()).a();
        }
        this.f9065a = jA;
    }

    @Override // com.yandex.mobile.ads.impl.z1
    public final long a() {
        return this.f9065a;
    }

    @Override // com.yandex.mobile.ads.impl.z1
    public final long a(long j) {
        return this.f9065a;
    }
}
