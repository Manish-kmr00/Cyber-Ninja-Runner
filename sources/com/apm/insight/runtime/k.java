package com.apm.insight.runtime;

import com.apm.insight.MonitorCrash;

/* JADX INFO: compiled from: MonitorCrashInner.java */
/* JADX INFO: loaded from: classes13.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MonitorCrash f290a = null;
    private static int b = -1;
    private static int c;

    public static MonitorCrash a() {
        if (f290a == null) {
            MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(com.apm.insight.e.g(), "239017", 1030851L, "1.3.8.nourl-rc.1", "com.apm.insight");
            f290a = monitorCrashInitSDK;
            monitorCrashInitSDK.config().setChannel("release");
        }
        return f290a;
    }

    public static void a(Throwable th, String str) {
        if (com.apm.insight.e.g() == null) {
            return;
        }
        if (b == -1) {
            b = 5;
        }
        int i = c;
        if (i < b) {
            c = i + 1;
            a().reportCustomErr(str, "INNER", th);
        }
    }
}
