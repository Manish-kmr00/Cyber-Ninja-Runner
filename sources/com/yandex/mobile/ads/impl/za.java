package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes6.dex */
public final class za extends tk {
    private final vi f;
    private final hp g;

    public static class b implements e70.b {
        public b(int i) {
            this((Object) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final e70[] a(e70.a[] aVarArr, vi viVar) {
            hk0 hk0VarA = za.a(aVarArr);
            e70[] e70VarArr = new e70[aVarArr.length];
            for (int i = 0; i < aVarArr.length; i++) {
                e70.a aVar = aVarArr[i];
                if (aVar != null) {
                    int[] iArr = aVar.b;
                    if (iArr.length != 0) {
                        e70VarArr[i] = iArr.length == 1 ? new qb0(iArr[0], aVar.c, aVar.f8769a) : new za(aVar.f8769a, iArr, aVar.c, viVar, 10000, 25000, (hk0) hk0VarA.get(i), hp.f9123a);
                    }
                }
            }
            return e70VarArr;
        }

        public b(Object obj) {
        }
    }

    @Override // com.yandex.mobile.ads.impl.tk, com.yandex.mobile.ads.impl.e70
    public final void a(float f) {
    }

    @Override // com.yandex.mobile.ads.impl.tk, com.yandex.mobile.ads.impl.e70
    public final void c() {
    }

    @Override // com.yandex.mobile.ads.impl.tk, com.yandex.mobile.ads.impl.e70
    public final void d() {
    }

    protected za(r52 r52Var, int[] iArr, int i, vi viVar, long j, long j2, hk0 hk0Var, hp hpVar) {
        super(r52Var, iArr);
        if (j2 < j) {
            at0.d("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
        }
        this.f = viVar;
        hk0.a((Collection) hk0Var);
        this.g = hpVar;
    }

    private static void a(ArrayList arrayList, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            hk0.a aVar = (hk0.a) arrayList.get(i);
            if (aVar != null) {
                aVar.b(new a(j, jArr[i]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static hk0<hk0<a>> a(e70.a[] aVarArr) {
        int i;
        int[] iArr;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = 1;
            if (i3 >= aVarArr.length) {
                break;
            }
            e70.a aVar = aVarArr[i3];
            if (aVar != null && aVar.b.length > 1) {
                hk0.a aVarG = hk0.g();
                aVarG.b(new a(0L, 0L));
                arrayList.add(aVarG);
            } else {
                arrayList.add(null);
            }
            i3++;
        }
        int length = aVarArr.length;
        long[][] jArr = new long[length][];
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            e70.a aVar2 = aVarArr[i4];
            if (aVar2 == null) {
                jArr[i4] = new long[0];
            } else {
                jArr[i4] = new long[aVar2.b.length];
                int i5 = 0;
                while (true) {
                    int[] iArr2 = aVar2.b;
                    if (i5 >= iArr2.length) {
                        break;
                    }
                    jArr[i4][i5] = aVar2.f8769a.a(iArr2[i5]).i;
                    i5++;
                }
                Arrays.sort(jArr[i4]);
            }
        }
        int[] iArr3 = new int[length];
        long[] jArr2 = new long[length];
        for (int i6 = 0; i6 < length; i6++) {
            long[] jArr3 = jArr[i6];
            jArr2[i6] = jArr3.length == 0 ? 0L : jArr3[0];
        }
        a(arrayList, jArr2);
        p31 p31VarB = r31.a().a().b();
        int i7 = 0;
        while (i7 < length) {
            long[] jArr4 = jArr[i7];
            if (jArr4.length <= i) {
                iArr = iArr3;
            } else {
                int length2 = jArr4.length;
                double[] dArr = new double[length2];
                int i8 = i2;
                while (true) {
                    long[] jArr5 = jArr[i7];
                    double dLog = 0.0d;
                    if (i8 >= jArr5.length) {
                        break;
                    }
                    int[] iArr4 = iArr3;
                    long j = jArr5[i8];
                    if (j != -1) {
                        dLog = Math.log(j);
                    }
                    dArr[i8] = dLog;
                    i8++;
                    iArr3 = iArr4;
                }
                iArr = iArr3;
                int i9 = length2 - 1;
                double d = dArr[i9] - dArr[i2];
                int i10 = i2;
                while (i10 < i9) {
                    double d2 = dArr[i10];
                    i10++;
                    p31VarB.put(Double.valueOf(d == 0.0d ? 1.0d : (((d2 + dArr[i10]) * 0.5d) - dArr[i2]) / d), Integer.valueOf(i7));
                    i2 = 0;
                }
            }
            i7++;
            iArr3 = iArr;
            i2 = 0;
            i = 1;
        }
        int[] iArr5 = iArr3;
        hk0 hk0VarA = hk0.a(p31VarB.values());
        for (int i11 = 0; i11 < hk0VarA.size(); i11++) {
            int iIntValue = ((Integer) hk0VarA.get(i11)).intValue();
            int i12 = iArr5[iIntValue] + 1;
            iArr5[iIntValue] = i12;
            jArr2[iIntValue] = jArr[iIntValue][i12];
            a(arrayList, jArr2);
        }
        for (int i13 = 0; i13 < aVarArr.length; i13++) {
            if (arrayList.get(i13) != null) {
                jArr2[i13] = jArr2[i13] * 2;
            }
        }
        a(arrayList, jArr2);
        hk0.a aVarG2 = hk0.g();
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            hk0.a aVar3 = (hk0.a) arrayList.get(i14);
            aVarG2.b((Object) (aVar3 == null ? hk0.h() : aVar3.a()));
        }
        return aVarG2.a();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10804a;
        public final long b;

        public a(long j, long j2) {
            this.f10804a = j;
            this.b = j2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f10804a == aVar.f10804a && this.b == aVar.b;
        }

        public final int hashCode() {
            return (((int) this.f10804a) * 31) + ((int) this.b);
        }
    }
}
