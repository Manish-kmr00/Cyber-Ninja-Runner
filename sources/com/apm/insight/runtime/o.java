package com.apm.insight.runtime;

import android.system.Os;
import android.system.OsConstants;

/* JADX INFO: compiled from: ProcessCpuTracker.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f297a = -1;

    /* JADX INFO: compiled from: ProcessCpuTracker.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static long f298a = -1;

        public static long a() {
            if (o.f297a == -1) {
                long jSysconf = f298a;
                if (jSysconf <= 0) {
                    jSysconf = Os.sysconf(OsConstants._SC_CLK_TCK);
                    if (jSysconf <= 0) {
                        jSysconf = 100;
                    }
                    f298a = jSysconf;
                }
                long unused = o.f297a = 1000 / jSysconf;
            }
            return o.f297a;
        }

        private static long a(String str) {
            try {
                int i = Class.forName("libcore.io.OsConstants").getField(str).getInt(null);
                Class<?> cls = Class.forName("libcore.io.Libcore");
                return ((Long) Class.forName("libcore.io.Os").getMethod("sysconf", Integer.TYPE).invoke(cls.getField("os").get(null), Integer.valueOf(i))).longValue();
            } catch (Throwable th) {
                th.printStackTrace();
                return 100L;
            }
        }
    }
}
