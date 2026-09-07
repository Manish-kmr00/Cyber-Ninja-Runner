package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessorsHolder;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueReporter;

/* JADX INFO: loaded from: classes3.dex */
public final class V5 implements U5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ModuleAdRevenueReporter f11389a;
    public final C4506v5 b;

    public V5(ModuleAdRevenueReporter moduleAdRevenueReporter, C4506v5 c4506v5) {
        this.f11389a = moduleAdRevenueReporter;
        this.b = c4506v5;
    }

    @Override // io.appmetrica.analytics.impl.U5, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final C4506v5 getAdRevenueProcessorsHolder() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.U5, io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueReporter getAdRevenueReporter() {
        return this.f11389a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext
    public final ModuleAdRevenueProcessorsHolder getAdRevenueProcessorsHolder() {
        return this.b;
    }
}
