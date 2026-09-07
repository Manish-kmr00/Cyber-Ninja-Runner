package sg.bigo.ads.ad.c;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ImageView;
import sg.bigo.ads.ad.c.a.a.AnonymousClass2;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.InnerBannerAd;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.p.e;
import sg.bigo.ads.common.p.f;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.t;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements sg.bigo.ads.ad.b.c.b, InnerBannerAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private sg.bigo.ads.ad.b.c f12574a;
    private sg.bigo.ads.ad.c.b b;
    private Boolean c;
    private b d;
    private sg.bigo.ads.ad.c.a.a e;
    private c f;
    private int g;
    private int h;
    private boolean i;
    private final g j;
    private long k;
    private sg.bigo.ads.api.b.d.a<InnerBannerAd> l;
    private final a m;
    private sg.bigo.ads.ad.b.c.a n;

    class a implements AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AdInteractionListener f12577a;

        a() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClicked() {
            AdInteractionListener adInteractionListener = this.f12577a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClosed() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdError(AdError adError) {
            if (this.f12577a != null) {
                if (adError.getCode() == 2002 && d.g(d.this)) {
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerNativeAd", "don't call onAdError when video has impressed");
                } else {
                    this.f12577a.onAdError(adError);
                }
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdImpression() {
            d.this.k = SystemClock.elapsedRealtime();
            if (d.this.e != null && d.this.f != null) {
                d.this.e.a(d.this.f.b);
            }
            if (d.this.f12574a != null) {
                d.this.f12574a.a(d.this.n);
            }
            AdInteractionListener adInteractionListener = this.f12577a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdImpression();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdOpened() {
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        sg.bigo.ads.api.b.d.a<NativeAd> f12578a;
        sg.bigo.ads.api.b.d.a<NativeAd> b;

        public b(final sg.bigo.ads.api.b.d.a<InnerBannerAd> aVar) {
            this.f12578a = new sg.bigo.ads.api.b.d.a<NativeAd>() { // from class: sg.bigo.ads.ad.c.d.b.1
                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad) {
                    boolean z = false;
                    if (d.this.e == null) {
                        d.c(d.this);
                        d.this.a((sg.bigo.ads.api.b.d.a<InnerBannerAd>) aVar, 1, false);
                        return;
                    }
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerNativeAd", "native-banner icon load success");
                    d.d(d.this);
                    if (d.this.b != null) {
                        sg.bigo.ads.ad.c.a.a aVar2 = d.this.e;
                        ImageView imageView = d.this.b.f12571a;
                        if (d.this.f12574a != null && d.this.f12574a.n()) {
                            z = true;
                        }
                        aVar2.a(imageView, z);
                    }
                    d.this.a(1, 3);
                    d.this.a((sg.bigo.ads.api.b.d.a<InnerBannerAd>) aVar, 1, true);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad, int i, int i2, String str) {
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerNativeAd", "native-banner icon load failed");
                    d.c(d.this);
                    if (i2 == 10103) {
                        d.this.a(1, 1);
                    } else {
                        d.this.a(1, 4);
                    }
                    d.this.a((sg.bigo.ads.api.b.d.a<InnerBannerAd>) aVar, 1, false);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z, int i, int i2, String str, boolean z2) {
                }
            };
            this.b = new sg.bigo.ads.api.b.d.a<NativeAd>() { // from class: sg.bigo.ads.ad.c.d.b.2
                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad) {
                    NativeAd nativeAd = (NativeAd) ad;
                    boolean z = false;
                    if (d.this.e == null) {
                        d.c(d.this);
                        d.this.a((sg.bigo.ads.api.b.d.a<InnerBannerAd>) aVar, 1, false);
                        return;
                    }
                    d.d(d.this);
                    b.a(b.this, nativeAd, 3);
                    sg.bigo.ads.ad.c.a.a aVar2 = d.this.e;
                    aVar2.a(aVar2.new AnonymousClass2(), nativeAd instanceof sg.bigo.ads.ad.b.a.a);
                    sg.bigo.ads.ad.c.a.a aVar3 = d.this.e;
                    if (d.this.f12574a != null && d.this.f12574a.n()) {
                        z = true;
                    }
                    aVar3.a(z);
                    d.this.a((sg.bigo.ads.api.b.d.a<InnerBannerAd>) aVar, 1, true);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad, int i, int i2, String str) {
                    b bVar;
                    int i3;
                    NativeAd nativeAd = (NativeAd) ad;
                    sg.bigo.ads.common.t.a.a(0, 3, "BannerNativeAd", "native-banner main media load failed");
                    d.c(d.this);
                    if (i2 == 1401 || i2 == 10074 || i2 == 10103 || i2 == 1300) {
                        bVar = b.this;
                        i3 = 1;
                    } else {
                        bVar = b.this;
                        i3 = 4;
                    }
                    b.a(bVar, nativeAd, i3);
                    d.this.a((sg.bigo.ads.api.b.d.a<InnerBannerAd>) aVar, 1, false);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z, int i, int i2, String str, boolean z2) {
                }
            };
        }

        static /* synthetic */ void a(b bVar, NativeAd nativeAd, int i) {
            if (nativeAd instanceof sg.bigo.ads.ad.b.a.b) {
                d.this.a(3, i);
            } else if (nativeAd instanceof sg.bigo.ads.ad.b.a.a) {
                d.this.a(2, i);
            }
        }

        public final void a() {
            this.f12578a = null;
            this.b = null;
        }
    }

    public d(g gVar) {
        this.g = 0;
        this.h = 0;
        this.i = false;
        a aVar = new a();
        this.m = aVar;
        this.n = new sg.bigo.ads.ad.b.c.a() { // from class: sg.bigo.ads.ad.c.d.1
            @Override // sg.bigo.ads.ad.b.c.a
            public final void a() {
                if (d.this.e != null) {
                    d.this.e.f();
                }
            }
        };
        this.j = gVar;
        sg.bigo.ads.ad.b.c cVarA = sg.bigo.ads.ad.b.a.a(gVar);
        this.f12574a = cVarA;
        if (cVarA != null) {
            cVarA.setAdInteractionListener(aVar);
            this.f = new c(gVar);
            this.b = new sg.bigo.ads.ad.c.b(this.f12574a);
            i.b bVarAv = ((sg.bigo.ads.core.a.a) this.f12574a.f()).av();
            sg.bigo.ads.ad.b.c cVar = this.f12574a;
            this.e = cVar != null ? sg.bigo.ads.ad.c.a.a.a(cVar, cVar.b.f, bVarAv) : null;
            this.c = Boolean.FALSE;
            this.d = null;
            this.g = 0;
            this.h = 0;
            this.i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(sg.bigo.ads.api.b.d.a<InnerBannerAd> aVar, int i, boolean z) {
        if (aVar == null) {
            return;
        }
        if (this.c.booleanValue()) {
            return;
        }
        c cVar = this.f;
        int i2 = 2;
        if (cVar != null && cVar.f12573a == 2 && i == 2) {
            d();
            aVar.a(this);
            this.c = Boolean.TRUE;
            return;
        }
        sg.bigo.ads.ad.b.c cVar2 = this.f12574a;
        if (cVar2 != null && ((sg.bigo.ads.core.a.a) cVar2.f()).aQ()) {
            i2 = 3;
        }
        if (!z) {
            if (this.h == i2 || this.i) {
                if (this.i) {
                    aVar.a(this, 1005, 1006, "native banner VAST parse failed");
                } else {
                    aVar.a(this, 1005, 1253, "native banner download icon & main resources all failed");
                }
            }
        }
        d();
        aVar.a(this);
        this.c = Boolean.TRUE;
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.h;
        dVar.h = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a();
            this.d = null;
        }
        sg.bigo.ads.ad.c.a.a aVar = this.e;
        if (aVar != null) {
            aVar.h();
        }
        sg.bigo.ads.ad.c.b bVar2 = this.b;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    static /* synthetic */ int d(d dVar) {
        int i = dVar.g;
        dVar.g = i + 1;
        return i;
    }

    private void d() {
        sg.bigo.ads.ad.c.b bVar;
        sg.bigo.ads.ad.c.a.a aVar = this.e;
        if (aVar == null || (bVar = this.b) == null) {
            return;
        }
        aVar.a(bVar.f12571a, e());
    }

    private int e() {
        c cVar = this.f;
        return (cVar == null || cVar.c != 2) ? 3 : 1;
    }

    static /* synthetic */ boolean g(d dVar) {
        sg.bigo.ads.ad.b.c cVar = dVar.f12574a;
        return cVar != null && cVar.n();
    }

    @Override // sg.bigo.ads.ad.b.c.b
    public final void a() {
        a(this.l, 2, false);
        final sg.bigo.ads.ad.c.b bVar = this.b;
        final sg.bigo.ads.api.b.d.a<NativeAd> aVar = this.d.f12578a;
        if (bVar.b != null) {
            sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) bVar.b.f();
            if (aVar2.au() == null) {
                aVar.a(bVar.b, 3001, 10103, "banner icon is empty");
                return;
            }
            String strC = aVar2.au().c();
            if (q.a((CharSequence) strC)) {
                aVar.a(bVar.b, 3001, 10103, "banner icon url is empty");
            } else if (sg.bigo.ads.api.a.i.f13093a.n().a(9) && URLUtil.isHttpUrl(strC)) {
                aVar.a(bVar.b, 3001, 10118, "Invalid http banner icon url");
            } else {
                e.b(bVar.b.b.e, sg.bigo.ads.common.u.a.e.j(), strC, aVar2.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.c.b.1

                    /* JADX INFO: renamed from: a */
                    final /* synthetic */ sg.bigo.ads.api.b.d.a f12572a;

                    AnonymousClass1() {
                        aVar = aVar;
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i, String str, String str2) {
                        sg.bigo.ads.api.b.d.a aVar3;
                        if (b.this.b == null || b.this.f12571a == null || (aVar3 = aVar) == null) {
                            return;
                        }
                        aVar3.a(b.this.b, i, 3001, str);
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(Bitmap bitmap, f fVar) {
                        if (b.this.b == null || b.this.f12571a == null || aVar == null) {
                            return;
                        }
                        b.this.b.a(bitmap, 1);
                        b.this.f12571a.setImageBitmap(bitmap);
                        aVar.a(b.this.b);
                    }
                });
            }
        }
    }

    public final void a(int i, int i2) {
        String str;
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        if (cVar == null) {
            return;
        }
        if (i == 1) {
            str = "icon_sta";
        } else {
            if (i != 2) {
                if (i == 3 && (cVar instanceof sg.bigo.ads.ad.b.a.b)) {
                    cVar.a("vid_sta", Integer.valueOf(i2));
                    return;
                }
                return;
            }
            str = "img_sta";
        }
        cVar.a(str, Integer.valueOf(i2));
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final View adView() {
        sg.bigo.ads.ad.b.c cVar;
        String str;
        if (!sg.bigo.ads.common.n.d.b()) {
            t.a("adView() must run on UI thread");
        }
        if (this.f12574a == null) {
            return null;
        }
        if (isExpired()) {
            cVar = this.f12574a;
            str = "The ad is expired.";
        } else if (this.f12574a.h) {
            cVar = this.f12574a;
            str = "The ad is destroyed.";
        } else {
            sg.bigo.ads.ad.c.a.a aVar = this.e;
            if (aVar != null) {
                return aVar.e();
            }
            cVar = this.f12574a;
            str = "mNativeBannerRender is null.";
        }
        cVar.a(2000, str);
        return null;
    }

    @Override // sg.bigo.ads.ad.b.c.b
    public final void b() {
        this.i = true;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Ad ad) {
        Ad ad2 = ad;
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        if (cVar != null) {
            return cVar.compareTo(ad2);
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.Ad
    public final void destroy() {
        destroyInMainThread();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void destroyInMainThread() {
        if (sg.bigo.ads.common.n.d.b()) {
            c();
        } else {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.c.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.c();
                }
            });
        }
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        if (cVar != null) {
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) cVar.f(), SystemClock.elapsedRealtime() - this.k);
        }
    }

    @Override // sg.bigo.ads.api.Ad
    public final AdBid getBid() {
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        if (cVar != null) {
            return cVar.getBid();
        }
        return null;
    }

    @Override // sg.bigo.ads.api.Ad
    public final String getCreativeId() {
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        return cVar != null ? cVar.getCreativeId() : "";
    }

    @Override // sg.bigo.ads.api.Ad
    public final String getExtraInfo(String str) {
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        if (cVar != null) {
            return cVar.getExtraInfo(str);
        }
        return null;
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final int getHeight() {
        sg.bigo.ads.ad.c.a.a aVar = this.e;
        if (aVar != null) {
            return aVar.j();
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.api.InnerBannerAd
    public final sg.bigo.ads.api.core.c getInnerBannerAdData() {
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        if (cVar != null) {
            return cVar.f();
        }
        return null;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final WebView getWebView() {
        return null;
    }

    @Override // sg.bigo.ads.api.BannerAd
    public final int getWidth() {
        sg.bigo.ads.ad.c.a.a aVar = this.e;
        if (aVar != null) {
            return aVar.i();
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void handleInnerBannerAdResponse(sg.bigo.ads.api.b.d.a<InnerBannerAd> aVar) {
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        if (cVar == null) {
            aVar.a(this, 1005, 1253, "native banner mNativeAd is null");
            return;
        }
        cVar.b(true);
        this.l = aVar;
        if (this.d == null) {
            this.d = new b(aVar);
        }
        a(1, 2);
        a(2, 2);
        a(3, 2);
        sg.bigo.ads.ad.b.c cVar2 = this.f12574a;
        if (cVar2 != null) {
            cVar2.a((sg.bigo.ads.ad.b.c.b) this);
            this.f12574a.a(this.d.b, 0);
        }
    }

    @Override // sg.bigo.ads.api.Ad
    public final boolean isExpired() {
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        if (cVar != null) {
            return cVar.isExpired();
        }
        return false;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final boolean isInnerBannerAdFromAutoRefresh() {
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        if (cVar != null) {
            return ((sg.bigo.ads.core.a.a) cVar.f()).bk();
        }
        return false;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final void markFromAutoFresh(sg.bigo.ads.api.core.c cVar) {
        if (cVar instanceof o) {
            ((o) cVar).bj();
        }
        sg.bigo.ads.ad.b.c cVar2 = this.f12574a;
        if (cVar2 != null) {
            cVar2.a();
        }
    }

    @Override // sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    public final void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        this.m.f12577a = adInteractionListener;
    }

    @Override // sg.bigo.ads.api.InnerBannerAd
    public final int updateFormOpenTimes() {
        sg.bigo.ads.ad.b.c cVar = this.f12574a;
        if (cVar != null) {
            return cVar.b_();
        }
        return 0;
    }
}
