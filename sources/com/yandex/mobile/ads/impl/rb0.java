package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
final class rb0 extends il {

    private static final class a implements il.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final xb0 f10092a;
        private final int b;
        private final tb0.a c;

        private a(int i, xb0 xb0Var) {
            this.f10092a = xb0Var;
            this.b = i;
            this.c = new tb0.a();
        }

        private long a(tz tzVar) throws IOException {
            int iC;
            while (tzVar.d() < tzVar.b() - 6) {
                xb0 xb0Var = this.f10092a;
                int i = this.b;
                tb0.a aVar = this.c;
                long jD = tzVar.d();
                byte[] bArr = new byte[2];
                tzVar.b(bArr, 0, 2, false);
                if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) == i) {
                    wf1 wf1Var = new wf1(16);
                    System.arraycopy(bArr, 0, wf1Var.c(), 0, 2);
                    byte[] bArrC = wf1Var.c();
                    int i2 = 0;
                    for (int i3 = 2; i2 < 14 && (iC = tzVar.c(bArrC, i3 + i2, 14 - i2)) != -1; i3 = 2) {
                        i2 += iC;
                    }
                    wf1Var.d(i2);
                    tzVar.c();
                    tzVar.a(false, (int) (jD - tzVar.a()));
                    if (tb0.a(wf1Var, xb0Var, i, aVar)) {
                        break;
                    }
                } else {
                    tzVar.c();
                    tzVar.a(false, (int) (jD - tzVar.a()));
                }
                tzVar.a(false, 1);
            }
            if (tzVar.d() < tzVar.b() - 6) {
                return this.c.f10282a;
            }
            tzVar.a(false, (int) (tzVar.b() - tzVar.d()));
            return this.f10092a.j;
        }

        @Override // com.yandex.mobile.ads.impl.il.f
        public final il.e a(tz tzVar, long j) throws IOException {
            long jA = tzVar.a();
            long jA2 = a(tzVar);
            long jD = tzVar.d();
            tzVar.a(false, Math.max(6, this.f10092a.c));
            long jA3 = a(tzVar);
            long jD2 = tzVar.d();
            if (jA2 <= j && jA3 > j) {
                return il.e.a(jD);
            }
            if (jA3 <= j) {
                return il.e.b(jA3, jD2);
            }
            return il.e.a(jA2, jA);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rb0(final xb0 xb0Var, int i, long j, long j2) {
        super(new il.d() { // from class: com.yandex.mobile.ads.impl.rb0$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.il.d
            public final long a(long j3) {
                return xb0Var.a(j3);
            }
        }, new a(i, xb0Var), xb0Var.b(), xb0Var.j, j, j2, xb0Var.a(), Math.max(6, xb0Var.c));
        Objects.requireNonNull(xb0Var);
    }
}
