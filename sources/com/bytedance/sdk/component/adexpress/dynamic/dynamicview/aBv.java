package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class aBv extends JG {
    private LinearLayout BF;
    private TextView Og;
    private TextView Sd;
    private TextView TX;
    private TextView pA;
    private TextView vZF;

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

    public aBv(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.pA = new TextView(this.BSW);
        this.Og = new TextView(this.BSW);
        this.vZF = new TextView(this.BSW);
        this.BF = new LinearLayout(this.BSW);
        this.Sd = new TextView(this.BSW);
        this.TX = new TextView(this.BSW);
        this.pA.setTag(9);
        this.Og.setTag(10);
        this.vZF.setTag(12);
        this.BF.addView(this.vZF);
        this.BF.addView(this.TX);
        this.BF.addView(this.Og);
        this.BF.addView(this.Sd);
        this.BF.addView(this.pA);
        addView(this.BF, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    protected boolean ZZv() {
        this.pA.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.pA.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.Og.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.Og.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.vZF.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.vZF.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.SD, this.omh);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        this.vZF.setText("Function");
        this.Og.setText("Permission list");
        this.Sd.setText(" | ");
        this.TX.setText(" | ");
        this.pA.setText("Privacy policy");
        if (this.WV != null) {
            this.vZF.setTextColor(this.WV.SD());
            this.vZF.setTextSize(this.WV.ML());
            this.Og.setTextColor(this.WV.SD());
            this.Og.setTextSize(this.WV.ML());
            this.Sd.setTextColor(this.WV.SD());
            this.TX.setTextColor(this.WV.SD());
            this.pA.setTextColor(this.WV.SD());
            this.pA.setTextSize(this.WV.ML());
            return false;
        }
        this.vZF.setTextColor(-1);
        this.vZF.setTextSize(12.0f);
        this.Og.setTextColor(-1);
        this.Og.setTextSize(12.0f);
        this.Sd.setTextColor(-1);
        this.TX.setTextColor(-1);
        this.pA.setTextColor(-1);
        this.pA.setTextSize(12.0f);
        return false;
    }
}
