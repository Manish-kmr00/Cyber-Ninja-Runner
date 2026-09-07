package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class Sn extends com.bytedance.sdk.openadsdk.core.ML.ZZv {
    private RectF Og;
    private Paint pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public Sn(Context context) {
        super(context);
        pA();
    }

    private void pA() {
        Paint paint = new Paint();
        this.pA = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.pA.setColor(Color.parseColor("#99333333"));
        this.pA.setAntiAlias(true);
        this.pA.setStrokeWidth(0.0f);
        this.Og = new RectF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Og.right == getMeasuredWidth() && this.Og.bottom == getMeasuredHeight()) {
            return;
        }
        this.Og.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.Og;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.Og.bottom / 2.0f, this.pA);
        super.onDraw(canvas);
    }
}
