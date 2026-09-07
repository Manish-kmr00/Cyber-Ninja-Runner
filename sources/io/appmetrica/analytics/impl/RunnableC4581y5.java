package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.y5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class RunnableC4581y5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Sd f11853a;
    public final /* synthetic */ C4606z5 b;

    public RunnableC4581y5(C4606z5 c4606z5, Sd sd) {
        this.b = c4606z5;
        this.f11853a = sd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            C4606z5 c4606z5 = this.b;
            Object obj = c4606z5.f11870a;
            if (obj == null) {
                c4606z5.b.add(this.f11853a);
            } else {
                this.f11853a.consume(obj);
            }
        }
    }
}
