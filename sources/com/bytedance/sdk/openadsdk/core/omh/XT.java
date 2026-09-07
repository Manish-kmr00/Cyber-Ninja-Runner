package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes9.dex */
public class XT extends yFO implements com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx, com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv {
    private com.bytedance.sdk.openadsdk.multipro.Og.pA IG;
    boolean JG;
    boolean KZx;
    boolean ML;
    private DX Mc;
    boolean Og;
    int SD;
    int ZZv;
    private long lT;
    int pA;
    private long rB;
    private com.bytedance.sdk.openadsdk.pA.Og.KZx xy;

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void ML() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void Og() {
    }

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
    public void pA() {
    }

    public XT(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, AdSlot adSlot, String str) {
        super(context, yfo, adSlot, str, false, true);
        this.pA = 1;
        this.Og = false;
        this.KZx = true;
        this.ML = true;
        this.JG = true;
        this.SD = -1;
        SD();
    }

    protected void SD() {
        this.WV = new FrameLayout(this.omh);
        int iWf = this.BSW != null ? this.BSW.Wf() : 0;
        this.ZZv = iWf;
        ZZv(iWf);
        oX();
        addView(this.WV, new FrameLayout.LayoutParams(-1, -1));
        if (getWebView() != null) {
            getWebView().setBackgroundColor(0);
        }
    }

    private void oX() {
        try {
            this.IG = new com.bytedance.sdk.openadsdk.multipro.Og.pA();
            DX dx = new DX(this.omh, this.BSW, this.Bzk, this.TV);
            this.Mc = dx;
            dx.setShouldCheckNetChange(false);
            this.Mc.setControllerStatusCallBack(new com.bytedance.sdk.openadsdk.core.Wx.Og.JG.Og() { // from class: com.bytedance.sdk.openadsdk.core.omh.XT.1
                @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG.Og
                public void pA(boolean z, long j, long j2, long j3, boolean z2) {
                    XT.this.IG.pA = z;
                    XT.this.IG.ML = j;
                    XT.this.IG.JG = j2;
                    XT.this.IG.SD = j3;
                    XT.this.IG.ZZv = z2;
                }
            });
            this.Mc.setVideoAdLoadListener(this);
            this.Mc.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.Bzk)) {
                this.Mc.setIsAutoPlay(this.Og ? this.SGo.isAutoPlay() : this.KZx);
            } else if ("open_ad".equals(this.Bzk)) {
                this.Mc.setIsAutoPlay(true);
            } else {
                this.Mc.setIsAutoPlay(this.KZx);
            }
            if ("open_ad".equals(this.Bzk)) {
                this.Mc.setIsQuiet(true);
            } else {
                this.TX = com.bytedance.sdk.openadsdk.core.aBv.ZZv().KZx(String.valueOf(this.ZZv));
                this.Mc.setIsQuiet(this.TX);
            }
            this.Mc.ZZv();
        } catch (Exception unused) {
            this.Mc = null;
        }
    }

    void ZZv(int i) {
        int iOg = com.bytedance.sdk.openadsdk.core.aBv.ZZv().Og(i);
        if (3 == iOg) {
            this.Og = false;
            this.KZx = false;
        } else if (4 == iOg) {
            this.Og = true;
        } else {
            int iKZx = com.bytedance.sdk.component.utils.DX.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA());
            if (1 == iOg) {
                this.Og = false;
                this.KZx = gbA.ZZv(iKZx);
            } else if (2 == iOg) {
                if (gbA.ML(iKZx) || gbA.ZZv(iKZx) || gbA.JG(iKZx)) {
                    this.Og = false;
                    this.KZx = true;
                }
            } else if (5 == iOg && (gbA.ZZv(iKZx) || gbA.JG(iKZx))) {
                this.Og = false;
                this.KZx = true;
            }
        }
        if (this.KZx) {
            return;
        }
        this.pA = 3;
    }

    public com.bytedance.sdk.openadsdk.multipro.Og.pA getVideoModel() {
        return this.IG;
    }

    private void setShowAdInteractionView(boolean z) {
        DX dx = this.Mc;
        if (dx != null) {
            dx.setShowAdInteractionView(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.component.adexpress.Og.DX
    public void pA(com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv, com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        this.roi = zZv;
        this.SD = zZv.KZx();
        if ((this.roi instanceof WQf) && ((WQf) this.roi).oX() != null) {
            ((WQf) this.roi).oX().pA((Sn) this);
        }
        if (sn != null && sn.KZx()) {
            Og(sn);
        }
        super.pA(zZv, sn);
    }

    private void Og(final com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        if (sn == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.XT.2
            @Override // java.lang.Runnable
            public void run() {
                XT.this.KZx(sn);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx(com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        int i;
        double dJG = sn.JG();
        double dSD = sn.SD();
        double dOmh = sn.omh();
        double dBzk = sn.Bzk();
        if ((dOmh != 0.0d && dBzk != 0.0d) || (i = this.SD) == 7 || i == 10) {
            int iKZx = Vgu.KZx(this.omh, (float) dJG);
            int iKZx2 = Vgu.KZx(this.omh, (float) dSD);
            int iKZx3 = Vgu.KZx(this.omh, (float) dOmh);
            int iKZx4 = Vgu.KZx(this.omh, (float) dBzk);
            float fMin = Math.min(Math.min(Vgu.KZx(this.omh, sn.WV()), Vgu.KZx(this.omh, sn.Wx())), Math.min(Vgu.KZx(this.omh, sn.Sn()), Vgu.KZx(this.omh, sn.DX())));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.WV.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(iKZx3, iKZx4);
            }
            layoutParams.width = iKZx3;
            layoutParams.height = iKZx4;
            layoutParams.topMargin = iKZx2;
            layoutParams.leftMargin = iKZx;
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            this.WV.setLayoutParams(layoutParams);
            this.WV.removeAllViews();
            if (this.Mc != null) {
                int i2 = this.SD;
                if ((i2 == 7 || i2 == 10) && (sn instanceof com.bytedance.sdk.openadsdk.core.BSW.ZZv.Og)) {
                    FrameLayout frameLayoutOX = ((com.bytedance.sdk.openadsdk.core.BSW.ZZv.Og) sn).oX();
                    if (frameLayoutOX != null) {
                        frameLayoutOX.removeAllViews();
                        frameLayoutOX.addView(this.Mc, new FrameLayout.LayoutParams(-1, -1));
                    }
                } else if (sn.pA() != null) {
                    if (this.JG) {
                        sn.pA().setTag(com.bytedance.sdk.component.adexpress.dynamic.pA.JG, 1);
                        ((FrameLayout) sn.pA()).removeAllViews();
                        ((FrameLayout) sn.pA()).addView(this.Mc, new FrameLayout.LayoutParams(-1, -1));
                        this.JG = false;
                    }
                } else {
                    this.WV.addView(this.Mc);
                }
                Vgu.Og(this.WV, fMin);
                this.Mc.pA(0L, true, false);
                ZZv(this.ZZv);
                if (!com.bytedance.sdk.component.utils.DX.ZZv(this.omh) && !this.KZx && this.ML) {
                    this.Mc.ML();
                }
                if (TextUtils.equals("embeded_ad", this.Bzk)) {
                    return;
                }
                setShowAdInteractionView(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA(boolean z) {
        DX dx = this.Mc;
        if (dx != null) {
            dx.setIsQuiet(z);
            setSoundMute(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA(int i) {
        DX dx = this.Mc;
        if (dx == null) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i == 1) {
            dx.pA(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            dx.setCanInterruptVideoPlay(true);
            this.Mc.performClick();
        } else if (i == 4) {
            dx.getNativeVideoController().ZZv();
        } else {
            if (i != 5) {
                return;
            }
            dx.pA(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.component.adexpress.Og.omh
    public void pA(View view, int i, com.bytedance.sdk.component.adexpress.KZx kZx) {
        if (i == -1 || kZx == null) {
            return;
        }
        if (i == 11) {
            try {
                DX dx = this.Mc;
                if (dx != null) {
                    dx.setCanInterruptVideoPlay(true);
                    this.Mc.performClick();
                    if (this.Wx) {
                        this.Mc.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.lgT).setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        super.pA(view, i, kZx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public long KZx() {
        return this.lT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public int ZZv() {
        DX dx;
        if (this.pA == 3 && (dx = this.Mc) != null) {
            dx.ZZv();
        }
        DX dx2 = this.Mc;
        if (dx2 == null || !dx2.getNativeVideoController().oX()) {
            return this.pA;
        }
        return 1;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void d_() {
        this.ML = false;
        this.pA = 2;
        com.bytedance.sdk.openadsdk.pA.Og.KZx kZx = this.xy;
        if (kZx != null) {
            kZx.pA(null);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void g_() {
        this.ML = false;
        this.Wx = true;
        this.pA = 3;
        com.bytedance.sdk.openadsdk.pA.Og.KZx kZx = this.xy;
        if (kZx != null) {
            kZx.Og(null);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void h_() {
        this.ML = false;
        this.Wx = false;
        this.pA = 2;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void pA(long j, long j2) {
        this.ML = false;
        int i = this.pA;
        if (i != 5 && i != 3 && j > this.lT) {
            this.pA = 2;
        }
        this.lT = j;
        this.rB = j2;
        if (this.eG != null && this.eG.Og() != null) {
            this.eG.Og().setTimeUpdate(((int) (j2 - j)) / 1000);
        }
        if (this.roi instanceof com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx) {
            ((com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx) this.roi).setTimeUpdate(((int) (j2 - j)) / 1000);
        }
        Og(j, j2);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void i_() {
        this.ML = false;
        this.pA = 5;
        if (this.eG != null && this.eG.Og() != null) {
            this.eG.Og().onvideoComplate();
        }
        com.bytedance.sdk.openadsdk.pA.Og.KZx kZx = this.xy;
        if (kZx != null) {
            kZx.KZx(null);
        }
        if (this.roi instanceof com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx) {
            ((com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx) this.roi).onvideoComplate();
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv
    public void pA(int i, int i2) {
        this.lT = this.rB;
        this.pA = 4;
        com.bytedance.sdk.openadsdk.pA.Og.KZx kZx = this.xy;
        if (kZx != null) {
            kZx.pA(i, i2);
        }
    }

    protected DX getExpressVideoView() {
        return this.Mc;
    }

    public com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx getVideoController() {
        DX dx = this.Mc;
        if (dx != null) {
            return dx.getNativeVideoController();
        }
        return null;
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.pA.Og.KZx kZx) {
        this.xy = kZx;
    }

    public com.bytedance.sdk.openadsdk.pA.Og.KZx getVideoAdListener() {
        return this.xy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA(int i, String str) {
        this.XT = i;
        this.yFO = str;
    }

    private void Og(long j, long j2) {
        int iAbs = (int) Math.abs(((long) this.XT) - j);
        if (this.XT < 0 || iAbs > 500 || this.XT > j2 || iAbs >= 500 || this.vZF.contains(this.yFO)) {
            return;
        }
        if (this.XT > j) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.XT.3
                @Override // java.lang.Runnable
                public void run() {
                    XT.this.Mc.setCanInterruptVideoPlay(true);
                    XT.this.Mc.performClick();
                    XT xt = XT.this;
                    xt.Og(xt.XT, XT.this.yFO);
                }
            }, iAbs);
        } else {
            this.Mc.setCanInterruptVideoPlay(true);
            this.Mc.performClick();
            Og(this.XT, this.yFO);
        }
        this.vZF.add(this.yFO);
    }
}
