package com.yandex.mobile.ads.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class u40 implements y40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<i72.a> f10356a;
    private final t52[] b;
    private boolean c;
    private int d;
    private int e;
    private long f = -9223372036854775807L;

    public u40(List<i72.a> list) {
        this.f10356a = list;
        this.b = new t52[list.size()];
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
        if (this.c) {
            if (this.f != -9223372036854775807L) {
                for (t52 t52Var : this.b) {
                    t52Var.a(this.f, 1, this.e, 0, null);
                }
            }
            this.c = false;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) {
        if (this.c) {
            if (this.d == 2) {
                if (wf1Var.a() == 0) {
                    return;
                }
                if (wf1Var.t() != 32) {
                    this.c = false;
                }
                this.d--;
                if (!this.c) {
                    return;
                }
            }
            if (this.d == 1) {
                if (wf1Var.a() == 0) {
                    return;
                }
                if (wf1Var.t() != 0) {
                    this.c = false;
                }
                this.d--;
                if (!this.c) {
                    return;
                }
            }
            int iD = wf1Var.d();
            int iA = wf1Var.a();
            for (t52 t52Var : this.b) {
                wf1Var.e(iD);
                t52Var.a(iA, wf1Var);
            }
            this.e += iA;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            i72.a aVar = this.f10356a.get(i);
            dVar.a();
            t52 t52VarA = y70Var.a(dVar.c(), 3);
            t52VarA.a(new gc0.a().b(dVar.b()).e("application/dvbsubs").a(Collections.singletonList(aVar.b)).d(aVar.f9186a).a());
            this.b[i] = t52VarA;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.f = j;
        }
        this.e = 0;
        this.d = 2;
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        this.c = false;
        this.f = -9223372036854775807L;
    }
}
