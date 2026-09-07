package com.bytedance.sdk.openadsdk.component.reward.Og;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.TV;
import com.bytedance.sdk.openadsdk.component.reward.pA.Sn;
import com.bytedance.sdk.openadsdk.component.reward.pA.XT;
import com.bytedance.sdk.openadsdk.component.reward.pA.aBv;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    protected com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og Bzk;
    protected final com.bytedance.sdk.openadsdk.component.reward.view.SGo JG;
    protected int KZx;
    protected final aBv ML;
    protected yFO Og;
    protected final XT SD;
    protected TV SGo;
    protected int ZZv;
    protected final Sn omh;
    protected com.bytedance.sdk.openadsdk.component.reward.pA.pA pA;

    public pA(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.pA = pAVar;
        this.Og = pAVar.Og;
        this.KZx = pAVar.IIF;
        this.ZZv = pAVar.vA;
        this.ML = pAVar.BF;
        this.JG = pAVar.Vgu;
        this.SD = pAVar.rB;
        this.omh = pAVar.qmB;
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og, TV tv) {
        this.Bzk = og;
        this.SGo = tv;
    }

    public boolean pA() {
        return this.pA.Og.rjD() || this.pA.Og.RS() == 15 || this.pA.Og.RS() == 5 || this.pA.Og.RS() == 50;
    }

    public void pA(boolean z) {
        if (this.pA.SGo.get()) {
            return;
        }
        yFO yfo = this.Og;
        if (yfo != null && yfo.qH()) {
            this.omh.KZx(false);
            this.omh.pA(true);
            this.pA.Vgu.Og(8);
            this.pA.Vgu.KZx(8);
            return;
        }
        if (!z) {
            this.omh.KZx(false);
            this.omh.pA(false);
            this.omh.ZZv(false);
            this.pA.Vgu.ML(8);
        } else {
            this.omh.pA(this.pA.Og.uQ());
            if (WQf.XT(this.pA.Og) || pA()) {
                this.omh.KZx(true);
            }
            if (pA() || ((this instanceof omh) && this.pA.Og.pA())) {
                this.omh.ZZv(true);
            } else {
                this.omh.JG();
                this.pA.Vgu.ML(0);
            }
        }
        if (!z) {
            this.pA.Vgu.Og(4);
            this.pA.Vgu.KZx(8);
        } else if (this.pA.dC != com.bytedance.sdk.openadsdk.component.reward.view.Og.pA) {
            this.pA.Vgu.Og(8);
            this.pA.Vgu.KZx(8);
        } else {
            this.pA.Vgu.Og(0);
            this.pA.Vgu.KZx(0);
        }
    }

    public boolean Og() {
        if (!com.bytedance.sdk.openadsdk.core.model.aBv.Og(this.pA.Og) || !this.pA.yFO.get()) {
            return (this.pA.SGo.get() || this.pA.BSW.get() || WQf.XT(this.pA.Og)) ? false : true;
        }
        FrameLayout frameLayoutJG = this.pA.Vgu.JG();
        frameLayoutJG.setVisibility(4);
        frameLayoutJG.setVisibility(0);
        return false;
    }

    protected void KZx() {
        if (WQf.Og(this.pA.Og) && DeviceUtils.SD() == 0) {
            this.pA.agB = true;
        }
        this.pA.qmB.Og(this.pA.agB);
    }
}
