package com.fyber.inneractive.sdk.player.exoplayer2.source;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w[] f2126a;

    public h(w[] wVarArr) {
        this.f2126a = wVarArr;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final boolean b(long j) {
        boolean zB;
        boolean z = false;
        do {
            long jF = f();
            if (jF == Long.MIN_VALUE) {
                break;
            }
            zB = false;
            for (w wVar : this.f2126a) {
                if (wVar.f() == jF) {
                    zB |= wVar.b(j);
                }
            }
            z |= zB;
        } while (zB);
        return z;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final long f() {
        long jMin = Long.MAX_VALUE;
        for (w wVar : this.f2126a) {
            long jF = wVar.f();
            if (jF != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jF);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }
}
