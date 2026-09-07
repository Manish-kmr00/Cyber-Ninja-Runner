package com.applovin.impl;

import android.content.Context;
import android.view.MotionEvent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes5.dex */
public class t1 extends AppLovinAdView {
    public t1(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        super(appLovinSdk, appLovinAdSize, context);
    }

    @Override // com.applovin.adview.AppLovinAdView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.f8160a, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.applovin.adview.AppLovinAdView, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
