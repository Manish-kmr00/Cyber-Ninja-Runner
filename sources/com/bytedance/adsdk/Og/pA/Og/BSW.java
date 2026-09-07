package com.bytedance.adsdk.Og.pA.Og;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class BSW extends SD<PointF> {
    private final PointF ZZv;

    public BSW(List<com.bytedance.adsdk.Og.SD.pA<PointF>> list) {
        super(list);
        this.ZZv = new PointF();
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public PointF pA(com.bytedance.adsdk.Og.SD.pA<PointF> pAVar, float f) {
        return pA(pAVar, f, f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public PointF pA(com.bytedance.adsdk.Og.SD.pA<PointF> pAVar, float f, float f2, float f3) {
        if (pAVar.pA == null || pAVar.Og == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = pAVar.pA;
        PointF pointF2 = pAVar.Og;
        if (this.KZx != null) {
            pAVar.SD.floatValue();
            ZZv();
            omh();
            throw null;
        }
        this.ZZv.set(pointF.x + (f2 * (pointF2.x - pointF.x)), pointF.y + (f3 * (pointF2.y - pointF.y)));
        return this.ZZv;
    }
}
