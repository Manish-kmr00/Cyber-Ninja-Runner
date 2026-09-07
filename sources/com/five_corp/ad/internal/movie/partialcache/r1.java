package com.five_corp.ad.internal.movie.partialcache;

/* JADX INFO: loaded from: classes9.dex */
public final class r1 implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s1 f1496a;

    public r1(s1 s1Var) {
        this.f1496a = s1Var;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        C3000e c3000e = ((t1) obj).f1498a;
        if (c3000e != null) {
            c3000e.d();
        }
        this.f1496a.g.removeCallbacksAndMessages(null);
        s1 s1Var = this.f1496a;
        s1Var.g = null;
        s1Var.h = null;
    }
}
