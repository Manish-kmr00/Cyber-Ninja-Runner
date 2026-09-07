package com.five_corp.ad.internal.movie.partialcache;

/* JADX INFO: loaded from: classes9.dex */
public abstract class j1 {
    public static final /* synthetic */ int l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.logger.a f1481a;
    public C3021o0 b;
    public C3017m0 c;
    public int f;
    public w1 g;
    public C2992a h;
    public i1 i;
    public i1 j;
    public int d = 0;
    public int e = 0;
    public boolean k = false;

    public j1(com.five_corp.ad.internal.logger.a aVar) {
        this.f1481a = aVar;
    }

    public static B a(B b, Class cls) {
        for (B b2 : b.c) {
            if (cls.isInstance(b2)) {
                return b2;
            }
        }
        return null;
    }
}
