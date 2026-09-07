package sg.bigo.ads.ad.interstitial.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.common.view.Indicator;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends a {
    protected final sg.bigo.ads.ad.interstitial.d o;
    protected final sg.bigo.ads.ad.interstitial.multi_img.b p;
    protected ViewFlow q;
    protected Indicator r;
    protected LinearLayout s;
    protected sg.bigo.ads.ad.interstitial.multi_img.view.c t;
    protected sg.bigo.ads.ad.interstitial.multi_img.view.c u;
    protected sg.bigo.ads.ad.interstitial.multi_img.a v;
    private final ValueCallback<Double> w;
    private final AtomicBoolean x;
    private final List<Runnable> y;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.c.b$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12679a;

        static {
            int[] iArr = new int[sg.bigo.ads.ad.interstitial.multi_img.d.values().length];
            f12679a = iArr;
            try {
                iArr[sg.bigo.ads.ad.interstitial.multi_img.d.LTR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12679a[sg.bigo.ads.ad.interstitial.multi_img.d.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12679a[sg.bigo.ads.ad.interstitial.multi_img.d.FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12679a[sg.bigo.ads.ad.interstitial.multi_img.d.TILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b(sg.bigo.ads.ad.b.c cVar, int i, sg.bigo.ads.api.a.m mVar, sg.bigo.ads.ad.interstitial.multi_img.b bVar, sg.bigo.ads.ad.interstitial.e.c cVar2) {
        super(cVar, i, mVar, cVar2);
        this.w = new ValueCallback<Double>() { // from class: sg.bigo.ads.ad.interstitial.c.b.1
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Double d) {
                Double d2 = d;
                if (d2 != null) {
                    b.this.b(d2.doubleValue());
                }
            }
        };
        this.x = new AtomicBoolean(false);
        this.y = new ArrayList();
        this.p = bVar;
        this.o = new sg.bigo.ads.ad.interstitial.d();
    }

    private sg.bigo.ads.ad.interstitial.multi_img.view.a a(final sg.bigo.ads.ad.interstitial.q qVar, sg.bigo.ads.ad.interstitial.multi_img.c cVar, int i, String str, boolean z) {
        final sg.bigo.ads.ad.interstitial.multi_img.view.a aVar = new sg.bigo.ads.ad.interstitial.multi_img.view.a(this.j.getContext(), this.p, cVar, e(), i, str, z, new ValueCallback<sg.bigo.ads.ad.interstitial.multi_img.view.a>() { // from class: sg.bigo.ads.ad.interstitial.c.b.12
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(sg.bigo.ads.ad.interstitial.multi_img.view.a aVar2) {
                final sg.bigo.ads.ad.interstitial.multi_img.view.a aVar3 = aVar2;
                b.a(qVar, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.c.b.12.1
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            aVar3.a(bitmap2);
                        }
                    }
                });
            }
        });
        ViewFlow.b bVar = new ViewFlow.b();
        bVar.f13336a = -1;
        bVar.b = -1;
        bVar.c = false;
        bVar.d = cVar.d;
        this.q.addView(aVar.j, bVar);
        if (this.v != null) {
            aVar.r = new sg.bigo.ads.ad.interstitial.multi_img.view.d.a() { // from class: sg.bigo.ads.ad.interstitial.c.b.2
                @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d.a
                public final void a() {
                    b.this.v.a(b.this.q.a(aVar.j));
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

    static /* synthetic */ void a(b bVar, final long j, long j2, final long j3) {
        if (j <= 0 || bVar.q.g || bVar.q.e()) {
            bVar.q.setScrollEnabled(true);
            return;
        }
        bVar.q.setScrollEnabled(false);
        int iA = sg.bigo.ads.common.utils.e.a(bVar.j.getContext(), 40);
        final int scrollX = bVar.q.getScrollX();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, iA, 0);
        valueAnimatorOfInt.setDuration(2 * j3);
        valueAnimatorOfInt.setStartDelay(j2);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        final AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: sg.bigo.ads.ad.interstitial.c.b.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                b.a(b.this, j - 1, 300L, j3);
            }
        };
        valueAnimatorOfInt.addListener(animatorListenerAdapter);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.ad.interstitial.c.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (atomicBoolean.get()) {
                    return;
                }
                if (b.this.x.get()) {
                    atomicBoolean.set(true);
                    valueAnimator.removeListener(animatorListenerAdapter);
                    valueAnimator.cancel();
                    b.this.y.add(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.b.8.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.a(b.this, j, 300L, j3);
                        }
                    });
                    return;
                }
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue instanceof Integer) {
                    b.this.q.scrollTo(scrollX + ((Integer) animatedValue).intValue(), b.this.q.getScrollY());
                }
            }
        });
        valueAnimatorOfInt.start();
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected final void a(double d) {
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005f  */
    /* JADX WARN: Code duplicated, block: B:20:0x0062  */
    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected void a(int i, boolean z, boolean z2) {
        boolean z3;
        List<View> items = this.q.getItems();
        sg.bigo.ads.ad.b.a.a(this.k, 9);
        sg.bigo.ads.ad.b.a.a(this.q, 9);
        if (z2) {
            sg.bigo.ads.ad.b.a.a(this.j, this.k, 4, this.f, i);
            sg.bigo.ads.ad.b.a.a(this.j, this.q, 4, this.f, i);
        } else {
            sg.bigo.ads.ad.b.a.a(this.j, this.k, 4, sg.bigo.ads.ad.interstitial.a.F, 0);
            sg.bigo.ads.ad.b.a.a(this.j, this.q, 4, sg.bigo.ads.ad.interstitial.a.F, 0);
        }
        if (l()) {
            z3 = false;
        } else {
            sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.p;
            z3 = true;
            int iA = bVar != null ? bVar.f12846a.a("endpage.multi_click_type") : 1;
            if (iA == 2) {
                z3 = false;
            } else if (iA != 3) {
                z3 = false;
            } else if (i != 1 && i != 2) {
                z3 = false;
            }
            i = 3;
        }
        Iterator<View> it = items.iterator();
        while (it.hasNext()) {
            Object tag = it.next().getTag(sg.bigo.ads.ad.interstitial.multi_img.view.d.e);
            if (tag instanceof sg.bigo.ads.ad.interstitial.multi_img.view.d) {
                sg.bigo.ads.ad.interstitial.multi_img.view.d dVar = (sg.bigo.ads.ad.interstitial.multi_img.view.d) tag;
                sg.bigo.ads.ad.b.a.a(dVar.j, 5);
                ViewGroup viewGroup = this.j;
                RoundedFrameLayout roundedFrameLayout = dVar.j;
                if (z) {
                    sg.bigo.ads.ad.b.c cVar = this.f;
                    if (z3) {
                        sg.bigo.ads.ad.b.a.a(viewGroup, roundedFrameLayout, 4, cVar, new sg.bigo.ads.ad.b.a.InterfaceC0810a() { // from class: sg.bigo.ads.ad.interstitial.c.b.3
                            @Override // sg.bigo.ads.ad.b.a.InterfaceC0810a
                            public final boolean a() {
                                return b.this.q.h;
                            }
                        });
                    } else {
                        sg.bigo.ads.ad.b.a.a(viewGroup, roundedFrameLayout, 4, cVar, i);
                    }
                } else {
                    sg.bigo.ads.ad.b.a.a(viewGroup, roundedFrameLayout, 4, sg.bigo.ads.ad.interstitial.a.F, 0);
                }
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final void a(sg.bigo.ads.ad.interstitial.q qVar, View view) {
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final boolean a(sg.bigo.ads.ad.interstitial.q qVar, ViewGroup viewGroup, View view, final sg.bigo.ads.ad.interstitial.t.a aVar, int i, int i2, int i3, View... viewArr) {
        return super.a(qVar, viewGroup, view, new sg.bigo.ads.ad.interstitial.t.a() { // from class: sg.bigo.ads.ad.interstitial.c.b.5
            @Override // sg.bigo.ads.ad.interstitial.t.a
            public final Pair<String, String> a(TextView textView, String str, String str2) {
                if (textView.getTag() == 2 && sg.bigo.ads.common.utils.q.a((CharSequence) str2)) {
                    str2 = b.this.f.getDescription();
                }
                sg.bigo.ads.ad.interstitial.t.a aVar2 = aVar;
                return aVar2 != null ? aVar2.a(textView, str, str2) : Pair.create(str, str2);
            }
        }, i, i2, i3, viewArr);
    }

    protected void b(double d) {
        if (d <= 3.0d) {
            sg.bigo.ads.ad.interstitial.multi_img.view.c cVar = this.t;
            if (cVar != null) {
                cVar.a(false);
            }
            sg.bigo.ads.ad.interstitial.multi_img.view.c cVar2 = this.u;
            if (cVar2 != null) {
                cVar2.a(false);
                return;
            }
            return;
        }
        sg.bigo.ads.ad.interstitial.multi_img.view.c cVar3 = this.t;
        if (cVar3 != null) {
            cVar3.a(true);
        }
        sg.bigo.ads.ad.interstitial.multi_img.view.c cVar4 = this.u;
        if (cVar4 != null) {
            cVar4.a(true);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.c.a
    protected final void d(sg.bigo.ads.ad.interstitial.q qVar) {
        Context context = this.j.getContext();
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.p;
        List<String> listA = bVar != null ? bVar.a() : null;
        sg.bigo.ads.ad.interstitial.multi_img.b bVar2 = this.p;
        boolean z = bVar2 != null && bVar2.e;
        sg.bigo.ads.ad.interstitial.multi_img.b bVar3 = this.p;
        sg.bigo.ads.ad.interstitial.multi_img.d dVar = bVar3 != null ? bVar3.b : sg.bigo.ads.ad.interstitial.multi_img.d.NONE;
        sg.bigo.ads.ad.interstitial.multi_img.b bVar4 = this.p;
        sg.bigo.ads.ad.interstitial.multi_img.c cVar = bVar4 != null ? bVar4.d : sg.bigo.ads.ad.interstitial.multi_img.c.FILL_MATCH_SELF;
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.r.a(this.f);
        this.q = (ViewFlow) this.k.findViewById(R.id.inter_media_ad_view_flow);
        this.r = (Indicator) this.k.findViewById(R.id.inter_vf_indicator);
        int iK = k();
        if (iK == 2) {
            this.k.setBackgroundColor(this.o.a(ViewCompat.MEASURED_STATE_MASK));
        } else if (iK == 3 || iK == 4) {
            this.k.setBackgroundColor(this.o.a(ViewCompat.MEASURED_STATE_MASK));
            this.v = new sg.bigo.ads.ad.interstitial.multi_img.a(this.k, this.q, this.o, iK);
        } else {
            this.k.setBackgroundColor(this.o.a(-1));
        }
        this.s = (LinearLayout) this.k.findViewById(R.id.inter_media_bottom_layout);
        if (sg.bigo.ads.common.utils.q.a((CharSequence) this.f.getWarning())) {
            ((ViewGroup.MarginLayoutParams) this.s.getLayoutParams()).topMargin = sg.bigo.ads.common.utils.e.a(context, 8);
        }
        g(qVar);
        this.o.a(this.w);
        if (this.p != null) {
            Context context2 = this.j.getContext();
            this.q.setDividerWidth(sg.bigo.ads.common.utils.e.a(context2, dVar.f));
            this.q.setContentMaxWidthSpace(sg.bigo.ads.common.utils.e.a(context2, dVar.i));
            this.q.setViewStyle(dVar.j);
            this.q.setOnItemChangeListener(new sg.bigo.ads.ad.interstitial.multi_img.f(dVar, this.r, this.v));
            int i = 0;
            int i2 = 0;
            while (listA != null && i2 < listA.size()) {
                String str = listA.get(i2);
                if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                    a(qVar, cVar, iK, str, ((sg.bigo.ads.core.a.a) this.f.f()).al());
                    i++;
                }
                i2++;
                context2 = context2;
            }
            Context context3 = context2;
            int iMax = Math.max(dVar == sg.bigo.ads.ad.interstitial.multi_img.d.CENTER ? 3 - i : 0, 0);
            if (z) {
                iMax = Math.max(iMax, 1);
            }
            int i3 = iMax;
            for (int i4 = 0; i4 < i3; i4++) {
                final sg.bigo.ads.ad.interstitial.multi_img.view.a aVarA = a(qVar, cVar, iK, (String) null, false);
                a(qVar, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.c.b.6
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                        aVarA.a(bitmap);
                    }
                });
            }
            this.q.setMainChildSize(pVarA);
            int i5 = AnonymousClass4.f12679a[dVar.ordinal()];
            if (i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4) {
                ViewFlow.d dVar2 = new ViewFlow.d() { // from class: sg.bigo.ads.ad.interstitial.c.b.11
                    @Override // sg.bigo.ads.common.view.ViewFlow.d
                    public final void a() {
                        b.this.f.a(4, 29);
                    }
                };
                sg.bigo.ads.ad.interstitial.multi_img.view.c cVar2 = new sg.bigo.ads.ad.interstitial.multi_img.view.c(context3, true);
                this.t = cVar2;
                this.q.setStartView(cVar2.f12862a);
                this.q.setOnStartViewShowListener(dVar2);
                sg.bigo.ads.ad.interstitial.multi_img.view.c cVar3 = new sg.bigo.ads.ad.interstitial.multi_img.view.c(context3, false);
                this.u = cVar3;
                this.q.setEndView(cVar3.f12862a);
                this.q.setOnEndViewShowListener(dVar2);
            }
            int itemCount = dVar == sg.bigo.ads.ad.interstitial.multi_img.d.CENTER ? this.q.getItemCount() >> 1 : 0;
            this.q.b(itemCount);
            sg.bigo.ads.ad.interstitial.multi_img.a aVar = this.v;
            if (aVar != null) {
                aVar.b(itemCount);
            }
        }
        if (l()) {
            return;
        }
        sg.bigo.ads.ad.interstitial.multi_img.b bVar5 = this.p;
        int iA = bVar5 != null ? bVar5.f12846a.a("endpage.multi_guide") : 0;
        switch (iA) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                a(iA, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.b.10
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.c.b.10.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (b.this.q.g) {
                                    return;
                                }
                                b.a(b.this, 3L, 0L, 300L);
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
                this.q.setFlipInterval((iA - 5) * 1000);
                this.q.c();
                break;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.u
    public final boolean d() {
        return false;
    }

    protected void g(sg.bigo.ads.ad.interstitial.q qVar) {
    }

    protected final boolean l() {
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.p;
        return bVar == null || bVar.b == sg.bigo.ads.ad.interstitial.multi_img.d.NONE;
    }

    protected final void m() {
        this.x.set(true);
    }

    protected final void n() {
        this.x.set(false);
        if (sg.bigo.ads.ad.interstitial.multi_img.f.a(this.q)) {
            sg.bigo.ads.ad.interstitial.multi_img.f.a(this.q, new ValueCallback<Integer>() { // from class: sg.bigo.ads.ad.interstitial.c.b.9
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Integer num) {
                    Iterator it = b.this.y.iterator();
                    while (it.hasNext()) {
                        b.this.q.post((Runnable) it.next());
                    }
                    b.this.y.clear();
                    sg.bigo.ads.ad.interstitial.multi_img.f.a(b.this.q, (ValueCallback<Integer>) null);
                }
            });
            return;
        }
        Iterator<Runnable> it = this.y.iterator();
        while (it.hasNext()) {
            this.q.post(it.next());
        }
        this.y.clear();
    }
}
