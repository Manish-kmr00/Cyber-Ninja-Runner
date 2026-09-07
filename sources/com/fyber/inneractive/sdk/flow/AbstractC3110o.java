package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.AbstractC3137m;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3110o implements com.fyber.inneractive.sdk.interfaces.a, com.fyber.inneractive.sdk.interfaces.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.interfaces.c f1805a;
    public InterfaceC3109n b;
    public com.fyber.inneractive.sdk.config.global.r c;
    public AbstractC3137m d;
    public final String e;
    public boolean f = false;

    public AbstractC3110o(String str) {
        this.e = str;
    }

    public void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
    }

    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        if (IAlog.f2345a <= 3) {
            Thread.dumpStack();
        }
        IAlog.e("%sgot onAdRequestFailed! with: %s", d(), inneractiveInfrastructureError.getErrorCode());
        if (this.b != null) {
            if (eVar != null && eVar.i != null) {
                inneractiveInfrastructureError.setCause(new Exception(eVar.i + ": " + eVar.j));
            }
            ((D) this.b).a(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
        }
    }

    public void b(InneractiveAdRequest inneractiveAdRequest) {
    }

    public final com.fyber.inneractive.sdk.response.e c() {
        com.fyber.inneractive.sdk.interfaces.c cVar = this.f1805a;
        if (cVar == null) {
            return null;
        }
        AbstractC3106k abstractC3106k = (AbstractC3106k) cVar;
        if (abstractC3106k.c != null) {
            return abstractC3106k.c.c();
        }
        return null;
    }

    public String d() {
        return IAlog.a(this);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.a
    public void a(InneractiveAdRequest inneractiveAdRequest) {
        com.fyber.inneractive.sdk.response.e eVar;
        Q q;
        IAlog.e("%sgot onAdLoaded!", d());
        com.fyber.inneractive.sdk.interfaces.c cVar = this.f1805a;
        if (cVar != null) {
            InterfaceC3109n interfaceC3109n = this.b;
            if (interfaceC3109n != null) {
                x xVar = ((AbstractC3106k) cVar).c;
                D d = (D) interfaceC3109n;
                F f = d.f1775a;
                if (!f.j && (q = f.f) != null && q.supportsRefresh()) {
                    if (d.f1775a.f.canRefreshAd()) {
                        F f2 = d.f1775a;
                        f2.e = xVar;
                        xVar.f1840a = inneractiveAdRequest;
                        E e = f2.i;
                        if (e != null) {
                            e.onAdRefreshed(f2);
                        } else {
                            Q q2 = f2.f;
                            if (q2 instanceof InneractiveAdViewUnitController) {
                                ((InneractiveAdViewUnitController) q2).onAdRefreshed(f2);
                            }
                        }
                    } else {
                        F f3 = d.f1775a;
                        f3.getClass();
                        IAlog.a("%sad loaded successfully, but the selected unit controller has rejected the refresh!", IAlog.a(f3));
                        F f4 = d.f1775a;
                        f4.i.onAdRefreshFailed(f4, InneractiveErrorCode.CANCELLED);
                    }
                } else {
                    F f5 = d.f1775a;
                    f5.e = xVar;
                    xVar.f1840a = inneractiveAdRequest;
                    Iterator it = f5.g.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Q q3 = (Q) it.next();
                            if (q3.supports(f5)) {
                                f5.f = q3;
                                F f6 = d.f1775a;
                                InneractiveAdSpot.RequestListener requestListener = f6.b;
                                if (requestListener != null) {
                                    requestListener.onInneractiveSuccessfulAdRequest(f6);
                                }
                                d.f1775a.j = false;
                            }
                        } else {
                            F f7 = d.f1775a;
                            f7.getClass();
                            IAlog.a("%sCannot find appropriate unit controller for unit: %s", IAlog.a(f7), d.f1775a.e.d);
                            C3108m c3108m = d.f1775a.h;
                            d.a(inneractiveAdRequest, c3108m != null ? c3108m.c() : null, new InneractiveInfrastructureError(InneractiveErrorCode.INVALID_INPUT, EnumC3104i.COULD_NOT_SELECT_UNIT_CONTROLLER, new Exception("Cannot find appropriate unit controller for unit: " + d.f1775a.e.d)));
                            F f8 = d.f1775a;
                            f8.e = null;
                            f8.j = false;
                        }
                    }
                }
                String str = d.f1775a.f1776a;
                com.fyber.inneractive.sdk.metrics.d dVar = com.fyber.inneractive.sdk.metrics.d.d;
                dVar.a(str).e();
                dVar.a(str).b();
                F f9 = d.f1775a;
                x xVar2 = f9.e;
                if (xVar2 != null && (eVar = xVar2.b) != null && eVar.p != null) {
                    x xVar3 = f9.e;
                    com.fyber.inneractive.sdk.response.e eVar2 = xVar3.b;
                    new com.fyber.inneractive.sdk.metrics.c(eVar2, f9.c, f9.f1776a, eVar2.p, xVar3.c.b()).a();
                }
            }
            this.f1805a = null;
        }
        b(inneractiveAdRequest);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.a
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        x xVar;
        IAlog.e("%sgot onFailedLoading! with: %s", d(), inneractiveInfrastructureError);
        com.fyber.inneractive.sdk.interfaces.c cVar = this.f1805a;
        InneractiveAdRequest inneractiveAdRequest = (cVar == null || (xVar = ((AbstractC3106k) cVar).c) == null) ? null : xVar.f1840a;
        com.fyber.inneractive.sdk.response.e eVarC = c();
        IAlog.e("%sgot handleFailedLoading! with: %s", d(), inneractiveInfrastructureError);
        InterfaceC3109n interfaceC3109n = this.b;
        if (interfaceC3109n != null) {
            ((D) interfaceC3109n).a(inneractiveAdRequest, eVarC, inneractiveInfrastructureError);
        }
        a(inneractiveAdRequest, eVarC);
    }

    public void a(boolean z) {
        this.f = true;
        com.fyber.inneractive.sdk.interfaces.c cVar = this.f1805a;
        if (cVar == null || !z) {
            return;
        }
        cVar.cancel();
        this.f1805a = null;
    }
}
