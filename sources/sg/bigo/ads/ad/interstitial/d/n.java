package sg.bigo.ads.ad.interstitial.d;

import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.Collection;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.multi_img.view.IconListView;
import sg.bigo.ads.common.view.RoundedFrameLayout;

/* JADX INFO: loaded from: classes5.dex */
public class n extends m {
    private LinearLayout G;
    private RoundedFrameLayout H;
    private TextView I;
    private IconListView J;
    private RoundedFrameLayout K;
    private Button L;
    private sg.bigo.ads.common.utils.n M;
    private ImageView N;
    private boolean O;
    private boolean P;
    private int Q;

    public n(sg.bigo.ads.ad.b.c cVar) {
        super(cVar);
        this.O = false;
        this.P = false;
    }

    private void a(sg.bigo.ads.common.w.b.a aVar, boolean z) {
        a.C0838a c0838aU = u();
        Button button = this.L;
        if (button != null) {
            sg.bigo.ads.ad.interstitial.d.a(button, c0838aU.f12723a, aVar);
        }
        TextView textView = this.I;
        if (textView != null) {
            textView.setTextColor(c0838aU.f12723a);
        }
        if (z && c0838aU.b) {
            a(this.L, new sg.bigo.ads.common.w.b.a() { // from class: sg.bigo.ads.ad.interstitial.d.n.8
                @Override // sg.bigo.ads.common.w.b.a
                public final void b(int i) {
                    super.b(i);
                    if (n.this.I != null) {
                        n.this.I.setTextColor(i);
                    }
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004d  */
    static /* synthetic */ void b(n nVar, int i) {
        long jA;
        sg.bigo.ads.common.utils.r rVar;
        final boolean zV = nVar.v();
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addListener((Transition.TransitionListener) new sg.bigo.ads.common.h() { // from class: sg.bigo.ads.ad.interstitial.d.n.7
            @Override // sg.bigo.ads.common.h, android.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                if (zV) {
                    sg.bigo.ads.ad.interstitial.c.e(n.this.K);
                }
                n.this.I();
            }
        });
        TransitionManager.beginDelayedTransition(nVar.r, transitionSet);
        nVar.a(new sg.bigo.ads.common.w.b.a(), true);
        nVar.c(i);
        if (nVar.u != null) {
            int i2 = nVar.u.b;
            int i3 = 3;
            if (i2 == 1) {
                rVar = sg.bigo.ads.common.utils.r.f13300a;
            } else if (i2 == 2) {
                rVar = sg.bigo.ads.common.utils.r.f13300a;
                i3 = 5;
            } else if (i2 != 3) {
                jA = 0;
            } else {
                rVar = sg.bigo.ads.common.utils.r.f13300a;
                i3 = 10;
            }
            jA = rVar.a(i3);
        } else {
            jA = 0;
        }
        long jMax = Math.max(0L, jA);
        if (jMax == 0) {
            nVar.N.setVisibility(0);
        } else {
            nVar.N.postDelayed(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.n.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (sg.bigo.ads.ad.c.a((sg.bigo.ads.ad.c) n.this.c)) {
                        return;
                    }
                    TransitionSet transitionSet2 = new TransitionSet();
                    transitionSet2.addTransition(new Fade());
                    TransitionManager.beginDelayedTransition(n.this.H, transitionSet2);
                    n.this.N.setVisibility(0);
                }
            }, jMax);
        }
        nVar.N.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.interstitial.d.n.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.g(n.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (this.E == null) {
            return;
        }
        int iN = N();
        int iM = M();
        Context context = this.z.getContext();
        this.E.k.setCornerRadius(L());
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E.k.getLayoutParams();
        marginLayoutParams.leftMargin = iM;
        marginLayoutParams.topMargin = this.P ? this.Q + iN : iN;
        marginLayoutParams.rightMargin = iM;
        if (this.P) {
            iN += this.Q;
        }
        marginLayoutParams.bottomMargin = iN;
        this.E.k.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.z.getLayoutParams();
        marginLayoutParams2.topMargin = -this.Q;
        marginLayoutParams2.height = i + (this.Q * 2);
        this.z.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.E.f12860a.getLayoutParams();
        marginLayoutParams3.bottomMargin = this.Q + sg.bigo.ads.common.utils.e.a(context, 12);
        this.E.f12860a.setLayoutParams(marginLayoutParams3);
        RoundedFrameLayout roundedFrameLayout = this.H;
        int i2 = this.Q;
        roundedFrameLayout.a(i2, i2, 0.0f, 0.0f);
        this.H.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.H.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = 0;
        layoutParams.weight = 1.0f;
        layoutParams.topMargin = -this.Q;
        this.H.setLayoutParams(layoutParams);
    }

    static /* synthetic */ void c(n nVar) {
        nVar.O = true;
        nVar.P = true;
        nVar.q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.n.3
            @Override // java.lang.Runnable
            public final void run() {
                n nVar2 = n.this;
                nVar2.G.getMeasuredWidth();
                nVar2.c(n.this.G.getMeasuredHeight());
                n.this.N.setVisibility(4);
            }
        });
        final float fA = sg.bigo.ads.common.utils.e.a(nVar.q.getContext(), 252);
        final float measuredWidth = nVar.z.getMeasuredWidth();
        sg.bigo.ads.common.p pVarA = sg.bigo.ads.ad.interstitial.r.a(((sg.bigo.ads.ad.interstitial.t) nVar).c);
        if (pVarA.a() && measuredWidth / fA < (pVarA.b * 1.0f) / pVarA.c) {
            fA = ((pVarA.c * measuredWidth) * 1.0f) / pVarA.b;
        }
        nVar.q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.n.4
            @Override // java.lang.Runnable
            public final void run() {
                n.b(n.this, (int) fA);
            }
        });
    }

    static /* synthetic */ void g(n nVar) {
        nVar.P = false;
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        TransitionManager.beginDelayedTransition(nVar.r, transitionSet);
        nVar.G.getMeasuredWidth();
        nVar.c(nVar.G.getMeasuredHeight());
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    public final boolean C() {
        return false;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final int D() {
        return Integer.MIN_VALUE;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final sg.bigo.ads.ad.interstitial.multi_img.c F() {
        return sg.bigo.ads.ad.interstitial.multi_img.c.FILL_MATCH_SELF;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final void I() {
        if (this.P) {
            super.I();
        }
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final void J() {
        super.J();
        if (this.s.h) {
            sg.bigo.ads.ad.b.a.a(this.H, 18);
            sg.bigo.ads.ad.b.a.a(this.q, this.H, 8, this.c, this.s.i);
        } else {
            sg.bigo.ads.ad.b.a.a(this.q, this.H, 8, sg.bigo.ads.ad.interstitial.a.F, 0);
        }
        IconListView iconListView = this.J;
        if (iconListView != null) {
            List<IconListView.a> items = iconListView.getItems();
            for (int i = 0; items != null && i < items.size(); i++) {
                IconListView.a aVar = items.get(i);
                sg.bigo.ads.ad.b.a.a(aVar.d, 26);
                sg.bigo.ads.ad.b.a.a(this.q, aVar.d, 8, this.c, this.s.i);
                sg.bigo.ads.ad.b.a.a(aVar.g, 26);
                sg.bigo.ads.ad.b.a.a(this.q, aVar.g, 8, this.c, this.s.i);
            }
        }
        if (this.s == null || !this.s.g) {
            sg.bigo.ads.ad.b.a.a(this.q, this.E.j, 8, sg.bigo.ads.ad.interstitial.a.F, 0);
        } else {
            sg.bigo.ads.ad.b.a.a(this.E.j, 9);
            sg.bigo.ads.ad.b.a.a(this.q, this.E.j, 8, this.c, this.s.i);
        }
    }

    protected int L() {
        return 0;
    }

    protected int M() {
        return 0;
    }

    protected int N() {
        return 0;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m, sg.bigo.ads.ad.interstitial.d.a
    protected final void a(double d) {
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final void a(int i, boolean z, int i2, boolean z2) {
        super.a(i, z, i, false);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final void a(sg.bigo.ads.ad.interstitial.q qVar) {
        super.a(qVar);
        this.G = (LinearLayout) this.q.findViewById(R.id.inter_media_container);
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) this.q.findViewById(R.id.inter_media_gp_container);
        this.H = roundedFrameLayout;
        this.I = (TextView) roundedFrameLayout.findViewById(R.id.inter_company);
        this.J = (IconListView) this.H.findViewById(R.id.inter_download_msg);
        RoundedFrameLayout roundedFrameLayout2 = (RoundedFrameLayout) this.H.findViewById(R.id.inter_btn_cta_layout);
        this.K = roundedFrameLayout2;
        this.L = (Button) roundedFrameLayout2.findViewById(R.id.inter_btn_cta);
        this.N = (ImageView) this.H.findViewById(R.id.inter_gp_btn_close);
        this.Q = sg.bigo.ads.common.utils.e.a(this.q.getContext(), 12);
    }

    @Override // sg.bigo.ads.ad.interstitial.e
    public final void b() {
        super.b();
        sg.bigo.ads.common.utils.n nVar = this.M;
        if (nVar == null || !nVar.e()) {
            return;
        }
        this.M.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final void b(int i) {
        super.b(i);
        sg.bigo.ads.common.utils.n nVar = new sg.bigo.ads.common.utils.n(((long) Math.max(1, i)) * 1000) { // from class: sg.bigo.ads.ad.interstitial.d.n.2
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                n.this.q.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.d.n.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.c(n.this);
                    }
                });
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
            }
        };
        this.M = nVar;
        nVar.c();
    }

    @Override // sg.bigo.ads.ad.interstitial.e
    public final void c() {
        super.c();
        sg.bigo.ads.common.utils.n nVar = this.M;
        if (nVar == null || nVar.e()) {
            return;
        }
        this.M.d();
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m, sg.bigo.ads.ad.interstitial.d.a
    protected final void t() {
        sg.bigo.ads.ad.interstitial.multi_img.view.b bVar;
        super.t();
        this.v.setTextColor(sg.bigo.ads.ad.interstitial.d.b);
        this.x.removeView(this.z);
        this.z.setCornerRadius(0.0f);
        int i = -1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.G.addView(this.z, 0, layoutParams);
        sg.bigo.ads.common.utils.u.a(this.G, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sg.bigo.ads.ad.interstitial.d.n.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (n.this.O) {
                    return;
                }
                n nVar = n.this;
                nVar.G.getMeasuredWidth();
                nVar.c(n.this.G.getMeasuredHeight());
            }
        });
        this.J.a(this.u);
        if (sg.bigo.ads.common.utils.k.a((Collection) this.J.getItems())) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
        }
        if (this.B != null) {
            this.B.a(false);
        }
        if (this.C != null) {
            this.C.a(false);
        }
        if (this.D != null) {
            this.D.f = false;
        }
        int iW = w();
        if (iW != 1) {
            if (iW == 2) {
                bVar = this.E;
                i = ViewCompat.MEASURED_STATE_MASK;
            }
            K();
            a((sg.bigo.ads.common.w.b.a) null, false);
        }
        bVar = this.E;
        bVar.b(sg.bigo.ads.common.w.b.b(i));
        K();
        a((sg.bigo.ads.common.w.b.a) null, false);
    }

    @Override // sg.bigo.ads.ad.interstitial.d.a
    protected final int x() {
        return 2;
    }

    @Override // sg.bigo.ads.ad.interstitial.d.m
    protected final boolean z() {
        return true;
    }
}
