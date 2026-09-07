package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes.dex */
public enum SGo {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    private final int ZZv;

    SGo(int i) {
        this.ZZv = i;
    }

    public static SGo pA(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return EXACTLY;
        }
        if (i == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
