package io.bidmachine.iab.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ProgressBar;
import androidx.core.internal.view.SupportMenu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes9.dex */
public final class CircularProgressBar extends ProgressBar implements IabElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CircularProgressDrawable f12231a;
    final Paint b;

    public CircularProgressBar(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(0);
        a(context);
    }

    void a(Context context) {
        float f = getResources().getDisplayMetrics().density;
        int iDpToPx = Utils.dpToPx(context, 8.0f);
        setPadding(iDpToPx, iDpToPx, iDpToPx, iDpToPx);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        this.f12231a = circularProgressDrawable;
        circularProgressDrawable.setStrokeWidth(f * 4.0f);
        this.f12231a.setColorSchemeColors(SupportMenu.CATEGORY_MASK);
        this.f12231a.setStrokeCap(Paint.Cap.ROUND);
        setIndeterminateDrawable(this.f12231a);
        setIndeterminate(true);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, Math.min(getWidth(), getHeight()) / 2.0f, this.b);
        super.onDraw(canvas);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f12231a.setCenterRadius((Math.min((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f) - this.f12231a.getStrokeWidth());
    }

    public void setColorSchemeColors(int... colors) {
        this.f12231a.setColorSchemeColors(colors);
    }

    public void setProgressBackgroundColor(int color) {
        this.b.setColor(color);
    }

    @Override // io.bidmachine.iab.utils.IabElement
    public void setStyle(IabElementStyle style) {
        this.f12231a.setStrokeWidth(style.getStrokeWidth(getContext()).floatValue());
        this.f12231a.setColorSchemeColors(style.getStrokeColor().intValue());
        this.b.setColor(style.getFillColor().intValue());
        postInvalidate();
    }

    public CircularProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(0);
        a(context);
    }

    public CircularProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(0);
        a(context);
    }
}
