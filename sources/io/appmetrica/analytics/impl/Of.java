package io.appmetrica.analytics.impl;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class Of extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Rf f11282a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Of(Rf rf) {
        super(0);
        this.f11282a = rf;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new Nf(this.f11282a);
    }
}
