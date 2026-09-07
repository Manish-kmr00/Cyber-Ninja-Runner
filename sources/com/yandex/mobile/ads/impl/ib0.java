package com.yandex.mobile.ads.impl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
final class ib0 {
    private boolean c;
    private int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f9197a = new a();
    private a b = new a();
    private long d = -9223372036854775807L;

    public final long a() {
        if (!this.f9197a.a()) {
            return -9223372036854775807L;
        }
        a aVar = this.f9197a;
        long j = aVar.e;
        if (j == 0) {
            return 0L;
        }
        return aVar.f / j;
    }

    public final float b() {
        if (!this.f9197a.a()) {
            return -1.0f;
        }
        a aVar = this.f9197a;
        long j = aVar.e;
        return (float) (1.0E9d / (j != 0 ? aVar.f / j : 0L));
    }

    public final long d() {
        if (this.f9197a.a()) {
            return this.f9197a.f;
        }
        return -9223372036854775807L;
    }

    public final void f() {
        a aVar = this.f9197a;
        aVar.d = 0L;
        aVar.e = 0L;
        aVar.f = 0L;
        aVar.h = 0;
        Arrays.fill(aVar.g, false);
        a aVar2 = this.b;
        aVar2.d = 0L;
        aVar2.e = 0L;
        aVar2.f = 0L;
        aVar2.h = 0;
        Arrays.fill(aVar2.g, false);
        this.c = false;
        this.d = -9223372036854775807L;
        this.e = 0;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003d  */
    public final void a(long j) {
        this.f9197a.a(j);
        if (this.f9197a.a()) {
            this.c = false;
        } else if (this.d != -9223372036854775807L) {
            if (this.c) {
                a aVar = this.b;
                long j2 = aVar.d;
                if (j2 != 0 && aVar.g[(int) ((j2 - 1) % 15)]) {
                    a aVar2 = this.b;
                    aVar2.d = 0L;
                    aVar2.e = 0L;
                    aVar2.f = 0L;
                    aVar2.h = 0;
                    Arrays.fill(aVar2.g, false);
                    this.b.a(this.d);
                }
            } else {
                a aVar3 = this.b;
                aVar3.d = 0L;
                aVar3.e = 0L;
                aVar3.f = 0L;
                aVar3.h = 0;
                Arrays.fill(aVar3.g, false);
                this.b.a(this.d);
            }
            this.c = true;
            this.b.a(j);
        }
        if (this.c && this.b.a()) {
            a aVar4 = this.f9197a;
            this.f9197a = this.b;
            this.b = aVar4;
            this.c = false;
        }
        this.d = j;
        this.e = this.f9197a.a() ? 0 : this.e + 1;
    }

    public final boolean e() {
        return this.f9197a.a();
    }

    public final int c() {
        return this.e;
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f9198a;
        private long b;
        private long c;
        private long d;
        private long e;
        private long f;
        private final boolean[] g = new boolean[15];
        private int h;

        public final boolean a() {
            return this.d > 15 && this.h == 0;
        }

        public final void a(long j) {
            long j2 = this.d;
            if (j2 == 0) {
                this.f9198a = j;
            } else if (j2 == 1) {
                long j3 = j - this.f9198a;
                this.b = j3;
                this.f = j3;
                this.e = 1L;
            } else {
                long j4 = j - this.c;
                int i = (int) (j2 % 15);
                if (Math.abs(j4 - this.b) <= 1000000) {
                    this.e++;
                    this.f += j4;
                    boolean[] zArr = this.g;
                    if (zArr[i]) {
                        zArr[i] = false;
                        this.h--;
                    }
                } else {
                    boolean[] zArr2 = this.g;
                    if (!zArr2[i]) {
                        zArr2[i] = true;
                        this.h++;
                    }
                }
            }
            this.d++;
            this.c = j;
        }
    }
}
