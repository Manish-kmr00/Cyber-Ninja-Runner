package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.utils.qmB;

/* JADX INFO: loaded from: classes13.dex */
public class du {
    private int BSW;
    private long Bzk;
    private long JG;
    private long ML;
    public long Og;
    private long SD;
    private long SGo;
    private long omh;
    public boolean pA;
    private qmB KZx = qmB.KZx();
    private qmB ZZv = qmB.KZx();

    public void pA(qmB qmb, qmB qmb2, int i, qmB qmb3) {
        this.ML = qmb.pA(this.KZx);
        this.JG = qmb2.pA(qmb);
        this.SD = i;
        this.omh = qmb3.pA(qmb2);
    }

    public void pA(qmB qmb) {
        this.KZx = qmb;
    }

    public void Og(qmB qmb) {
        this.ZZv = qmb;
        this.Bzk = qmb.pA(this.KZx);
    }

    public qmB pA() {
        return this.KZx;
    }

    public long Og() {
        return this.ML;
    }

    public long KZx() {
        return this.JG;
    }

    public long ZZv() {
        return this.SD;
    }

    public long ML() {
        return this.omh;
    }

    public long JG() {
        return this.Bzk;
    }

    public long SD() {
        return this.SGo;
    }

    public void pA(long j) {
        this.SGo = j;
    }

    public int omh() {
        return this.BSW;
    }

    public void pA(int i) {
        this.BSW = i;
    }
}
