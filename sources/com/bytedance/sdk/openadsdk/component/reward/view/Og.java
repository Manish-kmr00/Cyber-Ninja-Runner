package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.aBv;
import com.bytedance.sdk.openadsdk.core.model.vZF;
import com.bytedance.sdk.openadsdk.core.omh.Sn;
import com.bytedance.sdk.openadsdk.core.omh.WQf;
import com.bytedance.sdk.openadsdk.core.omh.oX;
import com.bytedance.sdk.openadsdk.core.omh.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Og extends yFO {
    public static float pA = 100.0f;
    private float JG;
    oX KZx;
    private final com.bytedance.sdk.openadsdk.component.reward.pA.pA ML;
    Sn Og;
    public int ZZv;

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/view/Og;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z");
        DetectTouchUtils.viewOnTouch(h.u, this, motionEvent);
        return safedk_Og_dispatchTouchEvent_b78d4cba8429b1fda4e5d82c27d3e599(motionEvent);
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

    public Og(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar, AdSlot adSlot, String str) {
        super(pAVar.SzT, pAVar.Og, adSlot, str, pAVar.agB, !pAVar.Itl);
        this.ZZv = 1;
        this.JG = -1.0f;
        this.ML = pAVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO
    protected void JG() {
        this.Sn = true;
        this.WV = new FrameLayout(this.omh);
        if (!com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(this.BSW) && !com.bytedance.sdk.openadsdk.core.BSW.KZx.Og(this.BSW)) {
            addView(this.WV, new FrameLayout.LayoutParams(-1, -1));
        }
        super.JG();
        com.bytedance.sdk.component.Bzk.ZZv webView = getWebView();
        if (webView != null) {
            webView.setBackgroundColor(0);
        }
        SD();
    }

    private void SD() {
        setBackupListener(new com.bytedance.sdk.component.adexpress.Og.KZx() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.Og.1
            @Override // com.bytedance.sdk.component.adexpress.Og.KZx
            public boolean pA(ViewGroup viewGroup, int i) {
                try {
                    ((yFO) viewGroup).WV();
                    Og.this.KZx = new oX(viewGroup.getContext());
                    Og.this.KZx.pA(Og.this.BSW, (yFO) viewGroup, Og.this.ML.CIG);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.component.adexpress.Og.DX
    public void pA(com.bytedance.sdk.component.adexpress.Og.ZZv<? extends View> zZv, com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        this.roi = zZv;
        if (this.BSW != null && this.BSW.qH()) {
            super.pA(zZv, sn);
            return;
        }
        if (zZv instanceof WQf) {
            WQf wQf = (WQf) zZv;
            if (wQf.oX() != null) {
                wQf.oX().pA((Sn) this);
            }
        }
        if (sn != null && sn.KZx()) {
            Og(sn);
            this.ZZv = zZv.KZx();
        }
        super.pA(zZv, sn);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO
    protected boolean pA(com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        if ((this.BSW instanceof vZF) && ((vZF) this.BSW).PF() && sn.KZx() && sn.Og() == 1) {
            return false;
        }
        return super.pA(sn);
    }

    public void setExpressVideoListenerProxy(Sn sn) {
        this.Og = sn;
    }

    public void Og(final com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        if (sn == null) {
            return;
        }
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.Og.2
            @Override // java.lang.Runnable
            public void run() {
                Og.this.KZx(sn);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA(String str, JSONObject jSONObject) {
        super.pA(str, jSONObject);
        Sn sn = this.Og;
        if (sn != null) {
            sn.pA(str, jSONObject);
        }
    }

    public boolean safedk_Og_dispatchTouchEvent_b78d4cba8429b1fda4e5d82c27d3e599(MotionEvent p0) {
        SGo sGo = this.ML.Vgu;
        if (sGo != null && sGo.DX != null) {
            aBv abv = sGo.DX;
            if (abv.Bzk()) {
                int action = p0.getAction();
                if (action == 0) {
                    this.JG = p0.getY();
                } else if (action == 1) {
                }
                if (Vgu.pA(this.JG, p0.getY(), this.omh)) {
                    abv.pA(5);
                }
            }
        }
        return super.dispatchTouchEvent(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx(com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        if (sn == null) {
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
                    frameLayoutOX.addView(this.WV, layoutParams);
                    return;
                }
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.WV.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(iKZx3, iKZx4);
            }
            layoutParams2.width = iKZx3;
            layoutParams2.height = iKZx4;
            layoutParams2.topMargin = iKZx2;
            layoutParams2.leftMargin = iKZx;
            layoutParams2.setMarginStart(layoutParams2.leftMargin);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.WV.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA(boolean z) {
        Sn sn = this.Og;
        if (sn != null) {
            sn.pA(z);
        }
        setSoundMute(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA() {
        Sn sn = this.Og;
        if (sn != null) {
            sn.pA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void Og() {
        Sn sn = this.Og;
        if (sn != null) {
            sn.Og();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA(int i) {
        Sn sn = this.Og;
        if (sn != null) {
            sn.pA(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public long KZx() {
        Sn sn = this.Og;
        if (sn != null) {
            return sn.KZx();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public int ZZv() {
        Sn sn = this.Og;
        if (sn != null) {
            return sn.ZZv();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void ML() {
        Sn sn = this.Og;
        if (sn != null) {
            sn.ML();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA(int i, com.bytedance.sdk.component.adexpress.Og.Sn sn) {
        Sn sn2 = this.Og;
        if (sn2 != null) {
            sn2.pA(i, sn);
        }
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
        if (Wx()) {
            return this.KZx.getVideoContainer();
        }
        return this.WV;
    }

    public View getBackupContainerBackgroundView() {
        if (Wx()) {
            return this.KZx.getBackupContainerBackgroundView();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void Og(int i) {
        Sn sn = this.Og;
        if (sn != null) {
            sn.Og(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO, com.bytedance.sdk.openadsdk.core.omh.Sn
    public void pA(int i, String str) {
        Sn sn = this.Og;
        if (sn != null) {
            sn.pA(i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.omh.yFO
    protected com.bytedance.sdk.openadsdk.BF.Og.ML.pA KZx(int i) {
        com.bytedance.sdk.openadsdk.BF.Og.ML.pA pAVarKZx = super.KZx(i);
        if (this.ML.Itl && this.ML.RS != null) {
            pAVarKZx.Og = this.ML.RS.Bzk;
        }
        return pAVarKZx;
    }
}
