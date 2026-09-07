package com.chartboost.sdk.impl;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class h1 implements Comparable<h1> {
    public final k8 b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final AtomicInteger g;
    public final AtomicReference<d1> h;
    public final AtomicInteger i;

    public h1(k8 k8Var, String str, String str2, String str3, AtomicInteger atomicInteger, AtomicReference<d1> atomicReference, AtomicInteger atomicInteger2, String str4) {
        this.b = k8Var;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.g = atomicInteger;
        this.h = atomicReference;
        this.i = atomicInteger2;
        this.f = str4;
        atomicInteger.incrementAndGet();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h1 h1Var) {
        return this.b.getValue() - h1Var.b.getValue();
    }

    public void a(Executor executor, boolean z) {
        d1 andSet;
        if ((this.g.decrementAndGet() == 0 || !z) && (andSet = this.h.getAndSet(null)) != null) {
            executor.execute(new e1(andSet, z, this.i.get()));
        }
    }
}
