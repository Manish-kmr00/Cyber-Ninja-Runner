package io.appmetrica.analytics.impl;

import android.content.res.Configuration;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.v1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4502v1 extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Configuration f11808a;
    public final /* synthetic */ F1 b;

    public C4502v1(F1 f1, Configuration configuration) {
        this.b = f1;
        this.f11808a = configuration;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        this.b.b.onConfigurationChanged(this.f11808a);
    }
}
