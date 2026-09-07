package io.appmetrica.analytics.location.impl;

import io.appmetrica.analytics.locationapi.internal.CacheArguments;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f11897a;
    public final /* synthetic */ k b;

    public j(k kVar, i iVar) {
        this.b = kVar;
        this.f11897a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.b.c;
        i iVar = this.f11897a;
        pVar.f11903a = iVar;
        CacheArguments cacheArguments = iVar.b;
        pVar.b.updateCacheControl(cacheArguments.getRefreshPeriod(), cacheArguments.getOutdatedTimeInterval());
    }
}
