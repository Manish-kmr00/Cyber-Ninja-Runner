package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
public final class y61 implements br1<u61> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ni2 f10706a;
    private final g91 b;

    public final u61 a(String stringResponse, wj base64EncodingParameters) {
        Intrinsics.checkNotNullParameter(stringResponse, "stringResponse");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        try {
            return this.b.a(stringResponse, base64EncodingParameters);
        } catch (p61 unused) {
            op0.b(new Object[0]);
            return null;
        } catch (JSONException unused2) {
            op0.b(new Object[0]);
            return null;
        }
    }

    public /* synthetic */ y61(Context context, lp1 lp1Var) {
        this(context, lp1Var, sc1.a(), new g91(context, lp1Var));
    }

    public y61(Context context, lp1 reporter, ni2 volleyNetworkResponseDecoder, g91 nativeJsonParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(volleyNetworkResponseDecoder, "volleyNetworkResponseDecoder");
        Intrinsics.checkNotNullParameter(nativeJsonParser, "nativeJsonParser");
        this.f10706a = volleyNetworkResponseDecoder;
        this.b = nativeJsonParser;
    }

    @Override // com.yandex.mobile.ads.impl.br1
    public final u61 a(tc1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        String strA = this.f10706a.a(networkResponse);
        if (strA == null || strA.length() == 0) {
            return null;
        }
        Map<String, String> mapEmptyMap = networkResponse.c;
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        return a(strA, new vj(mapEmptyMap));
    }
}
