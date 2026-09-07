package sg.bigo.ads.ad.e;

import android.app.Activity;
import android.view.View;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.ad.interstitial.x;

/* JADX INFO: loaded from: classes4.dex */
class d extends x {
    protected g H;
    private boolean L;
    private boolean M;

    protected d(Activity activity) {
        super(activity);
        this.L = true;
        this.M = false;
    }

    static /* synthetic */ boolean d(d dVar) {
        dVar.M = true;
        return true;
    }

    static /* synthetic */ boolean h(d dVar) {
        dVar.e = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
    public final void C() {
        if (G()) {
            F();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void N() {
        super.N();
        if (this.y == 0) {
            return;
        }
        if (this.y instanceof g) {
            this.H = (g) this.y;
        }
        if (this.H == null) {
            a("Illegal static content.");
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void W() {
        if (this.L && c() == 0) {
            d(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.q
    public final int Y() {
        return this.b.a("interstitial_video_style.video_play_page.icon_strategy") == 2 ? 2 : 1;
    }

    @Override // sg.bigo.ads.ad.interstitial.x, sg.bigo.ads.ad.interstitial.a
    public final w b() {
        w wVarB = super.b();
        if (!this.L) {
            wVarB.b = 0;
            wVarB.c = -1;
        }
        return wVarB;
    }

    @Override // sg.bigo.ads.ad.interstitial.x, sg.bigo.ads.ad.interstitial.a
    public final boolean f(boolean z) {
        if (this.p.get() && !this.M) {
            if (this.A != null) {
                this.A.d();
            }
            g gVar = this.H;
            if (gVar != null) {
                this.M = true;
                gVar.G();
            }
        }
        return super.f(z);
    }

    @Override // sg.bigo.ads.ad.interstitial.x, sg.bigo.ads.ad.interstitial.a
    public final void x() {
        super.x();
        if (this.A != null) {
            this.A.setShowCloseButtonInCountdown(this.L);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.x, sg.bigo.ads.ad.interstitial.a
    public final void y() {
        if (this.A == null) {
            return;
        }
        if (this.A.getVisibility() != 0) {
            this.A.setVisibility(0);
            sg.bigo.ads.ad.interstitial.c.b((View) this.A);
        }
        if (c() == 0) {
            int i = this.h.c;
            if (i < 0 && ((s) this.y).f().x() != 4) {
                i = 15;
            }
            this.A.a(i, new AdCountDownButton.b() { // from class: sg.bigo.ads.ad.e.d.1
                @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.b
                public final void a() {
                    sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.e.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (d.this.A != null) {
                                d.this.A.d();
                            }
                            if (d.this.H == null || d.this.M) {
                                sg.bigo.ads.common.t.a.a(2, "", "Failed to claim reward because of null RewardVideoAd.");
                            } else {
                                d.d(d.this);
                                d.this.H.G();
                            }
                            if (d.this.r != null) {
                                d.this.r.y.a(null);
                            }
                            if (d.this.h.j == 3) {
                                d.h(d.this);
                                sg.bigo.ads.common.t.a.a(0, 4, "Interstitial Static", "auto click when force staying finish");
                                ((s) d.this.y).w.a(8, 22);
                            }
                        }
                    });
                }
            });
        }
    }
}
