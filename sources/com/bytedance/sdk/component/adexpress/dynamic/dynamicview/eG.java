package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class eG extends SD implements com.bytedance.sdk.component.adexpress.dynamic.KZx {
    private boolean Og;
    private boolean pA;
    private boolean vZF;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SD, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public eG(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(omhVar.SGo().Og())) {
            dynamicRootView.setTimedown(this.omh);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SD, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        super.Bzk();
        if (com.bytedance.sdk.component.adexpress.ZZv.SD.Og(this.Sn.getRenderRequest().ZZv())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.Wx.SGo().Og())) {
            ((TextView) this.DX).setText(String.valueOf((int) Double.parseDouble(this.WV.SGo())));
            return true;
        }
        ((TextView) this.DX).setText(((int) Double.parseDouble(this.WV.SGo())) + "s");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML
    public void JG() {
        if (TextUtils.equals("skip-with-countdowns-video-countdown", this.Wx.SGo().Og()) || TextUtils.equals("skip-with-time-countdown", this.Wx.SGo().Og())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.SD, this.omh);
            layoutParams.gravity = 8388627;
            if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                layoutParams.leftMargin = this.Bzk;
            }
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            setLayoutParams(layoutParams);
            return;
        }
        super.JG();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SD, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ML, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.DX).getText())) {
            setMeasuredDimension(0, this.omh);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.KZx
    public void pA(CharSequence charSequence, boolean z, int i, boolean z2) {
        String string = "";
        if (z2 || this.vZF) {
            ((TextView) this.DX).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.Sn.getRenderRequest().pA() && com.bytedance.sdk.component.adexpress.ZZv.SD.Og(this.Sn.getRenderRequest().ZZv())) {
            if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                ((TextView) this.DX).setText(i + "s");
            } else {
                ((TextView) this.DX).setText(String.format(com.bytedance.sdk.component.utils.yFO.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), "tt_reward_full_skip"), Integer.valueOf(i)));
            }
            this.pA = true;
            return;
        }
        if (com.bytedance.sdk.component.adexpress.ZZv.Og() && !"open_ad".equals(this.Sn.getRenderRequest().ZZv()) && this.Sn.getRenderRequest().pA()) {
            this.vZF = true;
            setVisibility(8);
            return;
        }
        if (!"timedown".equals(this.Wx.SGo().Og())) {
            ((TextView) this.DX).setText(((Object) charSequence) + "s");
            this.Og = true;
            if (this.pA) {
                CharSequence text = ((TextView) this.DX).getText();
                if (text != null) {
                    string = text.toString();
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (com.bytedance.sdk.component.adexpress.dynamic.ML.BSW.Og(string, this.WV.ML(), true)[0] + com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA(), this.WV.KZx() + this.WV.ZZv())), this.omh);
                layoutParams.gravity = 8388629;
                this.DX.setLayoutParams(layoutParams);
                this.pA = false;
                requestLayout();
                return;
            }
            return;
        }
        ((TextView) this.DX).setText(charSequence);
    }
}
