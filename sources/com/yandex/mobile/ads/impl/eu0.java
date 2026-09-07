package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class eu0 implements lw0, lw0.a {
    public final rw0.b b;
    private final long c;
    private final cd d;
    private rw0 e;
    private lw0 f;
    private lw0.a g;
    private boolean h;
    private long i = -9223372036854775807L;

    public interface a {
        void a(rw0.b bVar);

        void a(rw0.b bVar, IOException iOException);
    }

    public eu0(rw0.b bVar, cd cdVar, long j) {
        this.b = bVar;
        this.d = cdVar;
        this.c = j;
    }

    public final long b() {
        return this.c;
    }

    public final void a(rw0.b bVar) {
        long j = this.c;
        long j2 = this.i;
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        rw0 rw0Var = this.e;
        rw0Var.getClass();
        lw0 lw0VarA = rw0Var.a(bVar, this.d, j);
        this.f = lw0VarA;
        if (this.g != null) {
            lw0VarA.a(this, j);
        }
    }

    public final void c() {
        if (this.f != null) {
            rw0 rw0Var = this.e;
            rw0Var.getClass();
            rw0Var.a(this.f);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final void maybeThrowPrepareError() throws IOException {
        lw0 lw0Var = this.f;
        if (lw0Var != null) {
            lw0Var.maybeThrowPrepareError();
            return;
        }
        rw0 rw0Var = this.e;
        if (rw0Var != null) {
            rw0Var.maybeThrowSourceInfoRefreshError();
        }
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final s52 getTrackGroups() {
        lw0 lw0Var = this.f;
        int i = x82.f10629a;
        return lw0Var.getTrackGroups();
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final void discardBuffer(long j, boolean z) {
        lw0 lw0Var = this.f;
        int i = x82.f10629a;
        lw0Var.discardBuffer(j, z);
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final long readDiscontinuity() {
        lw0 lw0Var = this.f;
        int i = x82.f10629a;
        return lw0Var.readDiscontinuity();
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final long getBufferedPositionUs() {
        lw0 lw0Var = this.f;
        int i = x82.f10629a;
        return lw0Var.getBufferedPositionUs();
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final long seekToUs(long j) {
        lw0 lw0Var = this.f;
        int i = x82.f10629a;
        return lw0Var.seekToUs(j);
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final long getNextLoadPositionUs() {
        lw0 lw0Var = this.f;
        int i = x82.f10629a;
        return lw0Var.getNextLoadPositionUs();
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final void reevaluateBuffer(long j) {
        lw0 lw0Var = this.f;
        int i = x82.f10629a;
        lw0Var.reevaluateBuffer(j);
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final boolean continueLoading(long j) {
        lw0 lw0Var = this.f;
        return lw0Var != null && lw0Var.continueLoading(j);
    }

    @Override // com.yandex.mobile.ads.impl.fx1
    public final boolean isLoading() {
        lw0 lw0Var = this.f;
        return lw0Var != null && lw0Var.isLoading();
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final long a(long j, yw1 yw1Var) {
        lw0 lw0Var = this.f;
        int i = x82.f10629a;
        return lw0Var.a(j, yw1Var);
    }

    public final long a() {
        return this.i;
    }

    @Override // com.yandex.mobile.ads.impl.fx1.a
    public final void a(fx1 fx1Var) {
        lw0.a aVar = this.g;
        int i = x82.f10629a;
        aVar.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.lw0.a
    public final void a(lw0 lw0Var) {
        lw0.a aVar = this.g;
        int i = x82.f10629a;
        aVar.a((lw0) this);
    }

    public final void a(long j) {
        this.i = j;
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final void a(lw0.a aVar, long j) {
        this.g = aVar;
        lw0 lw0Var = this.f;
        if (lw0Var != null) {
            long j2 = this.c;
            long j3 = this.i;
            if (j3 != -9223372036854775807L) {
                j2 = j3;
            }
            lw0Var.a(this, j2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.lw0
    public final long a(e70[] e70VarArr, boolean[] zArr, et1[] et1VarArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.i;
        if (j3 == -9223372036854775807L || j != this.c) {
            j2 = j;
        } else {
            this.i = -9223372036854775807L;
            j2 = j3;
        }
        lw0 lw0Var = this.f;
        int i = x82.f10629a;
        return lw0Var.a(e70VarArr, zArr, et1VarArr, zArr2, j2);
    }

    public final void a(rw0 rw0Var) {
        if (this.e == null) {
            this.e = rw0Var;
            return;
        }
        throw new IllegalStateException();
    }
}
