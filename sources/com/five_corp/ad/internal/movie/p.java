package com.five_corp.ad.internal.movie;

import android.os.Handler;
import com.five_corp.ad.internal.movie.partialcache.n1;
import com.five_corp.ad.internal.movie.partialcache.r1;
import com.five_corp.ad.internal.movie.partialcache.s1;
import com.five_corp.ad.internal.movie.partialcache.t1;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: loaded from: classes5.dex */
public final class p implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1458a;

    public p(x xVar) {
        this.f1458a = xVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        x xVar = this.f1458a;
        int i = xVar.o;
        if (i != 1) {
            w.a(i);
            return;
        }
        xVar.o = 2;
        try {
            s1 s1Var = xVar.g;
            if (s1Var.g != null) {
                s1Var.b(new r1(s1Var));
            }
            s1Var.h = new t1();
            s1Var.g = new Handler(s1Var.f);
            s1 s1Var2 = this.f1458a.g;
            s1Var2.getClass();
            s1Var2.a(new n1(s1Var2));
        } catch (Throwable th) {
            this.f1458a.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.v0, null, th, null));
        }
    }
}
