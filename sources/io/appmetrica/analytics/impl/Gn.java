package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class Gn implements Ml {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UtilityServiceProvider f11168a;

    public Gn(UtilityServiceProvider utilityServiceProvider) {
        this.f11168a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.Ml
    public final void a(Hl hl) {
        this.f11168a.updateConfiguration(new UtilityServiceConfiguration(hl.v, hl.u));
    }
}
