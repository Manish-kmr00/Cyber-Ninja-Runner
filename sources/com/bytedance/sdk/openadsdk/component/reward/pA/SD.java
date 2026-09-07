package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: loaded from: classes11.dex */
public class SD extends SGo implements Handler.Callback {
    boolean JG;
    int KZx;
    int ML;
    long Og;
    int ZZv;
    boolean pA;
    private final Handler yFO;

    public SD(pA pAVar) {
        super(pAVar);
        this.yFO = new Handler(this);
        this.pA = false;
        this.Og = 0L;
        this.KZx = 0;
        this.ZZv = 0;
        this.ML = 0;
        this.JG = false;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    public void pA() {
        if (this.Wx && !this.WV) {
            super.pA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    protected void pA(boolean z) {
        if (this.oX != null) {
            try {
                this.aBv = com.bytedance.sdk.openadsdk.yFO.pA.ZZv.pA().pA(this.Bzk, this.oX, Og());
                this.aBv.pA(this.BSW.FQ);
            } catch (Throwable unused) {
                com.bytedance.sdk.component.utils.WV.pA("RVIVPlayableNewManager", "PreRender injection exception");
            }
            if (this.aBv == null) {
                super.pA(z);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    protected com.bytedance.sdk.openadsdk.WV.ML Og() {
        return new com.bytedance.sdk.openadsdk.WV.ML() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.SD.1
            @Override // com.bytedance.sdk.openadsdk.WV.ML
            public void pA() {
                SD.this.WV();
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    public void KZx() {
        if (this.Wx) {
            this.SD = true;
            this.aBv.pA();
            if (WQf.SGo(this.Bzk)) {
                this.BSW.rB.JG();
            }
            this.ZZv = this.Bzk.mK();
            this.ML = com.bytedance.sdk.openadsdk.core.aBv.ZZv().pA(String.valueOf(this.BSW.JG), this.Bzk.kK());
            this.Og = System.currentTimeMillis();
            Handler handler = this.yFO;
            handler.sendMessage(handler.obtainMessage(900, this.ZZv, 0));
            this.BSW.FQ.BSW();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    public void ZZv() {
        if (this.Wx) {
            super.ZZv();
            if (DeviceUtils.SD() == 0) {
                this.BSW.agB = true;
            }
            if (this.BSW.agB) {
                this.BSW.qmB.Og(true);
                KZx(true);
            }
            if ((this.BSW.nCO == null || this.BSW.nCO.Wx == null || !this.BSW.nCO.Wx.isShowing()) && SD() > 0) {
                pA(0L);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    public void ML() {
        if (this.Wx) {
            super.ML();
            if (WQf.KZx(this.BSW.Og)) {
                this.BSW.Bf.removeMessages(600);
            }
            this.yFO.removeMessages(900);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    public void JG() {
        if (this.Wx && !this.DX) {
            super.JG();
            this.yFO.removeCallbacksAndMessages(null);
        }
    }

    public int SD() {
        return this.KZx;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    public void Og(int i) {
        this.KZx = i;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    public void omh() {
        if (this.Wx) {
            this.yFO.removeMessages(900);
            this.yFO.removeMessages(600);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    public void pA(long j) {
        if (this.Wx && this.SD) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            messageObtain.arg1 = SD();
            this.yFO.sendMessageDelayed(messageObtain, j);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 900 && this.SD && WQf.KZx(this.BSW.Og) && !this.XT.get()) {
            int i = message.arg1;
            if (i > 0) {
                this.BSW.qmB.ZZv(true);
                int i2 = this.ML - (this.ZZv - i);
                if (i2 == i) {
                    this.BSW.qmB.pA(String.valueOf(i), null);
                } else if (i2 > 0) {
                    this.BSW.qmB.pA(String.valueOf(i), String.format(com.bytedance.sdk.component.utils.yFO.pA(this.BSW.SzT.getApplicationContext(), "tt_skip_ad_time_text"), Integer.valueOf(i2)));
                } else {
                    this.JG = true;
                    if (WQf.SGo(this.BSW.Og)) {
                        this.BSW.qmB.KZx();
                        this.BSW.qmB.ML(true);
                    } else {
                        this.BSW.yFO.set(true);
                        this.BSW.nCO.DX();
                    }
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 900;
                int i3 = i - 1;
                messageObtain.arg1 = i3;
                this.yFO.sendMessageDelayed(messageObtain, 1000L);
                this.KZx = i3;
            } else {
                this.JG = true;
                if (WQf.SGo(this.Bzk) && (!WQf.BF(this.Bzk) || !this.aBv.ML())) {
                    this.BSW.qmB.KZx();
                    this.BSW.qmB.ML(true);
                } else {
                    this.BSW.qmB.ZZv(false);
                    this.BSW.yFO.set(true);
                    this.BSW.nCO.DX();
                }
                if (this.aBv == null || this.aBv.ML()) {
                    this.Sn = true;
                }
            }
            WV();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pA.SGo
    public boolean Bzk() {
        return this.JG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WV() {
        boolean z = false;
        boolean z2 = (1.0f - (((float) this.KZx) / ((float) this.ZZv))) * 100.0f >= ((float) com.bytedance.sdk.openadsdk.core.aBv.ZZv().eG(String.valueOf(this.BSW.JG)).JG);
        int iPA = com.bytedance.sdk.openadsdk.core.aBv.ZZv().pA(String.valueOf(this.BSW.JG));
        if (iPA == 0) {
            boolean zJG = this.aBv != null ? this.aBv.JG() : false;
            if (this.Sn) {
                zJG = true;
            }
            if (z2 && zJG) {
                z = true;
            }
        } else if (iPA == 1) {
            z = z2;
        }
        if (z) {
            this.BSW.FQ.pA(true);
        }
    }
}
