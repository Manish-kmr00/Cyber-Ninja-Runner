package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public abstract class pA implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, BSW, ML {
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> BSW;
    private com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> DX;
    float KZx;
    final Paint Og;
    private final float[] SGo;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Float> Sn;
    private final com.bytedance.adsdk.Og.pA.Og.pA<?, Integer> WV;
    private final List<com.bytedance.adsdk.Og.pA.Og.pA<?, Float>> Wx;
    private com.bytedance.adsdk.Og.pA.Og.KZx aBv;
    private com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> oX;
    private final com.bytedance.adsdk.Og.Bzk omh;
    protected final com.bytedance.adsdk.Og.KZx.KZx.pA pA;
    private final PathMeasure ZZv = new PathMeasure();
    private final Path ML = new Path();
    private final Path JG = new Path();
    private final RectF SD = new RectF();
    private final List<C0168pA> Bzk = new ArrayList();

    pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, Paint.Cap cap, Paint.Join join, float f, com.bytedance.adsdk.Og.KZx.pA.ZZv zZv, com.bytedance.adsdk.Og.KZx.pA.Og og, List<com.bytedance.adsdk.Og.KZx.pA.Og> list, com.bytedance.adsdk.Og.KZx.pA.Og og2) {
        com.bytedance.adsdk.Og.pA.pA pAVar2 = new com.bytedance.adsdk.Og.pA.pA(1);
        this.Og = pAVar2;
        this.KZx = 0.0f;
        this.omh = bzk;
        this.pA = pAVar;
        pAVar2.setStyle(Paint.Style.STROKE);
        pAVar2.setStrokeCap(cap);
        pAVar2.setStrokeJoin(join);
        pAVar2.setStrokeMiter(f);
        this.WV = zZv.pA();
        this.BSW = og.pA();
        if (og2 == null) {
            this.Sn = null;
        } else {
            this.Sn = og2.pA();
        }
        this.Wx = new ArrayList(list.size());
        this.SGo = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.Wx.add(list.get(i).pA());
        }
        pAVar.pA(this.WV);
        pAVar.pA(this.BSW);
        for (int i2 = 0; i2 < this.Wx.size(); i2++) {
            pAVar.pA(this.Wx.get(i2));
        }
        com.bytedance.adsdk.Og.pA.Og.pA<?, Float> pAVar3 = this.Sn;
        if (pAVar3 != null) {
            pAVar.pA(pAVar3);
        }
        this.WV.pA(this);
        this.BSW.pA(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.Wx.get(i3).pA(this);
        }
        com.bytedance.adsdk.Og.pA.Og.pA<?, Float> pAVar4 = this.Sn;
        if (pAVar4 != null) {
            pAVar4.pA(this);
        }
        if (pAVar.SGo() != null) {
            com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA = pAVar.SGo().pA().pA();
            this.oX = pAVarPA;
            pAVarPA.pA(this);
            pAVar.pA(this.oX);
        }
        if (pAVar.BSW() != null) {
            this.aBv = new com.bytedance.adsdk.Og.pA.Og.KZx(this, pAVar, pAVar.BSW());
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        this.omh.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
        TX tx = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            KZx kZx = list.get(size);
            if (kZx instanceof TX) {
                TX tx2 = (TX) kZx;
                if (tx2.Og() == com.bytedance.adsdk.Og.KZx.Og.yFO.pA.INDIVIDUALLY) {
                    tx = tx2;
                }
            }
        }
        if (tx != null) {
            tx.pA(this);
        }
        C0168pA c0168pA = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            KZx kZx2 = list2.get(size2);
            if (kZx2 instanceof TX) {
                TX tx3 = (TX) kZx2;
                if (tx3.Og() == com.bytedance.adsdk.Og.KZx.Og.yFO.pA.INDIVIDUALLY) {
                    if (c0168pA != null) {
                        this.Bzk.add(c0168pA);
                    }
                    c0168pA = new C0168pA(tx3);
                    tx3.pA(this);
                } else if (!(kZx2 instanceof Wx)) {
                    if (c0168pA == null) {
                        c0168pA = new C0168pA(tx);
                    }
                    c0168pA.pA.add((Wx) kZx2);
                }
            } else if (!(kZx2 instanceof Wx)) {
                if (c0168pA == null) {
                    c0168pA = new C0168pA(tx);
                }
                c0168pA.pA.add((Wx) kZx2);
            }
        }
        if (c0168pA != null) {
            this.Bzk.add(c0168pA);
        }
    }

    public void pA(Canvas canvas, Matrix matrix, int i) {
        com.bytedance.adsdk.Og.ML.pA("StrokeContent#draw");
        if (com.bytedance.adsdk.Og.JG.JG.Og(matrix)) {
            com.bytedance.adsdk.Og.ML.Og("StrokeContent#draw");
            return;
        }
        this.Og.setAlpha(com.bytedance.adsdk.Og.JG.ML.pA((int) ((((i / 255.0f) * ((com.bytedance.adsdk.Og.pA.Og.JG) this.WV).Bzk()) / 100.0f) * 255.0f), 0, 255));
        this.Og.setStrokeWidth(((com.bytedance.adsdk.Og.pA.Og.ZZv) this.BSW).Bzk() * com.bytedance.adsdk.Og.JG.JG.pA(matrix));
        if (this.Og.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.Og.ML.Og("StrokeContent#draw");
            return;
        }
        pA(matrix);
        com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> pAVar = this.DX;
        if (pAVar != null) {
            this.Og.setColorFilter(pAVar.SD());
        }
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar2 = this.oX;
        if (pAVar2 != null) {
            float fFloatValue = pAVar2.SD().floatValue();
            if (fFloatValue == 0.0f) {
                this.Og.setMaskFilter(null);
            } else if (fFloatValue != this.KZx) {
                this.Og.setMaskFilter(this.pA.Og(fFloatValue));
            }
            this.KZx = fFloatValue;
        }
        com.bytedance.adsdk.Og.pA.Og.KZx kZx = this.aBv;
        if (kZx != null) {
            kZx.pA(this.Og);
        }
        for (int i2 = 0; i2 < this.Bzk.size(); i2++) {
            C0168pA c0168pA = this.Bzk.get(i2);
            if (c0168pA.Og != null) {
                pA(canvas, c0168pA, matrix);
            } else {
                com.bytedance.adsdk.Og.ML.pA("StrokeContent#buildPath");
                this.ML.reset();
                for (int size = c0168pA.pA.size() - 1; size >= 0; size--) {
                    this.ML.addPath(((Wx) c0168pA.pA.get(size)).ZZv(), matrix);
                }
                com.bytedance.adsdk.Og.ML.Og("StrokeContent#buildPath");
                com.bytedance.adsdk.Og.ML.pA("StrokeContent#drawPath");
                canvas.drawPath(this.ML, this.Og);
                com.bytedance.adsdk.Og.ML.Og("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.Og.ML.Og("StrokeContent#draw");
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0110  */
    private void pA(Canvas canvas, C0168pA c0168pA, Matrix matrix) {
        float f;
        float f2;
        float fMin;
        com.bytedance.adsdk.Og.ML.pA("StrokeContent#applyTrimPath");
        if (c0168pA.Og == null) {
            com.bytedance.adsdk.Og.ML.Og("StrokeContent#applyTrimPath");
            return;
        }
        this.ML.reset();
        for (int size = c0168pA.pA.size() - 1; size >= 0; size--) {
            this.ML.addPath(((Wx) c0168pA.pA.get(size)).ZZv(), matrix);
        }
        float fFloatValue = c0168pA.Og.KZx().SD().floatValue() / 100.0f;
        float fFloatValue2 = c0168pA.Og.ZZv().SD().floatValue() / 100.0f;
        float fFloatValue3 = c0168pA.Og.ML().SD().floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.ML, this.Og);
            com.bytedance.adsdk.Og.ML.Og("StrokeContent#applyTrimPath");
            return;
        }
        this.ZZv.setPath(this.ML, false);
        float length = this.ZZv.getLength();
        while (this.ZZv.nextContour()) {
            length += this.ZZv.getLength();
        }
        float f3 = fFloatValue3 * length;
        float f4 = (fFloatValue * length) + f3;
        float fMin2 = Math.min((fFloatValue2 * length) + f3, (f4 + length) - 1.0f);
        float f5 = 0.0f;
        for (int size2 = c0168pA.pA.size() - 1; size2 >= 0; size2--) {
            this.JG.set(((Wx) c0168pA.pA.get(size2)).ZZv());
            this.JG.transform(matrix);
            this.ZZv.setPath(this.JG, false);
            float length2 = this.ZZv.getLength();
            if (fMin2 > length) {
                float f6 = fMin2 - length;
                if (f6 >= f5 + length2 || f5 >= f6) {
                    f = f5 + length2;
                    if (f < f4 && f5 <= fMin2) {
                        if (f > fMin2 || f4 >= f5) {
                            f2 = f4 < f5 ? 0.0f : (f4 - f5) / length2;
                            fMin = fMin2 > f ? 1.0f : (fMin2 - f5) / length2;
                        } else {
                            canvas.drawPath(this.JG, this.Og);
                        }
                    }
                } else {
                    f2 = f4 > length ? (f4 - length) / length2 : 0.0f;
                    fMin = Math.min(f6 / length2, 1.0f);
                }
                com.bytedance.adsdk.Og.JG.JG.pA(this.JG, f2, fMin, 0.0f);
                canvas.drawPath(this.JG, this.Og);
            } else {
                f = f5 + length2;
                if (f < f4) {
                }
            }
            f5 += length2;
        }
        com.bytedance.adsdk.Og.ML.Og("StrokeContent#applyTrimPath");
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(RectF rectF, Matrix matrix, boolean z) {
        com.bytedance.adsdk.Og.ML.pA("StrokeContent#getBounds");
        this.ML.reset();
        for (int i = 0; i < this.Bzk.size(); i++) {
            C0168pA c0168pA = this.Bzk.get(i);
            for (int i2 = 0; i2 < c0168pA.pA.size(); i2++) {
                this.ML.addPath(((Wx) c0168pA.pA.get(i2)).ZZv(), matrix);
            }
        }
        this.ML.computeBounds(this.SD, false);
        float fBzk = ((com.bytedance.adsdk.Og.pA.Og.ZZv) this.BSW).Bzk();
        RectF rectF2 = this.SD;
        float f = fBzk / 2.0f;
        rectF2.set(rectF2.left - f, this.SD.top - f, this.SD.right + f, this.SD.bottom + f);
        rectF.set(this.SD);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.Og.ML.Og("StrokeContent#getBounds");
    }

    private void pA(Matrix matrix) {
        com.bytedance.adsdk.Og.ML.pA("StrokeContent#applyDashPattern");
        if (this.Wx.isEmpty()) {
            com.bytedance.adsdk.Og.ML.Og("StrokeContent#applyDashPattern");
            return;
        }
        float fPA = com.bytedance.adsdk.Og.JG.JG.pA(matrix);
        for (int i = 0; i < this.Wx.size(); i++) {
            this.SGo[i] = this.Wx.get(i).SD().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.SGo;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.SGo;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.SGo;
            fArr3[i] = fArr3[i] * fPA;
        }
        com.bytedance.adsdk.Og.pA.Og.pA<?, Float> pAVar = this.Sn;
        this.Og.setPathEffect(new DashPathEffect(this.SGo, pAVar == null ? 0.0f : fPA * pAVar.SD().floatValue()));
        com.bytedance.adsdk.Og.ML.Og("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.Og.pA.pA.pA$pA, reason: collision with other inner class name */
    private static final class C0168pA {
        private final TX Og;
        private final List<Wx> pA;

        private C0168pA(TX tx) {
            this.pA = new ArrayList();
            this.Og = tx;
        }
    }
}
