package com.bytedance.sdk.openadsdk.component.reward;

import android.os.CountDownTimer;
import com.bytedance.sdk.openadsdk.ZZv.ML.Og.DX;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes11.dex */
public class KZx implements com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx {
    private final yFO JG;
    private boolean ML;
    private final com.bykv.vk.openvk.pA.pA.pA.Og.pA SD;
    private com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.InterfaceC0240pA omh;
    private final pA pA;
    private boolean Og = true;
    private long KZx = 0;
    private boolean ZZv = false;

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean BSW() {
        return false;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public long JG() {
        return 0L;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void KZx(long j) {
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void ML(boolean z) {
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void Og(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public int SD() {
        return 0;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public com.bykv.vk.openvk.pA.pA.pA.ZZv.Og Wx() {
        return null;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void ZZv(boolean z) {
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean aBv() {
        return false;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean oX() {
        return false;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.Og og) {
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv zZv) {
    }

    public KZx(yFO yfo, com.bytedance.sdk.openadsdk.ZZv.SD sd) {
        com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar = new com.bykv.vk.openvk.pA.pA.pA.Og.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.KZx.1
        };
        this.SD = pAVar;
        this.JG = yfo;
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = yfo.Bf();
        long j = 10;
        long jJG = ogBf != null ? (long) ogBf.JG() : 10L;
        if (jJG <= 0) {
            ogBf.pA(10.0d);
        } else {
            j = jJG;
        }
        this.pA = new pA(j * 1000, pAVar, sd);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA() {
        this.pA.SGo();
        DX.pA pAVar = new DX.pA();
        pAVar.pA(ML());
        pAVar.KZx(omh());
        pAVar.Og(JG());
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(this.SD, pAVar);
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.InterfaceC0240pA interfaceC0240pA = this.omh;
        if (interfaceC0240pA != null) {
            interfaceC0240pA.pA(2);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void Og() {
        this.pA.Bzk();
        DX.pA pAVar = new DX.pA();
        pAVar.pA(ML());
        pAVar.KZx(omh());
        pAVar.Og(JG());
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.Og(this.SD, pAVar);
        com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.InterfaceC0240pA interfaceC0240pA = this.omh;
        if (interfaceC0240pA != null) {
            interfaceC0240pA.pA(1);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void KZx() {
        this.pA.BSW();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(boolean z, int i) {
        KZx();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void ZZv() {
        KZx();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx) {
        this.ZZv = kZx.omh();
        if (kZx.SD() > 0) {
            this.pA.pA(kZx.SD());
        }
        com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.pA(this.JG, this.SD, kZx);
        this.pA.Bzk();
        return true;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public long ML() {
        return this.pA.DX();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(long j) {
        this.pA.pA(j);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(boolean z) {
        this.Og = z;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public long omh() {
        return this.pA.Sn();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public long Bzk() {
        return ML();
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public int SGo() {
        return com.bykv.vk.openvk.pA.pA.Og.ML.pA.pA(this.pA.JG, this.pA.pA);
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void Og(long j) {
        this.KZx = j;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public com.bykv.vk.openvk.pA.pA.pA.pA WV() {
        return this.pA;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean Sn() {
        return this.ZZv;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void Og(boolean z) {
        this.ZZv = z;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public boolean DX() {
        return this.ML;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void KZx(boolean z) {
        this.ML = z;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx
    public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar) {
        this.pA.pA(pAVar);
    }

    public com.bykv.vk.openvk.pA.pA.pA.Og.pA XT() {
        return this.SD;
    }

    private static class pA implements com.bykv.vk.openvk.pA.pA.pA.pA {
        private long JG;
        private int KZx = 0;
        private com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA ML;
        private long Og;
        private final com.bykv.vk.openvk.pA.pA.pA.Og.pA SD;
        private CountDownTimer ZZv;
        private final com.bytedance.sdk.openadsdk.ZZv.SD omh;
        private final long pA;

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA
        public boolean KZx() {
            return false;
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA
        public int ML() {
            return 0;
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA
        public boolean Og() {
            return false;
        }

        public long WV() {
            return 0L;
        }

        public int Wx() {
            return 0;
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA
        public int ZZv() {
            return 0;
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA
        public boolean pA() {
            return false;
        }

        public pA(long j, com.bykv.vk.openvk.pA.pA.pA.Og.pA pAVar, com.bytedance.sdk.openadsdk.ZZv.SD sd) {
            this.pA = j;
            this.SD = pAVar;
            this.omh = sd;
        }

        public void Bzk() {
            if (this.KZx == 1) {
                return;
            }
            this.KZx = 1;
            final long jSn = Sn();
            final long j = jSn - this.Og;
            CountDownTimer countDownTimer = new CountDownTimer(j, 200L) { // from class: com.bytedance.sdk.openadsdk.component.reward.KZx.pA.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = (j - j2) + pA.this.Og;
                    pA.this.JG = j3;
                    if (pA.this.ML != null) {
                        pA.this.ML.pA(j3, jSn);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    pA.this.KZx = 4;
                    pA.this.JG = jSn;
                    if (pA.this.ML != null) {
                        pA.this.ML.pA(pA.this.DX(), 100);
                    }
                    DX.pA pAVar = new DX.pA();
                    pAVar.pA(jSn);
                    pAVar.KZx(jSn);
                    pAVar.Og(pA.this.WV());
                    pAVar.ZZv(pA.this.Wx());
                    com.bytedance.sdk.openadsdk.ZZv.ML.pA.pA.Og(pA.this.SD, pAVar, pA.this.omh);
                }
            };
            this.ZZv = countDownTimer;
            countDownTimer.start();
        }

        public void SGo() {
            this.KZx = 2;
            this.Og = this.JG;
            CountDownTimer countDownTimer = this.ZZv;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.ZZv = null;
            }
        }

        public void BSW() {
            this.KZx = 0;
            CountDownTimer countDownTimer = this.ZZv;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.ZZv = null;
            }
            if (this.ML != null) {
                this.ML = null;
            }
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA
        public boolean JG() {
            return this.KZx == 1;
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA
        public boolean SD() {
            return this.KZx == 2;
        }

        @Override // com.bykv.vk.openvk.pA.pA.pA.pA
        public boolean omh() {
            return this.KZx == 0;
        }

        public long Sn() {
            return this.pA;
        }

        public long DX() {
            return this.JG;
        }

        public void pA(long j) {
            this.Og = j;
        }

        public void pA(com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.pA pAVar) {
            this.ML = pAVar;
        }
    }

    public void pA(com.bytedance.sdk.openadsdk.core.Wx.ZZv.pA.InterfaceC0240pA interfaceC0240pA) {
        this.omh = interfaceC0240pA;
    }
}
