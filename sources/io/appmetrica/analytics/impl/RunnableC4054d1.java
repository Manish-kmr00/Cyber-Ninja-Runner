package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ExternalAttribution;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.d1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class RunnableC4054d1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExternalAttribution f11505a;
    public final /* synthetic */ C4278m1 b;

    public RunnableC4054d1(C4278m1 c4278m1, ExternalAttribution externalAttribution) {
        this.b = c4278m1;
        this.f11505a = externalAttribution;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).a(this.f11505a);
    }
}
