package com.fyber.inneractive.sdk.player.exoplayer2.source;

/* JADX INFO: loaded from: classes14.dex */
public final class x extends com.fyber.inneractive.sdk.player.exoplayer2.x {
    public static final Object g = new Object();
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;

    public x(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.x
    public final int a() {
        return 1;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.x
    public final int b() {
        return 1;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.x
    public final com.fyber.inneractive.sdk.player.exoplayer2.w a(int i, com.fyber.inneractive.sdk.player.exoplayer2.w wVar, long j) {
        if (i < 0 || i >= 1) {
            throw new IndexOutOfBoundsException();
        }
        long j2 = this.e;
        boolean z = this.f;
        if (z) {
            j2 += j;
            if (j2 > this.c) {
                j2 = -9223372036854775807L;
            }
        }
        long j3 = this.c;
        long j4 = this.d;
        wVar.f2208a = null;
        wVar.b = z;
        wVar.e = j2;
        wVar.f = j3;
        wVar.c = 0;
        wVar.d = 0;
        wVar.g = j4;
        return wVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.x
    public final com.fyber.inneractive.sdk.player.exoplayer2.v a(int i, com.fyber.inneractive.sdk.player.exoplayer2.v vVar, boolean z) {
        if (i >= 0 && i < 1) {
            Object obj = z ? g : null;
            long j = this.b;
            long j2 = -this.d;
            vVar.f2193a = obj;
            vVar.b = obj;
            vVar.c = 0;
            vVar.d = j;
            vVar.e = j2;
            return vVar;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.x
    public final int a(Object obj) {
        return g.equals(obj) ? 0 : -1;
    }
}
