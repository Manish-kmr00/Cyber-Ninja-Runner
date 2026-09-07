package sg.bigo.ads.ad.splash.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import java.util.HashSet;
import java.util.Set;
import sg.bigo.ads.ad.interstitial.v;
import sg.bigo.ads.ad.interstitial.w;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.view.Indicator;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes10.dex */
public final class i extends sg.bigo.ads.ad.interstitial.e {
    static final Set<sg.bigo.ads.ad.interstitial.multi_img.view.d> j = new HashSet();
    ViewFlow c;
    Indicator d;
    RoundedFrameLayout e;
    sg.bigo.ads.ad.interstitial.multi_img.a f;
    sg.bigo.ads.ad.interstitial.multi_img.view.b g;
    final sg.bigo.ads.ad.interstitial.multi_img.b h;
    final w i;
    final sg.bigo.ads.ad.b.c l;
    final ViewGroup m;
    sg.bigo.ads.ad.interstitial.multi_img.view.c o;
    sg.bigo.ads.ad.interstitial.multi_img.view.c p;
    final sg.bigo.ads.ad.b.a.InterfaceC0810a k = new sg.bigo.ads.ad.b.a.InterfaceC0810a() { // from class: sg.bigo.ads.ad.splash.a.i.1
        @Override // sg.bigo.ads.ad.b.a.InterfaceC0810a
        public final boolean a() {
            if (i.this.c != null) {
                return i.this.c.h;
            }
            return false;
        }
    };
    v q = new v() { // from class: sg.bigo.ads.ad.splash.a.i.3
        @Override // sg.bigo.ads.ad.interstitial.v
        public final void a() {
            Bitmap bitmap = b.j;
            boolean zAQ = ((sg.bigo.ads.core.a.a) i.this.l.f()).aQ();
            if (bitmap != null) {
                if (zAQ) {
                    synchronized (i.j) {
                        i.j.remove(i.this.g);
                    }
                }
                i.this.g.a(bitmap);
            }
        }
    };
    final sg.bigo.ads.ad.interstitial.d n = new sg.bigo.ads.ad.interstitial.d();

    /* JADX INFO: renamed from: sg.bigo.ads.ad.splash.a.i$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13048a;

        static {
            int[] iArr = new int[sg.bigo.ads.ad.interstitial.multi_img.d.values().length];
            f13048a = iArr;
            try {
                iArr[sg.bigo.ads.ad.interstitial.multi_img.d.LTR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13048a[sg.bigo.ads.ad.interstitial.multi_img.d.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13048a[sg.bigo.ads.ad.interstitial.multi_img.d.FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13048a[sg.bigo.ads.ad.interstitial.multi_img.d.TILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public i(sg.bigo.ads.ad.b.c cVar, ViewGroup viewGroup, w wVar, sg.bigo.ads.ad.interstitial.multi_img.b bVar) {
        this.l = cVar;
        this.m = viewGroup;
        this.h = bVar;
        this.i = wVar;
    }

    static /* synthetic */ void a(i iVar, final long j2, long j3, final long j4) {
        if (j2 <= 0 || iVar.c.g || iVar.c.e()) {
            iVar.c.setScrollEnabled(true);
            return;
        }
        iVar.c.setScrollEnabled(false);
        int iA = sg.bigo.ads.common.utils.e.a(iVar.m.getContext(), 40);
        final int scrollX = iVar.c.getScrollX();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, iA, 0);
        valueAnimatorOfInt.setDuration(2 * j4);
        valueAnimatorOfInt.setStartDelay(j3);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: sg.bigo.ads.ad.splash.a.i.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                i.a(i.this, j2 - 1, 300L, j4);
            }
        });
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.ad.splash.a.i.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    i.this.c.scrollTo(scrollX + ((Integer) animatedValue).intValue(), i.this.c.getScrollY());
                }
            }
        });
        valueAnimatorOfInt.start();
    }

    final sg.bigo.ads.ad.interstitial.multi_img.view.a a(Context context, sg.bigo.ads.ad.interstitial.multi_img.c cVar, int i, String str, boolean z) {
        final sg.bigo.ads.ad.interstitial.multi_img.view.a aVar = new sg.bigo.ads.ad.interstitial.multi_img.view.a(context, this.h, cVar, d(), i, str, z, null);
        aVar.s = true;
        ViewFlow.b bVar = new ViewFlow.b();
        bVar.f13336a = -1;
        bVar.b = -1;
        bVar.c = false;
        bVar.d = cVar.d;
        this.c.addView(aVar.j, bVar);
        if (this.f != null) {
            aVar.r = new sg.bigo.ads.ad.interstitial.multi_img.view.d.a() { // from class: sg.bigo.ads.ad.splash.a.i.10
                @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                public final void a() {
                    i.this.f.a(i.this.c.a(aVar.j));
                }

                @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                public final void b() {
                    aVar.r = null;
                    a();
                }
            };
        }
        return aVar;
    }

    final int d() {
        m mVar = this.h.f12846a;
        if (mVar == null) {
            return 1;
        }
        return sg.bigo.ads.ad.interstitial.multi_img.e.a(mVar.a("video_play_page.mediaview_colour"));
    }

    final boolean e() {
        return this.h.b == sg.bigo.ads.ad.interstitial.multi_img.d.NONE;
    }

    final void f() {
        if (e()) {
        }
        int iA = this.h.f12846a.a("video_play_page.multi_guide");
        switch (iA) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                a(iA, new Runnable() { // from class: sg.bigo.ads.ad.splash.a.i.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.this.c.post(new Runnable() { // from class: sg.bigo.ads.ad.splash.a.i.8.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (i.this.c.g) {
                                    return;
                                }
                                i.a(i.this, 3L, 0L, 300L);
                            }
                        });
                    }
                });
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                this.c.setFlipInterval((iA - 5) * 1000);
                this.c.c();
                break;
        }
    }
}
