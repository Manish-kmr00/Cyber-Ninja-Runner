package sg.bigo.ads.ad.interstitial.e;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.ad.interstitial.s;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.IconAds;
import sg.bigo.ads.api.IconAdsRequest;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f12798a;
    public final sg.bigo.ads.ad.interstitial.e.a.a b;
    public final sg.bigo.ads.ad.interstitial.e.a.c c;
    final sg.bigo.ads.ad.interstitial.g.a d;
    public IconAds e;
    public int f;
    public b h;
    public b i;
    public sg.bigo.ads.ad.interstitial.e.a j;
    public sg.bigo.ads.ad.interstitial.e.a k;
    public final a g = new a(0 == true ? 1 : 0);
    public boolean l = false;
    final sg.bigo.ads.api.d m = new sg.bigo.ads.api.d() { // from class: sg.bigo.ads.ad.interstitial.e.c.1
        @Override // sg.bigo.ads.api.d
        public final void a(NativeAd nativeAd) {
            sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "ad impression.");
        }

        @Override // sg.bigo.ads.api.d
        public final void a(NativeAd nativeAd, AdError adError) {
            sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "ad error, code=" + adError.getCode() + ", message=" + adError.getMessage());
        }

        @Override // sg.bigo.ads.api.d
        public final void b(NativeAd nativeAd) {
            sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "ad click.");
        }

        @Override // sg.bigo.ads.api.d
        public final void c(NativeAd nativeAd) {
            sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "ad click.");
        }

        @Override // sg.bigo.ads.api.d
        public final void d(NativeAd nativeAd) {
            sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "ad click.");
        }
    };

    public static class a implements IconAdsRequest.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12803a;

        private a() {
            this.f12803a = 1;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // sg.bigo.ads.api.IconAdsRequest.b
        public final int a() {
            return this.f12803a;
        }
    }

    public static abstract class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f12804a;
        private boolean b;
        public final ViewGroup c;
        public final sg.bigo.ads.ad.interstitial.e.a.b d;
        private boolean e;
        private boolean f;

        private b(ViewGroup viewGroup, sg.bigo.ads.ad.interstitial.e.a.b bVar) {
            this.c = viewGroup;
            this.d = bVar;
            this.f12804a = 0L;
            this.b = false;
            this.e = false;
            this.f = false;
        }

        /* synthetic */ b(ViewGroup viewGroup, sg.bigo.ads.ad.interstitial.e.a.b bVar, byte b) {
            this(viewGroup, bVar);
        }

        final ValueAnimator a(Integer num) {
            if (num == null) {
                return null;
            }
            return sg.bigo.ads.common.w.b.a(this.c, num.intValue(), new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.e.c.b.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ long f12805a = 300;

                @Override // sg.bigo.ads.common.w.b.a
                public final long a() {
                    return this.f12805a;
                }
            });
        }

        protected final void a(ViewGroup viewGroup, View view, Integer num, final sg.bigo.ads.ad.interstitial.e.a aVar) {
            u.b(view);
            viewGroup.addView(view);
            sg.bigo.ads.common.e.a.a(view, 100.0f);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
            }
            final ValueAnimator valueAnimatorA = a(num);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.1f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setAnimationListener(new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.e.c.b.2
                @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    b.this.a(aVar);
                }

                @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    ValueAnimator valueAnimator = valueAnimatorA;
                    if (valueAnimator != null) {
                        valueAnimator.start();
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }

        protected void a(final sg.bigo.ads.ad.interstitial.e.a aVar) {
            if (aVar != null && aVar.c > 0) {
                aVar.b.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.e.c.b.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.b.setFlipInterval(aVar.c);
                        aVar.b.c();
                    }
                });
            }
        }

        protected abstract boolean a();

        public final void b() {
            this.b = true;
            this.e = false;
            this.c.removeCallbacks(this);
        }

        public final void c() {
            this.e = false;
            this.f = true;
            this.c.removeCallbacks(this);
        }

        public final boolean d() {
            if (this.b || this.e) {
                return false;
            }
            this.e = true;
            this.f = false;
            if (this.f12804a == 0) {
                this.f12804a = SystemClock.elapsedRealtime();
            }
            this.c.postDelayed(this, Math.max(this.d.g() - (SystemClock.elapsedRealtime() - this.f12804a), 0L));
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!this.b && !this.f && a()) {
                this.b = true;
            }
            this.e = false;
        }
    }

    public c(s sVar, m mVar, sg.bigo.ads.ad.interstitial.g.a aVar) {
        this.f12798a = sVar;
        this.b = new sg.bigo.ads.ad.interstitial.e.a.a(mVar);
        this.c = new sg.bigo.ads.ad.interstitial.e.a.c(mVar, aVar == null || aVar.g());
        this.d = aVar;
    }

    static /* synthetic */ List a(IconAds iconAds) {
        if (!(iconAds instanceof sg.bigo.ads.ad.a.a)) {
            if (iconAds != null) {
                return Arrays.asList(iconAds.getNativeAds());
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (sg.bigo.ads.ad.b.a.c cVar : ((sg.bigo.ads.ad.a.a) iconAds).f12480a) {
            if (!cVar.isExpired() && !cVar.h) {
                if (cVar.v) {
                    arrayList.add(cVar);
                } else if (!cVar.w) {
                    arrayList2.add(cVar);
                }
            }
        }
        arrayList.addAll(arrayList2);
        sg.bigo.ads.ad.b.a.c[] cVarArr = new sg.bigo.ads.ad.b.a.c[arrayList.size()];
        k.a(arrayList, cVarArr);
        return Arrays.asList(cVarArr);
    }

    public static void a(sg.bigo.ads.ad.interstitial.e.a aVar, b bVar) {
        if (aVar != null) {
            aVar.b.d();
        } else if (bVar != null) {
            bVar.c();
        }
    }

    static /* synthetic */ void a(c cVar, int i) {
        Ad ad = cVar.e;
        if (ad instanceof sg.bigo.ads.api.b.e) {
            ((sg.bigo.ads.api.b.e) ad).b = i;
        }
    }

    public static void b(sg.bigo.ads.ad.interstitial.e.a aVar, b bVar) {
        if (aVar == null) {
            if (bVar != null) {
                bVar.d();
            }
        } else if (aVar.c > 0) {
            aVar.b.setFlipInterval(aVar.c);
            aVar.b.c();
        }
    }

    private void d() {
        b();
        sg.bigo.ads.ad.interstitial.e.a aVar = this.j;
        if (aVar != null) {
            aVar.b.d();
            u.b(this.j.f12793a);
        }
        this.j = null;
    }

    public final void a(ViewGroup viewGroup) {
        if (viewGroup == null || sg.bigo.ads.ad.interstitial.e.a.b.a(this.b) || !a(1)) {
            return;
        }
        d();
        b bVar = new b(viewGroup, this.b) { // from class: sg.bigo.ads.ad.interstitial.e.c.3
            {
                byte b2 = 0;
            }

            @Override // sg.bigo.ads.ad.interstitial.e.c.b
            protected final boolean a() {
                if (c.this.e == null || c.this.l) {
                    return false;
                }
                if (!c.this.a()) {
                    List listA = c.a(c.this.e);
                    if (!k.a((Collection) listA) && u.c(this.c) && u.d(this.c)) {
                        c.a(c.this, 1);
                        c.this.j = sg.bigo.ads.ad.interstitial.e.a.a(this.c.getContext(), this.d, listA);
                        a(this.c, c.this.j.f12793a, null, c.this.j);
                    }
                }
                c.this.b();
                return true;
            }
        };
        this.h = bVar;
        bVar.d();
    }

    final boolean a() {
        return this.f12798a.h || this.f12798a.w.h;
    }

    public final boolean a(int i) {
        return (this.f & i) == i;
    }

    public final void b() {
        b bVar = this.h;
        if (bVar != null) {
            bVar.b();
        }
        this.h = null;
    }

    public final void c() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.b();
        }
        this.i = null;
    }
}
