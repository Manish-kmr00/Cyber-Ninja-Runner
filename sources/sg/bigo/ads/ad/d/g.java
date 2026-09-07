package sg.bigo.ads.ad.d;

import android.app.Activity;
import android.view.ViewGroup;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.d.w;
import sg.bigo.ads.ad.interstitial.x;
import sg.bigo.ads.api.MediaView;

/* JADX INFO: loaded from: classes8.dex */
public class g extends x implements f.a {
    private w H;

    protected g(Activity activity) {
        super(activity);
        activity.overridePendingTransition(0, 0);
    }

    private w ae() {
        if (this.H == null) {
            this.H = sg.bigo.ads.ad.interstitial.d.a.a(this.C, this.c, n());
        }
        return this.H;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean O() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.x, sg.bigo.ads.ad.interstitial.i
    public final int R() {
        int iN = n();
        if (iN == 2) {
            return R.layout.bigo_ad_activity_pop_up_style_2;
        }
        if (iN == 3) {
            return R.layout.bigo_ad_activity_pop_up_style_3;
        }
        if (iN == 4) {
            return R.layout.bigo_ad_activity_pop_up_style_4;
        }
        if (iN != 5) {
            return iN != 6 ? R.layout.bigo_ad_activity_pop_up_style_1 : R.layout.bigo_ad_activity_pop_up_style_6;
        }
        return R.layout.bigo_ad_activity_pop_up_style_5;
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void X() {
        super.X();
        this.I.overridePendingTransition(0, 0);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void a(ViewGroup viewGroup) {
        ae().c(viewGroup);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void a(boolean z) {
    }

    @Override // sg.bigo.ads.ad.interstitial.x
    public final void ad() {
        MediaView mediaView;
        if (this.D == null || (mediaView = (MediaView) this.D.findViewById(R.id.inter_media)) == null) {
            return;
        }
        if (!this.G) {
            mediaView.setMediaAreaClickable(false);
        }
        ae().a((ViewGroup) mediaView);
    }

    @Override // sg.bigo.ads.ad.d.f.a
    public final void d_() {
        e(true);
    }

    @Override // sg.bigo.ads.ad.interstitial.x, sg.bigo.ads.ad.interstitial.a
    public final boolean f(boolean z) {
        b(true);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.x, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void g(int i) {
        super.g(i);
        if (this.D == null) {
            return;
        }
        if (this.r != null) {
            this.r.b();
        }
        ae().g(this.D);
        ae().h(this.D);
        ae().d(this.D);
        ae().a(l(R.id.inter_container), this.D.findViewById(R.id.media_layout));
    }

    @Override // sg.bigo.ads.ad.interstitial.x, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void h() {
        super.h();
        if (this.A == null) {
            ae().q();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.x
    public final void i(int i) {
        ae();
        w.a(this.D, this.l);
        this.u = ae().e(this.D);
        if (this.u == null) {
            ae().f(this.D);
        } else {
            this.u.c();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.x, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void j() {
        super.j();
        if (this.A == null) {
            ae().p();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void p() {
        ae().a(this.A, this.D, this);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void u() {
    }
}
