package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class Wx extends JG {
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

    public Wx(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.DX = new TextView(context);
        this.DX.setTag(Integer.valueOf(getClickArea()));
        addView(this.DX, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        super.Bzk();
        this.DX.setTextAlignment(this.WV.omh());
        ((TextView) this.DX).setTextColor(this.WV.SD());
        ((TextView) this.DX).setTextSize(this.WV.ML());
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            ((TextView) this.DX).setIncludeFontPadding(false);
            ((TextView) this.DX).setTextSize(Math.min(((com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.omh) - this.WV.Og()) - this.WV.pA()) - 0.5f, this.WV.ML()));
            ((TextView) this.DX).setText(com.bytedance.sdk.component.utils.yFO.pA(getContext(), "tt_logo_en"));
            return true;
        }
        if (pA()) {
            if (com.bytedance.sdk.component.adexpress.dynamic.ML.BSW.Og()) {
                ((TextView) this.DX).setText(com.bytedance.sdk.component.adexpress.dynamic.ML.BSW.pA());
                return true;
            }
            ((TextView) this.DX).setText(com.bytedance.sdk.component.adexpress.dynamic.ML.BSW.pA(this.WV.Og));
            return true;
        }
        ((TextView) this.DX).setText(com.bytedance.sdk.component.utils.yFO.Og(getContext(), "tt_logo_cn"));
        return true;
    }

    private boolean pA() {
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.WV.Og) && this.WV.Og.contains("adx:")) || com.bytedance.sdk.component.adexpress.dynamic.ML.BSW.Og();
    }
}
