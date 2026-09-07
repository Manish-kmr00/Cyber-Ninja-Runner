package com.bytedance.adsdk.Og.pA.Og;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: loaded from: classes10.dex */
public class Sn extends pA<PointF, PointF> {
    private final pA<Float, Float> Bzk;
    private final PointF JG;
    protected com.bytedance.adsdk.Og.SD.Og<Float> ML;
    private final PointF SD;
    protected com.bytedance.adsdk.Og.SD.Og<Float> ZZv;
    private final pA<Float, Float> omh;

    public Sn(pA<Float, Float> pAVar, pA<Float, Float> pAVar2) {
        super(Collections.emptyList());
        this.JG = new PointF();
        this.SD = new PointF();
        this.omh = pAVar;
        this.Bzk = pAVar2;
        pA(omh());
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    public void pA(float f) {
        this.omh.pA(f);
        this.Bzk.pA(f);
        this.JG.set(this.omh.SD().floatValue(), this.Bzk.SD().floatValue());
        for (int i = 0; i < this.pA.size(); i++) {
            this.pA.get(i).pA();
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    /* JADX INFO: renamed from: Bzk, reason: merged with bridge method [inline-methods] */
    public PointF SD() {
        return pA(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public PointF pA(com.bytedance.adsdk.Og.SD.pA<PointF> pAVar, float f) {
        com.bytedance.adsdk.Og.SD.pA<Float> pAVarKZx;
        com.bytedance.adsdk.Og.SD.pA<Float> pAVarKZx2;
        if (this.ZZv != null && (pAVarKZx2 = this.omh.KZx()) != null) {
            this.omh.ML();
            Float f2 = pAVarKZx2.SD;
            if (f2 == null) {
                throw null;
            }
            f2.floatValue();
            throw null;
        }
        if (this.ML != null && (pAVarKZx = this.Bzk.KZx()) != null) {
            this.Bzk.ML();
            Float f3 = pAVarKZx.SD;
            if (f3 == null) {
                throw null;
            }
            f3.floatValue();
            throw null;
        }
        this.SD.set(this.JG.x, 0.0f);
        PointF pointF = this.SD;
        pointF.set(pointF.x, this.JG.y);
        return this.SD;
    }
}
