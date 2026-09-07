package com.yandex.div.internal;

import com.yandex.div.logging.Severity;

/* JADX INFO: loaded from: classes6.dex */
public class Log {
    private static volatile boolean sEnabled;
    private static volatile Severity sSeverity = Severity.VERBOSE;

    private Log() {
    }

    public static boolean isEnabled() {
        return sEnabled;
    }

    public static void setEnabled(Boolean bool) {
        sEnabled = bool.booleanValue();
    }

    public static Severity getSeverity() {
        return sSeverity;
    }

    public static void setSeverity(Severity severity) {
        sSeverity = severity;
    }

    public static void v(String str, String str2) {
        if (isAtLeast(Severity.VERBOSE)) {
            android.util.Log.v(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (isAtLeast(Severity.VERBOSE)) {
            android.util.Log.v(str, str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (isAtLeast(Severity.DEBUG)) {
            android.util.Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (isAtLeast(Severity.DEBUG)) {
            android.util.Log.d(str, str2, th);
        }
    }

    public static void w(String str, String str2) {
        if (isAtLeast(Severity.WARNING)) {
            android.util.Log.w(str, str2);
        }
    }

    public static void w(String str, Throwable th) {
        if (isAtLeast(Severity.WARNING)) {
            android.util.Log.w(str, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (isAtLeast(Severity.WARNING)) {
            android.util.Log.w(str, str2, th);
        }
    }

    public static void i(String str, String str2) {
        if (isAtLeast(Severity.INFO)) {
            android.util.Log.i(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (isAtLeast(Severity.INFO)) {
            android.util.Log.i(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (isAtLeast(Severity.ERROR)) {
            android.util.Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isAtLeast(Severity.ERROR)) {
            android.util.Log.e(str, str2, th);
        }
    }

    static boolean isAtLeast(Severity severity) {
        if (isEnabled()) {
            return sSeverity.isAtLeast(severity);
        }
        return false;
    }
}
