package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class qn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hj0 f10038a;
    private final g5 b;
    private final ah c;
    private final zj0 d;
    private final su e;
    private final bk0 f;

    public interface a {
        void h(rb2<do0> rb2Var);
    }

    public qn0(hj0 imageLoadManager, g5 adLoadingPhasesManager) {
        Intrinsics.checkNotNullParameter(imageLoadManager, "imageLoadManager");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        this.f10038a = imageLoadManager;
        this.b = adLoadingPhasesManager;
        this.c = new ah();
        this.d = new zj0();
        this.e = new su();
        this.f = new bk0();
    }

    public final void a(rb2 videoAdInfo, pj0 imageProvider, bo0 loadListener) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(loadListener, "loadListener");
        su suVar = this.e;
        ru ruVarB = videoAdInfo.b();
        suVar.getClass();
        List<? extends ig<?>> listA = su.a(ruVarB);
        Set<uj0> setA = this.f.a(listA, null);
        g5 g5Var = this.b;
        f5 f5Var = f5.q;
        ak.a(g5Var, f5Var, "adLoadingPhaseType", f5Var, null);
        this.f10038a.a(setA, new rn0(this, listA, imageProvider, loadListener, videoAdInfo));
    }
}
