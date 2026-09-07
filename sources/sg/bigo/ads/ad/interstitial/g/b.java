package sg.bigo.ads.ad.interstitial.g;

import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.q;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.p;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    protected TextView s;
    protected TextView t;

    protected b(sg.bigo.ads.ad.b.c cVar, m mVar, p pVar) {
        super(cVar, mVar, pVar);
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    protected final void d(q qVar) {
        if (this.k == null || qVar == null) {
            return;
        }
        this.s = (TextView) this.k.findViewById(R.id.inter_title);
        this.t = (TextView) this.k.findViewById(R.id.inter_description);
        sg.bigo.ads.ad.interstitial.d.a(this.s, -234881024);
        sg.bigo.ads.ad.interstitial.d.a(this.t, -234881024);
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final boolean d() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    public final boolean g() {
        return this.h != null && this.h.c > 960;
    }

    @Override // sg.bigo.ads.ad.interstitial.g.a
    protected final int h() {
        return R.layout.bigo_ad_view_click_guide_1;
    }
}
