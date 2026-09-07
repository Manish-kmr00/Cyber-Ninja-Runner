package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
public final class Mf extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Rf f11259a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mf(Rf rf) {
        super(0);
        this.f11259a = rf;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new Lf(this.f11259a);
    }
}
