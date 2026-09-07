package com.bytedance.adsdk.Og;

import android.content.Context;
import android.os.Trace;
import java.io.File;

/* JADX INFO: loaded from: classes8.dex */
public class ML {
    private static volatile com.bytedance.adsdk.Og.ZZv.omh BSW = null;
    private static com.bytedance.adsdk.Og.ZZv.JG Bzk = null;
    private static long[] JG = null;
    private static boolean KZx = true;
    private static String[] ML = null;
    private static boolean Og = false;
    private static int SD = 0;
    private static com.bytedance.adsdk.Og.ZZv.ML SGo = null;
    private static volatile com.bytedance.adsdk.Og.ZZv.SD WV = null;
    private static boolean ZZv = true;
    private static int omh;
    public static boolean pA;

    public static void pA(String str) {
        if (Og) {
            int i = SD;
            if (i == 20) {
                omh++;
                return;
            }
            ML[i] = str;
            JG[i] = System.nanoTime();
            Trace.beginSection(str);
            SD++;
        }
    }

    public static float Og(String str) {
        int i = omh;
        if (i > 0) {
            omh = i - 1;
            return 0.0f;
        }
        if (!Og) {
            return 0.0f;
        }
        int i2 = SD - 1;
        SD = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(ML[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + ML[SD] + ".");
        }
        Trace.endSection();
        return (System.nanoTime() - JG[SD]) / 1000000.0f;
    }

    public static com.bytedance.adsdk.Og.ZZv.omh pA(Context context) {
        com.bytedance.adsdk.Og.ZZv.omh omhVar;
        com.bytedance.adsdk.Og.ZZv.omh omhVar2 = BSW;
        if (omhVar2 != null) {
            return omhVar2;
        }
        synchronized (com.bytedance.adsdk.Og.ZZv.omh.class) {
            omhVar = BSW;
            if (omhVar == null) {
                com.bytedance.adsdk.Og.ZZv.SD sdOg = Og(context);
                com.bytedance.adsdk.Og.ZZv.JG og = Bzk;
                if (og == null) {
                    og = new com.bytedance.adsdk.Og.ZZv.Og();
                }
                omhVar = new com.bytedance.adsdk.Og.ZZv.omh(sdOg, og);
                BSW = omhVar;
            }
        }
        return omhVar;
    }

    public static com.bytedance.adsdk.Og.ZZv.SD Og(Context context) {
        com.bytedance.adsdk.Og.ZZv.SD sd;
        if (!KZx) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.Og.ZZv.SD sd2 = WV;
        if (sd2 != null) {
            return sd2;
        }
        synchronized (com.bytedance.adsdk.Og.ZZv.SD.class) {
            sd = WV;
            if (sd == null) {
                com.bytedance.adsdk.Og.ZZv.ML ml = SGo;
                if (ml == null) {
                    ml = new com.bytedance.adsdk.Og.ZZv.ML() { // from class: com.bytedance.adsdk.Og.ML.1
                        @Override // com.bytedance.adsdk.Og.ZZv.ML
                        public File pA() {
                            return new File(applicationContext.getCacheDir(), "lottie_network_cache");
                        }
                    };
                }
                sd = new com.bytedance.adsdk.Og.ZZv.SD(ml);
                WV = sd;
            }
        }
        return sd;
    }

    public static boolean pA() {
        return ZZv;
    }
}
