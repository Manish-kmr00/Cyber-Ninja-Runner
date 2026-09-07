package com.bytedance.adsdk.Og.KZx;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes5.dex */
public class Og {
    public boolean BSW;
    public int Bzk;
    public float JG;
    public float KZx;
    public int ML;
    public String Og;
    public float SD;
    public float SGo;
    public PointF WV;
    public PointF Wx;
    public pA ZZv;
    public int omh;
    public String pA;

    public enum pA {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public Og(String str, String str2, float f, pA pAVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        pA(str, str2, f, pAVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2);
    }

    public Og() {
    }

    public void pA(String str, String str2, float f, pA pAVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.pA = str;
        this.Og = str2;
        this.KZx = f;
        this.ZZv = pAVar;
        this.ML = i;
        this.JG = f2;
        this.SD = f3;
        this.omh = i2;
        this.Bzk = i3;
        this.SGo = f4;
        this.BSW = z;
        this.WV = pointF;
        this.Wx = pointF2;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.pA.hashCode() * 31) + this.Og.hashCode()) * 31) + this.KZx)) * 31) + this.ZZv.ordinal()) * 31) + this.ML;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.JG);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.omh;
    }
}
