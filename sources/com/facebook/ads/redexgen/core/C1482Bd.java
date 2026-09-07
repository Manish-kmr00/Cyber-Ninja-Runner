package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1482Bd {
    public static String[] A01 = {"0TBfSTrFZZIPTbjcv3YvZ5KQe5wh6M4Z", "Y", "skEIHJjGP8F0E9LHs3c03M6jOmkdnZrb", "lNiM6G1VkMzjPhI0VWbHd", "xoZoqEy9j11lJxTnOEXOmkmQN9dBXrj3", "0lNV7cA9G3CxYQK", "ZSiJ5Be21P36sCEypxWEkyax05PjjigP", "3dFveWP5h629GmfNhsyVO5v38YfKmNKK"};
    public static final ThreadLocal<C1482Bd> A02 = new ThreadLocal<>();
    public final BM A00 = new BM();

    public static BM A00() {
        return A02().A00;
    }

    public static BM A01(C1481Bc c1481Bc) {
        BM currentStackTraces = new BM(A00());
        currentStackTraces.add(c1481Bc);
        return currentStackTraces;
    }

    public static C1482Bd A02() {
        C1482Bd c1482Bd = A02.get();
        if (c1482Bd == null) {
            C1482Bd c1482Bd2 = new C1482Bd();
            A02.set(c1482Bd2);
            return c1482Bd2;
        }
        return c1482Bd;
    }

    public static void A03(BY by) {
        BM bmA04 = by.A04();
        if (bmA04 != null) {
            BM createRunnableAsyncStackTrace = A02().A00;
            createRunnableAsyncStackTrace.addAll(bmA04);
        }
    }

    public static void A04(BY by) {
        BM bmA04 = by.A04();
        if (bmA04 != null) {
            BM bm = A02().A00;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[0] = "6tfOksRsBjIBNQljvPHCCYkD1Hr87lb7";
            bm.removeAll(bmA04);
        }
    }
}
