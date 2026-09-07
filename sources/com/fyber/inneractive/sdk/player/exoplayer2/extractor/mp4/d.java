package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2036a;
    public int b;
    public int c;
    public long d;
    public final boolean e;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n g;
    public int h;
    public int i;

    public d(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2, boolean z) {
        this.g = nVar;
        this.f = nVar2;
        this.e = z;
        nVar2.e(12);
        this.f2036a = nVar2.m();
        nVar.e(12);
        this.i = nVar.m();
        if (!(nVar.b() == 1)) {
            throw new IllegalStateException("first_chunk must be 1");
        }
        this.b = -1;
    }

    public final boolean a() {
        int i = this.b + 1;
        this.b = i;
        if (i == this.f2036a) {
            return false;
        }
        this.d = this.e ? this.f.n() : this.f.k();
        if (this.b == this.h) {
            this.c = this.g.m();
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.g;
            nVar.e(nVar.b + 4);
            int i2 = this.i - 1;
            this.i = i2;
            this.h = i2 > 0 ? this.g.m() - 1 : -1;
        }
        return true;
    }
}
