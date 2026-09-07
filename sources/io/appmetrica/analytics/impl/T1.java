package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class T1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Sd f11357a;
    public final /* synthetic */ G7 b;

    public T1(V1 v1, G7 g7) {
        this.f11357a = v1;
        this.b = g7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11357a.consume(this.b);
    }
}
