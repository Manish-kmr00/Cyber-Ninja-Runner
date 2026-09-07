package com.smaato.sdk.core.log;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
abstract class LogWriter {
    private final LogLevel logLevel;

    protected abstract boolean isLoggable(LogLevel logLevel);

    protected abstract void log(LogLevel logLevel, String str, String str2);

    LogWriter(LogLevel logLevel) {
        Objects.requireNonNull(logLevel);
        this.logLevel = logLevel;
    }

    protected final LogLevel getLogLevel() {
        return this.logLevel;
    }
}
