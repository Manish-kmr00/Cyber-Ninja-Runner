package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.n4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4306n4 extends Pc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ke f11680a;

    public C4306n4(Context context) {
        this(new Ke(C4135g7.a(context).b()));
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final void a(int i) {
        this.f11680a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final int b() {
        return (int) this.f11680a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final SparseArray<Oc> c() {
        return new SparseArray<>();
    }

    public C4306n4(Ke ke) {
        this.f11680a = ke;
    }
}
