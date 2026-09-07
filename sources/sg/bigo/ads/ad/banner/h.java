package sg.bigo.ads.ad.banner;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.InnerBannerAd;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.t;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

/* JADX INFO: loaded from: classes5.dex */
public final class h extends sg.bigo.ads.ad.c<InnerBannerAd, sg.bigo.ads.api.core.c> implements InnerBannerAd, sg.bigo.ads.api.b.d<InnerBannerAd> {
    private a A;
    InnerBannerAd u;
    private FrameLayout v;
    private sg.bigo.ads.api.core.g w;
    private b x;
    private AbstractAdLoader y;
    private sg.bigo.ads.api.b.d.a<InnerBannerAd> z;

    class a implements AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AdInteractionListener f12551a;

        a() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClicked() {
            AdInteractionListener adInteractionListener = this.f12551a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClosed() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdError(AdError adError) {
            AdInteractionListener adInteractionListener = this.f12551a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdError(adError);
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdImpression() {
            AdInteractionListener adInteractionListener = this.f12551a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdImpression();
            }
            if (h.this.x != null) {
                final b bVar = h.this.x;
                sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Start auto refreshing after " + (bVar.f12552a / 1000) + " s");
                bVar.b.removeCallbacksAndMessages(null);
                bVar.b.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.banner.h.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.e(h.this);
                    }
                }, bVar.f12552a);
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdOpened() {
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12552a = 20000;
        final Handler b = new Handler(Looper.getMainLooper());

        public b() {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "Enable bigo adx banner auto refreshing");
        }
    }

    public h(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        this.A = new a();
        if (!gVar.b.w() && gVar.b.j()) {
            b bVar = new b();
            this.x = bVar;
            int iK = gVar.b.k();
            if (iK >= 10) {
                bVar.f12552a = iK * 1000;
            }
        }
        InnerBannerAd innerBannerAdB = d.b(gVar);
        this.u = innerBannerAdB;
        if (innerBannerAdB == null) {
            throw new IllegalArgumentException("UnifiedBannerWrapper Illegal adx type.");
        }
    }

    static /* synthetic */ void a(h hVar, final InnerBannerAd innerBannerAd) {
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.banner.h.2
            @Override // java.lang.Runnable
            public final void run() {
                InnerBannerAd innerBannerAd2 = innerBannerAd;
                if (innerBannerAd2 != null) {
                    innerBannerAd2.destroy();
                }
            }
        });
    }

    static /* synthetic */ void a(h hVar, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.api.core.g gVar) {
        InnerBannerAd innerBannerAdB = d.b(gVar);
        if (innerBannerAdB != null) {
            hVar.w = gVar;
            innerBannerAdB.markFromAutoFresh(cVar);
            innerBannerAdB.handleInnerBannerAdResponse(hVar.z);
        }
    }

    static /* synthetic */ void b(h hVar) {
        if (hVar.u != null) {
            hVar.a();
            hVar.b = hVar.w;
            hVar.u.setAdInteractionListener(hVar.A);
            sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.banner.h.3
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.x();
                }
            });
        }
    }

    static /* synthetic */ void e(h hVar) {
        sg.bigo.ads.api.b bVarA = hVar.b.c.a();
        if (bVarA != null) {
            bVarA.c = 1;
            final sg.bigo.ads.controller.e.a.C0884a[] c0884aArr = new sg.bigo.ads.controller.e.a.C0884a[1];
            c0884aArr[0] = BigoAdSdk.a(bVarA, new sg.bigo.ads.controller.c() { // from class: sg.bigo.ads.ad.banner.h.4
                @Override // sg.bigo.ads.controller.e
                public final /* synthetic */ void a(int i, int i2, int i3, String str, Pair<sg.bigo.ads.api.b, l> pair) {
                    sg.bigo.ads.api.b bVar;
                    int i4;
                    Pair<sg.bigo.ads.api.b, l> pair2 = pair;
                    sg.bigo.ads.common.t.a.a(2, "Banner", "Banner auto-refresh failed: ".concat(String.valueOf(str)));
                    String str2 = null;
                    if (pair2 != null) {
                        sg.bigo.ads.api.b bVar2 = (sg.bigo.ads.api.b) pair2.first;
                        if (bVar2 != null) {
                            bVar2.g.a();
                        }
                        bVar = bVar2;
                    } else {
                        bVar = null;
                    }
                    sg.bigo.ads.controller.e.a.C0884a c0884a = c0884aArr[0];
                    l lVar = pair2 != null ? (l) pair2.second : null;
                    if (c0884a == null || c0884a.g == null) {
                        i4 = 3;
                    } else {
                        i4 = c0884a.g.f13114a ? 1 : 0;
                    }
                    boolean z = (c0884a == null || c0884a.g == null || !c0884a.g.b) ? false : true;
                    int i5 = (c0884a == null || c0884a.g == null) ? 4 : c0884a.g.c;
                    if (c0884a != null && c0884a.g != null) {
                        str2 = c0884a.g.d;
                    }
                    sg.bigo.ads.core.d.b.a(lVar, bVar, i2, i3, str, 1, 0, i4, z, i5, str2);
                }

                @Override // sg.bigo.ads.controller.e
                public final /* synthetic */ void a(int i, sg.bigo.ads.api.b bVar, sg.bigo.ads.api.core.g[] gVarArr) {
                    int i2;
                    sg.bigo.ads.api.core.g gVar = (sg.bigo.ads.api.core.g) k.b(gVarArr);
                    gVar.c.g.a();
                    sg.bigo.ads.controller.e.a.C0884a c0884a = c0884aArr[0];
                    sg.bigo.ads.api.core.c[] cVarArr = {gVar.f13106a};
                    sg.bigo.ads.api.b bVar2 = gVar.c;
                    boolean z = gVar.b.s() && gVar.f13106a.ac();
                    if (c0884a == null || c0884a.g == null) {
                        i2 = 3;
                    } else {
                        i2 = c0884a.g.f13114a ? 1 : 0;
                    }
                    sg.bigo.ads.core.d.b.a(cVarArr, bVar2, z, 1, 0, i2, (c0884a == null || c0884a.g == null || !c0884a.g.b) ? false : true, (c0884a == null || c0884a.g == null) ? 4 : c0884a.g.c, (c0884a == null || c0884a.g == null) ? null : c0884a.g.d);
                    h.a(h.this, gVar.f13106a, gVar);
                }
            });
        }
        sg.bigo.ads.common.t.a.a(0, 3, "Banner", "Start auto refreshing for bigo adx banner");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View x() {
        if (this.v == null) {
            this.v = new FrameLayout(this.b.e);
        }
        if (this.u == null) {
            return null;
        }
        this.v.removeAllViews();
        u.a(this.u.adView(), this.v, null, -1);
        return this.v;
    }

    @Override // sg.bigo.ads.api.b.a, java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public final int compareTo(Ad ad) {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            return innerBannerAd.compareTo(ad);
        }
        return 0;
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.d
    public final void a(final sg.bigo.ads.api.b.d.a<InnerBannerAd> aVar) {
        super.a(aVar);
        if (this.y == null && (aVar instanceof AbstractAdLoader.b)) {
            this.y = ((AbstractAdLoader.b) aVar).a();
        }
        sg.bigo.ads.api.b.d.a<InnerBannerAd> aVar2 = new sg.bigo.ads.api.b.d.a<InnerBannerAd>() { // from class: sg.bigo.ads.ad.banner.h.1
            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad) {
                InnerBannerAd innerBannerAd = (InnerBannerAd) ad;
                if (h.this.u != null && h.this.u != innerBannerAd) {
                    h.a(h.this, h.this.u);
                }
                h.this.u = innerBannerAd;
                if (!innerBannerAd.isInnerBannerAdFromAutoRefresh()) {
                    aVar.a(h.this);
                    return;
                }
                h.b(h.this);
                if (h.this.y != null) {
                    h.this.y.a((Ad) h.this, true);
                }
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad, int i, int i2, String str) {
                InnerBannerAd innerBannerAd = (InnerBannerAd) ad;
                if (innerBannerAd == null || !innerBannerAd.isInnerBannerAdFromAutoRefresh()) {
                    aVar.a(h.this, i, i2, str);
                } else {
                    h.this.a(i, i2, str);
                }
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z, int i, int i2, String str, boolean z2) {
                aVar.a(h.this, z, i, i2, str, z2);
            }
        };
        this.z = aVar2;
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            innerBannerAd.handleInnerBannerAdResponse(aVar2);
        } else {
            aVar.a(this, 1005, 1200, "banner adx_type error");
        }
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final View adView() {
        String str;
        if (!sg.bigo.ads.common.n.d.b()) {
            t.a("adView() must run on UI thread");
        }
        if (isExpired()) {
            str = "The ad is expired.";
        } else {
            if (!this.h) {
                FrameLayout frameLayout = this.v;
                return frameLayout != null ? frameLayout : x();
            }
            str = "The ad is destroyed.";
        }
        a(2000, str);
        return null;
    }

    @Override // sg.bigo.ads.api.b.a
    public final int b_() {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            return innerBannerAd.updateFormOpenTimes();
        }
        return 0;
    }

    @Override // sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        super.destroyInMainThread();
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            innerBannerAd.destroy();
        }
        b bVar = this.x;
        if (bVar != null) {
            sg.bigo.ads.common.t.a.a(0, 3, "BannerAd", "bigo adx banner auto refreshing stop");
            bVar.b.removeCallbacksAndMessages(null);
        }
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.a
    public final sg.bigo.ads.api.core.c f() {
        return getInnerBannerAdData();
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad
    public final AdBid getBid() {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            return innerBannerAd.getBid();
        }
        return null;
    }

    @Override // sg.bigo.ads.api.Ad
    public final String getCreativeId() {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            return innerBannerAd.getCreativeId();
        }
        return null;
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad
    public final String getExtraInfo(String str) {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            return innerBannerAd.getExtraInfo(str);
        }
        return null;
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final int getHeight() {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            return innerBannerAd.getHeight();
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final sg.bigo.ads.api.core.c getInnerBannerAdData() {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            return innerBannerAd.getInnerBannerAdData();
        }
        return null;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final WebView getWebView() {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd == null) {
            return null;
        }
        return innerBannerAd.getWebView();
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final int getWidth() {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            return innerBannerAd.getWidth();
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void handleInnerBannerAdResponse(sg.bigo.ads.api.b.d.a<InnerBannerAd> aVar) {
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad
    public final boolean isExpired() {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            return innerBannerAd.isExpired();
        }
        return false;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final boolean isInnerBannerAdFromAutoRefresh() {
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            return innerBannerAd.isInnerBannerAdFromAutoRefresh();
        }
        return false;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void markFromAutoFresh(sg.bigo.ads.api.core.c cVar) {
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    public final void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        super.setAdInteractionListener(adInteractionListener);
        this.A.f12551a = adInteractionListener;
        InnerBannerAd innerBannerAd = this.u;
        if (innerBannerAd != null) {
            innerBannerAd.setAdInteractionListener(this.A);
        }
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final int updateFormOpenTimes() {
        return 0;
    }
}
