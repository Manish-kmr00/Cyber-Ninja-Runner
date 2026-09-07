package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.mraid.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3121d implements com.fyber.inneractive.sdk.factories.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAMraidKit f1898a;

    public C3121d(IAMraidKit iAMraidKit) {
        this.f1898a = iAMraidKit;
    }

    @Override // com.fyber.inneractive.sdk.factories.a
    public final boolean a(InneractiveAdSpot inneractiveAdSpot) {
        return this.f1898a.isMRaidSpotContent(inneractiveAdSpot);
    }

    @Override // com.fyber.inneractive.sdk.factories.a
    public final com.fyber.inneractive.sdk.interfaces.d a() {
        return new com.fyber.inneractive.sdk.renderers.k();
    }
}
