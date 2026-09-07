package com.five_corp.ad.internal.movie.exoplayer;

import com.five_corp.ad.internal.view.B;
import com.five_corp.ad.internal.view.v;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends f {
    public h(l lVar, n nVar, a aVar) {
        super(lVar, nVar, aVar);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.f, com.five_corp.ad.internal.movie.exoplayer.k
    public final k a() {
        return this;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k e() {
        n nVar = this.b;
        nVar.a();
        B b = nVar.c;
        b.e.post(new v(b));
        this.c.n();
        return new e(this.f1444a, this.b, this.c);
    }
}
