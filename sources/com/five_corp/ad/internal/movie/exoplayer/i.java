package com.five_corp.ad.internal.movie.exoplayer;

import android.os.SystemClock;
import com.five_corp.ad.internal.view.A;
import com.five_corp.ad.internal.view.B;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends f {
    public i(l lVar, n nVar, a aVar) {
        super(lVar, nVar, aVar);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k e() {
        B b = this.b.c;
        b.e.post(new A(b));
        this.c.h(b());
        return new e(this.f1444a, this.b, this.c);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k f() {
        return this;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k i() {
        n nVar = this.b;
        nVar.f1447a.play();
        nVar.a();
        if (nVar.e != null) {
            m mVar = new m(nVar.e.longValue() + SystemClock.uptimeMillis());
            nVar.f = mVar;
            nVar.b(mVar);
        }
        this.c.i(b());
        return new j(this.f1444a, this.b, this.c);
    }
}
