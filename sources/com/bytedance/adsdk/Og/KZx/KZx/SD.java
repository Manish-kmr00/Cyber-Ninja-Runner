package com.bytedance.adsdk.Og.KZx.KZx;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.Og.KZx.Og.oX;
import java.util.Collections;

/* JADX INFO: loaded from: classes13.dex */
public class SD extends pA {
    private final com.bytedance.adsdk.Og.pA.pA.ZZv SD;
    private final Og omh;

    SD(com.bytedance.adsdk.Og.Bzk bzk, ML ml, Og og, com.bytedance.adsdk.Og.SD sd) {
        super(bzk, ml);
        this.omh = og;
        com.bytedance.adsdk.Og.pA.pA.ZZv zZv = new com.bytedance.adsdk.Og.pA.pA.ZZv(bzk, this, new oX("__container", ml.Sn(), false), sd);
        this.SD = zZv;
        zZv.pA(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA
    public void Og(Canvas canvas, Matrix matrix, int i) {
        super.Og(canvas, matrix, i);
        this.SD.pA(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA, com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(RectF rectF, Matrix matrix, boolean z) {
        super.pA(rectF, matrix, z);
        this.SD.pA(rectF, this.pA, z);
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA
    public com.bytedance.adsdk.Og.KZx.Og.pA SGo() {
        com.bytedance.adsdk.Og.KZx.Og.pA pAVarSGo = super.SGo();
        return pAVarSGo != null ? pAVarSGo : this.omh.SGo();
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA
    public com.bytedance.adsdk.Og.ML.SGo BSW() {
        com.bytedance.adsdk.Og.ML.SGo sGoBSW = super.BSW();
        return sGoBSW != null ? sGoBSW : this.omh.BSW();
    }
}
