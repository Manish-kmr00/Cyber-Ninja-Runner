package io.bidmachine.iab.vast;

import io.bidmachine.iab.utils.LogListener;
import io.bidmachine.iab.utils.Logger;

/* JADX INFO: loaded from: classes12.dex */
public class VastLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f12256a = new Logger("VastLog");

    public static void addLogListener(LogListener logListener) {
        f12256a.addLogListener(logListener);
    }

    public static boolean canSendDLog() {
        return f12256a.canSendDLog();
    }

    public static boolean canSendELog() {
        return f12256a.canSendELog();
    }

    public static boolean canSendWLog() {
        return f12256a.canSendWLog();
    }

    public static void d(String subTag, String message, Object... args) {
        f12256a.d(subTag, message, args);
    }

    public static void e(String subTag, String message, Object... args) {
        f12256a.e(subTag, message, args);
    }

    public static boolean removeLogListener(LogListener logListener) {
        return f12256a.removeLogListener(logListener);
    }

    public static void setLoggingLevel(Logger.LogLevel logLevel) {
        f12256a.setLoggingLevel(logLevel);
    }

    public static void e(String subTag, Throwable throwable) {
        f12256a.e(subTag, throwable);
    }
}
