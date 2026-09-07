package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes13.dex */
public class tc {
    public static tc c = new tc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<zb> f1145a = new ArrayList<>();
    public final ArrayList<zb> b = new ArrayList<>();

    public static tc c() {
        return c;
    }

    public Collection<zb> a() {
        return Collections.unmodifiableCollection(this.b);
    }

    public Collection<zb> b() {
        return Collections.unmodifiableCollection(this.f1145a);
    }

    public boolean d() {
        return this.b.size() > 0;
    }

    public void a(zb zbVar) {
        this.f1145a.add(zbVar);
    }

    public void b(zb zbVar) {
        boolean zD = d();
        this.f1145a.remove(zbVar);
        this.b.remove(zbVar);
        if (!zD || d()) {
            return;
        }
        pd.c().e();
    }

    public void c(zb zbVar) {
        boolean zD = d();
        this.b.add(zbVar);
        if (zD) {
            return;
        }
        pd.c().d();
    }
}
