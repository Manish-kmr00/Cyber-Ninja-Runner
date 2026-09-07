package com.yandex.mobile.ads.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class p10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f9886a;
    private final ArrayDeque<sn1.a> b = new ArrayDeque<>();
    private final ArrayDeque<sn1.a> c = new ArrayDeque<>();
    private final ArrayDeque<sn1> d = new ArrayDeque<>();

    public final void a(sn1.a call) {
        sn1.a next;
        Intrinsics.checkNotNullParameter(call, "call");
        synchronized (this) {
            this.b.add(call);
            if (!call.a().f()) {
                String strC = call.c();
                Iterator<sn1.a> it = this.c.iterator();
                do {
                    if (!it.hasNext()) {
                        Iterator<sn1.a> it2 = this.b.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                        } while (!Intrinsics.areEqual(next.c(), strC));
                    } else {
                        next = it.next();
                    }
                } while (!Intrinsics.areEqual(next.c(), strC));
                if (next != null) {
                    call.a(next);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        b();
    }

    public final void b(sn1.a call) {
        Intrinsics.checkNotNullParameter(call, "call");
        call.b().decrementAndGet();
        a(this.c, call);
    }

    public final synchronized void a(sn1 call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.d.add(call);
    }

    public final void b(sn1 call) {
        Intrinsics.checkNotNullParameter(call, "call");
        a(this.d, call);
    }

    public final synchronized int c() {
        return this.d.size() + this.c.size();
    }

    private final void b() {
        if (y82.f && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<sn1.a> it = this.b.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                sn1.a next = it.next();
                if (this.c.size() >= 64) {
                    break;
                }
                if (next.b().get() < 5) {
                    it.remove();
                    next.b().incrementAndGet();
                    Intrinsics.checkNotNull(next);
                    arrayList.add(next);
                    this.c.add(next);
                }
            }
            c();
            Unit unit = Unit.INSTANCE;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((sn1.a) arrayList.get(i)).a(a());
        }
    }

    public final synchronized ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor;
        if (this.f9886a == null) {
            this.f9886a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), y82.a(y82.g + " Dispatcher", false));
        }
        threadPoolExecutor = this.f9886a;
        Intrinsics.checkNotNull(threadPoolExecutor);
        return threadPoolExecutor;
    }

    private final void a(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (arrayDeque.remove(obj)) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        b();
    }
}
