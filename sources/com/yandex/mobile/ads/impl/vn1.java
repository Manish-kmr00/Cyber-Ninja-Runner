package com.yandex.mobile.ads.impl;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10498a;
    private final long b;
    private final d42 c;
    private final un1 d;
    private final ConcurrentLinkedQueue<tn1> e;

    public vn1(e42 taskRunner, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.f10498a = 5;
        this.b = timeUnit.toNanos(5L);
        this.c = taskRunner.e();
        this.d = new un1(this, y82.g + " ConnectionPool");
        this.e = new ConcurrentLinkedQueue<>();
    }

    public final boolean a(ab address, sn1 call, List<os1> list, boolean z) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        for (tn1 tn1Var : this.e) {
            Intrinsics.checkNotNull(tn1Var);
            synchronized (tn1Var) {
                if (z) {
                    if (tn1Var.h()) {
                    }
                    Unit unit = Unit.INSTANCE;
                }
                if (tn1Var.a(address, list)) {
                    call.a(tn1Var);
                    return true;
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return false;
    }

    public final void b(tn1 connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (y82.f && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        this.e.add(connection);
        this.c.a(this.d, 0L);
    }

    public final long a(long j) {
        int i = 0;
        long j2 = Long.MIN_VALUE;
        tn1 tn1Var = null;
        int i2 = 0;
        for (tn1 tn1Var2 : this.e) {
            Intrinsics.checkNotNull(tn1Var2);
            synchronized (tn1Var2) {
                if (a(tn1Var2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long jC = j - tn1Var2.c();
                    if (jC > j2) {
                        tn1Var = tn1Var2;
                        j2 = jC;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        long j3 = this.b;
        if (j2 < j3 && i <= this.f10498a) {
            if (i > 0) {
                return j3 - j2;
            }
            if (i2 > 0) {
                return j3;
            }
            return -1L;
        }
        Intrinsics.checkNotNull(tn1Var);
        synchronized (tn1Var) {
            if (!tn1Var.b().isEmpty()) {
                return 0L;
            }
            if (tn1Var.c() + j2 != j) {
                return 0L;
            }
            tn1Var.l();
            this.e.remove(tn1Var);
            y82.a(tn1Var.m());
            if (this.e.isEmpty()) {
                this.c.a();
            }
            return 0L;
        }
    }

    public final boolean a(tn1 connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (y82.f && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (connection.d() || this.f10498a == 0) {
            connection.l();
            this.e.remove(connection);
            if (this.e.isEmpty()) {
                this.c.a();
            }
            return true;
        }
        this.c.a(this.d, 0L);
        return false;
    }

    private final int a(tn1 tn1Var, long j) {
        if (y82.f && !Thread.holdsLock(tn1Var)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + tn1Var);
        }
        ArrayList arrayListB = tn1Var.b();
        int i = 0;
        while (i < arrayListB.size()) {
            Reference reference = (Reference) arrayListB.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Intrinsics.checkNotNull(reference, "null cannot be cast to non-null type com.monetization.ads.embedded.okhttp.src.main.kotlin.okhttp3.internal.connection.RealCall.CallReference");
                String str = "A connection to " + tn1Var.k().a().k() + " was leaked. Did you forget to close a response body?";
                int i2 = nh1.c;
                nh1.a.a().a(((sn1.b) reference).a(), str);
                arrayListB.remove(i);
                tn1Var.l();
                if (arrayListB.isEmpty()) {
                    tn1Var.a(j - this.b);
                    return 0;
                }
            }
        }
        return arrayListB.size();
    }
}
