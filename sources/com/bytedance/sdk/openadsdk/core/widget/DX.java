package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.yandex.div2.PhoneMasks;

/* JADX INFO: loaded from: classes10.dex */
public class DX extends com.bytedance.sdk.openadsdk.core.ML.omh {
    private int KZx;
    private RectF Og;
    private Paint pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.omh, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public DX(Context context) {
        this(context, null);
    }

    public DX(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DX(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KZx = 0;
        pA();
    }

    private void pA() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.pA = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.pA.setColor(Color.parseColor("#99333333"));
        this.pA.setAntiAlias(true);
        this.pA.setStrokeWidth(0.0f);
        this.Og = new RectF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.omh, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int iMeasureText = (int) getPaint().measureText(PhoneMasks.EXTRA_NUMBERS);
            this.KZx = iMeasureText;
            if (measuredWidth < iMeasureText) {
                measuredWidth = iMeasureText;
            }
            int i3 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i3, measuredHeight);
            this.Og.set(0.0f, 0.0f, i3, measuredHeight);
            return;
        }
        this.Og.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.Og;
        canvas.drawRoundRect(rectF, rectF.bottom / 2.0f, this.Og.bottom / 2.0f, this.pA);
        canvas.translate((this.Og.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
