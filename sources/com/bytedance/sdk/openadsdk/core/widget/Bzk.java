package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class Bzk extends View {
    private static final int[] pA = {Color.parseColor("#1AFFFFFF"), Color.parseColor("#4DFFFFFF"), Color.parseColor("#99FFFFFF")};
    private int Bzk;
    private final Paint JG;
    private final RectF KZx;
    private final Paint ML;
    private final RectF Og;
    private int SD;
    private final ArrayList<pA> ZZv;
    private int omh;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public Bzk(Context context) {
        super(context);
        this.Og = new RectF();
        this.KZx = new RectF();
        this.ZZv = new ArrayList<>();
        this.JG = new Paint();
        Paint paint = new Paint();
        this.ML = paint;
        paint.setColor(Color.parseColor("#D9D9D9"));
    }

    public void setProgress(int i) {
        int i2 = this.omh;
        if (i2 == i) {
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        if (i2 == i) {
            return;
        }
        this.omh = i;
        pA();
    }

    private void pA() {
        if (this.SD <= 0) {
            return;
        }
        this.KZx.right = Math.max(this.Bzk, (int) (((this.omh * 1.0f) / 100.0f) * getWidth()));
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = i2 / 2;
        this.SD = i5;
        this.Bzk = i5 * 5;
        float f = i;
        float f2 = i2;
        this.Og.set(0.0f, 0.0f, f, f2);
        this.KZx.set(0.0f, 0.0f, 0.0f, f2);
        this.JG.setShader(new LinearGradient(0.0f, 0.0f, f, f2, new int[]{Color.parseColor("#90C0FF"), Color.parseColor("#196BE4")}, (float[]) null, Shader.TileMode.CLAMP));
        this.ZZv.clear();
        float f3 = this.SD / 4.0f;
        for (int i6 : pA) {
            Paint paint = new Paint();
            paint.setColor(i6);
            this.ZZv.add(new pA(paint, this.SD / 2.0f, f3, f2 / 2.0f));
            f3 += (this.SD / 2.0f) * 3.0f;
        }
        pA();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.Og;
        int i = this.SD;
        canvas.drawRoundRect(rectF, i, i, this.ML);
        RectF rectF2 = this.KZx;
        int i2 = this.SD;
        canvas.drawRoundRect(rectF2, i2, i2, this.JG);
        int iSave = canvas.save();
        canvas.translate(this.KZx.right - this.Bzk, 0.0f);
        for (pA pAVar : this.ZZv) {
            canvas.drawCircle(pAVar.KZx, pAVar.ZZv, pAVar.Og, pAVar.pA);
        }
        canvas.restoreToCount(iSave);
    }

    private static final class pA {
        float KZx;
        public float Og;
        float ZZv;
        public Paint pA;

        public pA(Paint paint, float f, float f2, float f3) {
            this.pA = paint;
            this.Og = f;
            this.KZx = f2;
            this.ZZv = f3;
        }
    }
}
