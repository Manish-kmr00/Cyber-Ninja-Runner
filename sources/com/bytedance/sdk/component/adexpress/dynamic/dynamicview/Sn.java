package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class Sn extends JG {
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

    public Sn(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.DX = new ImageView(context);
        this.DX.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            this.omh = Math.max(dynamicRootView.getLogoUnionHeight(), this.omh);
        }
        addView(this.DX, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        super.Bzk();
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        ((ImageView) this.DX).setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_ad_logo"));
        ((ImageView) this.DX).setColorFilter(this.WV.SD(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
