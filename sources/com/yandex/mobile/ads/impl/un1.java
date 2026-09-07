package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes12.dex */
public final class un1 extends a42 {
    final /* synthetic */ vn1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    un1(vn1 vn1Var, String str) {
        super(str);
        this.e = vn1Var;
    }

    @Override // com.yandex.mobile.ads.impl.a42
    public final long e() {
        return this.e.a(System.nanoTime());
    }
}
