package io.bidmachine.utils.time;

import java.util.TimeZone;

/* JADX INFO: loaded from: classes12.dex */
public final class SystemTimeManagerInstance implements TimeManagerInstance {
    @Override // io.bidmachine.utils.time.TimeManagerInstance
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // io.bidmachine.utils.time.TimeManagerInstance
    public String getTimeZoneId() {
        return TimeZone.getDefault().getID();
    }
}
