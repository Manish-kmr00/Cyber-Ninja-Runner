package com.moloco.sdk.acm.eventprocessing;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.services.g f6023a;
    public final long b;

    public f(com.moloco.sdk.acm.services.g timeProviderService, long j) {
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.f6023a = timeProviderService;
        this.b = j;
    }

    public final boolean a(com.moloco.sdk.acm.db.b eventEntity) {
        Intrinsics.checkNotNullParameter(eventEntity, "eventEntity");
        return this.f6023a.invoke() - eventEntity.l() >= this.b * ((long) 1000);
    }
}
