package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.kd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4240kd extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4315nd f11636a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public C4240kd(C4315nd c4315nd, int i, String str) {
        this.f11636a = c4315nd;
        this.b = i;
        this.c = str;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C4315nd.a(this.f11636a).a(new M9(this.b, this.c));
    }
}
