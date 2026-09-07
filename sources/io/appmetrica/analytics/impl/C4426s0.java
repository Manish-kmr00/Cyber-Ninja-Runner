package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4426s0 implements Cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4451t0 f11757a;
    public final /* synthetic */ AppMetricaConfig b;
    public final /* synthetic */ PublicLogger c;

    public C4426s0(C4451t0 c4451t0, AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f11757a = c4451t0;
        this.b = appMetricaConfig;
        this.c = publicLogger;
    }

    @Override // io.appmetrica.analytics.impl.Cc
    public final C4314nc a() {
        C4451t0 c4451t0 = this.f11757a;
        return c4451t0.g.a(this.b, this.c, c4451t0.i.g);
    }
}
