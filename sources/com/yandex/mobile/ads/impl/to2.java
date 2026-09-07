package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class to2 implements ho2, xn2.a {
    private static to2 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f10324a = 0.0f;
    private final qo2 b;
    private final wn2 c;
    private lo2 d;
    private nn2 e;

    public to2(qo2 qo2Var, wn2 wn2Var) {
        this.b = qo2Var;
        this.c = wn2Var;
    }

    public static to2 a() {
        if (f == null) {
            f = new to2(new qo2(), new wn2());
        }
        return f;
    }

    public final void b() {
        xn2.a().a(this);
        xn2.a().b();
        z62.g().getClass();
        z62.a();
        this.d.a();
    }

    public final void c() {
        z62.g().b();
        xn2.a().c();
        this.d.b();
    }

    public final float d() {
        return this.f10324a;
    }

    public final void a(float f2) {
        this.f10324a = f2;
        if (this.e == null) {
            this.e = nn2.a();
        }
        Iterator<mn2> it = this.e.c().iterator();
        while (it.hasNext()) {
            it.next().j().a(f2);
        }
    }

    public final void a(Context context) {
        this.c.getClass();
        un2 un2Var = new un2();
        qo2 qo2Var = this.b;
        Handler handler = new Handler();
        qo2Var.getClass();
        this.d = new lo2(handler, context, un2Var, this);
    }
}
