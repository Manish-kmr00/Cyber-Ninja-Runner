package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes10.dex */
final class b00 implements bv0 {
    private final e22 b;
    private final a c;
    private ro1 d;
    private bv0 e;
    private boolean f = true;
    private boolean g;

    public interface a {
    }

    public b00(a aVar, r32 r32Var) {
        this.c = aVar;
        this.b = new e22(r32Var);
    }

    public final void b(ro1 ro1Var) throws j60 {
        bv0 bv0Var;
        bv0 bv0VarL = ro1Var.l();
        if (bv0VarL == null || bv0VarL == (bv0Var = this.e)) {
            return;
        }
        if (bv0Var == null) {
            this.e = bv0VarL;
            this.d = ro1Var;
            ((dv0) bv0VarL).a(this.b.getPlaybackParameters());
            return;
        }
        throw j60.a(new IllegalStateException("Multiple renderer media clocks enabled."));
    }

    public final void a(ro1 ro1Var) {
        if (ro1Var == this.d) {
            this.e = null;
            this.d = null;
            this.f = true;
        }
    }

    @Override // com.yandex.mobile.ads.impl.bv0
    public final long o() {
        if (this.f) {
            return this.b.o();
        }
        bv0 bv0Var = this.e;
        bv0Var.getClass();
        return bv0Var.o();
    }

    @Override // com.yandex.mobile.ads.impl.bv0
    public final xh1 getPlaybackParameters() {
        bv0 bv0Var = this.e;
        if (bv0Var != null) {
            return bv0Var.getPlaybackParameters();
        }
        return this.b.getPlaybackParameters();
    }

    public final void b() {
        this.g = false;
        this.b.b();
    }

    public final void a(long j) {
        this.b.a(j);
    }

    @Override // com.yandex.mobile.ads.impl.bv0
    public final void a(xh1 xh1Var) {
        bv0 bv0Var = this.e;
        if (bv0Var != null) {
            bv0Var.a(xh1Var);
            xh1Var = this.e.getPlaybackParameters();
        }
        this.b.a(xh1Var);
    }

    public final void a() {
        this.g = true;
        this.b.a();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    public final long a(boolean z) {
        xh1 playbackParameters;
        ro1 ro1Var = this.d;
        if (ro1Var != null && !ro1Var.a() && (this.d.d() || (!z && !this.d.e()))) {
            bv0 bv0Var = this.e;
            bv0Var.getClass();
            long jO = bv0Var.o();
            if (!this.f) {
                this.b.a(jO);
                playbackParameters = bv0Var.getPlaybackParameters();
                if (!playbackParameters.equals(this.b.getPlaybackParameters())) {
                    this.b.a(playbackParameters);
                    ((q60) this.c).a(playbackParameters);
                }
            } else if (jO < this.b.o()) {
                this.b.b();
            } else {
                this.f = false;
                if (this.g) {
                    this.b.a();
                }
                this.b.a(jO);
                playbackParameters = bv0Var.getPlaybackParameters();
                if (!playbackParameters.equals(this.b.getPlaybackParameters())) {
                    this.b.a(playbackParameters);
                    ((q60) this.c).a(playbackParameters);
                }
            }
        } else {
            this.f = true;
            if (this.g) {
                this.b.a();
            }
        }
        return o();
    }
}
