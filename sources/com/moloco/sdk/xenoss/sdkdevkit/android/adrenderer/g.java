package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f6497a;
    public final e b;
    public final e c;

    public g(s vastOptions, e mraidOptions, e staticOptions) {
        Intrinsics.checkNotNullParameter(vastOptions, "vastOptions");
        Intrinsics.checkNotNullParameter(mraidOptions, "mraidOptions");
        Intrinsics.checkNotNullParameter(staticOptions, "staticOptions");
        this.f6497a = vastOptions;
        this.b = mraidOptions;
        this.c = staticOptions;
    }

    public final e a() {
        return this.b;
    }

    public final e b() {
        return this.c;
    }

    public final s c() {
        return this.f6497a;
    }
}
