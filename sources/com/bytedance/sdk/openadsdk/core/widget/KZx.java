package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class KZx extends com.bytedance.sdk.openadsdk.core.ML.ZZv {
    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public KZx(Context context) {
        super(context);
        pA();
    }

    private void pA() {
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.Sn.Ij);
    }

    public void pA(int i, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (yfo.rjD() || (yfo.qQU() && yfo.omh())) {
            Vgu.pA((View) this, 0);
            com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA((int) Vgu.pA(getContext(), i, true), this, yfo);
        }
    }
}
