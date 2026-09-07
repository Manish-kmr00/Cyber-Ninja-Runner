package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.AbstractC3106k;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadError;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements com.fyber.inneractive.sdk.interfaces.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f2431a;

    public b(c cVar) {
        this.f2431a = cVar;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.a
    public final void a(InneractiveAdRequest inneractiveAdRequest) {
        c cVar = this.f2431a;
        cVar.e.adSpot = new k(cVar.c, ((AbstractC3106k) cVar.b).c);
        e eVar = this.f2431a.e;
        eVar.internalOnAdLoaded(eVar, eVar.adSpot);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.a
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        this.f2431a.d.onAdLoadFailed(MarketplaceAdLoadError.FAILED_TO_LOAD_AD);
    }
}
