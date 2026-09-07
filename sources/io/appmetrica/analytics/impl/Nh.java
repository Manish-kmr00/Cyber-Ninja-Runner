package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class Nh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f11270a;
    public final /* synthetic */ Yh b;

    public Nh(Yh yh, ModuleEvent moduleEvent) {
        this.b = yh;
        this.f11270a = moduleEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).reportEvent(this.f11270a);
    }
}
