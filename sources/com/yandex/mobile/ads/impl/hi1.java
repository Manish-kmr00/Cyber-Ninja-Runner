package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r9 f9099a;
    private final z5 b;
    private final eb c;

    public hi1(r9 adStateHolder, z5 adPlayerEventsController, eb adsLoaderPlaybackErrorConverter) {
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        Intrinsics.checkNotNullParameter(adsLoaderPlaybackErrorConverter, "adsLoaderPlaybackErrorConverter");
        this.f9099a = adStateHolder;
        this.b = adPlayerEventsController;
        this.c = adsLoaderPlaybackErrorConverter;
    }

    public final void a(Exception exc) {
        pc2 pc2Var;
        yi1 yi1VarC = this.f9099a.c();
        do0 do0VarD = yi1VarC != null ? yi1VarC.d() : null;
        tm0 tm0VarA = do0VarD != null ? this.f9099a.a(do0VarD) : null;
        if (tm0VarA == null || tm0.b == tm0VarA) {
            return;
        }
        if (exc != null) {
            this.c.getClass();
            pc2Var = eb.c(exc);
        } else {
            pc2Var = new pc2(pc2.a.D, new s00());
        }
        this.b.a(do0VarD, pc2Var);
    }
}
