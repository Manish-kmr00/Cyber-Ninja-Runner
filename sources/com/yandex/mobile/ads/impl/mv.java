package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class mv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9671a;

    public mv(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f9671a = applicationContext;
    }

    public final boolean a() {
        return (this.f9671a.getResources().getConfiguration().uiMode & 48) == 32;
    }
}
