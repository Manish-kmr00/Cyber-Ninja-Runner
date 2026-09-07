package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.E;
import com.fyber.inneractive.sdk.flow.G;
import com.fyber.inneractive.sdk.flow.P;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements G, P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveUnitController f2436a;
    public x b;
    public boolean d = false;
    public final String c = UUID.randomUUID().toString();

    public k(InneractiveUnitController inneractiveUnitController, x xVar) {
        this.f2436a = inneractiveUnitController;
        this.b = xVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.P
    public final void a(E e) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void addUnitController(InneractiveUnitController inneractiveUnitController) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void destroy() {
        InneractiveUnitController inneractiveUnitController = this.f2436a;
        if (inneractiveUnitController != null) {
            inneractiveUnitController.destroy();
        }
        a();
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final x getAdContent() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveAdRequest getCurrentProcessedRequest() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getLocalUniqueId() {
        return this.c;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveMediationName getMediationName() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getMediationNameString() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getMediationVersion() {
        return "";
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getRequestedSpotId() {
        return "";
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveUnitController getSelectedUnitController() {
        return this.f2436a;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0024  */
    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final boolean isReady() {
        boolean z;
        x xVar = this.b;
        if (xVar == null) {
            return false;
        }
        if (xVar.c() != null) {
            com.fyber.inneractive.sdk.response.e eVarC = this.b.c();
            eVarC.getClass();
            if (eVarC.f2321a < System.currentTimeMillis()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (z) {
            x xVar2 = this.b;
            com.fyber.inneractive.sdk.response.e eVarC2 = xVar2.c();
            if (!this.d && eVarC2 != null && eVarC2.c != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = eVarC2.f2321a;
                if (j < jCurrentTimeMillis) {
                    long minutes = TimeUnit.MILLISECONDS.toMinutes(j - System.currentTimeMillis());
                    long j2 = eVarC2.b;
                    IAlog.a("Firing Event 802 - AdExpired - time passed- " + minutes + ", sessionTimeOut - " + j2, new Object[0]);
                    EnumC3143t enumC3143t = EnumC3143t.IA_AD_EXPIRED;
                    InneractiveAdRequest inneractiveAdRequest = xVar2.f1840a;
                    JSONArray jSONArrayB = xVar2.c.b();
                    C3146w c3146w = new C3146w(eVarC2);
                    c3146w.b = enumC3143t;
                    c3146w.f1934a = inneractiveAdRequest;
                    c3146w.d = jSONArrayB;
                    JSONObject jSONObject = new JSONObject();
                    Long lValueOf = Long.valueOf(minutes);
                    try {
                        jSONObject.put("time_passed", lValueOf);
                    } catch (Exception unused) {
                        IAlog.f("Got exception adding param to json object: %s, %s", "time_passed", lValueOf);
                    }
                    Long lValueOf2 = Long.valueOf(j2);
                    try {
                        jSONObject.put("timeout", lValueOf2);
                    } catch (Exception unused2) {
                        IAlog.f("Got exception adding param to json object: %s, %s", "timeout", lValueOf2);
                    }
                    c3146w.f.put(jSONObject);
                    c3146w.a((String) null);
                    this.d = true;
                }
            }
        }
        return !z;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void loadAd(String str) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void removeUnitController(InneractiveUnitController inneractiveUnitController) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void requestAd(InneractiveAdRequest inneractiveAdRequest) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationName(InneractiveMediationName inneractiveMediationName) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationName(String str) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationVersion(String str) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setRequestListener(InneractiveAdSpot.RequestListener requestListener) {
    }

    @Override // com.fyber.inneractive.sdk.flow.G
    public final void a() {
        x xVar = this.b;
        if (xVar != null) {
            xVar.a();
        }
        this.b = null;
        this.f2436a = null;
        InneractiveAdSpotManager.get().removeSpot(this);
    }
}
