package com.smaato.sdk.core.log;

import android.util.Log;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
class ConsoleLogWriter extends LogWriter {
    ConsoleLogWriter(LogLevel logLevel) {
        super(logLevel);
    }

    @Override // com.smaato.sdk.core.log.LogWriter
    protected void log(LogLevel logLevel, String str, String str2) {
        int iMin;
        Objects.requireNonNull(logLevel);
        Objects.requireNonNull(str);
        Objects.requireNonNull(str2);
        String strShrinkTagIfNeeded = shrinkTagIfNeeded(str);
        int length = str2.length();
        int i = 0;
        while (i < length) {
            int iIndexOf = str2.indexOf(10, i);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i + 4000);
                Log.println(mapToAndroidLogLevel(logLevel), strShrinkTagIfNeeded, str2.substring(i, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i = iMin;
                }
            }
            i = iMin + 1;
        }
    }

    @Override // com.smaato.sdk.core.log.LogWriter
    protected boolean isLoggable(LogLevel logLevel) {
        Objects.requireNonNull(logLevel);
        return logLevel.ordinal() >= getLogLevel().ordinal();
    }

    /* JADX INFO: renamed from: com.smaato.sdk.core.log.ConsoleLogWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$core$log$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$smaato$sdk$core$log$LogLevel = iArr;
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$log$LogLevel[LogLevel.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$log$LogLevel[LogLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$core$log$LogLevel[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private int mapToAndroidLogLevel(LogLevel logLevel) {
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$core$log$LogLevel[logLevel.ordinal()];
        if (i == 1) {
            return 3;
        }
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 5;
        }
        if (i == 4) {
            return 6;
        }
        throw new IllegalArgumentException("Unknown level: " + logLevel);
    }

    private String shrinkTagIfNeeded(String str) {
        Objects.requireNonNull(str);
        return str;
    }
}
