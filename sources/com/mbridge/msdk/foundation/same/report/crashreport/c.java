package com.mbridge.msdk.foundation.same.report.crashreport;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: compiled from: AnrMonitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends Thread {
    private static volatile c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f5007a;
    private volatile b b;
    private com.mbridge.msdk.foundation.same.report.crashreport.a c;
    private int d;

    /* JADX INFO: compiled from: AnrMonitor.java */
    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f5008a;
        private boolean b;
        private long c;

        private b() {
            this.f5008a = SystemClock.uptimeMillis();
        }

        void b() {
            this.b = false;
            this.c = SystemClock.uptimeMillis();
            c.this.f5007a.postAtFrontOfQueue(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this) {
                this.b = true;
                this.f5008a = SystemClock.uptimeMillis();
            }
        }

        boolean a() {
            return !this.b || this.f5008a - this.c >= ((long) c.this.d);
        }
    }

    private c() {
        super("AnrMonitor-Thread");
        this.f5007a = new Handler(Looper.getMainLooper());
        this.d = 5000;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0089 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r6 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
        L5:
            boolean r0 = r6.isInterrupted()
            if (r0 != 0) goto L8c
            com.mbridge.msdk.foundation.same.report.crashreport.c$b r0 = r6.b
            if (r0 == 0) goto L17
            com.mbridge.msdk.foundation.same.report.crashreport.c$b r0 = r6.b
            boolean r0 = com.mbridge.msdk.foundation.same.report.crashreport.c.b.a(r0)
            if (r0 == 0) goto L8c
        L17:
            monitor-enter(r6)
            com.mbridge.msdk.foundation.same.report.crashreport.c$b r0 = r6.b     // Catch: java.lang.Throwable -> L89
            if (r0 != 0) goto L24
            com.mbridge.msdk.foundation.same.report.crashreport.c$b r0 = new com.mbridge.msdk.foundation.same.report.crashreport.c$b     // Catch: java.lang.Throwable -> L89
            r1 = 0
            r0.<init>()     // Catch: java.lang.Throwable -> L89
            r6.b = r0     // Catch: java.lang.Throwable -> L89
        L24:
            com.mbridge.msdk.foundation.same.report.crashreport.c$b r0 = r6.b     // Catch: java.lang.Throwable -> L89
            r0.b()     // Catch: java.lang.Throwable -> L89
            int r0 = r6.d     // Catch: java.lang.Throwable -> L89
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L89
            long r2 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L89
        L30:
            r4 = 0
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L4f
            r6.wait(r0)     // Catch: java.lang.InterruptedException -> L3a java.lang.Throwable -> L89
            goto L44
        L3a:
            r0 = move-exception
            java.lang.String r1 = "AnrMonitor"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L89
            android.util.Log.w(r1, r0)     // Catch: java.lang.Throwable -> L89
        L44:
            long r0 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L89
            long r0 = r0 - r2
            int r4 = r6.d     // Catch: java.lang.Throwable -> L89
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L89
            long r0 = r4 - r0
            goto L30
        L4f:
            com.mbridge.msdk.foundation.same.report.crashreport.c$b r0 = r6.b     // Catch: java.lang.Throwable -> L89
            boolean r0 = r0.a()     // Catch: java.lang.Throwable -> L89
            if (r0 != 0) goto L60
            com.mbridge.msdk.foundation.same.report.crashreport.a r0 = r6.c     // Catch: java.lang.Throwable -> L89
            if (r0 == 0) goto L5e
            r0.a()     // Catch: java.lang.Throwable -> L89
        L5e:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L89
            goto L5
        L60:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L89
            boolean r0 = android.os.Debug.isDebuggerConnected()
            if (r0 != 0) goto L5
            boolean r0 = android.os.Debug.waitingForDebugger()
            if (r0 == 0) goto L6e
            goto L5
        L6e:
            com.mbridge.msdk.foundation.same.report.crashreport.a r0 = r6.c
            if (r0 == 0) goto L5
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            java.lang.Thread r0 = r0.getThread()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            java.lang.String r1 = com.mbridge.msdk.foundation.same.report.crashreport.d.b(r0)
            com.mbridge.msdk.foundation.same.report.crashreport.a r2 = r6.c
            r2.a(r1, r0)
            goto L5
        L89:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L89
            throw r0
        L8c:
            int r0 = r6.d     // Catch: java.lang.Exception -> L5
            long r0 = (long) r0     // Catch: java.lang.Exception -> L5
            java.lang.Thread.sleep(r0)     // Catch: java.lang.Exception -> L5
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.crashreport.c.run():void");
    }

    public static c a() {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c();
                }
            }
        }
        return e;
    }

    public c a(int i, com.mbridge.msdk.foundation.same.report.crashreport.a aVar) {
        this.d = i;
        this.c = aVar;
        return this;
    }
}
