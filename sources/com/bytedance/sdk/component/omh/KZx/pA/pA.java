package com.bytedance.sdk.component.omh.KZx.pA;

import android.text.TextUtils;
import com.bytedance.sdk.component.omh.KZx.Og;

/* JADX INFO: loaded from: classes5.dex */
public class pA {
    private long JG;
    private long KZx;
    private long ML;
    private int Og = 0;
    private long ZZv;
    private String pA;

    public String pA() {
        return this.pA;
    }

    public int Og() {
        return this.Og;
    }

    public long KZx() {
        return this.KZx;
    }

    public long ZZv() {
        return this.ZZv;
    }

    public long ML() {
        return this.ML;
    }

    public long JG() {
        return this.JG;
    }

    public void pA(Og og) {
        synchronized (this) {
            if (TextUtils.isEmpty(this.pA)) {
                this.pA = og.Og();
            }
            this.KZx += og.JG();
            this.ZZv += og.SD();
            this.ML = Math.max(this.ML, og.JG());
            this.JG = Math.max(this.JG, og.SD());
            this.Og++;
        }
        new Object[]{"recordTask: task wait=", Long.valueOf(og.JG()), "  run=", Long.valueOf(og.SD()), toString()};
    }

    public String toString() {
        return this.pA + " times=" + this.Og + ",waitMaxTime=" + this.ML + ",runMaxTime=" + this.JG + ",runTotalTime=" + this.ZZv + ",waitTotalTime=" + this.KZx;
    }
}
