package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes5.dex */
public class Bzk extends RelativeLayout {
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

    public Bzk(Context context) {
        super(context);
        pA();
    }

    private void pA() {
        setId(com.bytedance.sdk.openadsdk.utils.Sn.gy);
        setBackgroundColor(-1);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, Vgu.KZx(context, 44.0f)));
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.nCO);
        zZv.setClickable(true);
        zZv.setFocusable(true);
        zZv.setPadding(Vgu.KZx(context, 12.0f), Vgu.KZx(context, 14.0f), Vgu.KZx(context, 12.0f), Vgu.KZx(context, 14.0f));
        zZv.setImageResource(yFO.ZZv(context, "tt_ad_xmark"));
        addView(zZv, new RelativeLayout.LayoutParams(Vgu.KZx(context, 40.0f), Vgu.KZx(context, 44.0f)));
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv2 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv2.setId(com.bytedance.sdk.openadsdk.utils.Sn.Wo);
        zZv2.setPadding(Vgu.KZx(context, 8.0f), Vgu.KZx(context, 10.0f), Vgu.KZx(context, 8.0f), Vgu.KZx(context, 10.0f));
        zZv2.setImageResource(yFO.ZZv(context, "tt_ad_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Vgu.KZx(context, 40.0f), Vgu.KZx(context, 44.0f));
        layoutParams.addRule(11);
        addView(zZv2, layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setId(com.bytedance.sdk.openadsdk.utils.Sn.bU);
        omhVar.setSingleLine(true);
        omhVar.setEllipsize(TextUtils.TruncateAt.END);
        omhVar.setGravity(17);
        omhVar.setTextColor(Color.parseColor("#222222"));
        omhVar.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(Vgu.KZx(context, 191.0f), Vgu.KZx(context, 24.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, com.bytedance.sdk.openadsdk.utils.Sn.Wo);
        layoutParams2.addRule(1, com.bytedance.sdk.openadsdk.utils.Sn.nCO);
        int iKZx = Vgu.KZx(context, 10.0f);
        layoutParams2.leftMargin = iKZx;
        layoutParams2.rightMargin = iKZx;
        addView(omhVar, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ML.JG jg = new com.bytedance.sdk.openadsdk.core.ML.JG(context, null, R.style.Widget.ProgressBar.Horizontal);
        jg.setId(com.bytedance.sdk.openadsdk.utils.Sn.Itl);
        jg.setProgress(1);
        jg.setProgressDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_privacy_progress_style"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, Vgu.KZx(context, 2.0f));
        layoutParams3.addRule(12);
        addView(jg, layoutParams3);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, Vgu.KZx(context, 0.5f));
        layoutParams4.addRule(12);
        addView(view, layoutParams4);
    }
}
