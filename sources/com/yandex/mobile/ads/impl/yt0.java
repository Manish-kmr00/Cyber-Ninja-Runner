package com.yandex.mobile.ads.impl;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public abstract class yt0 extends y52 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10768a;
        private final int[] b;
        private final s52[] c;
        private final int[] d;
        private final int[][][] e;
        private final s52 f;

        a(int[] iArr, s52[] s52VarArr, int[] iArr2, int[][][] iArr3, s52 s52Var) {
            this.b = iArr;
            this.c = s52VarArr;
            this.e = iArr3;
            this.d = iArr2;
            this.f = s52Var;
            this.f10768a = iArr.length;
        }

        public final int a(int i, int i2) {
            int i3 = this.c[i].a(i2).b;
            int[] iArr = new int[i3];
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                if (a(i, i2, i6) == 4) {
                    iArr[i5] = i6;
                    i5++;
                }
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
            int iMin = 16;
            int i7 = 0;
            String str = null;
            boolean z = false;
            while (i4 < iArrCopyOf.length) {
                String str2 = this.c[i].a(i2).a(iArrCopyOf[i4]).m;
                int i8 = i7 + 1;
                if (i7 == 0) {
                    str = str2;
                } else {
                    z |= !x82.a(str, str2);
                }
                iMin = Math.min(iMin, this.e[i][i2][i4] & 24);
                i4++;
                i7 = i8;
            }
            return z ? Math.min(iMin, this.d[i]) : iMin;
        }

        public final int a() {
            return this.f10768a;
        }

        public final s52 b(int i) {
            return this.c[i];
        }

        public final int a(int i) {
            return this.b[i];
        }

        public final int a(int i, int i2, int i3) {
            return this.e[i][i2][i3] & 7;
        }

        public final s52 b() {
            return this.f;
        }
    }

    protected abstract Pair<to1[], e70[]> a(a aVar, int[][][] iArr, int[] iArr2, rw0.b bVar, b52 b52Var) throws j60;

    @Override // com.yandex.mobile.ads.impl.y52
    public final void a(Object obj) {
    }

    @Override // com.yandex.mobile.ads.impl.y52
    public final z52 a(so1[] so1VarArr, s52 s52Var, rw0.b bVar, b52 b52Var) throws j60 {
        boolean z;
        int[] iArr;
        s52 s52Var2 = s52Var;
        boolean z2 = true;
        int[] iArr2 = new int[so1VarArr.length + 1];
        int length = so1VarArr.length + 1;
        r52[][] r52VarArr = new r52[length][];
        int[][][] iArr3 = new int[so1VarArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = s52Var2.b;
            r52VarArr[i] = new r52[i2];
            iArr3[i] = new int[i2][];
        }
        int length2 = so1VarArr.length;
        int[] iArr4 = new int[length2];
        for (int i3 = 0; i3 < length2; i3++) {
            iArr4[i3] = so1VarArr[i3].f();
        }
        int i4 = 0;
        while (i4 < s52Var2.b) {
            r52 r52VarA = s52Var2.a(i4);
            boolean z3 = r52VarA.d == 5 ? z2 : false;
            int length3 = so1VarArr.length;
            boolean z4 = z2;
            int i5 = 0;
            for (int i6 = 0; i6 < so1VarArr.length; i6++) {
                so1 so1Var = so1VarArr[i6];
                int iMax = 0;
                for (int i7 = 0; i7 < r52VarA.b; i7++) {
                    iMax = Math.max(iMax, so1Var.a(r52VarA.a(i7)) & 7);
                }
                boolean z5 = iArr2[i6] == 0;
                if (iMax > i5 || (iMax == i5 && z3 && !z4 && z5)) {
                    z4 = z5;
                    i5 = iMax;
                    length3 = i6;
                }
            }
            if (length3 == so1VarArr.length) {
                iArr = new int[r52VarA.b];
            } else {
                so1 so1Var2 = so1VarArr[length3];
                int[] iArr5 = new int[r52VarA.b];
                for (int i8 = 0; i8 < r52VarA.b; i8++) {
                    iArr5[i8] = so1Var2.a(r52VarA.a(i8));
                }
                iArr = iArr5;
            }
            int i9 = iArr2[length3];
            r52VarArr[length3][i9] = r52VarA;
            iArr3[length3][i9] = iArr;
            iArr2[length3] = i9 + 1;
            i4++;
            z2 = true;
            s52Var2 = s52Var;
        }
        boolean z6 = z2;
        s52[] s52VarArr = new s52[so1VarArr.length];
        String[] strArr = new String[so1VarArr.length];
        int[] iArr6 = new int[so1VarArr.length];
        for (int i10 = 0; i10 < so1VarArr.length; i10++) {
            int i11 = iArr2[i10];
            s52VarArr[i10] = new s52((r52[]) x82.a(i11, r52VarArr[i10]));
            iArr3[i10] = (int[][]) x82.a(i11, iArr3[i10]);
            strArr[i10] = so1VarArr[i10].getName();
            iArr6[i10] = ((rk) so1VarArr[i10]).m();
        }
        a aVar = new a(iArr6, s52VarArr, iArr4, iArr3, new s52((r52[]) x82.a(iArr2[so1VarArr.length], r52VarArr[so1VarArr.length])));
        Pair<to1[], e70[]> pairA = a(aVar, iArr3, iArr4, bVar, b52Var);
        v52[] v52VarArr = (v52[]) pairA.second;
        List[] listArr = new List[v52VarArr.length];
        for (int i12 = 0; i12 < v52VarArr.length; i12++) {
            v52 v52Var = v52VarArr[i12];
            listArr[i12] = v52Var != null ? hk0.a(v52Var) : hk0.h();
        }
        hk0.a aVar2 = new hk0.a();
        int i13 = 0;
        while (i13 < aVar.f10768a) {
            s52 s52Var3 = aVar.c[i13];
            List list = listArr[i13];
            int i14 = 0;
            while (i14 < s52Var3.b) {
                r52 r52VarA2 = s52Var3.a(i14);
                boolean z7 = aVar.a(i13, i14) != 0 ? z6 : false;
                int i15 = r52VarA2.b;
                int[] iArr7 = new int[i15];
                boolean[] zArr = new boolean[i15];
                for (int i16 = 0; i16 < r52VarA2.b; i16++) {
                    iArr7[i16] = aVar.a(i13, i14, i16);
                    int i17 = 0;
                    while (true) {
                        if (i17 >= list.size()) {
                            z = false;
                            break;
                        }
                        v52 v52Var2 = (v52) list.get(i17);
                        if (v52Var2.a().equals(r52VarA2) && v52Var2.c(i16) != -1) {
                            z = true;
                            break;
                        }
                        i17++;
                    }
                    zArr[i16] = z;
                }
                aVar2.b(new u62.a(r52VarA2, z7, iArr7, zArr));
                i14++;
                z6 = true;
            }
            i13++;
            z6 = true;
        }
        s52 s52Var4 = aVar.f;
        for (int i18 = 0; i18 < s52Var4.b; i18++) {
            r52 r52VarA3 = s52Var4.a(i18);
            int[] iArr8 = new int[r52VarA3.b];
            Arrays.fill(iArr8, 0);
            aVar2.b(new u62.a(r52VarA3, false, iArr8, new boolean[r52VarA3.b]));
        }
        return new z52((to1[]) pairA.first, (e70[]) pairA.second, new u62(aVar2.a()), aVar);
    }
}
