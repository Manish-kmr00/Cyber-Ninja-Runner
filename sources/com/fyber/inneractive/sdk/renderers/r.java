package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.A;
import com.fyber.inneractive.sdk.flow.L;
import com.fyber.inneractive.sdk.flow.O;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.B;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.C3237a;
import com.fyber.inneractive.sdk.util.D;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.util.v0;
import com.fyber.inneractive.sdk.util.x0;
import com.fyber.inneractive.sdk.web.G;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public final class r implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f2317a;

    public r(s sVar) {
        this.f2317a = sVar;
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final D a(String str, h0 h0Var) {
        s sVar = this.f2317a;
        sVar.getClass();
        IAlog.a("%sweb view callback: onClicked", IAlog.a(sVar));
        Context contextW = this.f2317a.w();
        s sVar2 = this.f2317a;
        com.fyber.inneractive.sdk.interfaces.e eVar = sVar2.k;
        if (eVar != null) {
            contextW = sVar2.c(eVar.getLayout());
        }
        s sVar3 = this.f2317a;
        if (!sVar3.f) {
            return new D(com.fyber.inneractive.sdk.util.G.FAILED, new Exception("No context or no native click detected"));
        }
        x xVar = sVar3.b;
        com.fyber.inneractive.sdk.response.e eVar2 = xVar == null ? null : ((O) xVar).b;
        if (eVar2 != null) {
            A.a(eVar2);
        }
        A.a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, this.f2317a.F == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_DISPLAY);
        return this.f2317a.a(contextW, str, h0Var, EnumC3243g.DISPLAY);
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void b() {
        s sVar = this.f2317a;
        sVar.getClass();
        IAlog.a("%sweb view callback: onResize", IAlog.a(sVar));
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void c() {
        s sVar = this.f2317a;
        sVar.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a(sVar));
        s sVar2 = this.f2317a;
        sVar2.C = true;
        sVar2.N();
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void d() {
        s sVar = this.f2317a;
        sVar.a(sVar.w(), Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void onClose() {
        s sVar = this.f2317a;
        sVar.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a(sVar));
        s sVar2 = this.f2317a;
        if (sVar2.C) {
            sVar2.C = false;
            sVar2.N();
            return;
        }
        if (sVar2.F == UnitDisplayType.REWARDED) {
            sVar2.M();
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f2317a.k;
        if (eVar != null) {
            eVar.dismissAd(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void b(boolean z) {
        if (z) {
            s sVar = this.f2317a;
            if (!sVar.s) {
                sVar.s = true;
                com.fyber.inneractive.sdk.interfaces.e eVar = sVar.k;
                if (eVar != null) {
                    sVar.c(eVar.isCloseButtonDisplay());
                }
            }
            s sVar2 = this.f2317a;
            if (!sVar2.q) {
                sVar2.q = true;
                x0 x0Var = new x0(TimeUnit.MILLISECONDS, sVar2.r);
                sVar2.m = x0Var;
                x0Var.e = new L(sVar2);
                v0 v0Var = new v0(x0Var);
                x0Var.c = v0Var;
                x0Var.d = false;
                v0Var.sendEmptyMessage(1932593528);
            }
            com.fyber.inneractive.sdk.interfaces.e eVar2 = this.f2317a.k;
            if (eVar2 == null || !eVar2.isCloseButtonDisplay()) {
                return;
            }
            s sVar3 = this.f2317a;
            sVar3.p = false;
            com.fyber.inneractive.sdk.interfaces.e eVar3 = sVar3.k;
            if (eVar3 != null) {
                eVar3.disableCloseButton();
            }
            C3237a c3237a = sVar3.u;
            c3237a.d = 0L;
            c3237a.e = 0L;
            c3237a.f = 0L;
            c3237a.b = false;
        }
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final void a() {
        this.f2317a.a(new WebViewRendererProcessHasGoneError());
        this.f2317a.destroy();
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final void a(String str, String str2) {
        s sVar = this.f2317a;
        sVar.getClass();
        IAlog.a("%sweb view callback: onSuspiciousNoUserWebActionDetected", IAlog.a(sVar));
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f2317a.k;
        if (eVar == null || eVar.getLayout() == null) {
            return;
        }
        s sVar2 = this.f2317a;
        if (!sVar2.D) {
            B.a(sVar2.k.getLayout().getContext(), str, str2, this.f2317a.b);
            s sVar3 = this.f2317a;
            sVar3.D = true;
            sVar3.getClass();
            IAlog.a("%sreporting auto redirect", IAlog.a(sVar3));
            return;
        }
        sVar2.getClass();
        IAlog.a("%sredirect already reported for this ad", IAlog.a(sVar2));
    }

    @Override // com.fyber.inneractive.sdk.web.k0
    public final void a(boolean z) {
        if (z) {
            s sVar = this.f2317a;
            if (!sVar.x) {
                sVar.x = true;
                s.a(sVar);
            }
        }
        s sVar2 = this.f2317a;
        sVar2.getClass();
        IAlog.a("%sweb view callback: onVisibilityChanged: %s", IAlog.a(sVar2), Boolean.valueOf(z));
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void a(boolean z, Orientation orientation) {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f2317a.k;
        if (eVar != null) {
            eVar.setActivityOrientation(z, orientation);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final boolean a(String str) {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f2317a.k;
        if (eVar == null || eVar.getLayout() == null) {
            return false;
        }
        s sVar = this.f2317a;
        Context contextC = sVar.c(sVar.k.getLayout());
        boolean zStartRichMediaIntent = InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(contextC, str);
        if (!zStartRichMediaIntent) {
            return zStartRichMediaIntent;
        }
        this.f2317a.a(contextC, Float.NaN, Float.NaN);
        return zStartRichMediaIntent;
    }

    @Override // com.fyber.inneractive.sdk.web.B
    public final void a(IAmraidWebViewController.MraidVideoFailedToDisplayError mraidVideoFailedToDisplayError) {
        this.f2317a.d(false);
        s sVar = this.f2317a;
        InneractiveUnitController.EventsListener eventsListener = sVar.c;
        if (eventsListener != null) {
            ((InneractiveFullscreenAdEventsListener) eventsListener).onAdEnteredErrorState(sVar.f1772a, mraidVideoFailedToDisplayError);
        }
    }
}
