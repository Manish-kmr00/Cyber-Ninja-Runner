package com.pubmatic.sdk.nativead.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.pubmatic.sdk.nativead.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes6.dex */
public class POBNativeAdSmallTemplateView extends POBNativeTemplateView {
    public POBNativeAdSmallTemplateView(Context context) {
        super(context, R.layout.pob_small_template);
    }

    @Override // com.pubmatic.sdk.nativead.views.POBNativeTemplateView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.pubmatic.sdk.nativead.views.POBNativeTemplateView, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public POBNativeAdSmallTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public POBNativeAdSmallTemplateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public POBNativeAdSmallTemplateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
