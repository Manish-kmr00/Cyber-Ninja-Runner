package io.appmetrica.analytics.impl;

import android.location.Location;

/* JADX INFO: loaded from: classes4.dex */
public final class I0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Location f11184a;
    public final /* synthetic */ C4278m1 b;

    public I0(C4278m1 c4278m1, Location location) {
        this.b = c4278m1;
        this.f11184a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4377q0 c4377q0 = this.b.f11662a;
        Location location = this.f11184a;
        c4377q0.getClass();
        C4352p0.c().a(location);
    }
}
