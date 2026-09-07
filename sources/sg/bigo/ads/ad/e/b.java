package sg.bigo.ads.ad.e;

import sg.bigo.ads.ad.interstitial.n;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.RewardAdInteractionListener;
import sg.bigo.ads.api.RewardVideoAd;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends n implements RewardVideoAd {
    private RewardAdInteractionListener y;

    public b(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.n, sg.bigo.ads.ad.interstitial.k
    public final Class<? extends sg.bigo.ads.controller.e.b<?>> A() {
        return a.class;
    }

    final void C() {
        sg.bigo.ads.core.d.b.b(this.b.f13106a, this);
        RewardAdInteractionListener rewardAdInteractionListener = this.y;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdRewarded();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.n, sg.bigo.ads.ad.interstitial.k
    public final void b(sg.bigo.ads.api.b.d.a<InterstitialAd> aVar) {
        super.b(aVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.n, sg.bigo.ads.ad.interstitial.k, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        super.destroyInMainThread();
        this.y = null;
    }

    @Override // sg.bigo.ads.api.RewardVideoAd
    public final void setAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener) {
        super.setAdInteractionListener((AdInteractionListener) rewardAdInteractionListener);
        this.y = rewardAdInteractionListener;
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public final int x() {
        return 15;
    }
}
