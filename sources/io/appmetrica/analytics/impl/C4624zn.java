package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.BuildConfig;
import io.appmetrica.analytics.coreutils.internal.network.UserAgent;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.zn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4624zn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11884a = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.7.2", "50130239");

    public final String a() {
        return this.f11884a;
    }
}
