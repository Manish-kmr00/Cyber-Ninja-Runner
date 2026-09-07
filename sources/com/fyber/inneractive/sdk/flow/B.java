package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.bidder.adm.AdmParametersOuterClass$AdmParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.k0;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.bidder.adm.y f1773a;
    public final /* synthetic */ com.fyber.inneractive.sdk.config.global.r b;
    public final /* synthetic */ String c;
    public final /* synthetic */ F d;

    public B(F f, com.fyber.inneractive.sdk.bidder.adm.y yVar, com.fyber.inneractive.sdk.config.global.r rVar, String str) {
        this.d = f;
        this.f1773a = yVar;
        this.b = rVar;
        this.c = str;
    }

    public final void a() {
        com.fyber.inneractive.sdk.config.global.b bVar;
        com.fyber.inneractive.sdk.config.global.k kVar;
        com.fyber.inneractive.sdk.config.global.l lVar;
        F f = this.d;
        f.getClass();
        IAlog.a("%s : InneractiveAdSpotImpl markup data available", IAlog.a(f));
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.f1773a.f1627a;
        if (admParametersOuterClass$AdmParameters != null) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.b;
            List<AdmParametersOuterClass$AdmParameters.Experiment> abExperimentsList = admParametersOuterClass$AdmParameters.getAbExperimentsList();
            rVar.getClass();
            com.fyber.inneractive.sdk.config.global.a aVar = IAConfigManager.O.z;
            aVar.getClass();
            for (com.fyber.inneractive.sdk.config.global.features.h hVar : rVar.b.values()) {
                if (hVar != null && (lVar = aVar.f1695a) != null) {
                    com.fyber.inneractive.sdk.config.global.q qVar = (com.fyber.inneractive.sdk.config.global.q) lVar.f1704a.get(hVar.b);
                    if (qVar != null) {
                        hVar.f1706a = qVar.f1706a;
                    }
                }
            }
            if (abExperimentsList == null || abExperimentsList.size() <= 0) {
                return;
            }
            com.fyber.inneractive.sdk.config.global.a aVar2 = IAConfigManager.O.z;
            aVar2.b = rVar;
            for (com.fyber.inneractive.sdk.config.global.features.h hVar2 : rVar.b.values()) {
                for (AdmParametersOuterClass$AdmParameters.Experiment experiment : abExperimentsList) {
                    String identifier = experiment.getIdentifier();
                    String variant = experiment.getVariant();
                    com.fyber.inneractive.sdk.config.global.l lVar2 = aVar2.f1695a;
                    if (lVar2 != null) {
                        com.fyber.inneractive.sdk.config.global.q qVar2 = (com.fyber.inneractive.sdk.config.global.q) lVar2.f1704a.get(hVar2.b);
                        if (qVar2 != null && (bVar = (com.fyber.inneractive.sdk.config.global.b) qVar2.c.get(identifier)) != null) {
                            Iterator it = bVar.c.iterator();
                            do {
                                if (!it.hasNext()) {
                                    kVar = null;
                                    break;
                                }
                                kVar = (com.fyber.inneractive.sdk.config.global.k) it.next();
                            } while (!kVar.b.equals(variant));
                            hVar2.c.put(bVar.f1696a, bVar);
                            if (kVar != null) {
                                hVar2.d.put(bVar.f1696a, kVar);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(Exception exc, InneractiveErrorCode inneractiveErrorCode, com.fyber.inneractive.sdk.response.e... eVarArr) {
        EnumC3143t enumC3143t;
        F f = this.d;
        f.getClass();
        IAlog.a("%s : InneractiveAdSpotImpl data error", IAlog.a(f));
        com.fyber.inneractive.sdk.response.e eVar = eVarArr.length > 0 ? eVarArr[0] : null;
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, EnumC3104i.ADM_FETCH_FAILED);
        D d = this.d.d;
        if (d != null) {
            d.a(null, eVar, inneractiveInfrastructureError);
        }
        C3111p c3111p = this.d.l;
        if (c3111p != null) {
            IAlog.e("%sgot handleFailedLoading! with: %s", c3111p.d(), inneractiveInfrastructureError);
            InterfaceC3109n interfaceC3109n = c3111p.b;
            if (interfaceC3109n != null) {
                ((D) interfaceC3109n).a(null, eVar, inneractiveInfrastructureError);
            }
            c3111p.a(null, eVar);
        }
        F f2 = this.d;
        String str = this.c;
        com.fyber.inneractive.sdk.config.global.r rVar = this.b;
        f2.getClass();
        if (!inneractiveErrorCode.equals(InneractiveErrorCode.CONNECTION_ERROR) && !inneractiveErrorCode.equals(InneractiveErrorCode.NO_FILL)) {
            enumC3143t = EnumC3143t.FATAL_ADM_PARSING_ERROR;
        } else {
            enumC3143t = EnumC3143t.FATAL_ADM_MARKUP_FETCHING_ERROR;
        }
        if (eVar != null) {
            eVar.D = false;
        }
        String name = exc.getClass().getName();
        if (exc instanceof k0) {
            name = "NetworkStackException";
        }
        JSONArray jSONArrayB = rVar.b();
        C3146w c3146w = new C3146w(eVar);
        c3146w.b = enumC3143t;
        c3146w.f1934a = null;
        c3146w.d = jSONArrayB;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exception", name);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "exception", name);
        }
        String localizedMessage = exc.getLocalizedMessage();
        Exception localizedMessage2 = exc;
        if (localizedMessage != null) {
            localizedMessage2 = exc.getLocalizedMessage();
        }
        try {
            jSONObject.put("message", localizedMessage2);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", "message", localizedMessage2);
        }
        try {
            jSONObject.put("admPayload", str);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "admPayload", str);
        }
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
    }
}
