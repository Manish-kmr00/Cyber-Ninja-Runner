package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes7.dex */
public final class si0 implements y40 {
    private t52 b;
    private boolean c;
    private int e;
    private int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf1 f10210a = new wf1(10);
    private long d = -9223372036854775807L;

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) {
        if (this.b != null) {
            if (this.c) {
                int iA = wf1Var.a();
                int i = this.f;
                if (i < 10) {
                    int iMin = Math.min(iA, 10 - i);
                    System.arraycopy(wf1Var.c(), wf1Var.d(), this.f10210a.c(), this.f, iMin);
                    if (this.f + iMin == 10) {
                        this.f10210a.e(0);
                        if (73 == this.f10210a.t() && 68 == this.f10210a.t() && 51 == this.f10210a.t()) {
                            this.f10210a.f(3);
                            this.e = this.f10210a.s() + 10;
                        } else {
                            at0.d("Id3Reader", "Discarding invalid ID3 tag");
                            this.c = false;
                            return;
                        }
                    }
                }
                int iMin2 = Math.min(iA, this.e - this.f);
                this.b.a(iMin2, wf1Var);
                this.f += iMin2;
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
        int i;
        t52 t52Var = this.b;
        if (t52Var != null) {
            if (this.c && (i = this.e) != 0 && this.f == i) {
                long j = this.d;
                if (j != -9223372036854775807L) {
                    t52Var.a(j, 1, i, 0, null);
                }
                this.c = false;
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        dVar.a();
        t52 t52VarA = y70Var.a(dVar.c(), 5);
        this.b = t52VarA;
        t52VarA.a(new gc0.a().b(dVar.b()).e("application/id3").a());
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.d = j;
        }
        this.e = 0;
        this.f = 0;
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        this.c = false;
        this.d = -9223372036854775807L;
    }
}
