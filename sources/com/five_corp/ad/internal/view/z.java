package com.five_corp.ad.internal.view;

/* JADX INFO: loaded from: classes10.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1588a;

    public z(B b) {
        this.f1588a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1588a.b.setKeepScreenOn(false);
        B.a(this.f1588a);
        this.f1588a.f.setVisibility(0);
    }
}
