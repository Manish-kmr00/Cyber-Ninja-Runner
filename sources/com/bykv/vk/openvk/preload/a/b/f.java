package com.bykv.vk.openvk.preload.a.b;

import java.math.BigDecimal;

/* JADX INFO: compiled from: LazilyParsedNumber.java */
/* JADX INFO: loaded from: classes9.dex */
public final class f extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f868a;

    public f(String str) {
        this.f868a = str;
    }

    @Override // java.lang.Number
    public final int intValue() {
        try {
            try {
                return Integer.parseInt(this.f868a);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f868a).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(this.f868a);
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        try {
            return Long.parseLong(this.f868a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f868a).longValue();
        }
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f868a);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f868a);
    }

    public final String toString() {
        return this.f868a;
    }

    public final int hashCode() {
        return this.f868a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        String str = this.f868a;
        String str2 = ((f) obj).f868a;
        return str == str2 || str.equals(str2);
    }
}
