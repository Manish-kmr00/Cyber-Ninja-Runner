package com.bytedance.sdk.openadsdk.core.model;

/* JADX INFO: loaded from: classes12.dex */
public class XT {
    private long pA = 10000;
    private long Og = 10000;
    private long KZx = 10;
    private long ZZv = 20;
    private String ML = "";

    public long pA() {
        return this.pA;
    }

    public void pA(long j) {
        if (j <= 0) {
            this.pA = 10L;
        } else {
            this.pA = j;
        }
    }

    public long Og() {
        return this.Og;
    }

    public void Og(long j) {
        if (j < 0) {
            this.Og = 20L;
        } else {
            this.Og = j;
        }
    }

    public long KZx() {
        return this.KZx;
    }

    public void KZx(long j) {
        if (j <= 0) {
            this.KZx = 10L;
        } else {
            this.KZx = j;
        }
    }

    public long ZZv() {
        return this.ZZv;
    }

    public void ZZv(long j) {
        if (j < 0) {
            this.ZZv = 20L;
        } else {
            this.ZZv = j;
        }
    }

    public String ML() {
        return this.ML;
    }

    public void pA(String str) {
        this.ML = str;
    }
}
