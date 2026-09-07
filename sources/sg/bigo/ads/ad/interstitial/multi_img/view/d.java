package sg.bigo.ads.ad.interstitial.multi_img.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import sg.bigo.ads.ad.interstitial.u;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.common.view.FixContentFrameLayout;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes11.dex */
public abstract class d<T extends View> {
    public static long b = 300;
    public static long c = 500;
    public static int d = u.e;
    public static int e = "ViewHolder".hashCode();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12863a;
    protected final Context f;
    protected sg.bigo.ads.ad.interstitial.multi_img.c g;
    protected int h;
    protected final int i;
    public final RoundedFrameLayout j;
    public final FixContentFrameLayout k;
    public final T l;
    public final AdImageView m;
    public int n;
    public int o;
    public Bitmap p;
    public int q;
    public a r;
    private ValueAnimator t;
    private ValueAnimator u;
    private long v = 0;
    public boolean s = false;

    public interface a {
        void a();

        void b();
    }

    public d(Context context, sg.bigo.ads.ad.interstitial.multi_img.c cVar, boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
        this.f = context;
        this.f12863a = z;
        this.i = i2;
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) sg.bigo.ads.common.utils.a.a(context, i3, null, false);
        this.j = roundedFrameLayout;
        this.k = (FixContentFrameLayout) roundedFrameLayout.findViewById(i4);
        this.l = (T) roundedFrameLayout.findViewById(i5);
        this.m = (AdImageView) roundedFrameLayout.findViewById(i6);
        a(cVar);
        a(i);
        this.q = d;
        sg.bigo.ads.common.utils.u.a(roundedFrameLayout, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                d.this.v = SystemClock.elapsedRealtime();
            }
        });
        roundedFrameLayout.setTag(e, this);
    }

    static /* synthetic */ void a(d dVar, final Bitmap bitmap, final int i) {
        if (dVar.a()) {
            dVar.m.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.4
                @Override // java.lang.Runnable
                public final void run() {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(d.this.m.getResources(), bitmap);
                    bitmapDrawable.setAlpha(i);
                    d.this.m.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    d.this.m.setImageDrawable(bitmapDrawable);
                }
            });
        }
    }

    public final void a(int i) {
        int i2;
        if (i != Integer.MIN_VALUE) {
            if (i != 4) {
                if (i == 1) {
                    i2 = -1;
                } else if (i != 2) {
                    i = 3;
                } else {
                    i2 = ViewCompat.MEASURED_STATE_MASK;
                }
            }
            this.h = i;
        }
        i2 = 0;
        b(i2);
        this.h = i;
    }

    public final void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        FixContentFrameLayout.a aVar = (FixContentFrameLayout.a) this.l.getLayoutParams();
        if (aVar.f13314a == i || aVar.b == i2) {
            return;
        }
        aVar.f13314a = i;
        aVar.b = i2;
        this.l.setLayoutParams(aVar);
    }

    public final void a(sg.bigo.ads.ad.interstitial.multi_img.c cVar) {
        FixContentFrameLayout fixContentFrameLayout;
        boolean z;
        this.g = cVar;
        if (a()) {
            int iA = e.a(this.f, 12);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.gravity = 17;
            layoutParams.topMargin = iA;
            layoutParams.leftMargin = iA;
            layoutParams.rightMargin = iA;
            layoutParams.bottomMargin = iA;
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.k.setLayoutParams(layoutParams);
            fixContentFrameLayout = this.k;
            z = true;
        } else {
            fixContentFrameLayout = this.k;
            z = false;
        }
        fixContentFrameLayout.setFixContent(z);
    }

    public boolean a() {
        return this.f12863a;
    }

    public final void b(final int i) {
        if (a()) {
            this.m.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.5
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.m.setBackgroundColor(i);
                }
            });
        }
    }

    protected final void b(Bitmap bitmap) {
        a aVar;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = ((this.v > 0L ? 1 : (this.v == 0L ? 0 : -1)) != 0 ? SystemClock.elapsedRealtime() - this.v : 0L) > b;
        if (c(this.i) || c(this.h)) {
            this.p = sg.bigo.ads.common.utils.d.b(this.f, bitmap);
            if (c(this.i)) {
                this.o = sg.bigo.ads.common.w.b.a(this.p, ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.o = ViewCompat.MEASURED_STATE_MASK;
            }
            final sg.bigo.ads.common.w.b.a aVar2 = new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.2
                @Override // sg.bigo.ads.common.w.b.a
                public final long a() {
                    return d.c;
                }

                @Override // sg.bigo.ads.common.w.b.a
                public final boolean a(int i) {
                    d.this.q = i;
                    d dVar = d.this;
                    if (dVar.c(dVar.h)) {
                        d dVar2 = d.this;
                        d.a(dVar2, dVar2.p, d.this.q);
                    }
                    if (d.this.r != null) {
                        d.this.r.a();
                    }
                    return super.a(i);
                }

                @Override // sg.bigo.ads.common.w.b.a
                public final void b(int i) {
                    if (d.this.r != null) {
                        d.this.r.b();
                    }
                }
            };
            if (z3) {
                ValueAnimator valueAnimator = this.u;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, d);
                this.u = valueAnimatorOfInt;
                valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
                this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        Object animatedValue = valueAnimator2.getAnimatedValue();
                        if (animatedValue instanceof Integer) {
                            int iIntValue = ((Integer) animatedValue).intValue();
                            sg.bigo.ads.common.w.b.a aVar3 = aVar2;
                            if (aVar3 != null) {
                                aVar3.a(iIntValue);
                            }
                        }
                    }
                });
                this.u.addListener(new AnimatorListenerAdapter() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        sg.bigo.ads.common.w.b.a aVar3 = aVar2;
                        if (aVar3 != null) {
                            aVar3.b(d.d);
                        }
                    }
                });
                if (aVar2.a() >= 0) {
                    this.u.setDuration(aVar2.a());
                }
                this.u.start();
            } else {
                aVar2.a(d);
                aVar2.b(d);
            }
            z2 = true;
        }
        if (d(this.i) || d(this.h)) {
            int iA = sg.bigo.ads.common.w.b.a(bitmap, ViewCompat.MEASURED_STATE_MASK);
            final sg.bigo.ads.common.w.b.a aVar3 = new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.3
                @Override // sg.bigo.ads.common.w.b.a
                public final long a() {
                    return d.c;
                }

                @Override // sg.bigo.ads.common.w.b.a
                public final boolean a(int i) {
                    d.this.n = i;
                    d dVar = d.this;
                    if (dVar.d(dVar.h)) {
                        d dVar2 = d.this;
                        dVar2.b(dVar2.n);
                    }
                    if (d.this.r != null) {
                        d.this.r.a();
                    }
                    return super.a(i);
                }

                @Override // sg.bigo.ads.common.w.b.a
                public final void b(int i) {
                    if (d.this.r != null) {
                        d.this.r.b();
                    }
                }
            };
            if (z3) {
                ValueAnimator valueAnimator2 = this.t;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                this.t = sg.bigo.ads.common.w.b.a(this.m, iA, new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.d.8
                    @Override // sg.bigo.ads.common.w.b.a
                    public final long a() {
                        sg.bigo.ads.common.w.b.a aVar4 = aVar3;
                        if (aVar4 != null) {
                            return aVar4.a();
                        }
                        return -1L;
                    }

                    @Override // sg.bigo.ads.common.w.b.a
                    public final boolean a(int i) {
                        sg.bigo.ads.common.w.b.a aVar4 = aVar3;
                        if (aVar4 == null) {
                            return true;
                        }
                        aVar4.a(i);
                        return true;
                    }

                    @Override // sg.bigo.ads.common.w.b.a
                    public final void b(int i) {
                        sg.bigo.ads.common.w.b.a aVar4 = aVar3;
                        if (aVar4 != null) {
                            aVar4.b(i);
                        }
                    }
                });
            } else {
                aVar3.a(iA);
                aVar3.b(iA);
            }
        } else {
            z = z2;
        }
        if (z || (aVar = this.r) == null) {
            return;
        }
        aVar.b();
    }

    public final boolean c(int i) {
        if (this.s) {
            return i == 5;
        }
        return i == 4;
    }

    public final boolean d(int i) {
        if (this.s) {
            return i == 4;
        }
        return i == 3;
    }
}
