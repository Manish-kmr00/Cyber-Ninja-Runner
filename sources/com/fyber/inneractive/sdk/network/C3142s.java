package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.AbstractC3110o;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3142s extends AbstractC3137m {
    public final InneractiveAdRequest e;
    public final Q f;

    public C3142s(InneractiveAdRequest inneractiveAdRequest, String str, com.fyber.inneractive.sdk.config.global.r rVar, AbstractC3110o abstractC3110o) {
        super(rVar, str, abstractC3110o);
        this.e = inneractiveAdRequest;
        Q q = new Q(new C3141q(this), inneractiveAdRequest, rVar);
        this.f = q;
        q.d = new r(this);
    }

    @Override // com.fyber.inneractive.sdk.network.AbstractC3137m
    public final void a() {
        this.b = true;
        this.f1926a = null;
        this.f.f1914a = true;
    }

    @Override // com.fyber.inneractive.sdk.network.AbstractC3137m
    public final String b() {
        return this.f.p();
    }
}
