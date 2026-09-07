package com.yandex.mobile.ads.impl;

import java.util.LinkedHashMap;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class cd2 implements yg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xg1 f8591a;

    public /* synthetic */ cd2(g5 g5Var) {
        this(g5Var, new xg1(g5Var));
    }

    @Override // com.yandex.mobile.ads.impl.yg1
    public final LinkedHashMap a() {
        return this.f8591a.a(SetsKt.setOf((Object[]) new f5[]{f5.w, f5.x}));
    }

    public cd2(g5 adLoadingPhasesManager, xg1 phasesParametersExtractor) {
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(phasesParametersExtractor, "phasesParametersExtractor");
        this.f8591a = phasesParametersExtractor;
    }
}
