package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes6.dex */
public final class ww1 implements i72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vw1 f10599a;
    private final wf1 b = new wf1(32);
    private int c;
    private int d;
    private boolean e;
    private boolean f;

    @Override // com.yandex.mobile.ads.impl.i72
    public final void a(int i, wf1 wf1Var) {
        int iD;
        boolean z = (i & 1) != 0;
        if (z) {
            iD = wf1Var.d() + wf1Var.t();
        } else {
            iD = -1;
        }
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            wf1Var.e(iD);
            this.d = 0;
        }
        while (wf1Var.a() > 0) {
            int i2 = this.d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int iT = wf1Var.t();
                    wf1Var.e(wf1Var.d() - 1);
                    if (iT == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(wf1Var.a(), 3 - this.d);
                wf1Var.a(this.b.c(), this.d, iMin);
                int i3 = this.d + iMin;
                this.d = i3;
                if (i3 == 3) {
                    this.b.e(0);
                    this.b.d(3);
                    this.b.f(1);
                    int iT2 = this.b.t();
                    int iT3 = this.b.t();
                    this.e = (iT2 & 128) != 0;
                    this.c = (((iT2 & 15) << 8) | iT3) + 3;
                    int iB = this.b.b();
                    int i4 = this.c;
                    if (iB < i4) {
                        this.b.a(Math.min(4098, Math.max(i4, this.b.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(wf1Var.a(), this.c - this.d);
                wf1Var.a(this.b.c(), this.d, iMin2);
                int i5 = this.d + iMin2;
                this.d = i5;
                int i6 = this.c;
                if (i5 != i6) {
                    continue;
                } else {
                    if (this.e) {
                        if (x82.a(this.c, this.b.c()) != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.d(this.c - 4);
                    } else {
                        this.b.d(i6);
                    }
                    this.b.e(0);
                    this.f10599a.a(this.b);
                    this.d = 0;
                }
            }
        }
    }

    public ww1(vw1 vw1Var) {
        this.f10599a = vw1Var;
    }

    @Override // com.yandex.mobile.ads.impl.i72
    public final void a(i52 i52Var, y70 y70Var, i72.d dVar) {
        this.f10599a.a(i52Var, y70Var, dVar);
        this.f = true;
    }

    @Override // com.yandex.mobile.ads.impl.i72
    public final void a() {
        this.f = true;
    }
}
