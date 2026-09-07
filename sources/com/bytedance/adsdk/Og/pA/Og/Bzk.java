package com.bytedance.adsdk.Og.pA.Og;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes12.dex */
public class Bzk extends com.bytedance.adsdk.Og.SD.pA<PointF> {
    private final com.bytedance.adsdk.Og.SD.pA<PointF> BSW;
    private Path SGo;

    public Bzk(com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.SD.pA<PointF> pAVar) {
        super(sd, pAVar.pA, pAVar.Og, pAVar.KZx, pAVar.ZZv, pAVar.ML, pAVar.JG, pAVar.SD);
        this.BSW = pAVar;
        pA();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pA() {
        boolean z = (this.Og == 0 || this.pA == 0 || !((PointF) this.pA).equals(((PointF) this.Og).x, ((PointF) this.Og).y)) ? false : true;
        if (this.pA == 0 || this.Og == 0 || z) {
            return;
        }
        this.SGo = com.bytedance.adsdk.Og.JG.JG.pA((PointF) this.pA, (PointF) this.Og, this.BSW.omh, this.BSW.Bzk);
    }

    Path Og() {
        return this.SGo;
    }
}
