package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

/* JADX INFO: loaded from: classes11.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f2062a;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r b;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j c;
    public h d;
    public long e;
    public long f;
    public long g;
    public int h;
    public int i;
    public j j;
    public long k;
    public boolean l;
    public boolean m;

    public abstract long a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar);

    public void a(boolean z) {
        if (z) {
            this.j = new j();
            this.f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }

    public abstract boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, long j, j jVar);

    public void a(long j) {
        this.g = j;
    }
}
