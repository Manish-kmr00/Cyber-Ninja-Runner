package com.five_corp.ad.internal.movie.exoplayer;

import com.five_corp.ad.internal.view.B;
import com.five_corp.ad.internal.view.w;
import com.five_corp.ad.internal.view.x;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends f {
    public j(l lVar, n nVar, a aVar) {
        super(lVar, nVar, aVar);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k e() {
        n nVar = this.b;
        nVar.a();
        nVar.f1447a.play();
        B b = nVar.c;
        b.e.post(new w(b));
        this.c.h(b());
        return new g(this.f1444a, this.b, this.c);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k f() {
        n nVar = this.b;
        nVar.a();
        nVar.f1447a.pause();
        B b = nVar.c;
        b.e.post(new x(b));
        this.c.g(b());
        return new i(this.f1444a, this.b, this.c);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.f, com.five_corp.ad.internal.movie.exoplayer.k
    public final k h() {
        this.c.g(b());
        return super.h();
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k i() {
        return this;
    }
}
