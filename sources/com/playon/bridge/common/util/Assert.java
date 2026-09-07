package com.playon.bridge.common.util;

import android.text.TextUtils;
import com.playon.bridge.common.Log;

/* JADX INFO: loaded from: classes11.dex */
public final class Assert {
    private static final String MSG_DEFAULT = "An assertion has occurred.";
    private static final String TAG = Log.makeTag("Assert");

    private Assert() {
    }

    public static void assertTrue(String str, boolean z) {
        if (z) {
            return;
        }
        fail(str);
    }

    public static void assertTrue(boolean z) {
        assertTrue(null, z);
    }

    public static void assertFalse(String str, boolean z) {
        assertTrue(str, !z);
    }

    public static void assertFalse(boolean z) {
        assertFalse(null, z);
    }

    public static void fail(String str) {
        android.util.Log.wtf(TAG, str);
    }

    public static void fail() {
        fail(MSG_DEFAULT);
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return;
        }
        if (obj == null || !obj.equals(obj2)) {
            failNotEquals(str, obj, obj2);
        }
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void assertEquals(String str, String str2, String str3) {
        if ((str2 == null && str3 == null) || str2 == null) {
            return;
        }
        str2.equals(str3);
    }

    public static void assertEquals(String str, String str2) {
        assertEquals((String) null, str, str2);
    }

    public static void assertEquals(String str, double d, double d2, double d3) {
        if (Double.compare(d, d2) != 0 && Math.abs(d - d2) > d3) {
            failNotEquals(str, Double.valueOf(d), Double.valueOf(d2));
        }
    }

    public static void assertEquals(double d, double d2, double d3) {
        assertEquals((String) null, d, d2, d3);
    }

    public static void assertEquals(String str, float f, float f2, float f3) {
        if (Float.compare(f, f2) != 0 && Math.abs(f - f2) > f3) {
            failNotEquals(str, Float.valueOf(f), Float.valueOf(f2));
        }
    }

    public static void assertEquals(float f, float f2, float f3) {
        assertEquals((String) null, f, f2, f3);
    }

    public static void assertEquals(String str, long j, long j2) {
        assertEquals(str, Long.valueOf(j), Long.valueOf(j2));
    }

    public static void assertEquals(long j, long j2) {
        assertEquals((String) null, j, j2);
    }

    public static void assertEquals(String str, boolean z, boolean z2) {
        assertEquals(str, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public static void assertEquals(boolean z, boolean z2) {
        assertEquals((String) null, z, z2);
    }

    public static void assertEquals(String str, byte b, byte b2) {
        assertEquals(str, Byte.valueOf(b), Byte.valueOf(b2));
    }

    public static void assertEquals(byte b, byte b2) {
        assertEquals((String) null, b, b2);
    }

    public static void assertEquals(String str, char c, char c2) {
        assertEquals(str, Character.valueOf(c), Character.valueOf(c2));
    }

    public static void assertEquals(char c, char c2) {
        assertEquals((String) null, c, c2);
    }

    public static void assertEquals(String str, short s, short s2) {
        assertEquals(str, Short.valueOf(s), Short.valueOf(s2));
    }

    public static void assertEquals(short s, short s2) {
        assertEquals((String) null, s, s2);
    }

    public static void assertEquals(String str, int i, int i2) {
        assertEquals(str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void assertEquals(int i, int i2) {
        assertEquals((String) null, i, i2);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull(null, obj);
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNull(Object obj) {
        if (obj != null) {
            assertNull("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    public static void assertNull(String str, Object obj) {
        assertTrue(str, obj == null);
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        failNotSame(str, obj, obj2);
    }

    public static void assertSame(Object obj, Object obj2) {
        assertSame(null, obj, obj2);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            failSame(str);
        }
    }

    public static void assertNotSame(Object obj, Object obj2) {
        assertNotSame(null, obj, obj2);
    }

    public static void failSame(String str) {
        fail((str != null ? str + " " : "") + "expected not same");
    }

    public static void failNotSame(String str, Object obj, Object obj2) {
        fail((str != null ? str + " " : "") + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    public static void failNotEquals(String str, Object obj, Object obj2) {
        fail(format(str, obj, obj2));
    }

    public static String format(String str, Object obj, Object obj2) {
        String str2;
        if (str != null && str.length() > 0) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }

    public static void fail(String str, String str2) {
        fail(str + ": " + str2);
    }

    public static void failUnhandledValue(String str, Enum<?> r2) {
        failUnhandledValue(str, r2 == null ? "null" : r2.toString(), (String) null);
    }

    public static void failUnhandledValue(String str, int i) {
        failUnhandledValue(str, String.valueOf(i), (String) null);
    }

    public static void failUnhandledValue(String str, String str2) {
        failUnhandledValue(str, str2, (String) null);
    }

    public static void failUnhandledValue(String str, Enum<?> r1, String str2) {
        failUnhandledValue(str, r1 == null ? "null" : r1.toString(), str2);
    }

    public static void failUnhandledValue(String str, int i, String str2) {
        failUnhandledValue(str, String.valueOf(i), str2);
    }

    public static void failUnhandledValue(String str, String str2, String str3) {
        String str4 = str + " - Unhandled value: " + str2;
        if (!TextUtils.isEmpty(str3)) {
            str4 = str4 + " - " + str3;
        }
        fail(str4);
    }

    public static void fail(Exception exc) {
        fail("Exception=" + exc);
    }

    public static void fail(String str, Exception exc) {
        exc.printStackTrace();
        fail(str + " Exception=" + exc);
    }
}
