package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;

/* JADX INFO: loaded from: classes7.dex */
public class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f422a;
    private final MaxAdFormat b;

    public g3(String str, MaxAdFormat maxAdFormat) {
        this.f422a = str;
        this.b = maxAdFormat;
    }

    protected boolean a(Object obj) {
        return obj instanceof g3;
    }

    public String b() {
        return this.f422a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g3)) {
            return false;
        }
        g3 g3Var = (g3) obj;
        if (!g3Var.a(this)) {
            return false;
        }
        String strB = b();
        String strB2 = g3Var.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        MaxAdFormat maxAdFormatA = a();
        MaxAdFormat maxAdFormatA2 = g3Var.a();
        return maxAdFormatA != null ? maxAdFormatA.equals(maxAdFormatA2) : maxAdFormatA2 == null;
    }

    public int hashCode() {
        String strB = b();
        int iHashCode = strB == null ? 43 : strB.hashCode();
        MaxAdFormat maxAdFormatA = a();
        return ((iHashCode + 59) * 59) + (maxAdFormatA != null ? maxAdFormatA.hashCode() : 43);
    }

    public String toString() {
        return this.f422a + "-" + this.b.getLabel();
    }

    public MaxAdFormat a() {
        return this.b;
    }

    public static g3 a(String str) {
        String[] strArrSplit = str.split("-");
        return new g3(strArrSplit[0], MaxAdFormat.formatFromString(strArrSplit[1]));
    }
}
