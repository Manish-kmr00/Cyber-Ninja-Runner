package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class rk implements ro1, so1 {
    private final int b;
    private to1 d;
    private int e;
    private ii1 f;
    private int g;
    private et1 h;
    private gc0[] i;
    private long j;
    private boolean l;
    private boolean m;
    private final hc0 c = new hc0();
    private long k = Long.MIN_VALUE;

    @Override // com.yandex.mobile.ads.impl.ji1.b
    public void a(int i, Object obj) throws j60 {
    }

    protected abstract void a(long j, boolean z) throws j60;

    protected void a(boolean z, boolean z2) throws j60 {
    }

    protected abstract void a(gc0[] gc0VarArr, long j, long j2) throws j60;

    public int f() throws j60 {
        return 0;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public bv0 l() {
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final rk n() {
        return this;
    }

    protected abstract void u();

    protected void v() {
    }

    protected void w() throws j60 {
    }

    protected void x() {
    }

    protected final j60 a(int i, gc0 gc0Var, Exception exc, boolean z) {
        int iA;
        if (gc0Var == null || this.m) {
            iA = 4;
        } else {
            this.m = true;
            try {
                iA = a(gc0Var) & 7;
                this.m = false;
            } catch (j60 unused) {
                this.m = false;
                iA = 4;
            } catch (Throwable th) {
                this.m = false;
                throw th;
            }
        }
        return j60.a(exc, getName(), this.e, gc0Var, iA, z, i);
    }

    protected final j60 a(Exception exc, gc0 gc0Var, int i) {
        return a(i, gc0Var, exc, false);
    }

    public rk(int i) {
        this.b = i;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final int m() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final int getState() {
        return this.g;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void start() throws j60 {
        if (this.g == 1) {
            this.g = 2;
            w();
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void a(to1 to1Var, gc0[] gc0VarArr, et1 et1Var, long j, boolean z, boolean z2, long j2, long j3) throws j60 {
        if (this.g == 0) {
            this.d = to1Var;
            this.g = 1;
            a(z, z2);
            a(gc0VarArr, et1Var, j2, j3);
            this.l = false;
            this.k = j;
            a(j, z);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final et1 g() {
        return this.h;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final boolean e() {
        return this.k == Long.MIN_VALUE;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final long j() {
        return this.k;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void h() {
        this.l = true;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final boolean k() {
        return this.l;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void i() throws IOException {
        et1 et1Var = this.h;
        et1Var.getClass();
        et1Var.a();
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void stop() {
        if (this.g == 2) {
            this.g = 1;
            x();
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void c() {
        if (this.g == 1) {
            hc0 hc0Var = this.c;
            hc0Var.f9082a = null;
            hc0Var.b = null;
            this.g = 0;
            this.h = null;
            this.i = null;
            this.l = false;
            u();
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void b() {
        if (this.g == 0) {
            hc0 hc0Var = this.c;
            hc0Var.f9082a = null;
            hc0Var.b = null;
            v();
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void a(int i, ii1 ii1Var) {
        this.e = i;
        this.f = ii1Var;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public boolean a() {
        return e();
    }

    protected final hc0 q() {
        hc0 hc0Var = this.c;
        hc0Var.f9082a = null;
        hc0Var.b = null;
        return hc0Var;
    }

    protected final gc0[] s() {
        gc0[] gc0VarArr = this.i;
        gc0VarArr.getClass();
        return gc0VarArr;
    }

    protected final to1 p() {
        to1 to1Var = this.d;
        to1Var.getClass();
        return to1Var;
    }

    protected final ii1 r() {
        ii1 ii1Var = this.f;
        ii1Var.getClass();
        return ii1Var;
    }

    protected final boolean t() {
        if (e()) {
            return this.l;
        }
        et1 et1Var = this.h;
        et1Var.getClass();
        return et1Var.d();
    }

    protected final int a(hc0 hc0Var, oy oyVar, int i) {
        et1 et1Var = this.h;
        et1Var.getClass();
        int iA = et1Var.a(hc0Var, oyVar, i);
        if (iA == -4) {
            if (oyVar.f()) {
                this.k = Long.MIN_VALUE;
                return this.l ? -4 : -3;
            }
            long j = oyVar.f + this.j;
            oyVar.f = j;
            this.k = Math.max(this.k, j);
        } else if (iA == -5) {
            gc0 gc0Var = hc0Var.b;
            gc0Var.getClass();
            if (gc0Var.q != Long.MAX_VALUE) {
                hc0Var.b = gc0Var.a().a(gc0Var.q + this.j).a();
            }
        }
        return iA;
    }

    protected final int b(long j) {
        et1 et1Var = this.h;
        et1Var.getClass();
        return et1Var.a(j - this.j);
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void a(gc0[] gc0VarArr, et1 et1Var, long j, long j2) throws j60 {
        if (!this.l) {
            this.h = et1Var;
            if (this.k == Long.MIN_VALUE) {
                this.k = j;
            }
            this.i = gc0VarArr;
            this.j = j2;
            a(gc0VarArr, j, j2);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void a(long j) throws j60 {
        this.l = false;
        this.k = j;
        a(j, false);
    }
}
