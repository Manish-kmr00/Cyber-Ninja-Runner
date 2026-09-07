package com.bytedance.sdk.openadsdk.core.BSW.Og.pA;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes9.dex */
public class pA extends com.bytedance.adsdk.ugeno.Bzk.Og.pA {
    private final com.bytedance.adsdk.ugeno.Bzk.Og.pA Og;
    private final com.bytedance.adsdk.ugeno.Bzk.Og.pA pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.adsdk.ugeno.Bzk.Og.pA, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public pA(Context context) {
        super(context);
        com.bytedance.adsdk.ugeno.Bzk.Og.pA pAVar = new com.bytedance.adsdk.ugeno.Bzk.Og.pA(context);
        this.pA = pAVar;
        addView(pAVar, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.adsdk.ugeno.Bzk.Og.pA pAVar2 = new com.bytedance.adsdk.ugeno.Bzk.Og.pA(context);
        this.Og = pAVar2;
        pAVar2.setBackgroundColor(0);
        addView(pAVar2, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Og.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.Og.setOnTouchListener(onTouchListener);
    }

    public com.bytedance.adsdk.ugeno.Bzk.Og.pA getVideoView() {
        return this.pA;
    }
}
