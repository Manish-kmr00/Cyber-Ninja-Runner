package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class vZF extends SD implements com.bytedance.sdk.component.adexpress.dynamic.KZx {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SD, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public vZF(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SD, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SD, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.DX).getText())) {
            setMeasuredDimension(0, this.omh);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    public void JG() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.SD, this.omh);
        layoutParams.leftMargin = this.Bzk;
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx
    public void pA(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (i == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else {
            ((TextView) this.DX).setText(" | " + String.format(com.bytedance.sdk.component.utils.yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_full_skip_count_down"), Integer.valueOf(i)));
        }
        requestLayout();
    }
}
