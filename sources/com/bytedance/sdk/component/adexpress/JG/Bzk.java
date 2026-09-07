package com.bytedance.sdk.component.adexpress.JG;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class Bzk extends View {
    private int JG;
    private final RectF KZx;
    private Paint ML;
    private int Og;
    private Paint SD;
    private Paint ZZv;
    private int omh;
    private int pA;

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
        this.KZx = new RectF();
        pA();
    }

    private void pA() {
        Paint paint = new Paint();
        this.ZZv = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.SD = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.ML = paint3;
        paint3.setAntiAlias(true);
    }

    public void setRadius(int i) {
        this.JG = i;
    }

    public void setDislikeColor(int i) {
        this.SD.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.SD.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.ZZv.setStyle(Paint.Style.STROKE);
        this.ZZv.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.ZZv.setStrokeWidth(i);
        this.omh = i;
    }

    public void setBgColor(int i) {
        this.ML.setStyle(Paint.Style.FILL);
        this.ML.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.KZx;
        int i = this.JG;
        canvas.drawRoundRect(rectF, i, i, this.ML);
        RectF rectF2 = this.KZx;
        int i2 = this.JG;
        canvas.drawRoundRect(rectF2, i2, i2, this.ZZv);
        int i3 = this.pA;
        int i4 = this.Og;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.SD);
        int i5 = this.pA;
        int i6 = this.Og;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.SD);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pA = i;
        this.Og = i2;
        RectF rectF = this.KZx;
        int i5 = this.omh;
        rectF.set(i5, i5, i - i5, i2 - i5);
    }
}
