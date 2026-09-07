package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class TV extends JG {
    private int pA;

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

    public TV(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.pA = 0;
        this.DX = new com.bytedance.sdk.component.adexpress.JG.TV(context, null);
        this.DX.setTag(Integer.valueOf(getClickArea()));
        addView(this.DX, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iPA = (int) ((com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.ML()) * 5.0f) + com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.KZx() + com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.ZZv())));
        if (this.SD > iPA && 4 == this.WV.omh()) {
            this.pA = (this.SD - iPA) / 2;
        }
        this.SD = iPA;
        return new FrameLayout.LayoutParams(this.SD, this.omh);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    public void JG() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.SD, this.omh);
        layoutParams.topMargin = this.SGo;
        layoutParams.leftMargin = this.Bzk + this.pA;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        super.Bzk();
        double dWx = this.WV.Wx();
        if (com.bytedance.sdk.component.adexpress.ZZv.Og() && (dWx < 0.0d || dWx > 5.0d || (this.Sn != null && this.Sn.getRenderRequest() != null && this.Sn.getRenderRequest().SGo() != 4))) {
            this.DX.setVisibility(8);
            return true;
        }
        double d = (dWx < 0.0d || dWx > 5.0d) ? 5.0d : dWx;
        this.DX.setVisibility(0);
        ((com.bytedance.sdk.component.adexpress.JG.TV) this.DX).pA(d, this.WV.SD(), (int) this.WV.ML(), ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.Og())) + ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.pA())) + ((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.ML())));
        return true;
    }
}
