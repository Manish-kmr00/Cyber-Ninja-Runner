package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: classes5.dex */
final class xi2 extends r22 {
    private a n;
    private int o;
    private boolean p;
    private yi2.c q;
    private yi2.a r;

    xi2() {
    }

    @Override // com.yandex.mobile.ads.impl.r22
    protected final void c(long j) {
        super.c(j);
        this.p = j != 0;
        yi2.c cVar = this.q;
        this.o = cVar != null ? cVar.e : 0;
    }

    @Override // com.yandex.mobile.ads.impl.r22
    protected final long a(wf1 wf1Var) {
        int i;
        if ((wf1Var.c()[0] & 1) == 1) {
            return -1L;
        }
        byte b = wf1Var.c()[0];
        a aVar = this.n;
        if (aVar != null) {
            if (!aVar.d[(b >> 1) & (255 >>> (8 - aVar.e))].f10741a) {
                i = aVar.f10658a.e;
            } else {
                i = aVar.f10658a.f;
            }
            long j = this.p ? (this.o + i) / 4 : 0;
            if (wf1Var.b() < wf1Var.e() + 4) {
                wf1Var.a(Arrays.copyOf(wf1Var.c(), wf1Var.e() + 4));
            } else {
                wf1Var.d(wf1Var.e() + 4);
            }
            byte[] bArrC = wf1Var.c();
            bArrC[wf1Var.e() - 4] = (byte) (j & 255);
            bArrC[wf1Var.e() - 3] = (byte) ((j >>> 8) & 255);
            bArrC[wf1Var.e() - 2] = (byte) ((j >>> 16) & 255);
            bArrC[wf1Var.e() - 1] = (byte) ((j >>> 24) & 255);
            this.p = true;
            this.o = i;
            return j;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Code duplicated, block: B:165:0x039c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:167:0x039e  */
    @Override // com.yandex.mobile.ads.impl.r22
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean a(wf1 wf1Var, long j, r22.a aVar) throws IOException {
        a aVar2;
        ui2 ui2Var;
        ui2 ui2Var2;
        boolean z;
        if (this.n != null) {
            aVar.f10069a.getClass();
            return false;
        }
        yi2.c cVar = this.q;
        boolean z2 = true;
        if (cVar == null) {
            this.q = yi2.a(wf1Var);
        } else {
            yi2.a aVar3 = this.r;
            if (aVar3 == null) {
                this.r = yi2.a(wf1Var, true, true);
            } else {
                byte[] bArr = new byte[wf1Var.e()];
                System.arraycopy(wf1Var.c(), 0, bArr, 0, wf1Var.e());
                int i = cVar.f10742a;
                int i2 = 5;
                yi2.a(5, wf1Var, false);
                int iT = wf1Var.t() + 1;
                ui2 ui2Var3 = new ui2(wf1Var.c());
                ui2Var3.b(wf1Var.d() * 8);
                int i3 = 0;
                while (i3 < iT) {
                    if (ui2Var3.a(24) == 5653314) {
                        int iA = ui2Var3.a(16);
                        int iA2 = ui2Var3.a(24);
                        long[] jArr = new long[iA2];
                        long jFloor = 0;
                        if (!ui2Var3.b()) {
                            boolean zB = ui2Var3.b();
                            int i4 = 0;
                            while (i4 < iA2) {
                                if (zB) {
                                    if (ui2Var3.b()) {
                                        jArr[i4] = ui2Var3.a(i2) + 1;
                                    } else {
                                        jArr[i4] = 0;
                                    }
                                    ui2Var2 = ui2Var3;
                                    z = true;
                                } else {
                                    int i5 = i2;
                                    ui2Var2 = ui2Var3;
                                    z = true;
                                    jArr[i4] = ui2Var2.a(i5) + 1;
                                }
                                i4++;
                                ui2Var3 = ui2Var2;
                                i2 = 5;
                            }
                            ui2Var = ui2Var3;
                        } else {
                            int i6 = i2;
                            ui2Var = ui2Var3;
                            int iA3 = ui2Var.a(i6) + 1;
                            int i7 = 0;
                            while (i7 < iA2) {
                                int i8 = 0;
                                for (int i9 = iA2 - i7; i9 > 0; i9 >>>= 1) {
                                    i8++;
                                }
                                int iA4 = ui2Var.a(i8);
                                int i10 = 0;
                                while (i10 < iA4 && i7 < iA2) {
                                    jArr[i7] = iA3;
                                    i7++;
                                    i10++;
                                    aVar3 = aVar3;
                                    bArr = bArr;
                                }
                                iA3++;
                                aVar3 = aVar3;
                                bArr = bArr;
                            }
                        }
                        yi2.a aVar4 = aVar3;
                        byte[] bArr2 = bArr;
                        int iA5 = ui2Var.a(4);
                        if (iA5 > 2) {
                            throw ag1.a("lookup type greater than 2 not decodable: " + iA5, (Exception) null);
                        }
                        if (iA5 == 1 || iA5 == 2) {
                            ui2Var.b(32);
                            ui2Var.b(32);
                            int iA6 = ui2Var.a(4) + 1;
                            ui2Var.b(1);
                            if (iA5 != 1) {
                                jFloor = ((long) iA2) * ((long) iA);
                            } else if (iA != 0) {
                                jFloor = (long) Math.floor(Math.pow(iA2, 1.0d / ((double) iA)));
                            }
                            ui2Var.b((int) (((long) iA6) * jFloor));
                        }
                        i3++;
                        ui2Var3 = ui2Var;
                        aVar3 = aVar4;
                        bArr = bArr2;
                        i2 = 5;
                        z2 = true;
                    } else {
                        throw ag1.a("expected code book to start with [0x56, 0x43, 0x42] at " + ui2Var3.a(), (Exception) null);
                    }
                }
                yi2.a aVar5 = aVar3;
                byte[] bArr3 = bArr;
                ui2 ui2Var4 = ui2Var3;
                int i11 = 6;
                int iA7 = ui2Var4.a(6) + 1;
                for (int i12 = 0; i12 < iA7; i12++) {
                    if (ui2Var4.a(16) != 0) {
                        throw ag1.a("placeholder of time domain transforms not zeroed out", (Exception) null);
                    }
                }
                int i13 = 1;
                int iA8 = ui2Var4.a(6) + 1;
                int i14 = 0;
                while (true) {
                    int i15 = 3;
                    if (i14 < iA8) {
                        int iA9 = ui2Var4.a(16);
                        if (iA9 == 0) {
                            int i16 = 8;
                            ui2Var4.b(8);
                            ui2Var4.b(16);
                            ui2Var4.b(16);
                            ui2Var4.b(6);
                            ui2Var4.b(8);
                            int iA10 = ui2Var4.a(4) + 1;
                            int i17 = 0;
                            while (i17 < iA10) {
                                ui2Var4.b(i16);
                                i17++;
                                i16 = 8;
                            }
                        } else if (iA9 == i13) {
                            int iA11 = ui2Var4.a(5);
                            int[] iArr = new int[iA11];
                            int i18 = -1;
                            for (int i19 = 0; i19 < iA11; i19++) {
                                int iA12 = ui2Var4.a(4);
                                iArr[i19] = iA12;
                                if (iA12 > i18) {
                                    i18 = iA12;
                                }
                            }
                            int i20 = i18 + 1;
                            int[] iArr2 = new int[i20];
                            int i21 = 0;
                            while (i21 < i20) {
                                iArr2[i21] = ui2Var4.a(i15) + 1;
                                int iA13 = ui2Var4.a(2);
                                int i22 = 8;
                                if (iA13 > 0) {
                                    ui2Var4.b(8);
                                }
                                int i23 = 0;
                                for (int i24 = 1; i23 < (i24 << iA13); i24 = 1) {
                                    ui2Var4.b(i22);
                                    i23++;
                                    i22 = 8;
                                }
                                i21++;
                                i15 = 3;
                            }
                            ui2Var4.b(2);
                            int iA14 = ui2Var4.a(4);
                            int i25 = 0;
                            int i26 = 0;
                            for (int i27 = 0; i27 < iA11; i27++) {
                                i25 += iArr2[iArr[i27]];
                                while (i26 < i25) {
                                    ui2Var4.b(iA14);
                                    i26++;
                                }
                            }
                        } else {
                            throw ag1.a("floor type greater than 1 not decodable: " + iA9, (Exception) null);
                        }
                        i14++;
                        i11 = 6;
                        i13 = 1;
                    } else {
                        int i28 = 1;
                        int iA15 = ui2Var4.a(i11) + 1;
                        int i29 = 0;
                        while (i29 < iA15) {
                            if (ui2Var4.a(16) <= 2) {
                                ui2Var4.b(24);
                                ui2Var4.b(24);
                                ui2Var4.b(24);
                                int iA16 = ui2Var4.a(i11) + i28;
                                int i30 = 8;
                                ui2Var4.b(8);
                                int[] iArr3 = new int[iA16];
                                for (int i31 = 0; i31 < iA16; i31++) {
                                    iArr3[i31] = ((ui2Var4.b() ? ui2Var4.a(5) : 0) * 8) + ui2Var4.a(3);
                                }
                                int i32 = 0;
                                while (i32 < iA16) {
                                    int i33 = 0;
                                    while (i33 < i30) {
                                        if ((iArr3[i32] & (1 << i33)) != 0) {
                                            ui2Var4.b(i30);
                                        }
                                        i33++;
                                        i30 = 8;
                                    }
                                    i32++;
                                    i30 = 8;
                                }
                                i29++;
                                i11 = 6;
                                i28 = 1;
                            } else {
                                throw ag1.a("residueType greater than 2 is not decodable", (Exception) null);
                            }
                        }
                        int iA17 = ui2Var4.a(i11) + 1;
                        for (int i34 = 0; i34 < iA17; i34++) {
                            int iA18 = ui2Var4.a(16);
                            if (iA18 != 0) {
                                at0.b("VorbisUtil", "mapping type other than 0 not supported: " + iA18);
                            } else {
                                int iA19 = ui2Var4.b() ? ui2Var4.a(4) + 1 : 1;
                                if (ui2Var4.b()) {
                                    int iA20 = ui2Var4.a(8) + 1;
                                    for (int i35 = 0; i35 < iA20; i35++) {
                                        int i36 = i - 1;
                                        int i37 = 0;
                                        for (int i38 = i36; i38 > 0; i38 >>>= 1) {
                                            i37++;
                                        }
                                        ui2Var4.b(i37);
                                        int i39 = 0;
                                        while (i36 > 0) {
                                            i39++;
                                            i36 >>>= 1;
                                        }
                                        ui2Var4.b(i39);
                                    }
                                }
                                if (ui2Var4.a(2) != 0) {
                                    throw ag1.a("to reserved bits must be zero after mapping coupling steps", (Exception) null);
                                }
                                if (iA19 > 1) {
                                    for (int i40 = 0; i40 < i; i40++) {
                                        ui2Var4.b(4);
                                    }
                                }
                                for (int i41 = 0; i41 < iA19; i41++) {
                                    ui2Var4.b(8);
                                    ui2Var4.b(8);
                                    ui2Var4.b(8);
                                }
                            }
                        }
                        int iA21 = ui2Var4.a(6);
                        int i42 = iA21 + 1;
                        yi2.b[] bVarArr = new yi2.b[i42];
                        for (int i43 = 0; i43 < i42; i43++) {
                            boolean zB2 = ui2Var4.b();
                            ui2Var4.a(16);
                            ui2Var4.a(16);
                            ui2Var4.a(8);
                            bVarArr[i43] = new yi2.b(zB2);
                        }
                        if (ui2Var4.b()) {
                            int i44 = 0;
                            while (iA21 > 0) {
                                i44++;
                                iA21 >>>= 1;
                            }
                            aVar2 = new a(cVar, aVar5, bArr3, bVarArr, i44);
                            break;
                        }
                        throw ag1.a("framing bit after modes not set as expected", (Exception) null);
                    }
                }
            }
            this.n = aVar2;
            if (aVar2 == null) {
                return true;
            }
            yi2.c cVar2 = aVar2.f10658a;
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar2.g);
            arrayList.add(aVar2.c);
            aVar.f10069a = new gc0.a().e("audio/vorbis").b(cVar2.d).j(cVar2.c).c(cVar2.f10742a).l(cVar2.b).a(arrayList).a(yi2.a(hk0.b(aVar2.b.f10740a))).a();
            return true;
        }
        aVar2 = null;
        this.n = aVar2;
        if (aVar2 == null) {
            return true;
        }
        yi2.c cVar3 = aVar2.f10658a;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(cVar3.g);
        arrayList2.add(aVar2.c);
        aVar.f10069a = new gc0.a().e("audio/vorbis").b(cVar3.d).j(cVar3.c).c(cVar3.f10742a).l(cVar3.b).a(arrayList2).a(yi2.a(hk0.b(aVar2.b.f10740a))).a();
        return true;
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final yi2.c f10658a;
        public final yi2.a b;
        public final byte[] c;
        public final yi2.b[] d;
        public final int e;

        public a(yi2.c cVar, yi2.a aVar, byte[] bArr, yi2.b[] bVarArr, int i) {
            this.f10658a = cVar;
            this.b = aVar;
            this.c = bArr;
            this.d = bVarArr;
            this.e = i;
        }
    }

    @Override // com.yandex.mobile.ads.impl.r22
    protected final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }
}
