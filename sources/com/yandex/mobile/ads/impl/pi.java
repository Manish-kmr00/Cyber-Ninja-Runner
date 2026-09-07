package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes5.dex */
final class pi implements ni {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9928a;
    public final int b;
    public final int c;

    @Override // com.yandex.mobile.ads.impl.ni
    public final int getType() {
        return 1751742049;
    }

    private pi(int i, int i2, int i3) {
        this.f9928a = i;
        this.b = i2;
        this.c = i3;
    }

    public static pi a(wf1 wf1Var) {
        int iK = wf1Var.k();
        wf1Var.f(8);
        int iK2 = wf1Var.k();
        int iK3 = wf1Var.k();
        wf1Var.f(4);
        wf1Var.k();
        wf1Var.f(12);
        return new pi(iK, iK2, iK3);
    }
}
