package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class la2 extends b62<eb2, List<? extends eb2>> {
    private final u92 C;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public la2(Context context, o3 adConfiguration, String url, ri2 listener, eb2 wrapper, rk2 requestReporter, u92 vastDataResponseParser) {
        super(context, adConfiguration, 0, url, listener, wrapper, requestReporter, null, 1920);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        Intrinsics.checkNotNullParameter(requestReporter, "requestReporter");
        Intrinsics.checkNotNullParameter(vastDataResponseParser, "vastDataResponseParser");
        this.C = vastDataResponseParser;
    }

    @Override // com.yandex.mobile.ads.impl.b62
    public final qq1<List<? extends eb2>> a(tc1 networkResponse, int i) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        r92 r92VarA = this.C.a(networkResponse);
        if (r92VarA == null) {
            qq1<List<? extends eb2>> qq1VarA = qq1.a(new yf1("Can't parse VAST response."));
            Intrinsics.checkNotNullExpressionValue(qq1VarA, "error(...)");
            return qq1VarA;
        }
        List<eb2> listB = r92VarA.b().b();
        if (listB.isEmpty()) {
            qq1<List<? extends eb2>> qq1VarA2 = qq1.a(new d50());
            Intrinsics.checkNotNull(qq1VarA2);
            return qq1VarA2;
        }
        qq1<List<? extends eb2>> qq1VarA3 = qq1.a(listB, null);
        Intrinsics.checkNotNull(qq1VarA3);
        return qq1VarA3;
    }
}
