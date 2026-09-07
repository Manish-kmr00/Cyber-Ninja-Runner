package sg.bigo.ads.ad.interstitial.d;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.common.view.RealtimeBlurLinearLayout;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.common.view.RoundedImageView;

/* JADX INFO: loaded from: classes9.dex */
public class b extends sg.bigo.ads.ad.interstitial.d.a implements sg.bigo.ads.ad.interstitial.f.b {
    protected ViewGroup A;
    protected Button B;
    protected RoundedFrameLayout C;
    protected MediaView D;
    protected TextView E;
    protected TextView F;
    protected Button G;
    protected Button H;
    protected RoundedImageView I;
    protected int J;
    protected int K;
    protected boolean L;
    private int M;
    protected RelativeLayout x;
    protected RealtimeBlurLinearLayout y;
    protected ViewGroup z;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.d.b$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12731a;

        static {
            int[] iArr = new int[sg.bigo.ads.ad.interstitial.b.values().length];
            f12731a = iArr;
            try {
                iArr[sg.bigo.ads.ad.interstitial.b.f12647a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12731a[sg.bigo.ads.ad.interstitial.b.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12731a[sg.bigo.ads.ad.interstitial.b.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12731a[sg.bigo.ads.ad.interstitial.b.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12731a[sg.bigo.ads.ad.interstitial.b.d.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    protected class a extends sg.bigo.ads.common.utils.b.a {
        private RectF b;
        private RectF c;
        private RectF d;
        private float e = Float.NaN;
        private RectF f;

        protected a() {
        }

        @Override // sg.bigo.ads.common.utils.b.a
        public final void a(TransitionValues transitionValues, TransitionValues transitionValues2) {
            if (transitionValues.view == b.this.y) {
                Rect rect = (Rect) transitionValues.values.get("android:changeBounds:bounds");
                Rect rect2 = (Rect) transitionValues2.values.get("android:changeBounds:bounds");
                Rect rect3 = new Rect(sg.bigo.ads.common.utils.u.a(b.this.B, b.this.J));
                this.b = new RectF(rect3);
                if (rect3.intersect(rect2)) {
                    this.c = new RectF(rect);
                    this.d = new RectF(rect2);
                    this.e = b.this.B.getTranslationY();
                    this.f = new RectF(rect2);
                }
            }
        }

        @Override // sg.bigo.ads.common.utils.b.a
        public final void a(Object obj, Object obj2) {
            if (obj != b.this.y || this.c == null || this.d == null || this.f == null || this.b == null || !(obj2 instanceof PointF) || Float.isNaN(this.e)) {
                return;
            }
            PointF pointF = (PointF) obj2;
            if (this.c.centerX() != this.d.centerX()) {
                b.this.B.setTranslationY(this.e - (Math.abs(this.f.top - this.b.bottom) * (Math.abs(pointF.x - this.c.left) / Math.abs(this.d.left - this.c.left))));
            } else {
                this.f.offsetTo(pointF.x, pointF.y);
                if (new RectF(this.b).intersect(this.f)) {
                    b.this.B.setTranslationY((this.e + this.f.top) - this.b.bottom);
                }
            }
        }
    }

    public b(sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
        this.K = -1;
        this.L = false;
    }

    private boolean L() {
        return ((sg.bigo.ads.core.a.a) this.c.f()).aQ();
    }

    private void a(int i, int i2, int i3) {
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = this.y;
        if (realtimeBlurLinearLayout != null) {
            float f = i3;
            this.y.setBackground(sg.bigo.ads.common.utils.d.a(f, f, f, f, i, i2, sg.bigo.ads.common.utils.e.a(realtimeBlurLinearLayout.getContext(), 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public sg.bigo.ads.common.p b(int i, int i2, int i3, int i4) {
        sg.bigo.ads.common.p pVar;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.C.getLayoutParams();
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.r.a(((sg.bigo.ads.ad.interstitial.t) this).c);
        if (pVarA.a(i, i2)) {
            this.C.setCornerRadius(0.0f);
            marginLayoutParams.setMargins(0, 0, 0, 0);
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            pVar = new sg.bigo.ads.common.p(i, i2);
        } else {
            RoundedFrameLayout roundedFrameLayout = this.C;
            roundedFrameLayout.setCornerRadius(sg.bigo.ads.common.utils.e.a(roundedFrameLayout.getContext(), 8));
            marginLayoutParams.setMargins(i3, i4, i3, i4);
            sg.bigo.ads.common.p pVarA2 = sg.bigo.ads.common.p.a(pVarA.b, pVarA.c, i - (i3 * 2), i2 - (i4 * 2));
            marginLayoutParams.width = pVarA2.b;
            marginLayoutParams.height = pVarA2.c;
            pVar = new sg.bigo.ads.common.p(pVarA2.b, pVarA2.c);
        }
        sg.bigo.ads.common.utils.u.c(this.D, -1, -1);
        this.C.setLayoutParams(marginLayoutParams);
        return pVar;
    }

    private void b(int i, int i2, int i3) {
        if (this.y != null) {
            float f = i3;
            this.y.setBlurStyle(new sg.bigo.ads.common.view.a.b(f, f, f, f, i, i2, sg.bigo.ads.common.utils.e.a(this.y.getContext(), 1)));
        }
    }

    protected void A() {
        if (v()) {
            Button button = this.G;
            if (button != null) {
                sg.bigo.ads.ad.interstitial.c.e(button);
            }
            Button button2 = this.H;
            if (button2 != null) {
                sg.bigo.ads.ad.interstitial.c.e(button2);
            }
        }
    }

    protected final void B() {
        Button button;
        if (this.q == null || (button = this.B) == null || button.getVisibility() != 0) {
            return;
        }
        float translationY = this.B.getTranslationY();
        RectF rectF = new RectF(sg.bigo.ads.common.utils.u.a(this.B, this.J));
        rectF.offset(0.0f, -translationY);
        float f = rectF.top;
        RectF rectF2 = new RectF(sg.bigo.ads.common.utils.u.a(this.v, 0));
        float f2 = rectF2.top;
        if (rectF2.intersect(rectF)) {
            rectF.offset(0.0f, f2 - rectF.bottom);
        }
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = this.y;
        if (realtimeBlurLinearLayout != null && realtimeBlurLinearLayout.getVisibility() == 0) {
            RectF rectF3 = new RectF(sg.bigo.ads.common.utils.u.a(this.y, 0));
            float f3 = rectF3.top;
            if (rectF3.intersect(rectF)) {
                rectF.offset(0.0f, f3 - rectF.bottom);
            }
        }
        if (rectF.top != f) {
            this.B.setTranslationY(rectF.top - f);
        } else {
            this.B.setTranslationY(0.0f);
        }
    }

    protected final void C() {
        sg.bigo.ads.common.utils.u.a(this.C, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.b.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                b.this.B();
            }
        });
    }

    protected void D() {
        if (this.y == null) {
            return;
        }
        final int iY = y();
        Runnable runnable = new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.b.4
            @Override // java.lang.Runnable
            public final void run() {
                b.this.y.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.b.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.a(iY > 0);
                    }
                });
            }
        };
        if (iY == 0) {
            runnable.run();
        } else {
            a(iY, runnable);
        }
    }

    protected void E() {
        if (this.y == null || this.q == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = -(this.q.getMeasuredHeight() - sg.bigo.ads.common.utils.u.a(this.q, this.y).y);
            this.y.requestLayout();
        }
    }

    protected void F() {
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = this.y;
        if (realtimeBlurLinearLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = realtimeBlurLinearLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.M;
            this.y.requestLayout();
        }
    }

    protected void G() {
        int i = this.s != null ? this.s.i : 0;
        View viewFindViewById = this.q.findViewById(R.id.inter_media_container);
        sg.bigo.ads.ad.b.a.a(viewFindViewById, 9);
        if (this.s == null || !this.s.g) {
            MediaView mediaView = this.D;
            if (mediaView != null) {
                mediaView.setOtherClickAreaClick(false);
            }
            if (viewFindViewById != null) {
                sg.bigo.ads.ad.b.a.a(this.q, viewFindViewById, 8, sg.bigo.ads.ad.interstitial.a.F, 0);
            }
        } else {
            MediaView mediaView2 = this.D;
            if (mediaView2 != null) {
                mediaView2.setOtherClickAreaClick(true);
            }
            if (viewFindViewById != null) {
                sg.bigo.ads.ad.b.a.a(this.q, viewFindViewById, 8, this.c, i);
            }
        }
        boolean z = this.s != null && this.s.f;
        if (this.D != null) {
            sg.bigo.ads.ad.b.a.a(this.q, this.D, 8, this.c, i);
            this.D.setMediaAreaClickable(z);
            this.D.b().a(!z);
        }
        boolean z2 = this.s != null && this.s.h;
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = this.y;
        if (realtimeBlurLinearLayout != null) {
            sg.bigo.ads.ad.b.a.a(realtimeBlurLinearLayout, 18);
            ViewGroup viewGroup = this.q;
            if (z2) {
                sg.bigo.ads.ad.b.a.a(viewGroup, this.y, 8, this.c, this.s.i);
            } else {
                sg.bigo.ads.ad.b.a.a(viewGroup, this.y, 8, sg.bigo.ads.ad.interstitial.a.F, 0);
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b
    public final int H() {
        if (this.K == -1) {
            this.K = this.t != null ? this.t.a("video_play_page.webview_layout") : 0;
        }
        int i = this.K;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return i;
            default:
                return 0;
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b
    public final int I() {
        return b(this.t, "video_play_page.webview_force_time");
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b
    public final boolean J() {
        int iH = H();
        return iH == 5 || iH == 6;
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b
    public final boolean K() {
        return this.L;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    protected final void a(double d) {
        if (d <= 3.0d) {
            if (this.v != null) {
                this.v.setTextColor(sg.bigo.ads.common.w.b.a(sg.bigo.ads.ad.interstitial.d.b, 0.6f));
            }
        } else if (this.v != null) {
            this.v.setTextColor(sg.bigo.ads.common.w.b.a(sg.bigo.ads.ad.interstitial.d.f12709a, 0.6f));
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.f.b
    public final void a(int i, int i2, int i3, int i4) {
        if (J()) {
            if (i >= i3) {
                this.L = true;
                return;
            }
            this.L = false;
            if (this.x != null) {
                int iMin = (i3 - Math.min(i, i2)) + i4;
                ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
                if (iMin != layoutParams.height) {
                    layoutParams.height = iMin;
                    this.x.requestLayout();
                    b(this.x.getMeasuredWidth(), layoutParams.height, sg.bigo.ads.common.utils.e.a(this.C.getContext(), 12), sg.bigo.ads.common.utils.e.a(this.C.getContext(), 12));
                    B();
                }
            }
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.t
    public final void a(ViewGroup viewGroup, View view, int i, int i2, int i3, View... viewArr) {
        super.a(viewGroup, view, i, i2, i3, viewArr);
        G();
        a((View) this.q);
    }

    protected final void a(boolean z) {
        if (this.y == null || this.w) {
            return;
        }
        final sg.bigo.ads.ad.interstitial.d.a.C0838a c0838aU = u();
        Button button = this.G;
        if (button != null) {
            sg.bigo.ads.ad.interstitial.d.b(button, c0838aU.f12723a);
        }
        if (z) {
            E();
            this.y.setVisibility(0);
            this.y.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    TransitionSet transitionSet = new TransitionSet();
                    transitionSet.addTransition(b.this.new a());
                    transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.d.b.5.1
                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionEnd(Transition transition) {
                            b.this.A();
                            if (c0838aU.b) {
                                b.this.a(b.this.G, new sg.bigo.ads.common.w.b.a());
                            }
                        }

                        @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
                        public final void onTransitionStart(Transition transition) {
                        }
                    });
                    transitionSet.setDuration(300L);
                    TransitionManager.beginDelayedTransition(b.this.r, transitionSet);
                    b.this.F();
                }
            });
        } else {
            this.y.setVisibility(0);
            B();
            A();
            if (c0838aU.b) {
                a(this.G, new sg.bigo.ads.common.w.b.a());
            }
        }
    }

    protected boolean a(sg.bigo.ads.ad.interstitial.b bVar) {
        if (y() < 0) {
            return false;
        }
        ViewStub viewStub = (ViewStub) this.q.findViewById(z());
        if (viewStub != null) {
            this.z = (ViewGroup) viewStub.inflate();
        }
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = (RealtimeBlurLinearLayout) this.q.findViewById(R.id.inter_component_layout);
        this.y = realtimeBlurLinearLayout;
        if (realtimeBlurLinearLayout == null) {
            return false;
        }
        this.I = (RoundedImageView) realtimeBlurLinearLayout.findViewById(R.id.inter_icon);
        this.E = (TextView) this.y.findViewById(R.id.inter_title);
        TextView textView = (TextView) this.y.findViewById(R.id.inter_description);
        this.F = textView;
        bVar.a(this.E, textView);
        bVar.a(this.I);
        sg.bigo.ads.common.utils.u.a(this.y, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.b.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                b.this.D();
            }
        });
        ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
        layoutParams.width = -1;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            this.M = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        this.y.setVisibility(4);
        this.y.requestLayout();
        return true;
    }

    protected void b(sg.bigo.ads.ad.interstitial.b bVar) {
        float fA = sg.bigo.ads.common.utils.e.a(this.y.getContext(), 8);
        Button button = (Button) this.y.findViewById(R.id.inter_btn_cta_main);
        this.H = button;
        if (button != null) {
            button.setBackground(sg.bigo.ads.common.utils.d.a(fA, fA, fA, fA, (Rect) null, -16724924));
            bVar.a(this.H);
        }
        Button button2 = (Button) this.y.findViewById(R.id.inter_btn_cta);
        this.G = button2;
        if (button2 != null) {
            button2.setBackground(sg.bigo.ads.common.utils.d.a(fA, fA, fA, fA, (Rect) null, 0));
            bVar.a(this.G);
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final ViewGroup k() {
        return this.C;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final MediaView l() {
        return this.D;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final Button m() {
        return this.B;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    public final boolean n() {
        return true;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    protected final void q() {
        String strI = ((sg.bigo.ads.core.a.a) this.c.f()).i();
        TextView textView = (TextView) this.q.findViewById(R.id.inter_advertiser);
        if (TextUtils.isEmpty(strI)) {
            textView.setVisibility(8);
        } else {
            textView.setText(strI);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0115  */
    @Override // sg.bigo.ads.ad.interstitial.d.a
    protected void t() {
        sg.bigo.ads.ad.interstitial.b bVar;
        Integer numA;
        Integer numA2;
        super.t();
        this.x = (RelativeLayout) this.q.findViewById(R.id.inter_media_component);
        this.A = (ViewGroup) this.q.findViewById(R.id.inter_warning_layout);
        this.B = (Button) this.q.findViewById(R.id.inter_btn_mute);
        this.C = (RoundedFrameLayout) this.q.findViewById(R.id.inter_media_layout);
        this.D = (MediaView) this.q.findViewById(R.id.inter_media);
        this.J = sg.bigo.ads.common.utils.e.a(this.B.getContext(), 12);
        this.D.setImageBlurBorder(false);
        sg.bigo.ads.common.utils.u.a(this.C, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.b.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                int iA = sg.bigo.ads.common.utils.e.a(b.this.C.getContext(), 12);
                b bVar2 = b.this;
                bVar2.b(bVar2.C.getMeasuredWidth(), b.this.C.getMeasuredHeight(), iA, iA);
                b.this.C();
            }
        });
        sg.bigo.ads.api.a.m mVar = this.t;
        int iA = mVar != null ? mVar.a("video_play_page.ad_component_colour", 2) : 2;
        if (iA == 1) {
            bVar = sg.bigo.ads.ad.interstitial.b.f12647a;
        } else if (iA != 3) {
            bVar = L() ? sg.bigo.ads.ad.interstitial.b.b : sg.bigo.ads.ad.interstitial.b.d;
        } else {
            bVar = L() ? sg.bigo.ads.ad.interstitial.b.c : sg.bigo.ads.ad.interstitial.b.e;
        }
        a(bVar);
        b(bVar);
        RealtimeBlurLinearLayout realtimeBlurLinearLayout = this.y;
        if (realtimeBlurLinearLayout != null) {
            int iA2 = sg.bigo.ads.common.utils.e.a(realtimeBlurLinearLayout.getContext(), 12);
            if (L()) {
                if (this.y != null) {
                    int i = AnonymousClass6.f12731a[bVar.ordinal()];
                    if (i != 1) {
                        a(sg.bigo.ads.common.w.b.a((i == 2 && (numA2 = sg.bigo.ads.ad.interstitial.r.a((NativeAd) this.c)) != null) ? numA2.intValue() : -12303292, 0.5f), sg.bigo.ads.common.w.b.a(-1, 0.1f), iA2);
                    } else {
                        a(-1, -1, iA2);
                    }
                }
            } else if (this.y != null) {
                int i2 = AnonymousClass6.f12731a[bVar.ordinal()];
                if (i2 == 1) {
                    a(-1, -1, iA2);
                } else if (i2 == 4 && (numA = sg.bigo.ads.ad.interstitial.r.a((NativeAd) this.c)) != null) {
                    b(sg.bigo.ads.common.w.b.a(numA.intValue(), 0.35f), sg.bigo.ads.common.w.b.a(numA.intValue(), 0.1f), iA2);
                } else {
                    b(sg.bigo.ads.common.w.b.a(-3355444, 0.35f), sg.bigo.ads.common.w.b.a(-1, 0.1f), iA2);
                }
            }
            bVar.b(this.y);
            bVar.a(this.E, this.F);
        }
    }

    protected int z() {
        return R.id.inter_component_19;
    }
}
