package com.bytedance.sdk.openadsdk.component.Bzk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.oX;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class ML extends KZx {
    pA Wx;

    public interface pA {
        void pA(View view, int i);
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx, com.bytedance.sdk.openadsdk.core.ML.SD, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public com.bytedance.sdk.openadsdk.core.ML.ZZv getAdIconView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public com.bytedance.sdk.openadsdk.core.ML.omh getAdTitleTextView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public oX getScoreBar() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx
    public View getUserInfo() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Bzk.KZx, com.bytedance.sdk.openadsdk.core.ML.SD, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public ML(Context context, yFO yfo) {
        super(context);
        pA(context, yfo);
    }

    private void pA(Context context, yFO yfo) {
        com.bytedance.sdk.openadsdk.core.omh.ML ml = new com.bytedance.sdk.openadsdk.core.omh.ML(context);
        com.bytedance.sdk.openadsdk.core.omh.ZZv.pA().KZx(ml);
        ml.pA(yfo, new com.bytedance.sdk.openadsdk.core.omh.ML.Og() { // from class: com.bytedance.sdk.openadsdk.component.Bzk.ML.1
            @Override // com.bytedance.sdk.openadsdk.core.omh.ML.Og
            public void e_() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.ML.Og
            public void pA(int i, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.ML.Og
            public View pA() {
                if (ML.this.omh != null) {
                    return ML.this.omh.getTopDislike();
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.ML.Og
            public View Og() {
                return ML.this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.ML.Og
            public void pA(View view, int i) {
                if (ML.this.Wx != null) {
                    ML.this.Wx.pA(view, i);
                }
            }
        }, "open_ad");
        addView(ml, new ViewGroup.LayoutParams(-1, -1));
        ml.oX();
        int iKZx = Vgu.KZx(context, 9.0f);
        int iKZx2 = Vgu.KZx(context, 10.0f);
        this.ZZv = new PAGLogoView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, Vgu.KZx(context, 14.0f));
        layoutParams.leftMargin = iKZx2;
        layoutParams.bottomMargin = iKZx2;
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        addView(this.ZZv, layoutParams);
        this.WV = new com.bytedance.sdk.openadsdk.core.widget.KZx(context);
        this.WV.setPadding(iKZx, 0, iKZx, 0);
        this.WV.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(Vgu.KZx(context, 32.0f), Vgu.KZx(context, 14.0f));
        layoutParams2.addRule(12);
        layoutParams2.addRule(11);
        layoutParams2.setMargins(0, 0, iKZx2, iKZx2);
        addView(this.WV, layoutParams2);
        if (this.omh != null) {
            addView(this.omh);
        }
    }

    public void setRenderListener(pA pAVar) {
        this.Wx = pAVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Wx = null;
    }
}
