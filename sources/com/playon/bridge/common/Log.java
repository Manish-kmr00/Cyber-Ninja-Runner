package com.playon.bridge.common;

/* JADX INFO: loaded from: classes11.dex */
public final class Log {
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "PlayOn_";
    private static final int TAG_PREFIX_LENGTH = TAG_PREFIX.length();
    public static LogLevel level = LogLevel.None;

    public enum LogLevel {
        None,
        Info,
        Debug
    }

    private Log() {
    }

    public static String makeTag(String str) {
        int length = str.length();
        int i = TAG_PREFIX_LENGTH;
        if (length > 23 - i) {
            return TAG_PREFIX + str.substring(0, 22 - i);
        }
        return TAG_PREFIX + str;
    }

    public static void d(String str, Object... objArr) {
        if (level.ordinal() >= LogLevel.Debug.ordinal()) {
            log(str, 4, null, objArr);
        }
    }

    public static void i(String str, Object... objArr) {
        if (level.ordinal() >= LogLevel.Info.ordinal()) {
            log(str, 4, null, objArr);
        }
    }

    public static void w(String str, Object... objArr) {
        if (level.ordinal() >= LogLevel.Debug.ordinal()) {
            log(str, 5, null, objArr);
        }
    }

    public static void w(String str, Throwable th, Object... objArr) {
        if (level.ordinal() >= LogLevel.Debug.ordinal()) {
            log(str, 5, th, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        if (level.ordinal() >= LogLevel.Info.ordinal()) {
            log(str, 6, null, objArr);
        }
    }

    public static void e(String str, Throwable th, Object... objArr) {
        if (level.ordinal() >= LogLevel.Info.ordinal()) {
            log(str, 6, th, objArr);
        }
    }

    public static void log(String str, int i, Throwable th, Object... objArr) {
        String string;
        if (android.util.Log.isLoggable(str, i)) {
            if (th == null && objArr != null && objArr.length == 1) {
                string = objArr[0].toString();
            } else {
                StringBuilder sb = new StringBuilder();
                if (objArr != null) {
                    for (Object obj : objArr) {
                        sb.append(obj);
                    }
                }
                if (th != null) {
                    sb.append("\n").append(android.util.Log.getStackTraceString(th));
                }
                string = sb.toString();
            }
            android.util.Log.println(i, str, string);
        }
    }
}
