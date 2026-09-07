package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class u92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ni2 f10369a;
    private final ma2 b;

    /* JADX WARN: Code duplicated, block: B:20:0x004a  */
    public final r92 a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        String strA = this.f10369a.a(networkResponse);
        Map<String, String> mapEmptyMap = networkResponse.c;
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        vj vjVar = new vj(mapEmptyMap);
        if (strA != null && strA.length() != 0) {
            try {
                m92 m92VarA = this.b.a(strA, vjVar);
                if (m92VarA != null) {
                    Map<String, String> responseHeaders = networkResponse.c;
                    if (responseHeaders != null) {
                        sh0 httpHeader = sh0.J;
                        int i = kf0.b;
                        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
                        Intrinsics.checkNotNullParameter(httpHeader, "httpHeader");
                        String strA2 = kf0.a(responseHeaders, httpHeader);
                        if (strA2 == null || !Boolean.parseBoolean(strA2)) {
                            strA = null;
                        }
                    } else {
                        strA = null;
                    }
                    return new r92(m92VarA, strA);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public /* synthetic */ u92(Context context, lp1 lp1Var) {
        this(context, lp1Var, sc1.a(), new ma2(context, lp1Var));
    }

    public u92(Context context, lp1 reporter, ni2 volleyNetworkResponseDecoder, ma2 vastXmlParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(volleyNetworkResponseDecoder, "volleyNetworkResponseDecoder");
        Intrinsics.checkNotNullParameter(vastXmlParser, "vastXmlParser");
        this.f10369a = volleyNetworkResponseDecoder;
        this.b = vastXmlParser;
    }
}
