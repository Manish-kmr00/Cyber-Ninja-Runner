package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* JADX INFO: loaded from: classes13.dex */
public final class Be implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f11074a;
    public final /* synthetic */ String b;
    public final /* synthetic */ De c;

    public Be(De de, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = de;
        this.f11074a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Ya) this.c.d.get()).getPluginExtension().reportError(this.f11074a, this.b);
    }
}
