package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* JADX INFO: loaded from: classes8.dex */
public final class z implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.m f2096a = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(new byte[4]);
    public final /* synthetic */ B b;

    public z(B b) {
        this.b = b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (nVar.j() != 0) {
            return;
        }
        nVar.e(nVar.b + 7);
        int i = (nVar.c - nVar.b) / 4;
        for (int i2 = 0; i2 < i; i2++) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.m mVar = this.f2096a;
            nVar.a(mVar.f2183a, 0, 4);
            mVar.b(0);
            int iA = this.f2096a.a(16);
            this.f2096a.c(3);
            if (iA == 0) {
                this.f2096a.c(13);
            } else {
                int iA2 = this.f2096a.a(13);
                B b = this.b;
                b.f.put(iA2, new w(new A(b, iA2)));
                this.b.i++;
            }
        }
        B b2 = this.b;
        if (b2.f2069a != 2) {
            b2.f.remove(0);
        }
    }
}
