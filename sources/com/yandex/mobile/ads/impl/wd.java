package com.yandex.mobile.ads.impl;

import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class wd implements u00.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f10556a = "com.google.android.gms.org.conscrypt";

    wd() {
    }

    @Override // com.yandex.mobile.ads.impl.u00.a
    public final boolean a(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        String name = sslSocket.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.startsWith$default(name, this.f10556a + ".", false, 2, (Object) null);
    }

    @Override // com.yandex.mobile.ads.impl.u00.a
    public final xd b(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i = xd.g;
        return xd.a.b(sslSocket.getClass());
    }
}
