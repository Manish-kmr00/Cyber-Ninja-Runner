package com.yandex.mobile.ads.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8351a;

    public a11(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f8351a = applicationContext;
    }

    public final z01 a(SSLSocketFactory sSLSocketFactory) {
        Context context = this.f8351a;
        return new z01(context, sSLSocketFactory, new c(context, sSLSocketFactory), new mn1(), d.b(context), new uc1(), new hi0());
    }
}
