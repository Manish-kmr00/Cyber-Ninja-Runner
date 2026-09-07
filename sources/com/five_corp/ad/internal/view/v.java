package com.five_corp.ad.internal.view;

/* JADX INFO: loaded from: classes10.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1584a;

    public v(B b) {
        this.f1584a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1584a.b.setKeepScreenOn(false);
        this.f1584a.f.setVisibility(8);
        B.a(this.f1584a);
    }
}
