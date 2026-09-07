package com.bytedance.adsdk.ugeno.yoga;

import com.facebook.appevents.codeless.internal.Constants;

/* JADX INFO: loaded from: classes12.dex */
public enum DX {
    STATIC(0, "static"),
    RELATIVE(1, "relative"),
    ABSOLUTE(2, Constants.PATH_TYPE_ABSOLUTE);

    private final String ML;
    private final int ZZv;

    DX(int i, String str) {
        this.ZZv = i;
        this.ML = str;
    }

    public int pA() {
        return this.ZZv;
    }

    public static DX pA(int i) {
        if (i == 0) {
            return STATIC;
        }
        if (i == 1) {
            return RELATIVE;
        }
        if (i == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }

    public static DX pA(String str) {
        str.hashCode();
        switch (str) {
            case "static":
                return STATIC;
            case "relative":
                return RELATIVE;
            case "absolute":
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(str)));
        }
    }
}
