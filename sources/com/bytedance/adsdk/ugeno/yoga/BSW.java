package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes8.dex */
public class BSW {
    public static long pA(float f, float f2) {
        return ((long) Float.floatToRawIntBits(f2)) | (((long) Float.floatToRawIntBits(f)) << 32);
    }

    public static long pA(int i, int i2) {
        return pA(i, i2);
    }
}
