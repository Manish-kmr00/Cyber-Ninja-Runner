package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class gl2 implements ie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gd f9016a;

    @Override // com.yandex.mobile.ads.impl.ie
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9016a.a(context);
    }

    public /* synthetic */ gl2() {
        this(new gd());
    }

    public gl2(gd easyIntegrationInitializer) {
        Intrinsics.checkNotNullParameter(easyIntegrationInitializer, "easyIntegrationInitializer");
        this.f9016a = easyIntegrationInitializer;
    }
}
