package com.bytedance.sdk.openadsdk.component.Bzk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.Sn;
import com.bytedance.sdk.openadsdk.core.omh.yFO;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class pA extends com.bytedance.sdk.openadsdk.core.omh.pA {
    private yFO pA;

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA, com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public pA(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA
    protected void pA(View view, int i, Sn sn) {
        yFO yfo = this.pA;
        if (yfo != null) {
            yfo.pA(view, i, sn);
        }
    }

    public void pA(yFO yfo) {
        this.pA = yfo;
        yfo.addView(this, new FrameLayout.LayoutParams(-1, -1));
    }
}
