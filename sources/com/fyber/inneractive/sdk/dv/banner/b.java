package com.fyber.inneractive.sdk.dv.banner;

import com.fyber.inneractive.sdk.config.M;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends com.fyber.inneractive.sdk.dv.a {
    public boolean j;
    public boolean k;
    public final a l;

    public b(U u, r rVar, i iVar) {
        super(u, rVar, iVar);
        this.j = false;
        this.k = false;
        this.l = new a(this);
    }

    @Override // com.fyber.inneractive.sdk.dv.a
    public final void a(AdRequest adRequest, com.fyber.inneractive.sdk.dv.c cVar) {
        M m;
        this.g = cVar;
        AdView adView = new AdView(AbstractC3251o.f2370a);
        this.i = adView;
        AdSize adSize = AdSize.BANNER;
        U u = this.d;
        if (u != null && (m = ((T) u).c) != null && m.b == UnitDisplayType.MRECT) {
            adSize = AdSize.MEDIUM_RECTANGLE;
        }
        adView.setAdSize(adSize);
        ((AdView) this.i).setAdUnitId("FyberBanner");
        ((AdView) this.i).setAdListener(this.l);
        ((AdView) this.i).loadAd(adRequest);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean d() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean f() {
        return this.k;
    }
}
