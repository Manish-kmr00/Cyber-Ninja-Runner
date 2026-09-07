package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class D0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHandlerExecutor f11096a = C4455t4.i().e().a();
    public final C4377q0 b;
    public final Fe c;
    public final Ie d;

    public D0() {
        C4377q0 c4377q0 = new C4377q0();
        this.b = c4377q0;
        this.c = new Fe(c4377q0);
        this.d = new Ie();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        Fe fe = this.c;
        fe.f11141a.a(null);
        fe.b.a(pluginErrorDetails);
        Ie ie = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        ie.getClass();
        this.f11096a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.D0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                D0.a(this.f$0, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        Fe fe = this.c;
        fe.f11141a.a(null);
        fe.b.a(pluginErrorDetails);
        if (fe.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f11273a) {
            Ie ie = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            ie.getClass();
            this.f11096a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.D0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    D0.a(this.f$0, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        Fe fe = this.c;
        fe.f11141a.a(null);
        fe.c.a(str);
        Ie ie = this.d;
        Intrinsics.checkNotNull(str);
        ie.getClass();
        this.f11096a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.D0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                D0.a(this.f$0, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(D0 d0, PluginErrorDetails pluginErrorDetails, String str) {
        d0.b.getClass();
        C4352p0 c4352p0 = C4352p0.e;
        Intrinsics.checkNotNull(c4352p0);
        C4364pc c4364pcI = c4352p0.f().i();
        Intrinsics.checkNotNull(c4364pcI);
        c4364pcI.f11720a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(D0 d0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        d0.b.getClass();
        C4352p0 c4352p0 = C4352p0.e;
        Intrinsics.checkNotNull(c4352p0);
        C4364pc c4364pcI = c4352p0.f().i();
        Intrinsics.checkNotNull(c4364pcI);
        c4364pcI.f11720a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(D0 d0, PluginErrorDetails pluginErrorDetails) {
        d0.b.getClass();
        C4352p0 c4352p0 = C4352p0.e;
        Intrinsics.checkNotNull(c4352p0);
        C4364pc c4364pcI = c4352p0.f().i();
        Intrinsics.checkNotNull(c4364pcI);
        c4364pcI.f11720a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
