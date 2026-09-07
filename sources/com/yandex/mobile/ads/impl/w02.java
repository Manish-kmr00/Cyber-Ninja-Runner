package com.yandex.mobile.ads.impl;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class w02 implements b0<p02> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wj f10524a;
    private final t02 b;

    public w02(lp1 reporter, wj base64EncodingParameters, t02 itemParser) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        Intrinsics.checkNotNullParameter(itemParser, "itemParser");
        this.f10524a = base64EncodingParameters;
        this.b = itemParser;
    }

    @Override // com.yandex.mobile.ads.impl.b0
    public final x a(JSONObject jsonObject) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String strA = f91.a(jsonObject, "jsonAsset", "type", "jsonAttribute", "type");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        JSONArray jSONArray = jsonObject.getJSONArray(FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNull(jSONArray);
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            t02 t02Var = this.b;
            Intrinsics.checkNotNull(jSONObject);
            arrayList.add(t02Var.a(jSONObject, this.f10524a));
        }
        if (arrayList.isEmpty()) {
            throw new p61("Native Ad json has not required attributes");
        }
        return new p02(strA, arrayList);
    }
}
