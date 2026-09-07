package com.moloco.sdk.internal.services.bidtoken;

/* JADX INFO: loaded from: classes11.dex */
public enum b0 {
    NEEDS_REFRESH,
    EXPIRING,
    NO_REFRESH_NEEDED;

    public final boolean b() {
        return this == EXPIRING || this == NO_REFRESH_NEEDED;
    }
}
