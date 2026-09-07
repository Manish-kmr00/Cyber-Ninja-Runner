package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.o;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.q;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements i, q {
    public static final int n = z.a("FLV");
    public j e;
    public int g;
    public int h;
    public int i;
    public long j;
    public a k;
    public f l;
    public c m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f2002a = new n(4);
    public final n b = new n(9);
    public final n c = new n(11);
    public final n d = new n();
    public int f = 1;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return false;
    }

    public final n b(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) throws InterruptedException, EOFException {
        if (this.i > this.d.a()) {
            n nVar = this.d;
            nVar.f2184a = new byte[Math.max(nVar.a() * 2, this.i)];
            nVar.c = 0;
            nVar.b = 0;
        } else {
            this.d.e(0);
        }
        this.d.d(this.i);
        bVar.b(this.d.f2184a, 0, this.i, false);
        return this.d;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return this.m.b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) throws InterruptedException, EOFException {
        bVar.a(this.f2002a.f2184a, 0, 3, false);
        this.f2002a.e(0);
        if (this.f2002a.l() != n) {
            return false;
        }
        bVar.a(this.f2002a.f2184a, 0, 2, false);
        this.f2002a.e(0);
        if ((this.f2002a.o() & 250) != 0) {
            return false;
        }
        bVar.a(this.f2002a.f2184a, 0, 4, false);
        this.f2002a.e(0);
        int iB = this.f2002a.b();
        bVar.e = 0;
        bVar.a(iB, false);
        bVar.a(this.f2002a.f2184a, 0, 4, false);
        this.f2002a.e(0);
        return this.f2002a.b() == 0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(j jVar) {
        this.e = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.f = 1;
        this.g = 0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, o oVar) throws InterruptedException, r, EOFException {
        c cVar;
        f fVar;
        a aVar;
        while (true) {
            int i = this.f;
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    bVar.a(this.g);
                    this.g = 0;
                    this.f = 3;
                } else if (i != 3) {
                    if (i == 4) {
                        int i2 = this.h;
                        if (i2 == 8 && (aVar = this.k) != null) {
                            n nVarB = b(bVar);
                            long j = this.j;
                            aVar.a(nVarB);
                            aVar.a(nVarB, j);
                        } else if (i2 == 9 && (fVar = this.l) != null) {
                            n nVarB2 = b(bVar);
                            long j2 = this.j;
                            if (fVar.a(nVarB2)) {
                                fVar.a(nVarB2, j2);
                            }
                        } else if (i2 == 18 && (cVar = this.m) != null) {
                            cVar.a(b(bVar), this.j);
                        } else {
                            bVar.a(this.i);
                            z = false;
                        }
                        this.g = 4;
                        this.f = 2;
                        if (z) {
                            return 0;
                        }
                    } else {
                        continue;
                    }
                } else {
                    if (!bVar.b(this.c.f2184a, 0, 11, true)) {
                        return -1;
                    }
                    this.c.e(0);
                    this.h = this.c.j();
                    this.i = this.c.l();
                    this.j = this.c.l();
                    this.j = (((long) (this.c.j() << 24)) | this.j) * 1000;
                    n nVar = this.c;
                    nVar.e(nVar.b + 3);
                    this.f = 4;
                }
            } else {
                if (!bVar.b(this.b.f2184a, 0, 9, true)) {
                    return -1;
                }
                this.b.e(0);
                n nVar2 = this.b;
                nVar2.e(nVar2.b + 4);
                int iJ = this.b.j();
                boolean z2 = (iJ & 4) != 0;
                boolean z3 = (iJ & 1) != 0;
                if (z2 && this.k == null) {
                    this.k = new a(this.e.a(8, 1));
                }
                if (z3 && this.l == null) {
                    this.l = new f(this.e.a(9, 2));
                }
                if (this.m == null) {
                    this.m = new c();
                }
                this.e.b();
                this.e.a(this);
                this.g = this.b.b() - 5;
                this.f = 2;
            }
        }
    }
}
