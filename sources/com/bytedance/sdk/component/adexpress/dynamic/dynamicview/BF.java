package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BF extends JG implements com.bytedance.sdk.component.adexpress.dynamic.KZx {
    private int Og;
    private int pA;
    private int vZF;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public BF(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        pA();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.KZx()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.Og()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.ZZv()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.pA()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    public void JG() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.Bzk;
        layoutParams.topMargin = this.SGo;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.vZF == 0) {
            setMeasuredDimension(this.Og, this.omh);
        } else {
            setMeasuredDimension(this.pA, this.omh);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx
    public void pA(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.vZF = i;
    }

    private void pA() {
        List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> listBSW = this.Wx.BSW();
        if (listBSW == null || listBSW.size() <= 0) {
            return;
        }
        for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar : listBSW) {
            if (omhVar.SGo().pA() == 21) {
                this.pA = (int) (this.SD - com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, omhVar.omh()));
            }
            if (omhVar.SGo().pA() == 20) {
                this.Og = (int) (this.SD - com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, omhVar.omh()));
            }
        }
    }
}
