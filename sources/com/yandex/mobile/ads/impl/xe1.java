package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class xe1 implements yg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xg1 f10648a;

    public /* synthetic */ xe1(g5 g5Var) {
        this(g5Var, new xg1(g5Var));
    }

    @Override // com.yandex.mobile.ads.impl.yg1
    public final LinkedHashMap a() {
        return this.f10648a.a(SetsKt.setOf((Object[]) new f5[]{f5.j, f5.k, f5.m, f5.l, f5.n, f5.o, f5.z, f5.A, f5.B}));
    }

    public xe1(g5 adLoadingPhasesManager, xg1 phasesParametersExtractor) {
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(phasesParametersExtractor, "phasesParametersExtractor");
        this.f10648a = phasesParametersExtractor;
    }
}
