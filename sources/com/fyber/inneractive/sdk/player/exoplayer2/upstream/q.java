package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

/* JADX INFO: loaded from: classes9.dex */
public final class q implements g {
    public final String b;
    public final m c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f2169a = new w();
    public final int d = 2000;
    public final int e = 2000;
    public final boolean f = true;

    public q(String str, m mVar) {
        this.b = str;
        this.c = mVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public final h a() {
        return new p(this.b, this.c, this.d, this.e, this.f, this.f2169a);
    }
}
