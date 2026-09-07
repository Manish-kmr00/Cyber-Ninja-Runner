package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class SGo extends JG {
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

    public SGo(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            this.DX = new ImageView(context);
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.SD = this.omh;
        } else {
            this.DX = new TextView(context);
        }
        this.DX.setTag(3);
        addView(this.DX, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.DX);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().omh() && dynamicRootView.getRenderRequest().TV()) {
                return;
            }
            this.DX.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        super.Bzk();
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            Drawable drawablePA = com.bytedance.sdk.component.adexpress.ZZv.KZx.pA(getContext(), this.WV);
            if (drawablePA != null) {
                ((ImageView) this.DX).setBackground(drawablePA);
            }
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int iZZv = com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_reward_full_feedback");
            if (iZZv > 0) {
                ((ImageView) this.DX).setImageResource(iZZv);
            }
            return true;
        }
        ((TextView) this.DX).setText(getText());
        this.DX.setTextAlignment(this.WV.omh());
        ((TextView) this.DX).setTextColor(this.WV.SD());
        ((TextView) this.DX).setTextSize(this.WV.ML());
        this.DX.setBackground(getBackgroundDrawable());
        if (!this.WV.TX()) {
            ((TextView) this.DX).setMaxLines(1);
            ((TextView) this.DX).setGravity(17);
            ((TextView) this.DX).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iBF = this.WV.BF();
            if (iBF > 0) {
                ((TextView) this.DX).setLines(iBF);
                ((TextView) this.DX).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.DX.setPadding((int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.KZx()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.Og()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.ZZv()), (int) com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.pA()));
        ((TextView) this.DX).setGravity(17);
        return true;
    }

    public String getText() {
        return com.bytedance.sdk.component.utils.yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_feedback");
    }
}
