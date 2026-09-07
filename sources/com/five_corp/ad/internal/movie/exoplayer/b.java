package com.five_corp.ad.internal.movie.exoplayer;

import android.os.SystemClock;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.view.B;
import com.five_corp.ad.internal.view.u;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f1441a;
    public final a b;
    public final int c;
    public boolean d;

    public b(l lVar, a aVar, int i, boolean z) {
        this.f1441a = lVar;
        this.b = aVar;
        this.c = i;
        this.d = z;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k a() {
        n nVarA = this.f1441a.a();
        nVarA.f1447a.seekTo(0);
        B b = nVarA.c;
        b.e.post(new u(b));
        nVarA.a();
        if (nVarA.e != null) {
            m mVar = new m(nVarA.e.longValue() + SystemClock.uptimeMillis());
            nVarA.f = mVar;
            nVarA.b(mVar);
        }
        nVarA.f1447a.setVolume(this.d ? 1.0f : 0.0f);
        nVarA.f1447a.prepare();
        return new h(this.f1441a, nVarA, this.b);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final int b() {
        return this.c;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k f() {
        return this;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k g() {
        return this;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k h() {
        return this;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final k i() {
        return this;
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final c a(o oVar) {
        oVar.b();
        this.b.b(this.c, oVar);
        this.b.o();
        return new c(this.c);
    }

    @Override // com.five_corp.ad.internal.movie.exoplayer.k
    public final void a(boolean z) {
        this.d = z;
    }
}
