package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class rs0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ps0 f10135a = new ps0();

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Locale locale = context.getResources().getConfiguration().locale;
        ps0 ps0Var = this.f10135a;
        Intrinsics.checkNotNull(locale);
        ps0Var.getClass();
        return ps0.a(locale);
    }
}
