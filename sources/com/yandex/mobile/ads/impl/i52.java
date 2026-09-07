package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes11.dex */
public final class i52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9178a;
    private long b;
    private long c;
    private final ThreadLocal<Long> d = new ThreadLocal<>();

    public final synchronized long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.b == -9223372036854775807L) {
            long jLongValue = this.f9178a;
            if (jLongValue == 9223372036854775806L) {
                Long l = this.d.get();
                l.getClass();
                jLongValue = l.longValue();
            }
            this.b = jLongValue - j;
            notifyAll();
        }
        this.c = j;
        return j + this.b;
    }

    public final synchronized long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.c;
        if (j2 != -9223372036854775807L) {
            long j3 = (j2 * 90000) / 1000000;
            long j4 = (4294967296L + j3) / 8589934592L;
            long j5 = ((j4 - 1) * 8589934592L) + j;
            j += j4 * 8589934592L;
            if (Math.abs(j5 - j3) < Math.abs(j - j3)) {
                j = j5;
            }
        }
        return a((j * 1000000) / 90000);
    }

    public i52(long j) {
        c(j);
    }

    public final synchronized long c() {
        return this.b;
    }

    public final synchronized void c(long j) {
        this.f9178a = j;
        this.b = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.c = -9223372036854775807L;
    }

    public final synchronized long b() {
        long jA;
        long j = this.c;
        if (j != -9223372036854775807L) {
            jA = j + this.b;
        } else {
            jA = a();
        }
        return jA;
    }

    public final synchronized long a() {
        long j;
        j = this.f9178a;
        if (j == Long.MAX_VALUE || j == 9223372036854775806L) {
            j = -9223372036854775807L;
        }
        return j;
    }
}
