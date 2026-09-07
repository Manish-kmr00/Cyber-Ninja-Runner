package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q51 extends zj<u61> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q51(Context context, aq1<u61> requestPolicy, o3 adConfiguration, String url, String query, xp1 requestListener, pk.a<o8<u61>> listener, k61 responseParserCreator, t61 nativeAdRequestReporter) {
        super(context, adConfiguration, url, query, responseParserCreator, requestListener, listener, nativeAdRequestReporter, null, 1792);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(responseParserCreator, "responseParserCreator");
        Intrinsics.checkNotNullParameter(nativeAdRequestReporter, "nativeAdRequestReporter");
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001c  */
    /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // com.yandex.mobile.ads.impl.zj
    protected final boolean b(tc1 networkResponse, int i) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        if (200 == i) {
            Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
            byte[] bArr = networkResponse.b;
            if (bArr != null) {
                if (!(!(bArr.length == 0))) {
                    if (204 != i) {
                        return false;
                    }
                }
            } else if (204 != i) {
                return false;
            }
        } else if (204 != i) {
            return false;
        }
        return true;
    }
}
