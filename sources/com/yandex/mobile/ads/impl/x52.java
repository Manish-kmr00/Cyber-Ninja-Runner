package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public class x52 implements jm {
    public static final x52 B = new x52(new a());
    public final jk0<Integer> A;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final boolean l;
    public final hk0<String> m;
    public final int n;
    public final hk0<String> o;
    public final int p;
    public final int q;
    public final int r;
    public final hk0<String> s;
    public final hk0<String> t;
    public final int u;
    public final int v;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final ik0<r52, w52> z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10624a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private boolean k;
        private hk0<String> l;
        private int m;
        private hk0<String> n;
        private int o;
        private int p;
        private int q;
        private hk0<String> r;
        private hk0<String> s;
        private int t;
        private int u;
        private boolean v;
        private boolean w;
        private boolean x;
        private HashMap<r52, w52> y;
        private HashSet<Integer> z;

        public void b(Context context) {
            Point pointC = x82.c(context);
            a(pointC.x, pointC.y);
        }

        @Deprecated
        public a() {
            this.f10624a = Integer.MAX_VALUE;
            this.b = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
            this.d = Integer.MAX_VALUE;
            this.i = Integer.MAX_VALUE;
            this.j = Integer.MAX_VALUE;
            this.k = true;
            this.l = hk0.h();
            this.m = 0;
            this.n = hk0.h();
            this.o = 0;
            this.p = Integer.MAX_VALUE;
            this.q = Integer.MAX_VALUE;
            this.r = hk0.h();
            this.s = hk0.h();
            this.t = 0;
            this.u = 0;
            this.v = false;
            this.w = false;
            this.x = false;
            this.y = new HashMap<>();
            this.z = new HashSet<>();
        }

        public a(Context context) {
            this();
            a(context);
            b(context);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v35, types: [java.io.Serializable, java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r0v44, types: [java.io.Serializable, java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r0v59, types: [java.io.Serializable, java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r0v65, types: [java.io.Serializable, java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r0v91, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.io.Serializable, java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Serializable, java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Serializable, java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Serializable, java.lang.String[]] */
        /* JADX WARN: Type inference failed for: r7v1, types: [int[], java.io.Serializable] */
        protected a(Bundle bundle) {
            hk0 hk0VarA;
            String strA = x52.a(6);
            x52 x52Var = x52.B;
            this.f10624a = bundle.getInt(strA, x52Var.b);
            this.b = bundle.getInt(x52.a(7), x52Var.c);
            this.c = bundle.getInt(x52.a(8), x52Var.d);
            this.d = bundle.getInt(x52.a(9), x52Var.e);
            this.e = bundle.getInt(x52.a(10), x52Var.f);
            this.f = bundle.getInt(x52.a(11), x52Var.g);
            this.g = bundle.getInt(x52.a(12), x52Var.h);
            this.h = bundle.getInt(x52.a(13), x52Var.i);
            this.i = bundle.getInt(x52.a(14), x52Var.j);
            this.j = bundle.getInt(x52.a(15), x52Var.k);
            this.k = bundle.getBoolean(x52.a(16), x52Var.l);
            this.l = hk0.b((String[]) t11.a(bundle.getStringArray(x52.a(17)), new String[0]));
            this.m = bundle.getInt(x52.a(25), x52Var.n);
            this.n = a((String[]) t11.a(bundle.getStringArray(x52.a(1)), new String[0]));
            this.o = bundle.getInt(x52.a(2), x52Var.p);
            this.p = bundle.getInt(x52.a(18), x52Var.q);
            this.q = bundle.getInt(x52.a(19), x52Var.r);
            this.r = hk0.b((String[]) t11.a(bundle.getStringArray(x52.a(20)), new String[0]));
            this.s = a((String[]) t11.a(bundle.getStringArray(x52.a(3)), new String[0]));
            this.t = bundle.getInt(x52.a(4), x52Var.u);
            this.u = bundle.getInt(x52.a(26), x52Var.v);
            this.v = bundle.getBoolean(x52.a(5), x52Var.w);
            this.w = bundle.getBoolean(x52.a(21), x52Var.x);
            this.x = bundle.getBoolean(x52.a(22), x52Var.y);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(x52.a(23));
            if (parcelableArrayList == null) {
                hk0VarA = hk0.h();
            } else {
                hk0VarA = km.a(w52.d, parcelableArrayList);
            }
            this.y = new HashMap<>();
            for (int i = 0; i < hk0VarA.size(); i++) {
                w52 w52Var = (w52) hk0VarA.get(i);
                this.y.put(w52Var.b, w52Var);
            }
            int[] iArr = (int[]) t11.a(bundle.getIntArray(x52.a(24)), new int[0]);
            this.z = new HashSet<>();
            for (int i2 : iArr) {
                this.z.add(Integer.valueOf(i2));
            }
        }

        private static hk0<String> a(String[] strArr) {
            int i = hk0.d;
            hk0.a aVar = new hk0.a();
            for (String str : strArr) {
                str.getClass();
                aVar.b(x82.e(str));
            }
            return aVar.a();
        }

        public a a(int i, int i2) {
            this.i = i;
            this.j = i2;
            this.k = true;
            return this;
        }

        public void a(Context context) {
            CaptioningManager captioningManager;
            int i = x82.f10629a;
            if (i >= 19) {
                if ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                    this.t = 1088;
                    Locale locale = captioningManager.getLocale();
                    if (locale != null) {
                        this.s = hk0.a(x82.a(locale));
                    }
                }
            }
        }
    }

    static {
        new jm.a() { // from class: com.yandex.mobile.ads.impl.x52$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.jm.a
            public final jm fromBundle(Bundle bundle) {
                return x52.a(bundle);
            }
        };
    }

    protected x52(a aVar) {
        this.b = aVar.f10624a;
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
        this.r = aVar.q;
        this.s = aVar.r;
        this.t = aVar.s;
        this.u = aVar.t;
        this.v = aVar.u;
        this.w = aVar.v;
        this.x = aVar.w;
        this.y = aVar.x;
        this.z = ik0.a(aVar.y);
        this.A = jk0.a(aVar.z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        x52 x52Var = (x52) obj;
        return this.b == x52Var.b && this.c == x52Var.c && this.d == x52Var.d && this.e == x52Var.e && this.f == x52Var.f && this.g == x52Var.g && this.h == x52Var.h && this.i == x52Var.i && this.l == x52Var.l && this.j == x52Var.j && this.k == x52Var.k && this.m.equals(x52Var.m) && this.n == x52Var.n && this.o.equals(x52Var.o) && this.p == x52Var.p && this.q == x52Var.q && this.r == x52Var.r && this.s.equals(x52Var.s) && this.t.equals(x52Var.t) && this.u == x52Var.u && this.v == x52Var.v && this.w == x52Var.w && this.x == x52Var.x && this.y == x52Var.y && this.z.equals(x52Var.z) && this.A.equals(x52Var.A);
    }

    public int hashCode() {
        return this.A.hashCode() + ((this.z.hashCode() + ((((((((((((this.t.hashCode() + ((this.s.hashCode() + ((((((((this.o.hashCode() + ((((this.m.hashCode() + ((((((((((((((((((((((this.b + 31) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + (this.l ? 1 : 0)) * 31) + this.j) * 31) + this.k) * 31)) * 31) + this.n) * 31)) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31)) * 31)) * 31) + this.u) * 31) + this.v) * 31) + (this.w ? 1 : 0)) * 31) + (this.x ? 1 : 0)) * 31) + (this.y ? 1 : 0)) * 31)) * 31);
    }

    protected static String a(int i) {
        return Integer.toString(i, 36);
    }

    public static x52 a(Bundle bundle) {
        return new x52(new a(bundle));
    }
}
