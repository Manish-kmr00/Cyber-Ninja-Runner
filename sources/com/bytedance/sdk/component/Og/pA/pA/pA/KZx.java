package com.bytedance.sdk.component.Og.pA.pA.pA;

import com.bytedance.sdk.component.Og.pA.DX;
import com.bytedance.sdk.component.Og.pA.Wx;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class KZx implements com.bytedance.sdk.component.Og.pA.omh.pA {
    int KZx = 0;
    Wx Og;
    List<com.bytedance.sdk.component.Og.pA.omh> pA;

    KZx(List<com.bytedance.sdk.component.Og.pA.omh> list, Wx wx) {
        this.pA = list;
        this.Og = wx;
    }

    @Override // com.bytedance.sdk.component.Og.pA.omh.pA
    public Wx pA() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.Og.pA.omh.pA
    public DX pA(Wx wx) throws IOException {
        this.Og = wx;
        int i = this.KZx + 1;
        this.KZx = i;
        if (i >= this.pA.size()) {
            return null;
        }
        return this.pA.get(this.KZx).pA(this);
    }
}
