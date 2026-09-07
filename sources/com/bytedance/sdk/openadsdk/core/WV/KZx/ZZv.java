package com.bytedance.sdk.openadsdk.core.WV.KZx;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class ZZv {
    public static final List<String> pA = Arrays.asList("video/mp4", "video/3gpp");

    public static double pA(int i, double d, int i2, int i3, int i4, String str) {
        double dPA = pA(i, d, i2, i3);
        return pA(str) * (1.0d / ((dPA + 1.0d) + pA(i4)));
    }

    private static double pA(int i, double d, int i2, int i3) {
        return (d > 0.0d ? Math.abs(d - (i3 > 0 ? ((double) i2) / ((double) i3) : 0.0d)) : 0.0d) + (i > 0 ? Math.abs((i - i2) / i) : 0.0d);
    }

    private static double pA(int i) {
        int iMax = Math.max(i, 0);
        if (700 > iMax || iMax > 1500) {
            return Math.min(Math.abs(700 - iMax) / 700.0f, Math.abs(1500 - iMax) / 1500.0f);
        }
        return 0.0d;
    }

    private static double pA(String str) {
        if (str == null) {
            str = "";
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -1664118616) {
            return (iHashCode == 1331848029 && str.equals("video/mp4")) ? 1.5d : 1.0d;
        }
        str.equals("video/3gpp");
        return 1.0d;
    }
}
