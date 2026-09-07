package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.config.AbstractC3071a;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.AbstractC3096a;
import com.fyber.inneractive.sdk.flow.AbstractC3106k;
import com.fyber.inneractive.sdk.flow.AbstractC3110o;
import com.fyber.inneractive.sdk.flow.C3101f;
import com.fyber.inneractive.sdk.flow.EnumC3104i;
import com.fyber.inneractive.sdk.flow.InterfaceC3109n;
import com.fyber.inneractive.sdk.flow.RunnableC3100e;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractC3137m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC3110o f1926a;
    public volatile boolean b = false;
    public final com.fyber.inneractive.sdk.config.global.r c;
    public final String d;

    public AbstractC3137m(com.fyber.inneractive.sdk.config.global.r rVar, String str, AbstractC3110o abstractC3110o) {
        this.f1926a = abstractC3110o;
        this.c = rVar;
        this.d = str;
    }

    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        AbstractC3110o abstractC3110o;
        if (this.f1926a == null) {
            return;
        }
        if (this.b) {
            IAlog.e("IARemoteAdFetcher: ignoring response. Previous request was cancelled", new Object[0]);
            return;
        }
        com.fyber.inneractive.sdk.config.T tA = AbstractC3071a.a(eVar.o);
        if (inneractiveAdRequest != null) {
            inneractiveAdRequest.setSelectedUnitConfig(tA);
        }
        com.fyber.inneractive.sdk.config.global.e eVar2 = new com.fyber.inneractive.sdk.config.global.e();
        ImpressionData impressionData = eVar.t;
        eVar2.f1698a = impressionData != null ? impressionData.getDemandId() : null;
        try {
            eVar2.b = Long.valueOf(IAConfigManager.O.d);
        } catch (NumberFormatException unused) {
            IAlog.a("invalid publisherId", new Object[0]);
        }
        this.c.a(eVar2);
        InneractiveErrorCode inneractiveErrorCodeA = tA == null ? InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH : eVar.a(inneractiveAdRequest, this.c);
        if (inneractiveErrorCodeA == null) {
            AbstractC3110o abstractC3110o2 = this.f1926a;
            if (abstractC3110o2.f) {
                IAlog.e("IAAdSourceBase: load cancelled: ignoring response. Previous load request was cancelled", new Object[0]);
                return;
            }
            com.fyber.inneractive.sdk.config.global.r rVar = abstractC3110o2.c;
            IAlog.e("%sonAdDataAvailable: got response data: %s", abstractC3110o2.d(), eVar);
            if (eVar.a()) {
                com.fyber.inneractive.sdk.ignite.h hVar = IAConfigManager.O.E;
                if (hVar.f) {
                    hVar.a((com.digitalturbine.ignite.authenticator.listeners.internal.a) null);
                }
            }
            com.fyber.inneractive.sdk.response.a aVarA = com.fyber.inneractive.sdk.response.a.a(eVar.g);
            com.fyber.inneractive.sdk.factories.e eVar3 = (com.fyber.inneractive.sdk.factories.e) com.fyber.inneractive.sdk.factories.d.f1768a.f1769a.get(aVarA);
            com.fyber.inneractive.sdk.interfaces.c cVarA = eVar3 != null ? eVar3.a() : null;
            abstractC3110o2.f1805a = cVarA;
            if (cVarA == null) {
                IAlog.f("%sonAdDataAvailable: Cannot find content handler for ad type: %s", abstractC3110o2.d(), aVarA);
                InterfaceC3109n interfaceC3109n = abstractC3110o2.b;
                if (interfaceC3109n != null) {
                    ((com.fyber.inneractive.sdk.flow.D) interfaceC3109n).a(inneractiveAdRequest, eVar, new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.NO_CONTENT_LOADER_AVAILABLE));
                }
            } else {
                IAlog.e("%sonAdDataAvailable: found response loader: %s", abstractC3110o2.d(), abstractC3110o2.f1805a);
            }
            com.fyber.inneractive.sdk.interfaces.c cVar = abstractC3110o2.f1805a;
            if (cVar != null) {
                ((AbstractC3106k) cVar).a(inneractiveAdRequest, eVar, rVar, abstractC3110o2, abstractC3110o2);
                return;
            } else {
                AbstractC3149z.a("NullPointerException prevented", "mAdContentLoader is null", inneractiveAdRequest, eVar);
                return;
            }
        }
        EnumC3104i enumC3104i = EnumC3104i.CONTENT_ERROR_UNSPECIFIED;
        if (tA == null || inneractiveErrorCodeA == InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH) {
            enumC3104i = EnumC3104i.NO_APP_CONFIG_AVAILABLE;
            IAlog.b("%sGot configuration mismatch!", IAlog.a(this));
            IAConfigManager.a();
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCodeA, enumC3104i);
        Exception exc = eVar.z;
        if (exc != null) {
            inneractiveInfrastructureError.setCause(exc);
        }
        com.fyber.inneractive.sdk.response.a aVarA2 = com.fyber.inneractive.sdk.response.a.a(eVar.g);
        if (aVarA2 != null) {
            Exception exc2 = eVar.z;
            if (exc2 != null) {
                inneractiveInfrastructureError.setCause(exc2);
            }
            com.fyber.inneractive.sdk.util.r.f2374a.execute(new RunnableC3100e(new C3101f(eVar, inneractiveAdRequest, aVarA2 == com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML ? "send_failed_display_creatives" : "send_failed_vast_creatives", this.c.b()), inneractiveInfrastructureError));
        }
        com.fyber.inneractive.sdk.config.global.r rVar2 = this.c;
        if (rVar2 == null) {
            InneractiveAdSpot spot = InneractiveAdSpotManager.get().getSpot(this.d);
            rVar2 = (spot == null || spot.getAdContent() == null) ? null : spot.getAdContent().c;
        }
        AbstractC3096a.a(inneractiveAdRequest, inneractiveInfrastructureError, null, eVar, rVar2 != null ? rVar2.b() : null);
        if (this.b || (abstractC3110o = this.f1926a) == null) {
            return;
        }
        abstractC3110o.a(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
    }

    public String b() {
        return null;
    }

    public void a() {
        this.b = true;
        this.f1926a = null;
    }
}
