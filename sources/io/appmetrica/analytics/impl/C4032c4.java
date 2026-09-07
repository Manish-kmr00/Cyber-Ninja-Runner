package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.modulesapi.internal.client.ClientStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueContext;
import io.appmetrica.analytics.modulesapi.internal.common.InternalClientModuleFacade;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.c4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class C4032c4 implements S5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11489a;
    public final V5 b = new V5(new C4551x0(), new C4506v5());
    public final C4480u4 c = new C4480u4(C4455t4.i().b(getContext()));
    public final C4139gb d = new C4139gb();

    public C4032c4(Context context) {
        this.f11489a = context;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final ClientStorageProvider getClientStorageProvider() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final Context getContext() {
        return this.f11489a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final InternalClientModuleFacade getInternalClientModuleFacade() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.impl.S5, io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final U5 getModuleAdRevenueContext() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ClientContext
    public final ModuleAdRevenueContext getModuleAdRevenueContext() {
        return this.b;
    }
}
