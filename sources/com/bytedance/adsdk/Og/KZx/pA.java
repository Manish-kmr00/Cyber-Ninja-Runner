package com.bytedance.adsdk.Og.KZx;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes12.dex */
public class pA {
    private final PointF KZx;
    private final PointF Og;
    private final PointF pA;

    public pA() {
        this.pA = new PointF();
        this.Og = new PointF();
        this.KZx = new PointF();
    }

    public pA(PointF pointF, PointF pointF2, PointF pointF3) {
        this.pA = pointF;
        this.Og = pointF2;
        this.KZx = pointF3;
    }

    public void pA(float f, float f2) {
        this.pA.set(f, f2);
    }

    public PointF pA() {
        return this.pA;
    }

    public void Og(float f, float f2) {
        this.Og.set(f, f2);
    }

    public PointF Og() {
        return this.Og;
    }

    public void KZx(float f, float f2) {
        this.KZx.set(f, f2);
    }

    public PointF KZx() {
        return this.KZx;
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.KZx.x), Float.valueOf(this.KZx.y), Float.valueOf(this.pA.x), Float.valueOf(this.pA.y), Float.valueOf(this.Og.x), Float.valueOf(this.Og.y));
    }
}
