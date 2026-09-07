package com.five_corp.ad;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes7.dex */
public class NativeMainView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f1253a;
    public final com.five_corp.ad.internal.logger.a b;
    public double c;
    public final int d;
    public boolean e;

    public NativeMainView(Context context, FrameLayout frameLayout, com.five_corp.ad.internal.logger.a aVar, int i) {
        super(context);
        this.e = false;
        this.f1253a = frameLayout;
        this.b = aVar;
        this.c = 0.0d;
        this.d = i;
        addView(frameLayout);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    public int getLogicalHeight() {
        if (this.e) {
            return getHeight();
        }
        int i = this.d;
        double d = this.c;
        if (d == 0.0d) {
            return 0;
        }
        return (int) (((double) i) * d);
    }

    public int getLogicalWidth() {
        return this.e ? getWidth() : this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            this.e = true;
        } catch (Throwable th) {
            this.b.a(th);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return callOnClick();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout frameLayout;
        try {
            int i3 = this.d;
            int i4 = 0;
            if (i3 > 0) {
                i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                int i5 = this.d;
                double d = this.c;
                if (d != 0.0d) {
                    i4 = (int) (((double) i5) * d);
                }
                i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else if (View.MeasureSpec.getMode(i) == 0) {
                int size = View.MeasureSpec.getSize(i2);
                double d2 = this.c;
                if (d2 != 0.0d) {
                    i4 = (int) (((double) size) / d2);
                }
                i = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else if (View.MeasureSpec.getMode(i2) == 0) {
                int size2 = View.MeasureSpec.getSize(i);
                double d3 = this.c;
                if (d3 != 0.0d) {
                    i4 = (int) (((double) size2) * d3);
                }
                i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            }
            int size3 = View.MeasureSpec.getSize(i);
            int size4 = View.MeasureSpec.getSize(i2);
            double d4 = this.c;
            if (d4 != 0.0d) {
                double d5 = size4;
                double d6 = size3;
                if (d5 < d4 * d6) {
                    frameLayout = this.f1253a;
                    layoutParams = new FrameLayout.LayoutParams((int) (d5 / this.c), size4, 17);
                } else {
                    FrameLayout frameLayout2 = this.f1253a;
                    layoutParams = new FrameLayout.LayoutParams(size3, (int) (d6 * this.c), 17);
                    frameLayout = frameLayout2;
                }
                frameLayout.setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
            this.b.a(th);
        }
        super.onMeasure(i, i2);
    }

    public void setConfigHeightToWidthRatio(double d) {
        this.c = d;
    }
}
