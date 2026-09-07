package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.os.Looper;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.n;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.source.t;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.B;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.D;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.v;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.z;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements x, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2021a;
    public final B b = new B("HlsPlaylistTracker:MediaPlaylist");
    public final D c;
    public d d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public IOException j;
    public final /* synthetic */ k k;

    public h(k kVar, a aVar, long j) {
        this.k = kVar;
        this.f2021a = aVar;
        this.g = j;
        this.c = new D(kVar.f2022a.f2006a.a(), com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(kVar.j.f2018a, aVar.f2016a), kVar.b);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(z zVar, long j, long j2, boolean z) {
        D d = (D) zVar;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.k.i;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d.f2146a;
        long j3 = d.f;
        if (fVar.b != null) {
            fVar.f2125a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.c(fVar, kVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3));
        }
    }

    public final void b() {
        this.h = 0L;
        if (this.i || this.b.a()) {
            return;
        }
        B b = this.b;
        D d = this.c;
        int i = this.k.c;
        b.getClass();
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            throw new IllegalStateException();
        }
        y yVar = new y(b, looperMyLooper, d, this, i, SystemClock.elapsedRealtime());
        if (b.b != null) {
            throw new IllegalStateException();
        }
        b.b = yVar;
        yVar.e = null;
        b.f2145a.execute(yVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.i = false;
        b();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(z zVar, long j, long j2) {
        D d = (D) zVar;
        e eVar = d.d;
        if (eVar instanceof d) {
            a((d) eVar);
            com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.k.i;
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d.f2146a;
            long j3 = d.f;
            if (fVar.b != null) {
                fVar.f2125a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.b(fVar, kVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3));
                return;
            }
            return;
        }
        this.j = new r("Loaded playlist has unexpected type.");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final int a(z zVar, long j, long j2, IOException iOException) {
        boolean z;
        int i;
        D d = (D) zVar;
        boolean z2 = iOException instanceof r;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.k.i;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d.f2146a;
        long j3 = d.f;
        if (fVar.b != null) {
            z = z2;
            fVar.f2125a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.d(fVar, kVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z));
        } else {
            z = z2;
        }
        if (z) {
            return 3;
        }
        if ((iOException instanceof v) && ((i = ((v) iOException).f2171a) == 404 || i == 410)) {
            a();
            k kVar2 = this.k;
            if (kVar2.k == this.f2021a) {
                List list = kVar2.j.b;
                int size = list.size();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                for (int i2 = 0; i2 < size; i2++) {
                    h hVar = (h) kVar2.d.get(list.get(i2));
                    if (jElapsedRealtime > hVar.h) {
                        kVar2.k = hVar.f2021a;
                        hVar.b();
                    }
                }
            }
            return 2;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0218  */
    /* JADX WARN: Code duplicated, block: B:108:0x021c  */
    /* JADX WARN: Code duplicated, block: B:110:0x022e  */
    /* JADX WARN: Code duplicated, block: B:111:0x023d  */
    /* JADX WARN: Code duplicated, block: B:113:0x024c  */
    /* JADX WARN: Code duplicated, block: B:115:0x025f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0264  */
    /* JADX WARN: Code duplicated, block: B:124:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0135  */
    /* JADX WARN: Code duplicated, block: B:66:0x0141  */
    /* JADX WARN: Code duplicated, block: B:68:0x0145  */
    /* JADX WARN: Code duplicated, block: B:71:0x015a  */
    /* JADX WARN: Code duplicated, block: B:73:0x015e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0165  */
    /* JADX WARN: Code duplicated, block: B:77:0x016c  */
    /* JADX WARN: Code duplicated, block: B:79:0x0172  */
    /* JADX WARN: Code duplicated, block: B:80:0x0175  */
    /* JADX WARN: Code duplicated, block: B:81:0x0187 A[PHI: r10
  0x0187: PHI (r10v15 long) = (r10v12 long), (r10v17 long) binds: [B:76:0x016a, B:80:0x0175] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:83:0x019e  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:91:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:93:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:94:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:96:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:98:0x0200  */
    /* JADX WARN: Instruction removed from duplicated block: B:94:0x01f4, please report this as an issue */
    public final void a(d dVar) {
        long j;
        long j2;
        long j3;
        int i;
        d dVar2;
        long j4;
        k kVar;
        a aVar;
        int size;
        int i2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i iVar;
        int i3;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j jVar;
        long j5;
        long j6;
        com.fyber.inneractive.sdk.player.exoplayer2.source.x xVar;
        long j7;
        List list;
        long j8;
        int size2;
        int size3;
        d dVar3 = this.d;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.e = jElapsedRealtime;
        k kVar2 = this.k;
        kVar2.getClass();
        if (dVar3 != null) {
            int i4 = dVar.g;
            int i5 = dVar3.g;
            if (i4 <= i5 && (i4 < i5 || ((size2 = dVar.m.size()) <= (size3 = dVar3.m.size()) && (size2 != size3 || !dVar.j || dVar3.j)))) {
                dVar2 = (!dVar.j || dVar3.j) ? dVar3 : new d(dVar3.b, dVar3.f2018a, dVar3.c, dVar3.d, dVar3.e, dVar3.f, dVar3.g, dVar3.h, dVar3.i, true, dVar3.k, dVar3.l, dVar3.m, dVar3.n);
            }
            this.d = dVar2;
            if (dVar2 != dVar3) {
                this.j = null;
                this.f = jElapsedRealtime;
                kVar = this.k;
                aVar = this.f2021a;
                if (aVar == kVar.k) {
                    if (kVar.l == null) {
                        kVar.m = !dVar2.j;
                    }
                    kVar.l = dVar2;
                    jVar = kVar.f;
                    jVar.getClass();
                    j5 = dVar2.c;
                    if (jVar.d.m) {
                        if (dVar2.j) {
                            j7 = dVar2.d + dVar2.o;
                        } else {
                            j7 = -9223372036854775807L;
                        }
                        list = dVar2.m;
                        if (j5 != -9223372036854775807L) {
                            j8 = j5;
                        } else if (list.isEmpty()) {
                            j8 = 0;
                        } else {
                            j5 = ((c) list.get(Math.max(0, list.size() - 3))).d;
                            j8 = j5;
                        }
                        xVar = new com.fyber.inneractive.sdk.player.exoplayer2.source.x(j7, dVar2.o, dVar2.d, j8, true, !dVar2.j);
                    } else {
                        if (j5 == -9223372036854775807L) {
                            j6 = 0;
                        } else {
                            j6 = j5;
                        }
                        long j9 = dVar2.d;
                        long j10 = dVar2.o;
                        xVar = new com.fyber.inneractive.sdk.player.exoplayer2.source.x(j9 + j10, j10, j9, j6, true, false);
                    }
                    t tVar = jVar.e;
                    b bVar = jVar.d.j;
                    tVar.a(xVar, new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g());
                }
                size = kVar.g.size();
                for (i2 = 0; i2 < size; i2++) {
                    iVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i) kVar.g.get(i2);
                    if (iVar.m != null) {
                        l lVar = (l) iVar.j;
                        lVar.getClass();
                        lVar.f.obtainMessage(9, iVar).sendToTarget();
                    } else {
                        for (n nVar : iVar.n) {
                            if (!nVar.o) {
                                nVar.b(nVar.w);
                            }
                        }
                    }
                }
                if (aVar == kVar.k || dVar2.j) {
                    j4 = -9223372036854775807L;
                } else {
                    j4 = this.d.i;
                }
            } else if (dVar2.j) {
                j4 = -9223372036854775807L;
            } else {
                if (jElapsedRealtime - this.f > com.fyber.inneractive.sdk.player.exoplayer2.b.a(dVar2.i) * 3.5d) {
                    String str = this.f2021a.f2016a;
                    this.j = new j();
                    a();
                } else if (dVar.m.size() + dVar.g < this.d.g) {
                    String str2 = this.f2021a.f2016a;
                    this.j = new i();
                }
                j4 = this.d.i / 2;
            }
            if (j4 != -9223372036854775807L) {
                this.i = this.k.e.postDelayed(this, com.fyber.inneractive.sdk.player.exoplayer2.b.a(j4));
            }
        }
        dVar.getClass();
        if (dVar.k) {
            j = dVar.d;
        } else {
            d dVar4 = kVar2.l;
            j = dVar4 != null ? dVar4.d : 0L;
            if (dVar3 != null) {
                int size4 = dVar3.m.size();
                int i6 = dVar.g - dVar3.g;
                List list2 = dVar3.m;
                c cVar = i6 < list2.size() ? (c) list2.get(i6) : null;
                if (cVar != null) {
                    j2 = dVar3.d;
                    j3 = cVar.d;
                } else if (size4 == dVar.g - dVar3.g) {
                    j2 = dVar3.d;
                    j3 = dVar3.o;
                }
                j = j2 + j3;
            }
        }
        long j11 = j;
        if (dVar.e) {
            i = dVar.f;
        } else {
            d dVar5 = kVar2.l;
            i = dVar5 != null ? dVar5.f : 0;
            if (dVar3 != null) {
                int i7 = dVar.g - dVar3.g;
                List list3 = dVar3.m;
                c cVar2 = i7 < list3.size() ? (c) list3.get(i7) : null;
                if (cVar2 != null) {
                    i = (dVar3.f + cVar2.c) - ((c) dVar.m.get(0)).c;
                }
            }
        }
        dVar2 = new d(dVar.b, dVar.f2018a, dVar.c, j11, true, i, dVar.g, dVar.h, dVar.i, dVar.j, dVar.k, dVar.l, dVar.m, dVar.n);
        this.d = dVar2;
        if (dVar2 != dVar3) {
            this.j = null;
            this.f = jElapsedRealtime;
            kVar = this.k;
            aVar = this.f2021a;
            if (aVar == kVar.k) {
                if (kVar.l == null) {
                    kVar.m = !dVar2.j;
                }
                kVar.l = dVar2;
                jVar = kVar.f;
                jVar.getClass();
                j5 = dVar2.c;
                if (jVar.d.m) {
                    if (dVar2.j) {
                        j7 = dVar2.d + dVar2.o;
                    } else {
                        j7 = -9223372036854775807L;
                    }
                    list = dVar2.m;
                    if (j5 != -9223372036854775807L) {
                        j8 = j5;
                    } else if (list.isEmpty()) {
                        j8 = 0;
                    } else {
                        j5 = ((c) list.get(Math.max(0, list.size() - 3))).d;
                        j8 = j5;
                    }
                    xVar = new com.fyber.inneractive.sdk.player.exoplayer2.source.x(j7, dVar2.o, dVar2.d, j8, true, !dVar2.j);
                } else {
                    if (j5 == -9223372036854775807L) {
                        j6 = 0;
                    } else {
                        j6 = j5;
                    }
                    long j12 = dVar2.d;
                    long j13 = dVar2.o;
                    xVar = new com.fyber.inneractive.sdk.player.exoplayer2.source.x(j12 + j13, j13, j12, j6, true, false);
                }
                t tVar2 = jVar.e;
                b bVar2 = jVar.d.j;
                tVar2.a(xVar, new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g());
            }
            size = kVar.g.size();
            while (i2 < size) {
                iVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i) kVar.g.get(i2);
                if (iVar.m != null) {
                    l lVar2 = (l) iVar.j;
                    lVar2.getClass();
                    lVar2.f.obtainMessage(9, iVar).sendToTarget();
                } else {
                    while (i3 < r10) {
                        if (!nVar.o) {
                            nVar.b(nVar.w);
                        }
                    }
                }
            }
            if (aVar == kVar.k) {
                j4 = -9223372036854775807L;
            } else {
                j4 = -9223372036854775807L;
            }
        } else if (dVar2.j) {
            if (jElapsedRealtime - this.f > com.fyber.inneractive.sdk.player.exoplayer2.b.a(dVar2.i) * 3.5d) {
                String str3 = this.f2021a.f2016a;
                this.j = new j();
                a();
            } else if (dVar.m.size() + dVar.g < this.d.g) {
                String str4 = this.f2021a.f2016a;
                this.j = new i();
            }
            j4 = this.d.i / 2;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            this.i = this.k.e.postDelayed(this, com.fyber.inneractive.sdk.player.exoplayer2.b.a(j4));
        }
    }

    public final void a() {
        this.h = SystemClock.elapsedRealtime() + 60000;
        k kVar = this.k;
        a aVar = this.f2021a;
        int size = kVar.g.size();
        for (int i = 0; i < size; i++) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i iVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i) kVar.g.get(i);
            for (n nVar : iVar.n) {
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f fVar = nVar.c;
                int iA = fVar.f.a(aVar.b);
                if (iA != -1) {
                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = fVar.p;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= bVar.b) {
                            i2 = -1;
                            break;
                        } else if (bVar.c[i2] == iA) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 != -1) {
                        fVar.p.a(i2);
                    }
                }
            }
            if (iVar.m != null) {
                l lVar = (l) iVar.j;
                lVar.getClass();
                lVar.f.obtainMessage(9, iVar).sendToTarget();
            } else {
                for (n nVar2 : iVar.n) {
                    if (!nVar2.o) {
                        nVar2.b(nVar2.w);
                    }
                }
            }
        }
    }
}
