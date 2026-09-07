package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.Button;
import sg.bigo.ads.R;
import sg.bigo.ads.api.VideoController;

/* JADX INFO: loaded from: classes8.dex */
public abstract class q extends i<s> {
    public static final sg.bigo.ads.core.adview.h F = new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.interstitial.q.1
        @Override // sg.bigo.ads.core.adview.h
        public final void a(int i, int i2, int i3, int i4, int i5, int i6) {
            sg.bigo.ads.common.t.a.a(0, 4, "emptyClick", "emptyClick stop event Propagation");
        }
    };
    protected sg.bigo.ads.ad.b.c C;
    protected ViewGroup D;
    protected Button E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private t f12929a;

    protected q(Activity activity) {
        super(activity);
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void D() {
        super.D();
        VideoController videoControllerAa = aa();
        if (videoControllerAa != null) {
            videoControllerAa.setVideoLifeCallback(null);
            videoControllerAa.setLoadHTMLCallback(null);
            videoControllerAa.setProgressChangeListener(null);
        }
    }

    protected int Y() {
        return 1;
    }

    public final t Z() {
        if (this.f12929a == null) {
            this.f12929a = aq() ? sg.bigo.ads.ad.interstitial.d.a.a(this.C) : sg.bigo.ads.ad.interstitial.d.a.a(this.C, n());
        }
        return this.f12929a;
    }

    public final VideoController aa() {
        sg.bigo.ads.ad.b.c cVar = this.C;
        if (cVar != null) {
            return cVar.getVideoController();
        }
        return null;
    }

    protected final boolean ab() {
        return this.y != 0 && ((s) this.y).y();
    }

    protected final boolean ac() {
        return this.y != 0 && ((s) this.y).F();
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected void g(int i) {
        ViewGroup viewGroup = (ViewGroup) l(R.id.inter_native_ad_view);
        this.D = viewGroup;
        if (viewGroup == null) {
            a("can not find ad root view.");
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected void h() {
        super.h();
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialPage", "performResume");
        t tVar = this.f12929a;
        if (tVar != null) {
            tVar.b();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected void j() {
        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialPage", "performPause");
        t tVar = this.f12929a;
        if (tVar != null) {
            tVar.c();
        }
        if (ab()) {
            h(true);
        } else {
            super.j();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected void m() {
        this.C = ((s) this.y).w;
    }

    protected abstract int n();
}
