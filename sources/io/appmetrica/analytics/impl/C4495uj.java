package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.uj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4495uj implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ModuleEvent f11804a;

    public C4495uj(ModuleEvent moduleEvent) {
        this.f11804a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportEvent(this.f11804a);
    }
}
