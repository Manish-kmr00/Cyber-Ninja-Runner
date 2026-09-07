package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class z52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10791a;
    public final to1[] b;
    public final e70[] c;
    public final u62 d;
    public final Object e;

    public z52(to1[] to1VarArr, e70[] e70VarArr, u62 u62Var, yt0.a aVar) {
        this.b = to1VarArr;
        this.c = (e70[]) e70VarArr.clone();
        this.d = u62Var;
        this.e = aVar;
        this.f10791a = to1VarArr.length;
    }

    public final boolean a(int i) {
        return this.b[i] != null;
    }
}
