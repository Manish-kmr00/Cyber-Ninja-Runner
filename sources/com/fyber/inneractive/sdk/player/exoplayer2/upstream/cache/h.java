package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.util.TreeSet;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2154a;
    public final String b;
    public final TreeSet c = new TreeSet();
    public long d;

    public h(int i, String str, long j) {
        this.f2154a = i;
        this.b = str;
        this.d = j;
    }

    public final m a(long j) {
        m mVar = new m(this.b, j, -1L, -9223372036854775807L, null);
        m mVar2 = (m) this.c.floor(mVar);
        if (mVar2 != null && mVar2.b + mVar2.c > j) {
            return mVar2;
        }
        m mVar3 = (m) this.c.ceiling(mVar);
        return mVar3 == null ? new m(this.b, j, -1L, -9223372036854775807L, null) : new m(this.b, j, mVar3.b - j, -9223372036854775807L, null);
    }
}
