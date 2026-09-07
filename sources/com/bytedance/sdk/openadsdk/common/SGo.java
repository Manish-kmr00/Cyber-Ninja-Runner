package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class SGo extends RelativeLayout {
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public SGo(Context context) {
        super(context);
        pA();
    }

    private void pA() {
        Context context = getContext();
        int iKZx = Vgu.KZx(context, 12.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, Vgu.KZx(context, 44.0f)));
        setBackgroundColor(-1);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setId(520093720);
        zZv.setClickable(true);
        zZv.setFocusable(true);
        zZv.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_leftbackicon_selector"));
        int iKZx2 = Vgu.KZx(context, 24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iKZx2, iKZx2);
        layoutParams.leftMargin = iKZx;
        layoutParams.addRule(15);
        addView(zZv, layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv2 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv2.setId(520093716);
        zZv2.setClickable(true);
        zZv2.setFocusable(true);
        zZv2.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_titlebar_close_seletor"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iKZx2, iKZx2);
        layoutParams2.leftMargin = iKZx;
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 520093720);
        addView(zZv2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv3 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv3.setId(com.bytedance.sdk.openadsdk.utils.Sn.tZW);
        zZv3.setImageDrawable(yFO.KZx(context, "tt_ad_feedback_new"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iKZx2, iKZx2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = iKZx;
        addView(zZv3, layoutParams3);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setId(com.bytedance.sdk.openadsdk.utils.Sn.Ld);
        omhVar.setSingleLine(true);
        omhVar.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        omhVar.setGravity(17);
        omhVar.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        omhVar.setTextSize(1, 16.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(Vgu.KZx(context, 240.0f), -2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(1, 520093716);
        layoutParams4.addRule(0, com.bytedance.sdk.openadsdk.utils.Sn.tZW);
        int iKZx3 = Vgu.KZx(context, 25.0f);
        layoutParams4.rightMargin = iKZx3;
        layoutParams4.leftMargin = iKZx3;
        addView(omhVar, layoutParams4);
    }
}
