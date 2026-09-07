package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes4.dex */
final class qi implements ni {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10020a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    @Override // com.yandex.mobile.ads.impl.ni
    public final int getType() {
        return 1752331379;
    }

    private qi(int i, int i2, int i3, int i4, int i5) {
        this.f10020a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    public static qi a(wf1 wf1Var) {
        int iK = wf1Var.k();
        wf1Var.f(12);
        wf1Var.k();
        int iK2 = wf1Var.k();
        int iK3 = wf1Var.k();
        wf1Var.f(4);
        int iK4 = wf1Var.k();
        int iK5 = wf1Var.k();
        wf1Var.f(8);
        return new qi(iK, iK2, iK3, iK4, iK5);
    }
}
