package sg.bigo.ads.ad.interstitial.h;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.c;
import sg.bigo.ads.ad.interstitial.q;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.a.m;

/* JADX INFO: loaded from: classes13.dex */
public class a extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected w f12836a;
    protected m b;
    private final sg.bigo.ads.common.e.a.AbstractC0861a c;
    private boolean d;

    protected a(Activity activity) {
        super(activity);
        this.c = new sg.bigo.ads.common.e.a.AbstractC0861a() { // from class: sg.bigo.ads.ad.interstitial.h.a.1
            @Override // sg.bigo.ads.common.e.a.AbstractC0861a
            public final void a(boolean z) {
                a aVar = a.this;
                if (z) {
                    aVar.U();
                } else {
                    aVar.V();
                }
            }
        };
        this.d = true;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public int R() {
        return R.layout.bigo_ad_activity_interstitial_vpaid;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean S() {
        return true;
    }

    protected void a() {
        if (this.A == null) {
            return;
        }
        int i = this.f12836a.c;
        if (((s) this.y).f().x() != 4) {
            i = 0;
        }
        this.A.a(i, (AdCountDownButton.b) null);
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    public final boolean f() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public void g(int i) {
        super.g(i);
        if (this.D == null) {
            a("can not find ad root view.");
            return;
        }
        if (this.y == 0) {
            a("Illegal InterstitialAd.");
            return;
        }
        if (this.A != null) {
            sg.bigo.ads.common.e.a.a(this.A, this.c);
            this.A.setShowCloseButtonInCountdown(false);
            this.A.setTakeoverTickEvent(false);
            if (this.A.getVisibility() != 0) {
                this.A.setVisibility(0);
                c.b((View) this.A);
            }
            a();
        }
        if (this.D != null && this.C != null) {
            TextView textView = (TextView) this.D.findViewById(R.id.inter_advertiser);
            TextView textView2 = (TextView) this.D.findViewById(R.id.inter_ad_label);
            String advertiser = this.C.getAdvertiser();
            if (textView != null && textView2 != null) {
                boolean zIsEmpty = TextUtils.isEmpty(advertiser);
                textView.setVisibility(!zIsEmpty ? 0 : 8);
                if (!zIsEmpty) {
                    textView.setText(advertiser);
                    textView2.setText(R.string.bigo_ad_tag);
                }
            }
        }
        Z().a(this.D, this.D, Y(), 12, this.f12836a.i, this.A);
    }

    @Override // sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void h() {
        super.h();
        VideoController videoControllerAa = aa();
        if (videoControllerAa != null && videoControllerAa.isPaused() && this.d) {
            videoControllerAa.play();
            this.d = false;
        }
        if (this.A == null || this.A.c) {
            return;
        }
        this.A.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void j() {
        VideoController videoControllerAa = aa();
        boolean z = videoControllerAa != null && videoControllerAa.isPlaying();
        this.d = z;
        if (z) {
            videoControllerAa.pause();
        }
        if (this.A != null && !this.A.c) {
            this.A.b();
        }
        super.j();
    }

    @Override // sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public void m() {
        super.m();
        this.b = ((s) this.y).f().e();
        w wVar = new w();
        m mVar = this.b;
        if (mVar != null) {
            wVar.f = mVar.c("video_play_page.media_view_clickable_switch");
            wVar.g = this.b.c("video_play_page.other_space_clickable_switch");
            wVar.i = this.b.a("video_play_page.click_type");
            wVar.c = this.b.a("video_play_page.force_staying_time");
        }
        this.f12836a = wVar;
    }

    @Override // sg.bigo.ads.ad.interstitial.q
    public final int n() {
        return 0;
    }
}
