package com.pubmatic.sdk.nativead.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.pubmatic.sdk.nativead.R;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class POBNativeAdMediumTemplateView extends POBNativeTemplateView {
    public POBNativeAdMediumTemplateView(Context context) {
        super(context, R.layout.pob_medium_template);
    }

    @Override // com.pubmatic.sdk.nativead.views.POBNativeTemplateView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.pubmatic.sdk.nativead.views.POBNativeTemplateView
    public ImageView getMainImage() {
        return this.mainImage;
    }

    @Override // com.pubmatic.sdk.nativead.views.POBNativeTemplateView, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.pubmatic.sdk.nativead.views.POBNativeTemplateView
    public void setMainImage(ImageView imageView) {
        this.mainImage = imageView;
    }

    public POBNativeAdMediumTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public POBNativeAdMediumTemplateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public POBNativeAdMediumTemplateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
