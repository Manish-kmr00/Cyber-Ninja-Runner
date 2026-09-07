package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class t02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sr0 f10253a;
    private final v02 b;

    public final s02 a(JSONObject jsonObject, wj base64EncodingParameters) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        String strA = f91.a(jsonObject, "jsonAsset", "name", "jsonAttribute", "name");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        JSONObject jSONObject = jsonObject.getJSONObject("link");
        sr0 sr0Var = this.f10253a;
        Intrinsics.checkNotNull(jSONObject);
        rr0 rr0VarA = sr0Var.a(jSONObject, base64EncodingParameters);
        JSONObject jSONObject2 = jsonObject.getJSONObject("value");
        v02 v02Var = this.b;
        Intrinsics.checkNotNull(jSONObject2);
        return new s02(rr0VarA, strA, v02Var.a(jSONObject2));
    }

    public /* synthetic */ t02(sr0 sr0Var) {
        this(sr0Var, new v02());
    }

    public t02(sr0 linkJsonParser, v02 valueParser) {
        Intrinsics.checkNotNullParameter(linkJsonParser, "linkJsonParser");
        Intrinsics.checkNotNullParameter(valueParser, "valueParser");
        this.f10253a = linkJsonParser;
        this.b = valueParser;
    }
}
