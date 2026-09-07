package com.bytedance.sdk.openadsdk.Wx;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class ML extends SGo {
    private com.bytedance.sdk.openadsdk.core.ML.ZZv SD;
    private com.bytedance.sdk.openadsdk.core.ML.omh omh;

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

    public ML(Context context) {
        this(context, null);
    }

    public ML(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ML(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.Wx.SGo
    protected void pA(Context context) {
        int iKZx = Vgu.KZx(context, 6.0f);
        setPadding(iKZx, iKZx, iKZx, iKZx);
        this.pA = ML(context);
        this.pA.setId(com.bytedance.sdk.openadsdk.utils.Sn.rjD);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int iKZx2 = Vgu.KZx(context, 26.0f);
        layoutParams.topMargin = iKZx2;
        this.pA.setLayoutParams(layoutParams);
        addView(this.pA);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        this.SD = zZv;
        zZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.dGZ);
        this.SD.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = iKZx2;
        this.SD.setLayoutParams(layoutParams2);
        addView(this.SD);
        PAGLogoView pAGLogoViewOmh = omh(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        int iKZx3 = Vgu.KZx(context, 10.0f);
        layoutParams3.leftMargin = iKZx3;
        layoutParams3.topMargin = iKZx3;
        layoutParams3.bottomMargin = iKZx3;
        pAGLogoViewOmh.setLayoutParams(layoutParams3);
        addView(pAGLogoViewOmh);
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        ml.setOrientation(0);
        ml.setGravity(17);
        addView(ml);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        this.omh = omhVar;
        omhVar.setId(com.bytedance.sdk.openadsdk.utils.Sn.qQU);
        this.omh.setEllipsize(TextUtils.TruncateAt.END);
        this.omh.setMaxLines(1);
        this.omh.setTextColor(-1);
        this.omh.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        this.omh.setLayoutParams(layoutParams4);
        ml.addView(this.omh);
    }

    public com.bytedance.sdk.openadsdk.core.ML.ZZv getTtBuImg() {
        return this.SD;
    }

    public com.bytedance.sdk.openadsdk.core.ML.omh getTtBuDescTV() {
        return this.omh;
    }
}
