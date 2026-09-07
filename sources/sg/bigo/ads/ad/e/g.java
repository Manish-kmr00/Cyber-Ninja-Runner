package sg.bigo.ads.ad.e;

import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.RewardAdInteractionListener;
import sg.bigo.ads.api.RewardVideoAd;
import sg.bigo.ads.api.core.n;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends s implements RewardVideoAd {
    private RewardAdInteractionListener B;

    public g(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.s, sg.bigo.ads.ad.interstitial.k
    public final Class<? extends sg.bigo.ads.controller.e.b<?>> A() {
        if (y()) {
            return F() ? e.class : f.class;
        }
        return d.class;
    }

    final void G() {
        sg.bigo.ads.core.d.b.b(this.b.f13106a, this);
        RewardAdInteractionListener rewardAdInteractionListener = this.B;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdRewarded();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.s, sg.bigo.ads.ad.interstitial.k
    public final void b(sg.bigo.ads.api.b.d.a<InterstitialAd> aVar) {
        super.b(aVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.s, sg.bigo.ads.ad.interstitial.k, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        super.destroyInMainThread();
        this.B = null;
    }

    @Override // sg.bigo.ads.api.RewardVideoAd
    public final void setAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener) {
        super.setAdInteractionListener((AdInteractionListener) rewardAdInteractionListener);
        this.B = rewardAdInteractionListener;
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public final int x() {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) this.b.f13106a;
        n nVarAU = aVar.aU();
        long jAT = nVarAU != null ? nVarAU.c : 0L;
        if (jAT == 0) {
            jAT = aVar.aT();
        }
        return (int) (jAT / 1000);
    }
}
