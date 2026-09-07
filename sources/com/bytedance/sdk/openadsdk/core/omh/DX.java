package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class DX extends com.bytedance.sdk.openadsdk.core.Wx.Og.JG implements View.OnClickListener {
    private boolean oX;

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/omh/DX;->onClick(Landroid/view/View;)V");
        CreativeInfoManager.onViewClicked(h.u, view);
        safedk_DX_onClick_61c021a9811b5859f6356fcb123dac80(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG, com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG
    protected void pA(boolean z) {
    }

    public DX(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str, com.bytedance.sdk.openadsdk.ZZv.SD sd) {
        super(context, yfo, false, str, false, false, sd);
        this.oX = false;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG
    protected void Og() {
        if (!this.ML || !WQf.Og(this.WV)) {
            this.ZZv = false;
        }
        super.Og();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG
    protected void KZx() {
        if (this.oX) {
            super.KZx();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.oX = z;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.Og != null) {
            this.Og.ML(z);
        }
    }

    public void ZZv() {
        if (this.SGo != null) {
            Vgu.pA((View) this.SGo, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (this.Bzk != null && this.Bzk.getVisibility() == 0) {
            XT();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.Bzk != null && this.Bzk.getVisibility() == 0) {
            XT();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void aBv() {
        Vgu.pA((View) this.SD, 0);
        Vgu.pA((View) this.omh, 0);
        Vgu.pA((View) this.SGo, 8);
    }

    private void XT() {
        SD();
        if (this.SD != null) {
            if (this.SD.getVisibility() == 0) {
                return;
            } else {
                com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(this.pA.Bf().SGo(), this.pA.Bf().KZx(), this.pA.Bf().Og(), this.omh, this.pA);
            }
        }
        aBv();
    }

    public void safedk_DX_onClick_61c021a9811b5859f6356fcb123dac80(View p0) {
        View p1 = this.Bzk;
        if (p1 != null && this.Bzk.getVisibility() == 0) {
            View p2 = this.SD;
            Vgu.ML(p2);
        }
        KZx();
    }

    public void setShowAdInteractionView(boolean z) {
        com.bykv.vk.openvk.pA.pA.pA.ZZv.Og ogWx;
        if (this.Og == null || (ogWx = this.Og.Wx()) == null) {
            return;
        }
        ogWx.pA(z);
    }

    protected void ML() {
        SD();
        Vgu.pA((View) this.SD, 0);
    }
}
