package com.bytedance.adsdk.Og.KZx;

import com.bytedance.adsdk.Og.KZx.Og.oX;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ZZv {
    private final String JG;
    private final double KZx;
    private final String ML;
    private final char Og;
    private final double ZZv;
    private final List<oX> pA;

    public static int pA(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public ZZv(List<oX> list, char c, double d, double d2, String str, String str2) {
        this.pA = list;
        this.Og = c;
        this.KZx = d;
        this.ZZv = d2;
        this.ML = str;
        this.JG = str2;
    }

    public List<oX> pA() {
        return this.pA;
    }

    public double Og() {
        return this.ZZv;
    }

    public int hashCode() {
        return pA(this.Og, this.JG, this.ML);
    }
}
