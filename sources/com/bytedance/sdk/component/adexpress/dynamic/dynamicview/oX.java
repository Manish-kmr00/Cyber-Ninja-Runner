package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class oX extends JG implements com.bytedance.sdk.component.adexpress.dynamic.Og {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    public boolean ML() {
        return true;
    }

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

    public oX(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.DX = new ImageView(context);
        this.DX.setTag(5);
        addView(this.DX, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().TV()) {
            return;
        }
        this.DX.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        super.Bzk();
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.DX).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.Sn.mIsMute);
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            Drawable drawablePA = com.bytedance.sdk.component.adexpress.ZZv.KZx.pA(getContext(), this.WV);
            if (drawablePA == null) {
                return true;
            }
            ((ImageView) this.DX).setBackground(drawablePA);
            return true;
        }
        ((ImageView) this.DX).setBackgroundDrawable(com.bytedance.sdk.component.adexpress.ZZv.Bzk.pA(0, Integer.valueOf(this.WV.roi()), new int[]{this.omh / 2}, null, null, null));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Og
    public void setSoundMute(boolean z) {
        int iZZv;
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            if (z) {
                iZZv = com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_reward_full_mute");
            } else {
                iZZv = com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_reward_full_unmute");
            }
        } else if (z) {
            iZZv = com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_mute");
        } else {
            iZZv = com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_unmute");
        }
        ((ImageView) this.DX).setImageResource(iZZv);
        if (((ImageView) this.DX).getDrawable() != null) {
            ((ImageView) this.DX).getDrawable().setAutoMirrored(true);
        }
    }
}
