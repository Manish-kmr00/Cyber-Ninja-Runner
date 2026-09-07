package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* JADX INFO: loaded from: classes8.dex */
public final class y implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.exoplayer2.util.v f2095a;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r b;
    public boolean c;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, E e) {
        this.f2095a = vVar;
        e.a();
        e.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e.d, 4);
        this.b = gVarA;
        e.b();
        gVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(e.e, "application/x-scte35", (com.fyber.inneractive.sdk.player.exoplayer2.drm.d) null));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        long j;
        long j2;
        long j3;
        long j4 = -9223372036854775807L;
        if (!this.c) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar = this.f2095a;
            long j5 = 0;
            if (vVar.f2190a == Long.MAX_VALUE) {
                j2 = 0;
            } else {
                j2 = vVar.c == -9223372036854775807L ? -9223372036854775807L : vVar.b;
            }
            if (j2 == -9223372036854775807L) {
                return;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = this.b;
            com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar2 = this.f2095a;
            if (vVar2.f2190a == Long.MAX_VALUE) {
                j3 = j5;
            } else if (vVar2.c == -9223372036854775807L) {
                j3 = -9223372036854775807L;
            } else {
                j5 = vVar2.b;
                j3 = j5;
            }
            rVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.o(null, null, "application/x-scte35", null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j3, null, null, null));
            this.c = true;
        }
        int i = nVar.c - nVar.b;
        this.b.a(i, nVar);
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar2 = this.b;
        com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar3 = this.f2095a;
        if (vVar3.c != -9223372036854775807L) {
            j4 = vVar3.c;
        } else {
            long j6 = vVar3.f2190a;
            if (j6 != Long.MAX_VALUE) {
                j = j6;
            }
            rVar2.a(j, 1, i, 0, null);
        }
        j = j4;
        rVar2.a(j, 1, i, 0, null);
    }
}
