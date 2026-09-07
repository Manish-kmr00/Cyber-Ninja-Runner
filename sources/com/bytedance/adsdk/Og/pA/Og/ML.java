package com.bytedance.adsdk.Og.pA.Og;

import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class ML extends SD<com.bytedance.adsdk.Og.KZx.Og.ZZv> {
    private final com.bytedance.adsdk.Og.KZx.Og.ZZv ZZv;

    public ML(List<com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv>> list) {
        super(list);
        com.bytedance.adsdk.Og.KZx.Og.ZZv zZv = list.get(0).pA;
        int iKZx = zZv != null ? zZv.KZx() : 0;
        this.ZZv = new com.bytedance.adsdk.Og.KZx.Og.ZZv(new float[iKZx], new int[iKZx]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.Og.KZx.Og.ZZv pA(com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv> pAVar, float f) {
        this.ZZv.pA(pAVar.pA, pAVar.Og, f);
        return this.ZZv;
    }
}
