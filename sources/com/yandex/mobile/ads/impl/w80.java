package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w80 extends zj<String> {
    private final ha0 K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w80(Context context, o3 adConfiguration, String url, String query, bk requestListener, bk listener, ha0 ha0Var, lx1 sessionStorage, yc1 networkResponseParserCreator, d8 adRequestReporter) {
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
        this.K = ha0Var;
    }

    @Override // com.yandex.mobile.ads.impl.zj, com.yandex.mobile.ads.impl.np1
    public final Map<String, String> e() {
        Map<String, String> mapE = super.e();
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        if (this.K != null) {
            mapCreateMapBuilder.put(sh0.M.a(), this.K.a());
        }
        mapCreateMapBuilder.putAll(mapE);
        return MapsKt.build(mapCreateMapBuilder);
    }
}
