package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class oX extends pA {
    private FrameLayout Sn;
    private yFO Wx;
    private FrameLayout pA;

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA, com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public oX(Context context) {
        super(context);
        this.Og = context;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, yFO yfo2, ViewGroup viewGroup) {
        if (yfo == null) {
            return;
        }
        setBackgroundColor(-1);
        this.KZx = yfo;
        this.Wx = yfo2;
        if (yfo.PKZ() == 7) {
            this.JG = "rewarded_video";
        } else {
            this.JG = "fullscreen_interstitial_ad";
        }
        Og();
        if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(yfo)) {
            this.Wx.addView(this, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.Wx.addView(this, new ViewGroup.LayoutParams(-2, -2));
        }
        View viewFindViewById = viewGroup.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.ZDE);
        if (viewFindViewById != null) {
            Object tag = viewFindViewById.getTag(com.bytedance.sdk.openadsdk.utils.Sn.ZDE);
            if (tag instanceof String) {
                String str = (String) tag;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.aBv.KZx.pA().pA(str, viewFindViewById);
            }
        }
    }

    private void Og() {
        this.SD = Vgu.KZx(this.Og, this.Wx.getExpectExpressWidth());
        this.omh = Vgu.KZx(this.Og, this.Wx.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.SD, this.omh);
        }
        layoutParams.width = this.SD;
        layoutParams.height = this.omh;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.KZx.IG();
        KZx();
    }

    private void KZx() {
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx = new com.bytedance.sdk.openadsdk.core.ML.KZx(this.Og);
        this.pA = kZx;
        addView(kZx, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ML.KZx kZx2 = new com.bytedance.sdk.openadsdk.core.ML.KZx(this.Og);
        this.Sn = kZx2;
        this.pA.addView(kZx2, new FrameLayout.LayoutParams(-1, -1));
        this.Sn.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.Sn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.pA
    protected void pA(View view, int i, com.bytedance.sdk.openadsdk.core.model.Sn sn) {
        yFO yfo = this.Wx;
        if (yfo != null) {
            yfo.pA(view, i, sn);
        }
    }

    public View getBackupContainerBackgroundView() {
        return this.pA;
    }
}
