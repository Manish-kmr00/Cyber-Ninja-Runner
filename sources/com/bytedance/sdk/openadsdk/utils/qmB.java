package com.bytedance.sdk.openadsdk.utils;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes5.dex */
public class qmB {
    private long Og;
    public long pA;

    public long pA() {
        return this.Og;
    }

    private qmB(boolean z) {
        if (z) {
            ML();
        }
    }

    public static qmB Og() {
        return new qmB(true);
    }

    public static qmB KZx() {
        return new qmB(false);
    }

    public long ZZv() {
        return SystemClock.elapsedRealtime() - this.Og;
    }

    public long pA(qmB qmb) {
        return Math.abs(qmb.Og - this.Og);
    }

    public void ML() {
        this.pA = System.currentTimeMillis();
        this.Og = SystemClock.elapsedRealtime();
    }

    public boolean JG() {
        return this.Og > 0;
    }

    public String toString() {
        return String.valueOf(this.pA);
    }
}
