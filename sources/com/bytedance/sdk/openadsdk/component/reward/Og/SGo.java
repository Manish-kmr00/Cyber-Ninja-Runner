package com.bytedance.sdk.openadsdk.component.reward.Og;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: loaded from: classes11.dex */
public class SGo extends Og {
    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean JG() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean ML() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void SD() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void pA(FrameLayout frameLayout) {
    }

    public SGo(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        super(pAVar);
    }

    public static boolean pA(yFO yfo) {
        return WQf.SD(yfo) || WQf.XT(yfo);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void aBv() {
        if (WQf.omh(this.Og) && this.pA.rB.CIG() && !this.pA.rB.Gx()) {
            XT();
        }
        if (WQf.SD(this.pA.Og)) {
            if (DeviceUtils.SD() == 0) {
                this.pA.agB = true;
            }
            if (this.pA.agB) {
                this.pA.qmB.Og(true);
                this.pA.lT.pA(true);
            }
        }
        this.pA.Wo.pA();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void yFO() {
        if (this.pA.TV.omh(com.bytedance.sdk.openadsdk.component.reward.pA.omh.KZx) && WQf.XT(this.pA.Og)) {
            this.pA.TV.KZx("return_foreground");
            if ((this.Wx == null || !this.Wx.isShowing()) && this.pA.TV.Og() >= 0.0f) {
                this.pA.TV.ML(0);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void vZF() {
        super.vZF();
        if (WQf.XT(this.pA.Og)) {
            this.SGo.removeMessages(600);
            this.pA.TV.KZx("go_background");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void Sd() {
        super.Sd();
        if (WQf.XT(this.pA.Og)) {
            this.SGo.removeMessages(600);
            this.pA.TV.KZx("go_background");
        }
    }
}
