package com.bytedance.adsdk.Og.pA.Og;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class WV extends SD<com.bytedance.adsdk.Og.SD.KZx> {
    private final com.bytedance.adsdk.Og.SD.KZx ZZv;

    public WV(List<com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.SD.KZx>> list) {
        super(list);
        this.ZZv = new com.bytedance.adsdk.Og.SD.KZx();
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.Og.SD.KZx pA(com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.SD.KZx> pAVar, float f) {
        if (pAVar.pA == null || pAVar.Og == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.Og.SD.KZx kZx = pAVar.pA;
        com.bytedance.adsdk.Og.SD.KZx kZx2 = pAVar.Og;
        if (this.KZx != null) {
            pAVar.SD.floatValue();
            ZZv();
            omh();
            throw null;
        }
        this.ZZv.pA(com.bytedance.adsdk.Og.JG.ML.pA(kZx.pA(), kZx2.pA(), f), com.bytedance.adsdk.Og.JG.ML.pA(kZx.Og(), kZx2.Og(), f));
        return this.ZZv;
    }
}
