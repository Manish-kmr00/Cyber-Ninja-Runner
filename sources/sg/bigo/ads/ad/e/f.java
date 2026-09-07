package sg.bigo.ads.ad.e;

import android.app.Activity;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.d.m;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.ad.interstitial.t;
import sg.bigo.ads.ad.interstitial.y;
import sg.bigo.ads.api.VideoController;

/* JADX INFO: loaded from: classes7.dex */
class f extends y {
    protected g H;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;

    protected f(Activity activity) {
        super(activity);
        this.L = true;
        this.M = false;
        this.N = false;
        this.O = false;
    }

    private void ar() {
        g gVar = this.H;
        if (gVar != null && !this.M) {
            this.M = true;
            gVar.G();
        } else if (gVar == null) {
            sg.bigo.ads.common.t.a.a(2, "", "Failed to claim reward because of null RewardVideoAd.");
        }
    }

    static /* synthetic */ boolean f(f fVar) {
        fVar.O = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
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
        if (this.H == null || !ab()) {
            a("Illegal video content.");
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.controller.e.b, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void W() {
        if (this.L && c() == 0) {
            d(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.q
    public final int Y() {
        int i = this.b.a("interstitial_video_style.video_play_page.icon_strategy") != 2 ? 1 : 2;
        if (this.p.get()) {
            return 3;
        }
        return i;
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.b.a.InterfaceC0828a
    public final void a(boolean z, boolean z2) {
        super.a(z, z2);
        if (z || z2) {
            if (this.A != null) {
                this.A.d();
            }
            ar();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
    public final void b(String str) {
        this.N = true;
        super.b(str);
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a
    public final boolean f(boolean z) {
        if (this.p.get()) {
            if (this.A != null) {
                this.A.d();
            }
        } else if (!this.M && this.L && c() == 0 && !this.O) {
            final VideoController videoControllerAa = aa();
            new c(this.I).a(new c.a() { // from class: sg.bigo.ads.ad.e.f.1
                private int c = -1;
                private boolean d = false;
                private boolean e = false;

                private void e() {
                    if (f.this.c() == 3) {
                        f.this.f(this.c);
                    }
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void a() {
                    this.c = f.this.c();
                    f.this.f(3);
                    VideoController videoController = videoControllerAa;
                    if (videoController != null && videoController.isPlaying()) {
                        videoControllerAa.pause();
                        this.d = true;
                    }
                    if (f.this.H != null) {
                        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) f.this.H.f(), f.this.c(), 2);
                    }
                    f.this.Z().c();
                    f.this.G.b(false);
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void b() {
                    VideoController videoController;
                    e();
                    if (!this.e && this.d && (videoController = videoControllerAa) != null && videoController.isPaused()) {
                        videoControllerAa.play();
                    }
                    f.this.Z().b();
                    f.this.G.a(false);
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void c() {
                    this.e = true;
                    f.f(f.this);
                    if (f.this.K() || f.this.L()) {
                        f.this.T();
                        return;
                    }
                    if (f.this.r != null && f.this.r.y.a()) {
                        e();
                    } else if (!f.this.d && f.this.b.a("interstitial_video_style.video_play_page.skip_type") != 2) {
                        f.this.T();
                    } else {
                        e();
                        f.this.j(6);
                    }
                }

                @Override // sg.bigo.ads.ad.e.c.a
                public final void d() {
                    t tVarZ = f.this.Z();
                    if (tVarZ instanceof m) {
                        ((m) tVarZ).A();
                    }
                }
            });
            return false;
        }
        boolean zF = super.f(z);
        if (zF && (this.p.get() || this.N)) {
            ar();
        }
        return zF;
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.api.VideoController.a
    public final void i(boolean z) {
        super.i(z);
        if (z || c() != 0 || this.L || this.A == null) {
            return;
        }
        this.A.setTakeoverTickEvent(false);
        this.A.a(15, (AdCountDownButton.b) null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025 A[PHI: r0
  0x0025: PHI (r0v7 boolean) = (r0v1 boolean), (r0v8 boolean) binds: [B:8:0x0022, B:5:0x0014] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a, sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    public final void m() {
        boolean z;
        super.m();
        boolean z2 = true;
        if (this.c != null) {
            z = this.L;
            if (this.c.a("video_play_page.force_staying_time") == -1) {
                z2 = false;
            }
        } else {
            z = this.L;
            if (this.b.a("interstitial_video_style.style") == 2) {
                z2 = false;
            }
        }
        this.L = z & z2;
        if (this.L) {
            return;
        }
        this.h.b = 0;
        this.h.c = -1;
    }

    @Override // sg.bigo.ads.ad.interstitial.a
    public final void q() {
        super.q();
        sg.bigo.ads.core.a.a aVarF = ((s) this.y).f();
        if (!this.p.get() || aVarF.bg() == null || this.L) {
            return;
        }
        this.h.b = 0;
        this.h.c = 15;
    }

    @Override // sg.bigo.ads.ad.interstitial.y, sg.bigo.ads.ad.interstitial.a
    public final void x() {
        super.x();
        if (this.A != null) {
            this.A.setShowCloseButtonInCountdown(this.L);
        }
    }
}
