package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d42 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e42 f8664a;
    private final String b;
    private boolean c;
    private a42 d;
    private final ArrayList e;
    private boolean f;

    public d42(e42 taskRunner, String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f8664a = taskRunner;
        this.b = name;
        this.e = new ArrayList();
    }

    public final void a(a42 task, long j) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.f8664a) {
            if (!this.c) {
                if (a(task, j, false)) {
                    this.f8664a.a(this);
                }
                Unit unit = Unit.INSTANCE;
            } else if (task.a()) {
                e42 e42Var = e42.h;
                if (e42.i.isLoggable(Level.FINE)) {
                    b42.b(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                e42 e42Var2 = e42.h;
                if (e42.i.isLoggable(Level.FINE)) {
                    b42.b(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final void j() {
        if (y82.f && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.f8664a) {
            this.c = true;
            if (b()) {
                this.f8664a.a(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final ArrayList e() {
        return this.e;
    }

    public final void i() {
        this.f = false;
    }

    public final e42 h() {
        return this.f8664a;
    }

    public final String f() {
        return this.b;
    }

    public final boolean g() {
        return this.c;
    }

    public final a42 c() {
        return this.d;
    }

    public final boolean d() {
        return this.f;
    }

    public final boolean b() {
        a42 a42Var = this.d;
        if (a42Var != null) {
            Intrinsics.checkNotNull(a42Var);
            if (a42Var.a()) {
                this.f = true;
            }
        }
        boolean z = false;
        for (int size = this.e.size() - 1; -1 < size; size--) {
            if (((a42) this.e.get(size)).a()) {
                a42 a42Var2 = (a42) this.e.get(size);
                if (e42.i.isLoggable(Level.FINE)) {
                    b42.b(a42Var2, this, "canceled");
                }
                this.e.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final String toString() {
        return this.b;
    }

    public final boolean a(a42 task, long j, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        task.a(this);
        long jA = this.f8664a.d().a();
        long j2 = jA + j;
        int iIndexOf = this.e.indexOf(task);
        if (iIndexOf != -1) {
            if (task.c() <= j2) {
                e42 e42Var = e42.h;
                if (e42.b.a().isLoggable(Level.FINE)) {
                    b42.b(task, this, "already scheduled");
                }
                return false;
            }
            this.e.remove(iIndexOf);
        }
        task.a(j2);
        e42 e42Var2 = e42.h;
        if (e42.b.a().isLoggable(Level.FINE)) {
            if (z) {
                str = "run again after " + b42.a(j2 - jA);
            } else {
                str = "scheduled after " + b42.a(j2 - jA);
            }
            b42.b(task, this, str);
        }
        Iterator it = this.e.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (((a42) it.next()).c() - jA > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.e.size();
        }
        this.e.add(size, task);
        return size == 0;
    }

    public final void a(a42 a42Var) {
        this.d = a42Var;
    }

    public final void a() {
        if (y82.f && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.f8664a) {
            if (b()) {
                this.f8664a.a(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
