package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class qj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10023a;
    private final Context b;

    public qj(Context context, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f10023a = adConfiguration;
        this.b = context.getApplicationContext();
    }

    public final pj a(o8<String> adResponse, zy1 configurationSizeInfo) throws lj2 {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(configurationSizeInfo, "configurationSizeInfo");
        try {
            Context appContext = this.b;
            Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
            return new pj(appContext, adResponse, this.f10023a, configurationSizeInfo);
        } catch (Throwable unused) {
            throw new lj2();
        }
    }
}
