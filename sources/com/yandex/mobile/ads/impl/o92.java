package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o92 extends b62<z92, r92> {
    private final u92 C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o92(Context context, o3 adConfiguration, String url, ri2 listener, z92 configuration, da2 requestReporter, u92 vastDataResponseParser) {
        super(context, adConfiguration, 0, url, listener, configuration, requestReporter, null, 1920);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(requestReporter, "requestReporter");
        Intrinsics.checkNotNullParameter(vastDataResponseParser, "vastDataResponseParser");
        this.C = vastDataResponseParser;
        op0.e(url);
    }

    @Override // com.yandex.mobile.ads.impl.b62
    public final qq1<r92> a(tc1 networkResponse, int i) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        r92 r92VarA = this.C.a(networkResponse);
        if (r92VarA == null) {
            qq1<r92> qq1VarA = qq1.a(new yf1("Can't parse VAST response."));
            Intrinsics.checkNotNullExpressionValue(qq1VarA, "error(...)");
            return qq1VarA;
        }
        if (r92VarA.b().b().isEmpty()) {
            qq1<r92> qq1VarA2 = qq1.a(new d50());
            Intrinsics.checkNotNull(qq1VarA2);
            return qq1VarA2;
        }
        qq1<r92> qq1VarA3 = qq1.a(r92VarA, null);
        Intrinsics.checkNotNull(qq1VarA3);
        return qq1VarA3;
    }
}
