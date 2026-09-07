package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes2.dex */
public final class O0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4278m1 f11275a;

    public O0(C4278m1 c4278m1) {
        this.f11275a = c4278m1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.f11275a).sendEventsBuffer();
    }
}
