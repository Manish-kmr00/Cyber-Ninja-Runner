package io.appmetrica.analytics.impl;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes7.dex */
public final class Xj extends Pc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Tn f11422a;

    public Xj() {
        this(C4486ua.j().B().b());
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final void a(int i) {
        Tn tn = this.f11422a;
        synchronized (tn) {
            Vn vn = tn.f11370a;
            vn.a(vn.a().put("last_migration_api_level", i));
        }
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final int b() {
        int iOptInt;
        Tn tn = this.f11422a;
        synchronized (tn) {
            iOptInt = tn.f11370a.a().optInt("last_migration_api_level", -1);
        }
        return iOptInt;
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final SparseArray<Oc> c() {
        SparseArray<Oc> sparseArray = new SparseArray<>(1);
        sparseArray.put(112, new Yj(this.f11422a));
        sparseArray.put(115, new Zj());
        return sparseArray;
    }

    public Xj(Tn tn) {
        this.f11422a = tn;
    }
}
