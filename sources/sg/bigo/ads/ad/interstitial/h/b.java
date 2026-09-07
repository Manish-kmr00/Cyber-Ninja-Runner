package sg.bigo.ads.ad.interstitial.h;

import android.app.Activity;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.d.w;

/* JADX INFO: loaded from: classes13.dex */
public class b extends a {
    private w c;

    protected b(Activity activity) {
        super(activity);
    }

    private w b() {
        if (this.c == null) {
            this.c = sg.bigo.ads.ad.interstitial.d.a.a(this.C, this.b, 0);
        }
        return this.c;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean O() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.h.a, sg.bigo.ads.ad.interstitial.i
    public final int R() {
        return R.layout.bigo_ad_activity_popup_vpaid;
    }

    @Override // sg.bigo.ads.ad.interstitial.h.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void g(int i) {
        super.g(i);
        b().a(l(R.id.inter_container), l(R.id.media_layout));
        b().g(this.D);
    }
}
