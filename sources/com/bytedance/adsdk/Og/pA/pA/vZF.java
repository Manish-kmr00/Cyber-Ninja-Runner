package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes13.dex */
public class vZF extends pA {
    private final boolean JG;
    private final String ML;
    private final com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> SD;
    private final com.bytedance.adsdk.Og.KZx.KZx.pA ZZv;
    private com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> omh;

    public vZF(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.XT xt) {
        super(bzk, pAVar, xt.SD().pA(), xt.omh().pA(), xt.Bzk(), xt.KZx(), xt.ZZv(), xt.ML(), xt.JG());
        this.ZZv = pAVar;
        this.ML = xt.pA();
        this.JG = xt.SGo();
        com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVarPA = xt.Og().pA();
        this.SD = pAVarPA;
        pAVarPA.pA(this);
        pAVar.pA(pAVarPA);
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.pA, com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(Canvas canvas, Matrix matrix, int i) {
        if (this.JG) {
            return;
        }
        this.Og.setColor(((com.bytedance.adsdk.Og.pA.Og.Og) this.SD).Bzk());
        if (this.omh != null) {
            this.Og.setColorFilter(this.omh.SD());
        }
        super.pA(canvas, matrix, i);
    }
}
