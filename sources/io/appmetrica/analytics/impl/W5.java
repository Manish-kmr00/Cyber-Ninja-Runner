package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;

/* JADX INFO: loaded from: classes2.dex */
public final class W5 extends BaseRequestConfig.DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Hl f11402a;
    public final SdkEnvironmentProvider b;

    public W5(Hl hl, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, Object obj) {
        super(new SdkIdentifiers(hl.e(), hl.a(), hl.b()), sdkEnvironmentProvider, platformIdentifiers, obj);
        this.f11402a = hl;
        this.b = sdkEnvironmentProvider;
    }
}
