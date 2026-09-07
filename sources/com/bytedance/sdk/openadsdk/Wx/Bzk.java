package com.bytedance.sdk.openadsdk.Wx;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class Bzk extends SGo {
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

    public Bzk(Context context) {
        this(context, null);
    }

    public Bzk(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Bzk(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.Wx.SGo
    protected void pA(Context context) {
        int iKZx = Vgu.KZx(context, 10.0f);
        int iKZx2 = Vgu.KZx(context, 6.0f);
        int iKZx3 = Vgu.KZx(context, 16.0f);
        int iKZx4 = Vgu.KZx(context, 15.0f);
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        sd.setLayoutParams(layoutParams);
        addView(sd);
        this.pA = ML(context);
        this.pA.setId(com.bytedance.sdk.openadsdk.utils.Sn.rjD);
        this.pA.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        sd.addView(this.pA);
        this.Og = JG(context);
        this.Og.setId(com.bytedance.sdk.openadsdk.utils.Sn.npn);
        this.Og.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        sd.addView(this.Og);
        com.bytedance.sdk.openadsdk.core.ML.SD sd2 = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        sd2.setId(com.bytedance.sdk.openadsdk.utils.Sn.Uz);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, Vgu.KZx(context, 48.0f));
        layoutParams2.addRule(12);
        sd2.setLayoutParams(layoutParams2);
        sd2.setBackgroundColor(Color.parseColor("#26000000"));
        sd2.setGravity(16);
        sd2.setPadding(iKZx4, 0, 0, 0);
        sd.addView(sd2);
        this.KZx = SD(context);
        this.KZx.setId(com.bytedance.sdk.openadsdk.utils.Sn.uQ);
        int iKZx5 = Vgu.KZx(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iKZx5, iKZx5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = iKZx;
        layoutParams3.setMarginStart(iKZx);
        this.KZx.setLayoutParams(layoutParams3);
        sd2.addView(this.KZx);
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(17, com.bytedance.sdk.openadsdk.utils.Sn.uQ);
        layoutParams4.addRule(1, com.bytedance.sdk.openadsdk.utils.Sn.uQ);
        ml.setLayoutParams(layoutParams4);
        ml.setGravity(16);
        ml.setOrientation(1);
        sd2.addView(ml);
        this.ZZv = Og(context);
        this.ZZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.mK);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(Vgu.KZx(context, 130.0f), Vgu.KZx(context, 20.0f));
        layoutParams5.leftMargin = iKZx2;
        layoutParams5.setMarginStart(iKZx2);
        this.ZZv.setLayoutParams(layoutParams5);
        ml.addView(this.ZZv);
        this.ML = KZx(context);
        this.ML.setId(com.bytedance.sdk.openadsdk.utils.Sn.guZ);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = iKZx2;
        layoutParams6.setMarginStart(iKZx2);
        this.ML.setLayoutParams(layoutParams6);
        ml.addView(this.ML);
        this.JG = ZZv(context);
        this.JG.setId(com.bytedance.sdk.openadsdk.utils.Sn.jO);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(Vgu.KZx(context, 80.0f), Vgu.KZx(context, 30.0f));
        layoutParams7.addRule(21);
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        layoutParams7.rightMargin = iKZx;
        layoutParams7.setMarginEnd(iKZx);
        this.JG.setLayoutParams(layoutParams7);
        sd2.addView(this.JG);
        View viewOmh = omh(context);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, com.bytedance.sdk.openadsdk.utils.Sn.Uz);
        layoutParams8.leftMargin = iKZx3;
        layoutParams8.bottomMargin = iKZx;
        viewOmh.setLayoutParams(layoutParams8);
        sd.addView(viewOmh);
    }

    @Override // com.bytedance.sdk.openadsdk.Wx.SGo
    protected com.bytedance.sdk.openadsdk.core.ML.omh ZZv(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVarZZv = super.ZZv(context);
        omhVarZZv.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_download_corner_bg"));
        omhVarZZv.setTextSize(2, 14.0f);
        return omhVarZZv;
    }

    @Override // com.bytedance.sdk.openadsdk.Wx.SGo
    protected com.bytedance.sdk.openadsdk.core.ML.omh Og(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        omhVar.setGravity(16);
        omhVar.setMaxWidth(Vgu.KZx(context, 153.0f));
        omhVar.setSingleLine();
        omhVar.setText("Pangle");
        omhVar.setTextColor(-1);
        omhVar.setTextSize(2, 14.0f);
        return omhVar;
    }

    @Override // com.bytedance.sdk.openadsdk.Wx.SGo
    protected com.bytedance.sdk.openadsdk.core.ML.omh KZx(Context context) {
        com.bytedance.sdk.openadsdk.core.ML.omh omhVarKZx = super.KZx(context);
        omhVarKZx.setGravity(16);
        omhVarKZx.setMaxWidth(Vgu.KZx(context, 153.0f));
        omhVarKZx.setTextColor(-1);
        omhVarKZx.setTextSize(2, 13.0f);
        return omhVarKZx;
    }
}
