package com.bytedance.adsdk.Og.KZx.KZx;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes13.dex */
public class omh extends pA {
    private final ML BSW;
    private final float[] Bzk;
    private final RectF SD;
    private final Path SGo;
    private com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> WV;
    private final Paint omh;

    omh(com.bytedance.adsdk.Og.Bzk bzk, ML ml) {
        super(bzk, ml);
        this.SD = new RectF();
        com.bytedance.adsdk.Og.pA.pA pAVar = new com.bytedance.adsdk.Og.pA.pA();
        this.omh = pAVar;
        this.Bzk = new float[8];
        this.SGo = new Path();
        this.BSW = ml;
        pAVar.setAlpha(0);
        pAVar.setStyle(Paint.Style.FILL);
        pAVar.setColor(ml.oX());
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA
    public void Og(Canvas canvas, Matrix matrix, int i) {
        super.Og(canvas, matrix, i);
        int iAlpha = Color.alpha(this.BSW.oX());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.ZZv.pA() == null ? 100 : this.ZZv.pA().SD().intValue())) / 100.0f) * 255.0f);
        this.omh.setAlpha(iIntValue);
        com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> pAVar = this.WV;
        if (pAVar != null) {
            this.omh.setColorFilter(pAVar.SD());
        }
        if (iIntValue > 0) {
            float[] fArr = this.Bzk;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.BSW.XT();
            float[] fArr2 = this.Bzk;
            fArr2[3] = 0.0f;
            fArr2[4] = this.BSW.XT();
            this.Bzk[5] = this.BSW.aBv();
            float[] fArr3 = this.Bzk;
            fArr3[6] = 0.0f;
            fArr3[7] = this.BSW.aBv();
            matrix.mapPoints(this.Bzk);
            this.SGo.reset();
            Path path = this.SGo;
            float[] fArr4 = this.Bzk;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.SGo;
            float[] fArr5 = this.Bzk;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.SGo;
            float[] fArr6 = this.Bzk;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.SGo;
            float[] fArr7 = this.Bzk;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.SGo;
            float[] fArr8 = this.Bzk;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.SGo.close();
            canvas.drawPath(this.SGo, this.omh);
        }
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA, com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(RectF rectF, Matrix matrix, boolean z) {
        super.pA(rectF, matrix, z);
        this.SD.set(0.0f, 0.0f, this.BSW.XT(), this.BSW.aBv());
        this.pA.mapRect(this.SD);
        rectF.set(this.SD);
    }
}
