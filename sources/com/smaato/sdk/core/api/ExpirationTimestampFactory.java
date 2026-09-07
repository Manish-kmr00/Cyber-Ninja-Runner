package com.smaato.sdk.core.api;

import com.smaato.sdk.core.ad.Expiration;
import com.smaato.sdk.core.util.CurrentTimeProvider;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
public class ExpirationTimestampFactory {
    public static final long DEFAULT_AD_EXPIRATION_PERIOD_MS = 300000;
    private final CurrentTimeProvider currentTimeProvider;

    public ExpirationTimestampFactory(CurrentTimeProvider currentTimeProvider) {
        this.currentTimeProvider = (CurrentTimeProvider) Objects.requireNonNull(currentTimeProvider);
    }

    public Expiration createExpirationTimestampFor(long j, Long l) {
        long jCurrentMillisUtc = j - this.currentTimeProvider.currentMillisUtc();
        if (l != null) {
            long jLongValue = j - l.longValue();
            if (jLongValue >= 30000) {
                return new Expiration(this.currentTimeProvider.currentMillisUtc() + jLongValue, this.currentTimeProvider);
            }
        } else if (jCurrentMillisUtc >= 30000) {
            return new Expiration(j, this.currentTimeProvider);
        }
        return createDefaultExpirationTimestamp();
    }

    public Expiration createDefaultExpirationTimestamp() {
        return new Expiration(this.currentTimeProvider.currentMillisUtc() + 300000, this.currentTimeProvider);
    }
}
