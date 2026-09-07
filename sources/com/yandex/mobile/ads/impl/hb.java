package com.yandex.mobile.ads.impl;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class hb implements w70 {
    private final wf1 d;
    private final vf1 e;
    private y70 f;
    private long g;
    private boolean j;
    private boolean k;
    private boolean l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9079a = 0;
    private final ib b = new ib();
    private final wf1 c = new wf1(2048);
    private int i = -1;
    private long h = -1;

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.hb$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return hb.a();
            }
        };
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    public hb() {
        wf1 wf1Var = new wf1(10);
        this.d = wf1Var;
        this.e = new vf1(wf1Var.c());
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.f = y70Var;
        this.b.a(y70Var, new i72.d(Integer.MIN_VALUE, 0, 1));
        y70Var.a();
    }

    private int a(tz tzVar) throws IOException {
        int i = 0;
        while (true) {
            tzVar.b(this.d.c(), 0, 10, false);
            this.d.e(0);
            if (this.d.w() != 4801587) {
                break;
            }
            this.d.f(3);
            int iS = this.d.s();
            i += iS + 10;
            tzVar.a(false, iS);
        }
        tzVar.c();
        tzVar.a(false, i);
        if (this.h == -1) {
            this.h = i;
        }
        return i;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        if (this.f != null) {
            tz tzVar = (tz) x70Var;
            long jB = tzVar.b();
            int i = this.f9079a;
            if (((i & 2) != 0 || ((i & 1) != 0 && jB != -1)) && !this.j) {
                this.i = -1;
                tzVar.c();
                if (tzVar.a() == 0) {
                    a(tzVar);
                }
                long j = 0;
                int i2 = 0;
                while (tzVar.b(this.d.c(), 0, 2, true)) {
                    try {
                        this.d.e(0);
                        if ((this.d.z() & 65526) != 65520) {
                            i2 = 0;
                            break;
                        }
                        if (!tzVar.b(this.d.c(), 0, 4, true)) {
                            break;
                        }
                        this.e.c(14);
                        int iB = this.e.b(13);
                        if (iB > 6) {
                            j += (long) iB;
                            i2++;
                            if (i2 == 1000 || !tzVar.a(true, iB - 6)) {
                                break;
                                break;
                            }
                        } else {
                            this.j = true;
                            throw ag1.a("Malformed ADTS stream", (Exception) null);
                        }
                    } catch (EOFException unused) {
                    }
                }
                tzVar.c();
                if (i2 > 0) {
                    this.i = (int) (j / ((long) i2));
                } else {
                    this.i = -1;
                }
                this.j = true;
            }
            int i3 = tzVar.read(this.c.c(), 0, 2048);
            boolean z = i3 == -1;
            if (!this.l) {
                boolean z2 = (this.f9079a & 1) != 0 && this.i > 0;
                if (!z2 || this.b.c() != -9223372036854775807L || z) {
                    if (z2 && this.b.c() != -9223372036854775807L) {
                        this.f.a(new tr((int) ((((long) this.i) * 8000000) / this.b.c()), this.i, jB, this.h, (this.f9079a & 2) != 0));
                    } else {
                        this.f.a(new xw1.b(-9223372036854775807L, 0L));
                    }
                    this.l = true;
                }
            }
            if (z) {
                return -1;
            }
            this.c.e(0);
            this.c.d(i3);
            if (!this.k) {
                this.b.a(4, this.g);
                this.k = true;
            }
            this.b.a(this.c);
            return 0;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        this.k = false;
        this.b.a();
        this.g = j2;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        tz tzVar = (tz) x70Var;
        int iA = a(tzVar);
        int i = iA;
        int i2 = 0;
        int i3 = 0;
        do {
            tzVar.b(this.d.c(), 0, 2, false);
            this.d.e(0);
            if ((this.d.z() & 65526) == 65520) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                tzVar.b(this.d.c(), 0, 4, false);
                this.e.c(14);
                int iB = this.e.b(13);
                if (iB <= 6) {
                    i++;
                    tzVar.c();
                    tzVar.a(false, i);
                } else {
                    tzVar.a(false, iB - 6);
                    i3 += iB;
                }
            } else {
                i++;
                tzVar.c();
                tzVar.a(false, i);
            }
            i2 = 0;
            i3 = 0;
        } while (i - iA < 8192);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static w70[] a() {
        return new w70[]{new hb()};
    }
}
