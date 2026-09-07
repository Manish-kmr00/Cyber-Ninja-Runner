package com.yandex.mobile.ads.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vu1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xs1 f10510a;

    public vu1(xs1 sslSocketFactoryCreator) {
        Intrinsics.checkNotNullParameter(sslSocketFactoryCreator, "sslSocketFactoryCreator");
        this.f10510a = sslSocketFactoryCreator;
    }

    public final wu1 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strA = zc.a().a();
        SSLSocketFactory sSLSocketFactoryA = this.f10510a.a(context);
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        return new wu1(strA, sSLSocketFactoryA, cu1VarA != null && cu1VarA.y0());
    }
}
