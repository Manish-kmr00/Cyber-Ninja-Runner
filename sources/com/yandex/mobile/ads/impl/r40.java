package com.yandex.mobile.ads.impl;

import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class r40 extends ny1 {
    private final s40 m;

    public r40(List<byte[]> list) {
        wf1 wf1Var = new wf1(list.get(0));
        this.m = new s40(wf1Var.z(), wf1Var.z());
    }

    @Override // com.yandex.mobile.ads.impl.ny1
    protected final g32 a(byte[] bArr, int i, boolean z) {
        if (z) {
            this.m.d();
        }
        return new t40(this.m.a(i, bArr));
    }
}
