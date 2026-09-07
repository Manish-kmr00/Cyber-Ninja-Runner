package com.bytedance.sdk.openadsdk.Wx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class WV extends com.bytedance.sdk.openadsdk.core.ML.SD {
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

    public WV(Context context) {
        this(context, null);
    }

    public WV(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WV(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        pA(context);
    }

    private void pA(Context context) {
        setId(com.bytedance.sdk.openadsdk.utils.Sn.Xj);
        setVisibility(8);
        setBackgroundColor(Color.parseColor("#7f000000"));
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(getContext());
        zZv.setId(com.bytedance.sdk.openadsdk.utils.Sn.PU);
        zZv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        zZv.setImageTintMode(PorterDuff.Mode.SRC_OVER);
        zZv.setImageTintList(ColorStateList.valueOf(Color.parseColor("#7f000000")));
        zZv.setBackgroundColor(Color.parseColor("#7f000000"));
        zZv.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(zZv);
        com.bytedance.sdk.openadsdk.core.ML.SD sd = new com.bytedance.sdk.openadsdk.core.ML.SD(context);
        sd.setId(com.bytedance.sdk.openadsdk.utils.Sn.vkV);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        sd.setLayoutParams(layoutParams);
        addView(sd);
        int iKZx = Vgu.KZx(context, 44.0f);
        com.bytedance.sdk.openadsdk.core.widget.pA pAVar = new com.bytedance.sdk.openadsdk.core.widget.pA(context);
        pAVar.setId(com.bytedance.sdk.openadsdk.utils.Sn.FQ);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iKZx, iKZx);
        layoutParams2.addRule(14);
        pAVar.setLayoutParams(layoutParams2);
        pAVar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        sd.addView(pAVar);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar.setId(com.bytedance.sdk.openadsdk.utils.Sn.Gx);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iKZx, iKZx);
        layoutParams3.addRule(8, com.bytedance.sdk.openadsdk.utils.Sn.FQ);
        layoutParams3.addRule(19, com.bytedance.sdk.openadsdk.utils.Sn.FQ);
        layoutParams3.addRule(5, com.bytedance.sdk.openadsdk.utils.Sn.FQ);
        layoutParams3.addRule(7, com.bytedance.sdk.openadsdk.utils.Sn.FQ);
        layoutParams3.addRule(18, com.bytedance.sdk.openadsdk.utils.Sn.FQ);
        layoutParams3.addRule(6, com.bytedance.sdk.openadsdk.utils.Sn.FQ);
        layoutParams3.addRule(14);
        omhVar.setLayoutParams(layoutParams3);
        omhVar.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_circle_solid_mian"));
        omhVar.setGravity(17);
        omhVar.setTextColor(-1);
        omhVar.setTextSize(2, 19.0f);
        omhVar.setTypeface(Typeface.defaultFromStyle(1));
        omhVar.setVisibility(8);
        sd.addView(omhVar);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar2 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar2.setId(com.bytedance.sdk.openadsdk.utils.Sn.Bf);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, com.bytedance.sdk.openadsdk.utils.Sn.FQ);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = Vgu.KZx(context, 6.0f);
        omhVar2.setLayoutParams(layoutParams4);
        omhVar2.setEllipsize(TextUtils.TruncateAt.END);
        omhVar2.setMaxLines(1);
        omhVar2.setTextColor(-1);
        omhVar2.setTextSize(2, 12.0f);
        sd.addView(omhVar2);
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar3 = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        omhVar3.setId(com.bytedance.sdk.openadsdk.utils.Sn.HSv);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(Vgu.KZx(context, 100.0f), Vgu.KZx(context, 28.0f));
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, com.bytedance.sdk.openadsdk.utils.Sn.Bf);
        layoutParams5.topMargin = Vgu.KZx(context, 20.0f);
        omhVar3.setLayoutParams(layoutParams5);
        omhVar3.setMinWidth(Vgu.KZx(context, 72.0f));
        omhVar3.setMaxLines(1);
        omhVar3.setEllipsize(TextUtils.TruncateAt.END);
        omhVar3.setTextColor(-1);
        omhVar3.setTextSize(2, 14.0f);
        omhVar3.setBackground(com.bytedance.sdk.openadsdk.utils.Bzk.pA(context, "tt_ad_cover_btn_begin_bg"));
        omhVar3.setGravity(17);
        int iKZx2 = Vgu.KZx(context, 10.0f);
        int iKZx3 = Vgu.KZx(context, 2.0f);
        omhVar3.setPadding(iKZx2, iKZx3, iKZx2, iKZx3);
        omhVar3.setVisibility(8);
        sd.addView(omhVar3);
    }
}
