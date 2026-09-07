package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.config.AbstractC3071a;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.flow.T;
import com.fyber.inneractive.sdk.player.controller.InterfaceC3151b;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends v {
    public a(com.fyber.inneractive.sdk.player.t tVar) {
        super(tVar);
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final void a(com.fyber.inneractive.sdk.player.e eVar) {
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final void b() {
        this.c.getClass();
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final com.fyber.inneractive.sdk.player.ui.m a(Context context, com.fyber.inneractive.sdk.config.global.r rVar) {
        com.fyber.inneractive.sdk.player.ui.i iVar = this.b;
        return iVar == null ? new com.fyber.inneractive.sdk.player.ui.i(context, new com.fyber.inneractive.sdk.player.ui.h(), this.c, rVar, a()) : iVar;
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final InterfaceC3151b a(InneractiveAdSpot inneractiveAdSpot, S s) {
        if (this.f2319a == null) {
            Object selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
            boolean zIsOverlayOutside = selectedUnitController instanceof T ? ((T) selectedUnitController).isOverlayOutside() : false;
            this.f2319a = new com.fyber.inneractive.sdk.player.controller.s(this.c, (com.fyber.inneractive.sdk.player.ui.i) ((com.fyber.inneractive.sdk.player.ui.o) this.b), AbstractC3071a.a(inneractiveAdSpot.getAdContent().c().o), s.c, zIsOverlayOutside, a());
        }
        return this.f2319a;
    }
}
