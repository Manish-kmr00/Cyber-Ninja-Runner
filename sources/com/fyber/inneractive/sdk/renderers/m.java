package com.fyber.inneractive.sdk.renderers;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f2314a;

    public m(o oVar) {
        this.f2314a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o oVar = this.f2314a;
        if (oVar.t != null) {
            oVar.getClass();
            IAlog.a("%sIdle state reached!", IAlog.a(oVar));
            com.fyber.inneractive.sdk.player.controller.s sVar = this.f2314a.m;
            if (sVar != null) {
                sVar.h(true);
            }
            this.f2314a.t = null;
        }
    }
}
