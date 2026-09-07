package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.nd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4315nd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4377q0 f11684a;
    public final C4141gd b;
    public final C4464td c;
    public final IHandlerExecutor d;

    public C4315nd() {
        C4377q0 c4377q0C = C4455t4.i().c();
        this.f11684a = c4377q0C;
        this.b = new C4141gd(c4377q0C);
        this.c = new C4464td();
        this.d = C4455t4.i().e().a();
    }

    public static final Pa a(C4315nd c4315nd) {
        c4315nd.f11684a.getClass();
        C4352p0 c4352p0 = C4352p0.e;
        Intrinsics.checkNotNull(c4352p0);
        C4364pc c4364pcI = c4352p0.f().i();
        Intrinsics.checkNotNull(c4364pcI);
        return c4364pcI.f11720a;
    }
}
