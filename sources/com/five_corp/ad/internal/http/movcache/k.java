package com.five_corp.ad.internal.http.movcache;

import com.five_corp.ad.internal.movie.partialcache.C3000e;
import com.five_corp.ad.internal.movie.partialcache.InterfaceC2998d;
import com.five_corp.ad.internal.movie.partialcache.o1;
import com.five_corp.ad.internal.movie.partialcache.p1;
import com.five_corp.ad.internal.movie.partialcache.q1;
import com.five_corp.ad.internal.movie.partialcache.s1;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.http.a f1406a;
    public final WeakReference b;

    public k(com.five_corp.ad.internal.context.l lVar, C3000e c3000e) {
        this.f1406a = new com.five_corp.ad.internal.http.a(null, lVar, 3);
        this.b = new WeakReference(c3000e);
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final int a() {
        return this.f1406a.c;
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final void b() {
        C3000e c3000e = (C3000e) this.b.get();
        if (c3000e != null) {
            synchronized (c3000e.f1477a) {
                c3000e.g = true;
                if (c3000e.h == c3000e.i) {
                    c3000e.k = true;
                }
            }
        }
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final void c() {
        C3000e c3000e = (C3000e) this.b.get();
        if (c3000e != null) {
            synchronized (c3000e.f1477a) {
                c3000e.l = true;
            }
        }
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final boolean d() {
        com.five_corp.ad.internal.http.a aVar = this.f1406a;
        com.five_corp.ad.internal.context.l lVar = (com.five_corp.ad.internal.context.l) aVar.b.get();
        com.five_corp.ad.internal.ad.a aVar2 = lVar != null ? lVar.b : (com.five_corp.ad.internal.ad.a) aVar.f1379a.get();
        if (aVar2 == null || !this.f1406a.a()) {
            return false;
        }
        return !aVar2.a();
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final boolean e() {
        return this.f1406a.a();
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final boolean a(int i) {
        boolean z;
        C3000e c3000e = (C3000e) this.b.get();
        if (c3000e == null) {
            return false;
        }
        synchronized (c3000e.f1477a) {
            z = c3000e.f;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:25:0x00d9  */
    @Override // com.five_corp.ad.internal.http.movcache.i
    public final void a(byte[] bArr, int i, int i2, int i3) {
        o oVar;
        C3000e c3000e = (C3000e) this.b.get();
        if (c3000e != null) {
            synchronized (c3000e.f1477a) {
                o oVar2 = null;
                try {
                    if (i2 < 0) {
                        p pVar = p.v3;
                        Locale locale = Locale.US;
                        oVar = new o(pVar, "Ots: " + c3000e.c.b.b + ", Downloaded file size: " + c3000e.i + ", offsetFromStartByteInclusive: " + i + ", size: " + i2 + ", offsetFromResourceFileHead: " + i3, null, null);
                    } else {
                        int i4 = c3000e.i;
                        if (i4 > i3) {
                            p pVar2 = p.r3;
                            Locale locale2 = Locale.US;
                            oVar = new o(pVar2, "Ots: " + c3000e.c.b.b + ", Downloaded file size: " + i4 + ", Received data offset: " + i3, null, null);
                        } else {
                            if (c3000e.f && !c3000e.j) {
                                int i5 = c3000e.h;
                                if (i5 != i3) {
                                    p pVar3 = p.s3;
                                    Locale locale3 = Locale.US;
                                    oVar2 = new o(pVar3, "Ots: " + c3000e.c.b.b + ", Current offset: " + i5 + ", Received data offset: " + i3, null, null);
                                } else {
                                    int i6 = i3 + i2;
                                    c3000e.i = i6;
                                    c3000e.h = i6;
                                }
                            }
                            c3000e.i = i3 + i2;
                            return;
                        }
                        if (oVar2 != null) {
                            s1 s1Var = (s1) c3000e.d;
                            s1Var.getClass();
                            s1Var.b(new q1(s1Var, oVar2));
                        } else {
                            s1 s1Var2 = (s1) c3000e.d;
                            s1Var2.getClass();
                            s1Var2.a(new p1(s1Var2, c3000e, i2, i, i3, bArr));
                        }
                    }
                    oVar2 = oVar;
                    if (oVar2 != null) {
                        s1 s1Var3 = (s1) c3000e.d;
                        s1Var3.getClass();
                        s1Var3.b(new q1(s1Var3, oVar2));
                    } else {
                        s1 s1Var4 = (s1) c3000e.d;
                        s1Var4.getClass();
                        s1Var4.a(new p1(s1Var4, c3000e, i2, i, i3, bArr));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.five_corp.ad.internal.http.movcache.i
    public final void a(int i, boolean z, l lVar, boolean z2) {
        int i2;
        C3000e c3000e = (C3000e) this.b.get();
        if (c3000e != null) {
            synchronized (c3000e.f1477a) {
                i2 = c3000e.h;
                c3000e.g = z;
                c3000e.i = i;
                c3000e.l = z2;
                c3000e.m = lVar;
            }
            if (z && i2 > i) {
                InterfaceC2998d interfaceC2998d = c3000e.d;
                p pVar = p.u3;
                Locale locale = Locale.US;
                o oVar = new o(pVar, "Ots: " + c3000e.c.b.b + ", Requested offset: " + i2 + ", Downloaded file size: " + i, null, null);
                s1 s1Var = (s1) interfaceC2998d;
                s1Var.getClass();
                s1Var.b(new q1(s1Var, oVar));
                return;
            }
            ((s1) c3000e.d).a(new o1());
        }
    }
}
