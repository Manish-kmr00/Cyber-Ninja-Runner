package com.bytedance.sdk.component.adexpress.pA.pA;

import com.bytedance.sdk.component.ML.DX;

/* JADX INFO: loaded from: classes10.dex */
public class pA {
    private static pA ML = new pA();
    private volatile ML JG;
    private volatile KZx KZx;
    private volatile ZZv Og;
    private volatile DX ZZv;
    private volatile Og pA;

    private pA() {
    }

    public static pA pA() {
        return ML;
    }

    public void pA(Og og) {
        this.pA = og;
    }

    public Og Og() {
        return this.pA;
    }

    public void pA(KZx kZx) {
        this.KZx = kZx;
    }

    public KZx KZx() {
        return this.KZx;
    }

    public void pA(ZZv zZv) {
        this.Og = zZv;
    }

    public ZZv ZZv() {
        return this.Og;
    }

    public void pA(DX dx) {
        this.ZZv = dx;
    }

    public DX ML() {
        return this.ZZv;
    }

    public ML JG() {
        return this.JG;
    }
}
