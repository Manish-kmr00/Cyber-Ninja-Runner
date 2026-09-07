package com.five_corp.ad.internal;

import com.five_corp.ad.FiveAdErrorCode;
import com.five_corp.ad.FiveAdVideoReward;
import com.five_corp.ad.FiveAdVideoRewardEventListener;

/* JADX INFO: renamed from: com.five_corp.ad.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C2978e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FiveAdVideoRewardEventListener f1372a;
    public final /* synthetic */ FiveAdVideoReward b;

    public C2978e(FiveAdVideoRewardEventListener fiveAdVideoRewardEventListener, FiveAdVideoReward fiveAdVideoReward) {
        this.f1372a = fiveAdVideoRewardEventListener;
        this.b = fiveAdVideoReward;
    }

    @Override // com.five_corp.ad.internal.g
    public final void a() {
        this.f1372a.onPlay(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void b() {
        this.f1372a.onViewThrough(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void c() {
        this.f1372a.onPause(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void d() {
        this.f1372a.onClick(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void e() {
        this.f1372a.onImpression(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void a(FiveAdErrorCode fiveAdErrorCode) {
        this.f1372a.onViewError(this.b, fiveAdErrorCode);
    }
}
