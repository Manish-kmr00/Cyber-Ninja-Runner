package sg.bigo.ads.ad.interstitial.f;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import sg.bigo.ads.R;
import sg.bigo.ads.common.h;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;

/* JADX INFO: loaded from: classes8.dex */
public class c extends sg.bigo.ads.controller.landing.c {
    private final AtomicBoolean A;
    private boolean B;
    private final sg.bigo.ads.ad.interstitial.f.a.InterfaceC0845a C;
    private boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final sg.bigo.ads.ad.interstitial.f.a f12814a;
    protected final int b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final int f;
    protected RoundedFrameLayout g;
    protected RelativeLayout h;
    protected View i;
    protected LinearLayout j;
    protected ImageView k;
    protected TextView l;
    protected RelativeLayout m;
    protected ImageView n;
    protected ImageView o;
    protected ImageView p;
    protected ImageView q;
    private final a y;
    private final a z;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.f.c$10, reason: invalid class name */
    final class AnonymousClass10 implements ValueCallback<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f12816a;

        AnonymousClass10(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f12816a = marginLayoutParams;
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Integer num) {
            this.f12816a.topMargin = num.intValue();
            c.this.g.requestLayout();
            c.this.g.getMeasuredWidth();
            c.this.g(c.this.b - this.f12816a.topMargin);
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.f.c$2, reason: invalid class name */
    final class AnonymousClass2 implements ValueCallback<Void> {
        AnonymousClass2() {
        }

        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(Void r1) {
            c.e(c.this);
        }
    }

    class a implements View.OnTouchListener {
        private final int b;
        private float c;
        private float d;
        private int e;

        private a() {
            this.b = ViewConfiguration.get(c.this.I).getScaledTouchSlop();
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0064  */
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (!c.this.c() && c.this.A.get()) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.c = motionEvent.getRawX();
                    this.d = motionEvent.getRawY();
                    if (!c.this.c()) {
                        c.this.c();
                        if (c.this.D) {
                            this.e = (int) motionEvent.getRawY();
                        }
                    }
                } else if (action == 1) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    if (Math.abs(this.c - rawX) >= this.b || Math.abs(this.d - rawY) >= this.b) {
                        c.this.e();
                    } else {
                        c cVar = c.this;
                        cVar.h(cVar.d);
                    }
                } else if (action == 2) {
                    int rawY2 = (int) motionEvent.getRawY();
                    int i = rawY2 - this.e;
                    this.e = rawY2;
                    c.this.c(i);
                } else if (action == 3) {
                    c.this.e();
                }
                return true;
            }
            return false;
        }
    }

    public c(Activity activity) {
        super(activity);
        this.A = new AtomicBoolean(true);
        byte b = 0;
        this.B = false;
        this.C = new sg.bigo.ads.ad.interstitial.f.a.InterfaceC0845a() { // from class: sg.bigo.ads.ad.interstitial.f.c.1
            @Override // sg.bigo.ads.ad.interstitial.f.a.InterfaceC0845a
            public final boolean a() {
                if (c.this.r()) {
                    return false;
                }
                c.this.d(0);
                return true;
            }
        };
        this.D = true;
        Intent intent = activity.getIntent();
        sg.bigo.ads.ad.interstitial.f.a aVar = null;
        LandingPageStyleConfig landingPageStyleConfig = intent == null ? null : (LandingPageStyleConfig) intent.getParcelableExtra("layout_style");
        if (landingPageStyleConfig != null) {
            switch (landingPageStyleConfig.f13473a) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    aVar = new sg.bigo.ads.ad.interstitial.f.a(landingPageStyleConfig.c, landingPageStyleConfig.f13473a, landingPageStyleConfig.e, landingPageStyleConfig.f);
                    break;
                default:
                    aVar = new sg.bigo.ads.ad.interstitial.f.a(0, 1, landingPageStyleConfig.e, landingPageStyleConfig.f);
                    break;
            }
        }
        this.f12814a = aVar;
        int iA = e.a(this.I, 20);
        this.c = iA;
        this.b = ((landingPageStyleConfig == null || landingPageStyleConfig.d <= 0) ? e.c(this.I) - e.a(this.I, 48) : landingPageStyleConfig.d) - iA;
        this.d = 0;
        this.e = (int) (this.b * (1.0f - aVar.e()));
        this.f = e.a(activity, 3);
        this.y = new a(this, b);
        this.z = new a(this, b);
        activity.setTheme(R.style.LandingPageStyle);
        ao();
        Window window = this.I.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = this.b;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        activity.overridePendingTransition(0, 0);
    }

    static /* synthetic */ void d(c cVar) {
        if (cVar.A.compareAndSet(true, false)) {
            long jAbs = (long) Math.abs(((cVar.b - ((ViewGroup.MarginLayoutParams) cVar.g.getLayoutParams()).topMargin) * 1.5f) / cVar.f);
            sg.bigo.ads.common.a.a aVar = new sg.bigo.ads.common.a.a() { // from class: sg.bigo.ads.ad.interstitial.f.c.4
                @Override // sg.bigo.ads.common.a.a
                public final void a(float f, float f2, int i, int i2) {
                    c.this.g((int) (i2 - f2));
                }

                @Override // sg.bigo.ads.common.a.a, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    c.this.A.set(true);
                }
            };
            aVar.setDuration(jAbs);
            cVar.g.startAnimation(aVar);
        }
    }

    static /* synthetic */ boolean e(c cVar) {
        cVar.D = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        View view;
        int i2 = this.b;
        int i3 = i2 - this.e;
        int i4 = this.c;
        if (i == i2 && (view = this.i) != null && !this.B) {
            this.B = true;
            view.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.f.c.3
                @Override // java.lang.Runnable
                public final void run() {
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(new sg.bigo.ads.common.utils.b.a());
                    transitionSet.addTransition(new Fade(2));
                    transitionSet.setDuration(300L);
                    TransitionManager.beginDelayedTransition(c.this.g, transitionSet);
                    c.this.i.setVisibility(8);
                }
            }, 500L);
        }
        this.f12814a.a(i, i3, i2, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i) {
        int iMax = Math.max(this.d, Math.min(this.e, i));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
        if (marginLayoutParams.topMargin == iMax) {
            return;
        }
        long jAbs = (long) Math.abs(((iMax - marginLayoutParams.topMargin) * 2.0f) / this.f);
        this.D = false;
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new sg.bigo.ads.common.utils.b.a() { // from class: sg.bigo.ads.ad.interstitial.f.c.8
            @Override // sg.bigo.ads.common.utils.b.a
            public final void a(Object obj, Object obj2) {
                if (obj == c.this.g && (obj2 instanceof PointF)) {
                    PointF pointF = (PointF) obj2;
                    c.this.g.getMeasuredWidth();
                    float f = pointF.x;
                    c.this.g((int) (c.this.b - pointF.y));
                }
            }
        });
        transitionSet.setDuration(jAbs);
        transitionSet.addListener((Transition.TransitionListener) new h() { // from class: sg.bigo.ads.ad.interstitial.f.c.9
            @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                super.onTransitionEnd(transition);
                c.e(c.this);
            }
        });
        TransitionManager.beginDelayedTransition(this.g, transitionSet);
        marginLayoutParams.topMargin = iMax;
        this.g.requestLayout();
    }

    private boolean t() {
        if (this.v == null) {
            return false;
        }
        return this.v.canGoForward();
    }

    @Override // sg.bigo.ads.controller.landing.c, sg.bigo.ads.core.landing.WebViewActivityImpl, sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void X() {
        super.X();
        this.I.overridePendingTransition(0, 0);
        this.f12814a.c();
    }

    @Override // sg.bigo.ads.controller.landing.c, sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void a() {
        super.a();
        this.f12814a.a();
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void a(final int i) {
        final Runnable runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.f.c.6
            @Override // java.lang.Runnable
            public final void run() {
                c.super.a(i);
            }
        };
        if (this.A.compareAndSet(true, false)) {
            long jAbs = (long) Math.abs(((this.b - ((ViewGroup.MarginLayoutParams) this.g.getLayoutParams()).topMargin) * 1.5f) / this.f);
            sg.bigo.ads.common.a.a aVar = new sg.bigo.ads.common.a.a() { // from class: sg.bigo.ads.ad.interstitial.f.c.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0.0f, 1.0f);
                }

                @Override // sg.bigo.ads.common.a.a
                public final void a(float f, float f2, int i2, int i3) {
                    c.this.g((int) (i3 - f2));
                }

                @Override // sg.bigo.ads.common.a.a, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            };
            aVar.setFillAfter(true);
            aVar.setDuration(jAbs);
            this.g.startAnimation(aVar);
        }
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void a(String str) {
        super.a(str);
        if (this.r != null) {
            this.r.setVisibility(q.a((CharSequence) str) ? 8 : 0);
        }
    }

    @Override // sg.bigo.ads.controller.landing.c, sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void a(String str, boolean z) {
        super.a(str, z);
        this.u.setEnabled(s());
        this.n.setEnabled(t());
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final boolean a(MotionEvent motionEvent) {
        return this.y.onTouch(this.v, motionEvent);
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void a_(int i) {
        super.a_(R.layout.bigo_ad_activity_interstitial_landingpage);
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void b() {
        super.b();
        this.f12814a.b();
    }

    @Override // sg.bigo.ads.controller.landing.c, sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void b(String str) {
        super.b(str);
        this.u.setEnabled(s());
        this.n.setEnabled(t());
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final boolean b(MotionEvent motionEvent) {
        return this.f12814a.a(motionEvent, this.C) || super.b(motionEvent);
    }

    protected final void c(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
        int iMin = Math.min(Math.max(this.d, marginLayoutParams.topMargin + i), this.e);
        marginLayoutParams.topMargin = iMin;
        this.g.requestLayout();
        this.g.getMeasuredWidth();
        g(this.b - iMin);
    }

    protected final boolean c() {
        return ((ViewGroup.MarginLayoutParams) this.g.getLayoutParams()).topMargin <= this.d;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x011d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0120  */
    /* JADX WARN: Code duplicated, block: B:19:0x013b  */
    /* JADX WARN: Code duplicated, block: B:21:0x0145  */
    /* JADX WARN: Code duplicated, block: B:23:0x0158  */
    /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // sg.bigo.ads.controller.landing.c, sg.bigo.ads.core.landing.WebViewActivityImpl
    public final void d() {
        String host;
        ImageView imageView;
        int i;
        Drawable progressDrawable;
        Drawable drawable;
        super.d();
        this.g = (RoundedFrameLayout) l(R.id.inter_landpage_webview_page);
        this.h = (RelativeLayout) l(R.id.inter_webview_top_bar);
        this.j = (LinearLayout) l(R.id.inter_webview_top_action_bar);
        this.k = (ImageView) l(R.id.inter_webview_open);
        this.l = (TextView) l(R.id.inter_webview_host);
        this.q = (ImageView) l(R.id.inter_webview_safe);
        this.i = l(R.id.inter_webview_top_indicator);
        this.m = (RelativeLayout) l(R.id.inter_webview_bottom_bar);
        this.n = (ImageView) l(R.id.inter_webview_forward);
        this.o = (ImageView) l(R.id.inter_webview_copy);
        this.p = (ImageView) l(R.id.inter_webview_refresh);
        this.k.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.h.setLayoutDirection(this.f12814a.f() ? 1 : 0);
        this.j.setLayoutDirection(this.h.getLayoutDirection());
        int i2 = 0;
        this.t.setLayoutDirection(0);
        this.k.setLayoutDirection(0);
        this.s.setLayoutDirection(0);
        this.r.setLayoutDirection(0);
        this.l.setLayoutDirection(0);
        this.r.setMaxLines(1);
        float fA = e.a(this.I, 16);
        this.g.a(fA, fA, 0.0f, 0.0f);
        this.r.setVisibility(8);
        this.l.setVisibility(8);
        String str = this.w;
        boolean zIsHttpsUrl = URLUtil.isHttpsUrl(str);
        try {
            host = Uri.parse(str).getHost();
        } catch (Exception unused) {
            host = "";
        }
        this.l.setText(host);
        if (!q.a((CharSequence) host)) {
            this.l.setVisibility(0);
            imageView = this.q;
            if (!zIsHttpsUrl) {
            }
            imageView.setVisibility(i2);
            this.h.setOnTouchListener(this.z);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
            if (this.f12814a.g()) {
                i = this.d;
            } else {
                i = this.e;
            }
            marginLayoutParams.topMargin = i;
            this.g.requestLayout();
            u.a(this.g, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.f.c.7
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    c.d(c.this);
                }
            });
            if (this.f12814a.d() != 0) {
                progressDrawable = this.s.getProgressDrawable();
                if (progressDrawable instanceof LayerDrawable) {
                    drawable = ((ClipDrawable) ((LayerDrawable) progressDrawable).findDrawableByLayerId(android.R.id.progress)).getDrawable();
                    if (drawable instanceof GradientDrawable) {
                        ((GradientDrawable) drawable).setColors(new int[]{this.f12814a.d(), -1312769});
                    }
                }
            }
        }
        this.l.setVisibility(8);
        imageView = this.q;
        i2 = 8;
        imageView.setVisibility(i2);
        this.h.setOnTouchListener(this.z);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
        if (this.f12814a.g()) {
            i = this.d;
        } else {
            i = this.e;
        }
        marginLayoutParams2.topMargin = i;
        this.g.requestLayout();
        u.a(this.g, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.f.c.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                c.d(c.this);
            }
        });
        if (this.f12814a.d() != 0) {
            progressDrawable = this.s.getProgressDrawable();
            if (progressDrawable instanceof LayerDrawable) {
                drawable = ((ClipDrawable) ((LayerDrawable) progressDrawable).findDrawableByLayerId(android.R.id.progress)).getDrawable();
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setColors(new int[]{this.f12814a.d(), -1312769});
                }
            }
        }
    }

    protected final void e() {
        float f = ((ViewGroup.MarginLayoutParams) this.g.getLayoutParams()).topMargin;
        int i = this.e;
        if (f <= i * 0.8f) {
            i = 0;
        }
        h(i);
    }

    @Override // sg.bigo.ads.controller.landing.c, sg.bigo.ads.api.b.f
    public final int f() {
        return this.f12814a.c;
    }

    @Override // sg.bigo.ads.core.landing.WebViewActivityImpl, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.k) {
            sg.bigo.ads.core.landing.a.a(this.I, this.w, (JSONArray) null);
            return;
        }
        if (view == this.n) {
            if (this.v == null || !this.v.canGoForward()) {
                return;
            }
            this.v.goForward();
            return;
        }
        if (view == this.o) {
            if (sg.bigo.ads.common.utils.c.g(this.I, this.w)) {
                Toast.makeText(this.I, sg.bigo.ads.common.utils.a.a(this.I, R.string.bigo_ad_link_copied, new Object[0]), 0).show();
            }
        } else {
            if (view != this.p || this.v == null) {
                return;
            }
            this.v.reload();
        }
    }
}
