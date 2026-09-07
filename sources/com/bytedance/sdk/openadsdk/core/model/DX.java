package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DX {
    private String JG;
    private int KZx;
    private boolean ML;
    private int Og;
    private double ZZv;
    private String pA;

    public String pA() {
        return this.pA;
    }

    public void pA(String str) {
        this.pA = str;
    }

    public int Og() {
        return this.Og;
    }

    public void pA(int i) {
        this.Og = i;
    }

    public int KZx() {
        return this.KZx;
    }

    public void Og(int i) {
        this.KZx = i;
    }

    public double ZZv() {
        return this.ZZv;
    }

    public boolean ML() {
        return !TextUtils.isEmpty(this.pA) && this.Og > 0 && this.KZx > 0;
    }

    public boolean JG() {
        return this.ML;
    }

    public void pA(boolean z) {
        this.ML = z;
    }

    public String SD() {
        return this.JG;
    }

    public void Og(String str) {
        this.JG = str;
    }
}
