package com.bytedance.sdk.openadsdk.component.Bzk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes10.dex */
public class SD extends com.bytedance.sdk.openadsdk.core.ML.SD {
    private final com.bytedance.sdk.openadsdk.core.ML.ZZv Og;
    private final com.bytedance.sdk.openadsdk.core.ML.ZZv pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.SD, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.SD, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public SD(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        Vgu.KZx(context, 12.0f);
        int iKZx = Vgu.KZx(context, 16.0f);
        int iKZx2 = Vgu.KZx(context, 20.0f);
        Vgu.KZx(context, 24.0f);
        int iKZx3 = Vgu.KZx(context, 28.0f);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        this.pA = zZv;
        zZv.setId(520093713);
        int iKZx4 = Vgu.KZx(getContext(), 5.0f);
        zZv.setPadding(iKZx4, iKZx4, iKZx4, iKZx4);
        zZv.setScaleType(ImageView.ScaleType.CENTER);
        zZv.setBackground(com.bytedance.sdk.openadsdk.core.widget.ZZv.pA());
        zZv.setImageResource(yFO.ZZv(aBv.pA(), "tt_reward_full_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iKZx3, iKZx3);
        layoutParams.topMargin = iKZx2;
        layoutParams.leftMargin = iKZx;
        layoutParams.setMarginStart(iKZx);
        zZv.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv2 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        this.Og = zZv2;
        zZv2.setId(520093714);
        zZv2.setPadding(iKZx4, iKZx4, iKZx4, iKZx4);
        zZv2.setScaleType(ImageView.ScaleType.CENTER);
        zZv2.setBackground(com.bytedance.sdk.openadsdk.core.widget.ZZv.pA());
        zZv2.setImageResource(yFO.ZZv(aBv.pA(), "tt_close_btn"));
        if (zZv2.getDrawable() != null) {
            zZv2.getDrawable().setAutoMirrored(true);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iKZx3, iKZx3);
        layoutParams2.topMargin = iKZx2;
        layoutParams2.rightMargin = iKZx;
        layoutParams2.setMarginEnd(iKZx);
        layoutParams2.addRule(11);
        layoutParams2.addRule(21);
        zZv2.setLayoutParams(layoutParams2);
        addView(zZv);
        addView(zZv2);
    }

    public View getTopDislike() {
        return this.pA;
    }

    public com.bytedance.sdk.openadsdk.core.ML.ZZv getTopSkip() {
        return this.Og;
    }
}
