package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import android.util.Pair;
import android.webkit.ValueCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.NativeAd;

/* JADX INFO: loaded from: classes8.dex */
public class s extends k<sg.bigo.ads.core.a.a> {
    l A;
    private final a B;
    private final Map<sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.interstitial.multi_img.b> C;
    private final Map<sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.interstitial.multi_img.b> D;
    public sg.bigo.ads.ad.b.c w;
    public sg.bigo.ads.ad.interstitial.a.b x;
    public sg.bigo.ads.ad.interstitial.a.a y;
    b z;

    class a implements AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AdInteractionListener f12934a;

        a() {
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClicked() {
            AdInteractionListener adInteractionListener = this.f12934a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
            if (s.this.v != null) {
                s.this.v.C();
            }
            if (s.this.A != null) {
                s.this.A.k = SystemClock.elapsedRealtime();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdClosed() {
            AdInteractionListener adInteractionListener = this.f12934a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdError(AdError adError) {
            if (this.f12934a != null) {
                if (adError.getCode() == 2002 && s.this.n()) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialNativeImpl", "don't call onAdError when video has impressed");
                } else {
                    this.f12934a.onAdError(adError);
                }
            }
            if (adError.getCode() != 2002 || s.this.v == null) {
                return;
            }
            s.this.v.b(adError.getMessage());
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdImpression() {
            AdInteractionListener adInteractionListener = this.f12934a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdImpression();
            }
            if (s.this.A != null) {
                s.this.A.l = SystemClock.elapsedRealtime();
            }
            sg.bigo.ads.ad.interstitial.multi_img.b bVarC = s.this.C();
            if (bVarC != null) {
                bVarC.b();
            }
            sg.bigo.ads.ad.interstitial.multi_img.b bVarD = s.this.D();
            if (bVarD != null) {
                bVarD.b();
            }
        }

        @Override // sg.bigo.ads.api.AdInteractionListener
        public final void onAdOpened() {
            AdInteractionListener adInteractionListener = this.f12934a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdOpened();
            }
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map<NativeAd, Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a>> f12935a;

        b() {
        }
    }

    public s(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        a aVar = new a();
        this.B = aVar;
        this.C = new HashMap();
        this.D = new HashMap();
        sg.bigo.ads.ad.b.c cVarA = sg.bigo.ads.ad.b.a.a(gVar);
        if (cVarA == null) {
            throw new IllegalArgumentException("Illegal adx type.");
        }
        this.w = cVarA;
        cVarA.a(true);
        if (this.w instanceof sg.bigo.ads.ad.b.b) {
            this.z = new b();
        }
        this.w.setAdInteractionListener(aVar);
        a((sg.bigo.ads.api.b.a) cVarA);
    }

    static /* synthetic */ Pair a(s sVar, NativeAd nativeAd, sg.bigo.ads.api.a.l lVar, sg.bigo.ads.api.core.c cVar) {
        int i;
        boolean z = nativeAd instanceof sg.bigo.ads.ad.b.d;
        sg.bigo.ads.ad.interstitial.a.b bVar = new sg.bigo.ads.ad.interstitial.a.b(sVar, lVar, cVar, z ? ((sg.bigo.ads.ad.b.d) nativeAd).H : null, z ? ((sg.bigo.ads.ad.b.d) nativeAd).I : null);
        sg.bigo.ads.ad.interstitial.a.a aVar = new sg.bigo.ads.ad.interstitial.a.a(bVar.f12644a, sVar, lVar, cVar, z ? ((sg.bigo.ads.ad.b.d) nativeAd).H : null, z ? ((sg.bigo.ads.ad.b.d) nativeAd).I : null);
        if (bVar.f12644a) {
            i = 1;
        } else {
            i = aVar.f12630a ? 2 : 0;
        }
        if (cVar.e() != null) {
            i = cVar.h() ? i : 0;
        }
        cVar.d(i);
        cVar.e((bVar.f12644a || (aVar.b instanceof sg.bigo.ads.ad.interstitial.a.a.b)) ? 1 : 2);
        return new Pair(bVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sg.bigo.ads.ad.b.c cVar, int i) {
        while (cVar != null && i <= 5) {
            if (!(cVar instanceof sg.bigo.ads.ad.b.b)) {
                sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) cVar.f();
                sg.bigo.ads.api.a.m mVarE = aVar.e();
                sg.bigo.ads.ad.interstitial.multi_img.b bVarB = sg.bigo.ads.ad.interstitial.multi_img.b.b(cVar, mVarE);
                if (bVarB != null) {
                    this.C.put(cVar, bVarB);
                }
                sg.bigo.ads.ad.interstitial.multi_img.b bVarA = sg.bigo.ads.ad.interstitial.multi_img.b.a(cVar, mVarE);
                if (bVarA != null) {
                    this.D.put(cVar, bVarA);
                }
                if (bVarB == null && bVarA == null) {
                    return;
                }
                if (bVarB != null && bVarB.g == 1) {
                    bVarB.b();
                    return;
                }
                if (bVarA != null && bVarA.g == 1) {
                    bVarA.b();
                    return;
                }
                if (bVarB != null && bVarB.g == 2) {
                    a(aVar, bVarB);
                    return;
                } else {
                    if (bVarA == null || bVarA.g != 2) {
                        return;
                    }
                    a(aVar, bVarA);
                    return;
                }
            }
            sg.bigo.ads.ad.b.b bVar = (sg.bigo.ads.ad.b.b) cVar;
            i++;
            a(bVar.v, i);
            cVar = bVar.w;
        }
    }

    private void a(sg.bigo.ads.core.a.a aVar, final sg.bigo.ads.ad.interstitial.multi_img.b bVar) {
        if (aVar.aQ()) {
            sg.bigo.ads.core.player.b.a().a(aVar.aO(), new ValueCallback<Boolean>() { // from class: sg.bigo.ads.ad.interstitial.s.2
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Boolean bool) {
                    if (!bool.booleanValue()) {
                        bVar.b();
                    }
                }
            });
            return;
        }
        if (sg.bigo.ads.common.p.h.a.f13258a.a(aVar.aS())) {
            return;
        }
        bVar.b();
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    protected Class<? extends sg.bigo.ads.controller.e.b<?>> A() {
        if (y()) {
            return F() ? sg.bigo.ads.ad.interstitial.h.a.class : y.class;
        }
        return x.class;
    }

    public final sg.bigo.ads.ad.interstitial.multi_img.b C() {
        sg.bigo.ads.ad.b.c cVar = this.w;
        if (cVar instanceof sg.bigo.ads.ad.b.b) {
            return null;
        }
        sg.bigo.ads.ad.interstitial.multi_img.b bVarB = this.C.get(cVar);
        if (bVarB == null) {
            sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) this.w.f();
            if (aVar != null) {
                bVarB = sg.bigo.ads.ad.interstitial.multi_img.b.b(this.w, aVar.e());
            }
            if (bVarB != null) {
                this.C.put(this.w, bVarB);
            }
        }
        return bVarB;
    }

    public final sg.bigo.ads.ad.interstitial.multi_img.b D() {
        sg.bigo.ads.ad.b.c cVar = this.w;
        if (cVar instanceof sg.bigo.ads.ad.b.b) {
            return null;
        }
        sg.bigo.ads.ad.interstitial.multi_img.b bVarA = this.D.get(cVar);
        if (bVarA == null) {
            sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) this.w.f();
            if (aVar != null) {
                bVarA = sg.bigo.ads.ad.interstitial.multi_img.b.a(this.w, aVar.e());
            }
            if (bVarA != null) {
                this.D.put(this.w, bVarA);
            }
        }
        return bVarA;
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.b.a
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public final sg.bigo.ads.core.a.a f() {
        return (sg.bigo.ads.core.a.a) this.w.f();
    }

    protected final boolean F() {
        return ((sg.bigo.ads.core.a.a) this.w.f()).aR();
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(int i) {
        super.a(i);
        sg.bigo.ads.ad.b.c cVar = this.w;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    public final void a(int i, int i2) {
        super.a(i, i2);
        l lVar = this.A;
        if (lVar != null) {
            lVar.s = true;
            lVar.m = SystemClock.elapsedRealtime();
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(boolean z, boolean z2) {
        super.a(z, z2);
        sg.bigo.ads.ad.b.c cVar = this.w;
        if (cVar != null) {
            cVar.a(z, z2);
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final <ValueType> ValueType b(String str, ValueType valuetype) {
        return (ValueType) this.w.b(str, valuetype);
    }

    @Override // sg.bigo.ads.api.b.a
    public final void b(int i) {
        super.b(i);
        sg.bigo.ads.ad.b.c cVar = this.w;
        if (cVar != null) {
            cVar.b(i);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    protected final void b(Activity activity) {
        super.b(activity);
        sg.bigo.ads.ad.b.c cVar = this.w;
        if (cVar != null) {
            cVar.b(activity);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    protected void b(final sg.bigo.ads.api.b.d.a<InterstitialAd> aVar) {
        sg.bigo.ads.api.a.m mVarE;
        sg.bigo.ads.api.a.m mVarE2;
        sg.bigo.ads.api.a.m mVarE3;
        sg.bigo.ads.api.a.m mVarE4;
        sg.bigo.ads.ad.b.c cVar = this.w;
        sg.bigo.ads.api.a.m mVarE5 = f().e();
        boolean z = true;
        if ((mVarE5 == null || (mVarE5.a("video_play_page.cta_color") != 3 && mVarE5.a("video_play_page.background_colour") != 3 && mVarE5.a("video_play_page.mediaview_colour") != 3 && mVarE5.a("video_play_page.ad_component_colour") != 3)) && (((mVarE = f().e()) == null || mVarE.a("mid_page.cta_color") != 3) && (((mVarE2 = f().e()) == null || (mVarE2.a("endpage.cta_color") != 3 && mVarE2.a("endpage.background_colour") != 3 && mVarE2.a("endpage.mediaview_colour") != 3)) && (((mVarE3 = f().e()) == null || (mVarE3.a("layer.cta_color") != 3 && mVarE3.a("layer.mediaview_colour") != 3)) && ((mVarE4 = f().e()) == null || (mVarE4.a("video_play_page.is_widget") != 1 && mVarE4.a("endpage.is_widget") != 1)))))) {
            z = false;
        }
        cVar.b(z);
        this.w.a(new sg.bigo.ads.api.b.d.a<NativeAd>() { // from class: sg.bigo.ads.ad.interstitial.s.1
            private void a(int i, int i2, String str) {
                if (s.this.e || s.this.f) {
                    return;
                }
                aVar.a(s.this, i, i2, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Type inference failed for: r6v1, types: [sg.bigo.ads.api.core.c] */
            /* JADX WARN: Type inference failed for: r9v0, types: [sg.bigo.ads.api.core.c] */
            @Override // sg.bigo.ads.api.b.d.a
            public void a(NativeAd nativeAd) {
                Set<Map.Entry<NativeAd, Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a>>> setEntrySet;
                Map.Entry<NativeAd, Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a>> next;
                sg.bigo.ads.api.core.g gVar = s.this.b;
                if (s.this.z != null) {
                    b bVar = s.this.z;
                    sg.bigo.ads.ad.b.c cVar2 = s.this.w;
                    sg.bigo.ads.api.a.l lVar = gVar.b;
                    bVar.f12935a = new HashMap();
                    boolean z2 = false;
                    if (cVar2 instanceof sg.bigo.ads.ad.b.b) {
                        sg.bigo.ads.ad.b.b bVar2 = (sg.bigo.ads.ad.b.b) cVar2;
                        sg.bigo.ads.ad.b.d dVar = bVar2.v;
                        sg.bigo.ads.ad.b.d dVar2 = bVar2.w;
                        if (dVar != null) {
                            bVar.f12935a.put(cVar2, s.a(s.this, dVar, lVar, (sg.bigo.ads.api.core.c) dVar.f()));
                            z2 = true;
                        }
                        if (dVar2 != null) {
                            bVar.f12935a.put(cVar2, s.a(s.this, dVar2, lVar, (sg.bigo.ads.api.core.c) dVar2.f()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        b bVar3 = s.this.z;
                        Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a> value = null;
                        if (bVar3.f12935a != null && !bVar3.f12935a.isEmpty() && (setEntrySet = bVar3.f12935a.entrySet()) != null && !setEntrySet.isEmpty() && (next = setEntrySet.iterator().next()) != null) {
                            value = next.getValue();
                        }
                        if (value != null) {
                            s.this.x = (sg.bigo.ads.ad.interstitial.a.b) value.first;
                            s.this.y = (sg.bigo.ads.ad.interstitial.a.a) value.second;
                        }
                    }
                }
                if (s.this.x == null || s.this.y == null) {
                    Pair pairA = s.a(s.this, nativeAd, gVar.b, gVar.f13106a);
                    s.this.x = (sg.bigo.ads.ad.interstitial.a.b) pairA.first;
                    s.this.y = (sg.bigo.ads.ad.interstitial.a.a) pairA.second;
                }
                if (s.this.e || s.this.f) {
                    return;
                }
                s sVar = s.this;
                sVar.a(sVar.w, 0);
                aVar.a(s.this);
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* bridge */ /* synthetic */ void a(Ad ad, int i, int i2, String str) {
                a(i, i2, str);
            }

            @Override // sg.bigo.ads.api.b.d.a
            public final /* synthetic */ void a(Ad ad, boolean z2, int i, int i2, String str, boolean z3) {
                final NativeAd nativeAd = (NativeAd) ad;
                if (s.this.e || s.this.f || !(nativeAd instanceof sg.bigo.ads.ad.b.d)) {
                    return;
                }
                boolean z4 = ((sg.bigo.ads.core.a.a) ((sg.bigo.ads.ad.b.d) nativeAd).f()).bg() != null || z2;
                if (!(s.this.w instanceof sg.bigo.ads.ad.b.b)) {
                    if (z4) {
                        a(nativeAd);
                        return;
                    } else {
                        if (z3) {
                            a(i, i2, str);
                            return;
                        }
                        return;
                    }
                }
                final sg.bigo.ads.ad.b.b bVar = (sg.bigo.ads.ad.b.b) s.this.w;
                if (z4) {
                    sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.b.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (b.this.x != null) {
                                b.this.x.a(nativeAd);
                            }
                        }
                    });
                } else {
                    if (!z3 || bVar.x == null) {
                        return;
                    }
                    bVar.x.a(i, i2, str);
                }
            }
        }, 0);
    }

    @Override // sg.bigo.ads.api.b.a
    public final sg.bigo.ads.api.core.p c_() {
        sg.bigo.ads.ad.b.c cVar = this.w;
        return cVar != null ? cVar.c_() : this.U;
    }

    @Override // sg.bigo.ads.ad.interstitial.k, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public void destroyInMainThread() {
        super.destroyInMainThread();
        this.w.destroy();
        this.z = null;
    }

    @Override // sg.bigo.ads.api.Ad
    public String getCreativeId() {
        sg.bigo.ads.ad.b.c cVar = this.w;
        return cVar != null ? cVar.getCreativeId() : "";
    }

    @Override // sg.bigo.ads.ad.c
    public final boolean n() {
        sg.bigo.ads.ad.b.c cVar = this.w;
        return (cVar != null && cVar.n()) || super.n();
    }

    @Override // sg.bigo.ads.ad.c
    public final void s() {
        this.w.s();
    }

    @Override // sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        super.setAdInteractionListener(adInteractionListener);
        this.B.f12934a = adInteractionListener;
    }

    @Override // sg.bigo.ads.ad.interstitial.k
    protected final boolean y() {
        return ((sg.bigo.ads.core.a.a) this.w.f()).aQ();
    }
}
