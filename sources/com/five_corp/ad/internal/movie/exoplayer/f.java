package com.five_corp.ad.internal.movie.exoplayer;

import android.os.SystemClock;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.view.B;
import com.five_corp.ad.internal.view.u;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f1444a;
    public final n b;
    public final a c;

    public f(l lVar, n nVar, a aVar) {
        this.f1444a = lVar;
        this.b = nVar;
        this.c = aVar;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public k a() {
        n nVar = this.b;
        nVar.f1447a.seekTo(0);
        B b = nVar.c;
        b.e.post(new u(b));
        nVar.a();
        if (nVar.e != null) {
            m mVar = new m(nVar.e.longValue() + SystemClock.uptimeMillis());
            nVar.f = mVar;
            nVar.b(mVar);
        }
        return new h(this.f1444a, this.b, this.c);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final int b() {
        return (int) this.b.f1447a.getCurrentPosition();
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k g() {
        return this;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public k h() {
        int currentPosition = (int) this.b.f1447a.getCurrentPosition();
        boolean z = this.b.f1447a.getVolume() > 0.0f;
        n nVar = this.b;
        nVar.a();
        nVar.f1447a.release();
        this.c.o();
        return new d(this.f1444a, this.c, currentPosition, z);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final c a(o oVar) {
        oVar.b();
        int iB = b();
        n nVar = this.b;
        nVar.a();
        nVar.f1447a.release();
        this.c.b(iB, oVar);
        this.c.o();
        return new c(iB);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final void a(boolean z) {
        this.b.f1447a.setVolume(z ? 1.0f : 0.0f);
    }
}
