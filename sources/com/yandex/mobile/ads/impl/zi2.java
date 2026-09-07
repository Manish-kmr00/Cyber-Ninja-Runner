package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes8.dex */
final class zi2 implements np1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap f10820a = new HashMap();
    private final yq1 b;
    private final xm c;
    private final BlockingQueue<np1<?>> d;

    zi2(xm xmVar, PriorityBlockingQueue priorityBlockingQueue, yq1 yq1Var) {
        this.b = yq1Var;
        this.c = xmVar;
        this.d = priorityBlockingQueue;
    }

    public final synchronized void b(np1<?> np1Var) {
        BlockingQueue<np1<?>> blockingQueue;
        String strD = np1Var.d();
        List list = (List) this.f10820a.remove(strD);
        if (list != null && !list.isEmpty()) {
            if (li2.f9524a) {
                op0.e(Integer.valueOf(list.size()), strD);
            }
            np1<?> np1Var2 = (np1) list.remove(0);
            this.f10820a.put(strD, list);
            np1Var2.a((np1.b) this);
            if (this.c != null && (blockingQueue = this.d) != null) {
                try {
                    blockingQueue.put(np1Var2);
                } catch (InterruptedException e) {
                    op0.b(e.toString());
                    Thread.currentThread().interrupt();
                    this.c.b();
                }
            }
        }
    }

    final synchronized boolean a(np1<?> np1Var) {
        String strD = np1Var.d();
        if (this.f10820a.containsKey(strD)) {
            List arrayList = (List) this.f10820a.get(strD);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            np1Var.a("waiting-for-response");
            arrayList.add(np1Var);
            this.f10820a.put(strD, arrayList);
            if (li2.f9524a) {
                op0.a(strD);
            }
            return true;
        }
        this.f10820a.put(strD, null);
        np1Var.a((np1.b) this);
        if (li2.f9524a) {
            op0.a(strD);
        }
        return false;
    }

    public final void a(np1<?> np1Var, qq1<?> qq1Var) {
        List list;
        sm.a aVar = qq1Var.b;
        if (aVar != null) {
            if (aVar.e >= System.currentTimeMillis()) {
                String strD = np1Var.d();
                synchronized (this) {
                    list = (List) this.f10820a.remove(strD);
                }
                if (list != null) {
                    if (li2.f9524a) {
                        op0.e(Integer.valueOf(list.size()), strD);
                    }
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((e60) this.b).a((np1) it.next(), qq1Var, null);
                    }
                    return;
                }
                return;
            }
        }
        b(np1Var);
    }
}
