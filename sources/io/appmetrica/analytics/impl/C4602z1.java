package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.z1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4602z1 extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f11868a;
    public final /* synthetic */ F1 b;

    public C4602z1(F1 f1, Intent intent) {
        this.b = f1;
        this.f11868a = intent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.b.b.a(this.f11868a);
    }
}
