package com.five_corp.ad.internal;

import com.five_corp.ad.FiveAdInterstitial;
import com.five_corp.ad.FiveAdInterstitialEventListener;

/* JADX INFO: loaded from: classes10.dex */
public final class s implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FiveAdInterstitialEventListener f1520a;
    public final /* synthetic */ FiveAdInterstitial b;

    public s(FiveAdInterstitialEventListener fiveAdInterstitialEventListener, FiveAdInterstitial fiveAdInterstitial) {
        this.f1520a = fiveAdInterstitialEventListener;
        this.b = fiveAdInterstitial;
    }

    @Override // com.five_corp.ad.internal.u
    public final void a() {
    }

    @Override // com.five_corp.ad.internal.u
    public final void b() {
        this.f1520a.onFullScreenOpen(this.b);
    }

    @Override // com.five_corp.ad.internal.u
    public final void c() {
        this.f1520a.onFullScreenClose(this.b);
    }
}
