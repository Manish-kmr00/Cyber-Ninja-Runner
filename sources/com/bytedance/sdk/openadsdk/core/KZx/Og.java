package com.bytedance.sdk.openadsdk.core.KZx;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.omh.XT;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes9.dex */
public class Og extends KZx {
    @Override // com.bytedance.sdk.openadsdk.core.KZx.KZx, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.KZx.KZx, com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public Og(Context context, yFO yfo, AdSlot adSlot) {
        super(context, yfo, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.KZx.KZx
    protected void pA() {
        this.Og = new XT(this.pA, this.KZx, this.ZZv, this.JG);
        addView(this.Og, new ViewGroup.LayoutParams(-1, -1));
        if (this.ML != null) {
            setExpressInteractionListener(this.ML);
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.Og.pA getVideoModel() {
        if (this.Og != null) {
            return ((XT) this.Og).getVideoModel();
        }
        return null;
    }
}
