package com.yandex.mobile.ads.impl;

import java.util.Collections;

/* JADX INFO: loaded from: classes6.dex */
final class wh extends x32 {
    private static final int[] e = {5512, 11025, 22050, 44100};
    private boolean b;
    private boolean c;
    private int d;

    public wh(t52 t52Var) {
        super(t52Var);
    }

    protected final boolean a(wf1 wf1Var) throws x32.a {
        if (!this.b) {
            int iT = wf1Var.t();
            int i = (iT >> 4) & 15;
            this.d = i;
            if (i == 2) {
                this.f10620a.a(new gc0.a().e("audio/mpeg").c(1).l(e[(iT >> 2) & 3]).a());
                this.c = true;
            } else if (i == 7 || i == 8) {
                this.f10620a.a(new gc0.a().e(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").c(1).l(8000).a());
                this.c = true;
            } else if (i != 10) {
                throw new x32.a("Audio format not supported: " + this.d);
            }
            this.b = true;
        } else {
            wf1Var.f(1);
        }
        return true;
    }

    protected final boolean a(long j, wf1 wf1Var) throws ag1 {
        if (this.d == 2) {
            int iA = wf1Var.a();
            this.f10620a.a(iA, wf1Var);
            this.f10620a.a(j, 1, iA, 0, null);
            return true;
        }
        int iT = wf1Var.t();
        if (iT == 0 && !this.c) {
            int iA2 = wf1Var.a();
            byte[] bArr = new byte[iA2];
            wf1Var.a(bArr, 0, iA2);
            e.a aVarA = e.a(new vf1(iA2, bArr), false);
            this.f10620a.a(new gc0.a().e("audio/mp4a-latm").a(aVarA.c).c(aVarA.b).l(aVarA.f8746a).a(Collections.singletonList(bArr)).a());
            this.c = true;
            return false;
        }
        if (this.d == 10 && iT != 1) {
            return false;
        }
        int iA3 = wf1Var.a();
        this.f10620a.a(iA3, wf1Var);
        this.f10620a.a(j, 1, iA3, 0, null);
        return true;
    }
}
