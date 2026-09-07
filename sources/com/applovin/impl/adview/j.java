package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class j extends e {
    private static final Paint e = new Paint(1);
    private static final Paint f = new Paint(1);
    private final float[] c;
    private Path d;

    public j(Context context) {
        super(context);
        this.c = new float[]{30.0f, 30.0f, 50.0f, 50.0f, 30.0f, 70.0f, 55.0f, 30.0f, 75.0f, 50.0f, 55.0f, 70.0f};
        e.setARGB(80, 0, 0, 0);
        Paint paint = f;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.applovin.impl.adview.e
    public void a(int i) {
        setViewScale(i / 30.0f);
        a();
    }

    @Override // com.applovin.impl.adview.e, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.f8160a, this, me);
        return super.dispatchTouchEvent(me);
    }

    protected float getCenter() {
        return getSize() / 2.0f;
    }

    protected float getStrokeWidth() {
        return this.f345a * 2.0f;
    }

    @Override // com.applovin.impl.adview.e
    public e.a getStyle() {
        return e.a.TRANSPARENT_SKIP;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, e);
        Paint paint = f;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawPath(this.d, paint);
    }

    @Override // com.applovin.impl.adview.e, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private void a() {
        int i = 0;
        while (true) {
            float[] fArr = this.c;
            if (i < fArr.length) {
                fArr[i] = fArr[i] * 0.3f * this.f345a;
                i++;
            } else {
                Path path = new Path();
                this.d = path;
                float[] fArr2 = this.c;
                path.moveTo(fArr2[0], fArr2[1]);
                Path path2 = this.d;
                float[] fArr3 = this.c;
                path2.lineTo(fArr3[2], fArr3[3]);
                Path path3 = this.d;
                float[] fArr4 = this.c;
                path3.lineTo(fArr4[4], fArr4[5]);
                Path path4 = this.d;
                float[] fArr5 = this.c;
                path4.moveTo(fArr5[6], fArr5[7]);
                Path path5 = this.d;
                float[] fArr6 = this.c;
                path5.lineTo(fArr6[8], fArr6[9]);
                Path path6 = this.d;
                float[] fArr7 = this.c;
                path6.lineTo(fArr7[10], fArr7[11]);
                return;
            }
        }
    }
}
