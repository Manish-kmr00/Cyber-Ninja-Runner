package sg.bigo.ads.ad.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.a.m;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends d {
    public d v;
    public d w;
    public a x;

    public abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final sg.bigo.ads.api.b.d.a<NativeAd> f12501a;
        protected final sg.bigo.ads.api.b.d.a<NativeAd> b;
        protected final sg.bigo.ads.api.b.d.a<NativeAd> c;
        final List<d> d = new ArrayList();
        public final String[] e = {"", ""};
        private final List<sg.bigo.ads.common.p.g> k = new ArrayList();
        protected int f = 0;
        protected int g = 0;
        protected boolean h = false;
        protected boolean i = false;

        public a(final sg.bigo.ads.api.b.d.a<NativeAd> aVar) {
            this.c = aVar;
            this.f12501a = new sg.bigo.ads.api.b.d.a<NativeAd>() { // from class: sg.bigo.ads.ad.b.b.a.1
                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad) {
                    final NativeAd nativeAd = (NativeAd) ad;
                    sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.b.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.a(nativeAd);
                        }
                    });
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, int i, int i2, String str) {
                    a.this.a(i, i2, str);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z, int i, int i2, String str, boolean z2) {
                    aVar.a((NativeAd) ad, z, i, i2, str, z2);
                }
            };
            this.b = new sg.bigo.ads.api.b.d.a<NativeAd>() { // from class: sg.bigo.ads.ad.b.b.a.2
                @Override // sg.bigo.ads.api.b.d.a
                public final /* synthetic */ void a(Ad ad) {
                    final NativeAd nativeAd = (NativeAd) ad;
                    sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.b.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.a(nativeAd);
                        }
                    });
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, int i, int i2, String str) {
                    a.this.a(i, i2, str);
                }

                @Override // sg.bigo.ads.api.b.d.a
                public final /* bridge */ /* synthetic */ void a(Ad ad, boolean z, int i, int i2, String str, boolean z2) {
                    aVar.a((NativeAd) ad, z, i, i2, str, z2);
                }
            };
        }

        private void a(final d dVar) {
            final String strAS;
            sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) dVar.f();
            if (aVar != null) {
                strAS = aVar.aS();
                if (TextUtils.isEmpty(strAS) || !URLUtil.isNetworkUrl(strAS)) {
                    strAS = aVar.ay();
                }
            } else {
                strAS = null;
            }
            if (TextUtils.isEmpty(strAS) || !URLUtil.isNetworkUrl(strAS)) {
                return;
            }
            sg.bigo.ads.common.p.g gVar = new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.b.b.a.3
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i, String str, String str2) {
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(Bitmap bitmap, sg.bigo.ads.common.p.f fVar) {
                    if (dVar == b.this.v) {
                        a.this.e[0] = strAS;
                    } else if (dVar == b.this.w) {
                        a.this.e[1] = strAS;
                    }
                }
            };
            this.k.add(gVar);
            sg.bigo.ads.common.p.e.a(b.this.b.e, strAS, aVar.al(), gVar);
        }

        public final sg.bigo.ads.api.b.d.a<NativeAd> a() {
            return this.f12501a;
        }

        public final void a(final int i, final int i2, final String str) {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.b.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) b.this.f();
                    if (aVar != null) {
                        String str2 = str;
                        if (str2 == null) {
                            str2 = "";
                        }
                        aVar.c(str2);
                    }
                    a.this.g++;
                    if (a.this.h || a.this.i || a.this.f + a.this.g != 2) {
                        return;
                    }
                    if (a.this.f > 0) {
                        a.this.c.a(b.this);
                        a.this.h = true;
                    } else {
                        a.this.c.a(b.this, i, i2, str);
                        a.this.i = true;
                    }
                }
            });
        }

        public final void a(NativeAd nativeAd) {
            if ((nativeAd instanceof d) && !this.d.contains(nativeAd)) {
                d dVar = (d) nativeAd;
                if (nativeAd == b.this.v) {
                    this.d.add(0, dVar);
                } else {
                    this.d.add(dVar);
                }
                a(dVar);
            }
            c();
        }

        public final sg.bigo.ads.api.b.d.a<NativeAd> b() {
            return this.b;
        }

        public abstract void c();
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.b.b$b, reason: collision with other inner class name */
    class C0812b extends a {
        public C0812b(sg.bigo.ads.api.b.d.a<NativeAd> aVar) {
            super(aVar);
        }

        @Override // sg.bigo.ads.ad.b.b.a
        public final void c() {
            this.f++;
            if (this.h || this.i || this.f + this.g != 2) {
                return;
            }
            this.c.a(b.this);
            this.h = true;
        }
    }

    class c extends a {
        public c(sg.bigo.ads.api.b.d.a<NativeAd> aVar) {
            super(aVar);
        }

        @Override // sg.bigo.ads.ad.b.b.a
        public final void c() {
            this.f++;
            if (this.h || this.i) {
                return;
            }
            this.c.a(b.this);
            this.h = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [sg.bigo.ads.api.core.c] */
    public b(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        ?? F = f();
        List<sg.bigo.ads.api.core.c> listAm = F.am();
        this.v = new d(gVar.a(F));
        if (listAm == null || listAm.size() <= 0) {
            return;
        }
        this.w = new d(gVar.a(listAm.get(0)));
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(int i) {
        super.a(i);
        d dVar = this.v;
        if (dVar != null) {
            dVar.a(i);
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.a(i);
        }
    }

    @Override // sg.bigo.ads.ad.c
    public final void a(sg.bigo.ads.api.b.a aVar) {
        super.a(aVar);
        d dVar = this.v;
        if (dVar != null) {
            dVar.a(aVar);
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.a(aVar);
        }
    }

    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c
    public final void a(sg.bigo.ads.api.b.d.a<NativeAd> aVar, int i) {
        m mVarE;
        if (aVar == null) {
            return;
        }
        d dVar = this.v;
        d dVar2 = this.w;
        int iA = 0;
        int i2 = dVar == null ? 0 : 1;
        if (dVar2 != null) {
            i2++;
        }
        if (i2 == 0) {
            aVar.a(this, 1023, 10205, "Double video empty ads.");
            return;
        }
        if (i2 == 1) {
            if (dVar == null) {
                dVar = dVar2;
            }
            dVar.a(aVar, i);
            return;
        }
        sg.bigo.ads.core.a.a aVar2 = (sg.bigo.ads.core.a.a) f();
        if (aVar2 != null && (mVarE = aVar2.e()) != null) {
            iA = mVarE.a("multi_ads.ad_fill_tactic");
        }
        a c0812b = iA == 2 ? new C0812b(aVar) : new c(aVar);
        dVar.a(c0812b.a(), i);
        dVar2.a(c0812b.b(), i);
        this.x = c0812b;
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(boolean z) {
        super.a(z);
        d dVar = this.v;
        if (dVar != null) {
            dVar.a(z);
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.a(z);
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void a(boolean z, boolean z2) {
        super.a(z, z2);
        d dVar = this.v;
        if (dVar != null) {
            dVar.a(z, z2);
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.a(z, z2);
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void b(int i) {
        super.b(i);
        d dVar = this.v;
        if (dVar != null) {
            dVar.b(i);
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.b(i);
        }
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void b(Activity activity) {
        super.b(activity);
        d dVar = this.v;
        if (dVar != null) {
            dVar.b(activity);
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.b(activity);
        }
    }

    @Override // sg.bigo.ads.ad.b.e
    public final void b(boolean z) {
        super.b(z);
        d dVar = this.v;
        if (dVar != null) {
            dVar.b(z);
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.b(z);
        }
    }

    @Override // sg.bigo.ads.api.b.a
    public final void c(int i) {
        super.c(i);
        d dVar = this.v;
        if (dVar != null) {
            dVar.c(i);
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.c(i);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        super.destroyInMainThread();
        d dVar = this.v;
        if (dVar != null) {
            dVar.destroy();
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.destroy();
        }
        if (this.p) {
            return;
        }
        this.p = true;
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) f(), SystemClock.elapsedRealtime() - this.j);
    }

    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.c, sg.bigo.ads.api.Ad, sg.bigo.ads.api.IconAds
    public final void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        super.setAdInteractionListener(adInteractionListener);
        d dVar = this.v;
        if (dVar != null) {
            dVar.setAdInteractionListener(adInteractionListener);
        }
        d dVar2 = this.w;
        if (dVar2 != null) {
            dVar2.setAdInteractionListener(adInteractionListener);
        }
    }

    public final List<d> x() {
        a aVar = this.x;
        if (aVar != null) {
            return aVar.d;
        }
        return null;
    }
}
