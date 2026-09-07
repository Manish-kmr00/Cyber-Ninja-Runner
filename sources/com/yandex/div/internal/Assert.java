package com.yandex.div.internal;

import android.os.Looper;

/* JADX INFO: loaded from: classes13.dex */
public class Assert {
    private static AssertionErrorHandler sAssertionErrorHandler = new AssertionErrorHandler() { // from class: com.yandex.div.internal.Assert$$ExternalSyntheticLambda0
        @Override // com.yandex.div.internal.AssertionErrorHandler
        public final void handleError(AssertionError assertionError) {
            Assert.lambda$static$0(assertionError);
        }
    };
    private static volatile boolean sEnabled = false;

    static /* synthetic */ void lambda$static$0(AssertionError assertionError) {
        throw assertionError;
    }

    private Assert() {
    }

    public static boolean isEnabled() {
        return sEnabled;
    }

    public static void setEnabled(boolean z) {
        sEnabled = z;
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

    public static void fail() {
        fail(null);
    }

    public static void fail(String str) {
        if (sEnabled) {
            if (str == null) {
                str = "";
            }
            performFail(new AssertionError(str));
        }
    }

    public static void fail(String str, Throwable th) {
        if (sEnabled) {
            AssertionError assertionError = new AssertionError(str);
            assertionError.initCause(th);
            performFail(assertionError);
        }
    }

    public static void setAssertPerformer(AssertionErrorHandler assertionErrorHandler) {
        sAssertionErrorHandler = assertionErrorHandler;
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return;
        }
        if (obj == null || !obj.equals(obj2)) {
            if ((obj instanceof String) && (obj2 instanceof String)) {
                if (str == null) {
                    str = "";
                }
                performFail(new ComparisonFailure(str, (String) obj, (String) obj2));
                return;
            }
            failNotEquals(str, obj, obj2);
        }
    }

    public static void assertEquals(long j, long j2) {
        assertEquals((String) null, j, j2);
    }

    public static void assertEquals(int i, int i2) {
        assertEquals((String) null, i, i2);
    }

    public static void assertEquals(String str, long j, long j2) {
        assertEquals(str, Long.valueOf(j), Long.valueOf(j2));
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull(null, obj);
    }

    public static void assertNull(String str, Object obj) {
        assertTrue(str, obj == null);
    }

    public static void assertNull(Object obj) {
        assertNull(null, obj);
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

    public static void assertMainThread() {
        assertSame("Code run not in main thread!", Looper.getMainLooper(), Looper.myLooper());
    }

    public static void assertNotMainThread() {
        assertNotSame("Code run in main thread!", Looper.getMainLooper(), Looper.myLooper());
    }

    private static void failSame(String str) {
        String str2;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        fail(str2 + "expected not same");
    }

    private static void failNotSame(String str, Object obj, Object obj2) {
        String str2;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        fail(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    private static void failNotEquals(String str, Object obj, Object obj2) {
        fail(format(str, obj, obj2));
    }

    static String format(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !str.equals("")) {
            str2 = str + " ";
        }
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        if (strValueOf.equals(strValueOf2)) {
            return str2 + "expected: " + formatClassAndValue(obj, strValueOf) + " but was: " + formatClassAndValue(obj2, strValueOf2);
        }
        return str2 + "expected:<" + strValueOf + "> but was:<" + strValueOf2 + ">";
    }

    private static String formatClassAndValue(Object obj, String str) {
        return (obj == null ? "null" : obj.getClass().getName()) + "<" + str + ">";
    }

    private static void performFail(AssertionError assertionError) {
        if (isEnabled()) {
            sAssertionErrorHandler.handleError(assertionError);
        }
    }
}
