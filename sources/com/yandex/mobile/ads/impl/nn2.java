package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public final class nn2 {
    private static nn2 c = new nn2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<mn2> f9747a = new ArrayList<>();
    private final ArrayList<mn2> b = new ArrayList<>();

    private nn2() {
    }

    public static nn2 a() {
        return c;
    }

    public final Collection<mn2> b() {
        return Collections.unmodifiableCollection(this.f9747a);
    }

    public final Collection<mn2> c() {
        return Collections.unmodifiableCollection(this.b);
    }

    public final void a(mn2 mn2Var) {
        this.f9747a.add(mn2Var);
    }

    public final void b(mn2 mn2Var) {
        boolean z = this.b.size() > 0;
        this.b.add(mn2Var);
        if (z) {
            return;
        }
        to2.a().b();
    }

    public final void c(mn2 mn2Var) {
        boolean z = this.b.size() > 0;
        this.f9747a.remove(mn2Var);
        this.b.remove(mn2Var);
        if (!z || this.b.size() > 0) {
            return;
        }
        to2.a().c();
    }
}
