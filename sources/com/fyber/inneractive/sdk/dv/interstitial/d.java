package com.fyber.inneractive.sdk.dv.interstitial;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends com.fyber.inneractive.sdk.a {
    public final b k;
    public final c l;

    public d(U u, r rVar, i iVar) {
        super(u, rVar, iVar);
        this.k = new b(this);
        this.l = new c(this);
    }

    @Override // com.fyber.inneractive.sdk.dv.a
    public final void a(AdRequest adRequest, com.fyber.inneractive.sdk.dv.c cVar) {
        this.g = cVar;
        InterstitialAd.load(AbstractC3251o.f2370a, "FyberInterstitial", adRequest, this.k);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean d() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean f() {
        return this.i != null;
    }

    @Override // com.fyber.inneractive.sdk.a
    public final void a(a aVar, Activity activity) {
        this.j = aVar;
        Object obj = this.i;
        if (obj != null) {
            ((InterstitialAd) obj).setFullScreenContentCallback(this.l);
            ((InterstitialAd) this.i).show(activity);
        }
    }
}
