package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.c1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class RunnableC4029c1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnrListener f11487a;
    public final /* synthetic */ C4278m1 b;

    public RunnableC4029c1(C4278m1 c4278m1, AnrListener anrListener) {
        this.b = c4278m1;
        this.f11487a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).a(this.f11487a);
    }
}
