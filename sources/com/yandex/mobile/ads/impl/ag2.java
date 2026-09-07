package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes4.dex */
final class ag2 extends x32 {
    private final wf1 b;
    private final wf1 c;
    private int d;
    private boolean e;
    private boolean f;
    private int g;

    public ag2(t52 t52Var) {
        super(t52Var);
        this.b = new wf1(a41.f8364a);
        this.c = new wf1(4);
    }

    protected final boolean a(wf1 wf1Var) throws x32.a {
        int iT = wf1Var.t();
        int i = (iT >> 4) & 15;
        int i2 = iT & 15;
        if (i2 == 7) {
            this.g = i;
            return i != 5;
        }
        throw new x32.a(oe.a("Video format not supported: ", i2));
    }

    protected final boolean a(long j, wf1 wf1Var) throws ag1 {
        int iT = wf1Var.t();
        long jI = (((long) wf1Var.i()) * 1000) + j;
        if (iT == 0 && !this.e) {
            wf1 wf1Var2 = new wf1(new byte[wf1Var.a()]);
            wf1Var.a(wf1Var2.c(), 0, wf1Var.a());
            mi miVarA = mi.a(wf1Var2);
            this.d = miVarA.b;
            this.f10620a.a(new gc0.a().e("video/avc").a(miVarA.f).o(miVarA.c).f(miVarA.d).b(miVarA.e).a(miVarA.f9640a).a());
            this.e = true;
            return false;
        }
        if (iT != 1 || !this.e) {
            return false;
        }
        int i = this.g == 1 ? 1 : 0;
        if (!this.f && i == 0) {
            return false;
        }
        byte[] bArrC = this.c.c();
        bArrC[0] = 0;
        bArrC[1] = 0;
        bArrC[2] = 0;
        int i2 = 4 - this.d;
        int i3 = 0;
        while (wf1Var.a() > 0) {
            wf1Var.a(this.c.c(), i2, this.d);
            this.c.e(0);
            int iX = this.c.x();
            this.b.e(0);
            this.f10620a.a(4, this.b);
            this.f10620a.a(iX, wf1Var);
            i3 = i3 + 4 + iX;
        }
        this.f10620a.a(jI, i, i3, 0, null);
        this.f = true;
        return true;
    }
}
