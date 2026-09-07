package sg.bigo.ads.api;

import sg.bigo.ads.ad.interstitial.k;
import sg.bigo.ads.ad.interstitial.n;
import sg.bigo.ads.api.core.g;

/* JADX INFO: loaded from: classes11.dex */
public class IBAdCreator implements k.a<n> {
    @Override // sg.bigo.ads.ad.interstitial.k.a
    public n getAdInstance(g gVar) {
        return gVar.f13106a.x() == 20 ? new sg.bigo.ads.ad.d.c(gVar) : new n(gVar);
    }
}
