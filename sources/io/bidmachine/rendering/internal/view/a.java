package io.bidmachine.rendering.internal.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes8.dex */
public class a extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f12373a;

    public a(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f12373a <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = measuredWidth;
        float f2 = measuredHeight;
        float f3 = this.f12373a;
        if ((f3 / (f / f2)) - 1.0f > 0.0f) {
            measuredHeight = (int) (f / f3);
        } else {
            measuredWidth = (int) (f2 * f3);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setVideoAspectRatio(float videoAspectRatio) {
        if (videoAspectRatio == 0.0f || this.f12373a == videoAspectRatio) {
            return;
        }
        this.f12373a = videoAspectRatio;
        requestLayout();
    }
}
