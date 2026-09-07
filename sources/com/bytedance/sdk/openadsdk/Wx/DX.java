package com.bytedance.sdk.openadsdk.Wx;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class DX extends com.bytedance.sdk.openadsdk.core.ML.SD {
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

    public DX(Context context) {
        this(context, null);
    }

    public DX(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DX(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        pA(context);
    }

    private void pA(Context context) {
        setId(com.bytedance.sdk.openadsdk.utils.Sn.kK);
        setBackgroundColor(Color.parseColor("#00000000"));
        setGravity(16);
        setVisibility(8);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setId(com.bytedance.sdk.openadsdk.utils.Sn.EC);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        omhVar.setLayoutParams(layoutParams);
        omhVar.setIncludeFontPadding(false);
        omhVar.setText(yFO.pA(context, "tt_video_without_wifi_tips"));
        omhVar.setTextColor(Color.parseColor("#cacaca"));
        omhVar.setTextSize(2, 14.0f);
        addView(omhVar);
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        sd.setId(com.bytedance.sdk.openadsdk.utils.Sn.LhC);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, com.bytedance.sdk.openadsdk.utils.Sn.EC);
        layoutParams2.addRule(13);
        sd.setLayoutParams(layoutParams2);
        addView(sd);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.juv);
        int iKZx = Vgu.KZx(context, 44.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iKZx, iKZx);
        layoutParams3.addRule(15);
        zZv.setLayoutParams(layoutParams3);
        zZv.setImageDrawable(yFO.KZx(context, "tt_new_play_video"));
        zZv.setScaleType(ImageView.ScaleType.FIT_XY);
        sd.addView(zZv);
    }
}
