package sg.bigo.ads.ad.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.v;
import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.ad.splash.a.d;
import sg.bigo.ads.ad.splash.a.e;
import sg.bigo.ads.ad.splash.a.f;
import sg.bigo.ads.ad.splash.a.g;
import sg.bigo.ads.ad.splash.a.h;
import sg.bigo.ads.ad.splash.a.j;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.SplashAdInteractionListener;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.p;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends sg.bigo.ads.ad.c<SplashAd, sg.bigo.ads.core.a.a> implements SplashAd {
    private h A;
    private sg.bigo.ads.ad.splash.a.a B;
    private long C;
    private final m D;
    private ViewGroup E;
    private AdCountDownButton F;
    private n G;
    private Runnable H;
    private Runnable I;
    private Runnable J;
    private Runnable K;
    private n L;
    private long V;
    private long W;
    public g u;
    public final sg.bigo.ads.ad.b.c v;
    boolean w;
    final c x;
    public final m y;
    public final sg.bigo.ads.api.core.g z;

    public b(sg.bigo.ads.ad.b.c cVar, sg.bigo.ads.api.core.g gVar, m mVar, m mVar2) {
        h bVar;
        super(gVar);
        this.w = false;
        this.V = 0L;
        this.W = 0L;
        this.D = mVar;
        this.y = mVar2;
        this.z = gVar;
        a((sg.bigo.ads.api.b.a) cVar);
        this.v = cVar;
        c cVar2 = new c() { // from class: sg.bigo.ads.ad.splash.b.1
            @Override // sg.bigo.ads.ad.splash.c, sg.bigo.ads.api.AdInteractionListener
            public final void onAdClicked() {
                super.onAdClicked();
                if (b.this.A != null) {
                    b.this.A.b();
                }
            }

            @Override // sg.bigo.ads.ad.splash.c, sg.bigo.ads.api.SplashAdInteractionListener
            public final void onAdFinished() {
                super.onAdFinished();
            }

            @Override // sg.bigo.ads.ad.splash.c, sg.bigo.ads.api.AdInteractionListener
            public final void onAdImpression() {
                super.onAdImpression();
                b.this.C = SystemClock.elapsedRealtime();
                if (b.this.A != null) {
                    b.this.A.a();
                }
                b.this.x();
            }
        };
        this.x = cVar2;
        cVar.setAdInteractionListener(cVar2);
        int iAs = gVar.f13106a.as();
        int iA = mVar2 != null ? mVar2.a("video_play_page.interactive_method", 0) : 0;
        if (1 == iAs && iA != 0) {
            bVar = new d(gVar, mVar, mVar2, this);
        } else if (mVar2 == null || a.b(mVar) || a.b()) {
            bVar = new sg.bigo.ads.ad.splash.a.b(gVar, mVar, mVar2, this);
        } else {
            int iA2 = mVar2.a("video_play_page.ad_component_layout");
            bVar = iA2 != 3 ? (iA2 == 4 || iA2 == 5) ? new f(iA2, gVar, mVar, mVar2, this) : new sg.bigo.ads.ad.splash.a.b(gVar, mVar, mVar2, this) : new e(gVar, mVar, mVar2, this);
        }
        this.A = bVar;
    }

    private boolean F() {
        return f().aR() && P();
    }

    private void G() {
        int i;
        ViewGroup viewGroup;
        if (this.y == null || !C()) {
            return;
        }
        if (this.B == null && (viewGroup = this.E) != null) {
            this.B = new sg.bigo.ads.ad.splash.a.a(viewGroup, this, this.y);
        }
        int iA = this.y.a("endpage.endpage_timing", 0);
        if (iA >= 3) {
            if (iA == 4) {
                i = 5000;
            } else {
                i = iA == 5 ? 10000 : 3000;
            }
            if (this.L == null && !L()) {
                this.L = new n(i) { // from class: sg.bigo.ads.ad.splash.b.10
                    @Override // sg.bigo.ads.common.utils.n
                    public final void a() {
                        if (b.this.h || b.this.L()) {
                            return;
                        }
                        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.b.10.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.this.a(8, 12);
                            }
                        });
                    }

                    @Override // sg.bigo.ads.common.utils.n
                    public final void a(long j) {
                    }
                };
            }
            this.L.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        sg.bigo.ads.ad.splash.a.a aVar = this.B;
        return aVar != null && aVar.c == sg.bigo.ads.ad.splash.a.c.a.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        g gVar = this.u;
        if (gVar != null) {
            gVar.a(this.K);
            sg.bigo.ads.common.n.d.a(this.J);
            this.u.c();
            this.u = null;
            this.K = null;
            this.J = null;
        }
    }

    private void N() {
        int iA;
        AdCountDownButton adCountDownButton = this.F;
        if (adCountDownButton == null) {
            return;
        }
        adCountDownButton.d();
        m mVar = this.y;
        if (mVar == null || (iA = mVar.a("endpage.close_click_seconds", 0)) <= 0) {
            return;
        }
        this.F.clearAnimation();
        this.F.setVisibility(4);
        if (this.I == null) {
            this.I = new Runnable() { // from class: sg.bigo.ads.ad.splash.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.A() || b.this.F.getVisibility() == 0) {
                        return;
                    }
                    b.this.F.setVisibility(0);
                    sg.bigo.ads.ad.interstitial.c.b((View) b.this.F);
                }
            };
        }
        sg.bigo.ads.common.n.d.a(2, this.I, ((long) iA) * 1000);
    }

    private boolean O() {
        m mVar = this.y;
        return (mVar == null || 1 != mVar.a("video_play_page.is_auto_close", 0) || P()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        m mVar = this.y;
        return mVar != null && 6 == mVar.a("video_play_page.ad_component_layout", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q() {
        m mVar;
        return C() && (mVar = this.y) != null && 2 == mVar.a("endpage.ad_component_layout", 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.app.Activity] */
    private void a(Activity activity, boolean z) {
        sg.bigo.ads.api.a.h hVar;
        if (F()) {
            this.A = new j(this.z, this.D, this.y, this);
        }
        a(activity == 0, z);
        if (activity != 0) {
            this.v.b(activity);
        }
        this.v.d(1);
        this.v.a(true);
        sg.bigo.ads.core.d.b.a(f());
        if (activity != 0) {
            a(1);
        }
        if (activity == 0 && (hVar = i.f13093a) != null && hVar.n().a(16)) {
            activity = sg.bigo.ads.common.f.b.b();
            a(2);
        }
        if (activity == 0) {
            activity = this.b.e;
        }
        if (activity != 0) {
            this.R = this.Q.a();
            if (this.S != null) {
                this.S.c(this.R);
            }
            AdSplashActivity.a(activity, this);
        }
    }

    static /* synthetic */ void a(b bVar, ViewGroup viewGroup) {
        g gVar;
        View viewFindViewById;
        sg.bigo.ads.ad.splash.a.a aVar = bVar.B;
        if (aVar != null && (viewFindViewById = aVar.b.findViewById(R.id.layout_playable_loading)) != null && viewFindViewById.getVisibility() == 0) {
            viewFindViewById.setVisibility(4);
        }
        if (!bVar.Q() || (gVar = bVar.u) == null || !gVar.e() || bVar.u.d) {
            return;
        }
        sg.bigo.ads.ad.splash.a.a aVar2 = bVar.B;
        if (aVar2 != null) {
            aVar2.a(false, viewGroup, -1);
        }
        bVar.u.e = 2;
        bVar.u.a(true, viewGroup, 14);
    }

    static /* synthetic */ void a(b bVar, boolean z) {
        h hVar = bVar.A;
        if (hVar != null) {
            hVar.a(z);
        }
        sg.bigo.ads.ad.splash.a.a aVar = bVar.B;
        if (aVar != null) {
            aVar.a(z);
        }
        g gVar = bVar.u;
        if (gVar != null) {
            gVar.a(z);
        }
        if (!z) {
            n nVar = bVar.L;
            if (nVar != null) {
                nVar.d();
                return;
            }
            return;
        }
        n nVar2 = bVar.L;
        if (nVar2 == null || !nVar2.e()) {
            return;
        }
        bVar.L.c();
    }

    private void b(final ViewGroup viewGroup) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setTag("adview_background_main_tag");
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        u.a(imageView, viewGroup, null, 0);
        m mVar = this.y;
        if (mVar != null && 5 != mVar.a("video_play_page.background_colour")) {
            a.a(this.y.a("video_play_page.background_colour"), this.v, viewGroup);
            return;
        }
        v vVar = new v() { // from class: sg.bigo.ads.ad.splash.b.3
            @Override // sg.bigo.ads.ad.interstitial.v
            public final void a() {
                final Bitmap bitmap = sg.bigo.ads.ad.splash.a.b.j;
                if (b.this.h || bitmap == null) {
                    return;
                }
                sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        final ImageView imageView2;
                        View viewFindViewWithTag = viewGroup.findViewWithTag("adview_background_main_tag");
                        if (viewFindViewWithTag instanceof ImageView) {
                            imageView2 = (ImageView) viewFindViewWithTag;
                        } else {
                            Context context = viewGroup.getContext();
                            if (context != null) {
                                ImageView imageView3 = new ImageView(context);
                                imageView3.setTag("adview_background_main_tag");
                                imageView3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                u.a(imageView3, viewGroup, null, 0);
                                imageView2 = imageView3;
                            } else {
                                imageView2 = null;
                            }
                        }
                        if (imageView2 != null) {
                            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            sg.bigo.ads.common.utils.d.a(imageView2.getContext(), bitmap, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.splash.b.3.1.1
                                @Override // android.webkit.ValueCallback
                                public final /* synthetic */ void onReceiveValue(Bitmap bitmap2) {
                                    Bitmap bitmap3 = bitmap2;
                                    if (bitmap3 != null) {
                                        imageView2.setImageBitmap(bitmap3);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        };
        h hVar = this.A;
        if (hVar != null) {
            hVar.a(vVar);
        }
    }

    public final boolean A() {
        ViewGroup viewGroup;
        if (!O() || (viewGroup = this.E) == null || !(viewGroup.getContext() instanceof AdSplashActivity)) {
            return false;
        }
        d(9);
        return true;
    }

    public final boolean C() {
        m mVar;
        if (a.b() || (mVar = this.y) == null || mVar.a("endpage.endpage_timing", 0) <= 0) {
            return false;
        }
        return !O() || this.y.a("endpage.close_click_seconds", 0) > 0;
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.a
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public final sg.bigo.ads.core.a.a f() {
        return (sg.bigo.ads.core.a.a) this.v.f();
    }

    public final void E() {
        g gVar = this.u;
        if (gVar == null || gVar.f13043a != sg.bigo.ads.ad.splash.a.c.a.b) {
            this.v.a(8, 22);
            return;
        }
        g gVar2 = this.u;
        Context context = this.b.e;
        if (gVar2.f && gVar2.b != null) {
            gVar2.b.f.a(context, null, null);
            return;
        }
        if (gVar2.c != null) {
            sg.bigo.ads.ad.interstitial.a.a aVar = gVar2.c;
            if (aVar.b instanceof sg.bigo.ads.ad.interstitial.a.a.b) {
                ((sg.bigo.ads.ad.interstitial.a.a.b) aVar.b).a(context, null, null);
            } else if (aVar.b instanceof sg.bigo.ads.ad.interstitial.a.a.c) {
                ((sg.bigo.ads.ad.interstitial.a.a.c) aVar.b).a(context, (sg.bigo.ads.common.i) null);
            }
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(int i) {
        super.a(i);
        this.v.a(i);
    }

    public final void a(int i, int i2) {
        g gVar;
        g gVar2;
        final ViewGroup viewGroup = this.E;
        h hVar = this.A;
        if (hVar == null || viewGroup == null) {
            return;
        }
        if (this.B != null && hVar.d() == sg.bigo.ads.ad.splash.a.c.a.b) {
            this.A.a(false, viewGroup, -1);
        }
        if (Q() && (gVar2 = this.u) != null && gVar2.e() && !this.u.d) {
            this.u.e = 2;
            this.u.a(true, viewGroup, i2);
            N();
            return;
        }
        sg.bigo.ads.ad.splash.a.a aVar = this.B;
        if (aVar == null || aVar.c != sg.bigo.ads.ad.splash.a.c.a.c || ((gVar = this.u) != null && gVar.e == 2)) {
            d(i);
            return;
        }
        this.B.a(true, viewGroup, i2);
        N();
        if (this.u == null || !i.f13093a.p().a()) {
            M();
            return;
        }
        g gVar3 = this.u;
        Runnable runnable = this.K;
        if (runnable == null) {
            runnable = new Runnable() { // from class: sg.bigo.ads.ad.splash.b.11
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.h) {
                        return;
                    }
                    sg.bigo.ads.common.n.d.a(b.this.J);
                    if (b.this.u != null) {
                        b.this.u.a(this);
                    }
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.b.11.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.a(b.this, viewGroup);
                        }
                    });
                }
            };
            this.K = runnable;
        }
        if (gVar3.b != null) {
            gVar3.b.c = runnable;
        }
        int iB = i.f13093a.p().b();
        if (iB > 0) {
            Runnable runnable2 = this.J;
            if (runnable2 == null) {
                runnable2 = new Runnable() { // from class: sg.bigo.ads.ad.splash.b.12
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (b.this.h) {
                            return;
                        }
                        b.this.M();
                        b.a(b.this, viewGroup);
                    }
                };
                this.J = runnable2;
            }
            sg.bigo.ads.common.n.d.a(2, runnable2, ((long) iB) * 1000);
        }
    }

    protected final void a(ViewGroup viewGroup) {
        g gVar;
        String str;
        if (this.A != null) {
            sg.bigo.ads.api.core.g gVar2 = this.z;
            if (gVar2 != null) {
                sg.bigo.ads.core.d.b.a(gVar2.f13106a, this);
            }
            if (isExpired()) {
                str = "The ad is expired.";
            } else {
                if (!this.h) {
                    ViewGroup viewGroup2 = (ViewGroup) sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.layout.bigo_ad_splash_style_root, null, false);
                    u.a(viewGroup2, viewGroup, new ViewGroup.LayoutParams(-1, -1), -1);
                    ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.bigo_ad_splash_ad_container);
                    this.E = viewGroup3;
                    this.F = (AdCountDownButton) viewGroup2.findViewById(R.id.bigo_ad_splash_btn_skip);
                    b(viewGroup3);
                    if (P() && (gVar = this.u) != null && gVar.e()) {
                        this.u.e = 1;
                        this.u.a(true, viewGroup3, 11);
                    } else {
                        this.A.a(true, viewGroup3, -1);
                    }
                    G();
                    return;
                }
                str = "The ad is destroyed.";
            }
            a(2000, str);
        }
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.d
    public final void a(final sg.bigo.ads.api.b.d.a<SplashAd> aVar) {
        super.a(aVar);
        m mVar = this.y;
        if (mVar != null && mVar.a("video_play_page.background_colour") == 4) {
            this.v.b(true);
        }
        this.v.a(new sg.bigo.ads.api.b.d.a<NativeAd>() { // from class: sg.bigo.ads.ad.splash.b.4
            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad) {
                if (b.this.e || b.this.f) {
                    return;
                }
                aVar.a(b.this);
                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.splash.b.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if ((b.this.P() || b.this.Q()) && b.this.u == null) {
                            b bVar = b.this;
                            m unused = b.this.D;
                            m unused2 = b.this.y;
                            bVar.u = new g(b.this, b.this.z.b, b.this.z.f13106a);
                        }
                    }
                });
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad, int i, int i2, String str) {
                if (b.this.e || b.this.f) {
                    return;
                }
                if (i == 1006) {
                    sg.bigo.ads.controller.c.a.a(b.this.z == null ? "" : b.this.z.b.l());
                }
                aVar.a(b.this, i, i2, str);
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad, boolean z, int i, int i2, String str, boolean z2) {
                NativeAd nativeAd = (NativeAd) ad;
                if (b.this.e || b.this.f || !(nativeAd instanceof sg.bigo.ads.ad.b.d)) {
                    return;
                }
                if (((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.b.d) nativeAd).f()).bg() != null || z) {
                    aVar.a(b.this);
                } else {
                    aVar.a(b.this, i, i2, str);
                }
            }
        });
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(boolean z, boolean z2) {
        super.a(z, z2);
        this.v.a(z, z2);
    }

    @Override // sg.bigo.ads.ad.c
    public final <ValueType> ValueType b(String str, ValueType valuetype) {
        return (ValueType) this.v.b(str, valuetype);
    }

    @Override // sg.bigo.ads.api.b.a
    public final p c_() {
        sg.bigo.ads.ad.b.c cVar = this.v;
        return cVar != null ? cVar.c_() : this.U;
    }

    public final void d(int i) {
        this.x.onAdSkipped();
        if (this.z != null) {
            this.V += SystemClock.elapsedRealtime() - this.W;
            sg.bigo.ads.core.d.b.a(this.z.f13106a, i, this.C > 0 ? SystemClock.elapsedRealtime() - this.C : 0L, this.V, this);
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        a.b = false;
        a.f13002a = false;
        super.destroyInMainThread();
        this.v.destroy();
        n nVar = this.L;
        if (nVar != null) {
            nVar.b();
            this.L = null;
        }
        Runnable runnable = this.H;
        if (runnable != null) {
            sg.bigo.ads.common.n.d.b(runnable);
            this.H = null;
        }
        Runnable runnable2 = this.I;
        if (runnable2 != null) {
            sg.bigo.ads.common.n.d.a(runnable2);
            this.I = null;
        }
        h hVar = this.A;
        if (hVar != null) {
            hVar.c();
            this.A = null;
        }
        sg.bigo.ads.ad.splash.a.a aVar = this.B;
        if (aVar != null) {
            aVar.c();
            this.B = null;
        }
        a.a();
        M();
        this.E = null;
    }

    @Override // sg.bigo.ads.api.Ad
    public final String getCreativeId() {
        return this.v.getCreativeId();
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad
    public final String getExtraInfo(String str) {
        return null;
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final SplashAd.Style getStyle() {
        return a.c(this.D);
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad
    public final boolean isExpired() {
        return false;
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final boolean isSkippable() {
        return this.w || isExpired() || this.h;
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final void setAdInteractionListener(SplashAdInteractionListener splashAdInteractionListener) {
        super.setAdInteractionListener((AdInteractionListener) splashAdInteractionListener);
        this.x.b = splashAdInteractionListener;
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final void show() {
        a((Activity) null, true);
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final void show(Activity activity) {
        a(activity, false);
    }

    @Override // sg.bigo.ads.api.SplashAd
    public final void showInAdContainer(ViewGroup viewGroup) {
        this.v.d(2);
        a(viewGroup);
    }

    public final void x() {
        m mVar;
        AdCountDownButton adCountDownButton = this.F;
        if (adCountDownButton == null) {
            this.w = true;
            this.x.onAdFinished();
            return;
        }
        adCountDownButton.setVisibility(0);
        m mVar2 = this.y;
        a.a(this.F, mVar2 == null ? 1 : mVar2.a("video_play_page.close_button_style"));
        int iMax = Math.max(0, this.D.a("splash_duration"));
        h hVar = this.A;
        if (hVar != null && hVar.i().get() && f().bg() == null && (mVar = this.y) != null) {
            iMax = w.b(mVar.a("video_play_page.time_for_show_backup", -1));
        }
        this.G = new n(((long) iMax) * 1000) { // from class: sg.bigo.ads.ad.splash.b.5
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                if (b.this.F.c) {
                    if (b.this.C() || !b.this.A()) {
                        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.b.5.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (b.this.A != null) {
                                    b.this.A.j();
                                }
                            }
                        });
                    }
                    b.this.F.d();
                }
                b.this.w = true;
                b.this.x.onAdFinished();
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
                b.this.F.a(j);
            }
        };
        int iMax2 = Math.max(0, this.D.a("splash_close"));
        this.F.setWithUnit(true);
        this.F.setTakeoverTickEvent(true);
        this.F.setOnCloseListener(new AdCountDownButton.a() { // from class: sg.bigo.ads.ad.splash.b.6
            @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.a
            public final void a() {
                int i;
                if (b.this.y == null) {
                    b.this.d(8);
                    return;
                }
                if (!b.this.C()) {
                    b.this.d(8);
                    return;
                }
                if (b.this.Q()) {
                    i = 1 == ((sg.bigo.ads.core.a.a) b.this.v.f()).ad() ? 4 : 5;
                } else {
                    i = 2;
                }
                b.this.a(i, 2);
            }
        });
        h hVar2 = this.A;
        if (hVar2 != null && hVar2.i().get() && f().bg() == null) {
            AdCountDownButton adCountDownButton2 = this.F;
            adCountDownButton2.h.setVisibility(0);
            adCountDownButton2.g.setVisibility(0);
            adCountDownButton2.e();
        } else {
            this.F.a(iMax2, new AdCountDownButton.b() { // from class: sg.bigo.ads.ad.splash.b.7
                @Override // sg.bigo.ads.ad.interstitial.AdCountDownButton.b
                public final void a() {
                    b.this.w = true;
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.splash.b.7.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (b.this.A != null) {
                                b.this.A.j();
                            }
                        }
                    });
                }
            });
        }
        this.G.c();
        final ViewTreeObserver viewTreeObserver = this.F.getViewTreeObserver();
        final ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: sg.bigo.ads.ad.splash.b.8
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                if (b.this.v.h) {
                    return;
                }
                boolean zIsAttachedToWindow = b.this.F.isAttachedToWindow();
                if (z && zIsAttachedToWindow) {
                    b.a(b.this, true);
                    b.this.z();
                } else {
                    b.a(b.this, false);
                    b.this.y();
                }
            }
        };
        viewTreeObserver.addOnWindowFocusChangeListener(onWindowFocusChangeListener);
        this.H = new Runnable() { // from class: sg.bigo.ads.ad.splash.b.9
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    viewTreeObserver.removeOnWindowFocusChangeListener(onWindowFocusChangeListener);
                } catch (Throwable unused) {
                }
            }
        };
    }

    public final void y() {
        AdCountDownButton adCountDownButton = this.F;
        if (adCountDownButton != null && !adCountDownButton.c) {
            this.F.b();
        }
        n nVar = this.G;
        if (nVar != null && !nVar.e()) {
            this.G.d();
            this.V += SystemClock.elapsedRealtime() - this.W;
        }
        if (this.v.getVideoController() == null || !this.v.getVideoController().isPlaying()) {
            return;
        }
        this.v.getVideoController().pause();
    }

    public final void z() {
        AdCountDownButton adCountDownButton = this.F;
        if (adCountDownButton != null && !adCountDownButton.c) {
            this.F.c();
        }
        n nVar = this.G;
        if (nVar != null && nVar.e()) {
            this.G.c();
        }
        if (this.v.getVideoController() != null && this.v.getVideoController().isPaused()) {
            this.v.getVideoController().play();
        }
        this.W = SystemClock.elapsedRealtime();
    }
}
