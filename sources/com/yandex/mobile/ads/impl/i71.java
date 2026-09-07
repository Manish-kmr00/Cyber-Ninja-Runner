package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i71 implements sa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9185a;
    private final w71 b;
    private final s71 c;
    private final iw1 d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i71(Context context, k41 k41Var, s71 s71Var) {
        this(context, k41Var, s71Var, iw1.a.a());
        int i = iw1.l;
    }

    public i71(Context context, k41 nativeAssetsValidator, s71 nativeAdsConfiguration, iw1 sdkSettings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAssetsValidator, "nativeAssetsValidator");
        Intrinsics.checkNotNullParameter(nativeAdsConfiguration, "nativeAdsConfiguration");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        this.f9185a = context;
        this.b = nativeAssetsValidator;
        this.c = nativeAdsConfiguration;
        this.d = sdkSettings;
    }

    @Override // com.yandex.mobile.ads.impl.sa
    public final boolean a() {
        this.c.getClass();
        cu1 cu1VarA = this.d.a(this.f9185a);
        return !(cu1VarA != null && cu1VarA.u0()) || this.b.a(false).b() == f92.a.c;
    }
}
