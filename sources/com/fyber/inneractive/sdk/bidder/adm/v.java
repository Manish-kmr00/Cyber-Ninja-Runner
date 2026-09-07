package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.B;
import com.fyber.inneractive.sdk.flow.C3111p;
import com.fyber.inneractive.sdk.flow.D;
import com.fyber.inneractive.sdk.flow.F;
import com.fyber.inneractive.sdk.network.C3140p;
import com.fyber.inneractive.sdk.network.E;
import com.fyber.inneractive.sdk.network.k0;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes12.dex */
public final class v implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1624a;
    public final /* synthetic */ com.fyber.inneractive.sdk.response.e b;
    public final /* synthetic */ y c;

    public v(y yVar, B b, com.fyber.inneractive.sdk.response.e eVar) {
        this.c = yVar;
        this.f1624a = b;
        this.b = eVar;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        com.fyber.inneractive.sdk.response.e eVar = (com.fyber.inneractive.sdk.response.e) obj;
        if (exc != null) {
            com.fyber.inneractive.sdk.metrics.i iVarB = com.fyber.inneractive.sdk.metrics.d.d.b(this.c.d);
            iVarB.f1872a.put(new com.fyber.inneractive.sdk.metrics.h(exc.getMessage()), Long.valueOf(System.currentTimeMillis() - iVarB.c));
            B b = this.f1624a;
            if (b != null) {
                this.c.getClass();
                b.a(exc, ((exc instanceof k0) && ((k0) exc).f1923a == 404) ? InneractiveErrorCode.NO_FILL : InneractiveErrorCode.CONNECTION_ERROR, this.b);
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.metrics.d dVar = com.fyber.inneractive.sdk.metrics.d.d;
        com.fyber.inneractive.sdk.metrics.i iVarB2 = dVar.b(this.c.d);
        iVarB2.f1872a.put(new com.fyber.inneractive.sdk.metrics.h("success"), Long.valueOf(System.currentTimeMillis() - iVarB2.c));
        B b2 = this.f1624a;
        if (b2 != null) {
            F f = b2.d;
            f.getClass();
            IAlog.a("%s : InneractiveAdSpotImpl data available", IAlog.a(f));
            F f2 = b2.d;
            com.fyber.inneractive.sdk.config.global.r rVar = b2.b;
            D d = f2.d;
            C3111p c3111p = f2.l;
            if (c3111p != null) {
                c3111p.b = d;
                dVar.b(f2.f1776a).d = System.currentTimeMillis();
                c3111p.g = eVar;
                if (!IAConfigManager.e()) {
                    IAConfigManager.addListener(c3111p);
                    IAConfigManager.a();
                } else {
                    c3111p.c = rVar;
                    C3140p c3140p = new C3140p(rVar, eVar, f2.f1776a, c3111p);
                    c3111p.d = c3140p;
                    c3140p.c();
                }
            }
        }
    }
}
