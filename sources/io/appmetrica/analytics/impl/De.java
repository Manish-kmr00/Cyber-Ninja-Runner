package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;

/* JADX INFO: loaded from: classes13.dex */
public final class De implements IPluginReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ge f11106a = new Ge();
    public final He b = new He();
    public final IHandlerExecutor c = C4455t4.i().e().a();
    public final Provider d;

    public De(Provider<Ya> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Ge ge = this.f11106a;
        ge.f11162a.a(pluginErrorDetails);
        if (ge.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f11273a) {
            this.b.getClass();
            this.c.execute(new Be(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f11106a.f11162a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new Ae(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f11106a.b.a(str);
        this.b.getClass();
        this.c.execute(new Ce(this, str, str2, pluginErrorDetails));
    }
}
