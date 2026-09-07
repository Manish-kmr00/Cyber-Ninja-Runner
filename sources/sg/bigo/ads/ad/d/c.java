package sg.bigo.ads.ad.d;

import android.content.Context;
import sg.bigo.ads.ad.interstitial.n;
import sg.bigo.ads.api.popup.PopupAd;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends n implements PopupAd {
    public c(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.n, sg.bigo.ads.ad.interstitial.k
    public final Class<? extends sg.bigo.ads.controller.e.b<?>> A() {
        return b.class;
    }

    @Override // sg.bigo.ads.ad.interstitial.n
    public final sg.bigo.ads.core.mraid.n B() {
        return sg.bigo.ads.core.mraid.n.POPUP;
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public final void a(Context context) {
        if (sg.bigo.ads.controller.landing.d.a(context, (Class<? extends sg.bigo.ads.controller.e.b<?>>) b.class, this)) {
            return;
        }
        a(2004, "This ad cannot be open");
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public final int x() {
        return this.b.b.c();
    }
}
