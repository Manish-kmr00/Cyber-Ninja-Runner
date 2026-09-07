package com.fyber.inneractive.sdk.flow;

import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.network.AbstractC3137m;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class F implements G, P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1776a;
    public InneractiveAdSpot.RequestListener b;
    public InneractiveAdRequest c;
    public D d;
    public x e;
    public Q f;
    public final HashSet g;
    public C3108m h;
    public E i;
    public boolean j = true;
    public boolean k = false;
    public C3111p l;

    public F() {
        String string = UUID.randomUUID().toString();
        this.f1776a = string;
        this.g = new HashSet();
        IAlog.a("%sInneractiveAdSpotImpl created with UID: %s", IAlog.a(this), string);
    }

    @Override // com.fyber.inneractive.sdk.flow.P
    public final void a(E e) {
        this.i = e;
        requestAd(null);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void addUnitController(InneractiveUnitController inneractiveUnitController) {
        if (inneractiveUnitController != null) {
            Q q = (Q) inneractiveUnitController;
            q.setAdSpot(this);
            if (this.g.size() > 0) {
                for (InneractiveUnitController inneractiveUnitController2 : new HashSet(this.g)) {
                    if (inneractiveUnitController2.getClass().equals(inneractiveUnitController.getClass())) {
                        removeUnitController(inneractiveUnitController2);
                    }
                }
            }
            this.g.add(q);
            if (this.e != null) {
                for (Q q2 : this.g) {
                    if (q2.supports(this)) {
                        this.f = q2;
                        return;
                    }
                }
            }
        }
    }

    public final void b() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((InneractiveUnitController) it.next()).destroy();
        }
        this.g.clear();
        C3111p c3111p = this.l;
        if (c3111p != null) {
            c3111p.a(true);
            c3111p.b = null;
            this.l = null;
        }
        C3108m c3108m = this.h;
        if (c3108m != null) {
            C3107l c3107l = c3108m.g;
            if (c3107l != null) {
                IAConfigManager.removeListener(c3107l);
            }
            AbstractC3137m abstractC3137m = c3108m.d;
            if (abstractC3137m != null) {
                abstractC3137m.a();
                c3108m.d = null;
            }
            c3108m.a(true);
            c3108m.b = null;
            this.h = null;
        }
        this.b = null;
        a();
        InneractiveAdSpotManager.get().removeSpot(this);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final x getAdContent() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveAdRequest getCurrentProcessedRequest() {
        return this.c;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getLocalUniqueId() {
        return this.f1776a;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveMediationName getMediationName() {
        return IAConfigManager.O.m;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getMediationNameString() {
        return IAConfigManager.O.l;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getMediationVersion() {
        return IAConfigManager.O.n;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getRequestedSpotId() {
        InneractiveAdRequest inneractiveAdRequest = this.c;
        return inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : "";
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveUnitController getSelectedUnitController() {
        return this.f;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final boolean isReady() {
        boolean z;
        x xVar;
        x xVar2 = this.e;
        if (xVar2 == null) {
            return false;
        }
        if (xVar2.c() != null) {
            com.fyber.inneractive.sdk.response.e eVarC = this.e.c();
            eVarC.getClass();
            if (eVarC.f2321a < System.currentTimeMillis()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (z && (xVar = this.e) != null) {
            com.fyber.inneractive.sdk.response.e eVarC2 = xVar.c();
            if (!this.k && eVarC2 != null) {
                long minutes = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - eVarC2.c);
                long j = eVarC2.b;
                long j2 = minutes - j;
                IAlog.a("Firing Event 802 - AdExpired - time passed- " + j2 + ", sessionTimeOut - " + j, new Object[0]);
                EnumC3143t enumC3143t = EnumC3143t.IA_AD_EXPIRED;
                InneractiveAdRequest inneractiveAdRequest = xVar.f1840a;
                JSONArray jSONArrayB = xVar.c.b();
                C3146w c3146w = new C3146w(eVarC2);
                c3146w.b = enumC3143t;
                c3146w.f1934a = inneractiveAdRequest;
                c3146w.d = jSONArrayB;
                JSONObject jSONObject = new JSONObject();
                Long lValueOf = Long.valueOf(j2);
                try {
                    jSONObject.put("time_passed", lValueOf);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "time_passed", lValueOf);
                }
                Long lValueOf2 = Long.valueOf(j);
                try {
                    jSONObject.put("timeout", lValueOf2);
                } catch (Exception unused2) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "timeout", lValueOf2);
                }
                c3146w.f.put(jSONObject);
                c3146w.a((String) null);
                this.k = true;
            }
        }
        return !z && this.e.f();
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void removeUnitController(InneractiveUnitController inneractiveUnitController) {
        if (inneractiveUnitController != null) {
            Q q = this.f;
            if (q != null && q.equals(inneractiveUnitController)) {
                this.f.destroy();
                this.f = null;
            }
            this.g.remove(inneractiveUnitController);
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void requestAd(InneractiveAdRequest inneractiveAdRequest) {
        if (IAConfigManager.d()) {
            IAlog.a("%sIAB TCF purpose 1 disabled, dropping request", IAlog.a(this));
            InneractiveAdSpot.RequestListener requestListener = this.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(this, InneractiveErrorCode.IAB_TCF_PURPOSE_1_DISABLED);
                return;
            }
            return;
        }
        IAlog.a("%srequestAd called with request: %s", IAlog.a(this), inneractiveAdRequest);
        if (inneractiveAdRequest == null && this.c == null) {
            IAlog.b("%srequestAd called with a null request, but no previous request is available! Cannot continue", IAlog.a(this));
            InneractiveAdSpot.RequestListener requestListener2 = this.b;
            if (requestListener2 != null) {
                requestListener2.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                return;
            }
            return;
        }
        if (!InneractiveAdManager.wasInitialized()) {
            InneractiveAdSpot.RequestListener requestListener3 = this.b;
            if (requestListener3 != null) {
                requestListener3.onInneractiveFailedAdRequest(this, InneractiveErrorCode.SDK_NOT_INITIALIZED);
                return;
            }
            return;
        }
        InneractiveAdRequest inneractiveAdRequest2 = inneractiveAdRequest != null ? inneractiveAdRequest : this.c;
        String str = this.f1776a;
        inneractiveAdRequest2.b = str;
        com.fyber.inneractive.sdk.metrics.d.d.a(str).c();
        if (this.g.isEmpty()) {
            IAlog.b("%srequestAd called but no AdUnitControllers exist! Cannot continue", IAlog.a(this));
            if (this.b != null) {
                if (inneractiveAdRequest == null) {
                    inneractiveAdRequest = this.c;
                }
                a(inneractiveAdRequest, null);
                this.b.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                return;
            }
            return;
        }
        IAConfigManager.b();
        C3108m c3108m = this.h;
        if (c3108m != null) {
            boolean z = inneractiveAdRequest != null || this.c == null;
            C3107l c3107l = c3108m.g;
            if (c3107l != null) {
                IAConfigManager.removeListener(c3107l);
            }
            AbstractC3137m abstractC3137m = c3108m.d;
            if (abstractC3137m != null) {
                abstractC3137m.a();
                c3108m.d = null;
            }
            c3108m.a(z);
            c3108m.b = null;
        }
        if (inneractiveAdRequest != null) {
            InneractiveAdRequest inneractiveAdRequest3 = this.c;
            if (inneractiveAdRequest3 != null) {
                inneractiveAdRequest.setSelectedUnitConfig(inneractiveAdRequest3.getSelectedUnitConfig());
            }
            this.c = inneractiveAdRequest;
            x xVar = this.e;
            if (xVar != null) {
                xVar.a();
                this.j = true;
            }
            Iterator it = this.g.iterator();
            do {
                if (!it.hasNext()) {
                    this.c.f1782a = false;
                    break;
                }
            } while (!(((Q) it.next()) instanceof InneractiveFullscreenUnitController));
        }
        this.h = new C3108m(this.f1776a);
        if (this.d == null) {
            this.d = new D(this);
        }
        IAlog.a("%sFound ad source for request! %s", IAlog.a(this), this.h);
        IAlog.a("%s initOmidSdkIfNeeded", IAlog.a(this));
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.measurement.e eVar = iAConfigManager.K;
        if (eVar == null || !eVar.f1859a) {
            Application application = AbstractC3251o.f2370a;
            IAlog.c("initOmidSdk", new Object[0]);
            com.fyber.inneractive.sdk.util.r.f2374a.execute(new com.fyber.inneractive.sdk.config.B(iAConfigManager, application));
        }
        iAConfigManager.H.a();
        C3108m c3108m2 = this.h;
        if (c3108m2 != null) {
            InneractiveAdRequest inneractiveAdRequest4 = this.c;
            c3108m2.b = this.d;
            if (IAConfigManager.e()) {
                c3108m2.c(inneractiveAdRequest4);
                return;
            }
            C3107l c3107l2 = new C3107l(c3108m2, inneractiveAdRequest4);
            c3108m2.g = c3107l2;
            IAConfigManager.addListener(c3107l2);
            IAConfigManager.a();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationName(InneractiveMediationName inneractiveMediationName) {
        InneractiveAdManager.setMediationName(inneractiveMediationName);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationVersion(String str) {
        InneractiveAdManager.setMediationVersion(str);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void destroy() {
        IAlog.a("%sInneractiveAdSpotImpl spot destroy: %s", IAlog.a(this), this.f1776a);
        if (Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) {
            com.fyber.inneractive.sdk.util.r.b.post(new C(this));
        } else {
            b();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void loadAd(String str) {
        IAlog.a("%s : InneractiveAdSpotImpl Start load ad process", IAlog.a(this));
        if (IAConfigManager.d()) {
            IAlog.a("%sIAB TCF purpose 1 disabled, dropping request", IAlog.a(this));
            InneractiveAdSpot.RequestListener requestListener = this.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(this, InneractiveErrorCode.IAB_TCF_PURPOSE_1_DISABLED);
                return;
            }
            return;
        }
        if (str == null || TextUtils.isEmpty(str)) {
            InneractiveAdSpot.RequestListener requestListener2 = this.b;
            if (requestListener2 != null) {
                requestListener2.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                return;
            }
            return;
        }
        if (!InneractiveAdManager.wasInitialized()) {
            InneractiveAdSpot.RequestListener requestListener3 = this.b;
            if (requestListener3 != null) {
                requestListener3.onInneractiveFailedAdRequest(this, InneractiveErrorCode.SDK_NOT_INITIALIZED);
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.metrics.d.d.a(this.f1776a).c();
        String str2 = this.f1776a;
        this.l = new C3111p(str2);
        if (this.d == null) {
            this.d = new D(this);
        }
        com.fyber.inneractive.sdk.bidder.adm.y yVar = new com.fyber.inneractive.sdk.bidder.adm.y(str, str2);
        com.fyber.inneractive.sdk.config.global.r rVarA = com.fyber.inneractive.sdk.config.global.r.a();
        B b = new B(this, yVar, rVarA, str);
        IAlog.a("%s initOmidSdkIfNeeded", IAlog.a(this));
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.measurement.e eVar = iAConfigManager.K;
        if (eVar == null || !eVar.f1859a) {
            Application application = AbstractC3251o.f2370a;
            IAlog.c("initOmidSdk", new Object[0]);
            com.fyber.inneractive.sdk.util.r.f2374a.execute(new com.fyber.inneractive.sdk.config.B(iAConfigManager, application));
        }
        iAConfigManager.H.a();
        com.fyber.inneractive.sdk.util.r.f2374a.execute(new com.fyber.inneractive.sdk.bidder.adm.t(yVar, b, rVarA));
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationName(String str) {
        InneractiveAdManager.setMediationName(str);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setRequestListener(InneractiveAdSpot.RequestListener requestListener) {
        IAlog.a("%ssetRequestListener called with: %s", IAlog.a(this), requestListener);
        this.b = requestListener;
    }

    @Override // com.fyber.inneractive.sdk.flow.G
    public final void a() {
        x xVar;
        JSONArray jSONArrayB;
        com.fyber.inneractive.sdk.config.global.r rVar;
        x xVar2 = this.e;
        if (xVar2 != null) {
            if (xVar2.d() && (xVar = this.e) != null && !xVar.e) {
                String string = Arrays.toString(Thread.currentThread().getStackTrace());
                IAlog.a("Firing Event 803 - Stack trace - %s", string);
                EnumC3143t enumC3143t = EnumC3143t.IA_AD_DESTROYED_WITHOUT_SHOW;
                x xVar3 = this.e;
                InneractiveAdRequest inneractiveAdRequest = xVar3.f1840a;
                com.fyber.inneractive.sdk.response.e eVarC = xVar3.c();
                C3108m c3108m = this.h;
                C3111p c3111p = this.l;
                com.fyber.inneractive.sdk.config.global.r rVar2 = c3111p != null ? c3111p.c : null;
                if (c3108m != null && (rVar = c3108m.c) != null) {
                    jSONArrayB = rVar.b();
                } else {
                    jSONArrayB = rVar2 != null ? rVar2.b() : null;
                }
                C3146w c3146w = new C3146w(eVarC);
                c3146w.b = enumC3143t;
                c3146w.f1934a = inneractiveAdRequest;
                c3146w.d = jSONArrayB;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("stack_trace", string);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "stack_trace", string);
                }
                c3146w.f.put(jSONObject);
                c3146w.a((String) null);
            }
            this.e.a();
            this.e = null;
        }
        this.f = null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0033  */
    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        UnitDisplayType unitDisplayType;
        com.fyber.inneractive.sdk.response.e eVar2;
        if (inneractiveAdRequest == null || inneractiveAdRequest.getSelectedUnitConfig() == null) {
            unitDisplayType = null;
        } else if (((com.fyber.inneractive.sdk.config.T) inneractiveAdRequest.getSelectedUnitConfig()).c != null) {
            unitDisplayType = ((com.fyber.inneractive.sdk.config.T) inneractiveAdRequest.getSelectedUnitConfig()).c.b;
        } else if (((com.fyber.inneractive.sdk.config.T) inneractiveAdRequest.getSelectedUnitConfig()).f != null) {
            unitDisplayType = ((com.fyber.inneractive.sdk.config.T) inneractiveAdRequest.getSelectedUnitConfig()).f.j;
        } else {
            unitDisplayType = null;
        }
        x xVar = this.e;
        com.fyber.inneractive.sdk.response.e eVar3 = (xVar == null || (eVar2 = xVar.b) == null) ? eVar : eVar2;
        String str = this.f1776a;
        if (unitDisplayType == null && eVar3 != null) {
            unitDisplayType = eVar3.p;
        }
        UnitDisplayType unitDisplayType2 = unitDisplayType;
        x xVar2 = this.e;
        new com.fyber.inneractive.sdk.metrics.c(eVar3, inneractiveAdRequest, str, unitDisplayType2, xVar2 != null ? xVar2.c.b() : null).a();
    }
}
