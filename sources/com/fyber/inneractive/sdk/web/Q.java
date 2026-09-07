package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class Q implements com.digitalturbine.ignite.authenticator.listeners.internal.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ W f2393a;

    public Q(W w) {
        this.f2393a = w;
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.internal.a
    public final void a() {
        IAlog.a("InternalStoreWebpageController: onCancelError: onReconnectSuccess", new Object[0]);
        W w = this.f2393a;
        w.b.a(w.c, new com.fyber.inneractive.sdk.ignite.g(w.f, w.d, w.h.f1833a));
        this.f2393a.d("onShowInstallStarted();");
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.internal.a
    public final void a(String str) {
        IAlog.a("InternalStoreWebpageController: onCancelError: onReconnectFailed: error: %s", str);
    }
}
