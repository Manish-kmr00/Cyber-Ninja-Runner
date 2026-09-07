package com.yandex.mobile.ads.impl;

import android.util.SparseArray;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public interface ld {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final yb0 f9502a;
        private final SparseArray<a> b;

        public b(yb0 yb0Var, SparseArray<a> sparseArray) {
            this.f9502a = yb0Var;
            SparseArray<a> sparseArray2 = new SparseArray<>(yb0Var.a());
            for (int i = 0; i < yb0Var.a(); i++) {
                int iB = yb0Var.b(i);
                sparseArray2.append(iB, (a) hg.a(sparseArray.get(iB)));
            }
            this.b = sparseArray2;
        }

        public final a c(int i) {
            a aVar = this.b.get(i);
            aVar.getClass();
            return aVar;
        }

        public final boolean a(int i) {
            return this.f9502a.a(i);
        }

        public final int b(int i) {
            return this.f9502a.b(i);
        }

        public final int a() {
            return this.f9502a.a();
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9501a;
        public final b52 b;
        public final int c;
        public final rw0.b d;
        public final long e;
        public final b52 f;
        public final int g;
        public final rw0.b h;
        public final long i;
        public final long j;

        public a(long j, b52 b52Var, int i, rw0.b bVar, long j2, b52 b52Var2, int i2, rw0.b bVar2, long j3, long j4) {
            this.f9501a = j;
            this.b = b52Var;
            this.c = i;
            this.d = bVar;
            this.e = j2;
            this.f = b52Var2;
            this.g = i2;
            this.h = bVar2;
            this.i = j3;
            this.j = j4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9501a == aVar.f9501a && this.c == aVar.c && this.e == aVar.e && this.g == aVar.g && this.i == aVar.i && this.j == aVar.j && vd1.a(this.b, aVar.b) && vd1.a(this.d, aVar.d) && vd1.a(this.f, aVar.f) && vd1.a(this.h, aVar.h);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.f9501a), this.b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j)});
        }
    }
}
