package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.View;
import com.bytedance.sdk.openadsdk.component.reward.pA.aBv;
import com.bytedance.sdk.openadsdk.component.reward.pA.yFO;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes6.dex */
public class JG {
    private boolean KZx;
    private boolean ML;
    private RFEndCardBackUpLayout Og;
    private yFO ZZv;
    private final com.bytedance.sdk.openadsdk.component.reward.pA.pA pA;

    public JG(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.pA = pAVar;
    }

    public void pA() {
        if (this.KZx) {
            return;
        }
        this.KZx = true;
        RFEndCardBackUpLayout rFEndCardBackUpLayout = (RFEndCardBackUpLayout) this.pA.CIG.findViewById(Sn.rtW);
        this.Og = rFEndCardBackUpLayout;
        if (rFEndCardBackUpLayout != null) {
            rFEndCardBackUpLayout.init(this.pA);
        }
        if (this.pA.Og.rjD()) {
            this.ZZv = new yFO(this.pA);
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Og.ML ml) {
        RFEndCardBackUpLayout rFEndCardBackUpLayout = this.Og;
        if (rFEndCardBackUpLayout == null) {
            return;
        }
        Vgu.pA(rFEndCardBackUpLayout, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.JG.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/component/reward/view/JG$1;->onClick(Landroid/view/View;)V");
                CreativeInfoManager.onViewClicked(h.u, view);
                safedk_JG$1_onClick_c60fe85c40b3a961420220b2247ae630(view);
            }

            public void safedk_JG$1_onClick_c60fe85c40b3a961420220b2247ae630(View p0) {
            }
        }, "TTBaseVideoActivity#mFLEndCardBackupContainer");
        yFO yfo = this.ZZv;
        if (yfo != null) {
            yfo.pA(ml);
        }
    }

    public void Og() {
        this.ML = true;
        Vgu.pA((View) this.Og, 0);
    }

    public boolean pA(aBv abv) {
        this.ML = true;
        yFO yfo = this.ZZv;
        if (yfo == null || !yfo.pA(abv)) {
            return false;
        }
        Vgu.pA((View) this.Og, 0);
        return true;
    }

    public void KZx() {
        yFO yfo = this.ZZv;
        if (yfo != null) {
            yfo.pA();
        }
    }

    public void ZZv() {
        yFO yfo = this.ZZv;
        if (yfo != null) {
            yfo.Og();
        }
    }

    public boolean ML() {
        yFO yfo = this.ZZv;
        if (yfo != null) {
            return yfo.KZx();
        }
        return false;
    }

    public void pA(int i) {
        RFEndCardBackUpLayout rFEndCardBackUpLayout = this.Og;
        if (rFEndCardBackUpLayout == null) {
            return;
        }
        rFEndCardBackUpLayout.setShownAdCount(i);
    }

    public boolean JG() {
        return this.ML;
    }
}
