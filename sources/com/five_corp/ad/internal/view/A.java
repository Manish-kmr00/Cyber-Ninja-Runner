package com.five_corp.ad.internal.view;

/* JADX INFO: loaded from: classes10.dex */
public final class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1562a;

    public A(B b) {
        this.f1562a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1562a.b.setKeepScreenOn(true);
        this.f1562a.f.setVisibility(8);
    }
}
