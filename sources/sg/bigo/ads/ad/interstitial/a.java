package sg.bigo.ads.ad.interstitial;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.IconAds;
import sg.bigo.ads.api.IconAdsLoader;
import sg.bigo.ads.api.IconAdsRequest;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.RealtimeBlurLinearLayout;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.YandexWarningTextView;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends q implements sg.bigo.ads.ad.c.a, sg.bigo.ads.ad.interstitial.f.a.b {
    private final List<Integer> G;
    private o<s> H;
    private final l L;
    private final WeakHashMap<Object, Integer> M;
    private final Map<Integer, WeakHashMap<Object, Runnable>> N;
    private final sg.bigo.ads.common.e.a.AbstractC0861a O;
    private boolean P;
    private Runnable Q;
    private int R;
    private int S;
    private final Runnable T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected View f12610a;
    public sg.bigo.ads.api.a.m b;
    protected sg.bigo.ads.api.a.m c;
    public boolean d;
    public boolean e;
    protected boolean f;
    protected boolean g;
    public w h;
    protected sg.bigo.ads.ad.interstitial.multi_img.b i;
    protected f j;
    protected final Handler k;
    protected String l;
    protected int m;
    protected int n;
    protected int o;
    protected AtomicBoolean p;
    protected boolean q;
    public p r;
    protected sg.bigo.ads.ad.interstitial.e.c s;
    protected sg.bigo.ads.ad.interstitial.g.a t;
    protected sg.bigo.ads.common.utils.n u;
    protected sg.bigo.ads.common.utils.n v;
    protected sg.bigo.ads.common.utils.n w;
    protected sg.bigo.ads.common.utils.n x;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.a$3, reason: invalid class name */
    final class AnonymousClass3 extends sg.bigo.ads.common.utils.n {
        AnonymousClass3(long j) {
            super(j, 1000L);
        }

        @Override // sg.bigo.ads.common.utils.n
        public final void a() {
            a aVar = a.this;
            aVar.a(aVar.v, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.D != null) {
                        sg.bigo.ads.common.utils.a.a(a.this.D.getContext(), R.layout.bigo_ad_view_slide_gesture, a.this.D, a.this.D != null);
                        View viewFindViewById = a.this.D.findViewById(R.id.inter_slide_gesture_contain);
                        a.this.f12610a = a.this.D.findViewById(R.id.inter_slide_gesture);
                        if (a.this.f12610a == null) {
                            return;
                        }
                        a.this.f12610a.setTag(16);
                        a.this.Z().a(a.this.D, viewFindViewById, a.this.Y(), 8, 0, a.this.f12610a);
                        a.this.w();
                        View view = a.this.f12610a;
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(300L);
                        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation2.setDuration(200L);
                        alphaAnimation2.setStartOffset(200L);
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 160.0f, 0.0f);
                        translateAnimation.setDuration(300L);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                        animationSet.setAnimationListener(new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.c.8

                            /* JADX INFO: renamed from: a */
                            final /* synthetic */ View f12667a;
                            final /* synthetic */ AlphaAnimation b;

                            AnonymousClass8() {
                                view = view;
                                alphaAnimation = alphaAnimation2;
                            }

                            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                            public final void onAnimationEnd(Animation animation) {
                                view.startAnimation(alphaAnimation);
                            }
                        });
                        alphaAnimation2.setAnimationListener(new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.c.9

                            /* JADX INFO: renamed from: a */
                            final /* synthetic */ AnimationSet f12668a;
                            final /* synthetic */ View b;

                            AnonymousClass9() {
                                animationSet = animationSet;
                                view = view;
                            }

                            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
                            public final void onAnimationEnd(Animation animation) {
                                animationSet.setStartOffset(200L);
                                view.startAnimation(animationSet);
                            }
                        });
                        view.startAnimation(animationSet);
                        a.this.f12610a.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.3.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) a.this.y)) {
                                    return;
                                }
                                a.this.v();
                            }
                        }, 5000L);
                    }
                }
            });
        }

        @Override // sg.bigo.ads.common.utils.n
        public final void a(long j) {
        }
    }

    protected a(Activity activity) {
        super(activity);
        this.G = new ArrayList();
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.k = new Handler(Looper.getMainLooper());
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = new AtomicBoolean(false);
        this.q = true;
        this.L = new l();
        this.M = new WeakHashMap<>();
        this.N = new HashMap();
        this.O = new sg.bigo.ads.common.e.a.AbstractC0861a() { // from class: sg.bigo.ads.ad.interstitial.a.1
            @Override // sg.bigo.ads.common.e.a.AbstractC0861a
            public final void a(boolean z) {
                a.this.c(z);
            }
        };
        this.P = false;
        this.Q = null;
        this.R = 0;
        this.S = 0;
        this.T = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.6
            @Override // java.lang.Runnable
            public final void run() {
                a.this.y();
            }
        };
        sg.bigo.ads.ad.interstitial.f.a.f12813a = new WeakReference<>(this);
    }

    static /* synthetic */ double a(int i, int i2, int i3, int i4) {
        return Math.max(Math.abs(i - i3), Math.abs(i2 - i4));
    }

    private void a(sg.bigo.ads.api.a.m mVar) {
        if (mVar == null) {
            return;
        }
        this.i = ((s) this.y).C();
        sg.bigo.ads.core.a.a aVarF = ((s) this.y).f();
        this.j = new f(mVar.a("video_play_page.gp_element"), mVar.a("video_play_page.gp_force_time"), aVarF != null ? aVarF.n() : "");
    }

    private boolean ad() {
        if (!this.P) {
            return true;
        }
        if (c() == 0) {
            return !k() || l();
        }
        return false;
    }

    private LandingPageStyleConfig ae() {
        sg.bigo.ads.api.a.m mVar = this.c;
        if (mVar == null || !this.d) {
            mVar = null;
        }
        int iA = sg.bigo.ads.ad.interstitial.g.a.a(mVar);
        int iB = sg.bigo.ads.ad.interstitial.g.a.b(mVar);
        sg.bigo.ads.ad.interstitial.g.a aVar = this.t;
        int iA2 = (aVar == null || !aVar.d()) ? 0 : Z().i;
        if (iA2 == 0) {
            iA2 = r.a(this.C, 0);
        }
        return new LandingPageStyleConfig(sg.bigo.ads.ad.interstitial.f.c.class, 9, iA, iB, this.D != null ? this.D.getMeasuredHeight() : 0, iA2, 0.8f);
    }

    private boolean af() {
        sg.bigo.ads.api.a.m mVar = this.c;
        return mVar != null && mVar.c("layer.is_show_layer");
    }

    private void i(int i) {
        sg.bigo.ads.ad.interstitial.multi_img.b bVarD;
        if (i != 0) {
            if (i == 1 && (bVarD = ((s) this.y).D()) != null) {
                bVarD.a(2, 2);
                return;
            }
            return;
        }
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.i;
        if (bVar != null) {
            bVar.a(1, 2);
        }
    }

    protected final boolean A() {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        sg.bigo.ads.api.a.m mVar;
        int i = R.layout.bigo_ad_view_click_guide;
        int iA = -1;
        if (aq()) {
            sg.bigo.ads.api.a.m mVar2 = this.c;
            iA = mVar2 != null ? mVar2.a("layer.guided_click") : -1;
            if (iA == 1) {
                i = R.layout.bigo_ad_view_click_guide_landscape_1;
            } else if (iA == 3) {
                i = R.layout.bigo_ad_view_click_guide_landscape_3;
            } else {
                i = R.layout.bigo_ad_view_click_guide_landscape_2;
                iA = 2;
            }
        }
        boolean z = false;
        if (this.D == null || c() == 2 || c() == 8 || !this.h.d) {
            return false;
        }
        sg.bigo.ads.ad.interstitial.g.a aVar = this.t;
        if (aVar != null) {
            viewFindViewById = aVar.a(this, this.D, Y(), new u.a() { // from class: sg.bigo.ads.ad.interstitial.a.5
                @Override // sg.bigo.ads.ad.interstitial.u.a
                public final void a(View view) {
                    a.this.a(view);
                }
            });
        } else {
            sg.bigo.ads.common.utils.a.a(this.D.getContext(), i, this.D, this.D != null);
            viewFindViewById = this.D.findViewById(R.id.inter_click_guide_container);
            if (viewFindViewById != null) {
                Z().a(this.D, viewFindViewById, Y(), 10, this.h.l, viewFindViewById);
                viewFindViewById.setTag(12);
                Button button = (Button) viewFindViewById.findViewById(R.id.inter_btn_cta);
                if (button != null) {
                    button.setTag(17);
                }
                viewFindViewById.findViewById(R.id.inter_icon).setTag(17);
                if (this.d) {
                    if (button != null) {
                        button.setBackgroundColor(this.o);
                    }
                    if (this.h.k) {
                        a(viewFindViewById, 10, ((s) this.y).w, this.h.l);
                    } else {
                        a(viewFindViewById, 10, F, 0);
                    }
                } else {
                    a(viewFindViewById, 5, ((s) this.y).w, this.h.l);
                }
                c.b(viewFindViewById);
                View viewFindViewById4 = viewFindViewById.findViewById(R.id.inter_click_guide);
                View viewFindViewById5 = viewFindViewById.findViewById(R.id.inter_click_ripple);
                if (viewFindViewById4 != null && viewFindViewById5 != null) {
                    c.a(viewFindViewById4, viewFindViewById5);
                }
                if (iA == 1 && (viewFindViewById3 = viewFindViewById.findViewById(R.id.inter_btn_cta_layout)) != null) {
                    c.e(viewFindViewById3);
                } else if (iA == 3 && (viewFindViewById2 = viewFindViewById.findViewById(R.id.inter_click_guide)) != null) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(600L);
                    alphaAnimation.setStartOffset(1000L);
                    alphaAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(1));
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -sg.bigo.ads.common.utils.e.a(viewFindViewById2.getContext(), 160));
                    translateAnimation.setDuration(600L);
                    translateAnimation.setStartOffset(1000L);
                    translateAnimation.setInterpolator(sg.bigo.ads.common.utils.b.a(2));
                    AnimationSet animationSet = new AnimationSet(false);
                    animationSet.addAnimation(alphaAnimation);
                    animationSet.addAnimation(translateAnimation);
                    alphaAnimation.setRepeatCount(Integer.MAX_VALUE);
                    alphaAnimation.setRepeatMode(1);
                    translateAnimation.setRepeatCount(Integer.MAX_VALUE);
                    translateAnimation.setRepeatMode(1);
                    viewFindViewById2.startAnimation(animationSet);
                }
            }
            View viewFindViewById6 = this.D.findViewById(R.id.bigo_ad_layout_click_guide);
            a(viewFindViewById6);
            if (viewFindViewById6 != null) {
                viewFindViewById = viewFindViewById6;
            }
        }
        View view = viewFindViewById;
        if (view != null && (mVar = this.c) != null) {
            int iA2 = this.d ? mVar.a("layer.below_area_dp") : 0;
            boolean z2 = this.d && this.c.a("layer.below_area_clickable") == 1;
            int iA3 = this.d ? this.c.a("layer.up_area_dp") : 0;
            if (this.d && this.c.a("layer.up_area_clickable") == 1) {
                z = true;
            }
            a(view, iA2, z2, iA3, z, 10, this.h.l);
        }
        f(9);
        a(((long) this.h.e) * 1000);
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected final int B() {
        int iC = c();
        int iD = d();
        switch (iC) {
            case 1:
                return 2;
            case 2:
                return iD == 5 ? 4 : 2;
            case 3:
                return 3;
            case 4:
            default:
                return 1;
            case 5:
            case 6:
                return 4;
            case 7:
            case 8:
                return 5;
            case 9:
                if (iD == 1) {
                    return 2;
                }
                return iD == 5 ? 4 : 9;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.ad.interstitial.k.b
    public void C() {
        if (G()) {
            ae();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i, sg.bigo.ads.api.core.BaseAdActivityImpl
    public void D() {
        super.D();
        this.k.removeCallbacksAndMessages(null);
        sg.bigo.ads.ad.interstitial.e.c cVar = this.s;
        if (cVar != null) {
            if (cVar.e != null) {
                cVar.e.destroy();
            }
            cVar.l = true;
            cVar.b();
            cVar.c();
        }
        sg.bigo.ads.common.e.a.b(this.A, this.O);
    }

    protected final void E() {
        TextView textView = (TextView) this.D.findViewById(R.id.inter_advertiser);
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(this.l)) {
            textView.setVisibility(8);
            return;
        }
        if (!aq() && (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.inter_ad_info);
            layoutParams.addRule(12, 0);
            layoutParams.leftMargin = 18;
            layoutParams.setMarginStart(18);
            layoutParams.bottomMargin = 15;
            textView.setLayoutParams(layoutParams);
            textView.setText(this.l);
        }
    }

    protected final boolean F() {
        ae();
        return false;
    }

    protected final boolean G() {
        int iC = c();
        return iC == 2 || iC == 6 || iC == 8 || iC == 9;
    }

    protected abstract void H();

    /* JADX WARN: Code duplicated, block: B:24:0x004e A[PHI: r0
  0x004e: PHI (r0v16 java.lang.Integer) = (r0v15 java.lang.Integer), (r0v18 java.lang.Integer) binds: [B:23:0x004c, B:17:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    protected void I() {
        Integer numA;
        if (this.D != null) {
            sg.bigo.ads.api.a.m mVar = this.c;
            int iIntValue = ViewCompat.MEASURED_STATE_MASK;
            if (mVar == null || !M()) {
                if (!aq()) {
                    Z().a(this.D);
                    return;
                }
                sg.bigo.ads.api.a.m mVar2 = this.c;
                if (mVar2 != null) {
                    int iA = mVar2.a("video_play_page.background_colour");
                    if (iA == 1) {
                        Z().a(this.D, -1);
                        return;
                    }
                    if (iA == 2) {
                        Z().a(this.D, ViewCompat.MEASURED_STATE_MASK);
                        return;
                    }
                    if (iA == 4) {
                        Z().a(this.D, this.m);
                        return;
                    } else if (iA == 5) {
                        Z().a(this.D);
                        return;
                    } else {
                        Z().a(this.D, sg.bigo.ads.common.utils.q.b("#262E33", -7829368));
                        return;
                    }
                }
                return;
            }
            int iA2 = this.c.a("video_play_page.background_colour");
            if (iA2 == 1) {
                iIntValue = -1;
            } else if (iA2 != 2) {
                if (aq()) {
                    if (iA2 == 4) {
                        numA = r.a((NativeAd) this.C);
                        if (numA != null) {
                            iIntValue = numA.intValue();
                        }
                    } else if (iA2 != 3) {
                        iIntValue = -100;
                    }
                    iIntValue = sg.bigo.ads.common.utils.q.b("#262E33", -7829368);
                } else if (iA2 == 3) {
                    numA = r.a((NativeAd) this.C);
                    if (numA != null) {
                        iIntValue = numA.intValue();
                    } else {
                        iIntValue = sg.bigo.ads.common.utils.q.b("#262E33", -7829368);
                    }
                } else {
                    iIntValue = -100;
                }
            }
            t tVarZ = Z();
            ViewGroup viewGroup = this.D;
            if (iIntValue != -100) {
                tVarZ.a(viewGroup, iIntValue);
            } else {
                tVarZ.a(viewGroup);
            }
        }
    }

    public final boolean J() {
        sg.bigo.ads.api.a.m mVar = this.c;
        return mVar != null && 1 == mVar.a("endpage.is_endpage", 1);
    }

    public final boolean K() {
        sg.bigo.ads.api.a.m mVar = this.c;
        return (mVar == null || mVar.a("mid_page.show_time") != 0 || J() || af() || this.p.get()) ? false : true;
    }

    public final boolean L() {
        sg.bigo.ads.api.a.m mVar = this.c;
        return (mVar == null || mVar.a("mid_page.show_time") <= 0 || J() || af() || this.p.get()) ? false : true;
    }

    protected final boolean M() {
        int iR = R();
        return iR == R.layout.bigo_ad_activity_interstitial_percent_warning || iR == R.layout.bigo_ad_activity_interstitial_percent_warning_landscape;
    }

    @Override // sg.bigo.ads.ad.c.a
    public LandingPageStyleConfig a(Context context, String str, int i, boolean z) {
        p pVar;
        sg.bigo.ads.api.a.m mVar = null;
        mVar = null;
        sg.bigo.ads.api.a.m mVar2 = null;
        LandingPageStyleConfig landingPageStyleConfig = null;
        mVar = null;
        if (z) {
            return null;
        }
        int iC = c();
        if (iC == 0) {
            t tVarZ = Z();
            sg.bigo.ads.api.a.m mVar3 = this.c;
            if (mVar3 != null && this.d) {
                mVar = mVar3;
            }
            landingPageStyleConfig = new LandingPageStyleConfig(sg.bigo.ads.ad.interstitial.f.c.class, 0, sg.bigo.ads.ad.interstitial.d.a.a(tVarZ, mVar), sg.bigo.ads.ad.interstitial.d.a.b(tVarZ, mVar), this.D != null ? this.D.getMeasuredHeight() : 0, r.a(this.C, 0), sg.bigo.ads.ad.interstitial.d.a.a(tVarZ) ? 0.67f : 0.8f);
        } else if (iC == 9) {
            landingPageStyleConfig = ae();
        } else if (iC == 10) {
            sg.bigo.ads.api.a.m mVar4 = this.c;
            if (mVar4 != null && this.d) {
                mVar2 = mVar4;
            }
            landingPageStyleConfig = new LandingPageStyleConfig(sg.bigo.ads.ad.interstitial.f.c.class, 10, sg.bigo.ads.ad.interstitial.d.a.a(mVar2, "layer.webview_layout"), sg.bigo.ads.ad.interstitial.d.a.b(mVar2, "layer.webview_force_time"), this.D != null ? this.D.getMeasuredHeight() : 0, r.a(this.C, 0), 0.8f);
            if (!landingPageStyleConfig.b() && (pVar = this.r) != null) {
                pVar.e();
            }
        }
        sg.bigo.ads.ad.interstitial.f.a.a(landingPageStyleConfig);
        return landingPageStyleConfig;
    }

    @Override // sg.bigo.ads.ad.interstitial.f.a.b
    public void a(int i) {
        this.P = true;
    }

    @Override // sg.bigo.ads.ad.interstitial.f.a.b
    public final void a(int i, int i2, int i3, int i4, int i5) {
        if (c() == c() && i5 == 0) {
            Object objZ = Z();
            if (objZ instanceof sg.bigo.ads.ad.interstitial.f.b) {
                sg.bigo.ads.ad.interstitial.f.b bVar = (sg.bigo.ads.ad.interstitial.f.b) objZ;
                bVar.a(i, i2, i3, i4);
                if (bVar.K() && this.P && !this.B.get()) {
                    j();
                }
            }
        }
    }

    protected final void a(long j) {
        if (j <= 0) {
            y();
            return;
        }
        z();
        this.k.removeCallbacks(this.T);
        this.k.postDelayed(this.T, j);
    }

    protected final void a(View view) {
        sg.bigo.ads.ad.interstitial.e.c cVar = this.s;
        if (cVar == null || !(view instanceof ViewGroup)) {
            return;
        }
        sg.bigo.ads.ad.interstitial.e.c.a(cVar.j, cVar.h);
        sg.bigo.ads.ad.interstitial.e.c cVar2 = this.s;
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup == null || sg.bigo.ads.ad.interstitial.e.a.b.a(cVar2.c) || !cVar2.a(2)) {
            return;
        }
        cVar2.c();
        if (cVar2.k != null) {
            cVar2.k.b.d();
            sg.bigo.ads.common.utils.u.b(cVar2.k.f12793a);
        }
        cVar2.k = null;
        cVar2.i = new sg.bigo.ads.ad.interstitial.e.c.b(viewGroup, cVar2.c) { // from class: sg.bigo.ads.ad.interstitial.e.c.4

            /* JADX INFO: renamed from: a */
            final /* synthetic */ ViewGroup f12802a;
            private boolean e = false;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(ViewGroup viewGroup2, sg.bigo.ads.ad.interstitial.e.a.b bVar) {
                super(viewGroup2, bVar, (byte) 0);
                viewGroup = viewGroup2;
                this.e = false;
            }

            @Override // sg.bigo.ads.ad.interstitial.e.c.b
            protected final void a(sg.bigo.ads.ad.interstitial.e.a aVar) {
                super.a(aVar);
                if (!this.e || c.this.d == null || aVar.f12793a == null) {
                    return;
                }
                c.this.d.a(aVar.f12793a);
            }

            @Override // sg.bigo.ads.ad.interstitial.e.c.b
            protected final boolean a() {
                if (c.this.e == null || c.this.l) {
                    return false;
                }
                if (!c.this.a()) {
                    List listA = c.a(c.this.e);
                    if (!k.a((Collection) listA) && u.c(this.c) && u.d(this.c)) {
                        c.a(c.this, 2);
                        c.this.k = sg.bigo.ads.ad.interstitial.e.a.a(this.c.getContext(), this.d, listA);
                        RealtimeBlurLinearLayout realtimeBlurLinearLayout = c.this.k.f12793a;
                        int iC = this.d.c();
                        if (iC == 5 || iC == 6) {
                            View viewFindViewById = viewGroup.findViewById(R.id.inter_icons_bottom_anchor);
                            View viewFindViewById2 = viewGroup.findViewById(R.id.inter_icons_center_anchor);
                            if (viewFindViewById != null) {
                                ViewParent parent = viewFindViewById.getParent();
                                if (parent instanceof ViewGroup) {
                                    ((ViewGroup) parent).addView(realtimeBlurLinearLayout, viewFindViewById.getLayoutParams());
                                }
                            }
                            if (viewFindViewById2 != null) {
                                sg.bigo.ads.ad.interstitial.e.a aVar = c.this.k;
                                ViewParent parent2 = viewFindViewById2.getParent();
                                if (parent2 instanceof ViewGroup) {
                                    ViewGroup viewGroup2 = (ViewGroup) parent2;
                                    viewGroup2.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.e.c.b.3

                                        /* JADX INFO: renamed from: a */
                                        final /* synthetic */ View f12807a;
                                        final /* synthetic */ ViewGroup b;
                                        final /* synthetic */ View c;
                                        final /* synthetic */ Integer d;
                                        final /* synthetic */ sg.bigo.ads.ad.interstitial.e.a e;

                                        /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.e.c$b$3$1 */
                                        final class AnonymousClass1 extends sg.bigo.ads.common.h {

                                            /* JADX INFO: renamed from: a */
                                            final /* synthetic */ ValueAnimator f12808a;

                                            AnonymousClass1() {
                                                valueAnimator = valueAnimator;
                                            }

                                            @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                                            public final void onTransitionEnd(Transition transition) {
                                                b.this.a(aVar);
                                            }

                                            @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                                            public final void onTransitionStart(Transition transition) {
                                                ValueAnimator valueAnimator = valueAnimator;
                                                if (valueAnimator != null) {
                                                    valueAnimator.start();
                                                }
                                            }
                                        }

                                        AnonymousClass3() {
                                            view = realtimeBlurLinearLayout;
                                            viewGroup = viewGroup2;
                                            view = viewFindViewById2;
                                            num = num;
                                            aVar = aVar;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            u.b(view);
                                            viewGroup.addView(view, view.getLayoutParams());
                                            ValueAnimator valueAnimatorA = b.this.a(num);
                                            TransitionSet transitionSet = new TransitionSet();
                                            transitionSet.addTransition(new ChangeBounds());
                                            transitionSet.setDuration(300L);
                                            transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.e.c.b.3.1

                                                /* JADX INFO: renamed from: a */
                                                final /* synthetic */ ValueAnimator f12808a;

                                                AnonymousClass1() {
                                                    valueAnimator = valueAnimatorA;
                                                }

                                                @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                                                public final void onTransitionEnd(Transition transition) {
                                                    b.this.a(aVar);
                                                }

                                                @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                                                public final void onTransitionStart(Transition transition) {
                                                    ValueAnimator valueAnimator = valueAnimator;
                                                    if (valueAnimator != null) {
                                                        valueAnimator.start();
                                                    }
                                                }
                                            });
                                            TransitionManager.beginDelayedTransition(viewGroup, transitionSet);
                                        }
                                    });
                                }
                            }
                        } else {
                            this.e = true;
                            a(viewGroup, realtimeBlurLinearLayout, -234881024, c.this.k);
                        }
                    }
                }
                c.this.c();
                return true;
            }
        };
        cVar2.i.d();
    }

    protected final void a(View view, int i, sg.bigo.ads.core.adview.h hVar, int i2) {
        ViewGroup viewGroup = this.D;
        if (viewGroup == null) {
            sg.bigo.ads.common.t.a.a(0, "InterstitialNativeActivityImpl", "Failed to set ad click due to native ad view is null.");
        } else {
            sg.bigo.ads.ad.b.a.a(viewGroup, view, i, hVar, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x005d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0067 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0069  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    protected final void a(final View view, int i, boolean z, int i2, boolean z2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup viewGroup;
        ViewGroup.LayoutParams layoutParams2;
        if (!(view instanceof FrameLayout) && !(view instanceof RelativeLayout)) {
            sg.bigo.ads.common.t.a.a(0, "InterstitialNativeActivityImpl", "Failed to update up or below area click due to unsupported view.");
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) view;
        Context context = view.getContext();
        if (context == null) {
            return;
        }
        if (i > 0) {
            View view2 = new View(context);
            view2.setId(R.id.bigo_ad_interstitial_below_area_click);
            view2.setTag(25);
            if (viewGroup2 instanceof FrameLayout) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context, i), 80);
            } else if (viewGroup2 instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context, i));
                layoutParams3.addRule(12);
                layoutParams2 = layoutParams3;
            } else {
                viewGroup = this.D;
                if (z) {
                    if (viewGroup != null) {
                        a(view2, i3, ((s) this.y).w, i4);
                    }
                } else if (viewGroup != null) {
                    sg.bigo.ads.ad.b.a.a(this.D, view2, i3, new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.interstitial.a.7
                        @Override // sg.bigo.ads.core.adview.h
                        public final void a(int i5, int i6, int i7, int i8, int i9, int i10) {
                            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialNativeActivityImpl", "Forbidden click for below area: " + view);
                        }
                    }, i4);
                }
            }
            viewGroup2.addView(view2, layoutParams2);
            viewGroup = this.D;
            if (z) {
                if (viewGroup != null) {
                    a(view2, i3, ((s) this.y).w, i4);
                }
            } else if (viewGroup != null) {
                sg.bigo.ads.ad.b.a.a(this.D, view2, i3, new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.interstitial.a.7
                    @Override // sg.bigo.ads.core.adview.h
                    public final void a(int i5, int i6, int i7, int i8, int i9, int i10) {
                        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialNativeActivityImpl", "Forbidden click for below area: " + view);
                    }
                }, i4);
            }
        }
        if (i2 > 0) {
            View view3 = new View(context);
            view3.setTag(24);
            if (!(viewGroup2 instanceof FrameLayout)) {
                if (viewGroup2 instanceof RelativeLayout) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context, i2));
                }
                if (z2) {
                    if (this.D != null) {
                        a(view3, i3, ((s) this.y).w, i4);
                    }
                } else if (this.C != null) {
                    sg.bigo.ads.ad.b.a.a(this.D, view3, i3, new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.interstitial.a.8
                        @Override // sg.bigo.ads.core.adview.h
                        public final void a(int i5, int i6, int i7, int i8, int i9, int i10) {
                            sg.bigo.ads.common.t.a.a(0, 3, "InterstitialNativeActivityImpl", "Forbidden click for up area: " + view);
                        }
                    }, i4);
                }
            }
            layoutParams = new FrameLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context, i2));
            viewGroup2.addView(view3, layoutParams);
            if (z2) {
                if (this.D != null) {
                    a(view3, i3, ((s) this.y).w, i4);
                }
            } else if (this.C != null) {
                sg.bigo.ads.ad.b.a.a(this.D, view3, i3, new sg.bigo.ads.core.adview.h() { // from class: sg.bigo.ads.ad.interstitial.a.8
                    @Override // sg.bigo.ads.core.adview.h
                    public final void a(int i5, int i6, int i7, int i8, int i9, int i10) {
                        sg.bigo.ads.common.t.a.a(0, 3, "InterstitialNativeActivityImpl", "Forbidden click for up area: " + view);
                    }
                }, i4);
            }
        }
    }

    protected void a(ViewGroup viewGroup) {
        MediaView mediaView = (MediaView) viewGroup.findViewById(R.id.inter_media);
        if (mediaView != null) {
            mediaView.setTag(5);
        }
        if (this.h.f12960a) {
            viewGroup.setTag(11);
            a(viewGroup, 1, ((s) this.y).w, this.h.i);
            if (mediaView != null) {
                mediaView.b().a(false);
                return;
            }
            return;
        }
        if (!this.d) {
            a(viewGroup, 8, (sg.bigo.ads.core.adview.h) null, 0);
            return;
        }
        if (!(Z() instanceof sg.bigo.ads.ad.interstitial.d.a) && mediaView != null) {
            a(mediaView, 8, ((s) this.y).w, this.h.i);
            if (this.h.f) {
                mediaView.setMediaAreaClickable(true);
                mediaView.b().a(false);
            } else {
                mediaView.setMediaAreaClickable(false);
                mediaView.b().a(true);
            }
        }
        if (!(Z() instanceof sg.bigo.ads.ad.interstitial.d.a)) {
            View viewFindViewById = viewGroup.findViewById(R.id.inter_media_container);
            if (t()) {
                viewFindViewById = viewGroup.findViewById(R.id.inter_media_layout);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setTag(9);
                if (this.h.g) {
                    if (mediaView != null) {
                        mediaView.setOtherClickAreaClick(true);
                    }
                    a(viewFindViewById, 8, ((s) this.y).w, this.h.i);
                } else {
                    if (mediaView != null) {
                        mediaView.setOtherClickAreaClick(false);
                    }
                    a(viewFindViewById, 8, F, 0);
                }
            }
        }
        if (Z() instanceof sg.bigo.ads.ad.interstitial.d.a) {
            return;
        }
        View viewFindViewById2 = viewGroup.findViewById(R.id.inter_ad_info);
        if (M() && aq()) {
            viewFindViewById2 = viewGroup.findViewById(R.id.inter_ad_info_inner);
        }
        if (viewFindViewById2 != null) {
            viewFindViewById2.setTag(18);
            if (t()) {
                viewFindViewById2 = viewGroup.findViewById(R.id.inter_media_container);
                viewFindViewById2.setTag(18);
            }
            if (this.h.h) {
                a(viewFindViewById2, 8, ((s) this.y).w, this.h.i);
            } else {
                a(viewFindViewById2, 8, F, 0);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:41:0x007c  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d9  */
    protected void a(boolean z) {
        int iF;
        sg.bigo.ads.controller.b.f fVar;
        boolean z2;
        boolean z3;
        if (this.s != null) {
            if (J() || af() || this.p.get()) {
                sg.bigo.ads.ad.interstitial.e.c cVar = this.s;
                cVar.f = 0;
                sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) cVar.f12798a.w.f();
                if (cVar.c.b() == 1) {
                    iF = cVar.c.f();
                    cVar.f |= 2;
                } else {
                    iF = 0;
                }
                if (aVar.aQ()) {
                    int iB = cVar.b.b();
                    if (z) {
                        sg.bigo.ads.ad.interstitial.a.b bVar = cVar.f12798a.x;
                        z2 = bVar != null && bVar.f12644a;
                        sg.bigo.ads.ad.interstitial.a.a aVar2 = cVar.f12798a.y;
                        z3 = aVar2 != null && aVar2.f12630a;
                    } else {
                        z2 = false;
                        z3 = false;
                    }
                    if (iB == 1) {
                        iF = cVar.b.f();
                        cVar.f |= 1;
                    } else if (iB != 2) {
                        if (iB == 3) {
                            if (z2 || z3) {
                                cVar.f = 0;
                            } else {
                                iF = cVar.b.f();
                                cVar.f |= 1;
                            }
                        }
                    } else if (z2) {
                        cVar.f = 0;
                    } else {
                        iF = cVar.b.f();
                        cVar.f |= 1;
                    }
                }
                if (cVar.f > 0) {
                    sg.bigo.ads.api.a.l lVarD = aVar.d();
                    int iW = aVar.w();
                    if (lVarD == null) {
                        fVar = null;
                    } else {
                        int iB2 = lVarD.b();
                        if (iB2 != 3) {
                            if (iB2 != 4) {
                                fVar = null;
                            } else if (iW == 1) {
                                fVar = new sg.bigo.ads.controller.b.f("10000-10003", "10000-10003-10001", 17, lVarD);
                            } else if (iW != 2) {
                                fVar = null;
                            } else {
                                fVar = new sg.bigo.ads.controller.b.f("10000-10004", "10000-10004-10001", 18, lVarD);
                            }
                        } else if (iW == 1) {
                            fVar = new sg.bigo.ads.controller.b.f("10000-10001", "10000-10001-10001", 15, lVarD);
                        } else if (iW != 2) {
                            fVar = null;
                        } else {
                            fVar = new sg.bigo.ads.controller.b.f("10000-10002", "10000-10002-10001", 16, lVarD);
                        }
                    }
                    if (fVar != null) {
                        IconAdsRequest.a aVar3 = new IconAdsRequest.a();
                        aVar3.f13085a = fVar;
                        IconAdsRequest.a aVarWithSlotId = aVar3.withSlotId(fVar.l());
                        aVarWithSlotId.e = iF;
                        aVarWithSlotId.c = cVar.f;
                        aVarWithSlotId.b = aVar;
                        aVarWithSlotId.f = cVar.g;
                        aVarWithSlotId.d = 1;
                        sg.bigo.ads.api.b bVarK = cVar.f12798a.K();
                        if (bVarK != null) {
                            aVarWithSlotId.withAge(bVarK.d).withActivatedTime(bVarK.f).withGender(bVarK.e);
                        }
                        IconAdsLoader.a aVar4 = new IconAdsLoader.a();
                        aVar4.f13084a = new AdLoadListener<IconAds>() { // from class: sg.bigo.ads.ad.interstitial.e.c.2
                            public AnonymousClass2() {
                            }

                            @Override // sg.bigo.ads.api.AdLoadListener
                            public final /* synthetic */ void onAdLoaded(Ad ad) {
                                IconAds iconAds = (IconAds) ad;
                                c cVar2 = c.this;
                                if (cVar2.a() || iconAds == null) {
                                    return;
                                }
                                cVar2.e = iconAds;
                                cVar2.e.setAdInteractionListener(cVar2.m);
                                c.b(cVar2.k, cVar2.i);
                                c.b(cVar2.j, cVar2.h);
                                if (iconAds instanceof sg.bigo.ads.ad.a.a) {
                                    for (sg.bigo.ads.ad.b.a.c cVar3 : ((sg.bigo.ads.ad.a.a) iconAds).f12480a) {
                                        sg.bigo.ads.core.a.a aVar5 = (sg.bigo.ads.core.a.a) cVar3.f();
                                        if (aVar5 != null) {
                                            o.a aVarAu = aVar5.au();
                                            String strC = aVarAu != null ? aVarAu.c() : null;
                                            if (URLUtil.isNetworkUrl(strC)) {
                                                if (sg.bigo.ads.api.a.i.f13093a.n().a(9) && URLUtil.isHttpUrl(strC)) {
                                                    sg.bigo.ads.core.d.b.a(aVar5, 3000, 10220, "Invalid http url: ".concat(String.valueOf(strC)));
                                                } else {
                                                    sg.bigo.ads.common.p.e.b(cVar3.b.e, sg.bigo.ads.common.u.a.e.i(), strC, aVar5.al(), cVar3);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            @Override // sg.bigo.ads.api.AdLoadListener
                            public final void onError(AdError adError) {
                                sg.bigo.ads.common.t.a.a(0, 3, "IconAdsMgr", "load icon ads error, code=" + adError.getCode() + ", message=" + adError.getMessage());
                            }
                        };
                        aVar4.build().loadAd(aVarWithSlotId.build());
                    }
                }
            }
        }
    }

    protected final void a(Object... objArr) {
        if (objArr.length == 0) {
            return;
        }
        synchronized (this.M) {
            for (Object obj : objArr) {
                if (obj != null) {
                    this.M.put(obj, 1);
                }
            }
        }
    }

    @Override // sg.bigo.ads.ad.c.a
    public final boolean a() {
        return this.P;
    }

    @Override // sg.bigo.ads.ad.interstitial.f.a.b
    public boolean a(MotionEvent motionEvent, sg.bigo.ads.ad.interstitial.f.a.InterfaceC0845a interfaceC0845a, int i) {
        boolean zB;
        boolean z = false;
        if (this.A != null) {
            AdCountDownButton adCountDownButton = this.A;
            if (motionEvent == null || adCountDownButton.f == null) {
                zB = false;
            } else {
                zB = sg.bigo.ads.common.utils.u.b(adCountDownButton.f, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
            if (zB) {
                if (motionEvent.getAction() == 1) {
                    if (interfaceC0845a != null && interfaceC0845a.a()) {
                        z = true;
                    }
                    if (z && this.Q == null) {
                        if (this.P) {
                            this.Q = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.10
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (a.this.A != null) {
                                        a.this.A.a();
                                    }
                                }
                            };
                        } else if (this.A != null) {
                            this.A.a();
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    protected final boolean a(Object obj, Runnable runnable) {
        Integer num;
        if (obj == null || runnable == null) {
            return false;
        }
        synchronized (this.M) {
            num = this.M.get(obj);
        }
        if (num == null) {
            runnable.run();
            return false;
        }
        synchronized (this.N) {
            WeakHashMap<Object, Runnable> weakHashMap = this.N.get(num);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap<>();
                this.N.put(num, weakHashMap);
            }
            weakHashMap.put(obj, runnable);
        }
        return true;
    }

    protected abstract w b();

    @Override // sg.bigo.ads.ad.interstitial.f.a.b
    public final void b(int i) {
        if (c() == 0 && i == 0 && k() && !l() && this.P && this.B.get()) {
            h();
        }
    }

    protected void b(boolean z) {
        sg.bigo.ads.common.utils.n nVar;
        sg.bigo.ads.common.utils.n nVar2 = this.v;
        if (nVar2 != null) {
            nVar2.b();
            this.v = null;
        }
        sg.bigo.ads.common.utils.n nVar3 = this.u;
        if (nVar3 != null) {
            nVar3.b();
            this.u = null;
        }
        if (z && (nVar = this.w) != null) {
            nVar.b();
            this.w = null;
        }
        sg.bigo.ads.common.utils.n nVar4 = this.x;
        if (nVar4 != null) {
            nVar4.b();
            this.x = null;
        }
    }

    protected final void b(Object... objArr) {
        if (objArr.length == 0) {
            return;
        }
        synchronized (this.M) {
            for (Object obj : objArr) {
                if (obj != null) {
                    this.M.remove(obj);
                }
            }
        }
    }

    public final int c() {
        synchronized (this.G) {
            if (this.G.isEmpty()) {
                return -1;
            }
            return this.G.get(0).intValue();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.a.b
    public final void c(int i) {
        if (c() == 0 && i == 0 && k() && !l() && this.P && !this.B.get()) {
            j();
        }
    }

    protected void c(boolean z) {
        if (z) {
            U();
        } else {
            V();
        }
    }

    protected final void c(Object... objArr) {
        if (objArr.length == 0) {
            return;
        }
        synchronized (this.N) {
            WeakHashMap<Object, Runnable> weakHashMap = this.N.get(1);
            if (sg.bigo.ads.common.utils.k.a(weakHashMap)) {
                return;
            }
            for (Object obj : objArr) {
                if (obj != null) {
                    weakHashMap.remove(obj);
                }
            }
        }
    }

    public final int d() {
        synchronized (this.G) {
            if (this.G.size() < 2) {
                return -1;
            }
            return this.G.get(1).intValue();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.a.b
    public void d(int i) {
        this.P = false;
        Runnable runnable = this.Q;
        if (runnable != null) {
            sg.bigo.ads.common.n.d.a(2, runnable);
            this.Q = null;
        } else if (this.B.get()) {
            h();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected final void d(boolean z) {
        if (this.A == null || (this.A.getVisibility() == 0 && this.A.c)) {
            e(z);
        }
    }

    protected final void e() {
        synchronized (this.N) {
            WeakHashMap<Object, Runnable> weakHashMapRemove = this.N.remove(1);
            if (sg.bigo.ads.common.utils.k.a(weakHashMapRemove)) {
                return;
            }
            Iterator<Map.Entry<Object, Runnable>> it = weakHashMapRemove.entrySet().iterator();
            while (it.hasNext()) {
                Runnable value = it.next().getValue();
                if (value != null) {
                    sg.bigo.ads.common.n.d.a(2, value);
                }
            }
        }
    }

    protected final void e(int i) {
        StringBuilder sbAppend;
        if (this.D == null) {
            return;
        }
        TextView textView = (TextView) this.D.findViewById(R.id.inter_advertiser);
        TextView textView2 = (TextView) this.D.findViewById(R.id.inter_ad_label);
        if (aq()) {
            if (TextUtils.isEmpty(this.l) || textView2 == null || textView2.getContext() == null) {
                return;
            }
            String strA = sg.bigo.ads.common.utils.a.a(textView2.getContext(), R.string.bigo_ad_tag, new Object[0]);
            if (!M()) {
                textView2.setText(this.l + " · " + strA);
                return;
            }
            sbAppend = new StringBuilder().append(strA);
        } else {
            if (textView == null || textView2 == null) {
                return;
            }
            if (TextUtils.isEmpty(this.l)) {
                textView.setVisibility(8);
                return;
            }
            if (!M()) {
                if (i != R.layout.bigo_ad_activity_interstitial_native_top) {
                    textView.bringToFront();
                }
                textView.setText(this.l);
                textView.setPadding(sg.bigo.ads.common.utils.e.a(this.D.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView.getContext(), 1), sg.bigo.ads.common.utils.e.a(textView.getContext(), 4), sg.bigo.ads.common.utils.e.a(textView.getContext(), 1));
                textView2.setText(R.string.bigo_ad_tag);
                return;
            }
            textView.setVisibility(8);
            sbAppend = new StringBuilder().append(sg.bigo.ads.common.utils.a.a(textView2.getContext(), R.string.bigo_ad_tag, new Object[0]));
        }
        textView2.setText(sbAppend.append(" · ").append(this.l).toString());
    }

    protected final void e(boolean z) {
        if (f(z)) {
            i(c());
            super.d(true);
        }
    }

    protected void f(int i) {
        p pVar;
        sg.bigo.ads.ad.interstitial.e.c cVar = this.s;
        if (cVar != null) {
            sg.bigo.ads.ad.interstitial.e.c.a aVar = cVar.g;
            if (i == 0) {
                aVar.f12803a = 1;
            } else if (i == 1) {
                aVar.f12803a = 3;
            } else if (i == 9) {
                aVar.f12803a = 4;
            } else if (i == 10) {
                aVar.f12803a = 2;
            }
        }
        synchronized (this.G) {
            synchronized (this.G) {
                this.G.remove(Integer.valueOf(i));
            }
            this.G.add(0, Integer.valueOf(i));
        }
        int iD = d();
        int iC = c();
        if (iC != iD) {
            i(iD);
        }
        if (this.C != null) {
            this.C.e(i);
        }
        if (((i == 0) | (i == 1) | (i == 2) | (i == 4) | (i == 5) | (i == 6) | (i == 7) | (i == 8) | (i == 9)) && this.C != null) {
            ((sg.bigo.ads.core.a.a) this.C.f()).b(SystemClock.elapsedRealtime());
        }
        if (i != 0 && i != 10 && i != 3 && (pVar = this.r) != null) {
            pVar.b();
        }
        switch (iC) {
            case 0:
                sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.i;
                if (bVar != null) {
                    bVar.a(1, 1);
                }
                l lVar = this.L;
                lVar.a(lVar.b);
                return;
            case 1:
                sg.bigo.ads.ad.interstitial.multi_img.b bVarD = ((s) this.y).D();
                if (bVarD != null) {
                    bVarD.a(2, 1);
                }
                l lVar2 = this.L;
                lVar2.a(lVar2.d);
                w wVar = this.h;
                if (wVar == null || !wVar.d) {
                    h(R.drawable.bigo_ad_ic_close);
                    return;
                }
                return;
            case 2:
            case 8:
            case 9:
                h(R.drawable.bigo_ad_ic_close);
                l lVar3 = this.L;
                lVar3.a(lVar3.e);
                return;
            case 3:
            case 6:
            default:
                return;
            case 4:
                l lVar4 = this.L;
                lVar4.a(lVar4.g);
                return;
            case 5:
                l lVar5 = this.L;
                lVar5.a(lVar5.f);
                w wVar2 = this.h;
                if (wVar2 == null || !wVar2.d) {
                    h(R.drawable.bigo_ad_ic_close);
                    return;
                }
                return;
            case 7:
                l lVar6 = this.L;
                lVar6.a(lVar6.h);
                w wVar3 = this.h;
                if (wVar3 == null || !wVar3.d) {
                    h(R.drawable.bigo_ad_ic_close);
                    return;
                }
                return;
            case 10:
                l lVar7 = this.L;
                lVar7.a(lVar7.c);
                return;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // sg.bigo.ads.ad.interstitial.i
    protected final boolean f() {
        FrameLayout.LayoutParams layoutParams;
        int i;
        String str;
        byte b = 0;
        if (this.y == 0) {
            return false;
        }
        if (((s) this.y).w instanceof sg.bigo.ads.ad.b.b) {
            Context context = this.I;
            if (context == null) {
                context = ((s) this.y).w.b.e;
            }
            if (context != null) {
                o<s> oVar = new o<>((sg.bigo.ads.ad.b.b) ((s) this.y).w, this, new o.b() { // from class: sg.bigo.ads.ad.interstitial.a.9
                    @Override // sg.bigo.ads.ad.interstitial.o.b
                    public final void a(sg.bigo.ads.ad.b.d dVar) {
                        if (dVar == null) {
                            a.this.ap();
                            return;
                        }
                        s sVar = (s) a.this.y;
                        if (sVar.z != null) {
                            sVar.w = dVar;
                            s.b bVar = sVar.z;
                            Pair<sg.bigo.ads.ad.interstitial.a.b, sg.bigo.ads.ad.interstitial.a.a> pair = (dVar == null || bVar.f12935a == null) ? null : bVar.f12935a.get(dVar);
                            if (pair != null) {
                                sVar.x = (sg.bigo.ads.ad.interstitial.a.b) pair.first;
                                sVar.y = (sg.bigo.ads.ad.interstitial.a.a) pair.second;
                            }
                        }
                        a.this.C = dVar;
                        a.this.Q();
                    }
                });
                this.H = oVar;
                oVar.p = this.L;
                final o<s> oVar2 = this.H;
                ViewGroup viewGroup = (ViewGroup) oVar2.b.l(R.id.inter_container);
                if (viewGroup != null) {
                    final sg.bigo.ads.api.a.m mVar = oVar2.d;
                    if (mVar != null) {
                        List<sg.bigo.ads.ad.b.d> listX = oVar2.c.x();
                        if (listX == null || listX.size() == 0) {
                            sg.bigo.ads.common.t.a.a(0, "InterstitialDoubleVideoRenderer", "Failed to start with null ready video list.");
                            oVar2.e.a(null);
                            o.c.a("Error native videos");
                        } else {
                            sg.bigo.ads.ad.b.b bVar = oVar2.c;
                            String[] strArr = bVar.x != null ? bVar.x.e : new String[]{"", ""};
                            if (listX.size() == 1) {
                                sg.bigo.ads.ad.b.d dVar = listX.get(0);
                                if (dVar == oVar2.c.v) {
                                    i = 1;
                                } else {
                                    i = dVar == oVar2.c.w ? 2 : 0;
                                }
                                oVar2.a(false, null, dVar, i, false, true);
                            } else {
                                boolean z = oVar2.d.a("multi_ads.page_layout") == 2;
                                final Context context2 = oVar2.b.y.b.e;
                                FrameLayout frameLayout = new FrameLayout(context2);
                                oVar2.f = frameLayout;
                                viewGroup.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                                View view = new View(context2);
                                sg.bigo.ads.ad.b.d dVar2 = listX.get(0);
                                sg.bigo.ads.ad.b.d dVar3 = listX.get(1);
                                Integer numF = dVar2.F();
                                Integer numF2 = dVar3.F();
                                if (numF == null) {
                                    numF = Integer.valueOf(sg.bigo.ads.common.utils.q.b("#01B5FF", -16776961));
                                }
                                if (numF2 == null) {
                                    numF2 = Integer.valueOf(sg.bigo.ads.common.utils.q.b("#FF0054", SupportMenu.CATEGORY_MASK));
                                }
                                oVar2.k = new o.d(b);
                                o.d dVar4 = oVar2.k;
                                GradientDrawable gradientDrawable = new GradientDrawable();
                                gradientDrawable.setGradientType(0);
                                gradientDrawable.setColors(new int[]{numF.intValue(), numF2.intValue()});
                                gradientDrawable.setOrientation(GradientDrawable.Orientation.BR_TL);
                                gradientDrawable.setGradientCenter(0.0f, 0.0f);
                                dVar4.c = numF;
                                dVar4.d = numF2;
                                dVar4.b = gradientDrawable;
                                view.setBackground(gradientDrawable);
                                oVar2.q = view;
                                frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
                                LinearLayout linearLayout = new LinearLayout(context2);
                                linearLayout.setOrientation(1);
                                frameLayout.addView(linearLayout);
                                FrameLayout frameLayout2 = new FrameLayout(context2);
                                linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context2, z ? 32 : 50)));
                                if (!z) {
                                    RoundedFrameLayout roundedFrameLayout = new RoundedFrameLayout(context2);
                                    roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(context2, 16));
                                    roundedFrameLayout.setStrokeWidth(sg.bigo.ads.common.utils.e.a(context2, 1) * 1.5f);
                                    roundedFrameLayout.setStrokeColor(sg.bigo.ads.common.utils.q.b("#7FFFFFFF", -1));
                                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, sg.bigo.ads.common.utils.e.a(context2, 25), 21);
                                    layoutParams2.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
                                    frameLayout2.addView(roundedFrameLayout, layoutParams2);
                                    FrameLayout frameLayout3 = new FrameLayout(context2);
                                    frameLayout3.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#1C000000", -7829368));
                                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -1);
                                    int iA = sg.bigo.ads.common.utils.e.a(context2, 2);
                                    layoutParams3.setMargins(iA, iA, iA, iA);
                                    roundedFrameLayout.addView(frameLayout3, layoutParams3);
                                    TextView textView = new TextView(context2);
                                    textView.setTextColor(-1);
                                    textView.setTextSize(14.0f);
                                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 17);
                                    layoutParams4.leftMargin = sg.bigo.ads.common.utils.e.a(context2, 12);
                                    layoutParams4.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 12);
                                    frameLayout3.addView(textView, layoutParams4);
                                    oVar2.g = textView;
                                }
                                final RoundedFrameLayout roundedFrameLayout2 = new RoundedFrameLayout(context2);
                                roundedFrameLayout2.setCornerRadius(sg.bigo.ads.common.utils.e.a(context2, 6));
                                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1, 1.0f);
                                layoutParams5.leftMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
                                layoutParams5.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
                                linearLayout.addView(roundedFrameLayout2, layoutParams5);
                                oVar2.h = roundedFrameLayout2;
                                oVar2.a(context2, roundedFrameLayout2, listX.get(0), strArr[0], oVar2.m);
                                FrameLayout frameLayout4 = new FrameLayout(context2);
                                linearLayout.addView(frameLayout4, new LinearLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context2, z ? 80 : 64)));
                                TextView textView2 = new TextView(context2);
                                textView2.setTextColor(-1);
                                textView2.setTextSize(20.0f);
                                textView2.setTypeface(Typeface.defaultFromStyle(1));
                                textView2.setSingleLine(true);
                                textView2.setText(R.string.bigo_ad_double_video_choose_video);
                                if (z) {
                                    layoutParams = new FrameLayout.LayoutParams(-2, -2, 49);
                                    layoutParams.topMargin = sg.bigo.ads.common.utils.e.a(context2, 16);
                                    frameLayout4.addView(textView2, layoutParams);
                                    TextView textView3 = new TextView(context2);
                                    textView3.setTextColor(sg.bigo.ads.common.utils.q.b("#C8FFFFFF", -1));
                                    textView3.setTextSize(13.0f);
                                    FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2, 81);
                                    layoutParams6.bottomMargin = sg.bigo.ads.common.utils.e.a(context2, 18);
                                    frameLayout4.addView(textView3, layoutParams6);
                                    oVar2.g = textView3;
                                } else {
                                    layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
                                    frameLayout4.addView(textView2, layoutParams);
                                }
                                final RoundedFrameLayout roundedFrameLayout3 = new RoundedFrameLayout(context2);
                                roundedFrameLayout3.setCornerRadius(sg.bigo.ads.common.utils.e.a(context2, 6));
                                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -1, 1.0f);
                                layoutParams7.leftMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
                                layoutParams7.rightMargin = sg.bigo.ads.common.utils.e.a(context2, 10);
                                linearLayout.addView(roundedFrameLayout3, layoutParams7);
                                oVar2.i = roundedFrameLayout3;
                                oVar2.a(context2, roundedFrameLayout3, listX.get(1), strArr[1], oVar2.n);
                                linearLayout.addView(new FrameLayout(context2), new LinearLayout.LayoutParams(-1, sg.bigo.ads.common.utils.e.a(context2, 32)));
                                roundedFrameLayout2.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.o.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        sg.bigo.ads.ad.interstitial.c.a(roundedFrameLayout2, -sg.bigo.ads.common.utils.e.a(context2, 40));
                                    }
                                });
                                roundedFrameLayout3.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.o.4
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        sg.bigo.ads.ad.interstitial.c.a(roundedFrameLayout3, sg.bigo.ads.common.utils.e.a(context2, 40));
                                    }
                                });
                                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.o.5
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        int iA2 = mVar.a("multi_ads.auto_play_time");
                                        int i2 = 3;
                                        if (iA2 != 1) {
                                            if (iA2 == 2) {
                                                i2 = 5;
                                            } else {
                                                i2 = iA2 == 3 ? 10 : 15;
                                            }
                                        }
                                        o.this.j = new e(i2);
                                        o.this.j.f12893a.c();
                                    }
                                });
                                o<s>.c cVar = oVar2.f12874a;
                                sg.bigo.ads.ad.b.d dVar5 = oVar2.c.v;
                                cVar.f12891a = SystemClock.elapsedRealtime();
                                sg.bigo.ads.core.d.b.a(dVar5 == null ? null : (sg.bigo.ads.core.a.a) dVar5.f(), true, 1, 0, false, -1L, o.this.m.f12890a, o.this.m.b, -1L, o.this.n.f12890a, o.this.n.b, -1L);
                                if (oVar2.p != null) {
                                    l lVar = oVar2.p;
                                    lVar.a(lVar.f12841a);
                                }
                            }
                        }
                        return true;
                    }
                    sg.bigo.ads.common.t.a.a(0, "InterstitialDoubleVideoRenderer", "Failed to start with null style config.");
                    str = "Error style config";
                    return true;
                }
                sg.bigo.ads.common.t.a.a(0, "InterstitialDoubleVideoRenderer", "Failed to start with null container.");
                str = "Error container";
                o.c.a(str);
                oVar2.e.a(null);
                return true;
            }
        }
        return false;
    }

    protected abstract boolean f(boolean z);

    /* JADX WARN: Code duplicated, block: B:61:0x015d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0192  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void g(int i) {
        final View viewFindViewById;
        Bitmap bitmapA;
        IconListView iconListView;
        sg.bigo.ads.api.a.m mVar;
        super.g(i);
        if (this.D == null) {
            return;
        }
        ((s) this.y).A = this.L;
        t tVarZ = Z();
        if (tVarZ instanceof sg.bigo.ads.ad.interstitial.d.a) {
            if (tVarZ instanceof sg.bigo.ads.ad.interstitial.d.m) {
                ((sg.bigo.ads.ad.interstitial.d.m) tVarZ).a(this, this.D, this.h, this.i, this.j);
            } else {
                ((sg.bigo.ads.ad.interstitial.d.a) tVarZ).a(this, this.D, this.h, this.c, this.j);
            }
            o();
        }
        p();
        q();
        if (this.D != null) {
            Button button = (Button) this.D.findViewById(R.id.inter_btn_cta);
            TextView textView = (TextView) this.D.findViewById(R.id.inter_company);
            sg.bigo.ads.api.a.m mVar2 = this.c;
            if (mVar2 != null) {
                int iA = mVar2.a("video_play_page.cta_color");
                int iA2 = this.c.a("endpage.cta_color");
                int iA3 = this.c.a("layer.cta_color");
                this.m = r.a(((s) this.y).w, iA, null);
                this.n = r.a(((s) this.y).w, iA2, null);
                this.o = r.a(((s) this.y).w, iA3, null);
                if (!(Z() instanceof sg.bigo.ads.ad.interstitial.d.a)) {
                    if (button != null) {
                        button.setBackgroundColor(this.m);
                    }
                    if (textView != null) {
                        textView.setTextColor(this.m);
                    }
                }
            }
            if (M() && this.c != null) {
                View viewFindViewById2 = this.D.findViewById(R.id.inter_media_container);
                int iA4 = this.c.a("video_play_page.background_colour");
                if ((!aq() ? !(iA4 == 3 || iA4 == 4) : !(iA4 == 4 || iA4 == 5)) && viewFindViewById2 != null) {
                    viewFindViewById2.setBackgroundColor(sg.bigo.ads.common.utils.q.b("#66000000", -7829368));
                    TextView textView2 = (TextView) this.D.findViewById(R.id.inter_warning);
                    if (textView2 != null) {
                        textView2.setTextColor(sg.bigo.ads.common.utils.q.b("#66FFFFFF", -1));
                    }
                }
            }
        }
        if (!(Z() instanceof sg.bigo.ads.ad.interstitial.d.a) && this.D != null) {
            ViewGroup viewGroup = this.D;
            View viewFindViewById3 = viewGroup.findViewById(R.id.inter_download_msg);
            if (viewFindViewById3 != null) {
                f fVar = this.j;
                if (fVar == null || !fVar.d) {
                    viewFindViewById3.setVisibility(8);
                } else {
                    Button button2 = (Button) viewGroup.findViewById(R.id.inter_btn_cta);
                    if (button2 != null) {
                        button2.setText(R.string.bigo_ad_cta_download_default);
                    }
                    Z().a(viewGroup, viewFindViewById3, Y(), 8, this.h.i, new View[0]);
                    if (aq()) {
                        iconListView = (IconListView) viewGroup.findViewById(R.id.inter_iconlist_download_msg_list);
                        if (this.j != null) {
                            if (aq()) {
                                iconListView.setThemeWhite(true);
                            } else {
                                iconListView.setThemeWhite(true);
                            }
                            iconListView.a(this.j);
                            iconListView.setVisibility(0);
                        }
                    }
                }
            } else if (aq()) {
                iconListView = (IconListView) viewGroup.findViewById(R.id.inter_iconlist_download_msg_list);
                if (this.j != null && iconListView != null) {
                    if (aq() || !M() || (mVar = this.c) == null) {
                        iconListView.setThemeWhite(true);
                    } else {
                        int iA5 = mVar.a("video_play_page.background_colour");
                        iconListView.setThemeWhite(!aq() ? iA5 == 1 : iA5 == 1);
                    }
                    iconListView.a(this.j);
                    iconListView.setVisibility(0);
                }
            }
        }
        r();
        u();
        f(0);
        H();
        ((s) this.y).f().a(this.d);
        a(this.D);
        x();
        a(((long) this.h.b) * 1000);
        if (aq() && this.D != null && (viewFindViewById = this.D.findViewById(R.id.inter_ad_info_card_right_bottom)) != null) {
            ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.inter_star);
            View viewFindViewById4 = viewFindViewById.findViewById(R.id.bigo_ad_info_card_background);
            if (imageView != null && viewFindViewById4 != 0) {
                f fVar2 = this.j;
                String creativeId = fVar2 != null ? fVar2.c : "";
                if (this.C != null && sg.bigo.ads.common.utils.q.a((CharSequence) creativeId)) {
                    creativeId = this.C.getCreativeId();
                }
                float fA = (sg.bigo.ads.ad.b.f.a(creativeId, 4) * 0.5f) + 3.5f;
                d dVar = new d();
                TextView textView3 = (TextView) viewFindViewById.findViewById(R.id.inter_title);
                TextView textView4 = (TextView) viewFindViewById.findViewById(R.id.inter_description);
                if (textView3 != null) {
                    dVar.b(textView3);
                }
                if (textView4 != null) {
                    dVar.b(textView4);
                }
                sg.bigo.ads.api.a.m mVar3 = this.c;
                int iA6 = mVar3 != null ? mVar3.a("video_play_page.card_background_colour") : -1;
                if (iA6 == 1) {
                    bitmapA = sg.bigo.ads.common.utils.d.a(this.D.getContext(), fA, R.drawable.bigo_ad_ic_star, R.drawable.bigo_ad_ic_star_normal, R.drawable.bigo_ad_ic_star_half);
                    viewFindViewById4.setBackgroundColor(-1);
                    dVar.a(-1);
                } else {
                    if (iA6 == 2) {
                        viewFindViewById4.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                        dVar.a(ViewCompat.MEASURED_STATE_MASK);
                    } else {
                        sg.bigo.ads.ad.interstitial.e.b bVar = new sg.bigo.ads.ad.interstitial.e.b(sg.bigo.ads.common.utils.e.a(imageView.getContext(), 12), 0.0f, new sg.bigo.ads.ad.interstitial.e.a.b() { // from class: sg.bigo.ads.ad.interstitial.a.15
                        }.a());
                        Drawable drawableA = bVar.a();
                        if (drawableA != null) {
                            viewFindViewById4.setBackground(drawableA);
                        } else if (viewFindViewById4 instanceof sg.bigo.ads.common.view.a.c) {
                            ((sg.bigo.ads.common.view.a.c) viewFindViewById4).setBlurStyle(bVar);
                        }
                    }
                    bitmapA = sg.bigo.ads.common.utils.d.a(this.D.getContext(), fA, R.drawable.bigo_ad_ic_star_white, R.drawable.bigo_ad_ic_star_normal, R.drawable.bigo_ad_ic_star_half_white);
                }
                if (bitmapA != null) {
                    imageView.setImageBitmap(bitmapA);
                    imageView.setVisibility(0);
                }
            }
            viewFindViewById.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.16
                @Override // java.lang.Runnable
                public final void run() {
                    AnimationSet animationSet = new AnimationSet(true);
                    Interpolator interpolatorA = sg.bigo.ads.common.utils.b.a(2);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(300L);
                    alphaAnimation.setInterpolator(interpolatorA);
                    animationSet.addAnimation(alphaAnimation);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, 1, 1.0f, 1, 1.0f);
                    scaleAnimation.setDuration(300L);
                    alphaAnimation.setInterpolator(interpolatorA);
                    animationSet.addAnimation(scaleAnimation);
                    viewFindViewById.startAnimation(animationSet);
                }
            });
        }
        if (M() && this.D != null) {
            TextView textView5 = (TextView) this.D.findViewById(R.id.inter_title);
            TextView textView6 = (TextView) this.D.findViewById(R.id.inter_description);
            sg.bigo.ads.api.a.m mVar4 = this.c;
            int i2 = (mVar4 != null ? mVar4.a("video_play_page.background_colour") : -1) == 1 ? -16777216 : -1;
            if (textView5 != null) {
                textView5.setTextColor(i2);
            }
            if (textView6 != null) {
                textView6.setTextColor(i2);
            }
        }
        this.r = new p(this.I, ((s) this.y).w, ((s) this.y).f(), this.c, aq(), this.j, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.11
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.A != null) {
                    a.this.A.setAlpha(0.0f);
                }
                a.this.f(10);
            }
        }, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.12
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.A != null) {
                    a.this.A.setAlpha(1.0f);
                }
                a aVar = a.this;
                aVar.f(aVar.d());
                a.this.ao();
                if (a.this.c() == 0) {
                    a.this.h();
                }
            }
        }, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.13
            @Override // java.lang.Runnable
            public final void run() {
                a.this.d(false);
            }
        });
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.14
            @Override // java.lang.Runnable
            public final void run() {
                p pVar = a.this.r;
                sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Active mid page.");
                sg.bigo.ads.api.a.m mVar5 = pVar.d;
                Context context = pVar.f12896a;
                if (mVar5 == null) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Inactive mid page due to empty style config.");
                    return;
                }
                if (context == null) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Inactive mid page due to empty context.");
                    return;
                }
                int iA7 = mVar5.a("mid_page.show_time");
                if (iA7 != -1 && iA7 != 0 && iA7 != 3 && iA7 != 5 && iA7 != 10) {
                    iA7 = 0;
                }
                pVar.E = iA7;
                if (pVar.E == 0) {
                    pVar.i = false;
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Inactive mid page due to show_time in config.");
                    return;
                }
                p.d dVar2 = pVar.A;
                dVar2.b = mVar5.a("mid_page.pop_layout");
                dVar2.f12927a = mVar5.a("mid_page.pop_method");
                dVar2.c = mVar5.a("mid_page.cta_color");
                p.a aVar = pVar.z;
                aVar.p = pVar;
                aVar.e = mVar5.c("mid_page.is_cta_show_animation");
                aVar.f12922a = mVar5.a("mid_page.click_type");
                aVar.b = mVar5.c("mid_page.ad_component_clickable_switch");
                aVar.c = mVar5.c("mid_page.media_view_clickable_switch");
                aVar.d = mVar5.c("mid_page.other_space_clickable_switch");
                int iA8 = mVar5.a("mid_page.below_area_dp");
                if (iA8 > 0) {
                    aVar.f = sg.bigo.ads.common.utils.e.a(context, iA8);
                }
                aVar.g = mVar5.a("mid_page.below_area_clickable") == 1;
                int iA9 = mVar5.a("mid_page.up_area_dp");
                if (iA9 > 0) {
                    aVar.h = sg.bigo.ads.common.utils.e.a(context, iA9);
                }
                aVar.i = mVar5.a("mid_page.up_area_clickable") == 1;
                aVar.j = sg.bigo.ads.common.utils.e.c(context);
                aVar.n = new View(context);
                aVar.o = new View(context);
                Context context2 = pVar.f12896a;
                sg.bigo.ads.ad.b.c cVar = pVar.b;
                sg.bigo.ads.api.core.c cVar2 = pVar.c;
                if (pVar.a(context2, cVar, cVar2, pVar.d)) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Start render mid page.");
                    int i3 = pVar.A.f12927a;
                    ArrayList arrayList = new ArrayList();
                    if (pVar.o) {
                        arrayList.add(2);
                    } else {
                        if (i3 == 1) {
                            arrayList.add(1);
                        }
                        if (i3 == 2) {
                            arrayList.add(1);
                            arrayList.add(2);
                            arrayList.add(3);
                            arrayList.add(4);
                        }
                        if (i3 == 3) {
                            arrayList.add(2);
                        }
                        if (i3 == 4) {
                            arrayList.add(2);
                            arrayList.add(3);
                            arrayList.add(1);
                            arrayList.add(4);
                        }
                        if (i3 == 5) {
                            arrayList.add(2);
                            arrayList.add(3);
                            arrayList.add(4);
                        }
                        if (i3 == 6) {
                            arrayList.add(3);
                        }
                        if (i3 == 7) {
                            arrayList.add(3);
                            arrayList.add(2);
                            arrayList.add(1);
                            arrayList.add(4);
                        }
                        if (i3 == 8) {
                            arrayList.add(3);
                            arrayList.add(2);
                            arrayList.add(4);
                        }
                        if (i3 == 9) {
                        }
                        pVar.t = arrayList;
                        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.3

                            /* JADX INFO: renamed from: a */
                            final /* synthetic */ Context f12915a;
                            final /* synthetic */ sg.bigo.ads.ad.b.c b;
                            final /* synthetic */ sg.bigo.ads.api.core.c c;

                            AnonymousClass3() {
                                context = context2;
                                cVar = cVar;
                                cVar = cVar2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                p.a(p.this, context, cVar, cVar);
                            }
                        });
                    }
                    arrayList.add(4);
                    pVar.t = arrayList;
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.3

                        /* JADX INFO: renamed from: a */
                        final /* synthetic */ Context f12915a;
                        final /* synthetic */ sg.bigo.ads.ad.b.c b;
                        final /* synthetic */ sg.bigo.ads.api.core.c c;

                        AnonymousClass3() {
                            context = context2;
                            cVar = cVar;
                            cVar = cVar2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            p.a(p.this, context, cVar, cVar);
                        }
                    });
                }
                p.AnonymousClass1 anonymousClass1 = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.p.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (!p.a(p.this)) {
                            if (p.this.x != null) {
                                p.this.x.run();
                                p.this.x = null;
                            }
                            p.this.g();
                        }
                        p.b(p.this);
                    }
                };
                if (pVar.E > 0) {
                    pVar.u = ((long) pVar.E) * 1000;
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Mid page will be shown after " + pVar.E + "s.");
                    pVar.v = anonymousClass1;
                    pVar.a(pVar.u);
                    pVar.a();
                    return;
                }
                if (pVar.E != -1) {
                    sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Mid page can not be shown due to invalid show delay.");
                    return;
                }
                sg.bigo.ads.common.t.a.a(0, 3, "InterstitialMidPageRenderer", "Mid page will be shown after video completion.");
                pVar.w = anonymousClass1;
                pVar.a();
            }
        });
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected final boolean g() {
        return ad();
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void h() {
        l lVar;
        sg.bigo.ads.core.a.a aVarF;
        int i;
        sg.bigo.ads.ad.interstitial.e.c cVar;
        sg.bigo.ads.ad.interstitial.g.a aVar;
        super.h();
        int iC = c();
        p pVar = this.r;
        if (pVar != null) {
            pVar.c();
        }
        o<s> oVar = this.H;
        if (oVar != null && !oVar.l) {
            if (oVar.j != null) {
                oVar.j.f12893a.c();
            }
            if (oVar.f12874a != null) {
                o<s>.c cVar2 = oVar.f12874a;
                if (cVar2.b != 0) {
                    cVar2.c += SystemClock.elapsedRealtime() - cVar2.b;
                }
            }
            if (oVar.p != null) {
                l lVar2 = oVar.p;
                lVar2.a(oVar.c.f(), lVar2.f12841a);
            }
        }
        if (iC == 0) {
            lVar = this.L;
            aVarF = ((s) this.y).f();
            i = lVar.b;
        } else if (iC == 10) {
            lVar = this.L;
            aVarF = ((s) this.y).f();
            i = lVar.c;
        } else if (iC == 1) {
            lVar = this.L;
            aVarF = ((s) this.y).f();
            i = lVar.d;
        } else if (iC == 2 || iC == 8 || iC == 9) {
            lVar = this.L;
            aVarF = ((s) this.y).f();
            i = lVar.e;
        } else if (iC == 5) {
            lVar = this.L;
            aVarF = ((s) this.y).f();
            i = lVar.f;
        } else {
            if (iC != 4) {
                if (iC == 7) {
                    lVar = this.L;
                    aVarF = ((s) this.y).f();
                    i = lVar.h;
                }
                cVar = this.s;
                if (cVar != null) {
                    cVar.l = false;
                    sg.bigo.ads.ad.interstitial.e.c.b(cVar.k, cVar.i);
                    sg.bigo.ads.ad.interstitial.e.c.b(cVar.j, cVar.h);
                }
                aVar = this.t;
                if (aVar != null) {
                    aVar.b();
                }
            }
            lVar = this.L;
            aVarF = ((s) this.y).f();
            i = lVar.g;
        }
        lVar.a(aVarF, i);
        cVar = this.s;
        if (cVar != null) {
            cVar.l = false;
            sg.bigo.ads.ad.interstitial.e.c.b(cVar.k, cVar.i);
            sg.bigo.ads.ad.interstitial.e.c.b(cVar.j, cVar.h);
        }
        aVar = this.t;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.i
    protected final boolean i() {
        return ad();
    }

    @Override // sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void j() {
        l lVar;
        sg.bigo.ads.core.a.a aVarF;
        int i;
        l lVar2;
        sg.bigo.ads.core.a.a aVarF2;
        int i2;
        super.j();
        int iC = c();
        p pVar = this.r;
        if (pVar != null) {
            pVar.d();
        }
        o<s> oVar = this.H;
        if (oVar != null && !oVar.l) {
            if (oVar.j != null) {
                oVar.j.f12893a.d();
            }
            if (oVar.f12874a != null) {
                oVar.f12874a.b = SystemClock.elapsedRealtime();
            }
            if (oVar.p != null) {
                l lVar3 = oVar.p;
                lVar3.a(oVar.c.f(), lVar3.f12841a, oVar.m.f12890a, oVar.m.b, oVar.n.f12890a, oVar.n.b);
            }
        }
        if (iC == 0) {
            l lVar4 = this.L;
            lVar4.a(((s) this.y).f(), lVar4.b, -1, -1, -1, -1);
        } else {
            if (iC == 10) {
                lVar2 = this.L;
                aVarF2 = ((s) this.y).f();
                i2 = lVar2.c;
            } else {
                if (iC == 1) {
                    lVar = this.L;
                    aVarF = ((s) this.y).f();
                    i = lVar.d;
                } else if (iC == 2 || iC == 8 || iC == 9) {
                    lVar = this.L;
                    aVarF = ((s) this.y).f();
                    i = lVar.e;
                } else if (iC == 5) {
                    lVar2 = this.L;
                    aVarF2 = ((s) this.y).f();
                    i2 = lVar2.f;
                } else if (iC == 4) {
                    lVar2 = this.L;
                    aVarF2 = ((s) this.y).f();
                    i2 = lVar2.g;
                } else if (iC == 7) {
                    lVar2 = this.L;
                    aVarF2 = ((s) this.y).f();
                    i2 = lVar2.h;
                }
                lVar.a(aVarF, i, -1, -1, -1, -1);
            }
            lVar2.a(aVarF2, i2, -1, -1, -1, -1);
        }
        sg.bigo.ads.ad.interstitial.e.c cVar = this.s;
        if (cVar != null) {
            cVar.l = true;
            sg.bigo.ads.ad.interstitial.e.c.a(cVar.k, cVar.i);
            sg.bigo.ads.ad.interstitial.e.c.a(cVar.j, cVar.h);
        }
        sg.bigo.ads.ad.interstitial.g.a aVar = this.t;
        if (aVar != null) {
            aVar.c();
        }
    }

    protected final boolean k() {
        Object objZ = Z();
        if (objZ instanceof sg.bigo.ads.ad.interstitial.f.b) {
            return ((sg.bigo.ads.ad.interstitial.f.b) objZ).J();
        }
        return false;
    }

    protected final boolean l() {
        if (c() != 0 || !this.P) {
            return false;
        }
        Object objZ = Z();
        if (objZ instanceof sg.bigo.ads.ad.interstitial.f.b) {
            return ((sg.bigo.ads.ad.interstitial.f.b) objZ).K();
        }
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.q, sg.bigo.ads.ad.interstitial.i
    protected void m() {
        super.m();
        this.l = ((s) this.y).f().i();
        sg.bigo.ads.api.a.m mVarE = ((s) this.y).f().e();
        this.c = mVarE;
        if (mVarE != null) {
            this.d = true;
        }
        this.b = ((s) this.y).f().d().q();
        this.h = b();
        if (this.c == null || !this.d) {
            sg.bigo.ads.api.a.m mVar = this.b;
            if (mVar != null) {
                a(mVar);
                return;
            }
            return;
        }
        this.t = sg.bigo.ads.ad.interstitial.g.a.a(this.I, this.C, this.c, aq());
        this.s = new sg.bigo.ads.ad.interstitial.e.c((s) this.y, this.c, this.t);
        a(this.c);
        this.C.t = new WeakReference<>(this);
    }

    @Override // sg.bigo.ads.ad.interstitial.q
    protected final int n() {
        sg.bigo.ads.api.a.m mVar = this.c;
        if (mVar == null) {
            return 0;
        }
        if (this.d) {
            return mVar.a("video_play_page.ad_component_layout");
        }
        return 1;
    }

    protected final h.a o() {
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        sg.bigo.ads.api.a.m mVar = this.c;
        if (mVar != null) {
            int iA = this.d ? mVar.a("video_play_page.below_area_dp") : 0;
            boolean z3 = this.d && this.c.a("video_play_page.below_area_clickable") == 1;
            int iA2 = this.d ? this.c.a("video_play_page.up_area_dp") : 0;
            boolean z4 = this.d && this.c.a("video_play_page.up_area_clickable") == 1;
            int iA3 = this.c.a("video_play_page.click_type");
            a(this.D, iA, z3, iA2, z4, 8, iA3);
            i = iA;
            z = z3;
            i2 = iA2;
            z2 = z4;
            i3 = iA3;
        } else {
            i = 0;
            z = false;
            i2 = 0;
            z2 = false;
            i3 = 0;
        }
        return new h.a(i, z, i2, z2, i3);
    }

    protected void p() {
        int i;
        sg.bigo.ads.api.a.m mVar = this.c;
        if (mVar == null || !this.d) {
            return;
        }
        int iA = mVar.a("video_play_page.close_button_style");
        if (iA == 2) {
            i = R.drawable.bigo_ad_ic_close2;
        } else if (iA == 3) {
            i = R.drawable.bigo_ad_ic_close3;
        } else if (iA != 4) {
            i = iA != 5 ? R.drawable.bigo_ad_ic_close : R.drawable.bigo_ad_ic_close5;
        } else {
            i = R.drawable.bigo_ad_ic_close4;
        }
        h(i);
    }

    protected void q() {
        int iB;
        if ((((s) this.y).f() instanceof sg.bigo.ads.core.a.a) && ((s) this.y).y()) {
            final sg.bigo.ads.core.a.a aVarF = ((s) this.y).f();
            this.p.set(!aVarF.aY());
            if (this.p.get() && aVarF.bg() == null && (iB = w.b(this.h.n)) > 0) {
                sg.bigo.ads.common.utils.n nVar = new sg.bigo.ads.common.utils.n(((long) iB) * 1000) { // from class: sg.bigo.ads.ad.interstitial.a.2
                    @Override // sg.bigo.ads.common.utils.n
                    public final void a() {
                        aVarF.bb();
                        a aVar = a.this;
                        aVar.a(aVar.x, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.a.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                a.this.s();
                            }
                        });
                    }

                    @Override // sg.bigo.ads.common.utils.n
                    public final void a(long j) {
                    }
                };
                this.x = nVar;
                nVar.c();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00d4  */
    protected void r() {
        MediaView mediaView;
        YandexWarningTextView yandexWarningTextView;
        ViewGroup viewGroup = this.D;
        sg.bigo.ads.ad.b.c cVar = this.C;
        if (viewGroup == null || cVar == null) {
            return;
        }
        sg.bigo.ads.api.c.b.a(aq());
        if (t() && ((s) this.y).f().w() == 2) {
            sg.bigo.ads.api.c.b.a();
        }
        if (this.D != null && (mediaView = (MediaView) this.D.findViewById(R.id.inter_media)) != null && M()) {
            mediaView.setImageBlurBorder(false);
            ViewGroup viewGroup2 = this.D;
            sg.bigo.ads.ad.b.c cVar2 = this.C;
            if (viewGroup2 != null && (yandexWarningTextView = (YandexWarningTextView) viewGroup2.findViewById(R.id.inter_warning)) != null) {
                if (cVar2 != null && ((sg.bigo.ads.core.a.a) cVar2.f()).B() != null && ((sg.bigo.ads.core.a.a) cVar2.f()).B().f() >= 0) {
                    int iF = ((sg.bigo.ads.core.a.a) cVar2.f()).B().f();
                    View viewFindViewById = viewGroup2.findViewById(R.id.inter_ad_info_exclude_warning);
                    MediaView mediaView2 = (MediaView) viewGroup2.findViewById(R.id.inter_media);
                    RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) viewGroup2.findViewById(R.id.inter_media_layout);
                    float f = iF * 0.01f;
                    float f2 = f > 0.15f ? 0.15f : f;
                    if (viewFindViewById != null) {
                        yandexWarningTextView.setIsHorizontal(false);
                        sg.bigo.ads.common.utils.u.a(viewFindViewById, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.r.1

                            /* JADX INFO: renamed from: a */
                            final /* synthetic */ View f12930a;
                            final /* synthetic */ YandexWarningTextView b;
                            final /* synthetic */ RoundedFrameLayout c;
                            final /* synthetic */ float d;
                            final /* synthetic */ ViewGroup e;
                            final /* synthetic */ sg.bigo.ads.ad.b.c f;
                            final /* synthetic */ MediaView g;
                            final /* synthetic */ int h;

                            AnonymousClass1() {
                                view = viewFindViewById;
                                yandexWarningTextView = yandexWarningTextView;
                                roundedFrameLayout = roundedFrameLayout;
                                f = f2;
                                viewGroup = viewGroup2;
                                cVar = cVar2;
                                mediaView = mediaView2;
                                i = iF;
                            }

                            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                            public final void onGlobalLayout() {
                                int measuredHeight = view.getMeasuredHeight();
                                int iC = sg.bigo.ads.common.utils.e.c(view.getContext());
                                if (measuredHeight <= 0) {
                                    measuredHeight = sg.bigo.ads.common.utils.e.a(view.getContext(), 130);
                                }
                                int paddingTop = yandexWarningTextView.getPaddingTop();
                                int paddingBottom = yandexWarningTextView.getPaddingBottom();
                                int iA = sg.bigo.ads.common.utils.e.a(yandexWarningTextView.getContext(), 16);
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) yandexWarningTextView.getLayoutParams();
                                int i = marginLayoutParams.topMargin;
                                if (iC < 2000) {
                                    iA *= 2;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) roundedFrameLayout.getLayoutParams();
                                int i2 = marginLayoutParams2.topMargin;
                                int i3 = marginLayoutParams2.bottomMargin;
                                int i4 = marginLayoutParams2.leftMargin;
                                int i5 = marginLayoutParams2.rightMargin;
                                int iRound = Math.round(f * iC) + paddingBottom + paddingTop;
                                int i6 = (((((iC - measuredHeight) - iRound) - i) - iA) - i2) - i3;
                                if (iC <= 1000) {
                                    i6 = iC / 2;
                                    TextView textView = (TextView) viewGroup.findViewById(R.id.inter_description);
                                    if (textView != null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                                        marginLayoutParams3.topMargin = 0;
                                        textView.setLayoutParams(marginLayoutParams3);
                                    }
                                    ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.bigo_ad_btn_class);
                                    if (viewGroup3 != null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) viewGroup3.getLayoutParams();
                                        marginLayoutParams4.topMargin = 0;
                                        viewGroup3.setLayoutParams(marginLayoutParams4);
                                    }
                                    TextView textView2 = (TextView) viewGroup.findViewById(R.id.inter_title);
                                    if (textView2 != null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                                        marginLayoutParams5.topMargin = 0;
                                        textView2.setLayoutParams(marginLayoutParams5);
                                    }
                                }
                                int i7 = (view.getContext().getResources().getDisplayMetrics().widthPixels - i4) - i5;
                                sg.bigo.ads.common.p pVarA = r.a(cVar);
                                sg.bigo.ads.common.p pVarA2 = sg.bigo.ads.common.p.a(pVarA.b, pVarA.c, i7, i6);
                                RoundedFrameLayout roundedFrameLayout2 = roundedFrameLayout;
                                roundedFrameLayout2.setCornerRadius(sg.bigo.ads.common.utils.e.a(roundedFrameLayout2.getContext(), 8));
                                marginLayoutParams2.setMargins(i4, i2, i5, i3);
                                marginLayoutParams2.height = pVarA2.c;
                                marginLayoutParams2.width = pVarA2.b;
                                sg.bigo.ads.common.utils.u.c(mediaView, -1, -1);
                                roundedFrameLayout.setLayoutParams(marginLayoutParams2);
                                if (i == 0) {
                                    yandexWarningTextView.setVisibility(8);
                                    return;
                                }
                                marginLayoutParams.height = iRound;
                                marginLayoutParams.bottomMargin = iA;
                                yandexWarningTextView.setLayoutParams(marginLayoutParams);
                            }
                        });
                    } else if (iF != 0) {
                        yandexWarningTextView.setIsHorizontal(true);
                        yandexWarningTextView.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.r.2
                            final /* synthetic */ float b;
                            final /* synthetic */ sg.bigo.ads.ad.b.c c;
                            final /* synthetic */ RoundedFrameLayout d;
                            final /* synthetic */ MediaView e;

                            AnonymousClass2() {
                                f = f2;
                                cVar = cVar2;
                                roundedFrameLayout = roundedFrameLayout;
                                mediaView = mediaView2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                int iC = sg.bigo.ads.common.utils.e.c(yandexWarningTextView.getContext());
                                int i = yandexWarningTextView.getContext().getResources().getDisplayMetrics().widthPixels;
                                int iRound = Math.round(f * iC) + yandexWarningTextView.getPaddingBottom() + yandexWarningTextView.getPaddingTop();
                                ViewGroup.LayoutParams layoutParams = yandexWarningTextView.getLayoutParams();
                                int iA = sg.bigo.ads.common.utils.e.a(yandexWarningTextView.getContext(), 20);
                                int i2 = (i / 2) - (iA * 3);
                                sg.bigo.ads.common.p pVarA = r.a(cVar);
                                RoundedFrameLayout roundedFrameLayout2 = roundedFrameLayout;
                                roundedFrameLayout2.setCornerRadius(sg.bigo.ads.common.utils.e.a(roundedFrameLayout2.getContext(), 8));
                                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) roundedFrameLayout.getLayoutParams();
                                marginLayoutParams.setMargins(iA, iA, iA, iA);
                                if (pVarA.getHeight() <= pVarA.getWidth()) {
                                    marginLayoutParams.width = i2;
                                    marginLayoutParams.height = (int) (((pVarA.getHeight() * 1.0f) * i2) / pVarA.getWidth());
                                    sg.bigo.ads.common.utils.u.c(mediaView, -1, -1);
                                }
                                roundedFrameLayout.setLayoutParams(marginLayoutParams);
                                layoutParams.height = iRound;
                                yandexWarningTextView.setLayoutParams(layoutParams);
                            }
                        });
                    } else {
                        yandexWarningTextView.setVisibility(8);
                    }
                } else if (yandexWarningTextView != null) {
                    yandexWarningTextView.setVisibility(8);
                }
            }
        }
        Z().a(viewGroup, viewGroup, Y(), S() ? 8 : 1, this.h.i, this.A);
    }

    protected void s() {
    }

    protected boolean t() {
        if (!this.d) {
            return false;
        }
        switch (n()) {
            case 6:
                this.g = false;
                this.f = false;
                return !aq();
            case 7:
            case 8:
            case 9:
                this.g = false;
                this.f = false;
                return true;
            case 10:
                this.g = false;
                this.f = true;
                return true;
            case 11:
            case 12:
                this.g = true;
                this.f = false;
                return true;
            default:
                this.g = false;
                this.f = false;
                return false;
        }
    }

    protected void u() {
        sg.bigo.ads.api.a.m mVar;
        if (this.d && (mVar = this.c) != null) {
            long jA = ((long) mVar.a("video_play_page.guided_click_gesture_show_time")) * 1000;
            if (jA == 0) {
                return;
            }
            this.v = new AnonymousClass3(jA);
        }
    }

    protected final void v() {
        View viewFindViewById;
        if (this.D == null || (viewFindViewById = this.D.findViewById(R.id.inter_slide_gesture_contain)) == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new sg.bigo.ads.common.utils.b.c() { // from class: sg.bigo.ads.ad.interstitial.c.10

            /* JADX INFO: renamed from: a */
            final /* synthetic */ View f12655a;

            AnonymousClass10() {
                view = viewFindViewById;
            }

            @Override // sg.bigo.ads.common.utils.b.c, android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                sg.bigo.ads.common.utils.u.b(view);
            }
        });
        viewFindViewById.startAnimation(alphaAnimation);
        viewFindViewById.setVisibility(8);
    }

    protected final void w() {
        View viewFindViewById = this.D.findViewById(R.id.inter_slide_gesture_contain);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setTag(16);
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.ad.interstitial.a.4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    a.this.R = (int) motionEvent.getX();
                    a.this.S = (int) motionEvent.getY();
                } else if (action == 1 && a.a(a.this.R, a.this.S, (int) motionEvent.getX(), (int) motionEvent.getY()) > 10.0d) {
                    a.this.v();
                    ((s) a.this.y).w.a((int) motionEvent.getX(), (int) motionEvent.getY(), a.this.R, a.this.S, 8, ((Integer) view.getTag()).intValue());
                }
                return true;
            }
        });
    }

    protected void x() {
        if (this.A == null) {
            return;
        }
        sg.bigo.ads.common.e.a.a(this.A, this.O);
    }

    protected void y() {
        if (this.A == null) {
            return;
        }
        if (this.A.getVisibility() != 0) {
            this.A.setVisibility(0);
            c.b((View) this.A);
        }
        if (c() == 0) {
            int i = this.h.c;
            int iB = (i >= 0 || ((s) this.y).f().x() == 4) ? i : 0;
            if (((s) this.y).y()) {
                sg.bigo.ads.core.a.a aVarF = ((s) this.y).f();
                if (this.p.get() && aVarF.bg() == null) {
                    iB = w.b(this.h.n);
                }
            }
            this.A.a(iB, (AdCountDownButton.b) null);
        }
    }

    protected final void z() {
        if (this.A == null || this.A.getVisibility() != 0) {
            return;
        }
        this.A.clearAnimation();
        this.A.setVisibility(4);
    }
}
