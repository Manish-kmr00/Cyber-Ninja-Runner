package com.bytedance.adsdk.Og.JG;

/* JADX INFO: loaded from: classes8.dex */
public class Og {
    private static float pA(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float Og(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int pA(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fOg = Og(((i >> 16) & 255) / 255.0f);
        float fOg2 = Og(((i >> 8) & 255) / 255.0f);
        float fOg3 = Og((i & 255) / 255.0f);
        float fOg4 = Og(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fOg5 = fOg2 + ((Og(((i2 >> 8) & 255) / 255.0f) - fOg2) * f);
        float fOg6 = fOg3 + (f * (Og((i2 & 255) / 255.0f) - fOg3));
        return (Math.round(pA(fOg + ((fOg4 - fOg) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(pA(fOg5) * 255.0f) << 8) | Math.round(pA(fOg6) * 255.0f);
    }
}
