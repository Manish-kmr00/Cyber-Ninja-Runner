package com.bytedance.sdk.component.JG.pA;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    private int BSW;
    private ML Bzk;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA JG;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA KZx;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA ML;
    private com.bytedance.sdk.component.JG.pA.Og.KZx Og;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA SD;
    private boolean SGo;
    private int WV;
    private long Wx;
    private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA ZZv;
    private boolean omh;
    private com.bytedance.sdk.component.JG.pA.pA.ML pA;

    private pA() {
        this.BSW = 200;
        this.WV = 10;
    }

    public com.bytedance.sdk.component.JG.pA.pA.ML pA() {
        return this.pA;
    }

    public com.bytedance.sdk.component.JG.pA.ZZv.Og.pA Og() {
        return this.JG;
    }

    public boolean KZx() {
        return this.SGo;
    }

    public ML ZZv() {
        return this.Bzk;
    }

    public long ML() {
        return this.Wx;
    }

    public com.bytedance.sdk.component.JG.pA.ZZv.Og.pA JG() {
        return this.SD;
    }

    public com.bytedance.sdk.component.JG.pA.ZZv.Og.pA SD() {
        return this.KZx;
    }

    public com.bytedance.sdk.component.JG.pA.ZZv.Og.pA omh() {
        return this.ZZv;
    }

    public com.bytedance.sdk.component.JG.pA.ZZv.Og.pA Bzk() {
        return this.ML;
    }

    public com.bytedance.sdk.component.JG.pA.Og.KZx SGo() {
        return this.Og;
    }

    public boolean BSW() {
        return this.omh;
    }

    public int WV() {
        return this.BSW;
    }

    public int Wx() {
        return this.WV;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.JG.pA.pA$pA, reason: collision with other inner class name */
    public static class C0188pA {
        private boolean Bzk;
        private boolean JG;
        private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA KZx;
        private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA ML;
        private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA Og;
        private ML SD;
        private long WV;
        private com.bytedance.sdk.component.JG.pA.ZZv.Og.pA ZZv;
        private com.bytedance.sdk.component.JG.pA.pA.ML omh;
        private com.bytedance.sdk.component.JG.pA.Og.KZx pA;
        private int SGo = 5000;
        private int BSW = 10;

        public C0188pA pA(long j) {
            this.WV = j;
            return this;
        }

        public C0188pA pA(com.bytedance.sdk.component.JG.pA.pA.ML ml) {
            this.omh = ml;
            return this;
        }

        public C0188pA pA(ML ml) {
            this.SD = ml;
            return this;
        }

        public C0188pA pA(boolean z) {
            this.JG = z;
            return this;
        }

        public C0188pA pA(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
            this.Og = pAVar;
            return this;
        }

        public C0188pA Og(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
            this.KZx = pAVar;
            return this;
        }

        public C0188pA KZx(com.bytedance.sdk.component.JG.pA.ZZv.Og.pA pAVar) {
            this.ZZv = pAVar;
            return this;
        }

        public C0188pA pA(com.bytedance.sdk.component.JG.pA.Og.KZx kZx) {
            this.pA = kZx;
            return this;
        }

        public C0188pA pA(int i) {
            this.SGo = i;
            return this;
        }

        public C0188pA Og(int i) {
            this.BSW = i;
            return this;
        }

        public pA pA() {
            pA pAVar = new pA();
            pAVar.Og = this.pA;
            pAVar.KZx = this.Og;
            pAVar.ZZv = this.KZx;
            pAVar.ML = this.ZZv;
            pAVar.JG = this.ML;
            pAVar.omh = this.JG;
            pAVar.Bzk = this.SD;
            pAVar.pA = this.omh;
            pAVar.SGo = this.Bzk;
            pAVar.WV = this.BSW;
            pAVar.BSW = this.SGo;
            pAVar.Wx = this.WV;
            return pAVar;
        }
    }
}
