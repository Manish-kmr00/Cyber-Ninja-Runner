package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.tj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4470tj implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11784a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public C4470tj(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f11784a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.getPluginExtension().reportError(this.f11784a, this.b, this.c);
    }
}
