package com.bytedance.adsdk.Og.pA.Og;

import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv extends SD<Float> {
    public ZZv(List<com.bytedance.adsdk.Og.SD.pA<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public Float pA(com.bytedance.adsdk.Og.SD.pA<Float> pAVar, float f) {
        return Float.valueOf(KZx(pAVar, f));
    }

    float KZx(com.bytedance.adsdk.Og.SD.pA<Float> pAVar, float f) {
        if (pAVar.pA == null || pAVar.Og == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.KZx != null) {
            pAVar.SD.floatValue();
            ZZv();
            omh();
            throw null;
        }
        return com.bytedance.adsdk.Og.JG.ML.pA(pAVar.JG(), pAVar.SD(), f);
    }

    public float Bzk() {
        return KZx(KZx(), ML());
    }
}
