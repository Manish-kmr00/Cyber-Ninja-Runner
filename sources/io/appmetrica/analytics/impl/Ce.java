package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* JADX INFO: loaded from: classes13.dex */
public final class Ce implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11089a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ De d;

    public Ce(De de, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = de;
        this.f11089a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Ya) this.d.d.get()).getPluginExtension().reportError(this.f11089a, this.b, this.c);
    }
}
