package com.five_corp.ad.internal.movie.exoplayer;

import android.os.SystemClock;
import com.five_corp.ad.internal.view.B;
import com.five_corp.ad.internal.view.x;
import com.five_corp.ad.internal.view.y;
import com.five_corp.ad.internal.view.z;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends f {
    public g(l lVar, n nVar, a aVar) {
        super(lVar, nVar, aVar);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k c() {
        n nVar = this.b;
        B b = nVar.c;
        b.e.post(new z(b));
        nVar.a();
        if (nVar.e != null) {
            m mVar = new m(nVar.e.longValue() + SystemClock.uptimeMillis());
            nVar.f = mVar;
            nVar.b(mVar);
        }
        this.c.j(b());
        return new j(this.f1444a, this.b, this.c);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k d() {
        int currentPosition = (int) this.b.f1447a.getCurrentPosition();
        boolean z = this.b.f1447a.getVolume() > 0.0f;
        B b = this.b.c;
        b.e.post(new y(b));
        this.c.f(currentPosition);
        n nVar = this.b;
        nVar.a();
        nVar.f1447a.release();
        this.c.o();
        return new b(this.f1444a, this.c, currentPosition, z);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k f() {
        n nVar = this.b;
        nVar.a();
        nVar.f1447a.pause();
        B b = nVar.c;
        b.e.post(new x(b));
        this.c.g(b());
        return new e(this.f1444a, this.b, this.c);
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
