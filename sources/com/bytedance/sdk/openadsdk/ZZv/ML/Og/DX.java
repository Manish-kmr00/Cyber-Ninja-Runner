package com.bytedance.sdk.openadsdk.ZZv.ML.Og;

import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes2.dex */
public class DX {
    private int KZx;
    private yFO ML;
    private String Og;
    private com.bykv.vk.openvk.pA.pA.pA.KZx.KZx ZZv;
    private long pA;

    public DX(long j, String str, int i, com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, yFO yfo) {
        this.pA = j;
        this.Og = str;
        this.KZx = i;
        this.ZZv = kZx;
        this.ML = yfo;
    }

    public long pA() {
        return this.pA;
    }

    public String Og() {
        return this.Og;
    }

    public int KZx() {
        return this.KZx;
    }

    public com.bykv.vk.openvk.pA.pA.pA.KZx.KZx ZZv() {
        return this.ZZv;
    }

    public yFO ML() {
        return this.ML;
    }

    public static class pA {
        private com.bykv.vk.openvk.pA.pA.pA.KZx.pA BSW;
        private int Bzk;
        private int JG;
        private int ML;
        private int SD;
        private int omh;
        private long pA = 0;
        private long Og = 0;
        private long KZx = 0;
        private boolean ZZv = false;
        private boolean SGo = false;

        public long pA() {
            return this.pA;
        }

        public void pA(long j) {
            this.pA = j;
            Wx();
        }

        private void Wx() {
            long j = this.KZx;
            if (j > 0) {
                long j2 = this.pA;
                if (j2 > j) {
                    long j3 = j2 % j;
                    this.pA = j3;
                    if (j3 == 0) {
                        this.pA = j;
                    }
                }
            }
        }

        public long Og() {
            return this.Og;
        }

        public void Og(long j) {
            this.Og = j;
        }

        public long KZx() {
            return this.KZx;
        }

        public void KZx(long j) {
            this.KZx = j;
            Wx();
        }

        public int ZZv() {
            return this.ML;
        }

        public void pA(int i) {
            this.ML = i;
        }

        public int ML() {
            return this.JG;
        }

        public void Og(int i) {
            this.JG = i;
        }

        public int JG() {
            long j = this.KZx;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.pA * 100) / j), 100);
        }

        public int SD() {
            return this.SD;
        }

        public void KZx(int i) {
            this.SD = i;
        }

        public int omh() {
            return this.omh;
        }

        public int Bzk() {
            return this.Bzk;
        }

        public void ZZv(int i) {
            this.Bzk = i;
        }

        public boolean SGo() {
            return this.SGo;
        }

        public boolean BSW() {
            return this.ZZv;
        }

        public void pA(boolean z) {
            this.ZZv = z;
        }

        public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.pA pAVar) {
            this.BSW = pAVar;
        }

        public com.bykv.vk.openvk.pA.pA.pA.KZx.pA WV() {
            return this.BSW;
        }
    }
}
