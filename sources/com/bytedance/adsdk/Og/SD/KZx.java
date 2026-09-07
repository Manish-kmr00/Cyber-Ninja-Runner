package com.bytedance.adsdk.Og.SD;

import io.bidmachine.iab.vast.tags.VastAttributes;

/* JADX INFO: loaded from: classes4.dex */
public class KZx {
    private float Og;
    private float pA;

    public KZx(float f, float f2) {
        this.pA = f;
        this.Og = f2;
    }

    public KZx() {
        this(1.0f, 1.0f);
    }

    public float pA() {
        return this.pA;
    }

    public float Og() {
        return this.Og;
    }

    public void pA(float f, float f2) {
        this.pA = f;
        this.Og = f2;
    }

    public boolean Og(float f, float f2) {
        return this.pA == f && this.Og == f2;
    }

    public String toString() {
        return pA() + VastAttributes.HORIZONTAL_POSITION + Og();
    }
}
