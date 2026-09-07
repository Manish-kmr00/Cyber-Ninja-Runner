package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes8.dex */
public class m extends i<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f12842a;

    protected m(Activity activity) {
        super(activity);
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void D() {
        super.D();
        RelativeLayout relativeLayout = this.f12842a;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected int R() {
        return R.layout.bigo_ad_activity_interstitial_banner;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected final boolean S() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected final boolean f() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected void g(int i) {
        if (this.y == 0) {
            a("Illegal InterstitialAd.");
            return;
        }
        ((n) this.y).x = new sg.bigo.ads.ad.banner.g() { // from class: sg.bigo.ads.ad.interstitial.m.1
            @Override // sg.bigo.ads.ad.banner.g
            public final void a() {
                m.this.d(true);
            }

            @Override // sg.bigo.ads.ad.banner.g
            public final void a(String str) {
            }

            @Override // sg.bigo.ads.ad.banner.g
            public final void a(sg.bigo.ads.common.i iVar, sg.bigo.ads.api.core.e eVar) {
            }

            @Override // sg.bigo.ads.ad.banner.g
            public final void b() {
            }
        };
        this.f12842a = (RelativeLayout) this.z.findViewById(R.id.inter_banner_container);
        n nVar = (n) this.y;
        if (!sg.bigo.ads.common.n.d.b()) {
            sg.bigo.ads.common.utils.t.a("adView() must run on UI thread");
        }
        View viewC = nVar.w.c();
        nVar.a(viewC, false);
        if (viewC != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            sg.bigo.ads.common.utils.u.a(viewC, this.f12842a, layoutParams, 0);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected final void m() {
    }
}
