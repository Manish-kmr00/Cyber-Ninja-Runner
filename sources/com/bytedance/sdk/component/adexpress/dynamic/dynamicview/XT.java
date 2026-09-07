package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class XT extends JG {
    public Og pA;

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

    public XT(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        return super.Bzk();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    protected Og pA(Bitmap bitmap) {
        pA pAVar = new pA(bitmap, this.pA);
        this.pA = pAVar;
        return pAVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    protected GradientDrawable getDrawable() {
        Og og = new Og();
        this.pA = og;
        return og;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    protected GradientDrawable pA(GradientDrawable.Orientation orientation, int[] iArr) {
        Og og = new Og(orientation, iArr);
        this.pA = og;
        return og;
    }
}
