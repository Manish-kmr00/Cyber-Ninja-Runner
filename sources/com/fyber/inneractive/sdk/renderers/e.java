package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.flow.T;
import com.fyber.inneractive.sdk.player.controller.InterfaceC3151b;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends v {
    public e(com.fyber.inneractive.sdk.player.t tVar) {
        super(tVar);
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final com.fyber.inneractive.sdk.player.ui.m a(Context context, com.fyber.inneractive.sdk.config.global.r rVar) {
        if (this.b == null) {
            this.b = new com.fyber.inneractive.sdk.player.ui.i(context, new com.fyber.inneractive.sdk.player.ui.f(), this.c, rVar, a());
        }
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final void b() {
        this.c.getClass();
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final InterfaceC3151b a(InneractiveAdSpot inneractiveAdSpot, S s) {
        if (this.f2319a == null) {
            Object selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
            this.f2319a = new com.fyber.inneractive.sdk.player.controller.g(this.c, this.b, inneractiveAdSpot.getAdContent().d, s.c, selectedUnitController instanceof T ? ((T) selectedUnitController).isOverlayOutside() : false, IAConfigManager.O.k || s.f, a());
        }
        return this.f2319a;
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final void a(com.fyber.inneractive.sdk.player.e eVar) {
        this.c.getClass();
        eVar.a();
    }
}
