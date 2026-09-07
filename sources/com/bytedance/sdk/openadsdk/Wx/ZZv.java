package com.bytedance.sdk.openadsdk.Wx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class ZZv extends SGo {
    @Override // com.bytedance.sdk.openadsdk.Wx.SGo, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.Wx.SGo, com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public ZZv(Context context) {
        this(context, null);
    }

    public ZZv(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZZv(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.Wx.SGo
    protected void pA(Context context) {
        int iKZx = Vgu.KZx(context, 10.0f);
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ml.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        ml.setOrientation(1);
        ml.setPadding(iKZx, iKZx, iKZx, iKZx);
        addView(ml);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 3.0f;
        kZx.setLayoutParams(layoutParams2);
        ml.addView(kZx);
        this.pA = ML(context);
        this.pA.setId(com.bytedance.sdk.openadsdk.utils.Sn.rjD);
        this.pA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        kZx.addView(this.pA);
        this.Og = JG(context);
        this.Og.setId(com.bytedance.sdk.openadsdk.utils.Sn.npn);
        this.Og.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        kZx.addView(this.Og);
        PAGLogoView pAGLogoViewOmh = omh(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        layoutParams3.leftMargin = iKZx;
        layoutParams3.topMargin = iKZx;
        layoutParams3.bottomMargin = iKZx;
        pAGLogoViewOmh.setLayoutParams(layoutParams3);
        kZx.addView(pAGLogoViewOmh);
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 1.0f;
        sd.setLayoutParams(layoutParams4);
        ml.addView(sd);
        this.KZx = SD(context);
        this.KZx.setId(com.bytedance.sdk.openadsdk.utils.Sn.uQ);
        int iKZx2 = Vgu.KZx(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iKZx2, iKZx2);
        layoutParams5.addRule(15);
        this.KZx.setLayoutParams(layoutParams5);
        sd.addView(this.KZx);
        this.ZZv = Og(context);
        this.ZZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.mK);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(15);
        layoutParams6.leftMargin = iKZx;
        layoutParams6.setMarginStart(iKZx);
        layoutParams6.addRule(1, com.bytedance.sdk.openadsdk.utils.Sn.uQ);
        layoutParams6.addRule(17, com.bytedance.sdk.openadsdk.utils.Sn.uQ);
        this.ZZv.setLayoutParams(layoutParams6);
        sd.addView(this.ZZv);
        this.JG = ZZv(context);
        this.JG.setId(com.bytedance.sdk.openadsdk.utils.Sn.jO);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(Vgu.KZx(context, 100.0f), Vgu.KZx(context, 32.0f));
        layoutParams7.addRule(11);
        layoutParams7.addRule(21);
        layoutParams7.addRule(15);
        this.JG.setLayoutParams(layoutParams7);
        sd.addView(this.JG);
    }
}
