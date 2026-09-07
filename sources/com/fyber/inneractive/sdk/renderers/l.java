package com.fyber.inneractive.sdk.renderers;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements com.fyber.inneractive.sdk.player.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f2313a;

    public l(o oVar) {
        this.f2313a = oVar;
    }

    @Override // com.fyber.inneractive.sdk.player.e
    public final void a() {
        com.fyber.inneractive.sdk.player.controller.s sVar = this.f2313a.m;
        if (sVar != null) {
            sVar.b(false);
            this.f2313a.m.t();
        }
    }
}
