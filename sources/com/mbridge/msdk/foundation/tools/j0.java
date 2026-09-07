package com.mbridge.msdk.foundation.tools;

import android.os.SystemClock;

/* JADX INFO: compiled from: SameDeviceTimeTool.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j0 {
    public static final long a() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            if (jCurrentTimeMillis > 0) {
                return (jCurrentTimeMillis / 10) * 10;
            }
        } catch (Exception unused) {
        }
        return 0L;
    }
}
