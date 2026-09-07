package com.five_corp.ad.internal.view;

/* JADX INFO: loaded from: classes10.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1585a;

    public w(B b) {
        this.f1585a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1585a.b.setKeepScreenOn(true);
        this.f1585a.f.setVisibility(8);
        this.f1585a.g.setVisibility(8);
    }
}
