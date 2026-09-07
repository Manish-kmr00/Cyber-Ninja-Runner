package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a42 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8368a;
    private final boolean b;
    private d42 c;
    private long d;

    public abstract long e();

    public /* synthetic */ a42(String str) {
        this(str, true);
    }

    public a42(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f8368a = name;
        this.b = z;
        this.d = -1L;
    }

    public final String b() {
        return this.f8368a;
    }

    public final boolean a() {
        return this.b;
    }

    public final void a(d42 queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        d42 d42Var = this.c;
        if (d42Var == queue) {
            return;
        }
        if (d42Var == null) {
            this.c = queue;
            return;
        }
        throw new IllegalStateException("task is in multiple queues".toString());
    }

    public final d42 d() {
        return this.c;
    }

    public final long c() {
        return this.d;
    }

    public final String toString() {
        return this.f8368a;
    }

    public final void a(long j) {
        this.d = j;
    }
}
