package com.five_corp.ad.internal.ad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class p extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f1307a;

    public p(Context context) {
        super(context);
        Paint paint = new Paint(getPaint());
        this.f1307a = paint;
        paint.setAntiAlias(true);
        paint.setStrokeWidth(4.0f);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.drawText(getText().toString(), (getWidth() - this.f1307a.measureText(getText().toString())) / 2.0f, getBaseline(), this.f1307a);
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
