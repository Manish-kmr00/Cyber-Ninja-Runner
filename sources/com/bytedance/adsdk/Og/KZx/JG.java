package com.bytedance.adsdk.Og.KZx;

/* JADX INFO: loaded from: classes3.dex */
public class JG {
    private final String KZx;
    public final float Og;
    public final float pA;

    public JG(String str, float f, float f2) {
        this.KZx = str;
        this.Og = f2;
        this.pA = f;
    }

    public boolean pA(String str) {
        if (this.KZx.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.KZx.endsWith("\r")) {
            String str2 = this.KZx;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
