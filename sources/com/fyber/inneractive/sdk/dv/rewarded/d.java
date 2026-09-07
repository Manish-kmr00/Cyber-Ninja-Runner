package com.fyber.inneractive.sdk.dv.rewarded;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardedAd;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.fyber.inneractive.sdk.a {
    public final a k;
    public final b l;
    public final c m;

    public d(U u, r rVar, i iVar) {
        super(u, rVar, iVar);
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this);
    }

    @Override // com.fyber.inneractive.sdk.dv.a
    public final void a(AdRequest adRequest, com.fyber.inneractive.sdk.dv.c cVar) {
        this.g = cVar;
        RewardedAd.load(AbstractC3251o.f2370a, "FyberRewarded", adRequest, this.k);
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
    public final void a(com.fyber.inneractive.sdk.dv.interstitial.a aVar, Activity activity) {
        this.j = aVar;
        Object obj = this.i;
        if (obj != null) {
            ((RewardedAd) obj).setFullScreenContentCallback(this.l);
            ((RewardedAd) this.i).show(activity, this.m);
        }
    }
}
