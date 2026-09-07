package com.smaato.sdk.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.openmeasurement.ViewabilityVerificationResource;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AdContentView extends FrameLayout {
    protected static final String OMID = "omid";

    public abstract void destroy();

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    public abstract View getViewForOmTracking();

    public abstract View getViewForVisibilityTracking();

    public abstract Map<String, List<ViewabilityVerificationResource>> getViewabilityVerificationResourcesMap();

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public abstract void showProgressIndicator(boolean z);

    public abstract void startShowingView();

    public AdContentView(Context context) {
        super(context);
    }

    public AdContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AdContentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected static FrameLayout.LayoutParams generateDefaultLayoutParams(int i, int i2) {
        return new FrameLayout.LayoutParams(i, i2, 17);
    }
}
