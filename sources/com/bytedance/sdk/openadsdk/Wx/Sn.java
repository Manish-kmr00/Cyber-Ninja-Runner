package com.bytedance.sdk.openadsdk.Wx;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class Sn extends com.bytedance.sdk.openadsdk.core.ML.SD {
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

    public Sn(Context context) {
        this(context, null);
    }

    public Sn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Sn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        pA(context);
    }

    private void pA(Context context) {
        setBackgroundColor(Color.parseColor("#000000"));
        setId(520093726);
        int iKZx = Vgu.KZx(context, 60.0f);
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(context);
        kZx.setId(com.bytedance.sdk.openadsdk.utils.Sn.ka);
        kZx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        kZx.setBackgroundColor(0);
        addView(kZx);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.uhO);
        zZv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        zZv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        kZx.addView(zZv);
        com.bytedance.sdk.openadsdk.core.ML.JG jg = new com.bytedance.sdk.openadsdk.core.ML.JG(context);
        jg.setId(com.bytedance.sdk.openadsdk.utils.Sn.bA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iKZx, iKZx);
        layoutParams.gravity = 17;
        jg.setLayoutParams(layoutParams);
        jg.setIndeterminateDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_video_loading_progress_bar"));
        kZx.addView(jg);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv2 = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv2.setId(com.bytedance.sdk.openadsdk.utils.Sn.lgT);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        zZv2.setLayoutParams(layoutParams2);
        zZv2.setScaleType(ImageView.ScaleType.CENTER);
        zZv2.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_play_movebar_textpage"));
        zZv2.setVisibility(8);
        addView(zZv2);
        WV wv = new WV(context);
        wv.setId(com.bytedance.sdk.openadsdk.utils.Sn.Xj);
        wv.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(wv);
    }
}
