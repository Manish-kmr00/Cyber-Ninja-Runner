package com.moloco.sdk.internal.services;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6419a;
    public final String b;
    public final String c;

    public j(String applicationName, String packageName, String version) {
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(version, "version");
        this.f6419a = applicationName;
        this.b = packageName;
        this.c = version;
    }

    public final String a() {
        return this.f6419a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
