package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ld, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4265ld extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4315nd f11651a;
    public final /* synthetic */ boolean b;

    public C4265ld(C4315nd c4315nd, boolean z) {
        this.f11651a = c4315nd;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C4315nd.a(this.f11651a).b(this.b);
    }
}
