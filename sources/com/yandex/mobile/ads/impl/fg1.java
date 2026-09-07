package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class fg1 implements i82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gg1 f8892a;
    private final h50 b;

    public fg1(gg1 passbackUrlParametersProvider) {
        Intrinsics.checkNotNullParameter(passbackUrlParametersProvider, "passbackUrlParametersProvider");
        this.f8892a = passbackUrlParametersProvider;
        this.b = new h50();
    }

    @Override // com.yandex.mobile.ads.impl.i82
    public final String a(Context context, o3 adConfiguration, dx1 sensitiveModeChecker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        return this.b.a(context, new cb0(cb0.b.a(context, adConfiguration, sensitiveModeChecker).b(this.f8892a.a()), 0).toString());
    }

    @Override // com.yandex.mobile.ads.impl.i82
    public final String a(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        String strA = adConfiguration.k().a();
        if (strA == null || strA.length() <= 0) {
            return null;
        }
        return Uri.parse(strA).buildUpon().appendEncodedPath("v4/ad").build().toString();
    }

    @Override // com.yandex.mobile.ads.impl.i82
    public final i82.a a() {
        return i82.a.c;
    }
}
