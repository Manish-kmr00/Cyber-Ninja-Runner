package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes8.dex */
public class omh extends LinearLayout {
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public omh(Context context) {
        super(context);
        pA();
    }

    private static ImageView pA(Context context, float f, float f2, float f3, float f4) {
        com.bytedance.sdk.openadsdk.core.ML.ZZv zZv = new com.bytedance.sdk.openadsdk.core.ML.ZZv(context);
        zZv.setClickable(true);
        zZv.setFocusable(true);
        zZv.setPadding(Vgu.KZx(context, f3), Vgu.KZx(context, f4), Vgu.KZx(context, f3), Vgu.KZx(context, f4));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Vgu.KZx(context, 40.0f), Vgu.KZx(context, 44.0f));
        if (f > 0.0f) {
            layoutParams.leftMargin = Vgu.KZx(context, f);
        }
        if (f2 > 0.0f) {
            layoutParams.rightMargin = Vgu.KZx(context, f2);
        }
        zZv.setLayoutParams(layoutParams);
        return zZv;
    }

    private void pA() {
        Context context = getContext();
        setId(com.bytedance.sdk.openadsdk.utils.Sn.tM);
        setLayoutParams(new ViewGroup.LayoutParams(-1, Vgu.KZx(context, 44.5f)));
        setBackgroundColor(-1);
        setClickable(true);
        setFocusable(true);
        setOrientation(1);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        addView(view, new LinearLayout.LayoutParams(-1, Vgu.KZx(context, 0.5f)));
        com.bytedance.sdk.openadsdk.core.ML.ML ml = new com.bytedance.sdk.openadsdk.core.ML.ML(context);
        ml.setOrientation(0);
        addView(ml, new LinearLayout.LayoutParams(-1, Vgu.KZx(context, 44.0f)));
        ImageView imageViewPA = pA(context, 16.0f, 0.0f, 14.75f, 12.5f);
        imageViewPA.setId(com.bytedance.sdk.openadsdk.utils.Sn.RS);
        imageViewPA.setImageResource(yFO.ZZv(context, "tt_ad_arrow_backward"));
        ml.addView(imageViewPA);
        View view2 = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        ml.addView(view2, layoutParams);
        ImageView imageViewPA2 = pA(context, 8.0f, 0.0f, 14.75f, 12.5f);
        imageViewPA2.setId(com.bytedance.sdk.openadsdk.utils.Sn.QI);
        imageViewPA2.setImageResource(yFO.ZZv(context, "tt_ad_arrow_forward"));
        ml.addView(imageViewPA2);
        View view3 = new View(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 0);
        layoutParams2.weight = 1.0f;
        ml.addView(view3, layoutParams2);
        ImageView imageViewPA3 = pA(context, 8.0f, 0.0f, 10.0f, 12.0f);
        imageViewPA3.setId(com.bytedance.sdk.openadsdk.utils.Sn.Gag);
        imageViewPA3.setImageResource(yFO.ZZv(context, "tt_ad_refresh"));
        ml.addView(imageViewPA3);
        View view4 = new View(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        ml.addView(view4, layoutParams3);
        ImageView imageViewPA4 = pA(context, 0.0f, 16.0f, 9.0f, 11.0f);
        imageViewPA4.setId(com.bytedance.sdk.openadsdk.utils.Sn.Qj);
        imageViewPA4.setImageResource(yFO.ZZv(context, "tt_ad_link"));
        ml.addView(imageViewPA4);
    }
}
