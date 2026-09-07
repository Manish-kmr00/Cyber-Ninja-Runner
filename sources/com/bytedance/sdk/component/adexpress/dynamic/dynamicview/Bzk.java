package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes7.dex */
public class Bzk extends JG {
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

    public Bzk(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            this.DX = new ImageView(context);
        } else {
            this.DX = new com.bytedance.sdk.component.adexpress.JG.Bzk(context);
        }
        this.DX.setTag(3);
        addView(this.DX, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.DX);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        super.Bzk();
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            Drawable drawablePA = com.bytedance.sdk.component.adexpress.ZZv.KZx.pA(getContext(), this.WV);
            if (drawablePA != null) {
                this.DX.setBackground(drawablePA);
            }
            int iZZv = com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_close_btn");
            if (iZZv > 0) {
                ((ImageView) this.DX).setImageResource(iZZv);
            }
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        int iPA = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.aBv());
        if (this.DX instanceof com.bytedance.sdk.component.adexpress.JG.Bzk) {
            ((com.bytedance.sdk.component.adexpress.JG.Bzk) this.DX).setRadius((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.DX()));
            ((com.bytedance.sdk.component.adexpress.JG.Bzk) this.DX).setStrokeWidth(iPA);
            ((com.bytedance.sdk.component.adexpress.JG.Bzk) this.DX).setStrokeColor(this.WV.oX());
            ((com.bytedance.sdk.component.adexpress.JG.Bzk) this.DX).setBgColor(this.WV.roi());
            ((com.bytedance.sdk.component.adexpress.JG.Bzk) this.DX).setDislikeColor(this.WV.SD());
            ((com.bytedance.sdk.component.adexpress.JG.Bzk) this.DX).setDislikeWidth((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, 1.0f));
        }
        return true;
    }
}
