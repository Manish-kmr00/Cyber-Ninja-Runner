package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.W;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public final class S extends w {
    public com.fyber.inneractive.sdk.player.t i;
    public boolean j;

    public S(com.fyber.inneractive.sdk.config.U u, com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.response.g gVar, InneractiveAdRequest inneractiveAdRequest) {
        super(u, rVar);
        this.j = false;
        this.b = gVar;
        this.f1840a = inneractiveAdRequest;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void a() {
        com.fyber.inneractive.sdk.player.n nVar;
        if (this.g != null && d()) {
            W w = this.g;
            w.y = true;
            w.D = false;
            w.b.h.remove(w);
            w.i = null;
            IAlog.a("destroy internalStoreWebpageController", new Object[0]);
            this.g = null;
        }
        com.fyber.inneractive.sdk.player.t tVar = this.i;
        if (tVar != null) {
            com.fyber.inneractive.sdk.player.b bVar = tVar.f2231a;
            if (bVar != null && (nVar = bVar.b) != null) {
                nVar.i = true;
                IAlog.a("IAMediaPlayerFlowManager: destroy", new Object[0]);
                com.fyber.inneractive.sdk.flow.endcard.b bVarA = nVar.t.a();
                if (bVarA != null) {
                    bVarA.destroy();
                }
                com.fyber.inneractive.sdk.player.controller.q qVar = nVar.f2210a;
                if (qVar != null) {
                    qVar.a();
                    nVar.f2210a = null;
                }
                nVar.l = null;
                com.fyber.inneractive.sdk.flow.endcard.i iVar = nVar.t;
                if (iVar != null) {
                    com.fyber.inneractive.sdk.flow.endcard.j jVar = iVar.b;
                    Iterator it = jVar.f1794a.iterator();
                    while (it.hasNext()) {
                        ((com.fyber.inneractive.sdk.flow.endcard.b) it.next()).destroy();
                    }
                    jVar.f1794a.clear();
                    jVar.b.clear();
                    jVar.c = -1;
                }
                com.fyber.inneractive.sdk.player.ui.remote.g gVar = nVar.u;
                if (gVar != null) {
                    gVar.f2246a.a();
                }
                com.fyber.inneractive.sdk.flow.storepromo.b bVar2 = nVar.v;
                if (bVar2 != null) {
                    bVar2.f1808a.a();
                    bVar2.a();
                    bVar2.e = null;
                    bVar2.h.clear();
                }
            }
            this.i = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean d() {
        com.fyber.inneractive.sdk.config.V v = ((com.fyber.inneractive.sdk.config.T) this.d).f;
        if (v == null) {
            return false;
        }
        UnitDisplayType unitDisplayType = v.j;
        return UnitDisplayType.INTERSTITIAL.equals(unitDisplayType) || UnitDisplayType.REWARDED.equals(unitDisplayType) || UnitDisplayType.VERTICAL.equals(unitDisplayType);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean f() {
        return this.i != null;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public boolean isVideoAd() {
        return true;
    }
}
