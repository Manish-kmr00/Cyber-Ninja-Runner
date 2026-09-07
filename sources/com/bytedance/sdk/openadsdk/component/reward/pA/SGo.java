package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.app.Activity;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class SGo implements com.bytedance.sdk.openadsdk.WV.SD {
    protected final pA BSW;
    protected final com.bytedance.sdk.openadsdk.core.model.yFO Bzk;
    protected boolean DX;
    protected volatile boolean SD;
    protected final String SGo;
    protected boolean Sn;
    protected boolean WV;
    protected boolean Wx;
    protected AtomicBoolean XT = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.yFO.pA.pA aBv;
    protected FrameLayout oX;
    protected final Activity omh;

    public boolean Bzk() {
        return false;
    }

    public void Og(int i) {
    }

    public void omh() {
    }

    public void pA(long j) {
    }

    public SGo(pA pAVar) {
        this.BSW = pAVar;
        this.omh = pAVar.SzT;
        this.SGo = pAVar.ML;
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = pAVar.Og;
        this.Bzk = yfo;
        this.Wx = WQf.ML(yfo);
    }

    public void pA() {
        if (this.Wx && !this.WV) {
            this.WV = true;
            DeviceUtils.AudioInfoReceiver.pA(this);
        }
    }

    public void Og(boolean z) {
        if (this.Wx && this.BSW.HSv) {
            this.oX = (FrameLayout) this.BSW.CIG.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.Bi);
            pA(z);
        }
    }

    protected void pA(boolean z) {
        if (this.oX != null) {
            com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar = new com.bytedance.sdk.openadsdk.yFO.pA.pA(this.BSW.Gx, this.Bzk, this.BSW.YkC, z, this.oX);
            this.aBv = pAVar;
            pAVar.pA(this.BSW.FQ);
            this.aBv.pA(true, Og());
        }
    }

    protected com.bytedance.sdk.openadsdk.WV.ML Og() {
        return new com.bytedance.sdk.openadsdk.WV.ML() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.SGo.1
            @Override // com.bytedance.sdk.openadsdk.WV.ML
            public void pA() {
                SGo.this.BSW.FQ.pA(false);
            }
        };
    }

    public void KZx() {
        if (this.Wx) {
            this.SD = true;
            KZx(this.BSW.agB);
            this.aBv.pA();
            SD();
            if (WQf.SGo(this.Bzk)) {
                this.BSW.rB.JG();
            }
        }
    }

    private void SD() {
        int iGuZ = this.Bzk.guZ();
        if (iGuZ == -1) {
            if (WQf.Bzk(this.Bzk)) {
                com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar = this.aBv;
                if (pAVar != null && pAVar.ML()) {
                    this.BSW.yFO.set(true);
                    this.BSW.nCO.DX();
                } else {
                    this.BSW.nCO.WQf();
                    return;
                }
            } else {
                this.BSW.yFO.set(true);
                this.BSW.nCO.DX();
            }
        } else {
            if (iGuZ < 0) {
                return;
            }
            this.BSW.qmB.ZZv(false);
            if (WQf.Bzk(this.Bzk)) {
                com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar2 = this.aBv;
                if (pAVar2 != null && pAVar2.ML()) {
                    this.BSW.Bf.sendEmptyMessageDelayed(600, iGuZ);
                } else {
                    this.BSW.Bf.sendEmptyMessageDelayed(1, iGuZ);
                    return;
                }
            } else {
                this.BSW.Bf.sendEmptyMessageDelayed(600, iGuZ);
            }
        }
        if (this.BSW.Wo != null) {
            this.BSW.Wo.pA(iGuZ);
        }
    }

    public void ZZv() {
        com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar;
        if (!this.Wx || this.XT.get() || (pAVar = this.aBv) == null) {
            return;
        }
        pAVar.Og();
    }

    public void ML() {
        com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar;
        if (!this.Wx || this.XT.get() || (pAVar = this.aBv) == null) {
            return;
        }
        pAVar.KZx();
    }

    public void JG() {
        if (this.Wx && !this.DX) {
            this.DX = true;
            com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar = this.aBv;
            if (pAVar != null) {
                pAVar.ZZv();
            }
            FrameLayout frameLayout = this.oX;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            DeviceUtils.AudioInfoReceiver.Og(this);
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Og.ML ml) {
        com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar;
        if (this.Wx && (pAVar = this.aBv) != null) {
            pAVar.pA(ml);
        }
    }

    public void KZx(boolean z) {
        if (this.Wx && this.aBv != null && this.SD) {
            this.aBv.pA(z);
        }
    }

    public boolean SGo() {
        return this.SD;
    }

    @Override // com.bytedance.sdk.openadsdk.WV.SD
    public void pA(int i) {
        if (this.BSW.lT.Og()) {
            boolean z = this.BSW.agB;
            this.BSW.lT.pA();
            if (i == 0) {
                this.BSW.qmB.Og(true);
                KZx(true);
                return;
            } else {
                this.BSW.qmB.Og(false);
                KZx(false);
                return;
            }
        }
        this.BSW.lT.pA(-1);
        boolean z2 = this.BSW.agB;
        this.BSW.lT.pA();
        if (this.BSW.fN) {
            if (i == 0) {
                this.BSW.agB = true;
                this.BSW.qmB.Og(true);
                KZx(true);
            } else {
                this.BSW.agB = false;
                this.BSW.qmB.Og(false);
                KZx(false);
            }
        }
    }

    public void BSW() {
        if (this.XT.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.yFO.pA.pA pAVar = this.aBv;
            if (pAVar != null) {
                pAVar.pA(true);
            }
            this.BSW.rB.JG(true);
            this.BSW.gbA.pA(true, this.BSW.nCO);
            if (this.BSW.gbA.SD()) {
                this.BSW.Wo.pA(this.BSW.omh);
                return;
            }
            this.BSW.rB.pA(this.BSW.agB, true);
            this.BSW.rB.KZx(true);
            this.BSW.rB.Og(true);
            this.BSW.Bf.removeMessages(600);
            return;
        }
        this.BSW.rB.Bzk();
    }
}
