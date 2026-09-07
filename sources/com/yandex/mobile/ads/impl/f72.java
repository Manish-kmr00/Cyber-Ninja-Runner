package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
final class f72 extends il {
    public f72(i52 i52Var, long j, long j2, int i, int i2) {
        super(new il.b(), new a(i, i52Var, i2), j, j + 1, 0L, j2, 188L, 940);
    }

    private static final class a implements il.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i52 f8874a;
        private final wf1 b = new wf1();
        private final int c;
        private final int d;

        public a(int i, i52 i52Var, int i2) {
            this.c = i;
            this.f8874a = i52Var;
            this.d = i2;
        }

        @Override // com.yandex.mobile.ads.impl.il.f
        public final void a() {
            this.b.a(x82.f);
        }

        @Override // com.yandex.mobile.ads.impl.il.f
        public final il.e a(tz tzVar, long j) throws IOException {
            long jA = tzVar.a();
            int iMin = (int) Math.min(this.d, tzVar.b() - jA);
            this.b.c(iMin);
            tzVar.b(this.b.c(), 0, iMin, false);
            wf1 wf1Var = this.b;
            int iE = wf1Var.e();
            long j2 = -1;
            long j3 = -1;
            long j4 = -9223372036854775807L;
            while (wf1Var.a() >= 188) {
                byte[] bArrC = wf1Var.c();
                int iD = wf1Var.d();
                while (iD < iE && bArrC[iD] != 71) {
                    iD++;
                }
                int i = iD + 188;
                if (i > iE) {
                    break;
                }
                long jA2 = j72.a(iD, this.c, wf1Var);
                if (jA2 != -9223372036854775807L) {
                    long jB = this.f8874a.b(jA2);
                    if (jB > j) {
                        if (j4 == -9223372036854775807L) {
                            return il.e.a(jB, jA);
                        }
                        return il.e.a(jA + j3);
                    }
                    if (100000 + jB > j) {
                        return il.e.a(jA + ((long) iD));
                    }
                    j4 = jB;
                    j3 = iD;
                }
                wf1Var.e(i);
                j2 = i;
            }
            if (j4 != -9223372036854775807L) {
                return il.e.b(j4, jA + j2);
            }
            return il.e.d;
        }
    }
}
