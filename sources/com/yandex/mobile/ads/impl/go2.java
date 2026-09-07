package com.yandex.mobile.ads.impl;

import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public final class go2 implements co2.a {
    private final ArrayDeque<co2> b = new ArrayDeque<>();
    private co2 c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f9024a = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private void b() {
        co2 co2VarPoll = this.b.poll();
        this.c = co2VarPoll;
        if (co2VarPoll != null) {
            co2VarPoll.a(this.f9024a);
        }
    }

    public final void a() {
        this.c = null;
        b();
    }

    public final void a(co2 co2Var) {
        co2Var.a(this);
        this.b.add(co2Var);
        if (this.c == null) {
            b();
        }
    }
}
