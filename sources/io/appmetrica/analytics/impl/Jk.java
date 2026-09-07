package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes5.dex */
public final class Jk implements Pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4377q0 f11213a;

    public Jk(C4377q0 c4377q0) {
        this.f11213a = c4377q0;
    }

    @Override // io.appmetrica.analytics.impl.Pn
    public final Nn a(Void r3) {
        boolean z;
        this.f11213a.getClass();
        synchronized (C4352p0.class) {
            z = C4352p0.f;
        }
        return z ? new Nn(this, true, "") : new Nn(this, false, "AppMetrica isn't initialized. Use AppMetrica#activate(android.content.Context, String) method to activate.");
    }

    public final Nn a() {
        return a((Void) null);
    }
}
