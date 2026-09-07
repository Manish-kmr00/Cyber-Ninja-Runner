package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class omh implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, BSW, ML {
    private final com.bytedance.adsdk.Og.KZx.Og.SD BSW;
    private final RectF Bzk;
    private final com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> DX;
    private final boolean KZx;
    private final String Og;
    private final Path SD;
    private final List<Wx> SGo;
    private com.bytedance.adsdk.Og.pA.Og.KZx Sd;
    private final com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> Sn;
    private final com.bytedance.adsdk.Og.pA.Og.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv, com.bytedance.adsdk.Og.KZx.Og.ZZv> WV;
    private final com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> Wx;
    private final com.bytedance.adsdk.Og.Bzk XT;
    private final com.bytedance.adsdk.Og.KZx.KZx.pA ZZv;
    private com.bytedance.adsdk.Og.pA.Og.aBv aBv;
    private com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> oX;
    private final Paint omh;
    float pA;
    private com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> vZF;
    private final int yFO;
    private final LongSparseArray<LinearGradient> ML = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> JG = new LongSparseArray<>();

    public omh(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.ML ml) {
        Path path = new Path();
        this.SD = path;
        this.omh = new com.bytedance.adsdk.Og.pA.pA(1);
        this.Bzk = new RectF();
        this.SGo = new ArrayList();
        this.pA = 0.0f;
        this.ZZv = pAVar;
        this.Og = ml.pA();
        this.KZx = ml.omh();
        this.XT = bzk;
        this.BSW = ml.Og();
        path.setFillType(ml.KZx());
        this.yFO = (int) (sd.ML() / 32.0f);
        com.bytedance.adsdk.Og.pA.Og.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv, com.bytedance.adsdk.Og.KZx.Og.ZZv> pAVarPA = ml.ZZv().pA();
        this.WV = pAVarPA;
        pAVarPA.pA(this);
        pAVar.pA(pAVarPA);
        com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVarPA2 = ml.ML().pA();
        this.Wx = pAVarPA2;
        pAVarPA2.pA(this);
        pAVar.pA(pAVarPA2);
        com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pAVarPA3 = ml.JG().pA();
        this.Sn = pAVarPA3;
        pAVarPA3.pA(this);
        pAVar.pA(pAVarPA3);
        com.bytedance.adsdk.Og.pA.Og.pA<PointF, PointF> pAVarPA4 = ml.SD().pA();
        this.DX = pAVarPA4;
        pAVarPA4.pA(this);
        pAVar.pA(pAVarPA4);
        if (pAVar.SGo() != null) {
            com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA5 = pAVar.SGo().pA().pA();
            this.vZF = pAVarPA5;
            pAVarPA5.pA(this);
            pAVar.pA(this.vZF);
        }
        if (pAVar.BSW() != null) {
            this.Sd = new com.bytedance.adsdk.Og.pA.Og.KZx(this, pAVar, pAVar.BSW());
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        this.XT.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
        for (int i = 0; i < list2.size(); i++) {
            KZx kZx = list2.get(i);
            if (kZx instanceof Wx) {
                this.SGo.add((Wx) kZx);
            }
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(Canvas canvas, Matrix matrix, int i) {
        Shader shaderKZx;
        if (this.KZx) {
            return;
        }
        com.bytedance.adsdk.Og.ML.pA("GradientFillContent#draw");
        this.SD.reset();
        for (int i2 = 0; i2 < this.SGo.size(); i2++) {
            this.SD.addPath(this.SGo.get(i2).ZZv(), matrix);
        }
        this.SD.computeBounds(this.Bzk, false);
        if (this.BSW == com.bytedance.adsdk.Og.KZx.Og.SD.LINEAR) {
            shaderKZx = Og();
        } else {
            shaderKZx = KZx();
        }
        shaderKZx.setLocalMatrix(matrix);
        this.omh.setShader(shaderKZx);
        com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> pAVar = this.oX;
        if (pAVar != null) {
            this.omh.setColorFilter(pAVar.SD());
        }
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar2 = this.vZF;
        if (pAVar2 != null) {
            float fFloatValue = pAVar2.SD().floatValue();
            if (fFloatValue == 0.0f) {
                this.omh.setMaskFilter(null);
            } else if (fFloatValue != this.pA) {
                this.omh.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.pA = fFloatValue;
        }
        com.bytedance.adsdk.Og.pA.Og.KZx kZx = this.Sd;
        if (kZx != null) {
            kZx.pA(this.omh);
        }
        this.omh.setAlpha(com.bytedance.adsdk.Og.JG.ML.pA((int) ((((i / 255.0f) * this.Wx.SD().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.SD, this.omh);
        com.bytedance.adsdk.Og.ML.Og("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(RectF rectF, Matrix matrix, boolean z) {
        this.SD.reset();
        for (int i = 0; i < this.SGo.size(); i++) {
            this.SD.addPath(this.SGo.get(i).ZZv(), matrix);
        }
        this.SD.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private LinearGradient Og() {
        long jZZv = ZZv();
        LinearGradient linearGradient = this.ML.get(jZZv);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFSD = this.Sn.SD();
        PointF pointFSD2 = this.DX.SD();
        com.bytedance.adsdk.Og.KZx.Og.ZZv zZvSD = this.WV.SD();
        LinearGradient linearGradient2 = new LinearGradient(pointFSD.x, pointFSD.y, pointFSD2.x, pointFSD2.y, pA(zZvSD.Og()), zZvSD.pA(), Shader.TileMode.CLAMP);
        this.ML.put(jZZv, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient KZx() {
        long jZZv = ZZv();
        RadialGradient radialGradient = this.JG.get(jZZv);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFSD = this.Sn.SD();
        PointF pointFSD2 = this.DX.SD();
        com.bytedance.adsdk.Og.KZx.Og.ZZv zZvSD = this.WV.SD();
        int[] iArrPA = pA(zZvSD.Og());
        float[] fArrPA = zZvSD.pA();
        float f = pointFSD.x;
        float f2 = pointFSD.y;
        float fHypot = (float) Math.hypot(pointFSD2.x - f, pointFSD2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot, iArrPA, fArrPA, Shader.TileMode.CLAMP);
        this.JG.put(jZZv, radialGradient2);
        return radialGradient2;
    }

    private int ZZv() {
        int iRound = Math.round(this.Sn.omh() * this.yFO);
        int iRound2 = Math.round(this.DX.omh() * this.yFO);
        int iRound3 = Math.round(this.WV.omh() * this.yFO);
        int i = iRound != 0 ? iRound * IronSourceError.ERROR_NON_EXISTENT_INSTANCE : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] pA(int[] iArr) {
        if (this.aBv == null) {
            return iArr;
        }
        throw null;
    }
}
