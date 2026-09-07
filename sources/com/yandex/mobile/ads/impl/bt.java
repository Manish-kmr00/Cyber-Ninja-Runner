package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<dt> f8538a;

    public bt(ArrayList adBreaks) {
        Intrinsics.checkNotNullParameter(adBreaks, "adBreaks");
        this.f8538a = adBreaks;
    }

    public final void b() {
        Iterator<dt> it = this.f8538a.iterator();
        while (it.hasNext()) {
            it.next().a(null);
        }
    }

    public final List<dt> a() {
        return this.f8538a;
    }
}
