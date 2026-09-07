package com.yandex.div.internal.util;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes7.dex */
public class Clock {
    private static Clock sDefault = new Clock();

    @Inject
    public Clock() {
    }

    public static Clock get() {
        return sDefault;
    }

    public static void setForTests(Clock clock) {
        if (clock == null) {
            clock = new Clock();
        }
        sDefault = clock;
    }

    public long getCurrentUnixTimestamp() {
        return TimeUnit.MILLISECONDS.toSeconds(getCurrentTimeMs());
    }

    public long getCurrentTimeMs() {
        return System.currentTimeMillis();
    }

    public long getUptimeMillis() {
        return SystemClock.uptimeMillis();
    }

    public long getElapsedRealtimeMs() {
        return SystemClock.elapsedRealtime();
    }
}
