package com.pgl.ssdk;

/* JADX INFO: loaded from: classes9.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7520a = -1;

    public static void a(int i) {
        f7520a = i;
    }

    public static String b() {
        int i = f7520a;
        if (i != 0) {
            return i != 1 ? "" : "https://ssdk-va.pangle.io/ssdk/sd/token";
        }
        return "https://ssdk-sg.pangle.io/ssdk/sd/token";
    }

    public static String a() {
        int i = f7520a;
        if (i != 0) {
            return i != 1 ? "" : "https://ssdk-va.pangle.io/ssdk/v2/r";
        }
        return "https://ssdk-sg.pangle.io/ssdk/v2/r";
    }
}
