package com.five_corp.ad.internal.view;

/* JADX INFO: loaded from: classes10.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1583a;

    public u(B b) {
        this.f1583a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1583a.f.setVisibility(0);
    }
}
