package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.flow.x;
import com.google.android.gms.ads.AdRequest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends x {
    public c g;
    public com.fyber.inneractive.sdk.dv.banner.c h;
    public Object i;

    public a(U u, r rVar, i iVar) {
        super(u, rVar);
        this.b = iVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void a() {
        this.g = null;
        this.i = null;
    }

    public abstract void a(AdRequest adRequest, c cVar);

    @Override // com.fyber.inneractive.sdk.flow.x
    public final com.fyber.inneractive.sdk.response.e c() {
        return (i) this.b;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public boolean isVideoAd() {
        return false;
    }
}
