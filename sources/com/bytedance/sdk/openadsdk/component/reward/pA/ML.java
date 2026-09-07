package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.vZF;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ML {
    private pA KZx;
    private final com.bytedance.sdk.openadsdk.component.reward.view.JG Og;
    private final com.bytedance.sdk.openadsdk.component.reward.pA.pA pA;

    public interface pA {
        void oX();

        void pA(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.component.reward.Og.Og og, int i);
    }

    public ML(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        this.pA = pAVar;
        this.Og = new com.bytedance.sdk.openadsdk.component.reward.view.JG(pAVar);
    }

    public void pA() {
        this.Og.pA();
    }

    public void Og() {
        this.Og.KZx();
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Og.ML ml) {
        this.Og.pA(ml);
    }

    public void pA(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.component.reward.Og.Og og, int i) {
        int i2;
        if (this.pA != null) {
            com.bytedance.sdk.openadsdk.JG.Og.pA().pA("videoForceBreak", this.pA.Og);
            com.bytedance.sdk.openadsdk.BF.pA.KZx.Og(this.pA.Og);
        }
        new StringBuilder("showEndCard() called with: isSkip = [").append(z).append("], force = [").append(z2).append("], isFromLandingPage = [").append(z3).append("], mAdType = [").append(og);
        if (this.pA.SzT.isFinishing() || og == null) {
            return;
        }
        this.pA.Vgu.WV();
        if (z2) {
            this.pA.DX.set(true);
        }
        boolean z4 = false;
        if (this.pA.bU && !this.pA.oX.get() && !com.bytedance.sdk.openadsdk.core.model.aBv.Bzk(this.pA.Og) && (!com.bytedance.sdk.openadsdk.core.model.aBv.Og(this.pA.Og) || !this.pA.DX.get() || !this.pA.aBv.get())) {
            if ((com.bytedance.sdk.openadsdk.core.model.aBv.Og(this.pA.Og) && z3) || !Og(z2)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.model.aBv.Og(this.pA.Og) || com.bytedance.sdk.openadsdk.core.model.aBv.ZZv(this.pA.Og) || com.bytedance.sdk.openadsdk.core.model.aBv.ML(this.pA.Og)) {
                this.pA.qmB.KZx(false);
                og.DX();
                return;
            }
        }
        if (this.pA.SzT.isDestroyed() || this.pA.SzT.isFinishing()) {
            return;
        }
        if (this.pA.Og.qH()) {
            com.bytedance.sdk.openadsdk.component.reward.view.omh omhVar = this.pA.du;
            com.bytedance.sdk.openadsdk.core.omh.KZx brandBannerController = (omhVar == null || omhVar.pA() == null) ? null : omhVar.pA().getBrandBannerController();
            if (brandBannerController != null) {
                brandBannerController.Og();
            }
            this.pA.SzT.finish();
            return;
        }
        pA pAVar = this.KZx;
        if (pAVar != null) {
            pAVar.pA(z, z2, z3, og, i);
            return;
        }
        this.pA.BF.Wx();
        this.pA.rB.roi();
        this.pA.BSW.set(false);
        this.pA.WV.set(false);
        this.pA.IG.pA();
        Sn sn = this.pA.qmB;
        if (!this.pA.SD && this.pA.Og.uQ()) {
            z4 = true;
        }
        sn.pA(z4);
        if (this.pA.SGo.getAndSet(true)) {
            return;
        }
        if (WQf.Og(this.pA.Og)) {
            HashMap map = new HashMap();
            if (this.pA.rB.Vgu()) {
                i2 = 1;
            } else {
                i2 = !this.pA.rB.yFO() ? -1 : 2;
            }
            map.put("webview_state", Integer.valueOf(i2));
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.pA.Og, this.pA.ML, z, z2, z3, this.pA.SzT.isFinishing(), i, map);
        }
        if (this.pA.Og.pA() && WQf.SD(this.pA.Og) && z) {
            this.pA.qmB.ZZv(true);
        }
        if (WQf.SD(this.pA.Og)) {
            this.pA.qmB.KZx(true);
        }
        Bzk();
        if (WQf.ML(this.pA.Og)) {
            this.pA.qmB.KZx(true);
            this.pA.Vgu.KZx();
            if (this.pA.du != null) {
                this.pA.du.JG();
            }
            this.pA.TV.XT();
            return;
        }
        pA(z, og);
    }

    public void pA(boolean z, com.bytedance.sdk.openadsdk.component.reward.Og.Og og) {
        if (WQf.XT(this.pA.Og)) {
            return;
        }
        this.pA.XT.set(z);
        og.Sn();
        if (this.pA.Og.rjD()) {
            this.pA.qmB.ZZv(false);
        } else {
            this.pA.qmB.ZZv(WQf.XT(this.pA.Og));
        }
        this.pA.qmB.KZx(WQf.SD(this.pA.Og));
        if (this.pA.Og.pA() && WQf.SD(this.pA.Og) && z) {
            this.pA.qmB.ZZv(true);
        }
        this.pA.rB.Mc();
        if (this.pA.Vgu.DX != null) {
            this.pA.Vgu.DX.ML();
        }
        this.pA.Vgu.KZx();
        if (this.pA.du != null) {
            this.pA.du.JG();
        }
        if (this.pA.TV != null) {
            this.pA.TV.SD(omh.Og);
        }
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.yFO.pA(this.pA.Gx, this.pA.Og))) {
            vZF.pA(this.pA.SzT, WQf.Wx(this.pA.Og), this.pA.Og, com.bytedance.sdk.openadsdk.ZZv.Og.pA.KZx);
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.pA.Og) && this.pA.xy != null) {
            this.pA.xy.JG();
        }
        if (com.bytedance.sdk.openadsdk.core.model.yFO.pA(this.pA.Og) || ((!com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.pA.Og) && this.pA.rB.SzT()) || (!com.bytedance.sdk.openadsdk.core.model.yFO.pA(this.pA.Og, this.pA.rB.XT(), this.pA.rB.Bf(), this.pA.xy.WV(), this.pA.rB.IG()) && !WQf.SD(this.pA.Og)))) {
            ZZv();
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.model.yFO.ZZv(this.pA.Og) && !WQf.SD(this.pA.Og) && !com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.pA.Og)) {
            this.pA.rB.pA(true, 0, (String) null);
        }
        if (WQf.SD(this.pA.Og)) {
            if (WQf.BF(this.pA.Og) && !this.pA.rB.Vgu()) {
                if (!this.pA.rB.XT()) {
                    if (this.pA.TV.ZZv() != null) {
                        this.pA.TV.ZZv().pA(2);
                    }
                    this.pA.TV.ML();
                    return;
                } else {
                    if (this.pA.TV.ZZv() != null) {
                        this.pA.TV.ZZv().pA(-1);
                    }
                    this.pA.TV.JG();
                    this.pA.qmB.ZZv(false);
                    this.pA.TV.pA(this.pA.roi.ML());
                    return;
                }
            }
            if (this.pA.rB.Vgu() && this.pA.TV.ZZv() != null) {
                this.pA.TV.ZZv().pA(1);
            }
            Og(og);
        } else {
            KZx(og);
        }
        pA(og);
    }

    void pA(com.bytedance.sdk.openadsdk.component.reward.Og.Og og) {
        this.pA.rB.pA(0.0f);
        this.pA.Vgu.pA(0.0f);
        if (!com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.pA.Og)) {
            this.pA.xy.pA(8);
            this.pA.rB.Og(0);
            this.pA.rB.FQ();
        } else {
            this.pA.rB.Og(8);
            this.pA.xy.pA(0);
            this.pA.xy.SD();
        }
        if (this.pA.SD) {
            Vgu.pA((View) og.Sn, 0);
            this.pA.Vgu.ML(8);
        }
        this.pA.Vgu.KZx(8);
        this.pA.Vgu.SD();
        if (com.bytedance.sdk.openadsdk.core.model.yFO.KZx(this.pA.Og)) {
            this.pA.Bf.sendEmptyMessageDelayed(800, 100L);
            return;
        }
        this.pA.Bf.sendEmptyMessageDelayed(500, 100L);
        this.pA.rB.pA(this.pA.agB, true);
        this.pA.rB.KZx(true);
        this.pA.rB.Og(true);
        IG igWV = this.pA.rB.WV();
        if (igWV != null) {
            igWV.pA("prerender_page_show", (JSONObject) null);
        }
    }

    public void Og(com.bytedance.sdk.openadsdk.component.reward.Og.Og og) {
        int iGuZ = this.pA.Og.guZ();
        if (WQf.XT(this.pA.Og)) {
            iGuZ = (this.pA.Og.mK() + 1) * 1000;
        }
        if (iGuZ == -1) {
            if (WQf.omh(this.pA.Og)) {
                if (WQf.BF(this.pA.Og) && this.pA.TV.SD()) {
                    og.DX();
                    return;
                } else {
                    og.WQf();
                    return;
                }
            }
            og.DX();
        } else {
            if (iGuZ < 0) {
                return;
            }
            this.pA.qmB.ZZv(false);
            if (WQf.omh(this.pA.Og)) {
                if (WQf.BF(this.pA.Og) && this.pA.TV.SD()) {
                    this.pA.Bf.sendEmptyMessageDelayed(600, iGuZ);
                } else {
                    this.pA.Bf.sendEmptyMessageDelayed(1, iGuZ);
                    return;
                }
            } else {
                this.pA.Bf.sendEmptyMessageDelayed(600, iGuZ);
            }
        }
        if (this.pA.Wo != null) {
            this.pA.Wo.pA(iGuZ);
        }
    }

    public boolean KZx(com.bytedance.sdk.openadsdk.component.reward.Og.Og og) {
        boolean z;
        this.pA.omh = omh();
        int i = this.pA.omh;
        if (this.pA.Og.ML()) {
            return false;
        }
        if (this.pA.omh == -1) {
            if (WQf.omh(this.pA.Og) && this.pA.rB.XT()) {
                og.WQf();
            } else if (WQf.SGo(this.pA.Og) && this.pA.rB.XT()) {
                og.WQf();
            } else {
                og.DX();
                z = true;
            }
            z = false;
        } else {
            if (this.pA.omh >= 0) {
                this.pA.Sd.set(false);
                Message messageObtain = Message.obtain();
                messageObtain.what = 700;
                messageObtain.arg1 = this.pA.omh;
                this.pA.Bf.sendMessage(messageObtain);
                if (!WQf.Bzk(this.pA.Og)) {
                    z = true;
                }
            }
            z = false;
        }
        if ((this.pA.rB.du() ? false : z) && this.pA.Wo != null) {
            this.pA.Wo.pA(this.pA.omh);
        }
        return true;
    }

    private int omh() {
        int iNpn = this.pA.Og.npn();
        if (iNpn <= 5000 && iNpn >= 0) {
            if (iNpn < 1000) {
                iNpn += 1000;
            }
            int iPA = com.bytedance.sdk.openadsdk.core.aBv.ZZv().pA(this.pA.Og.Wf());
            if (iPA <= 5000 && iPA >= 0) {
                if (iPA < 1000) {
                    iPA += 1000;
                }
                return Math.min(iNpn, iPA);
            }
        }
        return -1;
    }

    private void Bzk() {
        if (WQf.yFO(this.pA.Og) && this.pA.agB) {
            this.pA.qmB.Og(true);
            this.pA.lT.pA(true);
        }
    }

    public void KZx() {
        this.Og.ZZv();
    }

    public void ZZv() {
        pA(true);
    }

    public void pA(boolean z) {
        if (!com.bytedance.sdk.openadsdk.core.model.yFO.ZZv(this.pA.Og)) {
            this.pA.rB.pA(false, 408, "end_card_timeout");
        }
        this.pA.rB.lT();
        this.pA.rB.Og(8);
        this.pA.xy.pA(8);
        if (this.pA.SD) {
            Vgu.pA((View) this.pA.nCO.Sn, 8);
            this.pA.Vgu.ML(0);
        }
        this.pA.Vgu.KZx(8);
        if (this.pA.Og.rjD()) {
            if (!this.Og.pA(this.pA.BF)) {
                this.pA.SzT.finish();
            }
        } else {
            com.bytedance.sdk.openadsdk.activity.JG jg = this.pA.RS;
            if (jg != null) {
                this.Og.pA(jg.WQf().SD());
            }
            this.Og.Og();
        }
        this.pA.Vgu.SD();
        if (z) {
            KZx(this.pA.nCO);
        }
        this.pA.qmB.KZx(false);
        this.pA.roi.pA(this.pA.Og.kK());
    }

    public boolean ML() {
        com.bytedance.sdk.openadsdk.component.reward.view.JG jg = this.Og;
        if (jg != null) {
            return jg.ML();
        }
        return false;
    }

    public void pA(pA pAVar) {
        this.KZx = pAVar;
    }

    public pA JG() {
        return this.KZx;
    }

    public boolean SD() {
        return this.Og.JG();
    }

    private boolean Og(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.view.Og ogPA;
        if (!com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.pA.Og) || (ogPA = this.pA.du.pA()) == null || ogPA.ZZv != 0 || z) {
            return true;
        }
        this.pA.qmB.KZx(false);
        return false;
    }
}
