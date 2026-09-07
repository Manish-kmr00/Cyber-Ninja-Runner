package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class Uf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4044cg f11377a;
    public final /* synthetic */ Vf b;

    public Uf(Vf vf, C4044cg c4044cg) {
        this.b = vf;
        this.f11377a = c4044cg;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f11392a.a(this.f11377a);
    }
}
