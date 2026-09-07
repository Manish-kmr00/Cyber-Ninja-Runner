package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public final class iw0 implements jm {
    public static final iw0 H = new iw0(new a());
    public static final jm.a<iw0> I = new jm.a() { // from class: com.yandex.mobile.ads.impl.iw0$$ExternalSyntheticLambda0
        @Override // com.yandex.mobile.ads.impl.jm.a
        public final jm fromBundle(Bundle bundle) {
            return iw0.a(bundle);
        }
    };
    public final CharSequence A;
    public final Integer B;
    public final Integer C;
    public final CharSequence D;
    public final CharSequence E;
    public final CharSequence F;
    public final Bundle G;
    public final CharSequence b;
    public final CharSequence c;
    public final CharSequence d;
    public final CharSequence e;
    public final CharSequence f;
    public final CharSequence g;
    public final CharSequence h;
    public final dn1 i;
    public final dn1 j;
    public final byte[] k;
    public final Integer l;
    public final Uri m;
    public final Integer n;
    public final Integer o;
    public final Integer p;
    public final Boolean q;

    @Deprecated
    public final Integer r;
    public final Integer s;
    public final Integer t;
    public final Integer u;
    public final Integer v;
    public final Integer w;
    public final Integer x;
    public final CharSequence y;
    public final CharSequence z;

    public static final class a {
        private Integer A;
        private CharSequence B;
        private CharSequence C;
        private CharSequence D;
        private Bundle E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f9261a;
        private CharSequence b;
        private CharSequence c;
        private CharSequence d;
        private CharSequence e;
        private CharSequence f;
        private CharSequence g;
        private dn1 h;
        private dn1 i;
        private byte[] j;
        private Integer k;
        private Uri l;
        private Integer m;
        private Integer n;
        private Integer o;
        private Boolean p;
        private Integer q;
        private Integer r;
        private Integer s;
        private Integer t;
        private Integer u;
        private Integer v;
        private CharSequence w;
        private CharSequence x;
        private CharSequence y;
        private Integer z;

        public final void a(int i, byte[] bArr) {
            if (this.j == null || x82.a((Object) Integer.valueOf(i), (Object) 3) || !x82.a((Object) this.k, (Object) 3)) {
                this.j = (byte[]) bArr.clone();
                this.k = Integer.valueOf(i);
            }
        }

        public final void b(String str) {
            this.c = str;
        }

        public final void c(String str) {
            this.b = str;
        }

        public final void d(String str) {
            this.x = str;
        }

        public final void e(String str) {
            this.y = str;
        }

        public final void f(String str) {
            this.g = str;
        }

        public final void g(String str) {
            this.B = str;
        }

        public final void h(String str) {
            this.D = str;
        }

        public final void i(String str) {
            this.f9261a = str;
        }

        public final void j(String str) {
            this.w = str;
        }

        public final void c(Integer num) {
            this.q = num;
        }

        public final void d(Integer num) {
            this.v = num;
        }

        public final void e(Integer num) {
            this.u = num;
        }

        public final void f(Integer num) {
            this.t = num;
        }

        public final void g(Integer num) {
            this.n = num;
        }

        public a() {
        }

        private a(iw0 iw0Var) {
            this.f9261a = iw0Var.b;
            this.b = iw0Var.c;
            this.c = iw0Var.d;
            this.d = iw0Var.e;
            this.e = iw0Var.f;
            this.f = iw0Var.g;
            this.g = iw0Var.h;
            this.h = iw0Var.i;
            this.i = iw0Var.j;
            this.j = iw0Var.k;
            this.k = iw0Var.l;
            this.l = iw0Var.m;
            this.m = iw0Var.n;
            this.n = iw0Var.o;
            this.o = iw0Var.p;
            this.p = iw0Var.q;
            this.q = iw0Var.s;
            this.r = iw0Var.t;
            this.s = iw0Var.u;
            this.t = iw0Var.v;
            this.u = iw0Var.w;
            this.v = iw0Var.x;
            this.w = iw0Var.y;
            this.x = iw0Var.z;
            this.y = iw0Var.A;
            this.z = iw0Var.B;
            this.A = iw0Var.C;
            this.B = iw0Var.D;
            this.C = iw0Var.E;
            this.D = iw0Var.F;
            this.E = iw0Var.G;
        }

        public final a h(Integer num) {
            this.m = num;
            return this;
        }

        public final a b(Integer num) {
            this.r = num;
            return this;
        }

        public final a a(iw0 iw0Var) {
            if (iw0Var == null) {
                return this;
            }
            CharSequence charSequence = iw0Var.b;
            if (charSequence != null) {
                this.f9261a = charSequence;
            }
            CharSequence charSequence2 = iw0Var.c;
            if (charSequence2 != null) {
                this.b = charSequence2;
            }
            CharSequence charSequence3 = iw0Var.d;
            if (charSequence3 != null) {
                this.c = charSequence3;
            }
            CharSequence charSequence4 = iw0Var.e;
            if (charSequence4 != null) {
                this.d = charSequence4;
            }
            CharSequence charSequence5 = iw0Var.f;
            if (charSequence5 != null) {
                this.e = charSequence5;
            }
            CharSequence charSequence6 = iw0Var.g;
            if (charSequence6 != null) {
                this.f = charSequence6;
            }
            CharSequence charSequence7 = iw0Var.h;
            if (charSequence7 != null) {
                this.g = charSequence7;
            }
            dn1 dn1Var = iw0Var.i;
            if (dn1Var != null) {
                this.h = dn1Var;
            }
            dn1 dn1Var2 = iw0Var.j;
            if (dn1Var2 != null) {
                this.i = dn1Var2;
            }
            byte[] bArr = iw0Var.k;
            if (bArr != null) {
                Integer num = iw0Var.l;
                this.j = (byte[]) bArr.clone();
                this.k = num;
            }
            Uri uri = iw0Var.m;
            if (uri != null) {
                this.l = uri;
            }
            Integer num2 = iw0Var.n;
            if (num2 != null) {
                this.m = num2;
            }
            Integer num3 = iw0Var.o;
            if (num3 != null) {
                this.n = num3;
            }
            Integer num4 = iw0Var.p;
            if (num4 != null) {
                this.o = num4;
            }
            Boolean bool = iw0Var.q;
            if (bool != null) {
                this.p = bool;
            }
            Integer num5 = iw0Var.r;
            if (num5 != null) {
                this.q = num5;
            }
            Integer num6 = iw0Var.s;
            if (num6 != null) {
                this.q = num6;
            }
            Integer num7 = iw0Var.t;
            if (num7 != null) {
                this.r = num7;
            }
            Integer num8 = iw0Var.u;
            if (num8 != null) {
                this.s = num8;
            }
            Integer num9 = iw0Var.v;
            if (num9 != null) {
                this.t = num9;
            }
            Integer num10 = iw0Var.w;
            if (num10 != null) {
                this.u = num10;
            }
            Integer num11 = iw0Var.x;
            if (num11 != null) {
                this.v = num11;
            }
            CharSequence charSequence8 = iw0Var.y;
            if (charSequence8 != null) {
                this.w = charSequence8;
            }
            CharSequence charSequence9 = iw0Var.z;
            if (charSequence9 != null) {
                this.x = charSequence9;
            }
            CharSequence charSequence10 = iw0Var.A;
            if (charSequence10 != null) {
                this.y = charSequence10;
            }
            Integer num12 = iw0Var.B;
            if (num12 != null) {
                this.z = num12;
            }
            Integer num13 = iw0Var.C;
            if (num13 != null) {
                this.A = num13;
            }
            CharSequence charSequence11 = iw0Var.D;
            if (charSequence11 != null) {
                this.B = charSequence11;
            }
            CharSequence charSequence12 = iw0Var.E;
            if (charSequence12 != null) {
                this.C = charSequence12;
            }
            CharSequence charSequence13 = iw0Var.F;
            if (charSequence13 != null) {
                this.D = charSequence13;
            }
            Bundle bundle = iw0Var.G;
            if (bundle != null) {
                this.E = bundle;
            }
            return this;
        }

        public final void a(String str) {
            this.d = str;
        }

        public final void a(Integer num) {
            this.s = num;
        }

        public final iw0 a() {
            return new iw0(this);
        }
    }

    public final a a() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static iw0 a(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        a aVar = new a();
        aVar.f9261a = bundle.getCharSequence(Integer.toString(0, 36));
        aVar.b = bundle.getCharSequence(Integer.toString(1, 36));
        aVar.c = bundle.getCharSequence(Integer.toString(2, 36));
        aVar.d = bundle.getCharSequence(Integer.toString(3, 36));
        aVar.e = bundle.getCharSequence(Integer.toString(4, 36));
        aVar.f = bundle.getCharSequence(Integer.toString(5, 36));
        aVar.g = bundle.getCharSequence(Integer.toString(6, 36));
        byte[] byteArray = bundle.getByteArray(Integer.toString(10, 36));
        Integer numValueOf = bundle.containsKey(Integer.toString(29, 36)) ? Integer.valueOf(bundle.getInt(Integer.toString(29, 36))) : null;
        aVar.j = byteArray != null ? (byte[]) byteArray.clone() : null;
        aVar.k = numValueOf;
        aVar.l = (Uri) bundle.getParcelable(Integer.toString(11, 36));
        aVar.w = bundle.getCharSequence(Integer.toString(22, 36));
        aVar.x = bundle.getCharSequence(Integer.toString(23, 36));
        aVar.y = bundle.getCharSequence(Integer.toString(24, 36));
        aVar.B = bundle.getCharSequence(Integer.toString(27, 36));
        aVar.C = bundle.getCharSequence(Integer.toString(28, 36));
        aVar.D = bundle.getCharSequence(Integer.toString(30, 36));
        aVar.E = bundle.getBundle(Integer.toString(1000, 36));
        if (bundle.containsKey(Integer.toString(8, 36)) && (bundle3 = bundle.getBundle(Integer.toString(8, 36))) != null) {
            aVar.h = (dn1) dn1.b.fromBundle(bundle3);
        }
        if (bundle.containsKey(Integer.toString(9, 36)) && (bundle2 = bundle.getBundle(Integer.toString(9, 36))) != null) {
            aVar.i = (dn1) dn1.b.fromBundle(bundle2);
        }
        if (bundle.containsKey(Integer.toString(12, 36))) {
            aVar.m = Integer.valueOf(bundle.getInt(Integer.toString(12, 36)));
        }
        if (bundle.containsKey(Integer.toString(13, 36))) {
            aVar.n = Integer.valueOf(bundle.getInt(Integer.toString(13, 36)));
        }
        if (bundle.containsKey(Integer.toString(14, 36))) {
            aVar.o = Integer.valueOf(bundle.getInt(Integer.toString(14, 36)));
        }
        if (bundle.containsKey(Integer.toString(15, 36))) {
            aVar.p = Boolean.valueOf(bundle.getBoolean(Integer.toString(15, 36)));
        }
        if (bundle.containsKey(Integer.toString(16, 36))) {
            aVar.q = Integer.valueOf(bundle.getInt(Integer.toString(16, 36)));
        }
        if (bundle.containsKey(Integer.toString(17, 36))) {
            aVar.r = Integer.valueOf(bundle.getInt(Integer.toString(17, 36)));
        }
        if (bundle.containsKey(Integer.toString(18, 36))) {
            aVar.s = Integer.valueOf(bundle.getInt(Integer.toString(18, 36)));
        }
        if (bundle.containsKey(Integer.toString(19, 36))) {
            aVar.t = Integer.valueOf(bundle.getInt(Integer.toString(19, 36)));
        }
        if (bundle.containsKey(Integer.toString(20, 36))) {
            aVar.u = Integer.valueOf(bundle.getInt(Integer.toString(20, 36)));
        }
        if (bundle.containsKey(Integer.toString(21, 36))) {
            aVar.v = Integer.valueOf(bundle.getInt(Integer.toString(21, 36)));
        }
        if (bundle.containsKey(Integer.toString(25, 36))) {
            aVar.z = Integer.valueOf(bundle.getInt(Integer.toString(25, 36)));
        }
        if (bundle.containsKey(Integer.toString(26, 36))) {
            aVar.A = Integer.valueOf(bundle.getInt(Integer.toString(26, 36)));
        }
        return new iw0(aVar);
    }

    private iw0(a aVar) {
        this.b = aVar.f9261a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
        this.h = aVar.g;
        this.i = aVar.h;
        this.j = aVar.i;
        this.k = aVar.j;
        this.l = aVar.k;
        this.m = aVar.l;
        this.n = aVar.m;
        this.o = aVar.n;
        this.p = aVar.o;
        this.q = aVar.p;
        Integer num = aVar.q;
        this.r = num;
        this.s = num;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        this.D = aVar.B;
        this.E = aVar.C;
        this.F = aVar.D;
        this.G = aVar.E;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || iw0.class != obj.getClass()) {
            return false;
        }
        iw0 iw0Var = (iw0) obj;
        return x82.a(this.b, iw0Var.b) && x82.a(this.c, iw0Var.c) && x82.a(this.d, iw0Var.d) && x82.a(this.e, iw0Var.e) && x82.a(this.f, iw0Var.f) && x82.a(this.g, iw0Var.g) && x82.a(this.h, iw0Var.h) && x82.a(this.i, iw0Var.i) && x82.a(this.j, iw0Var.j) && Arrays.equals(this.k, iw0Var.k) && x82.a(this.l, iw0Var.l) && x82.a(this.m, iw0Var.m) && x82.a(this.n, iw0Var.n) && x82.a(this.o, iw0Var.o) && x82.a(this.p, iw0Var.p) && x82.a(this.q, iw0Var.q) && x82.a(this.s, iw0Var.s) && x82.a(this.t, iw0Var.t) && x82.a(this.u, iw0Var.u) && x82.a(this.v, iw0Var.v) && x82.a(this.w, iw0Var.w) && x82.a(this.x, iw0Var.x) && x82.a(this.y, iw0Var.y) && x82.a(this.z, iw0Var.z) && x82.a(this.A, iw0Var.A) && x82.a(this.B, iw0Var.B) && x82.a(this.C, iw0Var.C) && x82.a(this.D, iw0Var.D) && x82.a(this.E, iw0Var.E) && x82.a(this.F, iw0Var.F);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, Integer.valueOf(Arrays.hashCode(this.k)), this.l, this.m, this.n, this.o, this.p, this.q, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F});
    }
}
