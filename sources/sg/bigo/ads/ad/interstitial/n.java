package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.InterstitialAd;

/* JADX INFO: loaded from: classes8.dex */
public class n extends k<sg.bigo.ads.api.core.i> {
    private final AtomicBoolean A;
    public final sg.bigo.ads.ad.banner.c<n> w;
    sg.bigo.ads.ad.banner.g x;
    private final boolean y;
    private boolean z;

    public n(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        try {
            sg.bigo.ads.api.core.i iVar = (sg.bigo.ads.api.core.i) f();
            this.A = new AtomicBoolean(false);
            boolean zAu = iVar.au();
            this.y = zAu;
            sg.bigo.ads.ad.banner.c<n> cVar = new sg.bigo.ads.ad.banner.c<>(this.b.e, gVar, this, iVar, B(), new sg.bigo.ads.ad.banner.g() { // from class: sg.bigo.ads.ad.interstitial.n.1
                @Override // sg.bigo.ads.ad.banner.g
                public final void a() {
                    if (n.this.x != null) {
                        n.this.x.a();
                    }
                }

                @Override // sg.bigo.ads.ad.banner.g
                public final void a(String str) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialBannerAd", "InterstitialBannerAd onCustomJsOmImpression, adSessionId=".concat(String.valueOf(str)));
                    n.this.C();
                    sg.bigo.ads.core.d.b.a(n.this.b.f13106a, (String) n.this.b("show_proportion", ""), n.this.i(), ((Integer) n.this.b("render_style", 0)).intValue());
                }

                @Override // sg.bigo.ads.ad.banner.g
                public final void a(sg.bigo.ads.common.i iVar2, sg.bigo.ads.api.core.e eVar) {
                    n.this.a(iVar2, eVar);
                }

                @Override // sg.bigo.ads.ad.banner.g
                public final void b() {
                    n.d(n.this);
                    if (n.this.n()) {
                        n.this.C();
                    }
                }
            }, zAu);
            this.w = cVar;
            cVar.b = 0;
        } catch (Exception unused) {
            throw new IllegalArgumentException("Error data type for ad!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.A.compareAndSet(false, true)) {
            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialBannerAd", "InterstitialBannerAd report impression AdEvent");
            super.l();
        }
    }

    static /* synthetic */ boolean d(n nVar) {
        nVar.z = true;
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    protected Class<? extends sg.bigo.ads.controller.e.b<?>> A() {
        return m.class;
    }

    protected sg.bigo.ads.core.mraid.n B() {
        return sg.bigo.ads.core.mraid.n.INTERSTITIAL;
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    protected final void b(Activity activity) {
        super.b(activity);
        sg.bigo.ads.ad.banner.c<n> cVar = this.w;
        if (cVar != null) {
            cVar.n = new WeakReference<>(activity);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    protected void b(sg.bigo.ads.api.b.d.a<InterstitialAd> aVar) {
        sg.bigo.ads.api.core.c cVar = this.b.f13106a;
        if (!(cVar instanceof sg.bigo.ads.api.core.i)) {
            aVar.a(this, 1021, 1250, "InterstitialBannerAd with invalid AdData class type.");
            return;
        }
        sg.bigo.ads.api.core.i iVar = (sg.bigo.ads.api.core.i) cVar;
        if (iVar.av() == null || TextUtils.isEmpty(iVar.av().c())) {
            aVar.a(this, 1022, 1252, "Empty content.");
        } else {
            this.w.a(new sg.bigo.ads.api.b.a.InterfaceC0855a() { // from class: sg.bigo.ads.ad.interstitial.n.2
                @Override // sg.bigo.ads.api.b.a.InterfaceC0855a
                public final void a(sg.bigo.ads.api.core.d dVar) {
                }

                @Override // sg.bigo.ads.api.b.a.InterfaceC0855a
                public final void b() {
                }
            });
            aVar.a(this);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.k, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public void destroyInMainThread() {
        this.x = null;
        super.destroyInMainThread();
        this.w.a();
    }

    @Override // sg.bigo.ads.api.Ad
    public String getCreativeId() {
        sg.bigo.ads.ad.banner.c<n> cVar = this.w;
        return cVar != null ? cVar.d() : "";
    }

    @Override // sg.bigo.ads.ad.c
    public final void h() {
        super.h();
        sg.bigo.ads.ad.banner.c<n> cVar = this.w;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final void l() {
        if (!this.y || this.z) {
            C();
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialBannerAd", "BannerAd report impression AdEvent depend on om callback.");
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final void m() {
        super.m();
        C();
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    protected final boolean y() {
        return false;
    }
}
