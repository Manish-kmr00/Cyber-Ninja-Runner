package com.five_corp.ad.internal;

import com.five_corp.ad.FiveAdErrorCode;
import com.five_corp.ad.FiveAdInterstitial;
import com.five_corp.ad.FiveAdInterstitialEventListener;

/* JADX INFO: renamed from: com.five_corp.ad.internal.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C2977d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FiveAdInterstitialEventListener f1371a;
    public final /* synthetic */ FiveAdInterstitial b;

    public C2977d(FiveAdInterstitialEventListener fiveAdInterstitialEventListener, FiveAdInterstitial fiveAdInterstitial) {
        this.f1371a = fiveAdInterstitialEventListener;
        this.b = fiveAdInterstitial;
    }

    @Override // com.five_corp.ad.internal.g
    public final void a() {
        this.f1371a.onPlay(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void b() {
        this.f1371a.onViewThrough(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void c() {
        this.f1371a.onPause(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void d() {
        this.f1371a.onClick(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void e() {
        this.f1371a.onImpression(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void a(FiveAdErrorCode fiveAdErrorCode) {
        this.f1371a.onViewError(this.b, fiveAdErrorCode);
    }
}
