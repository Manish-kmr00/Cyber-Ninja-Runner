package io.bidmachine.rendering.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import io.bidmachine.rendering.internal.i;
import io.bidmachine.rendering.internal.q;
import io.bidmachine.rendering.model.AppearanceParams;

/* JADX INFO: loaded from: classes8.dex */
public class c extends View implements io.bidmachine.rendering.internal.f, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Paint f12377a;
    float b;
    int c;
    int d;

    public c(Context context) {
        super(context);
        this.f12377a = new Paint(1);
        this.b = 0.0f;
        this.c = i.b;
        this.d = 0;
    }

    @Override // io.bidmachine.rendering.internal.f
    public void a(AppearanceParams appearanceParams) {
        Integer backgroundColor = appearanceParams.getBackgroundColor();
        if (backgroundColor != null) {
            this.d = backgroundColor.intValue();
        }
        Integer strokeColor = appearanceParams.getStrokeColor();
        if (strokeColor != null) {
            this.c = strokeColor.intValue();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float measuredHeight = (getMeasuredHeight() / 2.0f) + getPaddingTop();
        this.f12377a.setColor(this.d);
        canvas.drawLine(getPaddingLeft(), measuredHeight, getPaddingLeft() + width, measuredHeight, this.f12377a);
        this.f12377a.setColor(this.c);
        canvas.drawLine(getPaddingLeft(), measuredHeight, getPaddingLeft() + ((width * this.b) / 100.0f), measuredHeight, this.f12377a);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f12377a.setStrokeWidth(getMeasuredHeight());
    }

    @Override // io.bidmachine.rendering.internal.q
    public void a(long j, long j2, float f) {
        this.b = f;
        postInvalidate();
    }
}
