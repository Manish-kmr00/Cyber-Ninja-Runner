package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.hc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4165hc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fg f11584a;
    public final InterfaceC4560x9 b;
    public final F4 c;
    public final Le d;
    public final C4033c5 e;
    public final Bc f = new Bc();
    public final Lazy g = LazyKt.lazy(new C4140gc(this));

    public C4165hc(S6 s6, Fg fg, InterfaceC4560x9 interfaceC4560x9, F4 f4, Le le) {
        this.f11584a = fg;
        this.b = interfaceC4560x9;
        this.c = f4;
        this.d = le;
        this.e = new C4033c5(s6, fg);
    }

    public final List<J8> a() {
        return this.e.a();
    }

    public final List<J8> b() {
        return CollectionsKt.listOf((J8) this.g.getValue());
    }
}
