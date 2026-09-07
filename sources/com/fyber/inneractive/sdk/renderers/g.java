package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.M;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.A;
import com.fyber.inneractive.sdk.flow.O;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.D;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.G;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.B;
import com.safedk.android.internal.special.SpecialsBridge;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f2310a;

    public g(k kVar) {
        this.f2310a = kVar;
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final D a(String str, h0 h0Var) {
        U u;
        k kVar = this.f2310a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onClicked", IAlog.a(kVar));
        ViewGroup viewGroup = this.f2310a.p;
        Context context = (viewGroup == null || viewGroup.getContext() == null) ? AbstractC3251o.f2370a : this.f2310a.p.getContext();
        if (context != null) {
            k kVar2 = this.f2310a;
            if (kVar2.f) {
                x xVar = kVar2.b;
                com.fyber.inneractive.sdk.response.e eVar = xVar != null ? ((O) xVar).b : null;
                if (eVar != null) {
                    A.a(eVar);
                }
                x xVar2 = this.f2310a.b;
                if (xVar2 != null && (u = ((O) xVar2).d) != null) {
                    T t = (T) u;
                    if (t.c != null) {
                        A.a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, t.c.b == UnitDisplayType.MRECT ? com.fyber.inneractive.sdk.cache.session.enums.c.RECTANGLE_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.c.BANNER_DISPLAY);
                    }
                }
                return this.f2310a.a(context, str, h0Var, EnumC3243g.DISPLAY);
            }
        }
        return new D(G.FAILED, new Exception("No context or no native click detected"));
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void a(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void b() {
        this.f2310a.c(true);
        k kVar = this.f2310a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onResize", IAlog.a(kVar));
        k kVar2 = this.f2310a;
        InneractiveUnitController.EventsListener eventsListener = kVar2.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdResized(kVar2.f1772a);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void b(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void c() {
        k kVar = this.f2310a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a(kVar));
        k kVar2 = this.f2310a;
        InneractiveUnitController.EventsListener eventsListener = kVar2.c;
        if (eventsListener != null) {
            SpecialsBridge.fyberOnAdExpanded((InneractiveAdViewEventsListener) eventsListener, kVar2.f1772a);
        }
        k kVar3 = this.f2310a;
        kVar3.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a(kVar3));
        this.f2310a.c(true);
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void d() {
        k kVar = this.f2310a;
        kVar.a(kVar.w(), Float.NaN, Float.NaN);
        this.f2310a.D();
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void onClose() {
        k kVar = this.f2310a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a(kVar));
        k kVar2 = this.f2310a;
        InneractiveUnitController.EventsListener eventsListener = kVar2.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdCollapsed(kVar2.f1772a);
        }
        this.f2310a.K();
        k kVar3 = this.f2310a;
        kVar3.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a(kVar3));
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final void a() {
        this.f2310a.a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final void a(String str, String str2) {
        k kVar = this.f2310a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onSuspiciousNoUserWebActionDetected", IAlog.a(kVar));
        ViewGroup viewGroup = this.f2310a.p;
        if (viewGroup == null || viewGroup.getContext() == null) {
            return;
        }
        k kVar2 = this.f2310a;
        if (!kVar2.v) {
            com.fyber.inneractive.sdk.network.B.a(kVar2.p.getContext(), str, str2, this.f2310a.b);
            k kVar3 = this.f2310a;
            kVar3.v = true;
            kVar3.getClass();
            IAlog.a("%sreporting auto redirect", IAlog.a(kVar3));
            return;
        }
        kVar2.getClass();
        IAlog.a("%sredirect already reported for this ad", IAlog.a(kVar2));
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final void a(boolean z) {
        U u;
        M m;
        com.fyber.inneractive.sdk.cache.session.enums.c cVar;
        k kVar = this.f2310a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onVisibilityChanged: %s", IAlog.a(kVar), Boolean.valueOf(z));
        if (z) {
            k kVar2 = this.f2310a;
            if (!kVar2.o) {
                IAlog.a("%sonShownForTheFirstTime called", IAlog.a(kVar2));
                x xVar = kVar2.b;
                com.fyber.inneractive.sdk.response.e eVar = xVar != null ? ((O) xVar).b : null;
                if (eVar != null) {
                    IAmraidWebViewController iAmraidWebViewController = kVar2.m;
                    if (iAmraidWebViewController != null) {
                        iAmraidWebViewController.l();
                    }
                    kVar2.b(eVar);
                    kVar2.C();
                }
                long jI = kVar2.I();
                kVar2.k = jI;
                if (jI != 0) {
                    kVar2.a(true, jI);
                }
                x xVar2 = kVar2.b;
                if (xVar2 != null && (u = ((O) xVar2).d) != null && (m = ((T) u).c) != null) {
                    com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION;
                    if (m.b == UnitDisplayType.MRECT) {
                        cVar = com.fyber.inneractive.sdk.cache.session.enums.c.RECTANGLE_DISPLAY;
                    } else {
                        cVar = com.fyber.inneractive.sdk.cache.session.enums.c.BANNER_DISPLAY;
                    }
                    A.a(aVar, cVar);
                }
                this.f2310a.o = true;
                return;
            }
            d dVar = kVar2.y;
            if (dVar != null && !dVar.h && !dVar.g && dVar.f != 0) {
                dVar.f = 0L;
                dVar.g = true;
                dVar.a();
            }
            this.f2310a.K();
            return;
        }
        d dVar2 = this.f2310a.y;
        if (dVar2 != null && dVar2.g) {
            dVar2.g = false;
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar2.j);
        }
        this.f2310a.c(false);
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final boolean a(String str) {
        Context contextA = AbstractC3251o.a(this.f2310a.x());
        boolean zStartRichMediaIntent = InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(contextA, str);
        if (zStartRichMediaIntent) {
            k kVar = this.f2310a;
            if (kVar.c != null) {
                kVar.a(contextA, Float.NaN, Float.NaN);
            }
        }
        return zStartRichMediaIntent;
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void a(IAmraidWebViewController.MraidVideoFailedToDisplayError mraidVideoFailedToDisplayError) {
        k kVar = this.f2310a;
        InneractiveUnitController.EventsListener eventsListener = kVar.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdEnteredErrorState(kVar.f1772a, mraidVideoFailedToDisplayError);
        }
    }
}
