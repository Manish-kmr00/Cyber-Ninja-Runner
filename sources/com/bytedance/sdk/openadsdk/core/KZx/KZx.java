package com.bytedance.sdk.openadsdk.core.KZx;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes7.dex */
public class KZx extends com.bytedance.sdk.openadsdk.core.ML.KZx {
    protected String JG;
    protected yFO KZx;
    protected PAGBannerAdWrapperListener ML;
    protected com.bytedance.sdk.openadsdk.core.omh.yFO Og;
    protected AdSlot ZZv;
    protected final Context pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public KZx(Context context, yFO yfo, AdSlot adSlot) {
        super(context);
        this.JG = "banner_ad";
        this.pA = context;
        this.KZx = yfo;
        this.ZZv = adSlot;
        pA();
        AdSlot adSlot2 = this.ZZv;
        if (adSlot2 != null) {
            pA(adSlot2.getExpressViewAcceptedWidth(), this.ZZv.getExpressViewAcceptedHeight());
        }
    }

    protected void pA() {
        com.bytedance.sdk.openadsdk.core.omh.yFO yfo = new com.bytedance.sdk.openadsdk.core.omh.yFO(this.pA, this.KZx, this.ZZv, this.JG);
        this.Og = yfo;
        addView(yfo, new ViewGroup.LayoutParams(-1, -1));
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.ML;
        if (pAGBannerAdWrapperListener != null) {
            setExpressInteractionListener(pAGBannerAdWrapperListener);
        }
    }

    public void setExpressInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.ML = pAGBannerAdWrapperListener;
        com.bytedance.sdk.openadsdk.core.omh.yFO yfo = this.Og;
        if (yfo != null) {
            yfo.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.JG() { // from class: com.bytedance.sdk.openadsdk.core.KZx.KZx.1
                @Override // com.bytedance.sdk.openadsdk.core.widget.JG
                public void pA() {
                    KZx.this.ML.onAdClicked();
                }
            });
            this.Og.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.core.KZx.KZx.2
                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdDismissed() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
                public void onAdClicked() {
                    if (KZx.this.KZx == null || !KZx.this.KZx.qQU() || KZx.this.ML == null) {
                        return;
                    }
                    KZx.this.ML.onAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderFail(View view, String str, int i) {
                    if (KZx.this.ML != null) {
                        KZx.this.ML.onRenderFail(KZx.this, str, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderSuccess(View view, float f, float f2) {
                    if (KZx.this.Og != null) {
                        KZx.this.Og.setSoundMute(true);
                    }
                    if (KZx.this.Og != null && !com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(KZx.this.Og.getDynamicShowType())) {
                        KZx.this.pA(f, f2);
                    }
                    if (KZx.this.ML != null) {
                        KZx.this.ML.onRenderSuccess(KZx.this, f, f2);
                    }
                }
            });
        }
    }

    protected void pA(float f, float f2) {
        int iKZx = Vgu.KZx(this.pA, f);
        int iKZx2 = Vgu.KZx(this.pA, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iKZx, iKZx2);
        }
        layoutParams.width = iKZx;
        layoutParams.height = iKZx2;
        setLayoutParams(layoutParams);
    }

    public void Og() {
        com.bytedance.sdk.openadsdk.core.omh.yFO yfo = this.Og;
        if (yfo != null) {
            yfo.Bzk();
        }
    }

    public void KZx() {
        if (this.Og != null) {
            Bzk.Og().JG(this.Og.getClosedListenerKey());
            removeView(this.Og);
            this.Og.BSW();
            this.Og = null;
        }
        Bzk.Og().Sd();
    }

    public com.bytedance.sdk.openadsdk.core.omh.yFO getCurView() {
        return this.Og;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Og == null) {
            pA();
        }
        com.bytedance.sdk.openadsdk.utils.KZx.pA(this, this.KZx);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
