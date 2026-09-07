package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes12.dex */
public abstract class JG {
    protected IListenerManager BSW;
    public int Bzk;
    public boolean SGo;
    protected com.bytedance.sdk.openadsdk.WV.ML WV = new com.bytedance.sdk.openadsdk.WV.ML() { // from class: com.bytedance.sdk.openadsdk.activity.JG.1
        @Override // com.bytedance.sdk.openadsdk.WV.ML
        public void pA() {
            JG.this.Sn();
        }
    };
    protected final yFO omh;
    private final Og pA;

    public void DX() {
    }

    public void KZx(Activity activity) {
    }

    public void ML(Activity activity) {
    }

    public void Og(Activity activity) {
    }

    public abstract void Og(boolean z);

    public void Sn() {
    }

    public abstract com.bytedance.sdk.openadsdk.component.reward.pA.pA TX();

    public void ZZv(Activity activity) {
    }

    public void aBv() {
    }

    protected abstract boolean a_();

    public abstract String b_();

    public abstract View pA();

    public void pA(Activity activity) {
    }

    public void pA(Activity activity, Bundle bundle) {
    }

    public void pA(Activity activity, Og.ML ml) {
    }

    public void pA(JG jg, JG jg2, Og.ML ml) {
    }

    protected abstract String vZF();

    public abstract boolean yFO();

    public JG(Og og, yFO yfo, int i) {
        this.pA = og;
        this.omh = yfo;
        this.Bzk = i;
    }

    protected void pA(boolean z, boolean z2, boolean z3, int i) {
        this.pA.pA(this, z, z2, z3, i);
    }

    public Og WQf() {
        return this.pA;
    }

    public Activity TV() {
        return this.pA.KZx();
    }

    protected void du() {
        if (this.omh != null) {
            com.bytedance.sdk.openadsdk.JG.Og.pA().pA("videoForceBreak", this.omh);
        }
        this.pA.pA(this);
    }

    protected void pA(String str) {
        if (a_()) {
            pA(str, false, 0, "", 0, "");
        } else {
            Og(str);
        }
    }

    private void pA(final String str, final boolean z, final int i, final String str2, final int i2, final String str3) {
        xy.KZx(new omh("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.JG.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JG.this.KZx(0).executeRewardVideoCallback(JG.this.vZF(), str, z, i, str2, i2, str3);
                } catch (Throwable th) {
                    WV.pA("Scene", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    private void Og(final String str) {
        xy.KZx(new omh("FullScreen_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.JG.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JG.this.KZx(1).executeFullVideoCallback(JG.this.vZF(), str);
                } catch (Throwable th) {
                    WV.pA("Scene", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected final IListenerManager KZx(int i) {
        if (this.BSW == null) {
            this.BSW = com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA().pA(i));
        }
        return this.BSW;
    }

    public void eG() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdClose");
        } else {
            this.pA.WV();
        }
    }

    protected void roi() {
        if (this.pA.oX()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdShow");
        } else {
            this.pA.Wx();
        }
        this.pA.aBv();
    }

    protected final void Mc() {
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onAdVideoBarClick");
        } else {
            this.pA.BSW();
        }
    }

    protected final void pA(boolean z, int i, String str, int i2, String str2) {
        if (this.pA.Sn()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
            pA("onRewardVerify", z, i, str, i2, str2);
            this.pA.DX();
        } else {
            this.pA.pA(this, z, i, str, i2, str2);
        }
    }
}
