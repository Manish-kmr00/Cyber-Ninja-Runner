package com.json;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public class za {
    private static za h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4646a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;
    private final nf g;

    private za(Context context) {
        nf nfVarF = mm.S().f();
        this.g = nfVarF;
        this.f4646a = nfVarF.g();
        this.b = nfVarF.e();
        this.c = nfVarF.m();
        this.d = nfVarF.p();
        this.e = nfVarF.l();
        this.f = nfVarF.j(context);
    }

    public static za b(Context context) {
        if (h == null) {
            h = new za(context);
        }
        return h;
    }

    public static void g() {
        h = null;
    }

    public float a(Context context) {
        return this.g.m(context);
    }

    public int a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.f4646a;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }
}
