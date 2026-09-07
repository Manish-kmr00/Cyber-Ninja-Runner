package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class dp1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jg2 f8720a;
    private final fp1 b;
    private final bp1 c;

    public dp1(jg2 videoViewAdapter, fp1 replayController, bp1 replayViewConfigurator) {
        Intrinsics.checkNotNullParameter(videoViewAdapter, "videoViewAdapter");
        Intrinsics.checkNotNullParameter(replayController, "replayController");
        Intrinsics.checkNotNullParameter(replayViewConfigurator, "replayViewConfigurator");
        this.f8720a = videoViewAdapter;
        this.b = replayController;
        this.c = replayViewConfigurator;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        ub1 ub1VarB = this.f8720a.b();
        if (ub1VarB != null) {
            ap1 ap1VarB = ub1VarB.a().b();
            this.c.getClass();
            bp1.b(ap1VarB);
            this.b.a(ub1VarB);
        }
    }
}
