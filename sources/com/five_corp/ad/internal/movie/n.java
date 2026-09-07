package com.five_corp.ad.internal.movie;

import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: loaded from: classes5.dex */
public final class n implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1456a;

    public n(x xVar) {
        this.f1456a = xVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        C2994b c2994b = (C2994b) obj;
        x xVar = this.f1456a;
        if (xVar.o == 8) {
            xVar.o = 9;
            xVar.h.a(c2994b.b);
            com.five_corp.ad.internal.view.B b = this.f1456a.e;
            b.e.post(new com.five_corp.ad.internal.view.w(b));
        }
    }
}
