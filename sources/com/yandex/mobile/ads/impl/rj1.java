package com.yandex.mobile.ads.impl;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes10.dex */
public final class rj1 {
    public static void b(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(a(i, i2, "index"));
        }
    }

    private static String a(int i, int i2, String str) {
        if (i < 0) {
            return b32.a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return b32.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(oe.a("negative size: ", i2));
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void a(int i, int i2) {
        String strA;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                strA = b32.a("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else if (i2 >= 0) {
                strA = b32.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                throw new IllegalArgumentException(oe.a("negative size: ", i2));
            }
            throw new IndexOutOfBoundsException(strA);
        }
    }

    public static <T> T a(@CheckForNull T t) {
        t.getClass();
        return t;
    }

    public static void a(int i, int i2, int i3) {
        String strA;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strA = a(i, i3, "start index");
            } else if (i2 >= 0 && i2 <= i3) {
                strA = b32.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            } else {
                strA = a(i2, i3, "end index");
            }
            throw new IndexOutOfBoundsException(strA);
        }
    }
}
