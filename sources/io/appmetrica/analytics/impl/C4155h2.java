package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.h2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4155h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4289mc f11577a;
    public final ICommonExecutor b;
    public final long c;
    public boolean d = true;
    public final Runnable e = new Runnable() { // from class: io.appmetrica.analytics.impl.h2$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            C4155h2.a(this.f$0);
        }
    };

    public C4155h2(C4289mc c4289mc, IHandlerExecutor iHandlerExecutor, long j) {
        this.f11577a = c4289mc;
        this.b = iHandlerExecutor;
        this.c = j;
    }

    public static final void a(C4155h2 c4155h2) {
        C4314nc c4314nc = c4155h2.f11577a.f11670a;
        C4320ni c4320ni = c4314nc.h;
        c4320ni.c.a(c4314nc.b.f11474a);
    }
}
