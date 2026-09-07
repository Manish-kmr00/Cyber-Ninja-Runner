package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.q;
import com.fyber.inneractive.sdk.player.exoplayer2.source.RunnableC3162a;
import com.fyber.inneractive.sdk.player.exoplayer2.source.w;
import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.B;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.InterfaceC3164b;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import com.fyber.inneractive.sdk.player.exoplayer2.util.v;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class n implements x, w, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j, com.fyber.inneractive.sdk.player.exoplayer2.extractor.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2013a;
    public final i b;
    public final f c;
    public final InterfaceC3164b d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.o e;
    public final int f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.f h;
    public boolean n;
    public boolean o;
    public int p;
    public com.fyber.inneractive.sdk.player.exoplayer2.o q;
    public int r;
    public boolean s;
    public z t;
    public int u;
    public boolean[] v;
    public long w;
    public long x;
    public boolean y;
    public final B g = new B("Loader:HlsSampleStreamWrapper");
    public final d i = new d();
    public final SparseArray j = new SparseArray();
    public final LinkedList k = new LinkedList();
    public final m l = new m(this);
    public final Handler m = new Handler();

    public n(int i, i iVar, f fVar, InterfaceC3164b interfaceC3164b, long j, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, int i2, com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar2) {
        this.f2013a = i;
        this.b = iVar;
        this.c = fVar;
        this.d = interfaceC3164b;
        this.e = oVar;
        this.f = i2;
        this.h = fVar2;
        this.w = j;
        this.x = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final void a(q qVar) {
    }

    /* JADX WARN: Code duplicated, block: B:100:0x020a  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:77:0x0133  */
    /* JADX WARN: Code duplicated, block: B:78:0x013d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0147  */
    /* JADX WARN: Code duplicated, block: B:82:0x014b  */
    /* JADX WARN: Code duplicated, block: B:83:0x014f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0157  */
    /* JADX WARN: Code duplicated, block: B:87:0x0164  */
    /* JADX WARN: Code duplicated, block: B:89:0x0174  */
    /* JADX WARN: Code duplicated, block: B:90:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:92:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:93:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:96:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:97:0x01f2  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final boolean b(long j) {
        boolean z;
        h hVar;
        int iMax;
        int size;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar;
        int i;
        int i2;
        boolean z2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c cVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c cVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar;
        int i3;
        o oVar;
        v vVar;
        Uri uriA;
        int i4;
        if (this.y || this.g.a()) {
            return false;
        }
        f fVar = this.c;
        h hVar2 = this.k.isEmpty() ? null : (h) this.k.getLast();
        long j2 = this.x;
        if (j2 == -9223372036854775807L) {
            j2 = j;
        }
        d dVar = this.i;
        int iA = hVar2 == null ? -1 : fVar.f.a(hVar2.c);
        fVar.k = null;
        if (hVar2 != null) {
            Math.max(0L, hVar2.f - j2);
        }
        fVar.p.d();
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = fVar.p;
        int i5 = bVar.c[bVar.a()];
        boolean z3 = iA != i5;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar2 = fVar.d[i5];
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h hVar3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h) fVar.e.d.get(aVar2);
        if (hVar3.d == null) {
            dVar.c = aVar2;
            fVar.k = aVar2;
            z = true;
        } else {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            h hVar4 = hVar2;
            long j3 = j2;
            long jMax = Math.max(30000L, com.fyber.inneractive.sdk.player.exoplayer2.b.a(hVar3.d.o));
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d dVar2 = hVar3.d;
            if (dVar2.j || (i4 = dVar2.b) == 2 || i4 == 1 || hVar3.e + jMax > jElapsedRealtime) {
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d dVarA = fVar.e.a(aVar2);
                if (hVar4 == null || z3) {
                    hVar = hVar4;
                    long j4 = hVar == null ? j3 : hVar.f;
                    if (dVarA.j || j4 <= dVarA.d + dVarA.o) {
                        List list = dVarA.m;
                        Long lValueOf = Long.valueOf(j4 - dVarA.d);
                        boolean z4 = !fVar.e.m || hVar == null;
                        int i6 = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f2192a;
                        int iBinarySearch = Collections.binarySearch(list, lValueOf);
                        if (iBinarySearch < 0) {
                            iMax = -(iBinarySearch + 2);
                        } else {
                            while (true) {
                                int i7 = iBinarySearch - 1;
                                if (i7 < 0 || ((Comparable) list.get(i7)).compareTo(lValueOf) != 0) {
                                    break;
                                }
                                iBinarySearch = i7;
                            }
                            iMax = iBinarySearch;
                        }
                        if (z4) {
                            iMax = Math.max(0, iMax);
                        }
                        int i8 = dVarA.g;
                        size = iMax + i8;
                        if (size < i8 && hVar != null) {
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar3 = fVar.d[iA];
                            aVar = aVar3;
                            dVarA = fVar.e.a(aVar3);
                            size = hVar.i + 1;
                        }
                        i = dVarA.g;
                        if (size < i) {
                            fVar.j = new com.fyber.inneractive.sdk.player.exoplayer2.source.g();
                            z = true;
                        } else {
                            i2 = size - i;
                            if (i2 >= dVarA.m.size()) {
                                z2 = true;
                                cVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c) dVarA.m.get(i2);
                                if (cVar.e) {
                                    uriA = com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(dVarA.f2018a, cVar.f);
                                    if (!uriA.equals(fVar.l)) {
                                        dVar.f2007a = new c(fVar.b, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uriA, 0L, 0L, -1L, null, 1), fVar.d[iA].b, fVar.p.c(), fVar.p.b(), fVar.i, cVar.g);
                                    } else if (!com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(cVar.g, fVar.n)) {
                                        fVar.a(uriA, cVar.g, fVar.m);
                                    }
                                } else {
                                    fVar.l = null;
                                    fVar.m = null;
                                    fVar.n = null;
                                    fVar.o = null;
                                }
                                cVar2 = dVarA.l;
                                if (cVar2 != null) {
                                    Uri uriA2 = com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(dVarA.f2018a, cVar2.f2017a);
                                    long j5 = cVar2.h;
                                    kVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uriA2, j5, j5, cVar2.i, null, 0);
                                } else {
                                    kVar = null;
                                }
                                long j6 = dVarA.d + cVar.d;
                                i3 = dVarA.f + cVar.c;
                                oVar = fVar.c;
                                vVar = (v) oVar.f2014a.get(i3);
                                if (vVar == null) {
                                    vVar = new v(Long.MAX_VALUE);
                                    oVar.f2014a.put(i3, vVar);
                                }
                                Uri uriA3 = com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(dVarA.f2018a, cVar.f2017a);
                                long j7 = cVar.h;
                                com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uriA3, j7, j7, cVar.i, null, 0);
                                z = true;
                                dVar.f2007a = new h(fVar.f2008a, kVar2, kVar, aVar, fVar.g, fVar.p.c(), fVar.p.b(), j6, j6 + cVar.b, size, i3, fVar.h, vVar, hVar, fVar.m, fVar.o);
                            } else if (dVarA.j) {
                                z2 = true;
                                dVar.b = true;
                            } else {
                                z2 = true;
                                dVar.c = aVar;
                                fVar.k = aVar;
                            }
                            z = z2;
                        }
                    } else {
                        size = dVarA.m.size() + dVarA.g;
                    }
                } else {
                    hVar = hVar4;
                    size = hVar.i + 1;
                }
                iA = i5;
                aVar = aVar2;
                i = dVarA.g;
                if (size < i) {
                    fVar.j = new com.fyber.inneractive.sdk.player.exoplayer2.source.g();
                    z = true;
                } else {
                    i2 = size - i;
                    if (i2 >= dVarA.m.size()) {
                        z2 = true;
                        cVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c) dVarA.m.get(i2);
                        if (cVar.e) {
                            uriA = com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(dVarA.f2018a, cVar.f);
                            if (!uriA.equals(fVar.l)) {
                                dVar.f2007a = new c(fVar.b, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uriA, 0L, 0L, -1L, null, 1), fVar.d[iA].b, fVar.p.c(), fVar.p.b(), fVar.i, cVar.g);
                            } else if (!com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(cVar.g, fVar.n)) {
                                fVar.a(uriA, cVar.g, fVar.m);
                            }
                        } else {
                            fVar.l = null;
                            fVar.m = null;
                            fVar.n = null;
                            fVar.o = null;
                        }
                        cVar2 = dVarA.l;
                        if (cVar2 != null) {
                            Uri uriA4 = com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(dVarA.f2018a, cVar2.f2017a);
                            long j8 = cVar2.h;
                            kVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uriA4, j8, j8, cVar2.i, null, 0);
                        } else {
                            kVar = null;
                        }
                        long j9 = dVarA.d + cVar.d;
                        i3 = dVarA.f + cVar.c;
                        oVar = fVar.c;
                        vVar = (v) oVar.f2014a.get(i3);
                        if (vVar == null) {
                            vVar = new v(Long.MAX_VALUE);
                            oVar.f2014a.put(i3, vVar);
                        }
                        Uri uriA5 = com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(dVarA.f2018a, cVar.f2017a);
                        long j10 = cVar.h;
                        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uriA5, j10, j10, cVar.i, null, 0);
                        z = true;
                        dVar.f2007a = new h(fVar.f2008a, kVar3, kVar, aVar, fVar.g, fVar.p.c(), fVar.p.b(), j9, j9 + cVar.b, size, i3, fVar.h, vVar, hVar, fVar.m, fVar.o);
                    } else if (dVarA.j) {
                        z2 = true;
                        dVar.b = true;
                    } else {
                        z2 = true;
                        dVar.c = aVar;
                        fVar.k = aVar;
                    }
                    z = z2;
                }
            } else {
                dVar.c = aVar2;
                fVar.k = aVar2;
                z = true;
            }
        }
        d dVar3 = this.i;
        boolean z5 = dVar3.b;
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar4 = dVar3.f2007a;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar5 = dVar3.c;
        dVar3.f2007a = null;
        dVar3.b = false;
        dVar3.c = null;
        if (z5) {
            this.y = z;
            return z;
        }
        if (aVar4 == null) {
            if (aVar5 == null) {
                return false;
            }
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h) this.b.f2009a.d.get(aVar5)).b();
            return false;
        }
        if (aVar4 instanceof h) {
            this.x = -9223372036854775807L;
            h hVar5 = (h) aVar4;
            hVar5.D = this;
            int i9 = hVar5.j;
            boolean z6 = hVar5.t;
            this.r = i9;
            for (int i10 = 0; i10 < this.j.size(); i10++) {
                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i10)).c.r = i9;
            }
            if (z6) {
                for (int i11 = 0; i11 < this.j.size(); i11++) {
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i11)).m = z;
                }
            }
            this.k.add(hVar5);
        }
        B b = this.g;
        int i12 = this.f;
        b.getClass();
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            throw new IllegalStateException();
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        y yVar = new y(b, looperMyLooper, aVar4, this, i12, jElapsedRealtime2);
        if (b.b != null) {
            throw new IllegalStateException();
        }
        b.b = yVar;
        yVar.e = null;
        b.f2145a.execute(yVar);
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar2 = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar4 = aVar4.f2122a;
        int i13 = aVar4.b;
        int i14 = this.f2013a;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = aVar4.c;
        int i15 = aVar4.d;
        Object obj = aVar4.e;
        long j11 = aVar4.f;
        long j12 = aVar4.g;
        if (fVar2.b != null) {
            fVar2.f2125a.post(new RunnableC3162a(fVar2, kVar4, i13, i14, oVar2, i15, obj, j11, j12, jElapsedRealtime2));
        }
        return z;
    }

    public final void c(long j) {
        this.w = j;
        this.x = j;
        this.y = false;
        this.k.clear();
        if (this.g.a()) {
            this.g.b.a(false);
            return;
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i)).a(this.v[i]);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public final void e() {
        this.m.post(this.l);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final long f() {
        long j = this.x;
        if (j != -9223372036854775807L) {
            return j;
        }
        if (this.y) {
            return Long.MIN_VALUE;
        }
        return ((h) this.k.getLast()).g;
    }

    public final void h() {
        if (this.s || this.o || !this.n) {
            return;
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i)).e() == null) {
                return;
            }
        }
        int size2 = this.j.size();
        int i2 = 0;
        char c = 0;
        int i3 = -1;
        while (true) {
            char c2 = 3;
            if (i2 >= size2) {
                break;
            }
            String str = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i2)).e().f;
            if (!"video".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str))) {
                c2 = "audio".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str)) ? (char) 2 : "text".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str)) ? (char) 1 : (char) 0;
            }
            if (c2 > c) {
                i3 = i2;
                c = c2;
            } else if (c2 == c && i3 != -1) {
                i3 = -1;
            }
            i2++;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.source.y yVar = this.c.f;
        int i4 = yVar.f2136a;
        this.u = -1;
        this.v = new boolean[size2];
        com.fyber.inneractive.sdk.player.exoplayer2.source.y[] yVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.source.y[size2];
        for (int i5 = 0; i5 < size2; i5++) {
            com.fyber.inneractive.sdk.player.exoplayer2.o oVarE = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i5)).e();
            if (i5 == i3) {
                com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.o[i4];
                for (int i6 = 0; i6 < i4; i6++) {
                    oVarArr[i6] = a(yVar.b[i6], oVarE);
                }
                yVarArr[i5] = new com.fyber.inneractive.sdk.player.exoplayer2.source.y(oVarArr);
                this.u = i5;
            } else {
                yVarArr[i5] = new com.fyber.inneractive.sdk.player.exoplayer2.source.y(a((c == 3 && "audio".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(oVarE.f))) ? this.e : null, oVarE));
            }
        }
        this.t = new z(yVarArr);
        this.o = true;
        i iVar = this.b;
        int i7 = iVar.k - 1;
        iVar.k = i7;
        if (i7 > 0) {
            return;
        }
        int i8 = 0;
        for (n nVar : iVar.n) {
            i8 += nVar.t.f2137a;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.source.y[] yVarArr2 = new com.fyber.inneractive.sdk.player.exoplayer2.source.y[i8];
        int i9 = 0;
        for (n nVar2 : iVar.n) {
            int i10 = nVar2.t.f2137a;
            int i11 = 0;
            while (i11 < i10) {
                yVarArr2[i9] = nVar2.t.b[i11];
                i11++;
                i9++;
            }
        }
        iVar.m = new z(yVarArr2);
        ((com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j).f.obtainMessage(8, iVar).sendToTarget();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2, boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) zVar;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = aVar.f2122a;
        int i = aVar.b;
        int i2 = this.f2013a;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar = aVar.c;
        int i3 = aVar.d;
        Object obj = aVar.e;
        long j3 = aVar.f;
        long j4 = aVar.g;
        long jC = aVar.c();
        if (fVar.b != null) {
            fVar.f2125a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.c(fVar, kVar, i, i2, oVar, i3, obj, j3, j4, j, j2, jC));
        }
        if (z) {
            return;
        }
        int size = this.j.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i4)).a(this.v[i4]);
        }
        i iVar = this.b;
        iVar.getClass();
        if (iVar.m == null) {
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j;
        lVar.getClass();
        lVar.f.obtainMessage(9, iVar).sendToTarget();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) zVar;
        f fVar = this.c;
        fVar.getClass();
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            fVar.i = cVar.i;
            fVar.a(cVar.f2122a.f2163a, cVar.l, cVar.m);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar2 = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = aVar.f2122a;
        int i = aVar.b;
        int i2 = this.f2013a;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar = aVar.c;
        int i3 = aVar.d;
        Object obj = aVar.e;
        long j3 = aVar.f;
        long j4 = aVar.g;
        long jC = aVar.c();
        if (fVar2.b != null) {
            fVar2.f2125a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.b(fVar2, kVar, i, i2, oVar, i3, obj, j3, j4, j, j2, jC));
        }
        if (!this.o) {
            b(this.w);
            return;
        }
        i iVar = this.b;
        iVar.getClass();
        if (iVar.m == null) {
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j;
        lVar.getClass();
        lVar.f.obtainMessage(9, iVar).sendToTarget();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:55:0x0101  */
    /* JADX WARN: Code duplicated, block: B:57:0x0116  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2, IOException iOException) {
        boolean z;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar;
        int i;
        int i2;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar;
        int i3;
        Object obj;
        long j3;
        long j4;
        long jC;
        i iVar;
        boolean zA;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.v vVar;
        int i4;
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) zVar;
        boolean z2 = aVar instanceof h;
        boolean z3 = !z2 || aVar.c() == 0;
        f fVar2 = this.c;
        if (z3) {
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = fVar2.p;
            int iA = fVar2.f.a(aVar.c);
            int i5 = 0;
            while (true) {
                if (i5 >= bVar.b) {
                    i5 = -1;
                    break;
                }
                if (bVar.c[i5] == iA) {
                    break;
                }
                i5++;
            }
            if ((iOException instanceof com.fyber.inneractive.sdk.player.exoplayer2.upstream.v) && ((i4 = (vVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.v) iOException).f2171a) == 404 || i4 == 410)) {
                zA = bVar.a(i5);
                int i6 = vVar.f2171a;
                if (zA) {
                    Log.w("ChunkedTrackBlacklist", l.a("Blacklisted: duration=60000, responseCode=", i6, ", format=").append(bVar.d[i5]).toString());
                } else {
                    Log.w("ChunkedTrackBlacklist", l.a("Blacklisting failed (cannot blacklist last enabled track): responseCode=", i6, ", format=").append(bVar.d[i5]).toString());
                }
            } else {
                zA = false;
            }
            if (zA) {
                if (z2) {
                    if (((h) this.k.removeLast()) == aVar) {
                        if (this.k.isEmpty()) {
                            this.x = this.w;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                }
                z = true;
            }
            fVar = this.h;
            kVar = aVar.f2122a;
            i = aVar.b;
            i2 = this.f2013a;
            oVar = aVar.c;
            i3 = aVar.d;
            obj = aVar.e;
            j3 = aVar.f;
            j4 = aVar.g;
            jC = aVar.c();
            if (fVar.b != null) {
                fVar.f2125a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.d(fVar, kVar, i, i2, oVar, i3, obj, j3, j4, j, j2, jC, iOException, z));
            }
            if (z) {
                return 0;
            }
            if (!this.o) {
                b(this.w);
            } else {
                iVar = this.b;
                iVar.getClass();
                if (iVar.m != null) {
                    com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j;
                    lVar.getClass();
                    lVar.f.obtainMessage(9, iVar).sendToTarget();
                }
            }
            return 2;
        }
        fVar2.getClass();
        z = false;
        fVar = this.h;
        kVar = aVar.f2122a;
        i = aVar.b;
        i2 = this.f2013a;
        oVar = aVar.c;
        i3 = aVar.d;
        obj = aVar.e;
        j3 = aVar.f;
        j4 = aVar.g;
        jC = aVar.c();
        if (fVar.b != null) {
            fVar.f2125a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.d(fVar, kVar, i, i2, oVar, i3, obj, j3, j4, j, j2, jC, iOException, z));
        }
        if (z) {
            return 0;
        }
        if (!this.o) {
            b(this.w);
        } else {
            iVar = this.b;
            iVar.getClass();
            if (iVar.m != null) {
                com.fyber.inneractive.sdk.player.exoplayer2.l lVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j;
                lVar2.getClass();
                lVar2.f.obtainMessage(9, iVar).sendToTarget();
            }
        }
        return 2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a(int i, int i2) {
        if (this.j.indexOfKey(i) >= 0) {
            return (com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.get(i);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.g(this.d);
        gVar.n = this;
        gVar.c.r = this.r;
        this.j.put(i, gVar);
        return gVar;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.o a(com.fyber.inneractive.sdk.player.exoplayer2.o oVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar2) {
        String strA;
        if (oVar == null) {
            return oVar2;
        }
        int iC = com.fyber.inneractive.sdk.player.exoplayer2.util.i.c(oVar2.f);
        if (iC == 1) {
            strA = a(oVar.c, 1);
        } else {
            strA = iC == 2 ? a(oVar.c, 2) : null;
        }
        return new com.fyber.inneractive.sdk.player.exoplayer2.o(oVar.f2116a, oVar2.e, oVar2.f, strA, oVar.b, oVar2.g, oVar.j, oVar.k, oVar2.l, oVar2.m, oVar2.n, oVar2.p, oVar2.o, oVar2.q, oVar2.r, oVar2.s, oVar2.t, oVar2.u, oVar2.v, oVar.x, oVar.y, oVar2.z, oVar2.w, oVar2.h, oVar2.i, oVar2.d);
    }

    public static String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (i == com.fyber.inneractive.sdk.player.exoplayer2.util.i.c(com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(str2))) {
                if (sb.length() > 0) {
                    sb.append(StringUtils.COMMA);
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final void b() {
        this.n = true;
        this.m.post(this.l);
    }
}
