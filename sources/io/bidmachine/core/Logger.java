package io.bidmachine.core;

import io.bidmachine.utils.lazy.LazyValue;
import io.bidmachine.utils.log.DefaultLoggerInstance;
import io.bidmachine.utils.log.EmptyLoggerInstance;
import io.bidmachine.utils.log.LoggerInstance;

/* JADX INFO: loaded from: classes9.dex */
public class Logger {
    private static boolean isLoggingEnabled;
    private static volatile LoggerInstance enabledInstance = new DefaultLoggerInstance("BidMachineLog");
    private static volatile LoggerInstance disabledInstance = new EmptyLoggerInstance();
    static volatile LoggerInstance instance = disabledInstance;

    public static void setLoggingEnabled(boolean z) {
        LoggerInstance loggerInstance;
        isLoggingEnabled = z;
        if (z) {
            loggerInstance = enabledInstance;
        } else {
            loggerInstance = disabledInstance;
        }
        instance = loggerInstance;
    }

    public static void setEnabledInstance(LoggerInstance loggerInstance) {
        enabledInstance = loggerInstance;
        setLoggingEnabled(isLoggingEnabled);
    }

    public static void setDisabledInstance(LoggerInstance loggerInstance) {
        disabledInstance = loggerInstance;
        setLoggingEnabled(isLoggingEnabled);
    }

    public static boolean isLoggingEnabled() {
        return isLoggingEnabled;
    }

    public static void d(Object obj, String str) {
        instance.d(obj, str);
    }

    public static void d(String str) {
        instance.d(str);
    }

    public static void d(Object obj, LazyValue<String> lazyValue) {
        instance.d(obj, lazyValue);
    }

    public static void d(LazyValue<String> lazyValue) {
        instance.d(lazyValue);
    }

    public static void w(Object obj, String str) {
        instance.w(obj, str);
    }

    public static void w(String str) {
        instance.w(str);
    }

    public static void w(Throwable th) {
        instance.w(th);
    }

    public static void e(Object obj, String str) {
        instance.e(obj, str);
    }

    public static void e(String str) {
        instance.e(str);
    }

    public static void e(Object obj, LazyValue<String> lazyValue) {
        instance.e(obj, lazyValue);
    }

    public static void e(LazyValue<String> lazyValue) {
        instance.e(lazyValue);
    }
}
