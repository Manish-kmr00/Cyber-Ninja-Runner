package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2017a;
    public final long b;
    public final int c;
    public final long d;
    public final boolean e;
    public final String f;
    public final String g;
    public final long h;
    public final long i;

    public c(String str, long j, int i, long j2, boolean z, String str2, String str3, long j3, long j4) {
        this.f2017a = str;
        this.b = j;
        this.c = i;
        this.d = j2;
        this.e = z;
        this.f = str2;
        this.g = str3;
        this.h = j3;
        this.i = j4;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Long l = (Long) obj;
        if (this.d > l.longValue()) {
            return 1;
        }
        return this.d < l.longValue() ? -1 : 0;
    }
}
