package com.fyber.inneractive.sdk.renderers;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.C3082l;
import com.fyber.inneractive.sdk.config.C3085o;
import com.fyber.inneractive.sdk.config.C3088s;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.M;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.A;
import com.fyber.inneractive.sdk.flow.C3102g;
import com.fyber.inneractive.sdk.flow.G;
import com.fyber.inneractive.sdk.flow.N;
import com.fyber.inneractive.sdk.flow.O;
import com.fyber.inneractive.sdk.flow.Q;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.network.Z;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.C3237a;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.v0;
import com.fyber.inneractive.sdk.util.x0;
import com.fyber.inneractive.sdk.web.C3274m;
import com.iab.omid.library.fyber.adsession.AdSession;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes11.dex */
public final class s extends N {
    public x0 E;
    public com.fyber.inneractive.sdk.external.g I;
    public b0 J;
    public r w;
    public IAmraidWebViewController y;
    public boolean x = false;
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public UnitDisplayType F = UnitDisplayType.INTERSTITIAL;
    public boolean G = false;
    public boolean H = false;

    @Override // com.fyber.inneractive.sdk.flow.N
    public final boolean G() {
        return !this.B && this.y.X;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final int I() {
        Integer numA;
        x xVar = this.b;
        if (xVar == null) {
            return -1;
        }
        O o = (O) xVar;
        if (o.c == null || o.c.a(com.fyber.inneractive.sdk.config.global.features.e.class) == null || (numA = ((com.fyber.inneractive.sdk.config.global.features.e) ((O) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.e.class)).a("close_clickable_area_dp")) == null) {
            return -1;
        }
        return numA.intValue();
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final int J() {
        Integer numA;
        x xVar = this.b;
        if (xVar == null) {
            return -1;
        }
        O o = (O) xVar;
        if (o.c == null || o.c.a(com.fyber.inneractive.sdk.config.global.features.e.class) == null || (numA = ((com.fyber.inneractive.sdk.config.global.features.e) ((O) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.e.class)).a("close_visible_size_dp")) == null) {
            return -1;
        }
        return numA.intValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x002f  */
    @Override // com.fyber.inneractive.sdk.flow.N
    public final long K() {
        int iMin;
        int iMin2 = 5;
        if (this.F == UnitDisplayType.REWARDED) {
            iMin = IAConfigManager.O.u.b.a("rewarded_mraid_delay", 31, 30);
            IAlog.a("%sGetting rewarded total delay of %d seconds", IAlog.a(this), Integer.valueOf(iMin));
        } else {
            C3088s c3088s = IAConfigManager.O.u;
            if (c3088s != null) {
                C3085o c3085o = c3088s.b;
                C3082l c3082lA = c3085o.a("int_configuration");
                if (c3082lA == null || !c3082lA.f1711a.containsKey("close_d")) {
                    try {
                        iMin = Integer.parseInt(c3085o.a("mraid_x_delay_v2", Integer.toString(5)));
                    } catch (Throwable unused) {
                        iMin = 5;
                    }
                    if (iMin < 0 || iMin > 30) {
                        iMin = 5;
                    }
                } else {
                    try {
                        iMin = c3082lA.f1711a.containsKey("close_d") ? Integer.parseInt((String) c3082lA.f1711a.get("close_d")) : 5;
                    } catch (Throwable unused2) {
                    }
                    if (iMin < 0 || iMin > 30) {
                        iMin = 5;
                    }
                    this.t = true;
                }
            } else {
                iMin = 5;
            }
        }
        if (InneractiveAdManager.isCurrentUserAChild()) {
            if (A()) {
                Integer numA = ((com.fyber.inneractive.sdk.config.global.features.c) ((O) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.c.class)).a("skip_time_sec");
                int iIntValue = numA != null ? numA.intValue() : 5;
                if (iIntValue >= 0 && iIntValue <= 8) {
                    iMin2 = iIntValue;
                }
            } else {
                iMin2 = Math.min(iMin, 5);
            }
            iMin = Math.min(iMin2, iMin);
        }
        return iMin * 1000;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final boolean L() {
        return false;
    }

    public final void N() {
        IAmraidWebViewController iAmraidWebViewController;
        if (this.b == null || (iAmraidWebViewController = this.y) == null) {
            IAlog.a("updateWebViewLayoutParams called, but web view is invalid", new Object[0]);
            return;
        }
        C3274m c3274m = iAmraidWebViewController.b;
        if (c3274m != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            c3274m.setLayoutParams(layoutParams);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        U u;
        super.a(eVar, activity);
        x xVar = this.b;
        M m = (xVar == null || (u = ((O) xVar).d) == null) ? null : ((T) u).c;
        if (m == null) {
            IAlog.f("%sNo display config for full screen mraid ad renderer! Cannot render", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("No display config for full screen mraid");
        }
        IAmraidWebViewController iAmraidWebViewController = xVar != null ? ((O) xVar).i : null;
        this.y = iAmraidWebViewController;
        if (iAmraidWebViewController == null || iAmraidWebViewController.b == null) {
            IAlog.f("%sWeb view controller content is not valid. Web view might have crashed", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("Web view could not be loaded");
        }
        ((O) xVar).g();
        this.F = m.b;
        this.z = false;
        this.A = false;
        this.J = new b0(this.f1772a);
        this.k = eVar;
        IAmraidWebViewController iAmraidWebViewController2 = this.y;
        if (iAmraidWebViewController2 == null) {
            IAlog.f("InneractiveFullscreenMraidAdRenderer.renderAd: Spot ad content is not the right content :( %s", this.b);
            return;
        }
        iAmraidWebViewController2.a(eVar.getCloseButton(), com.fyber.inneractive.sdk.measurement.tracker.e.CloseButton);
        com.fyber.inneractive.sdk.response.f fVar = (com.fyber.inneractive.sdk.response.f) ((O) this.b).b;
        int i = fVar.e;
        int i2 = fVar.f;
        boolean z = (i == 300 && i2 == 250) || (i == 600 && i2 == 500);
        this.B = z;
        if (z) {
            this.y.setAdDefaultSize(AbstractC3251o.a(i), AbstractC3251o.a(i2));
        }
        if (this.w == null) {
            this.w = new r(this);
        }
        this.y.setListener(this.w);
        InneractiveAdSpot inneractiveAdSpot = this.f1772a;
        if (inneractiveAdSpot != null && inneractiveAdSpot.getAdContent() != null && activity != null) {
            x adContent = this.f1772a.getAdContent();
            C3102g c3102g = new C3102g(activity, false, adContent.f1840a, adContent.c(), adContent.c);
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.ia_identifier_overlay);
            IFyberAdIdentifier.Corner corner = IFyberAdIdentifier.Corner.BOTTOM_LEFT;
            IFyberAdIdentifier iFyberAdIdentifier = c3102g.d;
            iFyberAdIdentifier.k = corner;
            iFyberAdIdentifier.a(viewGroup);
            viewGroup.setVisibility(0);
            this.y.a(viewGroup, com.fyber.inneractive.sdk.measurement.tracker.e.IdentifierView);
        }
        N();
        IAmraidWebViewController iAmraidWebViewController3 = this.y;
        ViewGroup layout = this.k.getLayout();
        InneractiveAdRequest inneractiveAdRequest = ((O) this.b).f1840a;
        iAmraidWebViewController3.a(layout, (ViewGroup.LayoutParams) null);
        this.z = true;
        if (this.F == UnitDisplayType.REWARDED) {
            x0 x0Var = new x0(TimeUnit.SECONDS, IAConfigManager.O.u.b.a("rewarded_mraid_delay", 31, 30));
            this.E = x0Var;
            x0Var.e = new q(this);
            v0 v0Var = new v0(x0Var);
            x0Var.c = v0Var;
            x0Var.d = false;
            v0Var.sendEmptyMessage(1932593528);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final /* bridge */ /* synthetic */ boolean b(x xVar) {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final void d(View view) {
        IAmraidWebViewController iAmraidWebViewController = this.y;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.a(view, com.fyber.inneractive.sdk.measurement.tracker.e.ProgressOverlay);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.flow.A, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        InneractiveUnitController.EventsListener eventsListener;
        if (this.z && !this.A && (eventsListener = this.c) != null) {
            this.A = true;
            ((InneractiveFullscreenAdEventsListener) eventsListener).onAdDismissed(this.f1772a);
        }
        this.w = null;
        x0 x0Var = this.E;
        if (x0Var != null) {
            x0Var.e = null;
            this.E = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final void e(View view) {
        com.fyber.inneractive.sdk.measurement.tracker.f fVar;
        IAmraidWebViewController iAmraidWebViewController = this.y;
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

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void k() {
        com.fyber.inneractive.sdk.config.global.r rVar;
        InneractiveUnitController.EventsListener eventsListener;
        if (this.F == UnitDisplayType.REWARDED && this.G) {
            M();
        }
        if (!this.A && (eventsListener = this.c) != null) {
            this.A = true;
            ((InneractiveFullscreenAdEventsListener) eventsListener).onAdDismissed(this.f1772a);
        }
        b0 b0Var = this.J;
        if (b0Var != null && b0Var.b != 0) {
            long jCurrentTimeMillis = (System.currentTimeMillis() - b0Var.b) - b0Var.d;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long seconds = timeUnit.toSeconds(jCurrentTimeMillis);
            long millis = timeUnit.toMillis(jCurrentTimeMillis - TimeUnit.SECONDS.toMillis(seconds));
            Locale locale = Locale.US;
            String str = seconds + "." + millis;
            b0Var.b = 0L;
            b0Var.c = 0L;
            b0Var.d = 0L;
            InneractiveAdSpot inneractiveAdSpot = b0Var.f2357a;
            x adContent = inneractiveAdSpot != null ? inneractiveAdSpot.getAdContent() : null;
            EnumC3144u enumC3144u = EnumC3144u.INTERSTITIAL_VIEW_TIME;
            InneractiveAdRequest inneractiveAdRequest = adContent != null ? adContent.f1840a : null;
            com.fyber.inneractive.sdk.response.e eVarC = adContent != null ? adContent.c() : null;
            JSONArray jSONArrayB = (adContent == null || (rVar = adContent.c) == null) ? null : rVar.b();
            C3146w c3146w = new C3146w(eVarC);
            c3146w.c = enumC3144u;
            c3146w.f1934a = inneractiveAdRequest;
            c3146w.d = jSONArrayB;
            c3146w.a("time", str);
            c3146w.a((String) null);
        }
        InneractiveAdSpot inneractiveAdSpot2 = this.f1772a;
        if (inneractiveAdSpot2 == null || !(inneractiveAdSpot2 instanceof G)) {
            return;
        }
        ((G) inneractiveAdSpot2).a();
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void m() {
        x0 x0Var;
        super.m();
        if (this.F == UnitDisplayType.REWARDED && (x0Var = this.E) != null) {
            x0Var.d = false;
            x0Var.a(SystemClock.uptimeMillis());
        }
        b0 b0Var = this.J;
        if (b0Var != null) {
            if (b0Var.b == 0) {
                b0Var.b = System.currentTimeMillis();
            }
            if (b0Var.c > 0) {
                b0Var.d += System.currentTimeMillis() - b0Var.c;
                b0Var.c = 0L;
            }
        }
        C3237a c3237a = this.u;
        if (!c3237a.b || c3237a.e <= 0) {
            return;
        }
        c3237a.f += System.currentTimeMillis() - c3237a.e;
        c3237a.e = 0L;
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void r() {
        x0 x0Var;
        super.r();
        if (this.F == UnitDisplayType.REWARDED && (x0Var = this.E) != null) {
            x0Var.d = true;
            v0 v0Var = x0Var.c;
            if (v0Var != null) {
                v0Var.removeMessages(1932593528);
            }
        }
        b0 b0Var = this.J;
        if (b0Var != null) {
            b0Var.c = System.currentTimeMillis();
        }
        C3237a c3237a = this.u;
        if (c3237a.b) {
            c3237a.e = System.currentTimeMillis();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean t() {
        boolean z;
        if (this.k == null) {
            z = true;
        } else if (this.F == UnitDisplayType.REWARDED) {
            if (this.G) {
                M();
            }
            z = this.G;
        } else {
            z = this.p;
        }
        if (!z) {
            return true;
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar == null) {
            return false;
        }
        eVar.dismissAd(true);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final Context w() {
        IAmraidWebViewController iAmraidWebViewController = this.y;
        return c(iAmraidWebViewController != null ? iAmraidWebViewController.b : null);
    }

    public final void M() {
        IAlog.a("%sprovide reward called", IAlog.a(this));
        if (this.H) {
            IAlog.a("%sreward was already provided", IAlog.a(this));
            return;
        }
        IAlog.a("%sreward sent", IAlog.a(this));
        if (this.I != null) {
            A.a(com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION, com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_DISPLAY);
            com.fyber.inneractive.sdk.external.g gVar = this.I;
            G g = (G) AbstractC3256u.a(((Q) gVar.f1765a).mAdSpot);
            InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener = gVar.f1765a.b;
            if (inneractiveFullScreenAdRewardedListener != null && g != null) {
                inneractiveFullScreenAdRewardedListener.onAdRewarded(g);
            }
        }
        IAmraidWebViewController iAmraidWebViewController = this.y;
        if (iAmraidWebViewController == null || !iAmraidWebViewController.D) {
            F();
        }
        this.H = true;
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void b(boolean z) {
        if (!G()) {
            if (z) {
                this.u.a((String) null);
            } else {
                C3237a c3237a = this.u;
                c3237a.d = 0L;
                c3237a.e = 0L;
                c3237a.f = 0L;
                c3237a.b = false;
            }
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            eVar.destroy();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
        N();
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final long a(long j) {
        if (this.F == UnitDisplayType.REWARDED) {
            return 0L;
        }
        if (this.t) {
            return j;
        }
        long j2 = 13;
        try {
            j2 = Long.parseLong(IAConfigManager.O.u.b.a("mraid_x_fallback_delay", Long.toString(13L)));
        } catch (Throwable unused) {
        }
        return j2 * 1000;
    }

    public static void a(s sVar) {
        String str;
        if (sVar.b == null) {
            return;
        }
        IAmraidWebViewController iAmraidWebViewController = sVar.y;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.l();
        }
        com.fyber.inneractive.sdk.response.e eVar = ((O) sVar.b).b;
        if (eVar != null && (str = eVar.k) != null && str.trim().length() > 0) {
            IAlog.e("%sfiring impression!", IAlog.a(sVar));
            IAlog.d("AD_IMPRESSION", new Object[0]);
            Z.b(str);
        }
        C3274m c3274m = sVar.y.b;
        if (c3274m != null) {
            c3274m.a("var forceReflow = function(elem){ elem = elem || document.documentElement; elem.style.zIndex = 2147483646; var width = elem.style.width, px = elem.offsetWidth+1; elem.style.width = px+'px'; setTimeout(function(){ elem.style.zIndex = 2147483646; elem.style.width = width; elem = null; }, 0); }; forceReflow(document.documentElement);");
        }
        A.a(com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION, sVar.F == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_DISPLAY);
        sVar.C();
        sVar.H();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
        this.I = gVar;
    }
}
