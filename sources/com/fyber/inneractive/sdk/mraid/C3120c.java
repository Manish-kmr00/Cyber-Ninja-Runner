package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.mraid.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3120c implements com.fyber.inneractive.sdk.factories.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAMraidKit f1897a;

    public C3120c(IAMraidKit iAMraidKit) {
        this.f1897a = iAMraidKit;
    }

    @Override // com.fyber.inneractive.sdk.factories.g
    public final boolean a(InneractiveAdSpot inneractiveAdSpot) {
        return this.f1897a.isMRaidSpotContent(inneractiveAdSpot);
    }

    @Override // com.fyber.inneractive.sdk.factories.g
    public final com.fyber.inneractive.sdk.interfaces.f b(InneractiveAdSpot inneractiveAdSpot) {
        return new com.fyber.inneractive.sdk.renderers.s();
    }
}
