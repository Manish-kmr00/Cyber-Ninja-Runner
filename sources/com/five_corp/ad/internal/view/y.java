package com.five_corp.ad.internal.view;

/* JADX INFO: loaded from: classes10.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1587a;

    public y(B b) {
        this.f1587a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1587a.b.setKeepScreenOn(false);
        B.a(this.f1587a);
    }
}
