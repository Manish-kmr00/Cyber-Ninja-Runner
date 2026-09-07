package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class gi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q9 f9007a;
    private final y5 b;
    private final db c;

    public gi1(q9 adStateHolder, y5 adPlayerEventsController, db adsLoaderPlaybackErrorConverter) {
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        Intrinsics.checkNotNullParameter(adsLoaderPlaybackErrorConverter, "adsLoaderPlaybackErrorConverter");
        this.f9007a = adStateHolder;
        this.b = adPlayerEventsController;
        this.c = adsLoaderPlaybackErrorConverter;
    }

    public final void a(Exception exc) {
        pc2 pc2Var;
        xi1 xi1VarC = this.f9007a.c();
        do0 do0VarD = xi1VarC != null ? xi1VarC.d() : null;
        sm0 sm0VarA = do0VarD != null ? this.f9007a.a(do0VarD) : null;
        if (sm0VarA == null || sm0.b == sm0VarA) {
            return;
        }
        if (exc != null) {
            this.c.getClass();
            pc2Var = db.c(exc);
        } else {
            pc2Var = new pc2(pc2.a.D, new s00());
        }
        this.b.a(do0VarD, pc2Var);
    }
}
