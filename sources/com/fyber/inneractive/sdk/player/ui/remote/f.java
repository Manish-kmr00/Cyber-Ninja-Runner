package com.fyber.inneractive.sdk.player.ui.remote;

import com.fyber.inneractive.sdk.ignite.m;
import com.fyber.inneractive.sdk.player.ui.o;
import com.fyber.inneractive.sdk.player.ui.t;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements com.fyber.inneractive.sdk.web.remoteui.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f2245a;
    public boolean h;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean i = false;
    public boolean j = false;
    public m k = m.NONE;
    public String l = "";

    public f(o oVar) {
        this.f2245a = null;
        this.h = false;
        this.f2245a = oVar;
        this.h = oVar.J;
    }

    @Override // com.fyber.inneractive.sdk.web.remoteui.a
    public final void a(com.fyber.inneractive.sdk.network.events.b bVar, String str, boolean z, HashMap map) {
        t tVar = this.f2245a;
        if (tVar == null) {
            IAlog.a("%s: showFallback: fallback won't be displayed because it is null", "RemoteUiFallbackHandler");
            return;
        }
        tVar.g(this.b);
        this.f2245a.d(this.i);
        this.f2245a.f(this.f);
        this.f2245a.a(this.e, this.k);
        this.f2245a.c(this.h);
        this.f2245a.a(this.j, this.l);
        this.f2245a.b(this.g);
        this.f2245a.e(this.c);
        this.f2245a.a(this.d);
    }
}
