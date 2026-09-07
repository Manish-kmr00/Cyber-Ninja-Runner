package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4078e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f11525a = new HashMap();

    public final synchronized C4053d0 a(C4108f5 c4108f5, PublicLogger publicLogger, Le le) {
        C4053d0 c4053d0;
        c4053d0 = (C4053d0) this.f11525a.get(c4108f5.toString());
        if (c4053d0 == null) {
            C4028c0 c4028c0D = le.d();
            c4053d0 = new C4053d0(c4028c0D.f11486a, c4028c0D.b, new Tk(publicLogger, "[App Environment]"));
            this.f11525a.put(c4108f5.toString(), c4053d0);
        }
        return c4053d0;
    }

    public final synchronized void a(C4028c0 c4028c0, Le le) {
        le.a(c4028c0).b();
    }
}
