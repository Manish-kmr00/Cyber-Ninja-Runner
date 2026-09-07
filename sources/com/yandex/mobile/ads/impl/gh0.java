package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class gh0 extends a42 {
    final /* synthetic */ eh0 e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh0(String str, eh0 eh0Var, int i, int i2) {
        super(str, true);
        this.e = eh0Var;
        this.f = i;
        this.g = i2;
    }

    @Override // com.yandex.mobile.ads.impl.a42
    public final long e() {
        this.e.a(this.f, this.g, true);
        return -1L;
    }
}
