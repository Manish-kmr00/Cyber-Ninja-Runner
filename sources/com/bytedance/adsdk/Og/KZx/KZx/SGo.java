package com.bytedance.adsdk.Og.KZx.KZx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public class SGo extends ZZv {
    private int Bzk;
    private int SGo;
    private Path omh;

    public SGo(com.bytedance.adsdk.Og.Bzk bzk, ML ml, Context context) {
        super(bzk, ml);
        this.omh = null;
        this.Bzk = -1;
        this.SGo = -1;
        if (this.SD != null) {
            float fPA = com.bytedance.adsdk.Og.JG.JG.pA();
            this.Bzk = (int) (this.SD.pA() * fPA);
            this.SGo = (int) (this.SD.Og() * fPA);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.Bzk, this.SGo);
            Path path = new Path();
            this.omh = path;
            float f = fPA * 40.0f;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.ZZv, com.bytedance.adsdk.Og.KZx.KZx.pA
    public void Og(Canvas canvas, Matrix matrix, int i) {
        View viewPA = this.Og.pA();
        if (this.Bzk <= 0 || viewPA == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        pA(i);
        float fJG = JG();
        pA(viewPA, this.Bzk, this.SGo);
        viewPA.setAlpha(fJG);
        canvas.clipPath(this.omh);
        viewPA.draw(canvas);
        canvas.restore();
    }

    private static void pA(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
