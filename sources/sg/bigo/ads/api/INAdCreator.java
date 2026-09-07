package sg.bigo.ads.api;

import sg.bigo.ads.ad.d.e;
import sg.bigo.ads.ad.interstitial.k;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.api.core.g;

/* JADX INFO: loaded from: classes3.dex */
public class INAdCreator implements k.a<s> {
    @Override // sg.bigo.ads.ad.interstitial.k.a
    public s getAdInstance(g gVar) {
        return gVar.f13106a.x() == 20 ? new e(gVar) : new s(gVar);
    }
}
