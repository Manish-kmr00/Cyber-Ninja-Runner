package com.five_corp.ad.internal.movie.exoplayer;

import com.five_corp.ad.internal.view.B;
import com.five_corp.ad.internal.view.w;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {
    public e(l lVar, n nVar, a aVar) {
        super(lVar, nVar, aVar);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k f() {
        return this;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k i() {
        n nVar = this.b;
        nVar.a();
        nVar.f1447a.play();
        B b = nVar.c;
        b.e.post(new w(b));
        this.c.i(b());
        return new g(this.f1444a, this.b, this.c);
    }
}
