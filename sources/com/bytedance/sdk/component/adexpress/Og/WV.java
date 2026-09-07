package com.bytedance.sdk.component.adexpress.Og;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes12.dex */
public class WV implements SGo.pA {
    private Bzk KZx;
    private List<SGo> Og;
    private AtomicBoolean ZZv = new AtomicBoolean(false);
    DX pA;

    public WV(List<SGo> list, Bzk bzk) {
        this.Og = list;
        this.KZx = bzk;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo.pA
    public void pA() {
        this.KZx.ZZv();
        Iterator<SGo> it = this.Og.iterator();
        while (it.hasNext() && !it.next().pA(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo.pA
    public void pA(SGo sGo) {
        int iIndexOf = this.Og.indexOf(sGo);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.Og.size()) {
                return;
            }
        } while (!this.Og.get(iIndexOf).pA(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo.pA
    public boolean Og(SGo sGo) {
        int iIndexOf = this.Og.indexOf(sGo);
        return iIndexOf < this.Og.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo.pA
    public DX Og() {
        return this.pA;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo.pA
    public void pA(DX dx) {
        this.pA = dx;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo.pA
    public void pA(boolean z) {
        this.ZZv.getAndSet(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo.pA
    public boolean KZx() {
        return this.ZZv.get();
    }
}
