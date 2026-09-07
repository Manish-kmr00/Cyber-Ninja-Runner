package com.bytedance.sdk.openadsdk.component.Bzk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.Og.Sn;
import com.bytedance.sdk.component.adexpress.Og.Wx;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.omh.WQf;
import com.bytedance.sdk.openadsdk.core.omh.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class Og extends yFO {
    private com.bytedance.sdk.openadsdk.component.JG.pA JG;
    private final com.bytedance.sdk.openadsdk.component.JG.Og KZx;
    private com.bytedance.sdk.openadsdk.component.omh.KZx ML;
    private com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA Mc;
    private final com.bytedance.sdk.openadsdk.component.pA Og;
    private FrameLayout SD;
    private final com.bytedance.sdk.openadsdk.component.omh.pA ZZv;
    boolean pA;

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA(int i, String str) {
    }

    public Og(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, AdSlot adSlot, String str, com.bytedance.sdk.openadsdk.component.pA pAVar, com.bytedance.sdk.openadsdk.component.JG.Og og, com.bytedance.sdk.openadsdk.component.omh.pA pAVar2) {
        super(context, yfo, adSlot, str, true, true);
        this.pA = true;
        this.Og = pAVar;
        this.KZx = og;
        this.ZZv = pAVar2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO
    protected void JG() {
        this.Sn = true;
        this.SD = new FrameLayout(this.omh);
        if (!com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(this.BSW) && !com.bytedance.sdk.openadsdk.core.BSW.KZx.Og(this.BSW)) {
            addView(this.SD, new FrameLayout.LayoutParams(-1, -1));
        }
        super.JG();
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO
    public int getDynamicShowType() {
        if (this.roi == null) {
            return 1;
        }
        return super.getDynamicShowType();
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.component.adexpress.Og.DX
    public void pA(com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv, Sn sn) {
        this.roi = zZv;
        if (zZv instanceof WQf) {
            WQf wQf = (WQf) zZv;
            if (wQf.oX() != null) {
                wQf.oX().pA((com.bytedance.sdk.openadsdk.core.omh.Sn) this);
            }
        }
        if (sn != null && sn.KZx()) {
            Og(sn);
        }
        super.pA(zZv, sn);
    }

    public void Og(final Sn sn) {
        if (sn == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.Bzk.Og.1
            @Override // java.lang.Runnable
            public void run() {
                Og.this.KZx(sn);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx(Sn sn) {
        if (sn == null) {
            return;
        }
        if (sn.pA() != null) {
            if (this.pA) {
                sn.pA().setTag(com.bytedance.sdk.component.adexpress.dynamic.pA.JG, 1);
                ((FrameLayout) sn.pA()).removeAllViews();
                FrameLayout frameLayout = (FrameLayout) sn.pA();
                this.SD = frameLayout;
                ((FrameLayout.LayoutParams) frameLayout.getLayoutParams()).gravity = 17;
                this.pA = false;
                return;
            }
            return;
        }
        double dJG = sn.JG();
        double dSD = sn.SD();
        double dOmh = sn.omh();
        double dBzk = sn.Bzk();
        int iKZx = Vgu.KZx(this.omh, (float) dJG);
        int iKZx2 = Vgu.KZx(this.omh, (float) dSD);
        int iKZx3 = Vgu.KZx(this.omh, (float) dOmh);
        int iKZx4 = Vgu.KZx(this.omh, (float) dBzk);
        if ((dBzk != 0.0d && dOmh != 0.0d) || this.roi.KZx() == 7 || this.roi.KZx() == 10) {
            if ((this.roi.KZx() == 7 || this.roi.KZx() == 10) && (sn instanceof com.bytedance.sdk.openadsdk.core.BSW.ZZv.Og)) {
                FrameLayout frameLayoutOX = ((com.bytedance.sdk.openadsdk.core.BSW.ZZv.Og) sn).oX();
                if (frameLayoutOX != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    frameLayoutOX.addView(this.SD, layoutParams);
                    return;
                }
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.SD.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(iKZx3, iKZx4);
            }
            layoutParams2.width = iKZx3;
            layoutParams2.height = iKZx4;
            layoutParams2.topMargin = iKZx2;
            layoutParams2.leftMargin = iKZx;
            layoutParams2.setMarginStart(layoutParams2.leftMargin);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.SD.setLayoutParams(layoutParams2);
        }
    }

    public void setExpressVideoListenerProxy(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar) {
        this.Mc = pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA() {
        com.bytedance.sdk.openadsdk.component.JG.pA pAVar = this.JG;
        if (pAVar != null) {
            pAVar.pA(this);
        }
    }

    public void setVideoManager(com.bytedance.sdk.openadsdk.component.omh.KZx kZx) {
        this.ML = kZx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void Og() {
        super.Og();
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA(int i) {
        com.bytedance.sdk.openadsdk.component.omh.KZx kZx = this.ML;
        if (kZx == null) {
            return;
        }
        if (i != 1) {
            if (i == 2) {
                kZx.SD();
                this.KZx.ZZv();
                return;
            } else if (i == 3) {
                kZx.omh();
                this.KZx.KZx();
                return;
            } else if (i == 4) {
                kZx.Bzk();
                return;
            } else if (i != 5) {
                return;
            }
        }
        if (kZx.ZZv() || this.ML.ML()) {
            return;
        }
        this.ML.pA(getVideoFrameLayout(), this.Og, this.BSW);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void ML() {
        com.bytedance.sdk.openadsdk.component.JG.pA pAVar = this.JG;
        if (pAVar != null) {
            pAVar.Og(this);
        }
    }

    public void setTopListener(com.bytedance.sdk.openadsdk.component.JG.pA pAVar) {
        this.JG = pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public int ZZv() {
        com.bytedance.sdk.openadsdk.component.omh.KZx kZx = this.ML;
        if (kZx != null && kZx.JG()) {
            return 1;
        }
        com.bytedance.sdk.openadsdk.component.omh.KZx kZx2 = this.ML;
        if (kZx2 != null && kZx2.ML()) {
            return 3;
        }
        com.bytedance.sdk.openadsdk.component.omh.KZx kZx3 = this.ML;
        if (kZx3 != null && kZx3.ZZv()) {
            return 2;
        }
        com.bytedance.sdk.openadsdk.component.omh.KZx kZx4 = this.ML;
        if (kZx4 != null && kZx4.Og()) {
            return 4;
        }
        com.bytedance.sdk.openadsdk.component.omh.KZx kZx5 = this.ML;
        return (kZx5 == null || !kZx5.KZx()) ? 3 : 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public long KZx() {
        return this.ZZv.Og();
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.component.adexpress.Og.omh
    public void pA(View view, int i, com.bytedance.sdk.component.adexpress.KZx kZx) {
        if (i != -1 && kZx != null && i == 3) {
            ML();
        } else {
            super.pA(view, i, kZx);
        }
    }

    public FrameLayout getVideoFrameLayout() {
        return this.SD;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO
    protected int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.component.SD.pA.pA(this.BSW, aBv.ZZv().SD(String.valueOf(this.BSW.Wf())));
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO
    protected void pA(Wx.pA pAVar) {
        pAVar.ML(com.bytedance.sdk.openadsdk.component.SD.pA.Og());
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO
    protected void pA(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.component.SD.pA.pA(jSONObject, this.BSW != null ? this.BSW.Wf() : 0, this.BSW != null && this.BSW.du() == 0);
    }
}
