package com.json;

import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes9.dex */
public class u6 {
    private static final int p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h4 f4484a;
    private int b;
    private long c;
    private boolean d;
    private ArrayList<h7> e;
    private h7 f;
    private int g;
    private int h;
    private o5 i;
    private boolean j;
    private long k;
    private boolean l;
    private boolean m;
    private boolean n;
    private long o;

    public u6() {
        this.f4484a = new h4();
        this.e = new ArrayList<>();
    }

    public u6(int i, long j, boolean z, h4 h4Var, int i2, o5 o5Var, int i3, boolean z2, long j2, boolean z3, boolean z4, boolean z5, long j3) {
        this.e = new ArrayList<>();
        this.b = i;
        this.c = j;
        this.d = z;
        this.f4484a = h4Var;
        this.g = i2;
        this.h = i3;
        this.i = o5Var;
        this.j = z2;
        this.k = j2;
        this.l = z3;
        this.m = z4;
        this.n = z5;
        this.o = j3;
    }

    public int a() {
        return this.b;
    }

    public h7 a(String str) {
        for (h7 h7Var : this.e) {
            if (h7Var.getPlacementName().equals(str)) {
                return h7Var;
            }
        }
        return null;
    }

    public void a(h7 h7Var) {
        if (h7Var != null) {
            this.e.add(h7Var);
            if (this.f == null || h7Var.isPlacementId(0)) {
                this.f = h7Var;
            }
        }
    }

    public long b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public o5 d() {
        return this.i;
    }

    public long e() {
        return this.k;
    }

    public int f() {
        return this.h;
    }

    public h4 g() {
        return this.f4484a;
    }

    public int h() {
        return this.g;
    }

    public h7 i() {
        for (h7 h7Var : this.e) {
            if (h7Var.getIsDefault()) {
                return h7Var;
            }
        }
        h7 h7Var2 = this.f;
        return h7Var2 != null ? h7Var2 : new lb();
    }

    public long j() {
        return this.o;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.n;
    }

    public boolean n() {
        return this.m;
    }

    public String toString() {
        return "BannerConfigurations{parallelLoad=" + this.b + ", bidderExclusive=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}
