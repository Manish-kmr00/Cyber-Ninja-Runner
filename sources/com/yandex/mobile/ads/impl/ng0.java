package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ng0 implements yc1<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final si2<String> f9729a;

    @Override // com.yandex.mobile.ads.impl.yc1
    public final pi2 a(Context context, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        return sc1.a(adConfiguration, this.f9729a);
    }

    public /* synthetic */ ng0() {
        this(new qg0());
    }

    public ng0(si2<String> responseBodyParser) {
        Intrinsics.checkNotNullParameter(responseBodyParser, "responseBodyParser");
        this.f9729a = responseBodyParser;
    }
}
