package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.jd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4215jd extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4315nd f11617a;
    public final /* synthetic */ ModuleEvent b;

    public C4215jd(C4315nd c4315nd, ModuleEvent moduleEvent) {
        this.f11617a = c4315nd;
        this.b = moduleEvent;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C4315nd.a(this.f11617a).reportEvent(this.b);
    }
}
