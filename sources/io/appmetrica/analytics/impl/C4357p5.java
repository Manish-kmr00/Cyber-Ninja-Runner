package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.p5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4357p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11713a;

    public C4357p5(String str) {
        this.f11713a = str;
    }

    public final PublicLogger a() {
        return LoggerStorage.getOrCreatePublicLogger(this.f11713a);
    }
}
