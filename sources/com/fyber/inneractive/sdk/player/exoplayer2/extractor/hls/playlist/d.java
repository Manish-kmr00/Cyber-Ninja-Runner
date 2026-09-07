package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends e {
    public final int b;
    public final long c;
    public final long d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final long i;
    public final boolean j;
    public final boolean k;
    public final c l;
    public final List m;
    public final List n;
    public final long o;

    public d(int i, String str, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, c cVar, List list, List list2) {
        super(str);
        this.b = i;
        this.d = j2;
        this.e = z;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = j3;
        this.j = z2;
        this.k = z3;
        this.l = cVar;
        this.m = Collections.unmodifiableList(list);
        if (list.isEmpty()) {
            this.o = 0L;
        } else {
            c cVar2 = (c) list.get(list.size() - 1);
            this.o = cVar2.d + cVar2.b;
        }
        this.c = j == -9223372036854775807L ? -9223372036854775807L : j >= 0 ? j : this.o + j;
        this.n = Collections.unmodifiableList(list2);
    }
}
