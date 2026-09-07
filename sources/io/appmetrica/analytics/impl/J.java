package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class J implements Provider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f11202a;
    public final /* synthetic */ InterfaceC4544wi b;
    public final /* synthetic */ K c;

    public J(K k, Context context, InterfaceC4544wi interfaceC4544wi) {
        this.c = k;
        this.f11202a = context;
        this.b = interfaceC4544wi;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Provider
    public final Object get() {
        return this.c.f11216a.a(this.f11202a, this.b);
    }
}
