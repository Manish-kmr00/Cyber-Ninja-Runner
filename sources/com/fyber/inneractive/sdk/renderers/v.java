package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.S;
import com.fyber.inneractive.sdk.player.controller.InterfaceC3151b;
import com.fyber.inneractive.sdk.player.controller.z;

/* JADX INFO: loaded from: classes11.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f2319a;
    public com.fyber.inneractive.sdk.player.ui.i b;
    public final com.fyber.inneractive.sdk.player.n c;

    public v(com.fyber.inneractive.sdk.player.t tVar) {
        this.c = (com.fyber.inneractive.sdk.player.n) tVar.f;
    }

    public abstract InterfaceC3151b a(InneractiveAdSpot inneractiveAdSpot, S s);

    public abstract com.fyber.inneractive.sdk.player.ui.m a(Context context, com.fyber.inneractive.sdk.config.global.r rVar);

    public final String a() {
        S s;
        com.fyber.inneractive.sdk.player.n nVar = this.c;
        com.fyber.inneractive.sdk.response.e eVar = (nVar == null || (s = nVar.b) == null) ? null : s.b;
        if (eVar != null) {
            return eVar.F;
        }
        return null;
    }

    public abstract void a(com.fyber.inneractive.sdk.player.e eVar);

    public abstract void b();
}
