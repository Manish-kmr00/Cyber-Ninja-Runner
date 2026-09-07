package com.smaato.sdk.core.log;

/* JADX INFO: loaded from: classes13.dex */
public interface Logger {
    void debug(LogDomain logDomain, String str, Object... objArr);

    void debug(LogDomain logDomain, Throwable th, String str, Object... objArr);

    void error(LogDomain logDomain, String str, Object... objArr);

    void error(LogDomain logDomain, Throwable th, String str, Object... objArr);

    void info(LogDomain logDomain, String str, Object... objArr);

    void info(LogDomain logDomain, Throwable th, String str, Object... objArr);

    void log(LogLevel logLevel, LogDomain logDomain, String str, Object... objArr);

    void log(LogLevel logLevel, LogDomain logDomain, Throwable th, String str, Object... objArr);

    void setExplicitOneShotTag(String str);

    void warning(LogDomain logDomain, String str, Object... objArr);

    void warning(LogDomain logDomain, Throwable th, String str, Object... objArr);
}
