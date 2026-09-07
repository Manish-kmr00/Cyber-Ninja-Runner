package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class SD implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, BSW, ML {
    private final com.bytedance.adsdk.Og.Bzk BSW;
    private final com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> Bzk;
    private final boolean JG;
    private final Paint KZx;
    private final String ML;
    private final Path Og;
    private final List<Wx> SD;
    private com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> SGo;
    private com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> WV;
    private com.bytedance.adsdk.Og.pA.Og.KZx Wx;
    private final com.bytedance.adsdk.Og.KZx.KZx.pA ZZv;
    private final com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> omh;
    float pA;

    public SD(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.DX dx) {
        Path path = new Path();
        this.Og = path;
        this.KZx = new com.bytedance.adsdk.Og.pA.pA(1);
        this.SD = new ArrayList();
        this.ZZv = pAVar;
        this.ML = dx.pA();
        this.JG = dx.ML();
        this.BSW = bzk;
        if (pAVar.SGo() != null) {
            com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA = pAVar.SGo().pA().pA();
            this.WV = pAVarPA;
            pAVarPA.pA(this);
            pAVar.pA(this.WV);
        }
        if (pAVar.BSW() != null) {
            this.Wx = new com.bytedance.adsdk.Og.pA.Og.KZx(this, pAVar, pAVar.BSW());
        }
        if (dx.Og() == null || dx.KZx() == null) {
            this.omh = null;
            this.Bzk = null;
            return;
        }
        path.setFillType(dx.ZZv());
        com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVarPA2 = dx.Og().pA();
        this.omh = pAVarPA2;
        pAVarPA2.pA(this);
        pAVar.pA(pAVarPA2);
        com.bytedance.adsdk.Og.pA.Og.pA<Integer, Integer> pAVarPA3 = dx.KZx().pA();
        this.Bzk = pAVarPA3;
        pAVarPA3.pA(this);
        pAVar.pA(pAVarPA3);
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        this.BSW.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
        for (int i = 0; i < list2.size(); i++) {
            KZx kZx = list2.get(i);
            if (kZx instanceof Wx) {
                this.SD.add((Wx) kZx);
            }
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(Canvas canvas, Matrix matrix, int i) {
        if (this.JG) {
            return;
        }
        com.bytedance.adsdk.Og.ML.pA("FillContent#draw");
        this.KZx.setColor((com.bytedance.adsdk.Og.JG.ML.pA((int) ((((i / 255.0f) * this.Bzk.SD().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.Og.pA.Og.Og) this.omh).Bzk() & ViewCompat.MEASURED_SIZE_MASK));
        com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> pAVar = this.SGo;
        if (pAVar != null) {
            this.KZx.setColorFilter(pAVar.SD());
        }
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVar2 = this.WV;
        if (pAVar2 != null) {
            float fFloatValue = pAVar2.SD().floatValue();
            if (fFloatValue == 0.0f) {
                this.KZx.setMaskFilter(null);
            } else if (fFloatValue != this.pA) {
                this.KZx.setMaskFilter(this.ZZv.Og(fFloatValue));
            }
            this.pA = fFloatValue;
        }
        com.bytedance.adsdk.Og.pA.Og.KZx kZx = this.Wx;
        if (kZx != null) {
            kZx.pA(this.KZx);
        }
        this.Og.reset();
        for (int i2 = 0; i2 < this.SD.size(); i2++) {
            this.Og.addPath(this.SD.get(i2).ZZv(), matrix);
        }
        canvas.drawPath(this.Og, this.KZx);
        com.bytedance.adsdk.Og.ML.Og("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(RectF rectF, Matrix matrix, boolean z) {
        this.Og.reset();
        for (int i = 0; i < this.SD.size(); i++) {
            this.Og.addPath(this.SD.get(i).ZZv(), matrix);
        }
        this.Og.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
