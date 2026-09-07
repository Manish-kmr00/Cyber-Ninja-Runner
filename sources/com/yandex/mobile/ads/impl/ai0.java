package com.yandex.mobile.ads.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ai0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xs1 f8408a;
    private final a11 b;
    private final Context c;

    public ai0(Context context, ys1 sslSocketFactoryCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sslSocketFactoryCreator, "sslSocketFactoryCreator");
        this.f8408a = sslSocketFactoryCreator;
        this.b = bi0.a(context);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.c = applicationContext;
    }

    public final ci0 a() {
        Integer numE;
        SSLSocketFactory sSLSocketFactoryA = this.f8408a.a(this.c);
        Context context = this.c;
        Intrinsics.checkNotNullParameter(context, "context");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        if (cu1VarA != null && (numE = cu1VarA.E()) != null) {
            numE.intValue();
        }
        return new ci0(this.b.a(sSLSocketFactoryA), zc.a());
    }
}
