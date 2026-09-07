package com.five_corp.ad.internal.movie.partialcache;

import java.util.Locale;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.partialcache.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C3000e {
    public final com.five_corp.ad.internal.cache.o b;
    public final com.five_corp.ad.internal.context.l c;
    public final InterfaceC2998d d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1477a = new Object();
    public com.five_corp.ad.internal.storage.i e = null;
    public boolean f = false;
    public boolean g = false;
    public int h = 0;
    public int i = 0;
    public boolean j = true;
    public boolean k = false;
    public boolean l = false;
    public com.five_corp.ad.internal.http.movcache.l m = null;

    public C3000e(com.five_corp.ad.internal.cache.o oVar, com.five_corp.ad.internal.context.l lVar, InterfaceC2998d interfaceC2998d, com.five_corp.ad.internal.http.movcache.h hVar) {
        this.b = oVar;
        this.c = lVar;
        this.d = interfaceC2998d;
    }

    public final int a() {
        int iMin;
        synchronized (this.f1477a) {
            iMin = Math.min(this.i - this.h, 8192);
        }
        return iMin;
    }

    public final void b() {
        int i;
        int i2;
        synchronized (this.f1477a) {
            if (this.k) {
                return;
            }
            if (this.f) {
                if (!this.g && (i = this.h) >= (i2 = this.i)) {
                    if (i == i2) {
                        this.j = false;
                        return;
                    }
                    com.five_corp.ad.internal.p pVar = com.five_corp.ad.internal.p.q3;
                    Locale locale = Locale.US;
                    com.five_corp.ad.internal.o oVar = new com.five_corp.ad.internal.o(pVar, "Ots: " + this.c.b.b + ", Current offset: " + i + ", Downloaded file size: " + i2, null, null);
                    s1 s1Var = (s1) this.d;
                    s1Var.getClass();
                    s1Var.b(new q1(s1Var, oVar));
                    return;
                }
                this.j = true;
                com.five_corp.ad.internal.storage.i iVar = this.e;
                iVar.d.post(new com.five_corp.ad.internal.storage.f(iVar, a()));
            }
        }
    }

    public final void c() {
        int i;
        int i2;
        synchronized (this.f1477a) {
            if (!this.f && !this.k) {
                boolean z = true;
                this.f = true;
                com.five_corp.ad.internal.o oVar = null;
                if (this.g || (i = this.h) < (i2 = this.i)) {
                    this.j = true;
                    com.five_corp.ad.internal.util.f fVarA = this.b.a(this.h, this);
                    if (fVarA.f1560a) {
                        this.e = (com.five_corp.ad.internal.storage.i) fVarA.c;
                    } else {
                        oVar = fVarA.b;
                    }
                } else if (i == i2) {
                    this.j = false;
                } else {
                    com.five_corp.ad.internal.p pVar = com.five_corp.ad.internal.p.o3;
                    Locale locale = Locale.US;
                    oVar = new com.five_corp.ad.internal.o(pVar, "Ots: " + this.c.b.b + ", Current offset: " + i + ", Downloaded file size: " + i2, null, null);
                }
                boolean z2 = this.j;
                if (!this.l || !this.f) {
                    z = false;
                }
                if (z) {
                    this.l = false;
                }
                if (oVar != null) {
                    s1 s1Var = (s1) this.d;
                    s1Var.getClass();
                    s1Var.b(new q1(s1Var, oVar));
                } else {
                    if (z) {
                        this.m.f1407a.k();
                    }
                    if (z2) {
                        b();
                    }
                }
            }
        }
    }

    public final void d() {
        synchronized (this.f1477a) {
            this.f = false;
            com.five_corp.ad.internal.storage.i iVar = this.e;
            if (iVar != null) {
                iVar.d.post(new com.five_corp.ad.internal.storage.h(iVar));
                this.e = null;
            }
        }
    }

    public final void a(com.five_corp.ad.internal.storage.i iVar, byte[] bArr, int i) {
        synchronized (this.f1477a) {
            if (this.e == iVar) {
                int i2 = this.h;
                com.five_corp.ad.internal.o oVar = null;
                if (i < 0) {
                    com.five_corp.ad.internal.p pVar = com.five_corp.ad.internal.p.w3;
                    Locale locale = Locale.US;
                    oVar = new com.five_corp.ad.internal.o(pVar, "Ots: " + this.c.b.b + ", Current offset: " + i2 + ", Downloaded file size: " + this.i + ", length: " + i, null, null);
                } else {
                    int i3 = i2 + i;
                    this.h = i3;
                    if (this.g && i2 == this.i) {
                        this.k = true;
                    } else {
                        int i4 = this.i;
                        if (i2 > i4) {
                            com.five_corp.ad.internal.p pVar2 = com.five_corp.ad.internal.p.p3;
                            Locale locale2 = Locale.US;
                            oVar = new com.five_corp.ad.internal.o(pVar2, "Ots: " + this.c.b.b + ", Current offset: " + i3 + ", Downloaded file size: " + i4, null, null);
                        }
                    }
                }
                if (oVar != null) {
                    s1 s1Var = (s1) this.d;
                    s1Var.getClass();
                    s1Var.b(new q1(s1Var, oVar));
                } else if (i > 0) {
                    s1 s1Var2 = (s1) this.d;
                    s1Var2.getClass();
                    s1Var2.a(new p1(s1Var2, this, i, 0, i2, bArr));
                }
            }
        }
        b();
    }
}
