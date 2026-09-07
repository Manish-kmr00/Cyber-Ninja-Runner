package com.bytedance.sdk.openadsdk.KZx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class pA extends com.bytedance.sdk.openadsdk.core.ML.omh {
    private boolean KZx;
    private float Og;
    private int ZZv;
    private Paint pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.omh, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public pA(Context context) {
        super(context);
        pA();
    }

    private void pA() {
        this.Og = Vgu.pA(getContext(), 8.0f);
        this.pA = new Paint();
    }

    public void setMinTextSize(float f) {
        if (f <= 0.0f) {
            return;
        }
        this.Og = f;
    }

    private void pA(String str, int i) {
        if (!this.KZx && i > 0) {
            float textSize = getTextSize();
            this.pA.set(getPaint());
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            float fPA = pA(textSize, str);
            while (fPA > paddingLeft) {
                textSize -= 1.0f;
                this.pA.setTextSize(textSize);
                if (textSize <= this.Og) {
                    break;
                } else {
                    fPA = pA(textSize, str);
                }
            }
            setTextSize(0, textSize);
            this.KZx = true;
        }
    }

    private float pA(float f, String str) {
        this.pA.setTextSize(f);
        return this.pA.measureText(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.omh, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.ZZv = getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, this.ZZv);
        } else {
            layoutParams.height = this.ZZv;
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.omh, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        int i = this.ZZv;
        if (i == 0 || layoutParams == null) {
            return;
        }
        layoutParams.height = i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pA(getText().toString(), getWidth());
    }
}
