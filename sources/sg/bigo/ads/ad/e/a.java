package sg.bigo.ads.ad.e;

import android.app.Activity;
import android.view.View;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.m;

/* JADX INFO: loaded from: classes11.dex */
class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f12596a;
    private boolean b;
    private boolean c;

    protected a(Activity activity) {
        super(activity);
        this.b = true;
        this.c = false;
    }

    static /* synthetic */ boolean c(a aVar) {
        aVar.c = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void N() {
        super.N();
        if (this.y == 0) {
            return;
        }
        if (this.y instanceof b) {
            this.f12596a = (b) this.y;
        }
        if (this.f12596a == null) {
            a("Illegal reward banner content.");
        }
        if (this.A.getVisibility() != 0) {
            this.A.setVisibility(0);
            sg.bigo.ads.ad.interstitial.c.b((View) this.A);
        }
        this.A.a(15, new AdCountDownButton.b() { // from class: sg.bigo.ads.ad.e.a.1
            @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.b
            public final void a() {
                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.e.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.A.d();
                        if (a.this.f12596a == null || a.this.c) {
                            sg.bigo.ads.common.t.a.a(2, "", "Failed to claim reward because of null RewardVideoAd.");
                        } else {
                            a.c(a.this);
                            a.this.f12596a.C();
                        }
                    }
                });
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void W() {
        if (this.b) {
            d(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final void d(boolean z) {
        if (this.A.getVisibility() == 0 && this.A.c) {
            if (!this.c) {
                this.A.d();
                b bVar = this.f12596a;
                if (bVar != null) {
                    this.c = true;
                    bVar.C();
                }
            }
            super.d(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.m, sg.bigo.ads.ad.interstitial.i
    public final void g(int i) {
        super.g(i);
    }
}
