package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class PAGLogoView extends LinearLayout {
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public PAGLogoView(Context context) {
        this(context, null);
    }

    public PAGLogoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PAGLogoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public PAGLogoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView(context);
    }

    private void initView(Context context) {
        Vgu.KZx(context, 1.0f);
        int iKZx = Vgu.KZx(context, 2.0f);
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Vgu.KZx(context, 14.0f), Vgu.KZx(context, 6.0f));
        layoutParams.leftMargin = iKZx;
        zZv.setLayoutParams(layoutParams);
        zZv.setImageDrawable(com.bytedance.sdk.component.utils.yFO.KZx(context, "tt_ad_logo"));
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = iKZx;
        layoutParams2.rightMargin = iKZx;
        omhVar.setLayoutParams(layoutParams2);
        omhVar.setText(com.bytedance.sdk.component.utils.yFO.pA(context, "tt_logo_en"));
        omhVar.setTextSize(1, 8.0f);
        omhVar.setGravity(17);
        omhVar.setTextColor(Color.parseColor("#BFFFFFFF"));
        addView(zZv);
        addView(omhVar);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(iKZx);
        setBackground(gradientDrawable);
        setGravity(16);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = Vgu.KZx(getContext(), 12.0f);
        super.setLayoutParams(com.bytedance.sdk.openadsdk.core.ML.Bzk.pA(this, layoutParams));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
