package com.bytedance.sdk.component.JG.pA.ZZv.Og;

/* JADX INFO: loaded from: classes10.dex */
public class pA {
    private int Og;
    private int pA;

    public int pA() {
        return this.pA;
    }

    public int Og() {
        return this.Og;
    }

    pA(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.pA = i;
        this.Og = i2;
    }

    public static pA KZx() {
        return new pA(1, 100, 172800000L);
    }

    public static pA ZZv() {
        return new pA(1, 100, -1L);
    }

    public static pA ML() {
        return new pA(3, 100, 172800000L);
    }
}
