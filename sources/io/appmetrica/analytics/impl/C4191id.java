package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.id, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4191id extends SafeRunnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4315nd f11603a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public C4191id(C4315nd c4315nd, AdRevenue adRevenue, boolean z) {
        this.f11603a = c4315nd;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C4315nd.a(this.f11603a).reportAdRevenue(this.b, this.c);
    }
}
