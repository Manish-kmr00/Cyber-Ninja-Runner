package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes12.dex */
public class TTImage {
    private final String KZx;
    private final int Og;
    private double ZZv;
    private final int pA;

    public TTImage(int i, int i2, String str, double d) {
        this.pA = i;
        this.Og = i2;
        this.KZx = str;
        this.ZZv = d;
    }

    public TTImage(int i, int i2, String str) {
        this(i, i2, str, 0.0d);
    }

    public int getHeight() {
        return this.pA;
    }

    public int getWidth() {
        return this.Og;
    }

    public String getImageUrl() {
        return this.KZx;
    }

    public double getDuration() {
        return this.ZZv;
    }

    public boolean isValid() {
        String str;
        return this.pA > 0 && this.Og > 0 && (str = this.KZx) != null && str.length() > 0;
    }
}
