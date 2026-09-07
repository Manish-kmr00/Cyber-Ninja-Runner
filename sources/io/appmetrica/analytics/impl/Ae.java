package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* JADX INFO: loaded from: classes13.dex */
public final class Ae implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f11059a;
    public final /* synthetic */ De b;

    public Ae(De de, PluginErrorDetails pluginErrorDetails) {
        this.b = de;
        this.f11059a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Ya) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f11059a);
    }
}
