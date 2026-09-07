package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class roi extends JG implements com.bytedance.sdk.component.adexpress.dynamic.KZx {
    boolean Og;
    private int Sd;
    private boolean TX;
    int pA;
    private int vZF;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public roi(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.Sd = 0;
        setTag(Integer.valueOf(getClickArea()));
        pA();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().TV()) {
            return;
        }
        if (this.DX != null) {
            this.DX.setVisibility(8);
        }
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    public void JG() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.Og) {
            layoutParams.leftMargin = this.Bzk;
        } else {
            layoutParams.leftMargin = this.Bzk + this.Sd;
        }
        if (this.TX && this.WV != null) {
            layoutParams.leftMargin = ((this.Bzk + this.Sd) - ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.KZx()))) - ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.ZZv()));
        }
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            layoutParams.topMargin = this.SGo - ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.Og()));
        } else {
            layoutParams.topMargin = this.SGo;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        if (com.bytedance.sdk.component.adexpress.ZZv.SD.Og(this.Sn.getRenderRequest().ZZv())) {
            return true;
        }
        super.Bzk();
        setPadding((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.KZx()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.Og()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.ZZv()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.pA()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.TX && this.WV != null) {
            setMeasuredDimension(this.vZF + ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.KZx())) + ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.ZZv())), this.omh);
        } else if (this.Og) {
            setMeasuredDimension(this.SD, this.omh);
        } else {
            setMeasuredDimension(this.pA, this.omh);
        }
    }

    private void pA() {
        List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh> listBSW = this.Wx.BSW();
        if (listBSW == null || listBSW.size() <= 0) {
            return;
        }
        for (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar : listBSW) {
            if (TextUtils.equals("skip-with-time-skip-btn", omhVar.SGo().Og())) {
                this.vZF = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, omhVar.omh() + (com.bytedance.sdk.component.adexpress.ZZv.Og() ? omhVar.Wx() : 0));
                this.pA = this.SD - this.vZF;
                break;
            }
        }
        this.Sd = this.SD - this.pA;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx
    public void pA(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.TX != z2) {
            this.TX = z2;
            JG();
            return;
        }
        if (z && this.Og != z) {
            this.Og = z;
            JG();
        }
        this.Og = z;
    }
}
