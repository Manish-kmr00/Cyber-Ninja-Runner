package com.yandex.mobile.ads.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
final class ej1 extends h {
    private final int f;
    private final int g;
    private final int[] h;
    private final int[] i;
    private final b52[] j;
    private final Object[] k;
    private final HashMap<Object, Integer> l;

    public ej1(List list, by1 by1Var) {
        super(by1Var);
        int size = list.size();
        this.h = new int[size];
        this.i = new int[size];
        this.j = new b52[size];
        this.k = new Object[size];
        this.l = new HashMap<>();
        Iterator it = list.iterator();
        int iB = 0;
        int iA = 0;
        int i = 0;
        while (it.hasNext()) {
            tw0 tw0Var = (tw0) it.next();
            this.j[i] = tw0Var.b();
            this.i[i] = iB;
            this.h[i] = iA;
            iB += this.j[i].b();
            iA += this.j[i].a();
            this.k[i] = tw0Var.a();
            this.l.put(this.k[i], Integer.valueOf(i));
            i++;
        }
        this.f = iB;
        this.g = iA;
    }

    final List<b52> d() {
        return Arrays.asList(this.j);
    }

    @Override // com.yandex.mobile.ads.impl.h
    protected final int c(int i) {
        return x82.a(this.i, i + 1, false, false);
    }

    @Override // com.yandex.mobile.ads.impl.h
    protected final int b(Object obj) {
        Integer num = this.l.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.yandex.mobile.ads.impl.h
    protected final b52 g(int i) {
        return this.j[i];
    }

    @Override // com.yandex.mobile.ads.impl.h
    protected final int e(int i) {
        return this.h[i];
    }

    @Override // com.yandex.mobile.ads.impl.h
    protected final int f(int i) {
        return this.i[i];
    }

    @Override // com.yandex.mobile.ads.impl.b52
    public final int a() {
        return this.g;
    }

    @Override // com.yandex.mobile.ads.impl.h
    protected final int b(int i) {
        return x82.a(this.h, i + 1, false, false);
    }

    @Override // com.yandex.mobile.ads.impl.h
    protected final Object d(int i) {
        return this.k[i];
    }

    @Override // com.yandex.mobile.ads.impl.b52
    public final int b() {
        return this.f;
    }
}
