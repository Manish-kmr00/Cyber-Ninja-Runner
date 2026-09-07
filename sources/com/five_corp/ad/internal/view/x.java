package com.five_corp.ad.internal.view;

/* JADX INFO: loaded from: classes10.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1586a;

    public x(B b) {
        this.f1586a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1586a.b.setKeepScreenOn(false);
        B.a(this.f1586a);
    }
}
