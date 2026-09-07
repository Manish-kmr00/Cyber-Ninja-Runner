package com.fyber.inneractive.sdk.player.ui;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f2238a;

    public k(l lVar) {
        this.f2238a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f2238a;
        int i = lVar.G + (lVar.i / lVar.j);
        lVar.G = i;
        lVar.a(i);
        l lVar2 = this.f2238a;
        if (lVar2.G != lVar2.H) {
            lVar2.postDelayed(lVar2.F, lVar2.k);
            return;
        }
        lVar2.F = null;
        lVar2.G = 0;
        lVar2.H = 0;
    }
}
