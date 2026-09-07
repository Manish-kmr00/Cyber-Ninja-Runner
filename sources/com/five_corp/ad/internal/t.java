package com.five_corp.ad.internal;

import com.five_corp.ad.FiveAdVideoReward;
import com.five_corp.ad.FiveAdVideoRewardEventListener;

/* JADX INFO: loaded from: classes10.dex */
public final class t implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FiveAdVideoRewardEventListener f1550a;
    public final /* synthetic */ FiveAdVideoReward b;

    public t(FiveAdVideoRewardEventListener fiveAdVideoRewardEventListener, FiveAdVideoReward fiveAdVideoReward) {
        this.f1550a = fiveAdVideoRewardEventListener;
        this.b = fiveAdVideoReward;
    }

    @Override // com.five_corp.ad.internal.u
    public final void a() {
        this.f1550a.onReward(this.b);
    }

    @Override // com.five_corp.ad.internal.u
    public final void b() {
        this.f1550a.onFullScreenOpen(this.b);
    }

    @Override // com.five_corp.ad.internal.u
    public final void c() {
        this.f1550a.onFullScreenClose(this.b);
    }
}
