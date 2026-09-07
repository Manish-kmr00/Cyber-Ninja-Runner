package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.w1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4527w1 extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ F1 f11823a;

    public C4527w1(F1 f1) {
        this.f11823a = f1;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        synchronized (this.f11823a) {
            F1 f1 = this.f11823a;
            if (f1.c) {
                f1.b.onCreate();
            }
        }
    }
}
