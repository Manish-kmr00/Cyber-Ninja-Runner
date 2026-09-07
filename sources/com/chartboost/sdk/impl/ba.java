package com.chartboost.sdk.impl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class ba {
    public long a() {
        return System.currentTimeMillis();
    }

    public long b() {
        return System.nanoTime();
    }

    public long c() {
        return SystemClock.uptimeMillis();
    }
}
