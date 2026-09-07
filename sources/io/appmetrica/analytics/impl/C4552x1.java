package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.x1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4552x1 extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f11837a;
    public final /* synthetic */ int b;
    public final /* synthetic */ F1 c;

    public C4552x1(F1 f1, Intent intent, int i) {
        this.c = f1;
        this.f11837a = intent;
        this.b = i;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.c.b.a(this.f11837a, this.b);
    }
}
