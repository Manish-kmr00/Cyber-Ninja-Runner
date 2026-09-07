package sg.bigo.ads.ad.d;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.d.w;
import sg.bigo.ads.ad.interstitial.r;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.ad.interstitial.y;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;

/* JADX INFO: loaded from: classes7.dex */
public class h extends y implements f.a {
    private w H;
    private sg.bigo.ads.ad.interstitial.c.w L;

    protected h(Activity activity) {
        super(activity);
        activity.overridePendingTransition(0, 0);
    }

    private boolean ar() {
        sg.bigo.ads.core.a.a aVarF = ((s) this.y).f();
        sg.bigo.ads.ad.interstitial.a.b bVar = ((s) this.y).x;
        return (aVarF.bg() == null) && (bVar == null || !bVar.b());
    }

    private w as() {
        if (this.H == null) {
            this.H = sg.bigo.ads.ad.interstitial.d.a.a(this.C, this.c, n());
        }
        return this.H;
    }

    private sg.bigo.ads.ad.interstitial.c.w at() {
        if (this.L == null) {
            this.L = sg.bigo.ads.ad.interstitial.d.a.b(this.C, this.c, n());
        }
        return this.L;
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void I() {
        MediaView mediaView;
        if (this.D == null || (mediaView = (MediaView) this.D.findViewById(R.id.inter_media)) == null) {
            return;
        }
        as().a((ViewGroup) mediaView);
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean O() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.i
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
        as().c(viewGroup);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void a(boolean z) {
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.b.a.InterfaceC0828a
    public final void a(boolean z, boolean z2) {
        if (this.A != null) {
            this.A.d();
        }
        if (z2 && c() == 0) {
            a(this.G, new Runnable() { // from class: sg.bigo.ads.ad.d.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.ag();
                    if (h.this.J()) {
                        h.this.j(1);
                        return;
                    }
                    VideoController videoControllerAa = h.this.aa();
                    if (videoControllerAa != null) {
                        videoControllerAa.play();
                    }
                }
            });
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.y
    public final boolean ad() {
        at().i();
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.y
    public final boolean aj() {
        return !this.p.get();
    }

    @Override // sg.bigo.ads.ad.interstitial.y
    public final LandingPageStyleConfig an() {
        return new LandingPageStyleConfig(sg.bigo.ads.ad.interstitial.f.c.class, 1, at().n(), at().o(), this.D != null ? this.D.getMeasuredHeight() : 0, r.a(this.C, 0), 0.8f);
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a
    public final sg.bigo.ads.ad.interstitial.w b() {
        sg.bigo.ads.ad.interstitial.w wVar = new sg.bigo.ads.ad.interstitial.w();
        if (this.c != null) {
            wVar.f = this.c.c("video_play_page.media_view_clickable_switch");
            wVar.h = this.c.c("video_play_page.ad_component_clickable_switch");
            wVar.g = this.c.c("video_play_page.other_space_clickable_switch");
            wVar.i = this.c.a("video_play_page.click_type");
            wVar.k = this.c.c("layer.other_space_clickable_switch");
            wVar.l = this.c.a("layer.click_type");
            wVar.c = this.c.a("video_play_page.force_staying_time");
            wVar.e = this.c.a("layer.force_staying_time");
            wVar.j = this.c.a("video_play_page.auto_click");
            wVar.m = this.c.a("video_play_page.time_for_auto_click", -1);
            wVar.n = this.c.a("video_play_page.time_for_show_backup", -1);
            this.d = true;
            wVar.f12960a = false;
            wVar.b = 0;
            wVar.d = false;
        }
        return wVar;
    }

    @Override // sg.bigo.ads.ad.d.f.a
    public final void d_() {
        e(true);
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a
    public final boolean f(boolean z) {
        int iC = c();
        if (!J() || iC != 0) {
            return z;
        }
        b(true);
        j(3);
        return c() == 0;
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void g(int i) {
        super.g(i);
        if (this.D == null) {
            return;
        }
        if (this.r != null) {
            this.r.b();
        }
        as().g(this.D);
        as().h(this.D);
        as().d(this.D);
        as().a(l(R.id.inter_container), this.D.findViewById(R.id.media_layout));
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void h() {
        super.h();
        if (this.A == null) {
            as().q();
            at().q();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.y
    public final void i(int i) {
        as();
        w.a(this.D, this.l);
        this.u = as().e(this.D);
        if (this.u == null) {
            as().f(this.D);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.api.VideoController.a
    public final void i(boolean z) {
        super.i(z);
        ae();
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void j() {
        super.j();
        if (this.A == null) {
            as().p();
            at().p();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.y
    public final void j(int i) {
        int iA;
        if (this.D == null) {
            return;
        }
        if (c() != 0) {
            sg.bigo.ads.common.t.a.a(0, "PopupVideoActivityImpl", "end page can be shown but current page is not main");
            return;
        }
        if (this.p.get() && ar()) {
            return;
        }
        View viewFindViewById = this.D.findViewById(R.id.inter_btn_cta);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(this.n);
        }
        View viewFindViewById2 = this.D.findViewById(R.id.inter_btn_mute);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(4);
        }
        MediaView mediaView = (MediaView) this.D.findViewById(R.id.inter_media);
        if (mediaView == null || (iA = at().a(mediaView, (s) this.y, this.p.get())) == 0) {
            return;
        }
        at().g(this.D);
        at().c(this.D);
        at().f(this.D);
        at().a(this.A, this.D, this);
        at().d(this.D);
        f(iA);
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) ((s) this.y).f(), c(), i);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void p() {
        as().a(this.A, this.D, this);
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a
    public final void s() {
        e(true);
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void u() {
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a
    public final void x() {
        super.x();
        if (this.A != null) {
            this.A.setShowCloseButtonInCountdown(false);
            this.A.setTakeoverTickEvent(false);
        }
    }
}
