package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.AbstractC3137m;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3111p extends AbstractC3110o implements IAConfigManager.OnConfigurationReadyAndValidListener {
    public com.fyber.inneractive.sdk.response.e g;

    public C3111p(String str) {
        super(str);
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3110o, com.fyber.inneractive.sdk.interfaces.a
    public final void a(InneractiveAdRequest inneractiveAdRequest) {
        com.fyber.inneractive.sdk.metrics.i iVarB = com.fyber.inneractive.sdk.metrics.d.d.b(this.e);
        iVarB.b.put(new com.fyber.inneractive.sdk.metrics.h("success"), Long.valueOf(System.currentTimeMillis() - iVarB.d));
        super.a(inneractiveAdRequest);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public final void b() {
        com.fyber.inneractive.sdk.metrics.i iVarB = com.fyber.inneractive.sdk.metrics.d.d.b(this.e);
        iVarB.b.put(new com.fyber.inneractive.sdk.metrics.h("retrying"), Long.valueOf(System.currentTimeMillis() - iVarB.d));
    }

    @Override // com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener
    public final void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        IAConfigManager.removeListener(this);
        if (z) {
            return;
        }
        a(null, c(), new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.NO_APP_CONFIG_AVAILABLE, exc));
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3110o
    public final void b(InneractiveAdRequest inneractiveAdRequest) {
        a(inneractiveAdRequest, this.g);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        com.fyber.inneractive.sdk.metrics.i iVarB = com.fyber.inneractive.sdk.metrics.d.d.b(this.e);
        iVarB.b.put(new com.fyber.inneractive.sdk.metrics.h("dyn_timeout"), Long.valueOf(System.currentTimeMillis() - iVarB.d));
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3110o
    public final void a(boolean z) {
        AbstractC3137m abstractC3137m = this.d;
        if (abstractC3137m != null) {
            abstractC3137m.a();
        }
        super.a(true);
    }

    @Override // com.fyber.inneractive.sdk.flow.AbstractC3110o
    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        String str;
        if (eVar == null || (str = eVar.B) == null) {
            return;
        }
        com.fyber.inneractive.sdk.metrics.i iVarB = com.fyber.inneractive.sdk.metrics.d.d.b(str);
        com.fyber.inneractive.sdk.config.global.r rVarA = this.c;
        if (rVarA == null) {
            rVarA = com.fyber.inneractive.sdk.config.global.r.a();
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayA = com.fyber.inneractive.sdk.metrics.i.a(iVarB.b);
        try {
            jSONObject.put("adl", jSONArrayA);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "adl", jSONArrayA);
        }
        JSONArray jSONArrayA2 = com.fyber.inneractive.sdk.metrics.i.a(iVarB.f1872a);
        try {
            jSONObject.put("adml", jSONArrayA2);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", "adml", jSONArrayA2);
        }
        if (!TextUtils.isEmpty(null)) {
            try {
                jSONObject.put("dns_failed", (Object) null);
            } catch (Exception unused3) {
                IAlog.f("Got exception adding param to json object: %s, %s", "dns_failed", null);
            }
        }
        EnumC3144u enumC3144u = EnumC3144u.SDK_BIDDING_METRICS;
        JSONArray jSONArrayB = rVarA.b();
        C3146w c3146w = new C3146w(eVar);
        c3146w.c = enumC3144u;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArrayB;
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
    }
}
