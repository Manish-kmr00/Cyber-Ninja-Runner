package com.fyber.inneractive.sdk.player.exoplayer2;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1973a;
    public t b;
    public int c;
    public com.fyber.inneractive.sdk.player.exoplayer2.source.v d;
    public long e;
    public boolean f = true;
    public boolean g;

    public a(int i) {
        this.f1973a = i;
    }

    public abstract void a(int i, Object obj);

    public abstract void a(long j, long j2);

    public abstract void a(boolean z, long j);

    public void a(o[] oVarArr) {
    }

    public final void c() {
        if (this.c != 1) {
            throw new IllegalStateException();
        }
        this.c = 0;
        this.d = null;
        this.g = false;
        g();
    }

    public com.fyber.inneractive.sdk.player.exoplayer2.util.h d() {
        return null;
    }

    public abstract boolean e();

    public abstract boolean f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public final int a(p pVar, com.fyber.inneractive.sdk.player.exoplayer2.decoder.c cVar, boolean z) {
        int iA = this.d.a(pVar, cVar, z);
        if (iA == -4) {
            if (cVar.b(4)) {
                this.f = true;
                return this.g ? -4 : -3;
            }
            cVar.d += this.e;
        } else if (iA == -5) {
            o oVar = pVar.f2117a;
            long j = oVar.w;
            if (j != Long.MAX_VALUE) {
                pVar.f2117a = new o(oVar.f2116a, oVar.e, oVar.f, oVar.c, oVar.b, oVar.g, oVar.j, oVar.k, oVar.l, oVar.m, oVar.n, oVar.p, oVar.o, oVar.q, oVar.r, oVar.s, oVar.t, oVar.u, oVar.v, oVar.x, oVar.y, oVar.z, j + this.e, oVar.h, oVar.i, oVar.d);
            }
        }
        return iA;
    }
}
