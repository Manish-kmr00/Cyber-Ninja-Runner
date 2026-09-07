package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes10.dex */
public final class D implements InterfaceC3109n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ F f1775a;

    public D(F f) {
        this.f1775a = f;
    }

    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        com.fyber.inneractive.sdk.config.global.r rVar;
        if (this.f1775a.b != null) {
            if (inneractiveInfrastructureError.getErrorCode().shouldSendTimeMetric()) {
                this.f1775a.a(inneractiveAdRequest, eVar);
            }
            F f = this.f1775a;
            if (!f.j) {
                E e = f.i;
                if (e != null) {
                    e.onAdRefreshFailed(f, inneractiveInfrastructureError.getErrorCode());
                    return;
                }
                return;
            }
            C3108m c3108m = f.h;
            C3111p c3111p = f.l;
            JSONArray jSONArrayB = null;
            com.fyber.inneractive.sdk.config.global.r rVar2 = c3111p != null ? c3111p.c : null;
            if (c3108m != null && (rVar = c3108m.c) != null) {
                jSONArrayB = rVar.b();
            } else if (rVar2 != null) {
                jSONArrayB = rVar2.b();
            }
            AbstractC3096a.a(inneractiveAdRequest, inneractiveInfrastructureError, f.e, eVar, jSONArrayB);
            F f2 = this.f1775a;
            InneractiveAdSpot.RequestListener requestListener = f2.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(f2, inneractiveInfrastructureError.getErrorCode());
            }
        }
    }
}
