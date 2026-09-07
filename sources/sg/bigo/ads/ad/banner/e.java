package sg.bigo.ads.ad.banner;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.BannerAd;
import sg.bigo.ads.api.InnerBannerAd;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.core.mraid.n;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends sg.bigo.ads.ad.d<InnerBannerAd, i> implements InnerBannerAd {
    private boolean A;
    private AdError[] B;
    private boolean C;
    private c<BannerAd> v;
    private FrameLayout w;
    private boolean x;
    private boolean y;
    private final AtomicBoolean z;

    public e(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        this.B = new AdError[1];
        this.C = false;
        this.z = new AtomicBoolean(false);
        if (gVar.f13106a.w() == 3) {
            this.v = a(gVar, this.B);
        }
    }

    private boolean A() {
        try {
            return ((i) f()).ay();
        } catch (Exception unused) {
            return false;
        }
    }

    private c<BannerAd> a(sg.bigo.ads.api.core.g gVar, AdError[] adErrorArr) {
        try {
            i iVar = (i) f();
            this.x = iVar.au();
            Context context = this.b.e;
            int iC = gVar.c.c();
            return new c<>(context, gVar, this, iVar, (iC == 3 || iC == 4) ? n.INTERSTITIAL : n.INLINE, new g() { // from class: sg.bigo.ads.ad.banner.e.1
                @Override // sg.bigo.ads.ad.banner.g
                public final void a() {
                }

                /* JADX WARN: Type inference failed for: r6v5, types: [sg.bigo.ads.api.core.c] */
                @Override // sg.bigo.ads.ad.banner.g
                public final void a(String str) {
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "BannerAd onCustomJsOmImpression, adSessionId=".concat(String.valueOf(str)));
                    e.this.z();
                    sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) e.this.f(), (String) e.this.b("show_proportion", ""), e.this.i(), ((Integer) e.this.b("render_style", 0)).intValue());
                }

                @Override // sg.bigo.ads.ad.banner.g
                public final void a(sg.bigo.ads.common.i iVar2, sg.bigo.ads.api.core.e eVar) {
                    e.this.a(iVar2, eVar);
                }

                @Override // sg.bigo.ads.ad.banner.g
                public final void b() {
                    e.b(e.this);
                    if (e.this.n()) {
                        e.this.z();
                    }
                }
            }, this.x);
        } catch (Exception unused) {
            adErrorArr[0] = new AdError(1200, "Unable to init banner ad due to invalid ad data");
            return null;
        }
    }

    private void a(boolean z) {
        if (this.v == null) {
            return;
        }
        final i iVar = (i) f();
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final sg.bigo.ads.api.b.a.InterfaceC0855a interfaceC0855a = new sg.bigo.ads.api.b.a.InterfaceC0855a() { // from class: sg.bigo.ads.ad.banner.e.3
            @Override // sg.bigo.ads.api.b.a.InterfaceC0855a
            public final void a(sg.bigo.ads.api.core.d dVar) {
                sg.bigo.ads.core.d.b.a(iVar, "banner_load_cost", SystemClock.elapsedRealtime() - jElapsedRealtime, 0, (Map<String, String>) null);
                sg.bigo.ads.common.t.a.a(1, 5, "BannerAd", "Failed to load banner media.");
            }

            @Override // sg.bigo.ads.api.b.a.InterfaceC0855a
            public final void b() {
                sg.bigo.ads.core.d.b.a(iVar, "banner_load_cost", SystemClock.elapsedRealtime() - jElapsedRealtime, 1, (Map<String, String>) null);
                sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "banner load success");
            }
        };
        if (z) {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Banner load when onAdLoaded() ");
            this.v.a(interfaceC0855a);
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Banner load when adView() ");
            sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.banner.e.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (e.this.v.b(interfaceC0855a)) {
                        return;
                    }
                    interfaceC0855a.a(new sg.bigo.ads.api.core.d(3001, 10102, "Adx media load error when load"));
                }
            });
        }
    }

    static /* synthetic */ boolean b(e eVar) {
        eVar.y = true;
        return true;
    }

    private AdError x() {
        if (this.v == null) {
            AdError[] adErrorArr = this.B;
            AdError adError = adErrorArr[0];
            if (adError == null) {
                return new AdError(1201, "Failed to create html ads.");
            }
            adErrorArr[0] = null;
            return adError;
        }
        try {
            i iVar = (i) f();
            if (iVar.av() != null && !TextUtils.isEmpty(iVar.av().c())) {
                return null;
            }
            return new AdError(1202, "Empty content.");
        } catch (Exception unused) {
            return new AdError(1200, "BannerAd with invalid AdData class type.");
        }
    }

    private void y() {
        if (!this.A) {
            this.A = true;
        }
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.banner.e.2
            @Override // java.lang.Runnable
            public final void run() {
                f.a.f12546a.b(e.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.z.compareAndSet(false, true)) {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "BannerAd report impression AdEvent");
            super.l();
        }
    }

    public final void a(long j) {
        a("attach_render_cost", Long.valueOf(j));
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final View adView() {
        c<BannerAd> cVar = this.v;
        if (cVar == null) {
            return null;
        }
        if (!cVar.r) {
            a(false);
        }
        View viewC = this.v.c();
        if (this.w == null) {
            this.w = new FrameLayout(viewC.getContext());
        }
        this.w.removeAllViews();
        this.w.addView(viewC);
        t();
        a(this.w, this.C);
        return this.w;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        super.destroyInMainThread();
        c<BannerAd> cVar = this.v;
        if (cVar != null) {
            cVar.a();
        }
        y();
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) f(), SystemClock.elapsedRealtime() - this.j);
    }

    @Override // sg.bigo.ads.api.Ad
    public final String getCreativeId() {
        c<BannerAd> cVar = this.v;
        return cVar != null ? cVar.d() : "";
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final int getHeight() {
        c<BannerAd> cVar = this.v;
        if (cVar != null) {
            return (cVar.k == null || cVar.k.av() == null || cVar.k.av().a() <= 0 || cVar.k.av().b() <= 0) ? cVar.i().getHeight() : cVar.k.av().b();
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.api.InnerBannerAd
    public final sg.bigo.ads.api.core.c getInnerBannerAdData() {
        return f();
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final WebView getWebView() {
        c<BannerAd> cVar = this.v;
        if (cVar == null) {
            return null;
        }
        return cVar.f12529a;
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final int getWidth() {
        c<BannerAd> cVar = this.v;
        if (cVar != null) {
            return (cVar.k == null || cVar.k.av() == null || cVar.k.av().a() <= 0 || cVar.k.av().b() <= 0) ? cVar.i().getWidth() : cVar.k.av().a();
        }
        return 0;
    }

    @Override // sg.bigo.ads.ad.c
    public final void h() {
        c<BannerAd> cVar = this.v;
        if (cVar != null) {
            b.g(cVar);
            if (cVar.j instanceof e) {
                ((e) cVar.j).a(b.i(cVar));
            }
        }
        super.h();
        c<BannerAd> cVar2 = this.v;
        if (cVar2 != null) {
            cVar2.f();
        }
        y();
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void handleInnerBannerAdResponse(sg.bigo.ads.api.b.d.a<InnerBannerAd> aVar) {
        String str;
        this.A = false;
        AdError adErrorX = x();
        if (adErrorX != null) {
            aVar.a(this, 1005, adErrorX.getCode(), adErrorX.getMessage());
            return;
        }
        i.a aVarAw = this.v.k.aw();
        if (aVarAw != null && aVarAw.a() && !A()) {
            try {
                i iVar = (i) f();
                sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Banner load when onAdLoaded() ");
                if (f.a.f12546a.a(this)) {
                    this.A = true;
                    iVar.az();
                    a(true);
                } else {
                    str = "Banner preload limit 3 BannerAds.";
                    sg.bigo.ads.common.t.a.a(0, 5, "BannerAd", str);
                }
            } catch (Exception unused) {
                str = "Banner preload, not BannerAdData type.";
            }
        }
        aVar.a(this);
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final boolean isInnerBannerAdFromAutoRefresh() {
        return A();
    }

    @Override // sg.bigo.ads.ad.c
    public final void l() {
        if (!this.x || this.y) {
            z();
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "BannerAd report impression AdEvent depend on om callback.");
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final void m() {
        super.m();
        z();
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void markFromAutoFresh(sg.bigo.ads.api.core.c cVar) {
        this.C = true;
        if (cVar instanceof i) {
            ((i) cVar).ax();
        }
        a();
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final int updateFormOpenTimes() {
        return b_();
    }
}
