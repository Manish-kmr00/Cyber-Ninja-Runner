package com.json;

/* JADX INFO: loaded from: classes8.dex */
public class yu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f4636a;
    protected long b;
    protected long c;

    public long a() {
        return Math.max(0L, this.f4636a - System.currentTimeMillis());
    }

    public void a(long j) {
        this.f4636a = System.currentTimeMillis() + j;
    }

    public void b() {
        this.f4636a = 0L;
        this.b = 0L;
        this.c = 0L;
    }

    public void b(long j) {
        this.c = j;
        this.f4636a += j - this.b;
    }

    public void c(long j) {
        this.b = j;
        this.c = 0L;
    }
}
