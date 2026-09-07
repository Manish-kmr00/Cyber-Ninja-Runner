package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class IG extends JG implements com.bytedance.sdk.component.adexpress.dynamic.KZx {
    private boolean pA;

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

    public IG(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.SD = this.omh;
        this.DX = new ImageView(context);
        this.DX.setTag(Integer.valueOf(getClickArea()));
        addView(this.DX, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            if (!dynamicRootView.getRenderRequest().TV()) {
                this.DX.setVisibility(8);
                setVisibility(8);
            }
            this.pA = dynamicRootView.getRenderRequest().Wx();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        Drawable drawableKZx;
        super.Bzk();
        if (this.DX != null) {
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.CENTER_CROP);
            Drawable drawablePA = com.bytedance.sdk.component.adexpress.ZZv.KZx.pA(getContext(), this.WV);
            if (drawablePA != null) {
                ((ImageView) this.DX).setBackground(drawablePA);
            }
            if (this.pA) {
                drawableKZx = com.bytedance.sdk.component.utils.yFO.KZx(getContext(), "tt_close_btn");
            } else {
                drawableKZx = com.bytedance.sdk.component.utils.yFO.KZx(getContext(), "tt_skip_btn");
            }
            if (drawableKZx != null) {
                drawableKZx.setAutoMirrored(true);
                ((ImageView) this.DX).setImageDrawable(drawableKZx);
            }
            int iPA = (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(this.BSW, this.WV.Og());
            this.DX.setPadding(iPA, iPA, iPA, iPA);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx
    public void pA(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
