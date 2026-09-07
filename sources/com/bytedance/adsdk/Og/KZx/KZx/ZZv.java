package com.bytedance.adsdk.Og.KZx.KZx;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes13.dex */
public class ZZv extends pA {
    private com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> BSW;
    private final Rect Bzk;
    protected final com.bytedance.adsdk.Og.SGo SD;
    private final Rect SGo;
    private com.bytedance.adsdk.Og.pA.Og.pA<Bitmap, Bitmap> WV;
    private final Paint omh;

    ZZv(com.bytedance.adsdk.Og.Bzk bzk, ML ml) {
        super(bzk, ml);
        this.omh = new com.bytedance.adsdk.Og.pA.pA(3);
        this.Bzk = new Rect();
        this.SGo = new Rect();
        this.SD = bzk.JG(ml.SD());
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA
    public void Og(Canvas canvas, Matrix matrix, int i) {
        super.Og(canvas, matrix, i);
        Bitmap bitmapWV = WV();
        if (bitmapWV == null || bitmapWV.isRecycled() || this.SD == null) {
            return;
        }
        float fPA = com.bytedance.adsdk.Og.JG.JG.pA();
        this.omh.setAlpha(i);
        com.bytedance.adsdk.Og.pA.Og.pA<ColorFilter, ColorFilter> pAVar = this.BSW;
        if (pAVar != null) {
            this.omh.setColorFilter(pAVar.SD());
        }
        canvas.save();
        canvas.concat(matrix);
        this.Bzk.set(0, 0, bitmapWV.getWidth(), bitmapWV.getHeight());
        if (this.Og.ML()) {
            this.SGo.set(0, 0, (int) (this.SD.pA() * fPA), (int) (this.SD.Og() * fPA));
        } else {
            this.SGo.set(0, 0, (int) (bitmapWV.getWidth() * fPA), (int) (bitmapWV.getHeight() * fPA));
        }
        canvas.drawBitmap(bitmapWV, this.Bzk, this.SGo, this.omh);
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA, com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(RectF rectF, Matrix matrix, boolean z) {
        super.pA(rectF, matrix, z);
        if (this.SD != null) {
            float fPA = com.bytedance.adsdk.Og.JG.JG.pA();
            rectF.set(0.0f, 0.0f, this.SD.pA() * fPA, this.SD.Og() * fPA);
            this.pA.mapRect(rectF);
        }
    }

    private Bitmap WV() {
        Bitmap bitmapSD;
        com.bytedance.adsdk.Og.pA.Og.pA<Bitmap, Bitmap> pAVar = this.WV;
        if (pAVar != null && (bitmapSD = pAVar.SD()) != null) {
            return bitmapSD;
        }
        Bitmap bitmapML = this.Og.ML(this.KZx.SD());
        if (bitmapML != null) {
            return bitmapML;
        }
        com.bytedance.adsdk.Og.SGo sGo = this.SD;
        if (sGo != null) {
            return sGo.BSW();
        }
        return null;
    }
}
