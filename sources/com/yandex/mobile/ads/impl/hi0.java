package com.yandex.mobile.ads.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hi0 {
    public static mk a(Context context, gi0.b bVar, SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        return (cu1VarA == null || !cu1VarA.y0()) ? new gi0(bVar, sSLSocketFactory) : new ii0(bVar, sSLSocketFactory);
    }
}
