package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.network.EnumC3143t;

/* JADX INFO: loaded from: classes13.dex */
public final class P implements com.digitalturbine.ignite.authenticator.listeners.internal.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2392a;
    public final /* synthetic */ String b;
    public final /* synthetic */ W c;

    public P(W w, String str, String str2) {
        this.c = w;
        this.f2392a = str;
        this.b = str2;
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.internal.a
    public final void a() {
        W w = this.c;
        w.b.a(w.c, new com.fyber.inneractive.sdk.ignite.g(w.f, w.d, w.h.f1833a));
        this.c.d("onShowInstallStarted();");
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.internal.a
    public final void a(String str) {
        W w = this.c;
        w.b.m();
        w.d("onInstallationFailed();");
        W w2 = this.c;
        w2.h.a(EnumC3143t.IGNITE_FLOW_FAILED_TO_INSTALL_APP, this.f2392a, this.b, w2.d);
    }
}
