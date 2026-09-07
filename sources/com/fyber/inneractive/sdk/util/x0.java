package com.fyber.inneractive.sdk.util;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeUnit f2381a;
    public final long b;
    public v0 c;
    public boolean d;
    public w0 e;
    public long f;

    public x0(TimeUnit timeUnit, long j) {
        this.d = false;
        this.f = 0L;
        this.b = j;
        this.f2381a = timeUnit;
        IAlog.a("Visible time counter init - time %d", Long.valueOf(j));
    }

    public final void a(long j) {
        long jUptimeMillis = (SystemClock.uptimeMillis() - j) + 50 + this.f;
        this.f = jUptimeMillis;
        if (this.e != null && jUptimeMillis > this.f2381a.toMillis(this.b)) {
            this.e.a();
            return;
        }
        v0 v0Var = this.c;
        if (v0Var == null || this.e == null) {
            return;
        }
        v0Var.removeMessages(1932593528);
        this.c.sendEmptyMessageDelayed(1932593528, 50L);
    }

    public x0(TimeUnit timeUnit, long j, long j2) {
        this.d = false;
        this.b = j;
        this.f2381a = timeUnit;
        this.f = j2;
        IAlog.a("Visible time counter init - time %d", Long.valueOf(j));
    }
}
