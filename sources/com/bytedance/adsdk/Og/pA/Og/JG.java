package com.bytedance.adsdk.Og.pA.Og;

import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class JG extends SD<Integer> {
    public JG(List<com.bytedance.adsdk.Og.SD.pA<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public Integer pA(com.bytedance.adsdk.Og.SD.pA<Integer> pAVar, float f) {
        return Integer.valueOf(KZx(pAVar, f));
    }

    int KZx(com.bytedance.adsdk.Og.SD.pA<Integer> pAVar, float f) {
        if (pAVar.pA == null || pAVar.Og == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.KZx != null) {
            pAVar.SD.floatValue();
            ZZv();
            omh();
            throw null;
        }
        return com.bytedance.adsdk.Og.JG.ML.pA(pAVar.omh(), pAVar.Bzk(), f);
    }

    public int Bzk() {
        return KZx(KZx(), ML());
    }
}
