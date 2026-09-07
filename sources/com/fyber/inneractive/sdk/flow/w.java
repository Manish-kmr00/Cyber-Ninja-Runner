package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.W;
import com.fyber.inneractive.sdk.web.X;

/* JADX INFO: loaded from: classes10.dex */
public abstract class w extends x {
    public W g;
    public final C3116v h;

    public w(com.fyber.inneractive.sdk.config.U u, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(u, rVar);
        this.h = new C3116v(this);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void a(String str) {
        com.fyber.inneractive.sdk.ignite.m mVar;
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.ignite.m mVar2 = com.fyber.inneractive.sdk.ignite.m.NONE;
        com.fyber.inneractive.sdk.response.e eVar2 = this.b;
        if (eVar2 != null) {
            com.fyber.inneractive.sdk.ignite.m mVar3 = eVar2.H;
            mVar3.getClass();
            mVar = com.fyber.inneractive.sdk.ignite.m.SINGLE_TAP;
            if (mVar3 != mVar) {
                com.fyber.inneractive.sdk.ignite.m mVar4 = this.b.H;
                mVar4.getClass();
                if (mVar4 != com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP || isVideoAd()) {
                    mVar = this.b.H;
                } else {
                    this.h.a(EnumC3143t.IGNITE_FLOW_MODE_NOT_COMPATIBLE, null, null, null);
                }
            }
        } else {
            mVar = mVar2;
        }
        com.fyber.inneractive.sdk.ignite.h hVar = IAConfigManager.O.E;
        if (!hVar.f || (eVar = this.b) == null || !eVar.a() || !hVar.n()) {
            com.fyber.inneractive.sdk.response.e eVar3 = this.b;
            if (eVar3 != null) {
                eVar3.H = mVar2;
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.response.e eVar4 = this.b;
        String str2 = eVar4 != null ? eVar4.A : null;
        X x = new X();
        x.f2398a = str2;
        x.b = mVar;
        x.c = str;
        x.d = this.c;
        x.e = eVar4 != null ? eVar4.G : null;
        x.f = eVar4 != null ? eVar4.I : null;
        x.g = this.h;
        W w = new W(x);
        this.g = w;
        com.fyber.inneractive.sdk.config.global.features.r rVar = (com.fyber.inneractive.sdk.config.global.features.r) this.c.a(com.fyber.inneractive.sdk.config.global.features.r.class);
        if (rVar == null || str2 == null) {
            return;
        }
        String strA = rVar.a("detail_url", "https://cdn2.inner-active.mobi/app-detail-page-v0/[BUNDLE_ID].html");
        w.e(strA == null ? "" : strA.replace("[BUNDLE_ID]", str2));
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final W b() {
        return this.g;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean e() {
        W w = this.g;
        return w != null && w.l;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void g() {
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.response.e eVar2;
        com.fyber.inneractive.sdk.ignite.h hVar = IAConfigManager.O.E;
        if (!hVar.f || (eVar = this.b) == null || !eVar.a() || !hVar.n() || e() || (eVar2 = this.b) == null) {
            return;
        }
        com.fyber.inneractive.sdk.ignite.m mVar = eVar2.H;
        com.fyber.inneractive.sdk.ignite.m mVar2 = com.fyber.inneractive.sdk.ignite.m.NONE;
        if (mVar != mVar2) {
            IAlog.a("ignite webpage was not loaded yet, stopping the loading process", new Object[0]);
            com.fyber.inneractive.sdk.response.e eVar3 = this.b;
            if (mVar2 == null) {
                eVar3.getClass();
            }
            eVar3.H = mVar2;
            W w = this.g;
            if (w != null) {
                com.fyber.inneractive.sdk.web.N n = w.p;
                if (n != null) {
                    com.fyber.inneractive.sdk.util.r.b.removeCallbacks(n);
                    w.p = null;
                }
                if (!w.y) {
                    w.f2397a.stopLoading();
                }
                this.h.a(EnumC3143t.IGNITE_FLOW_FAILED_TO_LOAD_WEBPAGE, this.g.k, com.fyber.inneractive.sdk.ignite.j.WEBPAGE_NOT_LOADED_BEFORE_SHOW.a(), this.b.H);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean a(boolean z, EnumC3243g enumC3243g) {
        com.fyber.inneractive.sdk.ignite.m mVar;
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        if (eVar != null) {
            mVar = eVar.H;
        } else {
            mVar = com.fyber.inneractive.sdk.ignite.m.NONE;
        }
        return !z && mVar != null && mVar == com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP && (enumC3243g == EnumC3243g.VIDEO_CTA || enumC3243g == EnumC3243g.DEFAULT_ENDCARD);
    }
}
