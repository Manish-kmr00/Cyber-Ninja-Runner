package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f10703a;
    private vi b;

    public interface a {
        void a();
    }

    public abstract z52 a(so1[] so1VarArr, s52 s52Var, rw0.b bVar, b52 b52Var) throws j60;

    public void a(oh ohVar) {
    }

    public abstract void a(Object obj);

    public boolean c() {
        return this instanceof p00;
    }

    public void d() {
        this.f10703a = null;
        this.b = null;
    }

    protected final void b() {
        a aVar = this.f10703a;
        if (aVar != null) {
            aVar.a();
        }
    }

    protected final vi a() {
        vi viVar = this.b;
        if (viVar != null) {
            return viVar;
        }
        throw new IllegalStateException();
    }

    public final void a(a aVar, vi viVar) {
        this.f10703a = aVar;
        this.b = viVar;
    }
}
