package com.chartboost.sdk.impl;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public class xc implements pc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockingQueue<Runnable> f1194a;
    public final ThreadPoolExecutor b;
    public final ArrayDeque<pc> c = new ArrayDeque<>();
    public pc d = null;

    public xc() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f1194a = linkedBlockingQueue;
        this.b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    public final void a() {
        pc pcVarPoll = this.c.poll();
        this.d = pcVarPoll;
        if (pcVarPoll != null) {
            pcVarPoll.a(this.b);
        }
    }

    public void b(pc pcVar) {
        pcVar.a(this);
        this.c.add(pcVar);
        if (this.d == null) {
            a();
        }
    }

    @Override // com.chartboost.sdk.impl.pc.a
    public void a(pc pcVar) {
        this.d = null;
        a();
    }
}
