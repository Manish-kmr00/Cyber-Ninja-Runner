package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8748a;
    private final o3 b;
    private final o8<?> c;

    public final f70 a() {
        return new n60(this.f8748a, this.c, this.b).a();
    }

    public e00(Context context, o8 adResponse, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f8748a = context;
        this.b = adConfiguration;
        this.c = adResponse;
    }
}
