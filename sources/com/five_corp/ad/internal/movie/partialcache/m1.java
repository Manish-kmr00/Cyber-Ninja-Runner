package com.five_corp.ad.internal.movie.partialcache;

/* JADX INFO: loaded from: classes9.dex */
public final class m1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f1483a;
    public final /* synthetic */ s1 b;

    public m1(s1 s1Var, u1 u1Var) {
        this.b = s1Var;
        this.f1483a = u1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1483a.a(this.b.h);
        } catch (Throwable th) {
            s1 s1Var = this.b;
            s1Var.a(s1Var.h, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.o5, null, th, null));
        }
    }
}
