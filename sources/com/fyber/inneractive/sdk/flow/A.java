package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.Z;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRenderer;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListenerWithImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListenerWithImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.OnGlobalImpressionDataListener;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.model.vast.C3117a;
import com.fyber.inneractive.sdk.network.AbstractC3149z;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.C3147x;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.web.W;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.safedk.android.internal.special.SpecialsBridge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class A implements InneractiveAdRenderer, InneractiveInternalBrowserActivity.InternalBrowserListener, com.fyber.inneractive.sdk.click.f, com.fyber.inneractive.sdk.web.U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveAdSpot f1772a;
    public x b;
    public InneractiveUnitController.EventsListener c;
    public boolean d = false;
    public boolean e = false;
    public boolean f = true;
    public Runnable g;
    public com.fyber.inneractive.sdk.click.r h;
    public y i;
    public View j;

    public final boolean A() {
        com.fyber.inneractive.sdk.config.global.r rVar;
        x xVar = this.b;
        if (xVar != null && (rVar = xVar.c) != null && rVar.a(com.fyber.inneractive.sdk.config.global.features.c.class) != null) {
            com.fyber.inneractive.sdk.config.global.features.c cVar = (com.fyber.inneractive.sdk.config.global.features.c) this.b.c.a(com.fyber.inneractive.sdk.config.global.features.c.class);
            cVar.getClass();
            if (new ArrayList(cVar.c.values()).size() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean B() {
        return false;
    }

    public final void C() {
        com.fyber.inneractive.sdk.response.e eVarC;
        Context contextW = w();
        if (this.e || this.c == null) {
            return;
        }
        IAlog.a("%sCalling external interface onAdImpression", IAlog.a(this));
        this.c.onAdImpression(this.f1772a);
        x xVar = this.b;
        if (xVar != null && (eVarC = xVar.c()) != null) {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            Z z = iAConfigManager.x;
            if (z != null) {
                UnitDisplayType unitDisplayType = eVarC.p;
                ImpressionData impressionData = eVarC.t;
                z.a(unitDisplayType, "LAST_DOMAIN_SHOWED", impressionData != null ? impressionData.getAdvertiserDomain() : null);
                z.a(unitDisplayType, "LAST_APP_BUNDLE_ID", eVarC.A);
                if (this.b.isVideoAd()) {
                    String[] strArr = new String[1];
                    z.a(unitDisplayType, "LAST_VAST_SKIPED", "0");
                    String[] strArr2 = new String[1];
                    z.a(unitDisplayType, "LAST_VAST_CLICKED_TYPE", "0");
                }
                String[] strArr3 = new String[1];
                z.a(unitDisplayType, "LAST_CLICKED", "0");
            }
            com.fyber.inneractive.sdk.util.Z z2 = iAConfigManager.A;
            com.fyber.inneractive.sdk.config.U u = this.b.d;
            ImpressionData impressionData2 = eVarC.t;
            if (u != null) {
                OnGlobalImpressionDataListener onGlobalImpressionDataListener = z2.f2355a;
                if (onGlobalImpressionDataListener != null) {
                    com.fyber.inneractive.sdk.config.T t = (com.fyber.inneractive.sdk.config.T) u;
                    SpecialsBridge.fyberOnImpression(onGlobalImpressionDataListener, t.b, t.f1681a, impressionData2);
                }
            } else {
                z2.getClass();
            }
            InneractiveUnitController.EventsListener eventsListener = this.c;
            if (eventsListener instanceof InneractiveFullscreenAdEventsListenerWithImpressionData) {
                ((InneractiveFullscreenAdEventsListenerWithImpressionData) eventsListener).onAdImpression(this.f1772a, eVarC.t);
            } else if (eventsListener instanceof InneractiveAdViewEventsListenerWithImpressionData) {
                ((InneractiveAdViewEventsListenerWithImpressionData) eventsListener).onAdImpression(this.f1772a, eVarC.t);
            }
            com.fyber.inneractive.sdk.privacysandbox.b bVarA = com.fyber.inneractive.sdk.privacysandbox.b.a(contextW);
            if (bVarA == null) {
                bVarA = null;
            }
            String str = eVarC.m;
            if (!TextUtils.isEmpty(str) && bVarA != null) {
                bVarA.a(str, null);
            }
        }
        this.e = true;
    }

    public final void D() {
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdWillOpenExternalApp", IAlog.a(this));
            this.c.onAdWillOpenExternalApp(this.f1772a);
        }
    }

    public void E() {
        View viewX = x();
        if (viewX == null || this.j == null || viewX.getParent() == null || !(viewX.getParent() instanceof ViewGroup)) {
            return;
        }
        viewX.getLayoutParams();
        ((ViewGroup) viewX.getParent()).removeView(this.j);
        e(this.j);
        this.j = null;
    }

    public final void F() {
        x xVar = this.b;
        if (xVar == null || xVar.c() == null) {
            return;
        }
        String str = this.b.c().q;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IAlog.e("%sfiring rewarded completion!", IAlog.a(this));
        IAlog.d("AD_REWARDED_COMPLETION", new Object[0]);
        com.fyber.inneractive.sdk.network.Z.b(str);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:60:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:63:0x0105  */
    /* JADX WARN: Code duplicated, block: B:66:0x0113 A[LOOP:0: B:64:0x010d->B:66:0x0113, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x0126  */
    /* JADX WARN: Code duplicated, block: B:73:0x016a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0170  */
    /* JADX WARN: Code duplicated, block: B:76:0x0173  */
    /* JADX WARN: Code duplicated, block: B:82:0x0182  */
    /* JADX WARN: Code duplicated, block: B:93:0x01a9  */
    public final com.fyber.inneractive.sdk.util.D a(Context context, String str, h0 h0Var, EnumC3243g enumC3243g) {
        String queryParameter;
        String strReplace;
        boolean z;
        com.fyber.inneractive.sdk.click.r rVar;
        x xVar;
        W wB;
        x xVar2;
        x xVar3;
        com.fyber.inneractive.sdk.ignite.m mVar;
        Iterator it;
        com.fyber.inneractive.sdk.network.h0 h0Var2;
        boolean z2;
        if (!this.f || this.d) {
            String str2 = this.d ? "external/browser is already open" : "click is in grace period";
            IAlog.a("InneractiveAdRendererImpl: openClickThroughUrl - %s", str2);
            return new com.fyber.inneractive.sdk.util.D(com.fyber.inneractive.sdk.util.G.FAILED, new Exception(str2));
        }
        if (context != null) {
            IAlog.a("%sBlocking clicks until grace has ended", IAlog.a(this));
            this.f = false;
            Runnable runnable = this.g;
            if (runnable != null) {
                com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            }
            z zVar = new z(this);
            this.g = zVar;
            com.fyber.inneractive.sdk.util.r.b.postDelayed(zVar, 1000L);
        }
        a(context, h0Var.f2364a, h0Var.b);
        if (TextUtils.isEmpty(str)) {
            IAlog.a("InneractiveAdRendererImpl: openClickThroughUrl - is empty", new Object[0]);
            return new com.fyber.inneractive.sdk.util.D(com.fyber.inneractive.sdk.util.G.FAILED, new Exception("empty url"));
        }
        x xVar4 = this.b;
        if (xVar4 != null && xVar4.c() != null && this.b.c().a()) {
            com.fyber.inneractive.sdk.ignite.h hVar = IAConfigManager.O.E;
            if (hVar.f) {
                hVar.a((com.digitalturbine.ignite.authenticator.listeners.internal.a) null);
            }
        }
        this.i = new y(this, h0Var, enumC3243g);
        if (TextUtils.isEmpty(str)) {
            queryParameter = null;
        } else {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (scheme == null || !scheme.equals("fybernativebrowser") || host == null || !host.equals("navigate")) {
                queryParameter = null;
            } else {
                queryParameter = uri.getQueryParameter("url");
            }
        }
        String scheme2 = !TextUtils.isEmpty(str) ? Uri.parse(str).getScheme() : null;
        if (TextUtils.isEmpty(queryParameter)) {
            strReplace = str;
            if (!strReplace.contains("FYBER_OPEN_BROWSER")) {
                z = true;
            }
            if (strReplace.contains("[IS_CTA_CLICK]")) {
                if (B() || enumC3243g != EnumC3243g.VIDEO_CTA) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                strReplace = strReplace.replace("[IS_CTA_CLICK]", String.valueOf(z2));
            }
            if (x() != null) {
                v();
            }
            rVar = this.h;
            if (rVar != null) {
                rVar.e = true;
                it = rVar.i.iterator();
                while (it.hasNext()) {
                    ((com.fyber.inneractive.sdk.click.a) it.next()).cancel();
                }
                rVar.i.clear();
                h0Var2 = rVar.h;
                if (h0Var2 != null) {
                    h0Var2.f1914a = true;
                }
                rVar.d = null;
                this.h = null;
            }
            com.fyber.inneractive.sdk.click.r rVar2 = new com.fyber.inneractive.sdk.click.r(z);
            rVar2.i.addAll(Arrays.asList(new com.fyber.inneractive.sdk.click.i(!z, scheme2), new com.fyber.inneractive.sdk.click.g(this, h0Var, enumC3243g), new com.fyber.inneractive.sdk.click.d(), new com.fyber.inneractive.sdk.click.h(), new com.fyber.inneractive.sdk.click.l()));
            this.h = rVar2;
            xVar = this.b;
            if (xVar != null) {
                wB = xVar.b();
            } else {
                wB = null;
            }
            if (wB != null) {
                wB.i = this;
            }
            x xVar5 = this.b;
            boolean z3 = xVar5 == null && xVar5.a(h0Var.c, enumC3243g);
            xVar2 = this.b;
            if (xVar2 != null && xVar2.c() != null) {
                this.b.g();
            }
            com.fyber.inneractive.sdk.click.r rVar3 = this.h;
            y yVar = this.i;
            xVar3 = this.b;
            if (xVar3 != null || xVar3.c() == null) {
                mVar = com.fyber.inneractive.sdk.ignite.m.NONE;
            } else {
                mVar = this.b.c().H;
            }
            rVar3.a(context, strReplace, yVar, wB, z3, mVar, this.f1772a.getLocalUniqueId());
            com.fyber.inneractive.sdk.util.G g = com.fyber.inneractive.sdk.util.G.OPEN_IN_EXTERNAL_APPLICATION;
            context.getClass();
            return new com.fyber.inneractive.sdk.util.D(g, null);
        }
        strReplace = queryParameter;
        z = false;
        if (strReplace.contains("[IS_CTA_CLICK]")) {
            if (B()) {
                z2 = false;
            } else {
                z2 = false;
            }
            strReplace = strReplace.replace("[IS_CTA_CLICK]", String.valueOf(z2));
        }
        if (x() != null) {
            v();
        }
        rVar = this.h;
        if (rVar != null) {
            rVar.e = true;
            it = rVar.i.iterator();
            while (it.hasNext()) {
                ((com.fyber.inneractive.sdk.click.a) it.next()).cancel();
            }
            rVar.i.clear();
            h0Var2 = rVar.h;
            if (h0Var2 != null) {
                h0Var2.f1914a = true;
            }
            rVar.d = null;
            this.h = null;
        }
        com.fyber.inneractive.sdk.click.r rVar4 = new com.fyber.inneractive.sdk.click.r(z);
        rVar4.i.addAll(Arrays.asList(new com.fyber.inneractive.sdk.click.i(!z, scheme2), new com.fyber.inneractive.sdk.click.g(this, h0Var, enumC3243g), new com.fyber.inneractive.sdk.click.d(), new com.fyber.inneractive.sdk.click.h(), new com.fyber.inneractive.sdk.click.l()));
        this.h = rVar4;
        xVar = this.b;
        if (xVar != null) {
            wB = xVar.b();
        } else {
            wB = null;
        }
        if (wB != null) {
            wB.i = this;
        }
        x xVar6 = this.b;
        if (xVar6 == null) {
        }
        xVar2 = this.b;
        if (xVar2 != null) {
            this.b.g();
        }
        com.fyber.inneractive.sdk.click.r rVar5 = this.h;
        y yVar2 = this.i;
        xVar3 = this.b;
        if (xVar3 != null) {
            mVar = com.fyber.inneractive.sdk.ignite.m.NONE;
        } else {
            mVar = com.fyber.inneractive.sdk.ignite.m.NONE;
        }
        rVar5.a(context, strReplace, yVar2, wB, z3, mVar, this.f1772a.getLocalUniqueId());
        com.fyber.inneractive.sdk.util.G g2 = com.fyber.inneractive.sdk.util.G.OPEN_IN_EXTERNAL_APPLICATION;
        context.getClass();
        return new com.fyber.inneractive.sdk.util.D(g2, null);
    }

    public final void b(com.fyber.inneractive.sdk.response.e eVar) {
        String str = eVar.k;
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        IAlog.e("%sfiring impression!", IAlog.a(this));
        IAlog.d("AD_IMPRESSION", new Object[0]);
        com.fyber.inneractive.sdk.network.Z.b(str);
    }

    public final Context c(View view) {
        View view2;
        View[] viewArr = {view, x()};
        for (int i = 0; i < 2; i++) {
            view2 = viewArr[i];
            if (view2 != null) {
                return AbstractC3251o.a(view2);
            }
        }
        view2 = null;
        return AbstractC3251o.a(view2);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public boolean canRefreshAd() {
        return true;
    }

    public void d(View view) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        if (this.d) {
            InneractiveInternalBrowserActivity.setInternalBrowserListener(null);
            this.d = false;
        }
        Runnable runnable = this.g;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            this.g = null;
        }
        this.b = null;
        this.c = null;
        this.f1772a = null;
        if (this.h != null) {
            E();
            com.fyber.inneractive.sdk.click.r rVar = this.h;
            rVar.e = true;
            Iterator it = rVar.i.iterator();
            while (it.hasNext()) {
                ((com.fyber.inneractive.sdk.click.a) it.next()).cancel();
            }
            rVar.i.clear();
            com.fyber.inneractive.sdk.network.h0 h0Var = rVar.h;
            if (h0Var != null) {
                h0Var.f1914a = true;
            }
            rVar.d = null;
            this.h = null;
            this.i = null;
        }
    }

    public void e(View view) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void initialize(InneractiveAdSpot inneractiveAdSpot) {
        this.f1772a = inneractiveAdSpot;
        this.b = inneractiveAdSpot.getAdContent();
        this.c = inneractiveAdSpot.getSelectedUnitController().getEventsListener();
    }

    public final com.fyber.inneractive.sdk.ignite.m o() {
        x xVar = this.b;
        return (xVar == null || !xVar.e() || this.b.c() == null) ? com.fyber.inneractive.sdk.ignite.m.NONE : this.b.c().H;
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.InternalBrowserListener
    public final void onApplicationInBackground() {
        D();
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.InternalBrowserListener
    public final void onInternalBrowserDismissed() {
        IAlog.a("onInternalBrowserDismissed callback called", new Object[0]);
        if (this.d) {
            this.d = false;
            InneractiveInternalBrowserActivity.setInternalBrowserListener(null);
        }
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdWillCloseInternalBrowser", IAlog.a(this));
            this.c.onAdWillCloseInternalBrowser(this.f1772a);
        }
    }

    public void v() {
        View viewX = x();
        if (viewX == null || viewX.getParent() == null || !(viewX.getParent() instanceof ViewGroup) || this.j != null) {
            return;
        }
        View viewInflate = View.inflate(viewX.getContext(), R.layout.ia_layout_click_overlay, null);
        this.j = viewInflate;
        if (viewInflate != null) {
            ((ViewGroup) viewX.getParent()).addView(this.j, viewX.getLayoutParams());
            d(this.j);
        }
    }

    public Context w() {
        return AbstractC3251o.a(x());
    }

    public abstract View x();

    public int y() {
        return -1;
    }

    public int z() {
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:115:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:91:0x018d  */
    public final void b(com.fyber.inneractive.sdk.click.b bVar, h0 h0Var, EnumC3243g enumC3243g) {
        boolean z;
        boolean z2;
        com.fyber.inneractive.sdk.config.global.r rVar;
        com.fyber.inneractive.sdk.config.global.r rVar2;
        Object obj;
        com.fyber.inneractive.sdk.config.global.r rVar3;
        x xVar = this.b;
        InneractiveAdRequest inneractiveAdRequest = xVar != null ? xVar.f1840a : null;
        com.fyber.inneractive.sdk.response.e eVarC = xVar != null ? xVar.c() : null;
        x xVar2 = this.b;
        JSONArray jSONArrayB = (xVar2 == null || (rVar3 = xVar2.c) == null) ? null : rVar3.b();
        EnumC3144u enumC3144u = EnumC3144u.FYBER_SUCCESS_CLICK;
        C3146w c3146w = new C3146w(eVarC);
        c3146w.c = enumC3144u;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArrayB;
        C3147x c3147x = new C3147x();
        long j = bVar.e;
        if (j != 0) {
            c3147x.a(Long.valueOf(j), "time_passed");
        }
        JSONArray jSONArray = new JSONArray();
        for (com.fyber.inneractive.sdk.click.j jVar : bVar.f) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", jVar.f1660a);
                jSONObject.put("success", jVar.b);
                jSONObject.put("opened_by", jVar.c);
                jSONObject.put("reason", jVar.d);
            } catch (Exception unused) {
            }
            jSONArray.put(jSONObject);
        }
        c3147x.a(jSONArray, "urls");
        c3147x.a(enumC3243g, "origin");
        if (enumC3243g == EnumC3243g.FMP_ENDCARD) {
            c3147x.a(enumC3243g.a(), "version");
        }
        if (h0Var != null && h0Var.c) {
            c3147x.a(Boolean.TRUE, "is_auto_click");
        }
        boolean z3 = true;
        if (h0Var != null) {
            if (h0Var.f2364a > 0.0f && h0Var.b > 0.0f) {
                x xVar3 = this.b;
                boolean zD = xVar3 != null ? xVar3.d() : true;
                int iZ = z();
                if (!zD) {
                    iZ = AbstractC3251o.a(iZ);
                }
                float f = iZ == 0 ? 0.0f : h0Var.f2364a / iZ;
                x xVar4 = this.b;
                boolean zD2 = xVar4 != null ? xVar4.d() : true;
                int iY = y();
                if (!zD2) {
                    iY = AbstractC3251o.a(iY);
                }
                float f2 = iY != 0 ? h0Var.b / iY : 0.0f;
                IAlog.a("Point location -  x - %.2f , y- %.2f", Float.valueOf(f), Float.valueOf(f2));
                x xVar5 = this.b;
                if (xVar5 != null) {
                    xVar5.d();
                }
                Locale locale = Locale.ENGLISH;
                C3147x c3147xA = c3147x.a(String.format(locale, "%.2f", Float.valueOf(f)), "td_x");
                x xVar6 = this.b;
                if (xVar6 != null) {
                    xVar6.d();
                }
                c3147xA.a(String.format(locale, "%.2f", Float.valueOf(f2)), "td_y");
            }
        }
        x xVar7 = this.b;
        if (xVar7 != null ? xVar7.d() : true) {
            if (AbstractC3251o.d() == 1) {
                obj = "p";
            } else {
                obj = "l";
            }
            c3147x.a(obj, "o");
        } else {
            c3147x.a(Integer.valueOf(z()), "b_w");
            c3147x.a(Integer.valueOf(y()), "b_h");
        }
        x xVar8 = this.b;
        com.fyber.inneractive.sdk.config.global.features.d dVar = (xVar8 == null || (rVar2 = xVar8.c) == null) ? null : (com.fyber.inneractive.sdk.config.global.features.d) rVar2.a(com.fyber.inneractive.sdk.config.global.features.d.class);
        if (dVar == null) {
            z = false;
        } else {
            C3117a c3117a = dVar.e;
            if (c3117a != null ? c3117a.d : false) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            z3 = false;
        } else if (!EnumC3243g.DEFAULT_ENDCARD.equals(enumC3243g) && !EnumC3243g.VIDEO_CTA.equals(enumC3243g)) {
            if (EnumC3243g.VIDEO_CLICK.equals(enumC3243g)) {
                x xVar9 = this.b;
                com.fyber.inneractive.sdk.config.global.features.w wVar = (xVar9 == null || (rVar = xVar9.c) == null) ? null : (com.fyber.inneractive.sdk.config.global.features.w) rVar.a(com.fyber.inneractive.sdk.config.global.features.w.class);
                if (wVar == null) {
                    z2 = false;
                } else {
                    Boolean boolC = wVar.c("show_cta");
                    if (boolC != null ? boolC.booleanValue() : true) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                if (!z2) {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
        }
        if (z3) {
            c3147x.a(IAConfigManager.O.o, "cta_lng");
        }
        c3146w.f.put(c3147x.f1935a);
        c3146w.a((String) null);
    }

    public static void a(com.fyber.inneractive.sdk.response.e eVar) {
        String str = eVar.l;
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        IAlog.d("AD_CLICKED", new Object[0]);
        com.fyber.inneractive.sdk.network.Z.b(str);
    }

    @Override // com.fyber.inneractive.sdk.click.f
    public final void a(com.fyber.inneractive.sdk.click.b bVar, h0 h0Var, EnumC3243g enumC3243g) {
        b(bVar, h0Var, enumC3243g);
    }

    public final void a(String str, com.fyber.inneractive.sdk.click.q qVar) {
        com.fyber.inneractive.sdk.response.e eVarC;
        JSONArray jSONArrayB;
        InneractiveAdRequest inneractiveAdRequest;
        x xVar = this.b;
        if (xVar != null) {
            eVarC = xVar.c();
            x xVar2 = this.b;
            inneractiveAdRequest = xVar2.f1840a;
            com.fyber.inneractive.sdk.config.global.r rVar = xVar2.c;
            jSONArrayB = rVar != null ? rVar.b() : null;
        } else {
            eVarC = null;
            jSONArrayB = null;
            inneractiveAdRequest = null;
        }
        EnumC3144u enumC3144u = EnumC3144u.EXTERNAL_BROWSER_OPENED;
        C3146w c3146w = new C3146w(eVarC);
        c3146w.c = enumC3144u;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArrayB;
        c3146w.a("url", str).a(POBNativeConstants.NATIVE_FALLBACK_URL, (qVar == com.fyber.inneractive.sdk.click.q.OPENED_USING_CHROME_NAVIGATE || qVar == com.fyber.inneractive.sdk.click.q.OPENED_IN_EXTERNAL_BROWSER) ? "chrome" : "na").a((String) null);
    }

    public final void a(Context context, float f, float f2) {
        com.fyber.inneractive.sdk.response.e eVarC;
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdClicked", IAlog.a(this));
            this.c.onAdClicked(this.f1772a);
        }
        x xVar = this.b;
        if (xVar == null || (eVarC = xVar.c()) == null) {
            return;
        }
        IAConfigManager.O.x.a(eVarC.p, "LAST_CLICKED", "1");
        com.fyber.inneractive.sdk.privacysandbox.b bVarA = com.fyber.inneractive.sdk.privacysandbox.b.a(context);
        if (bVarA == null) {
            bVarA = null;
        }
        String str = eVarC.n;
        Float fValueOf = Float.valueOf(f);
        Float fValueOf2 = Float.valueOf(f2);
        if (!fValueOf.isNaN() && !fValueOf2.isNaN() && f >= 0.0f && f2 >= 0.0f) {
            MotionEvent motionEventObtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, f, f2, 0);
            if (TextUtils.isEmpty(str) || bVarA == null) {
                return;
            }
            bVarA.a(str, motionEventObtain);
            return;
        }
        if (TextUtils.isEmpty(str) || bVarA == null) {
            return;
        }
        bVarA.a(str, null);
    }

    public final void a(WebViewRendererProcessHasGoneError webViewRendererProcessHasGoneError) {
        String simpleName = webViewRendererProcessHasGoneError.getClass().getSimpleName();
        String message = webViewRendererProcessHasGoneError.getMessage();
        x xVar = this.b;
        AbstractC3149z.a(simpleName, message, xVar != null ? xVar.f1840a : null, xVar != null ? xVar.c() : null);
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdEnteredErrorState: %s", IAlog.a(this), webViewRendererProcessHasGoneError.getMessage());
            this.c.onAdEnteredErrorState(this.f1772a, webViewRendererProcessHasGoneError);
        }
    }

    public static void a(com.fyber.inneractive.sdk.cache.session.enums.a aVar, com.fyber.inneractive.sdk.cache.session.enums.c cVar) {
        com.fyber.inneractive.sdk.cache.session.e eVar = IAConfigManager.O.x.f1684a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.util.r.f2374a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
        }
    }
}
