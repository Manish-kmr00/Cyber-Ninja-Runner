package com.smaato.sdk.core.log;

/* JADX INFO: loaded from: classes10.dex */
public enum LogLevel {
    DEBUG(3),
    INFO(4),
    WARNING(5),
    ERROR(6);

    private final int logCatLevel;

    LogLevel(int i) {
        this.logCatLevel = i;
    }

    public int getLogCatLevel() {
        return this.logCatLevel;
    }
}
