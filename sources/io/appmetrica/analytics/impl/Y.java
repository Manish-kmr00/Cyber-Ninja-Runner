package io.appmetrica.analytics.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class Y implements Zm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Z f11425a;

    public Y(Z z) {
        this.f11425a = z;
    }

    @Override // io.appmetrica.analytics.impl.Zm
    public final Thread a() {
        return this.f11425a.b;
    }

    @Override // io.appmetrica.analytics.impl.Zm
    public final StackTraceElement[] b() {
        Z z = this.f11425a;
        return (StackTraceElement[]) z.f11442a.get(z.b);
    }

    @Override // io.appmetrica.analytics.impl.Zm
    public final Map<Thread, StackTraceElement[]> c() {
        return this.f11425a.f11442a;
    }
}
