package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
final class sm1 extends il {
    /* JADX INFO: Access modifiers changed from: private */
    public static int a(int i, byte[] bArr) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public sm1(i52 i52Var, long j, long j2) {
        super(new il.b(), new a(i52Var), j, j + 1, 0L, j2, 188L, 1000);
    }

    private static final class a implements il.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i52 f10219a;
        private final wf1 b;

        private a(i52 i52Var) {
            this.f10219a = i52Var;
            this.b = new wf1();
        }

        @Override // com.yandex.mobile.ads.impl.il.f
        public final void a() {
            this.b.a(x82.f);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x00e8  */
        @Override // com.yandex.mobile.ads.impl.il.f
        public final il.e a(tz tzVar, long j) throws IOException {
            int iA;
            long jA = tzVar.a();
            int iMin = (int) Math.min(20000L, tzVar.b() - jA);
            this.b.c(iMin);
            tzVar.b(this.b.c(), 0, iMin, false);
            wf1 wf1Var = this.b;
            int iD = -1;
            int iD2 = -1;
            long j2 = -9223372036854775807L;
            while (wf1Var.a() >= 4) {
                if (sm1.a(wf1Var.d(), wf1Var.c()) != 442) {
                    wf1Var.f(1);
                } else {
                    wf1Var.f(4);
                    long jA2 = tm1.a(wf1Var);
                    if (jA2 != -9223372036854775807L) {
                        long jB = this.f10219a.b(jA2);
                        if (jB > j) {
                            if (j2 == -9223372036854775807L) {
                                return il.e.a(jB, jA);
                            }
                            return il.e.a(jA + ((long) iD2));
                        }
                        if (100000 + jB > j) {
                            return il.e.a(jA + ((long) wf1Var.d()));
                        }
                        iD2 = wf1Var.d();
                        j2 = jB;
                    }
                    int iE = wf1Var.e();
                    if (wf1Var.a() < 10) {
                        wf1Var.e(iE);
                    } else {
                        wf1Var.f(9);
                        int iT = wf1Var.t() & 7;
                        if (wf1Var.a() < iT) {
                            wf1Var.e(iE);
                        } else {
                            wf1Var.f(iT);
                            if (wf1Var.a() < 4) {
                                wf1Var.e(iE);
                            } else {
                                if (sm1.a(wf1Var.d(), wf1Var.c()) == 443) {
                                    wf1Var.f(4);
                                    int iZ = wf1Var.z();
                                    if (wf1Var.a() < iZ) {
                                        wf1Var.e(iE);
                                    } else {
                                        wf1Var.f(iZ);
                                        while (wf1Var.a() >= 4) {
                                            iA = sm1.a(wf1Var.d(), wf1Var.c());
                                            if (iA == 442 || iA == 441 || (iA >>> 8) != 1) {
                                                break;
                                            }
                                            wf1Var.f(4);
                                            if (wf1Var.a() < 2) {
                                                wf1Var.e(iE);
                                                break;
                                            }
                                            wf1Var.e(Math.min(wf1Var.e(), wf1Var.d() + wf1Var.z()));
                                        }
                                    }
                                } else {
                                    while (wf1Var.a() >= 4) {
                                        iA = sm1.a(wf1Var.d(), wf1Var.c());
                                        if (iA == 442) {
                                            break;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    iD = wf1Var.d();
                }
            }
            if (j2 != -9223372036854775807L) {
                return il.e.b(j2, jA + ((long) iD));
            }
            return il.e.d;
        }
    }
}
