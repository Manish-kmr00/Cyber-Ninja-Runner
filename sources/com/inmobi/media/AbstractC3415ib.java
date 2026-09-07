package com.inmobi.media;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.inmobi.media.ib, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractC3415ib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3341a;
    public static final Lazy b;
    public static final Lazy c;
    public static final Lazy d;
    public static final Lazy e;
    public static final Lazy f;
    public static final Lazy g;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        f3341a = LazyKt.lazy(lazyThreadSafetyMode, (Function0) C3317bb.f3277a);
        b = LazyKt.lazy(lazyThreadSafetyMode, (Function0) C3331cb.f3285a);
        c = LazyKt.lazy(lazyThreadSafetyMode, (Function0) C3345db.f3296a);
        d = LazyKt.lazy(lazyThreadSafetyMode, (Function0) C3359eb.f3304a);
        e = LazyKt.lazy(lazyThreadSafetyMode, (Function0) C3373fb.f3317a);
        f = LazyKt.lazy(lazyThreadSafetyMode, (Function0) C3401hb.f3335a);
        g = LazyKt.lazy(lazyThreadSafetyMode, (Function0) C3387gb.f3327a);
    }

    public static W0 a() {
        return (W0) b.getValue();
    }

    public static U1 b() {
        return (U1) c.getValue();
    }

    public static C3311b5 c() {
        return (C3311b5) e.getValue();
    }

    public static C3382g6 d() {
        return (C3382g6) g.getValue();
    }

    public static Ub e() {
        return (Ub) f.getValue();
    }
}
