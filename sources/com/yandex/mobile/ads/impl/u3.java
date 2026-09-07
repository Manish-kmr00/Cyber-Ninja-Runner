package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u3 extends zj<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u3(Context context, o3 adConfiguration, String url, String query, bk requestListener, bk listener, lx1 sessionStorage, yc1 networkResponseParserCreator, d8 adRequestReporter) {
        super(context, adConfiguration, url, query, networkResponseParserCreator, requestListener, listener, adRequestReporter, sessionStorage, 1536);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(sessionStorage, "sessionStorage");
        Intrinsics.checkNotNullParameter(networkResponseParserCreator, "networkResponseParserCreator");
        Intrinsics.checkNotNullParameter(adRequestReporter, "adRequestReporter");
    }
}
