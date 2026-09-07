package com.smaato.sdk.core.ad;

import com.smaato.sdk.core.util.CurrentTimeProvider;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class Expiration {
    private final CurrentTimeProvider currentTimeProvider;
    private final long expirationTimestamp;

    public Expiration(long j, CurrentTimeProvider currentTimeProvider) {
        this.expirationTimestamp = j;
        this.currentTimeProvider = (CurrentTimeProvider) Objects.requireNonNull(currentTimeProvider);
    }

    public long getTimestamp() {
        return this.expirationTimestamp;
    }

    public boolean isExpired() {
        return this.expirationTimestamp <= this.currentTimeProvider.currentMillisUtc();
    }

    public long getRemainingTime() {
        long jCurrentMillisUtc = this.expirationTimestamp - this.currentTimeProvider.currentMillisUtc();
        if (jCurrentMillisUtc > 0) {
            return jCurrentMillisUtc;
        }
        return 0L;
    }

    public String toString() {
        return String.valueOf(this.expirationTimestamp);
    }
}
