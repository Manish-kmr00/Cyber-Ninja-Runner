package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f8552a;
    private final j82 b;
    private final t62 c;
    private final c10 d;
    private final d30 e;
    private Map<String, ? extends b0<?>> f;

    public final b0<?> a(JSONObject jsonObject, wj base64EncodingParameters) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        String strA = f91.a(jsonObject, "jsonAsset", "type", "jsonAttribute", "type");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        Map<String, ? extends b0<?>> mapMapOf = this.f;
        if (mapMapOf == null) {
            Pair pair = TuplesKt.to("adtune", new lb(this.b, this.c));
            Pair pair2 = TuplesKt.to("divkit_adtune", new m20(this.d, this.e, this.c, base64EncodingParameters.a()));
            Pair pair3 = TuplesKt.to("close", new lp());
            j82 j82Var = this.b;
            Pair pair4 = TuplesKt.to("deeplink", new ty(j82Var, new yj1(j82Var)));
            Pair pair5 = TuplesKt.to("feedback", new na0(this.b));
            lp1 lp1Var = this.f8552a;
            mapMapOf = MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, TuplesKt.to("social_action", new w02(lp1Var, base64EncodingParameters, new t02(new sr0(lp1Var)))));
            this.f = mapMapOf;
        }
        return mapMapOf.get(strA);
    }

    public /* synthetic */ c0(lp1 lp1Var) {
        this(lp1Var, new j82(), new t62(), new c10(), new d30(lp1Var));
    }

    public c0(lp1 reporter, j82 urlJsonParser, t62 trackingUrlsParser, c10 designJsonParser, d30 divKitDesignParser) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(urlJsonParser, "urlJsonParser");
        Intrinsics.checkNotNullParameter(trackingUrlsParser, "trackingUrlsParser");
        Intrinsics.checkNotNullParameter(designJsonParser, "designJsonParser");
        Intrinsics.checkNotNullParameter(divKitDesignParser, "divKitDesignParser");
        this.f8552a = reporter;
        this.b = urlJsonParser;
        this.c = trackingUrlsParser;
        this.d = designJsonParser;
        this.e = divKitDesignParser;
    }
}
