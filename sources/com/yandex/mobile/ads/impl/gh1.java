package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class gh1 extends pk<tc1> {
    private static final int x = (int) TimeUnit.SECONDS.toMillis(10);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gh1(Context context, String url, pk.a<tc1> listener) {
        super(context, url, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        a(context);
        r();
        s();
    }

    @Override // com.yandex.mobile.ads.impl.np1
    protected final qq1<tc1> a(tc1 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        qq1<tc1> qq1VarA = qq1.a(response, th0.a(response));
        Intrinsics.checkNotNullExpressionValue(qq1VarA, "success(...)");
        return qq1VarA;
    }

    private final void a(Context context) {
        Integer numH;
        Integer numQ;
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        int iIntValue = (cu1VarA == null || (numQ = cu1VarA.Q()) == null) ? x : numQ.intValue();
        Intrinsics.checkNotNullParameter(context, "context");
        cu1 cu1VarA2 = iw1.a.a().a(context);
        a(new j00(1.0f, iIntValue, (cu1VarA2 == null || (numH = cu1VarA2.H()) == null) ? 0 : numH.intValue()));
    }
}
