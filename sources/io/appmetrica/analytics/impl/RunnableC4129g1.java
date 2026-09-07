package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.g1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class RunnableC4129g1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11560a;
    public final /* synthetic */ C4278m1 b;

    public RunnableC4129g1(C4278m1 c4278m1, String str) {
        this.b = c4278m1;
        this.f11560a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).reportEvent(this.f11560a);
    }
}
