package io.appmetrica.analytics.impl;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes.dex */
public final class R8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11326a;
    public String b;
    public final Long c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final C4384q7 g;
    public final EnumC4164hb h;
    public final Integer i;
    public final String j;
    public final Integer k;
    public final Integer l;
    public final String m;
    public final String n;
    public final M8 o;
    public final EnumC4237ka p;
    public final EnumC4435s9 q;
    public final Boolean r;
    public final Integer s;
    public final byte[] t;

    public R8(ContentValues contentValues) {
        C4284m7 model = new C4309n7(null, 1, 0 == true ? 1 : 0).toModel(contentValues);
        this.f11326a = model.a().j();
        this.b = model.a().p();
        this.c = model.c();
        this.d = model.b();
        this.e = model.a().k();
        this.f = model.d();
        this.g = model.a().i();
        this.h = model.e();
        this.i = model.a().d();
        this.j = model.a().f();
        this.k = model.a().o();
        this.l = model.a().c();
        this.m = model.a().b();
        this.n = model.a().m();
        M8 m8E = model.a().e();
        this.o = m8E == null ? M8.a(null) : m8E;
        EnumC4237ka enumC4237kaH = model.a().h();
        this.p = enumC4237kaH == null ? EnumC4237ka.a(null) : enumC4237kaH;
        this.q = model.a().n();
        this.r = model.a().a();
        this.s = model.a().l();
        this.t = model.a().g();
    }
}
