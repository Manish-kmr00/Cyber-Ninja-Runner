package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2079a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.r[] b;
    public boolean c;
    public int d;
    public int e;
    public long f;

    public g(List list) {
        this.f2079a = list;
        this.b = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.r[list.size()];
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        this.c = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
        if (this.c) {
            for (com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar : this.b) {
                rVar.a(this.f, 1, this.e, 0, null);
            }
            this.c = false;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
        for (int i = 0; i < this.b.length; i++) {
            C c = (C) this.f2079a.get(i);
            e.a();
            e.b();
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e.d, 3);
            e.b();
            gVarA.a(new com.fyber.inneractive.sdk.player.exoplayer2.o(e.e, null, "application/dvbsubs", null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, c.f2070a, -1, Long.MAX_VALUE, Collections.singletonList(c.b), null, null));
            this.b[i] = gVarA;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        if (z) {
            this.c = true;
            this.f = j;
            this.e = 0;
            this.d = 2;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        boolean z;
        boolean z2;
        if (this.c) {
            if (this.d == 2) {
                if (nVar.c - nVar.b == 0) {
                    z2 = false;
                } else {
                    if (nVar.j() != 32) {
                        this.c = false;
                    }
                    this.d--;
                    z2 = this.c;
                }
                if (!z2) {
                    return;
                }
            }
            if (this.d == 1) {
                if (nVar.c - nVar.b == 0) {
                    z = false;
                } else {
                    if (nVar.j() != 0) {
                        this.c = false;
                    }
                    this.d--;
                    z = this.c;
                }
                if (!z) {
                    return;
                }
            }
            int i = nVar.b;
            int i2 = nVar.c - i;
            for (com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar : this.b) {
                nVar.e(i);
                rVar.a(i2, nVar);
            }
            this.e += i2;
        }
    }
}
