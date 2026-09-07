package com.pubmatic.sdk.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes3.dex */
public class POBNativeAdView extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final POBNativeAdViewHandler f7690a;

    public POBNativeAdView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7690a.onAdViewAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f7690a.onClick(view);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setListener(POBNativeAdViewListener pOBNativeAdViewListener) {
        this.f7690a.setListener(pOBNativeAdViewListener);
    }

    public POBNativeAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public POBNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        POBNativeAdViewHandler pOBNativeAdViewHandler = new POBNativeAdViewHandler();
        this.f7690a = pOBNativeAdViewHandler;
        pOBNativeAdViewHandler.setAdView(this);
    }
}
