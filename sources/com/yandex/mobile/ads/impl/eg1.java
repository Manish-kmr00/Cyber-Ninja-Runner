package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes10.dex */
public final class eg1 {
    static final /* synthetic */ KProperty<Object>[] c = {ta.a(eg1.class, "loadController", "getLoadController()Lcom/monetization/ads/base/BaseAdLoadController;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fg1 f8796a;
    private final zn1 b;

    public /* synthetic */ eg1(bk bkVar, dz0 dz0Var, g5 g5Var) {
        this(bkVar, dz0Var, g5Var, new wa());
    }

    public final void a() {
        bk bkVar = (bk) this.b.getValue(this, c[0]);
        if (bkVar == null || bkVar.h()) {
            return;
        }
        bkVar.a(this.f8796a);
    }

    public eg1(bk<?> loadController, dz0 mediationData, g5 adLoadingPhasesManager, wa adapterLoadingDurationProvider) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(mediationData, "mediationData");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(adapterLoadingDurationProvider, "adapterLoadingDurationProvider");
        this.b = ao1.a(loadController);
        List<e5> listB = adLoadingPhasesManager.b();
        adapterLoadingDurationProvider.getClass();
        this.f8796a = new fg1(new gg1(wa.a(listB), mediationData));
    }
}
