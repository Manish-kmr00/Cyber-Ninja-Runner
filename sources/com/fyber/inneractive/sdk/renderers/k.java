package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.M;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.flow.A;
import com.fyber.inneractive.sdk.flow.C3102g;
import com.fyber.inneractive.sdk.flow.O;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.mraid.F;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;
import com.fyber.inneractive.sdk.util.AbstractC3247k;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3261z;
import com.fyber.inneractive.sdk.util.B;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.i0;
import com.fyber.inneractive.sdk.web.C3274m;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.json.cc;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends A implements com.fyber.inneractive.sdk.interfaces.d, com.fyber.inneractive.sdk.util.A {
    public InneractiveAdViewUnitController l;
    public IAmraidWebViewController m;
    public g n;
    public ViewGroup p;
    public i q;
    public h s;
    public d y;
    public long k = 0;
    public boolean o = false;
    public long r = 0;
    public int t = 0;
    public long u = 0;
    public boolean v = false;
    public boolean w = true;
    public boolean x = false;

    public final void G() {
        if (this.s != null) {
            IAlog.a("%scancelling refreen runnable", IAlog.a(this));
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.s);
            this.s = null;
        }
    }

    public final void H() {
        d dVar = this.y;
        if (dVar != null) {
            dVar.g = false;
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar.j);
        }
        if (this.m != null) {
            G();
            x xVar = this.b;
            if (xVar != null) {
                ((O) xVar).a();
            }
            this.m = null;
            this.b = null;
            ViewGroup viewGroup = this.p;
            if (viewGroup != null) {
                viewGroup.removeView(this.q);
            }
            i iVar = this.q;
            if (iVar != null) {
                iVar.removeAllViews();
                this.q = null;
            }
        }
        this.v = false;
    }

    public final int I() {
        M m;
        int iIntValue;
        int i = this.t;
        if (i == -1) {
            IAlog.a("%sreturning disable value for banner refresh", IAlog.a(this));
            return 0;
        }
        if (i <= 0) {
            U u = this.f1772a.getAdContent().d;
            if (u != null && (m = ((T) u).c) != null) {
                Integer num = m.f1676a;
                IAlog.a("%sreturning refreshConfig = %d", IAlog.a(this), num);
                if (num != null) {
                    iIntValue = num.intValue();
                }
            }
            IAlog.a("%sgetRefreshInterval: returning 0. Refresh is disabled", IAlog.a(this));
            return 0;
        }
        IAlog.a("%sreturning overriden refresh interval = %d", IAlog.a(this), Integer.valueOf(this.t));
        iIntValue = this.t;
        return iIntValue * 1000;
    }

    public final void J() {
        InneractiveAdViewUnitController inneractiveAdViewUnitController;
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController == null || iAmraidWebViewController.b == null) {
            return;
        }
        IAlog.a("%srefreshing ad", IAlog.a(this));
        if ((!this.m.p() || this.m.N == F.RESIZED) && (inneractiveAdViewUnitController = this.l) != null) {
            this.r = 0L;
            inneractiveAdViewUnitController.refreshAd();
        }
    }

    public final void K() {
        C3274m c3274m;
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController == null || (c3274m = iAmraidWebViewController.b) == null || !c3274m.getIsVisible() || this.r == 0 || this.m.p() || this.m.N == F.RESIZED) {
            return;
        }
        if (!this.w) {
            if (this.k < System.currentTimeMillis() - this.r) {
                this.u = 1L;
            } else {
                this.u = this.k - (System.currentTimeMillis() - this.r);
            }
        }
        IAlog.a("%sresuming refresh runnable mRefreshTimeStamp %d", IAlog.a(this), Long.valueOf(this.u));
        a(false, this.u);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean a(x xVar) {
        return xVar instanceof O;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean b(View view) {
        return view.equals(this.p);
    }

    public final void c(boolean z) {
        if (this.s != null) {
            this.w = z;
            G();
            this.u = this.k - (System.currentTimeMillis() - this.r);
            IAlog.a("%sPause refresh time : time remaning:%d ,refreshInterval: %d", IAlog.a(this), Long.valueOf(this.u), Long.valueOf(this.k));
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.A, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final boolean canRefreshAd() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return (iAmraidWebViewController.p() || this.m.N == F.RESIZED) ? false : true;
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int d() {
        return this.m.d0;
    }

    @Override // com.fyber.inneractive.sdk.flow.A, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        G();
        H();
        this.n = null;
        AbstractC3261z.f2383a.f2343a.remove(this);
        h hVar = this.s;
        if (hVar != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(hVar);
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final void e(View view) {
        com.fyber.inneractive.sdk.measurement.tracker.f fVar;
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController == null || (fVar = iAmraidWebViewController.I) == null) {
            return;
        }
        try {
            AdSession adSession = fVar.f1866a;
            if (adSession == null || view == null) {
                return;
            }
            adSession.removeFriendlyObstruction(view);
        } catch (Throwable th) {
            fVar.a(th);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void l() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int n() {
        return this.m.e0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void q() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void s() {
        d dVar = this.y;
        if (dVar != null) {
            dVar.g = false;
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar.j);
        }
        i iVar = this.q;
        if (iVar != null) {
            iVar.removeAllViews();
            this.q = null;
        }
        ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.p = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final View x() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return iAmraidWebViewController.b;
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final int y() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return (iAmraidWebViewController.b == null || !iAmraidWebViewController.p()) ? AbstractC3251o.b(this.m.e0) : AbstractC3251o.b(this.m.b.getHeight());
        }
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final int z() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return (iAmraidWebViewController.b == null || !iAmraidWebViewController.p()) ? AbstractC3251o.b(this.m.d0) : AbstractC3251o.b(this.m.b.getWidth());
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:45:0x015e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0160  */
    /* JADX WARN: Code duplicated, block: B:47:0x0165  */
    /* JADX WARN: Code duplicated, block: B:50:0x016a  */
    /* JADX WARN: Code duplicated, block: B:53:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:60:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:62:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:66:0x0204  */
    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void a(ViewGroup viewGroup) {
        i0 i0VarA;
        C3274m c3274m;
        ViewParent parent;
        InneractiveAdSpot inneractiveAdSpot;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        IAmraidWebViewController iAmraidWebViewController;
        ViewGroup viewGroup4;
        i iVar;
        InneractiveAdSpot inneractiveAdSpot2 = this.f1772a;
        if (inneractiveAdSpot2 == null) {
            IAlog.f("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            return;
        }
        this.o = false;
        this.e = false;
        if (viewGroup != null) {
            this.p = viewGroup;
            this.l = (InneractiveAdViewUnitController) inneractiveAdSpot2.getSelectedUnitController();
        } else if (!this.x) {
            H();
            if (!(this.f1772a.getAdContent() instanceof O)) {
                IAlog.f("InneractiveAdViewMraidAdRenderer.renderAd: Spot ad content is not the right content :( %s", this.f1772a.getAdContent());
                return;
            }
            this.b = (O) this.f1772a.getAdContent();
        }
        x xVar = this.b;
        IAmraidWebViewController iAmraidWebViewController2 = xVar != null ? ((O) xVar).i : null;
        this.m = iAmraidWebViewController2;
        if (iAmraidWebViewController2 != null) {
            if (this.n == null) {
                this.n = new g(this);
            }
            iAmraidWebViewController2.setListener(this.n);
            O o = (O) this.b;
            InneractiveAdRequest inneractiveAdRequest = o.f1840a;
            U u = o.d;
            if (u != null) {
                T t = (T) u;
                if (t.c == null || t.c.b == null || !t.c.b.isFullscreenUnit()) {
                    this.q = new i(this.p.getContext(), 0.0f);
                    O o2 = (O) this.b;
                    com.fyber.inneractive.sdk.response.f fVar = (com.fyber.inneractive.sdk.response.f) o2.b;
                    i0VarA = a(fVar.e, fVar.f, o2.d);
                    this.m.setAdDefaultSize(i0VarA.f2365a, i0VarA.b);
                    IAmraidWebViewController iAmraidWebViewController3 = this.m;
                    c3274m = iAmraidWebViewController3.b;
                    if (c3274m == null || AbstractC3251o.f2370a == null) {
                        if (c3274m != null) {
                            parent = c3274m.getParent();
                        } else {
                            parent = null;
                        }
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(c3274m);
                        }
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i0VarA.f2365a, i0VarA.b);
                        layoutParams.addRule(new int[]{13}[0]);
                        this.m.a(this.q, layoutParams);
                        this.p.addView(this.q);
                        i iVar2 = this.q;
                        ViewGroup.LayoutParams layoutParams2 = iVar2.getLayoutParams();
                        layoutParams2.width = -2;
                        layoutParams2.height = -2;
                        iVar2.setLayoutParams(layoutParams2);
                        inneractiveAdSpot = this.f1772a;
                        if (inneractiveAdSpot != null && inneractiveAdSpot.getAdContent() != null && (viewGroup2 = this.p) != null) {
                            Context context = viewGroup2.getContext();
                            C3102g c3102g = new C3102g(context, false, this.f1772a.getAdContent().f1840a, this.f1772a.getAdContent().c(), this.f1772a.getAdContent().c);
                            viewGroup3 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ia_layout_fyber_ad_identifier_relative, this.p, false);
                            IFyberAdIdentifier.Corner corner = IFyberAdIdentifier.Corner.BOTTOM_LEFT;
                            IFyberAdIdentifier iFyberAdIdentifier = c3102g.d;
                            iFyberAdIdentifier.k = corner;
                            iFyberAdIdentifier.a(viewGroup3);
                            viewGroup3.setVisibility(0);
                            iAmraidWebViewController = this.m;
                            if (iAmraidWebViewController == null) {
                                viewGroup4 = null;
                            } else {
                                viewGroup4 = iAmraidWebViewController.b;
                                if (viewGroup4 != null && viewGroup4.getParent() != null) {
                                    viewGroup4 = (ViewGroup) viewGroup4.getParent();
                                }
                            }
                            if (viewGroup4 != null && x() != null) {
                                ViewGroup.LayoutParams layoutParams3 = x().getLayoutParams();
                                IAmraidWebViewController iAmraidWebViewController4 = this.m;
                                viewGroup4.addView(viewGroup3, layoutParams3);
                                iAmraidWebViewController4.a(viewGroup3, com.fyber.inneractive.sdk.measurement.tracker.e.IdentifierView);
                            }
                        }
                    } else if (this.x) {
                        FrameLayout frameLayout = new FrameLayout(this.p.getContext());
                        frameLayout.setBackgroundResource(R.color.ia_blank_background);
                        this.p.removeAllViews();
                        this.p.addView(frameLayout, new FrameLayout.LayoutParams(i0VarA.f2365a, i0VarA.b, 17));
                    } else {
                        this.x = true;
                        iAmraidWebViewController3.b = iAmraidWebViewController3.a(((O) this.b).c);
                        try {
                            iAmraidWebViewController3.h();
                            DTExchangeNetworkBridge.webviewLoadDataWithBaseURL(iAmraidWebViewController3.b, iAmraidWebViewController3.p, iAmraidWebViewController3.q, POBCommonConstants.CONTENT_TYPE_HTML, cc.N, null);
                        } catch (Throwable unused) {
                            FrameLayout frameLayout2 = new FrameLayout(this.p.getContext());
                            frameLayout2.setBackgroundResource(R.color.ia_blank_background);
                            this.p.removeAllViews();
                            this.p.addView(frameLayout2, new FrameLayout.LayoutParams(i0VarA.f2365a, i0VarA.b, 17));
                        }
                    }
                } else {
                    i iVar3 = new i(this.p.getContext(), 1.5f);
                    this.q = iVar3;
                    this.m.a(iVar3, new ViewGroup.LayoutParams(-1, -1));
                    this.p.addView(this.q, new ViewGroup.LayoutParams(-2, -2));
                }
            } else {
                this.q = new i(this.p.getContext(), 0.0f);
                O o3 = (O) this.b;
                com.fyber.inneractive.sdk.response.f fVar2 = (com.fyber.inneractive.sdk.response.f) o3.b;
                i0VarA = a(fVar2.e, fVar2.f, o3.d);
                this.m.setAdDefaultSize(i0VarA.f2365a, i0VarA.b);
                IAmraidWebViewController iAmraidWebViewController5 = this.m;
                c3274m = iAmraidWebViewController5.b;
                if (c3274m == null) {
                    if (c3274m != null) {
                        parent = c3274m.getParent();
                    } else {
                        parent = null;
                    }
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(c3274m);
                    }
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i0VarA.f2365a, i0VarA.b);
                    layoutParams4.addRule(new int[]{13}[0]);
                    this.m.a(this.q, layoutParams4);
                    this.p.addView(this.q);
                    i iVar4 = this.q;
                    ViewGroup.LayoutParams layoutParams5 = iVar4.getLayoutParams();
                    layoutParams5.width = -2;
                    layoutParams5.height = -2;
                    iVar4.setLayoutParams(layoutParams5);
                    inneractiveAdSpot = this.f1772a;
                    if (inneractiveAdSpot != null) {
                        Context context2 = viewGroup2.getContext();
                        C3102g c3102g2 = new C3102g(context2, false, this.f1772a.getAdContent().f1840a, this.f1772a.getAdContent().c(), this.f1772a.getAdContent().c);
                        viewGroup3 = (ViewGroup) LayoutInflater.from(context2).inflate(R.layout.ia_layout_fyber_ad_identifier_relative, this.p, false);
                        IFyberAdIdentifier.Corner corner2 = IFyberAdIdentifier.Corner.BOTTOM_LEFT;
                        IFyberAdIdentifier iFyberAdIdentifier2 = c3102g2.d;
                        iFyberAdIdentifier2.k = corner2;
                        iFyberAdIdentifier2.a(viewGroup3);
                        viewGroup3.setVisibility(0);
                        iAmraidWebViewController = this.m;
                        if (iAmraidWebViewController == null) {
                            viewGroup4 = null;
                        } else {
                            viewGroup4 = iAmraidWebViewController.b;
                            if (viewGroup4 != null) {
                                viewGroup4 = (ViewGroup) viewGroup4.getParent();
                            }
                        }
                        if (viewGroup4 != null) {
                            ViewGroup.LayoutParams layoutParams6 = x().getLayoutParams();
                            IAmraidWebViewController iAmraidWebViewController6 = this.m;
                            viewGroup4.addView(viewGroup3, layoutParams6);
                            iAmraidWebViewController6.a(viewGroup3, com.fyber.inneractive.sdk.measurement.tracker.e.IdentifierView);
                        }
                    }
                } else {
                    if (c3274m != null) {
                        parent = c3274m.getParent();
                    } else {
                        parent = null;
                    }
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(c3274m);
                    }
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(i0VarA.f2365a, i0VarA.b);
                    layoutParams7.addRule(new int[]{13}[0]);
                    this.m.a(this.q, layoutParams7);
                    this.p.addView(this.q);
                    i iVar5 = this.q;
                    ViewGroup.LayoutParams layoutParams8 = iVar5.getLayoutParams();
                    layoutParams8.width = -2;
                    layoutParams8.height = -2;
                    iVar5.setLayoutParams(layoutParams8);
                    inneractiveAdSpot = this.f1772a;
                    if (inneractiveAdSpot != null) {
                        Context context3 = viewGroup2.getContext();
                        C3102g c3102g3 = new C3102g(context3, false, this.f1772a.getAdContent().f1840a, this.f1772a.getAdContent().c(), this.f1772a.getAdContent().c);
                        viewGroup3 = (ViewGroup) LayoutInflater.from(context3).inflate(R.layout.ia_layout_fyber_ad_identifier_relative, this.p, false);
                        IFyberAdIdentifier.Corner corner3 = IFyberAdIdentifier.Corner.BOTTOM_LEFT;
                        IFyberAdIdentifier iFyberAdIdentifier3 = c3102g3.d;
                        iFyberAdIdentifier3.k = corner3;
                        iFyberAdIdentifier3.a(viewGroup3);
                        viewGroup3.setVisibility(0);
                        iAmraidWebViewController = this.m;
                        if (iAmraidWebViewController == null) {
                            viewGroup4 = null;
                        } else {
                            viewGroup4 = iAmraidWebViewController.b;
                            if (viewGroup4 != null) {
                                viewGroup4 = (ViewGroup) viewGroup4.getParent();
                            }
                        }
                        if (viewGroup4 != null) {
                            ViewGroup.LayoutParams layoutParams9 = x().getLayoutParams();
                            IAmraidWebViewController iAmraidWebViewController7 = this.m;
                            viewGroup4.addView(viewGroup3, layoutParams9);
                            iAmraidWebViewController7.a(viewGroup3, com.fyber.inneractive.sdk.measurement.tracker.e.IdentifierView);
                        }
                    }
                }
            }
            x xVar2 = this.b;
            com.fyber.inneractive.sdk.response.f fVar3 = xVar2 != null ? (com.fyber.inneractive.sdk.response.f) ((O) xVar2).b : null;
            if (fVar3 != null && (iVar = this.q) != null) {
                d dVar = new d(fVar3, iVar, new f(this));
                this.y = dVar;
                dVar.h = false;
                dVar.d = 1;
                dVar.e = 0.0f;
                int i = fVar3.v;
                if (i >= 1) {
                    dVar.d = Math.min(i, 100);
                }
                float f = fVar3.w;
                if (f >= -1.0f) {
                    dVar.e = f;
                }
                if (dVar.e >= 0.0f) {
                    IAlog.a("IAVisibilityTracker: startTrackingVisibility", new Object[0]);
                    dVar.c = 0.0f;
                    dVar.f = System.currentTimeMillis();
                    dVar.g = true;
                    dVar.a();
                }
            }
        } else {
            IAlog.f("InneractiveAdViewMraidAdRenderer.renderAd: Spot ad content is not the right content :( %s", xVar);
        }
        B b = AbstractC3261z.f2383a;
        if (b.f2343a.contains(this)) {
            return;
        }
        b.f2343a.add(this);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void p() {
        C3274m c3274m;
        IAlog.a("%sgot onAdRefreshFailed", IAlog.a(this));
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController == null || (c3274m = iAmraidWebViewController.b) == null) {
            return;
        }
        if (!c3274m.getIsVisible() || AbstractC3261z.f2383a.b || this.m.p() || this.m.N == F.RESIZED) {
            IAlog.a("%sview is not visible or screen is locked or webView is Expanded or web is Resised. Waiting for visibility change", IAlog.a(this));
            this.u = 1L;
            return;
        }
        IAlog.a("%sview is visible and screen is unlocked: refreshing ad and webView is not expanded", IAlog.a(this));
        long jI = I();
        this.k = jI;
        if (jI != 0) {
            a(false, 10000L);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final void d(View view) {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.a(view, com.fyber.inneractive.sdk.measurement.tracker.e.ProgressOverlay);
        }
    }

    public final void a(boolean z, long j) {
        IAmraidWebViewController iAmraidWebViewController;
        C3274m c3274m;
        if (!TextUtils.isEmpty(this.f1772a.getMediationNameString()) || j == 0 || (this.f1772a.getSelectedUnitController() instanceof InneractiveFullscreenUnitController) || this.t == -1 || (iAmraidWebViewController = this.m) == null || (c3274m = iAmraidWebViewController.b) == null) {
            return;
        }
        if (!c3274m.getIsVisible()) {
            IAlog.a("%sstartRefreshTimer called but ad is not visible", IAlog.a(this));
            return;
        }
        this.r = System.currentTimeMillis();
        this.k = z ? this.k : j;
        IAlog.a("%sstartRefreshTimer in %d msec, mRefreshInterval = %d", IAlog.a(this), Long.valueOf(j), Long.valueOf(this.k));
        if (j > 1) {
            h hVar = this.s;
            if (hVar != null) {
                com.fyber.inneractive.sdk.util.r.b.removeCallbacks(hVar);
            }
            G();
            h hVar2 = new h(this);
            this.s = hVar2;
            com.fyber.inneractive.sdk.util.r.b.postDelayed(hVar2, j);
            return;
        }
        J();
    }

    public static i0 a(int i, int i2, U u) {
        int iA;
        int iA2;
        M m;
        IAlog.a("View layout params: response width and height: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i > 0 && i2 > 0) {
            iA = AbstractC3251o.a(i);
            iA2 = AbstractC3251o.a(i2);
        } else {
            UnitDisplayType unitDisplayType = UnitDisplayType.BANNER;
            if (u != null && (m = ((T) u).c) != null) {
                unitDisplayType = m.b;
            }
            if (unitDisplayType.equals(UnitDisplayType.MRECT)) {
                iA = AbstractC3251o.a(j.RECTANGLE_WIDTH.value);
                iA2 = AbstractC3251o.a(j.RECTANGLE_HEIGHT.value);
            } else if (AbstractC3247k.n()) {
                iA = AbstractC3251o.a(j.BANNER_TABLET_WIDTH.value);
                iA2 = AbstractC3251o.a(j.BANNER_TABLET_HEIGHT.value);
            } else {
                iA = AbstractC3251o.a(j.BANNER_WIDTH.value);
                iA2 = AbstractC3251o.a(j.BANNER_HEIGHT.value);
            }
        }
        IAlog.e("View layout params: final scaled width and height: %d, %d", Integer.valueOf(iA), Integer.valueOf(iA2));
        return new i0(iA, iA2);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void a(int i) {
        this.t = i;
    }
}
