package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class TX extends SD implements com.bytedance.sdk.component.adexpress.dynamic.KZx {
    private int Og;
    private int[] pA;
    private int vZF;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SD, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public TX(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SD, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        super.Bzk();
        ((TextView) this.DX).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    public void JG() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.SD, this.omh);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SD, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.DX).getText())) {
            setMeasuredDimension(0, this.omh);
        } else {
            setMeasuredDimension(this.SD, this.omh);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx
    public void pA(CharSequence charSequence, boolean z, int i, boolean z2) {
        String strPA = com.bytedance.sdk.component.utils.yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_screen_skip_tx");
        if (i == 0) {
            this.DX.setVisibility(0);
            ((TextView) this.DX).setText("| ".concat(String.valueOf(strPA)));
            this.DX.measure(-2, -2);
            this.pA = new int[]{this.DX.getMeasuredWidth() + 1, this.DX.getMeasuredHeight()};
            View view = this.DX;
            int[] iArr = this.pA;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.DX).setGravity(17);
            ((TextView) this.DX).setIncludeFontPadding(false);
            pA();
            this.DX.setPadding(this.WV.KZx(), this.Og, this.WV.ZZv(), this.vZF);
        }
        requestLayout();
    }

    private void pA() {
        int iPA = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.ML());
        this.Og = ((this.omh - iPA) / 2) - this.WV.pA();
        this.vZF = 0;
    }
}
