package io.bidmachine.iab.utils;

/* JADX INFO: loaded from: classes13.dex */
public class CommonLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f12237a = new Logger("CommonLog");

    public static boolean canSendDLog() {
        return f12237a.canSendDLog();
    }

    public static boolean canSendELog() {
        return f12237a.canSendELog();
    }

    public static boolean canSendWLog() {
        return f12237a.canSendWLog();
    }

    public static void d(String subTag, String message, Object... args) {
        f12237a.d(subTag, message, args);
    }

    public static void e(String subTag, String message, Object... args) {
        f12237a.e(subTag, message, args);
    }

    public static void setLoggingLevel(Logger.LogLevel logLevel) {
        f12237a.setLoggingLevel(logLevel);
    }

    public static void e(String subTag, Throwable throwable) {
        f12237a.e(subTag, throwable);
    }
}
