package com.yandex.mobile.ads.impl;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes14.dex */
final class yd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10727a;
    public long b;
    public int c;
    public int d;
    public int e;
    public final int[] f = new int[255];
    private final wf1 g = new wf1(255);

    public final boolean a(tz tzVar, boolean z) throws IOException {
        this.f10727a = 0;
        this.b = 0L;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.g.c(27);
        try {
            if (tzVar.b(this.g.c(), 0, 27, z) && this.g.v() == 1332176723) {
                if (this.g.t() != 0) {
                    if (z) {
                        return false;
                    }
                    throw ag1.a("unsupported bit stream revision");
                }
                this.f10727a = this.g.t();
                this.b = this.g.l();
                this.g.n();
                this.g.n();
                this.g.n();
                int iT = this.g.t();
                this.c = iT;
                this.d = iT + 27;
                this.g.c(iT);
                try {
                    if (tzVar.b(this.g.c(), 0, this.c, z)) {
                        for (int i = 0; i < this.c; i++) {
                            this.f[i] = this.g.t();
                            this.e += this.f[i];
                        }
                        return true;
                    }
                } catch (EOFException e) {
                    if (!z) {
                        throw e;
                    }
                }
                return false;
            }
        } catch (EOFException e2) {
            if (!z) {
                throw e2;
            }
        }
        return false;
    }

    yd1() {
    }

    public final boolean a(tz tzVar, long j) throws IOException {
        if (tzVar.a() == tzVar.d()) {
            this.g.c(4);
            while (true) {
                if (j != -1 && tzVar.a() + 4 >= j) {
                    break;
                }
                try {
                    if (!tzVar.b(this.g.c(), 0, 4, true)) {
                        break;
                    }
                    this.g.e(0);
                    if (this.g.v() == 1332176723) {
                        tzVar.c();
                        return true;
                    }
                    tzVar.a(1);
                } catch (EOFException unused) {
                }
            }
            do {
                if (j != -1 && tzVar.a() >= j) {
                    break;
                }
            } while (tzVar.c(1) != -1);
            return false;
        }
        throw new IllegalArgumentException();
    }
}
