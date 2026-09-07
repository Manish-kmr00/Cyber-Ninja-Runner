package com.bytedance.sdk.openadsdk.component.reward.Og;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes6.dex */
public class Bzk extends Og {
    private com.bytedance.sdk.openadsdk.component.reward.view.pA DX;

    public Bzk(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        super(pAVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void pA(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.reward.view.pA pAVar = new com.bytedance.sdk.openadsdk.component.reward.view.pA(this.pA.SzT, this.BSW);
        this.DX = pAVar;
        pAVar.setDownloadListener(this.WV);
        this.DX.pA(this.Og, this.pA.dC, this.pA.YkC, this.KZx, this.ZZv);
        frameLayout.addView(this.DX.getInteractionStyleRootView());
    }

    public static boolean pA(yFO yfo) {
        return (yfo.kK() || yfo.slz() == 100.0f) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public Og.pA ZZv() {
        return new Og.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.Og.Bzk.1
            @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og.pA
            public void pA(boolean z) {
                if (Bzk.this.DX != null) {
                    Bzk.this.DX.setIsMute(z);
                }
            }
        };
    }

    public FrameLayout Mc() {
        com.bytedance.sdk.openadsdk.component.reward.view.pA pAVar = this.DX;
        if (pAVar != null) {
            return pAVar.getVideoContainer();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean ML() {
        return IG();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public boolean JG() {
        return IG();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.Og.Og
    public void SD() {
        this.JG.KZx(8);
        this.JG.Og(8);
        if (this.Og.BF() == 2) {
            this.omh.pA(false);
            this.omh.KZx(false);
            this.omh.ZZv(false);
            this.JG.ML(8);
            return;
        }
        this.omh.pA(this.Og.uQ());
        this.omh.KZx(IG());
        this.omh.ZZv(IG());
        if (IG()) {
            this.JG.ML(8);
        } else {
            this.omh.JG();
            this.JG.ML(0);
        }
    }

    private boolean IG() {
        return yFO.ML(this.Og);
    }
}
