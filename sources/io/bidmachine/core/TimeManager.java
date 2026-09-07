package io.bidmachine.core;

import io.bidmachine.utils.time.SystemTimeManagerInstance;
import io.bidmachine.utils.time.TimeManagerInstance;

/* JADX INFO: loaded from: classes11.dex */
public final class TimeManager {
    private static TimeManagerInstance instance = new SystemTimeManagerInstance();

    public static long currentTimeMillis() {
        return instance.currentTimeMillis();
    }

    public static String getTimezoneId() {
        return instance.getTimeZoneId();
    }
}
