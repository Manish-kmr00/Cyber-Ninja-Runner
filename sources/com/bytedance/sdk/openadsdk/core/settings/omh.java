package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class omh implements Comparable<omh> {
    private final int JG;
    private final int KZx;
    private String ML;
    private final String Og;
    private final int SD;
    private final int ZZv;
    private final String omh;
    private final String pA;

    public omh(String str, String str2, int i, int i2, String str3, int i3, int i4, String str4) {
        this.pA = str;
        this.Og = str2;
        this.KZx = i;
        this.ZZv = i2;
        this.ML = str3;
        if (TextUtils.isEmpty(str3)) {
            this.ML = "0";
        }
        this.JG = i3;
        this.SD = i4;
        this.omh = str4;
    }

    public int pA() {
        return this.JG;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public int compareTo(omh omhVar) {
        if (this.JG < omhVar.pA()) {
            return -1;
        }
        return this.JG == omhVar.pA() ? 0 : 1;
    }
}
