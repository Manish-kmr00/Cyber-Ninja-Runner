package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes6.dex */
public final class sg1 extends ny1 {
    private final wf1 m = new wf1();
    private final wf1 n = new wf1();
    private final a o = new a();
    private Inflater p;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final wf1 f10205a = new wf1();
        private final int[] b = new int[256];
        private boolean c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x0090  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    @Override // com.yandex.mobile.ads.impl.ny1
    protected final g32 a(byte[] bArr, int i, boolean z) throws i32 {
        boolean z2;
        ev evVarA;
        wf1 wf1Var;
        int iT;
        boolean z3;
        wf1 wf1Var2;
        int iD;
        int iE;
        int iW;
        this.m.a(i, bArr);
        wf1 wf1Var3 = this.m;
        if (wf1Var3.a() > 0 && wf1Var3.g() == 120) {
            if (this.p == null) {
                this.p = new Inflater();
            }
            if (x82.a(wf1Var3, this.n, this.p)) {
                wf1Var3.a(this.n.e(), this.n.c());
            }
        }
        a aVar = this.o;
        ?? r2 = 0;
        aVar.d = 0;
        aVar.e = 0;
        aVar.f = 0;
        aVar.g = 0;
        aVar.h = 0;
        aVar.i = 0;
        aVar.f10205a.c(0);
        aVar.c = false;
        ArrayList arrayList = new ArrayList();
        while (this.m.a() >= 3) {
            wf1 wf1Var4 = this.m;
            a aVar2 = this.o;
            int iE2 = wf1Var4.e();
            int iT2 = wf1Var4.t();
            int iZ = wf1Var4.z();
            int iD2 = wf1Var4.d() + iZ;
            if (iD2 > iE2) {
                wf1Var4.e(iE2);
                evVarA = null;
            } else {
                int i2 = 128;
                if (iT2 != 128) {
                    switch (iT2) {
                        case 20:
                            aVar2.getClass();
                            if (iZ % 5 != 2) {
                                wf1Var2 = wf1Var4;
                            } else {
                                wf1Var4.f(2);
                                Arrays.fill(aVar2.b, (int) r2);
                                int i3 = iZ / 5;
                                for (?? r4 = r2; r4 < i3; r4++) {
                                    int iT3 = wf1Var4.t();
                                    double dT = wf1Var4.t();
                                    double dT2 = wf1Var4.t() - i2;
                                    double dT3 = wf1Var4.t() - i2;
                                    int[] iArr = aVar2.b;
                                    int i4 = x82.f10629a;
                                    iArr[iT3] = (Math.max(0, Math.min((int) ((1.402d * dT2) + dT), 255)) << 16) | (wf1Var4.t() << 24) | (Math.max(0, Math.min((int) ((dT - (0.34414d * dT3)) - (dT2 * 0.71414d)), 255)) << 8) | Math.max(0, Math.min((int) ((dT3 * 1.772d) + dT), 255));
                                    wf1Var4 = wf1Var4;
                                    i2 = 128;
                                }
                                wf1Var2 = wf1Var4;
                                aVar2.c = true;
                            }
                            break;
                        case 21:
                            aVar2.getClass();
                            if (iZ >= 4) {
                                wf1Var4.f(3);
                                int i5 = iZ - 4;
                                if (((wf1Var4.t() & 128) != 0 ? 1 : r2) == 0) {
                                    iD = aVar2.f10205a.d();
                                    iE = aVar2.f10205a.e();
                                    if (iD < iE && i5 > 0) {
                                        int iMin = Math.min(i5, iE - iD);
                                        wf1Var4.a(aVar2.f10205a.c(), iD, iMin);
                                        aVar2.f10205a.e(iD + iMin);
                                    }
                                } else if (i5 >= 7 && (iW = wf1Var4.w()) >= 4) {
                                    aVar2.h = wf1Var4.z();
                                    aVar2.i = wf1Var4.z();
                                    aVar2.f10205a.c(iW - 4);
                                    i5 = iZ - 11;
                                    iD = aVar2.f10205a.d();
                                    iE = aVar2.f10205a.e();
                                    if (iD < iE) {
                                        int iMin2 = Math.min(i5, iE - iD);
                                        wf1Var4.a(aVar2.f10205a.c(), iD, iMin2);
                                        aVar2.f10205a.e(iD + iMin2);
                                    }
                                }
                            }
                            wf1Var2 = wf1Var4;
                            break;
                        case 22:
                            aVar2.getClass();
                            if (iZ >= 19) {
                                aVar2.d = wf1Var4.z();
                                aVar2.e = wf1Var4.z();
                                wf1Var4.f(11);
                                aVar2.f = wf1Var4.z();
                                aVar2.g = wf1Var4.z();
                            }
                            wf1Var2 = wf1Var4;
                            break;
                        default:
                            wf1Var2 = wf1Var4;
                            break;
                    }
                    wf1Var = wf1Var2;
                    z3 = false;
                    evVarA = null;
                } else {
                    if (aVar2.d == 0 || aVar2.e == 0 || aVar2.h == 0 || aVar2.i == 0 || aVar2.f10205a.e() == 0 || aVar2.f10205a.d() != aVar2.f10205a.e() || !aVar2.c) {
                        z2 = false;
                        evVarA = null;
                    } else {
                        aVar2.f10205a.e(0);
                        int i6 = aVar2.h * aVar2.i;
                        int[] iArr2 = new int[i6];
                        int i7 = 0;
                        while (i7 < i6) {
                            int iT4 = aVar2.f10205a.t();
                            if (iT4 != 0) {
                                iT = i7 + 1;
                                iArr2[i7] = aVar2.b[iT4];
                            } else {
                                int iT5 = aVar2.f10205a.t();
                                if (iT5 != 0) {
                                    iT = ((iT5 & 64) == 0 ? iT5 & 63 : ((iT5 & 63) << 8) | aVar2.f10205a.t()) + i7;
                                    Arrays.fill(iArr2, i7, iT, (iT5 & 128) == 0 ? 0 : aVar2.b[aVar2.f10205a.t()]);
                                }
                            }
                            i7 = iT;
                        }
                        evVarA = new ev.a().a(Bitmap.createBitmap(iArr2, aVar2.h, aVar2.i, Bitmap.Config.ARGB_8888)).b(aVar2.f / aVar2.d).b(0).a(0, aVar2.g / aVar2.e).a(0).d(aVar2.h / aVar2.d).a(aVar2.i / aVar2.e).a();
                        z2 = false;
                    }
                    aVar2.d = z2 ? 1 : 0;
                    aVar2.e = z2 ? 1 : 0;
                    aVar2.f = z2 ? 1 : 0;
                    aVar2.g = z2 ? 1 : 0;
                    aVar2.h = z2 ? 1 : 0;
                    aVar2.i = z2 ? 1 : 0;
                    aVar2.f10205a.c(z2 ? 1 : 0);
                    aVar2.c = z2;
                    wf1Var = wf1Var4;
                    z3 = z2;
                }
                wf1Var.e(iD2);
                r2 = z3;
            }
            if (evVarA != null) {
                r2 = r2;
                arrayList.add(evVarA);
            } else {
                r2 = r2;
            }
        }
        return new tg1(Collections.unmodifiableList(arrayList));
    }
}
