package com.fyber.inneractive.sdk.dv.rewarded;

import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends RewardedAdCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1748a;

    public f(g gVar) {
        this.f1748a = gVar;
    }

    public final void onRewardedAdClosed() {
        com.fyber.inneractive.sdk.dv.interstitial.a aVar = this.f1748a.j;
        if (aVar != null) {
            aVar.g();
        }
    }

    public final void onRewardedAdFailedToShow(int i) {
    }

    public final void onRewardedAdOpened() {
        com.fyber.inneractive.sdk.dv.interstitial.a aVar = this.f1748a.j;
        if (aVar != null) {
            aVar.u();
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        com.fyber.inneractive.sdk.dv.interstitial.a aVar = this.f1748a.j;
        if (aVar != null) {
            aVar.onReward();
        }
    }
}
