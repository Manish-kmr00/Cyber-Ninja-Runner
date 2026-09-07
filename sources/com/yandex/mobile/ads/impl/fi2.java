package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class fi2 extends b62<gi2, ci2> {
    private final ei2 C;
    private final ni2 D;
    private final fq1 E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi2(Context context, o3 adConfiguration, String url, ri2 listener, gi2 configuration, ji2 requestReporter, ei2 vmapParser, ni2 volleyNetworkResponseDecoder) {
        super(context, adConfiguration, 0, url, listener, configuration, requestReporter, null, 1920);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(requestReporter, "requestReporter");
        Intrinsics.checkNotNullParameter(vmapParser, "vmapParser");
        Intrinsics.checkNotNullParameter(volleyNetworkResponseDecoder, "volleyNetworkResponseDecoder");
        this.C = vmapParser;
        this.D = volleyNetworkResponseDecoder;
        op0.e(url);
        this.E = fq1.d;
    }

    @Override // com.yandex.mobile.ads.impl.b62
    public final qq1<ci2> a(tc1 networkResponse, int i) {
        byte[] data;
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        a(Integer.valueOf(i));
        if (200 == i && (data = networkResponse.b) != null) {
            Intrinsics.checkNotNullExpressionValue(data, "data");
            if (data.length != 0) {
                String strA = this.D.a(networkResponse);
                Map<String, String> mapEmptyMap = networkResponse.c;
                if (mapEmptyMap == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                vj vjVar = new vj(mapEmptyMap);
                if (strA == null || strA.length() == 0) {
                    qq1<ci2> qq1VarA = qq1.a(new yf1("Can't parse VMAP response"));
                    Intrinsics.checkNotNull(qq1VarA);
                    return qq1VarA;
                }
                try {
                    qq1<ci2> qq1VarA2 = qq1.a(this.C.a(strA, vjVar), null);
                    Intrinsics.checkNotNullExpressionValue(qq1VarA2, "success(...)");
                    return qq1VarA2;
                } catch (Exception e) {
                    qq1<ci2> qq1VarA3 = qq1.a(new yf1(e));
                    Intrinsics.checkNotNullExpressionValue(qq1VarA3, "error(...)");
                    return qq1VarA3;
                }
            }
        }
        int i2 = r3.d;
        qq1<ci2> qq1VarA4 = qq1.a(new ki2(y3.a.a(null, r3.a.a(networkResponse).a()).c()));
        Intrinsics.checkNotNullExpressionValue(qq1VarA4, "error(...)");
        return qq1VarA4;
    }

    @Override // com.yandex.mobile.ads.impl.pk
    protected final fq1 w() {
        return this.E;
    }
}
