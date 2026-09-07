package io.appmetrica.analytics.impl;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.h1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class RunnableC4154h1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11576a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C4278m1 c;

    public RunnableC4154h1(C4278m1 c4278m1, String str, String str2) {
        this.c = c4278m1;
        this.f11576a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.c).reportEvent(this.f11576a, this.b);
    }
}
