package com.smaato.sdk.core.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes12.dex */
public final class Clock {
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
