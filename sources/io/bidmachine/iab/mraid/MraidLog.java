package io.bidmachine.iab.mraid;

import io.bidmachine.iab.utils.LogListener;
import io.bidmachine.iab.utils.Logger;

/* JADX INFO: loaded from: classes11.dex */
public class MraidLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f12201a = new Logger("MraidLog");

    public static void addLogListener(LogListener logListener) {
        f12201a.addLogListener(logListener);
    }

    public static boolean canSendDLog() {
        return f12201a.canSendDLog();
    }

    public static boolean canSendELog() {
        return f12201a.canSendELog();
    }

    public static boolean canSendWLog() {
        return f12201a.canSendWLog();
    }

    public static void d(String subTag, String message, Object... args) {
        f12201a.d(subTag, message, args);
    }

    public static void e(String subTag, String message, Object... args) {
        f12201a.e(subTag, message, args);
    }

    public static Logger.LogLevel getLoggingLevel() {
        return f12201a.getLoggingLevel();
    }

    public static boolean removeLogListener(LogListener logListener) {
        return f12201a.removeLogListener(logListener);
    }

    public static void setLoggingLevel(Logger.LogLevel logLevel) {
        f12201a.setLoggingLevel(logLevel);
    }

    public static void w(String subTag, String message, Object... args) {
        f12201a.w(subTag, message, args);
    }

    public static void e(String subTag, Throwable throwable) {
        f12201a.e(subTag, throwable);
    }
}
