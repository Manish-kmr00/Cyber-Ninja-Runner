package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class s7 implements yg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xg1 f10180a;

    public /* synthetic */ s7(g5 g5Var) {
        this(g5Var, new xg1(g5Var));
    }

    @Override // com.yandex.mobile.ads.impl.yg1
    public final LinkedHashMap a() {
        return this.f10180a.a(SetsKt.setOf(f5.f));
    }

    public s7(g5 adLoadingPhasesManager, xg1 phasesParametersExtractor) {
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(phasesParametersExtractor, "phasesParametersExtractor");
        this.f10180a = phasesParametersExtractor;
    }
}
