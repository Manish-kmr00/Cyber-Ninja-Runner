package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public class SD extends JG {
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

    public SD(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        super(context, dynamicRootView, omhVar);
        this.DX = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.pA(context);
        this.DX.setTag(Integer.valueOf(getClickArea()));
        addView(this.DX, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (com.bytedance.sdk.component.adexpress.ZZv.Og() && "fillButton".equals(this.Wx.SGo().Og())) {
            ((TextView) this.DX).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) this.DX).setMaxLines(1);
            FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
            widgetLayoutParams.width -= this.WV.XT() * 2;
            widgetLayoutParams.height -= this.WV.XT() * 2;
            widgetLayoutParams.topMargin += this.WV.XT();
            widgetLayoutParams.leftMargin += this.WV.XT();
            widgetLayoutParams.setMarginStart(widgetLayoutParams.leftMargin);
            widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
            return widgetLayoutParams;
        }
        return super.getWidgetLayoutParams();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JG, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qmB
    public boolean Bzk() {
        super.Bzk();
        if (TextUtils.equals("download-progress-button", this.Wx.SGo().Og()) && TextUtils.isEmpty(this.WV.SGo())) {
            this.DX.setVisibility(4);
            return true;
        }
        this.DX.setTextAlignment(this.WV.omh());
        ((TextView) this.DX).setText(this.WV.SGo());
        ((TextView) this.DX).setTextColor(this.WV.SD());
        ((TextView) this.DX).setTextSize(this.WV.ML());
        ((TextView) this.DX).setGravity(17);
        ((TextView) this.DX).setIncludeFontPadding(false);
        if ("fillButton".equals(this.Wx.SGo().Og())) {
            this.DX.setPadding(0, 0, 0, 0);
        } else {
            this.DX.setPadding(this.WV.KZx(), this.WV.Og(), this.WV.ZZv(), this.WV.pA());
        }
        return true;
    }
}
