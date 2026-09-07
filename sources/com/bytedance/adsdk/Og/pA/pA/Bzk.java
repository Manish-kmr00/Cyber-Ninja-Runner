package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.json.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes9.dex */
public class Bzk extends pA {
    private final com.bytedance.adsdk.Og.pA.Og.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv, com.bytedance.adsdk.Og.KZx.Og.ZZv> BSW;
    private final com.bytedance.adsdk.Og.KZx.Og.SD Bzk;
    private final LongSparseArray<LinearGradient> JG;
    private final boolean ML;
    private final LongSparseArray<RadialGradient> SD;
    private final int SGo;
    private com.bytedance.adsdk.Og.pA.Og.aBv Sn;
    private final com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> WV;
    private final com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> Wx;
    private final String ZZv;
    private final RectF omh;

    public Bzk(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.JG jg) {
        super(bzk, pAVar, jg.omh().pA(), jg.Bzk().pA(), jg.WV(), jg.ZZv(), jg.SD(), jg.SGo(), jg.BSW());
        this.JG = new LongSparseArray<>();
        this.SD = new LongSparseArray<>();
        this.omh = new RectF();
        this.ZZv = jg.pA();
        this.Bzk = jg.Og();
        this.ML = jg.Wx();
        this.SGo = (int) (bzk.du().ML() / 32.0f);
        com.bytedance.adsdk.Og.pA.Og.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv, com.bytedance.adsdk.Og.KZx.Og.ZZv> pAVarPA = jg.KZx().pA();
        this.BSW = pAVarPA;
        pAVarPA.pA(this);
        pAVar.pA(pAVarPA);
        com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pAVarPA2 = jg.ML().pA();
        this.WV = pAVarPA2;
        pAVarPA2.pA(this);
        pAVar.pA(pAVarPA2);
        com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pAVarPA3 = jg.JG().pA();
        this.Wx = pAVarPA3;
        pAVarPA3.pA(this);
        pAVar.pA(pAVarPA3);
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.pA, com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(Canvas canvas, Matrix matrix, int i) {
        Shader shaderKZx;
        if (this.ML) {
            return;
        }
        pA(this.omh, matrix, false);
        if (this.Bzk == com.bytedance.adsdk.Og.KZx.Og.SD.LINEAR) {
            shaderKZx = Og();
        } else {
            shaderKZx = KZx();
        }
        shaderKZx.setLocalMatrix(matrix);
        this.Og.setShader(shaderKZx);
        super.pA(canvas, matrix, i);
    }

    private LinearGradient Og() {
        long jZZv = ZZv();
        LinearGradient linearGradient = this.JG.get(jZZv);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFSD = this.WV.SD();
        PointF pointFSD2 = this.Wx.SD();
        com.bytedance.adsdk.Og.KZx.Og.ZZv zZvSD = this.BSW.SD();
        LinearGradient linearGradient2 = new LinearGradient(pointFSD.x, pointFSD.y, pointFSD2.x, pointFSD2.y, pA(zZvSD.Og()), zZvSD.pA(), Shader.TileMode.CLAMP);
        this.JG.put(jZZv, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient KZx() {
        long jZZv = ZZv();
        RadialGradient radialGradient = this.SD.get(jZZv);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFSD = this.WV.SD();
        PointF pointFSD2 = this.Wx.SD();
        com.bytedance.adsdk.Og.KZx.Og.ZZv zZvSD = this.BSW.SD();
        int[] iArrPA = pA(zZvSD.Og());
        float[] fArrPA = zZvSD.pA();
        float f = pointFSD.x;
        float f2 = pointFSD.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(pointFSD2.x - f, pointFSD2.y - f2), iArrPA, fArrPA, Shader.TileMode.CLAMP);
        this.SD.put(jZZv, radialGradient2);
        return radialGradient2;
    }

    private int ZZv() {
        int iRound = Math.round(this.WV.omh() * this.SGo);
        int iRound2 = Math.round(this.Wx.omh() * this.SGo);
        int iRound3 = Math.round(this.BSW.omh() * this.SGo);
        int i = iRound != 0 ? iRound * IronSourceError.ERROR_NON_EXISTENT_INSTANCE : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] pA(int[] iArr) {
        if (this.Sn == null) {
            return iArr;
        }
        throw null;
    }
}
