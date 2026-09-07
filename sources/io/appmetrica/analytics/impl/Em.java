package io.appmetrica.analytics.impl;

/* JADX INFO: loaded from: classes4.dex */
public final class Em implements InterfaceC4200in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC4200in f11128a;
    public final Object b;

    public Em(InterfaceC4200in interfaceC4200in, Object obj) {
        this.f11128a = interfaceC4200in;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4200in
    public final Object a(Object obj) {
        return obj != this.f11128a.a(obj) ? this.b : obj;
    }
}
