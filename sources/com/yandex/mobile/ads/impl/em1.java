package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
final class em1 {
    /* JADX WARN: Code duplicated, block: B:29:0x0068  */
    private static ArrayList<dm1.a> a(wf1 wf1Var) {
        ArrayList<dm1.a> arrayList;
        boolean z;
        int i;
        ArrayList<dm1.a> arrayList2;
        dm1.a aVar;
        wf1 wf1Var2 = wf1Var;
        if (wf1Var.t() != 0) {
            return null;
        }
        wf1Var2.f(7);
        int iH = wf1Var.h();
        boolean z2 = true;
        if (iH == 1684433976) {
            wf1 wf1Var3 = new wf1();
            Inflater inflater = new Inflater(true);
            try {
                if (!x82.a(wf1Var2, wf1Var3, inflater)) {
                    inflater.end();
                    return null;
                }
                inflater.end();
                wf1Var2 = wf1Var3;
            } catch (Throwable th) {
                inflater.end();
                throw th;
            }
        } else if (iH != 1918990112) {
            return null;
        }
        ArrayList<dm1.a> arrayList3 = new ArrayList<>();
        int iD = wf1Var2.d();
        int iE = wf1Var2.e();
        while (iD < iE) {
            int iH2 = wf1Var2.h() + iD;
            if (iH2 > iD && iH2 <= iE) {
                if (wf1Var2.h() == 1835365224) {
                    int iH3 = wf1Var2.h();
                    if (iH3 > 10000) {
                        arrayList2 = arrayList3;
                        z = z2;
                        i = iE;
                        aVar = null;
                    } else {
                        float[] fArr = new float[iH3];
                        for (int i2 = 0; i2 < iH3; i2++) {
                            fArr[i2] = Float.intBitsToFloat(wf1Var2.h());
                        }
                        int iH4 = wf1Var2.h();
                        if (iH4 > 32000) {
                            arrayList2 = arrayList3;
                        } else {
                            double dLog = Math.log(2.0d);
                            arrayList2 = arrayList3;
                            int iCeil = (int) Math.ceil(Math.log(((double) iH3) * 2.0d) / dLog);
                            byte[] bArrC = wf1Var2.c();
                            vf1 vf1Var = new vf1(bArrC.length, bArrC);
                            vf1Var.c(wf1Var2.d() * 8);
                            float[] fArr2 = new float[iH4 * 5];
                            int i3 = 5;
                            int[] iArr = new int[5];
                            int i4 = 0;
                            int i5 = 0;
                            while (true) {
                                if (i4 < iH4) {
                                    int i6 = 0;
                                    while (true) {
                                        if (i6 < i3) {
                                            int i7 = iArr[i6];
                                            int iB = vf1Var.b(iCeil);
                                            int i8 = i7 + ((iB >> 1) ^ (-(iB & 1)));
                                            if (i8 < iH3 && i8 >= 0) {
                                                fArr2[i5] = fArr[i8];
                                                iArr[i6] = i8;
                                                i6++;
                                                i5++;
                                                i3 = 5;
                                            }
                                        } else {
                                            i4++;
                                            i3 = 5;
                                        }
                                    }
                                } else {
                                    vf1Var.c((vf1Var.e() + 7) & (-8));
                                    int i9 = 32;
                                    int iB2 = vf1Var.b(32);
                                    dm1.b[] bVarArr = new dm1.b[iB2];
                                    int i10 = 0;
                                    while (true) {
                                        if (i10 < iB2) {
                                            int iB3 = vf1Var.b(8);
                                            int iB4 = vf1Var.b(8);
                                            int iB5 = vf1Var.b(i9);
                                            if (iB5 <= 128000) {
                                                i = iE;
                                                int iCeil2 = (int) Math.ceil(Math.log(((double) iH4) * 2.0d) / dLog);
                                                float[] fArr3 = new float[iB5 * 3];
                                                float[] fArr4 = new float[iB5 * 2];
                                                int i11 = 0;
                                                int i12 = 0;
                                                while (true) {
                                                    if (i11 < iB5) {
                                                        int iB6 = vf1Var.b(iCeil2);
                                                        int i13 = iB6 >> 1;
                                                        vf1 vf1Var2 = vf1Var;
                                                        int i14 = iB6 & 1;
                                                        int i15 = iB2;
                                                        float[] fArr5 = fArr4;
                                                        int i16 = i12 + (i13 ^ (-i14));
                                                        if (i16 < 0 || i16 >= iH4) {
                                                            z = true;
                                                        } else {
                                                            int i17 = i11 * 3;
                                                            int i18 = i16 * 5;
                                                            fArr3[i17] = fArr2[i18];
                                                            fArr3[i17 + 1] = fArr2[i18 + 1];
                                                            fArr3[i17 + 2] = fArr2[i18 + 2];
                                                            int i19 = i11 * 2;
                                                            fArr5[i19] = fArr2[i18 + 3];
                                                            fArr5[i19 + 1] = fArr2[i18 + 4];
                                                            i11++;
                                                            i12 = i16;
                                                            fArr4 = fArr5;
                                                            iB2 = i15;
                                                            vf1Var = vf1Var2;
                                                        }
                                                    } else {
                                                        bVarArr[i10] = new dm1.b(iB3, fArr3, fArr4, iB4);
                                                        i10++;
                                                        iE = i;
                                                        z2 = true;
                                                        iB2 = iB2;
                                                        i9 = 32;
                                                    }
                                                }
                                            }
                                            aVar = null;
                                        } else {
                                            z = z2;
                                            i = iE;
                                            aVar = new dm1.a(bVarArr);
                                        }
                                    }
                                }
                            }
                        }
                        z = z2;
                        i = iE;
                        aVar = null;
                    }
                    if (aVar != null) {
                        arrayList = arrayList2;
                        arrayList.add(aVar);
                    }
                } else {
                    arrayList = arrayList3;
                    z = z2;
                    i = iE;
                }
                wf1Var2.e(iH2);
                arrayList3 = arrayList;
                iD = iH2;
                iE = i;
                z2 = z;
            }
            return null;
        }
        return arrayList3;
    }

    public static dm1 a(int i, byte[] bArr) {
        ArrayList<dm1.a> arrayListA;
        wf1 wf1Var = new wf1(bArr);
        try {
            wf1Var.f(4);
            int iH = wf1Var.h();
            wf1Var.e(0);
            if (iH == 1886547818) {
                wf1Var.f(8);
                int iD = wf1Var.d();
                int iE = wf1Var.e();
                while (true) {
                    if (iD < iE) {
                        int iH2 = wf1Var.h() + iD;
                        if (iH2 > iD && iH2 <= iE) {
                            int iH3 = wf1Var.h();
                            if (iH3 != 2037673328 && iH3 != 1836279920) {
                                wf1Var.e(iH2);
                                iD = iH2;
                            }
                            wf1Var.d(iH2);
                            arrayListA = a(wf1Var);
                        }
                    }
                    arrayListA = null;
                }
            } else {
                arrayListA = a(wf1Var);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        if (arrayListA == null) {
            return null;
        }
        int size = arrayListA.size();
        if (size == 1) {
            dm1.a aVar = arrayListA.get(0);
            return new dm1(aVar, aVar, i);
        }
        if (size != 2) {
            return null;
        }
        return new dm1(arrayListA.get(0), arrayListA.get(1), i);
    }
}
