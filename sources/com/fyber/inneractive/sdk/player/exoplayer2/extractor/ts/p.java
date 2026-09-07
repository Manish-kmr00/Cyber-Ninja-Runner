package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public final class p implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f2087a = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(10);
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r b;
    public boolean c;
    public long d;
    public int e;
    public int f;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        this.c = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
        int i;
        if (this.c && (i = this.e) != 0 && this.f == i) {
            this.b.a(this.d, 1, i, 0, null);
            this.c = false;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
        e.a();
        e.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e.d, 4);
        this.b = gVarA;
        e.b();
        gVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(e.e, "application/id3", (com.fyber.inneractive.sdk.player.exoplayer2.drm.d) null));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        if (z) {
            this.c = true;
            this.d = j;
            this.e = 0;
            this.f = 0;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (this.c) {
            int i = nVar.c - nVar.b;
            int i2 = this.f;
            if (i2 < 10) {
                int iMin = Math.min(i, 10 - i2);
                System.arraycopy(nVar.f2184a, nVar.b, this.f2087a.f2184a, this.f, iMin);
                if (this.f + iMin == 10) {
                    this.f2087a.e(0);
                    if (73 == this.f2087a.j() && 68 == this.f2087a.j() && 51 == this.f2087a.j()) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.f2087a;
                        nVar2.e(nVar2.b + 3);
                        this.e = this.f2087a.i() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    }
                }
            }
            int iMin2 = Math.min(i, this.e - this.f);
            this.b.a(iMin2, nVar);
            this.f += iMin2;
        }
    }
}
