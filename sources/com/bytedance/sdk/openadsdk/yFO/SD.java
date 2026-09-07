package com.bytedance.sdk.openadsdk.yFO;

/* JADX INFO: loaded from: classes10.dex */
public class SD {
    private static pA pA;

    public interface pA {
        void pA(String str, String str2, Throwable th);
    }

    public static void pA(pA pAVar) {
        pA = pAVar;
    }

    public static boolean pA() {
        return pA != null;
    }

    public static void pA(String str, String str2, Throwable th) {
        if (pA == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        pA.pA(str, str2, th);
    }
}
