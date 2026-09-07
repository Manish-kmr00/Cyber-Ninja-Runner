package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.y1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4577y1 extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f11850a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ F1 d;

    public C4577y1(F1 f1, Intent intent, int i, int i2) {
        this.d = f1;
        this.f11850a = intent;
        this.b = i;
        this.c = i2;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.d.b.a(this.f11850a, this.b, this.c);
    }
}
