package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import com.json.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class gc0 implements jm {
    private static final gc0 H = new gc0(new a());
    public static final jm.a<gc0> I = new jm.a() { // from class: com.yandex.mobile.ads.impl.gc0$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return gc0.a(bundle);
        }
    };
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    private int G;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final String j;
    public final g01 k;
    public final String l;
    public final String m;
    public final int n;
    public final List<byte[]> o;
    public final c40 p;
    public final long q;
    public final int r;
    public final int s;
    public final float t;
    public final int u;
    public final float v;
    public final byte[] w;
    public final int x;
    public final pq y;
    public final int z;

    public final String toString() {
        return "Format(" + this.b + ", " + this.c + ", " + this.l + ", " + this.m + ", " + this.j + ", " + this.i + ", " + this.d + ", [" + this.r + ", " + this.s + ", " + this.t + "], [" + this.z + ", " + this.A + "])";
    }

    public static final class a {
        private int A;
        private int B;
        private int C;
        private int D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8989a;
        private String b;
        private String c;
        private int d;
        private int e;
        private int f;
        private int g;
        private String h;
        private g01 i;
        private String j;
        private String k;
        private int l;
        private List<byte[]> m;
        private c40 n;
        private long o;
        private int p;
        private int q;
        private float r;
        private int s;
        private float t;
        private byte[] u;
        private int v;
        private pq w;
        private int x;
        private int y;
        private int z;

        public a() {
            this.f = -1;
            this.g = -1;
            this.l = -1;
            this.o = Long.MAX_VALUE;
            this.p = -1;
            this.q = -1;
            this.r = -1.0f;
            this.t = 1.0f;
            this.v = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.C = -1;
            this.D = 0;
        }

        public final a g(int i) {
            this.f8989a = Integer.toString(i);
            return this;
        }

        public final a m(int i) {
            this.d = i;
            return this;
        }

        public final a b(int i) {
            this.f = i;
            return this;
        }

        public final a b() {
            this.j = "image/jpeg";
            return this;
        }

        public final a j(int i) {
            this.g = i;
            return this;
        }

        public final a h(int i) {
            this.l = i;
            return this;
        }

        private a(gc0 gc0Var) {
            this.f8989a = gc0Var.b;
            this.b = gc0Var.c;
            this.c = gc0Var.d;
            this.d = gc0Var.e;
            this.e = gc0Var.f;
            this.f = gc0Var.g;
            this.g = gc0Var.h;
            this.h = gc0Var.j;
            this.i = gc0Var.k;
            this.j = gc0Var.l;
            this.k = gc0Var.m;
            this.l = gc0Var.n;
            this.m = gc0Var.o;
            this.n = gc0Var.p;
            this.o = gc0Var.q;
            this.p = gc0Var.r;
            this.q = gc0Var.s;
            this.r = gc0Var.t;
            this.s = gc0Var.u;
            this.t = gc0Var.v;
            this.u = gc0Var.w;
            this.v = gc0Var.x;
            this.w = gc0Var.y;
            this.x = gc0Var.z;
            this.y = gc0Var.A;
            this.z = gc0Var.B;
            this.A = gc0Var.C;
            this.B = gc0Var.D;
            this.C = gc0Var.E;
            this.D = gc0Var.F;
        }

        public final a o(int i) {
            this.p = i;
            return this;
        }

        public final a f(int i) {
            this.q = i;
            return this;
        }

        public final a k(int i) {
            this.s = i;
            return this;
        }

        public final a n(int i) {
            this.v = i;
            return this;
        }

        public final a c(int i) {
            this.x = i;
            return this;
        }

        public final a l(int i) {
            this.y = i;
            return this;
        }

        public final a i(int i) {
            this.z = i;
            return this;
        }

        public final a d(int i) {
            this.A = i;
            return this;
        }

        public final a e(int i) {
            this.B = i;
            return this;
        }

        public final a b(String str) {
            this.f8989a = str;
            return this;
        }

        public final a a(int i) {
            this.C = i;
            return this;
        }

        public final a c(String str) {
            this.b = str;
            return this;
        }

        public final a d(String str) {
            this.c = str;
            return this;
        }

        public final a a(String str) {
            this.h = str;
            return this;
        }

        public final a e(String str) {
            this.k = str;
            return this;
        }

        public final a b(float f) {
            this.t = f;
            return this;
        }

        public final a a(pq pqVar) {
            this.w = pqVar;
            return this;
        }

        public final a a(c40 c40Var) {
            this.n = c40Var;
            return this;
        }

        public final void a(float f) {
            this.r = f;
        }

        public final a a(List<byte[]> list) {
            this.m = list;
            return this;
        }

        public final a a(g01 g01Var) {
            this.i = g01Var;
            return this;
        }

        public final a a(byte[] bArr) {
            this.u = bArr;
            return this;
        }

        public final a a(long j) {
            this.o = j;
            return this;
        }

        public final gc0 a() {
            return new gc0(this);
        }
    }

    private gc0(a aVar) {
        this.b = aVar.f8989a;
        this.c = aVar.b;
        this.d = x82.e(aVar.c);
        this.e = aVar.d;
        this.f = aVar.e;
        int i = aVar.f;
        this.g = i;
        int i2 = aVar.g;
        this.h = i2;
        this.i = i2 != -1 ? i2 : i;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        List<byte[]> list = aVar.m;
        this.o = list == null ? Collections.emptyList() : list;
        c40 c40Var = aVar.n;
        this.p = c40Var;
        this.q = aVar.o;
        this.r = aVar.p;
        this.s = aVar.q;
        this.t = aVar.r;
        int i3 = aVar.s;
        this.u = i3 == -1 ? 0 : i3;
        float f = aVar.t;
        this.v = f == -1.0f ? 1.0f : f;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        int i4 = aVar.A;
        this.C = i4 == -1 ? 0 : i4;
        int i5 = aVar.B;
        this.D = i5 != -1 ? i5 : 0;
        this.E = aVar.C;
        int i6 = aVar.D;
        if (i6 == 0 && c40Var != null) {
            this.F = 1;
        } else {
            this.F = i6;
        }
    }

    public final int b() {
        int i;
        int i2 = this.r;
        if (i2 == -1 || (i = this.s) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final int hashCode() {
        if (this.G == 0) {
            String str = this.b;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
            String str2 = this.c;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.d;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31;
            String str4 = this.j;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            g01 g01Var = this.k;
            int iHashCode5 = (iHashCode4 + (g01Var == null ? 0 : g01Var.hashCode())) * 31;
            String str5 = this.l;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.m;
            this.G = ((((((((((((((((Float.floatToIntBits(this.v) + ((((Float.floatToIntBits(this.t) + ((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.n) * 31) + ((int) this.q)) * 31) + this.r) * 31) + this.s) * 31)) * 31) + this.u) * 31)) * 31) + this.x) * 31) + this.z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F;
        }
        return this.G;
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || gc0.class != obj.getClass()) {
            return false;
        }
        gc0 gc0Var = (gc0) obj;
        int i2 = this.G;
        if (i2 == 0 || (i = gc0Var.G) == 0 || i2 == i) {
            return this.e == gc0Var.e && this.f == gc0Var.f && this.g == gc0Var.g && this.h == gc0Var.h && this.n == gc0Var.n && this.q == gc0Var.q && this.r == gc0Var.r && this.s == gc0Var.s && this.u == gc0Var.u && this.x == gc0Var.x && this.z == gc0Var.z && this.A == gc0Var.A && this.B == gc0Var.B && this.C == gc0Var.C && this.D == gc0Var.D && this.E == gc0Var.E && this.F == gc0Var.F && Float.compare(this.t, gc0Var.t) == 0 && Float.compare(this.v, gc0Var.v) == 0 && x82.a(this.b, gc0Var.b) && x82.a(this.c, gc0Var.c) && x82.a(this.j, gc0Var.j) && x82.a(this.l, gc0Var.l) && x82.a(this.m, gc0Var.m) && x82.a(this.d, gc0Var.d) && Arrays.equals(this.w, gc0Var.w) && x82.a(this.k, gc0Var.k) && x82.a(this.y, gc0Var.y) && x82.a(this.p, gc0Var.p) && a(gc0Var);
        }
        return false;
    }

    public final boolean a(gc0 gc0Var) {
        if (this.o.size() != gc0Var.o.size()) {
            return false;
        }
        for (int i = 0; i < this.o.size(); i++) {
            if (!Arrays.equals(this.o.get(i), gc0Var.o.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final a a() {
        return new a();
    }

    public final gc0 a(int i) {
        a aVar = new a();
        aVar.D = i;
        return new gc0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static gc0 a(Bundle bundle) {
        a aVar = new a();
        if (bundle != null) {
            ClassLoader classLoader = km.class.getClassLoader();
            int i = x82.f10629a;
            bundle.setClassLoader(classLoader);
        }
        int i2 = 0;
        String string = bundle.getString(Integer.toString(0, 36));
        gc0 gc0Var = H;
        String str = gc0Var.b;
        if (string == null) {
            string = str;
        }
        aVar.f8989a = string;
        String string2 = bundle.getString(Integer.toString(1, 36));
        String str2 = gc0Var.c;
        if (string2 == null) {
            string2 = str2;
        }
        aVar.b = string2;
        String string3 = bundle.getString(Integer.toString(2, 36));
        String str3 = gc0Var.d;
        if (string3 == null) {
            string3 = str3;
        }
        aVar.c = string3;
        aVar.d = bundle.getInt(Integer.toString(3, 36), gc0Var.e);
        aVar.e = bundle.getInt(Integer.toString(4, 36), gc0Var.f);
        aVar.f = bundle.getInt(Integer.toString(5, 36), gc0Var.g);
        aVar.g = bundle.getInt(Integer.toString(6, 36), gc0Var.h);
        String string4 = bundle.getString(Integer.toString(7, 36));
        String str4 = gc0Var.j;
        if (string4 == null) {
            string4 = str4;
        }
        aVar.h = string4;
        g01 g01Var = (g01) bundle.getParcelable(Integer.toString(8, 36));
        g01 g01Var2 = gc0Var.k;
        if (g01Var == null) {
            g01Var = g01Var2;
        }
        aVar.i = g01Var;
        String string5 = bundle.getString(Integer.toString(9, 36));
        String str5 = gc0Var.l;
        if (string5 == null) {
            string5 = str5;
        }
        aVar.j = string5;
        String string6 = bundle.getString(Integer.toString(10, 36));
        String str6 = gc0Var.m;
        if (string6 == null) {
            string6 = str6;
        }
        aVar.k = string6;
        aVar.l = bundle.getInt(Integer.toString(11, 36), gc0Var.n);
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte[] byteArray = bundle.getByteArray(Integer.toString(12, 36) + "_" + Integer.toString(i2, 36));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i2++;
        }
        aVar.m = arrayList;
        aVar.n = (c40) bundle.getParcelable(Integer.toString(13, 36));
        String string7 = Integer.toString(14, 36);
        gc0 gc0Var2 = H;
        aVar.o = bundle.getLong(string7, gc0Var2.q);
        aVar.p = bundle.getInt(Integer.toString(15, 36), gc0Var2.r);
        aVar.q = bundle.getInt(Integer.toString(16, 36), gc0Var2.s);
        aVar.r = bundle.getFloat(Integer.toString(17, 36), gc0Var2.t);
        aVar.s = bundle.getInt(Integer.toString(18, 36), gc0Var2.u);
        aVar.t = bundle.getFloat(Integer.toString(19, 36), gc0Var2.v);
        aVar.u = bundle.getByteArray(Integer.toString(20, 36));
        aVar.v = bundle.getInt(Integer.toString(21, 36), gc0Var2.x);
        Bundle bundle2 = bundle.getBundle(Integer.toString(22, 36));
        if (bundle2 != null) {
            aVar.w = (pq) pq.g.fromBundle(bundle2);
        }
        aVar.x = bundle.getInt(Integer.toString(23, 36), gc0Var2.z);
        aVar.y = bundle.getInt(Integer.toString(24, 36), gc0Var2.A);
        aVar.z = bundle.getInt(Integer.toString(25, 36), gc0Var2.B);
        aVar.A = bundle.getInt(Integer.toString(26, 36), gc0Var2.C);
        aVar.B = bundle.getInt(Integer.toString(27, 36), gc0Var2.D);
        aVar.C = bundle.getInt(Integer.toString(28, 36), gc0Var2.E);
        aVar.D = bundle.getInt(Integer.toString(29, 36), gc0Var2.F);
        return new gc0(aVar);
    }
}
