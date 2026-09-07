package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes11.dex */
public final class j22 implements y70 {
    private final long b;
    private final y70 c;

    public j22(long j, y70 y70Var) {
        this.b = j;
        this.c = y70Var;
    }

    @Override // com.yandex.mobile.ads.impl.y70
    public final void a() {
        this.c.a();
    }

    final class a implements xw1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ xw1 f9282a;

        a(xw1 xw1Var) {
            this.f9282a = xw1Var;
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final long c() {
            return this.f9282a.c();
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final xw1.a b(long j) {
            xw1.a aVarB = this.f9282a.b(j);
            zw1 zw1Var = aVarB.f10682a;
            long j2 = zw1Var.f10856a;
            long j3 = zw1Var.b;
            long j4 = j22.this.b;
            zw1 zw1Var2 = new zw1(j2, j3 + j4);
            zw1 zw1Var3 = aVarB.b;
            return new xw1.a(zw1Var2, new zw1(zw1Var3.f10856a, zw1Var3.b + j4));
        }

        @Override // com.yandex.mobile.ads.impl.xw1
        public final boolean b() {
            return this.f9282a.b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.y70
    public final void a(xw1 xw1Var) {
        this.c.a(new a(xw1Var));
    }

    @Override // com.yandex.mobile.ads.impl.y70
    public final t52 a(int i, int i2) {
        return this.c.a(i, i2);
    }
}
