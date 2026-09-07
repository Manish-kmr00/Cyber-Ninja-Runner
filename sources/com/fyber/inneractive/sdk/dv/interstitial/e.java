package com.fyber.inneractive.sdk.dv.interstitial;

import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.google.android.gms.ads.AdListener;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends AdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1741a;

    public e(g gVar) {
        this.f1741a = gVar;
    }

    public final void onAdFailedToLoad(int i) {
        com.fyber.inneractive.sdk.dv.c cVar = this.f1741a.g;
        if (cVar != null) {
            cVar.i();
            InneractiveAdRequest inneractiveAdRequest = this.f1741a.f1840a;
            String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
            com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
            g gVar = this.f1741a;
            com.fyber.inneractive.sdk.dv.handler.e.a(spotId, aVar, gVar.f1840a, (i) gVar.b, String.format("errorCode - %d", Integer.valueOf(i)));
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        g gVar = this.f1741a;
        if (gVar.g != null) {
            gVar.h();
            this.f1741a.g.f();
        }
    }
}
