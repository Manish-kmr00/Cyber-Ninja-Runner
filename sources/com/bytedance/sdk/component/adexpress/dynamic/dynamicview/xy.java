package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import com.yandex.div2.PhoneMasks;

/* JADX INFO: loaded from: classes11.dex */
public class xy extends JG implements com.bytedance.sdk.component.adexpress.dynamic.ML {
    FrameLayout Og;
    TextView pA;
    boolean vZF;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    public boolean ML() {
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public xy(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.vZF = false;
        this.DX = new View(context);
        this.DX.setTag(Integer.valueOf(getClickArea()));
        this.pA = new TextView(context);
        this.Og = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.pA.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.pA.setBackground(gradientDrawable);
        this.pA.setTextSize(10.0f);
        this.pA.setGravity(17);
        this.pA.setTextColor(-1);
        this.pA.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            addView(this.Og, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.pA);
        addView(this.DX, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            addView(this.Og, getWidgetLayoutParams());
        }
        dynamicRootView.videoView = this.Og;
        dynamicRootView.setVideoListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        super.Bzk();
        double dML = 0.0d;
        double dZZv = 0.0d;
        for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVarWV = this.Wx; omhVarWV != null; omhVarWV = omhVarWV.WV()) {
            double dJG = dZZv + ((double) omhVarWV.JG());
            double dSD = dML + ((double) omhVarWV.SD());
            dZZv = dJG - ((double) omhVarWV.ZZv());
            dML = dSD - ((double) omhVarWV.ML());
        }
        try {
            float f = (float) dZZv;
            int iPA = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), f);
            int iPA2 = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), f + this.ML);
            if (com.bytedance.sdk.component.adexpress.ZZv.Og.pA(getContext())) {
                XT xt = (XT) this.Sn.getChildAt(0);
                int dynamicWidth = xt.getDynamicWidth();
                int i = dynamicWidth - iPA2;
                iPA2 = dynamicWidth - iPA;
                iPA = i;
            }
            if (!"open_ad".equals(this.Sn.getRenderRequest().ZZv())) {
                XT xt2 = (XT) this.Sn.getChildAt(0);
                float f2 = (float) dML;
                xt2.pA.pA(iPA, (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), f2), iPA2, (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(getContext(), f2 + this.JG));
            } else {
                this.Sn.videoView = this.Og;
            }
        } catch (Exception unused) {
        }
        this.Sn.updateRenderInfoForVideo(dZZv, dML, this.ML, this.JG, this.WV.DX());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ML
    public void setTimeUpdate(int i) {
        String str;
        String str2;
        if (this.Wx.SGo().ML().bA() && i > 0 && !this.vZF) {
            if (i >= 60) {
                str = "0" + (i / 60);
            } else {
                str = PhoneMasks.EXTRA_NUMBERS;
            }
            String str3 = str + ":";
            int i2 = i % 60;
            if (i2 <= 9) {
                str2 = str3 + "0" + i2;
            } else {
                str2 = str3 + i2;
            }
            this.pA.setText(str2);
            this.pA.setVisibility(0);
            return;
        }
        this.vZF = true;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            KZx(getChildAt(i3));
        }
        this.pA.setVisibility(8);
    }

    private void KZx(View view) {
        if (view == this.pA || view == this.yFO) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.pA.JG)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            KZx(viewGroup.getChildAt(i));
            i++;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ML
    public void pA() {
        this.pA.setVisibility(8);
    }
}
