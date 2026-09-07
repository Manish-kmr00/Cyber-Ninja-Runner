package com.yandex.mobile.ads.impl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class gr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9030a;

    public final synchronized void c() {
        this.f9030a = false;
    }

    public gr() {
        this(0);
    }

    public gr(int i) {
    }

    public final synchronized boolean e() {
        if (this.f9030a) {
            return false;
        }
        this.f9030a = true;
        notifyAll();
        return true;
    }

    public final synchronized void a() throws InterruptedException {
        while (!this.f9030a) {
            wait();
        }
    }

    public final synchronized void b() {
        boolean z = false;
        while (!this.f9030a) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean d() {
        return this.f9030a;
    }

    public final synchronized boolean a(long j) throws InterruptedException {
        try {
            if (j <= 0) {
                return this.f9030a;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = j + jElapsedRealtime;
            if (j2 < jElapsedRealtime) {
                a();
            } else {
                while (!this.f9030a && jElapsedRealtime < j2) {
                    wait(j2 - jElapsedRealtime);
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                }
            }
            return this.f9030a;
        } catch (Throwable th) {
            throw th;
        }
    }
}
