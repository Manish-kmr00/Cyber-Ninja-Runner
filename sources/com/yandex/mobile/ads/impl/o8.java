package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class o8<T> {
    private final Long A;
    private final T B;
    private final Map<String, Object> C;
    private final String D;
    private final String E;
    private final boolean F;
    private final boolean G;
    private final boolean H;
    private final boolean I;
    private final int J;
    private final boolean K;
    private final j80 L;
    private final ha0 M;
    private final boolean N;
    private final boolean O;
    private final boolean P;
    private final boolean Q;
    private final int R;
    private final int S;
    private final boolean T;
    private final boolean U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qs f9789a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final int g;
    private final zy1 h;
    private final List<String> i;
    private final List<String> j;
    private final f k;
    private final List<String> l;
    private final Long m;
    private final String n;
    private final List<String> o;
    private final t4 p;
    private final List<Long> q;
    private final List<Integer> r;
    private final String s;
    private final String t;
    private final String u;
    private final fs v;
    private final String w;
    private final String x;
    private final dz0 y;
    private final nr1 z;

    public static final class a<T> {
        private String A;
        private String B;
        private String C;
        private Map<String, ? extends Object> D;
        private int E;
        private int F;
        private int G;
        private int H;
        private int I;
        private int J;
        private boolean K;
        private boolean L;
        private boolean M;
        private boolean N;
        private boolean O;
        private ha0 P;
        private boolean R;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private qs f9790a;
        private String b;
        private String c;
        private String d;
        private String e;
        private fs f;
        private zy1.a g;
        private List<String> h;
        private List<String> i;
        private f j;
        private List<String> k;
        private Long l;
        private String m;
        private List<String> n;
        private j80 o;
        private t4 p;
        private List<Long> q;
        private List<Integer> r;
        private String s;
        private dz0 t;
        private nr1 u;
        private Long v;
        private T w;
        private String x;
        private String y;
        private String z;
        private boolean Q = true;
        private boolean S = true;
        private boolean T = true;
        private boolean U = true;

        public final void a(Locale locale) {
        }

        public final void a(f fVar) {
            this.j = fVar;
        }

        public final void b(int i) {
            this.F = i;
        }

        public final void c(int i) {
            this.H = i;
        }

        public final void d(int i) {
            this.I = i;
        }

        public final void e(String str) {
            this.b = str;
        }

        public final void f(String str) {
            this.e = str;
        }

        public final void g(String str) {
            this.m = str;
        }

        public final void h(String str) {
            this.A = str;
        }

        public final void i(String str) {
            this.C = str;
        }

        public final void j(String str) {
            this.B = str;
        }

        public final void k(String str) {
            this.d = str;
        }

        public final void l(String str) {
            this.z = str;
        }

        public final void f(ArrayList experiments) {
            Intrinsics.checkNotNullParameter(experiments, "experiments");
            this.i = experiments;
        }

        public final void a(int i) {
            this.J = i;
        }

        public final void b(String str) {
            this.c = str;
        }

        public final void c(String str) {
            this.s = str;
        }

        public final void d(String str) {
            this.x = str;
        }

        public final void e(int i) {
            this.E = i;
        }

        public final void g(boolean z) {
            this.R = z;
        }

        public final void h(boolean z) {
            this.Q = z;
        }

        public final void i(boolean z) {
            this.K = z;
        }

        public final void j(boolean z) {
            this.M = z;
        }

        public final void b(ArrayList adRenderTrackingUrls) {
            Intrinsics.checkNotNullParameter(adRenderTrackingUrls, "adRenderTrackingUrls");
            this.n = adRenderTrackingUrls;
        }

        public final void c(ArrayList adShowNotice) {
            Intrinsics.checkNotNullParameter(adShowNotice, "adShowNotice");
            this.h = adShowNotice;
        }

        public final void d(ArrayList adVisibilityPercents) {
            Intrinsics.checkNotNullParameter(adVisibilityPercents, "adVisibilityPercents");
            this.r = adVisibilityPercents;
        }

        public final void e(ArrayList clickTrackingUrls) {
            Intrinsics.checkNotNullParameter(clickTrackingUrls, "clickTrackingUrls");
            this.k = clickTrackingUrls;
        }

        public final void a(String str) {
            this.y = str;
        }

        public final void f(boolean z) {
            this.N = z;
        }

        public final void a(ArrayList adNoticeDelays) {
            Intrinsics.checkNotNullParameter(adNoticeDelays, "adNoticeDelays");
            this.q = adNoticeDelays;
        }

        public final void b(boolean z) {
            this.U = z;
        }

        public final void c(boolean z) {
            this.O = z;
        }

        public final void d(boolean z) {
            this.T = z;
        }

        public final void e(boolean z) {
            this.L = z;
        }

        public final void f(int i) {
            this.G = i;
        }

        public final void a(qs adType) {
            Intrinsics.checkNotNullParameter(adType, "adType");
            this.f9790a = adType;
        }

        public final void b(Long l) {
            this.v = l;
        }

        public final void a(HashMap analyticsParameters) {
            Intrinsics.checkNotNullParameter(analyticsParameters, "analyticsParameters");
            this.D = analyticsParameters;
        }

        public final void a(boolean z) {
            this.S = z;
        }

        public final void a(Long l) {
            this.l = l;
        }

        public final void a(fs fsVar) {
            this.f = fsVar;
        }

        public final void a(j80 j80Var) {
            this.o = j80Var;
        }

        public final void a(ha0 ha0Var) {
            this.P = ha0Var;
        }

        public final void a(t4 t4Var) {
            this.p = t4Var;
        }

        public final void a(dz0 dz0Var) {
            this.t = dz0Var;
        }

        public final a<T> a(T t) {
            this.w = t;
            return this;
        }

        public final void a(nr1 nr1Var) {
            this.u = nr1Var;
        }

        public final void a(zy1.a aVar) {
            this.g = aVar;
        }

        public final o8<T> a() {
            qs qsVar = this.f9790a;
            String str = this.b;
            String str2 = this.c;
            String str3 = this.d;
            String str4 = this.e;
            int i = this.E;
            int i2 = this.F;
            zy1.a aVar = this.g;
            if (aVar == null) {
                aVar = zy1.a.c;
            }
            return new o8<>(qsVar, str, str2, str3, str4, i, i2, new ob0(i, i2, aVar), this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.x, this.s, this.y, this.f, this.z, this.A, this.t, this.u, this.v, this.w, this.D, this.B, this.C, this.K, this.L, this.M, this.N, this.G, this.H, this.I, this.J, this.O, this.o, this.P, this.Q, this.R, this.S, this.T, this.U);
        }
    }

    public /* synthetic */ o8(qs qsVar, String str, String str2, String str3, String str4, int i, int i2, ob0 ob0Var, List list, List list2, f fVar, List list3, Long l, String str5, List list4, t4 t4Var, List list5, List list6, String str6, String str7, String str8, fs fsVar, String str9, String str10, dz0 dz0Var, nr1 nr1Var, Long l2, Object obj, Map map, String str11, String str12, boolean z, boolean z2, boolean z3, boolean z4, int i3, int i4, int i5, int i6, boolean z5, j80 j80Var, ha0 ha0Var, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this(qsVar, str, str2, str3, str4, i, i2, ob0Var, list, list2, fVar, list3, l, str5, list4, t4Var, list5, list6, str6, str7, str8, fsVar, str9, str10, dz0Var, nr1Var, l2, obj, map, str11, str12, z, z2, z3, z4, i4, i5, i6, z5, j80Var, ha0Var, z6, z7, z8, z9, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private o8(qs qsVar, String str, String str2, String str3, String str4, int i, int i2, ob0 ob0Var, List list, List list2, f fVar, List list3, Long l, String str5, List list4, t4 t4Var, List list5, List list6, String str6, String str7, String str8, fs fsVar, String str9, String str10, dz0 dz0Var, nr1 nr1Var, Long l2, Object obj, Map map, String str11, String str12, boolean z, boolean z2, boolean z3, boolean z4, int i3, int i4, int i5, boolean z5, j80 j80Var, ha0 ha0Var, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f9789a = qsVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i;
        this.g = i2;
        this.h = ob0Var;
        this.i = list;
        this.j = list2;
        this.k = fVar;
        this.l = list3;
        this.m = l;
        this.n = str5;
        this.o = list4;
        this.p = t4Var;
        this.q = list5;
        this.r = list6;
        this.s = str6;
        this.t = str7;
        this.u = str8;
        this.v = fsVar;
        this.w = str9;
        this.x = str10;
        this.y = dz0Var;
        this.z = nr1Var;
        this.A = l2;
        this.B = obj;
        this.C = map;
        this.D = str11;
        this.E = str12;
        this.F = z;
        this.G = z2;
        this.H = z3;
        this.I = z4;
        this.J = i3;
        this.K = z5;
        this.L = j80Var;
        this.M = ha0Var;
        this.N = z6;
        this.O = z7;
        this.P = z9;
        this.Q = z10;
        this.R = i3 * 1000;
        this.S = i4 * 1000;
        this.T = i2 == 0;
        this.U = i3 > 0;
    }

    public final qs n() {
        return this.f9789a;
    }

    public final String o() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public final String H() {
        return this.d;
    }

    public final String p() {
        return this.e;
    }

    public final int r() {
        return this.f;
    }

    public final int c() {
        return this.g;
    }

    public final zy1 M() {
        return this.h;
    }

    public final List<String> l() {
        return this.i;
    }

    public final List<String> b() {
        return this.j;
    }

    public final f a() {
        return this.k;
    }

    public final List<String> t() {
        return this.l;
    }

    public final Long u() {
        return this.m;
    }

    public final String w() {
        return this.n;
    }

    public final List<String> j() {
        return this.o;
    }

    public final t4 B() {
        return this.p;
    }

    public final List<Long> f() {
        return this.q;
    }

    public final List<Integer> q() {
        return this.r;
    }

    public final String m() {
        return this.s;
    }

    public final String k() {
        return this.t;
    }

    public final String d() {
        return this.u;
    }

    public final fs v() {
        return this.v;
    }

    public final String L() {
        return this.w;
    }

    public final String x() {
        return this.x;
    }

    public final dz0 D() {
        return this.y;
    }

    public final nr1 J() {
        return this.z;
    }

    public final Long K() {
        return this.A;
    }

    public final T I() {
        return this.B;
    }

    public final Map<String, Object> s() {
        return this.C;
    }

    public final String F() {
        return this.D;
    }

    public final String E() {
        return this.E;
    }

    public final boolean R() {
        return this.F;
    }

    public final boolean O() {
        return this.G;
    }

    public final boolean S() {
        return this.H;
    }

    public final boolean P() {
        return this.I;
    }

    public final int h() {
        return this.J;
    }

    public final boolean N() {
        return this.K;
    }

    public final j80 z() {
        return this.L;
    }

    public final ha0 A() {
        return this.M;
    }

    public final boolean Q() {
        return this.N;
    }

    public final boolean G() {
        return this.O;
    }

    public final boolean C() {
        return this.P;
    }

    public final boolean y() {
        return this.Q;
    }

    public final int g() {
        return this.R;
    }

    public final int i() {
        return this.S;
    }

    public final boolean U() {
        return this.T;
    }

    public final boolean T() {
        return this.U;
    }
}
