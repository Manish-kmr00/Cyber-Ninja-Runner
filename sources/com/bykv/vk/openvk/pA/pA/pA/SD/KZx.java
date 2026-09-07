package com.bykv.vk.openvk.pA.pA.pA.SD;

/* JADX INFO: loaded from: classes5.dex */
public class KZx {
    private static String KZx = "";
    private static int Og = 4;
    private static boolean pA;

    public static void pA(String str) {
        KZx = str;
    }

    public static void pA(int i) {
        Og = i;
    }

    public static void pA() {
        pA = true;
        pA(3);
    }

    public static void Og() {
        pA = false;
        pA(7);
    }

    public static boolean KZx() {
        return pA;
    }
}
