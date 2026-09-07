package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class RunnableC4128g0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4178i0 f11559a;

    public RunnableC4128g0(C4178i0 c4178i0) {
        this.f11559a = c4178i0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4178i0 c4178i0 = this.f11559a;
        synchronized (c4178i0) {
            if (c4178i0.f11591a != null && c4178i0.a()) {
                try {
                    c4178i0.d = null;
                    c4178i0.f11591a.unbindService(c4178i0.i);
                } catch (Throwable unused) {
                }
            }
            c4178i0.d = null;
        }
    }
}
