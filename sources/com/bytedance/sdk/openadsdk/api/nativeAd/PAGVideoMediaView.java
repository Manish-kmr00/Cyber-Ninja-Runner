package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.Og.pA;
import com.bytedance.sdk.openadsdk.core.Wx.Og.JG;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.KZx;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes6.dex */
public class PAGVideoMediaView extends PAGMediaView implements pA.InterfaceC0231pA {
    private final com.bytedance.sdk.openadsdk.pA.Og.pA KZx;
    private JG Og;
    private yFO ZZv;

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public PAGVideoMediaView(Context context, View view, com.bytedance.sdk.openadsdk.pA.Og.pA pAVar) {
        super(context);
        pA(view);
        this.KZx = pAVar;
    }

    private void pA(View view) {
        if (view instanceof JG) {
            JG jg = (JG) view;
            this.Og = jg;
            addView(jg, -1, -1);
        }
    }

    private void pA() {
        JG jg = this.Og;
        if (jg != null) {
            jg.Sn();
        }
    }

    private boolean Og() {
        JG jg = this.Og;
        if (jg != null) {
            return jg.WV();
        }
        return false;
    }

    public void handleInterruptVideo() {
        if (Og()) {
            return;
        }
        pA();
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
    public void setVideoAdListener(final PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.pA.Og.pA pAVar = this.KZx;
        if (pAVar == null) {
            return;
        }
        pAVar.pA(new PAGVideoAdListener() { // from class: com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView.1
            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdPlay() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdPaused() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdComplete() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdComplete();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoError() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoError();
                }
            }
        });
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (onClickListener instanceof pA) {
            ((pA) onClickListener).pA((pA.InterfaceC0231pA) this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
    public void close() {
        JG jg = this.Og;
        if (jg != null) {
            jg.DX();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.pA.InterfaceC0231pA
    public long getVideoProgress() {
        JG jg = this.Og;
        if (jg == null || jg.getNativeVideoController() == null) {
            return 0L;
        }
        return this.Og.getNativeVideoController().ML();
    }

    public void setMaterialMeta(yFO yfo) {
        this.ZZv = yfo;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        KZx.pA(this, this.ZZv);
    }
}
