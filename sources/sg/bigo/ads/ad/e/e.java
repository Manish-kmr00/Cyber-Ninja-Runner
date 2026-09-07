package sg.bigo.ads.ad.e;

import android.app.Activity;

/* JADX INFO: loaded from: classes11.dex */
public class e extends sg.bigo.ads.ad.interstitial.h.a {
    protected g c;
    private boolean d;
    private boolean e;

    protected e(Activity activity) {
        super(activity);
        this.d = true;
        this.e = false;
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void N() {
        super.N();
        if (this.y == 0) {
            return;
        }
        if (this.y instanceof g) {
            this.c = (g) this.y;
        }
        if (this.c == null || !ac()) {
            a("Illegal VPAID content.");
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void W() {
        if (this.d) {
            d(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.q
    public final int Y() {
        return 2;
    }

    @Override // sg.bigo.ads.ad.interstitial.h.a
    public final void a() {
        if (this.A != null) {
            this.A.setShowCloseButtonInCountdown(false);
        }
        super.a();
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final void d(boolean z) {
        if (this.A.getVisibility() == 0 && this.A.c) {
            if (!this.e) {
                this.A.d();
                g gVar = this.c;
                if (gVar != null) {
                    this.e = true;
                    gVar.G();
                }
            }
            super.d(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.h.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void m() {
        super.m();
        if (this.f12836a != null) {
            this.f12836a.c = 15;
            this.f12836a.f = true;
            this.f12836a.g = false;
        }
    }
}
