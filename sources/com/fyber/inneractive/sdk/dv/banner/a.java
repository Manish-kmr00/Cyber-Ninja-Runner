package com.fyber.inneractive.sdk.dv.banner;

import com.fyber.inneractive.sdk.config.M;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.dv.handler.e;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.A;
import com.fyber.inneractive.sdk.flow.x;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends AdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1733a;

    public a(b bVar) {
        this.f1733a = bVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        InneractiveAdRequest inneractiveAdRequest = this.f1733a.f1840a;
        String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
        com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
        b bVar = this.f1733a;
        e.a(spotId, aVar, bVar.f1840a, (i) bVar.b, loadAdError.getMessage());
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdImpression() {
        b bVar = this.f1733a;
        c cVar = bVar.h;
        if (cVar != null) {
            cVar.u();
        } else {
            bVar.j = true;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        b bVar = this.f1733a;
        com.fyber.inneractive.sdk.dv.c cVar = bVar.g;
        if (cVar != null) {
            bVar.k = true;
            cVar.f();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        i iVar;
        M m;
        c cVar = this.f1733a.h;
        if (cVar != null) {
            cVar.a(cVar.w(), Float.NaN, Float.NaN);
            x xVar = cVar.b;
            if (xVar == null || (iVar = (i) ((b) xVar).b) == null) {
                return;
            }
            A.a(iVar);
            U u = ((b) cVar.b).d;
            if (u == null || (m = ((T) u).c) == null) {
                return;
            }
            A.a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, m.b == UnitDisplayType.MRECT ? com.fyber.inneractive.sdk.cache.session.enums.c.RECTANGLE_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.c.BANNER_DISPLAY);
        }
    }
}
