package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h5 implements yg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xg1 f9062a;

    public /* synthetic */ h5(g5 g5Var) {
        this(g5Var, new xg1(g5Var));
    }

    @Override // com.yandex.mobile.ads.impl.yg1
    public final LinkedHashMap a() {
        return this.f9062a.a(SetsKt.setOf((Object[]) new f5[]{f5.c, f5.d, f5.e, f5.g, f5.h, f5.i, f5.j, f5.k, f5.m, f5.l, f5.n, f5.o, f5.p, f5.q, f5.r, f5.s, f5.t, f5.u, f5.v, f5.y, f5.B}));
    }

    public h5(g5 adLoadingPhasesManager, xg1 phasesParametersExtractor) {
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(phasesParametersExtractor, "phasesParametersExtractor");
        this.f9062a = phasesParametersExtractor;
    }
}
