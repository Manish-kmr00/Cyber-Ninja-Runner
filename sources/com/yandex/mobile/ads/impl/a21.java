package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes12.dex */
public final class a21 implements y40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf1 f8353a;
    private final b21.a b;
    private final String c;
    private t52 d;
    private String e;
    private int f = 0;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private int k;
    private long l;

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
    }

    public a21(String str) {
        wf1 wf1Var = new wf1(4);
        this.f8353a = wf1Var;
        wf1Var.c()[0] = -1;
        this.b = new b21.a();
        this.l = -9223372036854775807L;
        this.c = str;
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) {
        if (this.d != null) {
            while (wf1Var.a() > 0) {
                int i = this.f;
                if (i == 0) {
                    byte[] bArrC = wf1Var.c();
                    int iD = wf1Var.d();
                    int iE = wf1Var.e();
                    while (true) {
                        if (iD < iE) {
                            byte b = bArrC[iD];
                            boolean z = (b & 255) == 255;
                            boolean z2 = this.i && (b & 224) == 224;
                            this.i = z;
                            if (z2) {
                                wf1Var.e(iD + 1);
                                this.i = false;
                                this.f8353a.c()[1] = bArrC[iD];
                                this.g = 2;
                                this.f = 1;
                                break;
                            }
                            iD++;
                        } else {
                            wf1Var.e(iE);
                            break;
                        }
                    }
                } else if (i == 1) {
                    int iMin = Math.min(wf1Var.a(), 4 - this.g);
                    wf1Var.a(this.f8353a.c(), this.g, iMin);
                    int i2 = this.g + iMin;
                    this.g = i2;
                    if (i2 >= 4) {
                        this.f8353a.e(0);
                        if (!this.b.a(this.f8353a.h())) {
                            this.g = 0;
                            this.f = 1;
                        } else {
                            b21.a aVar = this.b;
                            this.k = aVar.c;
                            if (!this.h) {
                                this.j = (((long) aVar.g) * 1000000) / ((long) aVar.d);
                                this.d.a(new gc0.a().b(this.e).e(this.b.b).h(4096).c(this.b.e).l(this.b.d).d(this.c).a());
                                this.h = true;
                            }
                            this.f8353a.e(0);
                            this.d.a(4, this.f8353a);
                            this.f = 2;
                        }
                    }
                } else if (i == 2) {
                    int iMin2 = Math.min(wf1Var.a(), this.k - this.g);
                    this.d.a(iMin2, wf1Var);
                    int i3 = this.g + iMin2;
                    this.g = i3;
                    int i4 = this.k;
                    if (i3 >= i4) {
                        long j = this.l;
                        if (j != -9223372036854775807L) {
                            this.d.a(j, 1, i4, 0, null);
                            this.l += this.j;
                        }
                        this.g = 0;
                        this.f = 0;
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        dVar.a();
        this.e = dVar.b();
        this.d = y70Var.a(dVar.c(), 1);
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.l = -9223372036854775807L;
    }
}
