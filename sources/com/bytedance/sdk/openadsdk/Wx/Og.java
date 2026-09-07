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

/* JADX INFO: loaded from: classes14.dex */
public class Og extends SGo {
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

    public Og(Context context) {
        this(context, null);
    }

    public Og(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Og(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.Wx.SGo
    protected void pA(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ml.setOrientation(1);
        addView(ml);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 2.0f;
        kZx.setLayoutParams(layoutParams);
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
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 80;
        int iKZx = Vgu.KZx(context, 10.0f);
        layoutParams2.leftMargin = iKZx;
        layoutParams2.topMargin = iKZx;
        layoutParams2.bottomMargin = iKZx;
        pAGLogoViewOmh.setLayoutParams(layoutParams2);
        kZx.addView(pAGLogoViewOmh);
        com.bytedance.sdk.openadsdk.core.ML.ML ml2 = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 1.0f;
        ml2.setLayoutParams(layoutParams3);
        ml2.setOrientation(1);
        ml2.setGravity(81);
        int iKZx2 = Vgu.KZx(context, 16.0f);
        ml2.setPadding(iKZx2, iKZx2, iKZx2, iKZx2);
        ml.addView(ml2);
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        sd.setId(com.bytedance.sdk.openadsdk.utils.Sn.Lm);
        sd.setLayoutParams(new LinearLayout.LayoutParams(-2, Vgu.KZx(context, 40.0f)));
        sd.setGravity(17);
        ml2.addView(sd);
        this.KZx = SD(context);
        this.KZx.setId(com.bytedance.sdk.openadsdk.utils.Sn.uQ);
        int iKZx3 = Vgu.KZx(context, 35.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iKZx3, iKZx3);
        layoutParams4.addRule(20);
        layoutParams4.addRule(9);
        layoutParams4.addRule(15);
        this.KZx.setLayoutParams(layoutParams4);
        sd.addView(this.KZx);
        this.ZZv = Og(context);
        this.ZZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.mK);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, iKZx * 2);
        int iKZx4 = Vgu.KZx(context, 6.0f);
        layoutParams5.leftMargin = iKZx4;
        layoutParams5.setMarginStart(iKZx4);
        layoutParams5.addRule(1, this.KZx.getId());
        layoutParams5.addRule(17, this.KZx.getId());
        this.ZZv.setLayoutParams(layoutParams5);
        sd.addView(this.ZZv);
        this.ML = KZx(context);
        this.ML.setId(com.bytedance.sdk.openadsdk.utils.Sn.guZ);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, Vgu.KZx(context, 20.0f));
        layoutParams6.addRule(3, this.ZZv.getId());
        layoutParams6.addRule(8, this.KZx.getId());
        layoutParams6.addRule(17, this.KZx.getId());
        layoutParams6.addRule(1, this.KZx.getId());
        layoutParams6.leftMargin = iKZx4;
        layoutParams6.setMarginStart(iKZx4);
        this.ML.setLayoutParams(layoutParams6);
        sd.addView(this.ML);
        this.JG = ZZv(context);
        this.JG.setId(com.bytedance.sdk.openadsdk.utils.Sn.jO);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, Vgu.KZx(context, 22.0f));
        layoutParams7.topMargin = iKZx2;
        this.JG.setLayoutParams(layoutParams7);
        ml2.addView(this.JG);
    }

    @Override // com.bytedance.sdk.openadsdk.Wx.SGo
    protected com.bytedance.sdk.openadsdk.core.ML.omh Og(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVarOg = super.Og(context);
        omhVarOg.setTextColor(-1);
        omhVarOg.setTextSize(2, 13.0f);
        omhVarOg.setText("Pangle");
        return omhVarOg;
    }

    @Override // com.bytedance.sdk.openadsdk.Wx.SGo
    protected com.bytedance.sdk.openadsdk.core.ML.omh KZx(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVarKZx = super.KZx(context);
        omhVarKZx.setTextColor(-1);
        return omhVarKZx;
    }
}
