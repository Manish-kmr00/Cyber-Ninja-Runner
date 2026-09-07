package com.bytedance.adsdk.Og.pA.Og;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes6.dex */
public class oX {
    private ZZv BSW;
    private pA<Float, Float> Bzk;
    private pA<PointF, PointF> JG;
    private final Matrix KZx;
    private final float[] ML;
    private final Matrix Og;
    private pA<?, PointF> SD;
    private pA<Integer, Integer> SGo;
    private pA<?, Float> Sn;
    private ZZv WV;
    private pA<?, Float> Wx;
    private final Matrix ZZv;
    private pA<com.bytedance.adsdk.Og.SD.KZx, com.bytedance.adsdk.Og.SD.KZx> omh;
    private final Matrix pA = new Matrix();

    public oX(com.bytedance.adsdk.Og.KZx.pA.WV wv) {
        this.JG = wv.pA() == null ? null : wv.pA().pA();
        this.SD = wv.Og() == null ? null : wv.Og().pA();
        this.omh = wv.KZx() == null ? null : wv.KZx().pA();
        this.Bzk = wv.ZZv() == null ? null : wv.ZZv().pA();
        ZZv zZv = wv.omh() == null ? null : (ZZv) wv.omh().pA();
        this.BSW = zZv;
        if (zZv != null) {
            this.Og = new Matrix();
            this.KZx = new Matrix();
            this.ZZv = new Matrix();
            this.ML = new float[9];
        } else {
            this.Og = null;
            this.KZx = null;
            this.ZZv = null;
            this.ML = null;
        }
        this.WV = wv.Bzk() == null ? null : (ZZv) wv.Bzk().pA();
        if (wv.ML() != null) {
            this.SGo = wv.ML().pA();
        }
        if (wv.JG() != null) {
            this.Wx = wv.JG().pA();
        } else {
            this.Wx = null;
        }
        if (wv.SD() != null) {
            this.Sn = wv.SD().pA();
        } else {
            this.Sn = null;
        }
    }

    public void pA(com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        pAVar.pA(this.SGo);
        pAVar.pA(this.Wx);
        pAVar.pA(this.Sn);
        pAVar.pA(this.JG);
        pAVar.pA(this.SD);
        pAVar.pA(this.omh);
        pAVar.pA(this.Bzk);
        pAVar.pA(this.BSW);
        pAVar.pA(this.WV);
    }

    public void pA(pA.InterfaceC0167pA interfaceC0167pA) {
        pA<Integer, Integer> pAVar = this.SGo;
        if (pAVar != null) {
            pAVar.pA(interfaceC0167pA);
        }
        pA<?, Float> pAVar2 = this.Wx;
        if (pAVar2 != null) {
            pAVar2.pA(interfaceC0167pA);
        }
        pA<?, Float> pAVar3 = this.Sn;
        if (pAVar3 != null) {
            pAVar3.pA(interfaceC0167pA);
        }
        pA<PointF, PointF> pAVar4 = this.JG;
        if (pAVar4 != null) {
            pAVar4.pA(interfaceC0167pA);
        }
        pA<?, PointF> pAVar5 = this.SD;
        if (pAVar5 != null) {
            pAVar5.pA(interfaceC0167pA);
        }
        pA<com.bytedance.adsdk.Og.SD.KZx, com.bytedance.adsdk.Og.SD.KZx> pAVar6 = this.omh;
        if (pAVar6 != null) {
            pAVar6.pA(interfaceC0167pA);
        }
        pA<Float, Float> pAVar7 = this.Bzk;
        if (pAVar7 != null) {
            pAVar7.pA(interfaceC0167pA);
        }
        ZZv zZv = this.BSW;
        if (zZv != null) {
            zZv.pA(interfaceC0167pA);
        }
        ZZv zZv2 = this.WV;
        if (zZv2 != null) {
            zZv2.pA(interfaceC0167pA);
        }
    }

    public void pA(float f) {
        pA<Integer, Integer> pAVar = this.SGo;
        if (pAVar != null) {
            pAVar.pA(f);
        }
        pA<?, Float> pAVar2 = this.Wx;
        if (pAVar2 != null) {
            pAVar2.pA(f);
        }
        pA<?, Float> pAVar3 = this.Sn;
        if (pAVar3 != null) {
            pAVar3.pA(f);
        }
        pA<PointF, PointF> pAVar4 = this.JG;
        if (pAVar4 != null) {
            pAVar4.pA(f);
        }
        pA<?, PointF> pAVar5 = this.SD;
        if (pAVar5 != null) {
            pAVar5.pA(f);
        }
        pA<com.bytedance.adsdk.Og.SD.KZx, com.bytedance.adsdk.Og.SD.KZx> pAVar6 = this.omh;
        if (pAVar6 != null) {
            pAVar6.pA(f);
        }
        pA<Float, Float> pAVar7 = this.Bzk;
        if (pAVar7 != null) {
            pAVar7.pA(f);
        }
        ZZv zZv = this.BSW;
        if (zZv != null) {
            zZv.pA(f);
        }
        ZZv zZv2 = this.WV;
        if (zZv2 != null) {
            zZv2.pA(f);
        }
    }

    public pA<?, Integer> pA() {
        return this.SGo;
    }

    public pA<?, Float> Og() {
        return this.Wx;
    }

    public pA<?, Float> KZx() {
        return this.Sn;
    }

    public Matrix ZZv() {
        PointF pointFSD;
        float fBzk;
        PointF pointFSD2;
        this.pA.reset();
        pA<?, PointF> pAVar = this.SD;
        if (pAVar != null && (pointFSD2 = pAVar.SD()) != null && (pointFSD2.x != 0.0f || pointFSD2.y != 0.0f)) {
            this.pA.preTranslate(pointFSD2.x, pointFSD2.y);
        }
        pA<Float, Float> pAVar2 = this.Bzk;
        if (pAVar2 != null) {
            if (pAVar2 instanceof aBv) {
                fBzk = pAVar2.SD().floatValue();
            } else {
                fBzk = ((ZZv) pAVar2).Bzk();
            }
            if (fBzk != 0.0f) {
                this.pA.preRotate(fBzk);
            }
        }
        ZZv zZv = this.BSW;
        if (zZv != null) {
            ZZv zZv2 = this.WV;
            float fCos = zZv2 == null ? 0.0f : (float) Math.cos(Math.toRadians((-zZv2.Bzk()) + 90.0f));
            ZZv zZv3 = this.WV;
            float fSin = zZv3 == null ? 1.0f : (float) Math.sin(Math.toRadians((-zZv3.Bzk()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(zZv.Bzk()));
            ML();
            float[] fArr = this.ML;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f = -fSin;
            fArr[3] = f;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.Og.setValues(fArr);
            ML();
            float[] fArr2 = this.ML;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.KZx.setValues(fArr2);
            ML();
            float[] fArr3 = this.ML;
            fArr3[0] = fCos;
            fArr3[1] = f;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.ZZv.setValues(fArr3);
            this.KZx.preConcat(this.Og);
            this.ZZv.preConcat(this.KZx);
            this.pA.preConcat(this.ZZv);
        }
        pA<com.bytedance.adsdk.Og.SD.KZx, com.bytedance.adsdk.Og.SD.KZx> pAVar3 = this.omh;
        if (pAVar3 != null) {
            com.bytedance.adsdk.Og.SD.KZx kZxSD = pAVar3.SD();
            if (kZxSD.pA() != 1.0f || kZxSD.Og() != 1.0f) {
                this.pA.preScale(kZxSD.pA(), kZxSD.Og());
            }
        }
        pA<PointF, PointF> pAVar4 = this.JG;
        if (pAVar4 != null && (((pointFSD = pAVar4.SD()) != null && pointFSD.x != 0.0f) || pointFSD.y != 0.0f)) {
            this.pA.preTranslate(-pointFSD.x, -pointFSD.y);
        }
        return this.pA;
    }

    private void ML() {
        for (int i = 0; i < 9; i++) {
            this.ML[i] = 0.0f;
        }
    }

    public Matrix Og(float f) {
        pA<?, PointF> pAVar = this.SD;
        PointF pointFSD = pAVar == null ? null : pAVar.SD();
        pA<com.bytedance.adsdk.Og.SD.KZx, com.bytedance.adsdk.Og.SD.KZx> pAVar2 = this.omh;
        com.bytedance.adsdk.Og.SD.KZx kZxSD = pAVar2 == null ? null : pAVar2.SD();
        this.pA.reset();
        if (pointFSD != null) {
            this.pA.preTranslate(pointFSD.x * f, pointFSD.y * f);
        }
        if (kZxSD != null) {
            double d = f;
            this.pA.preScale((float) Math.pow(kZxSD.pA(), d), (float) Math.pow(kZxSD.Og(), d));
        }
        pA<Float, Float> pAVar3 = this.Bzk;
        if (pAVar3 != null) {
            float fFloatValue = pAVar3.SD().floatValue();
            pA<PointF, PointF> pAVar4 = this.JG;
            PointF pointFSD2 = pAVar4 != null ? pAVar4.SD() : null;
            this.pA.preRotate(fFloatValue * f, pointFSD2 == null ? 0.0f : pointFSD2.x, pointFSD2 != null ? pointFSD2.y : 0.0f);
        }
        return this.pA;
    }
}
