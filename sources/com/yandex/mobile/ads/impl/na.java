package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class na implements i82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h50 f9711a = new h50();

    @Override // com.yandex.mobile.ads.impl.i82
    public final String a(Context context, o3 adConfiguration, dx1 sensitiveModeChecker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        return this.f9711a.a(context, new cb0(cb0.b.a(context, adConfiguration, sensitiveModeChecker), 0).toString());
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
        return i82.a.b;
    }
}
