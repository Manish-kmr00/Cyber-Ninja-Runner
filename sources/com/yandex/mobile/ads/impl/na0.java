package com.yandex.mobile.ads.impl;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class na0 implements b0<la0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j82 f9712a;

    public na0(j82 urlJsonParser) {
        Intrinsics.checkNotNullParameter(urlJsonParser, "urlJsonParser");
        this.f9712a = urlJsonParser;
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
            JSONObject jsonAsset = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNull(jsonAsset);
            Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
            Intrinsics.checkNotNullParameter("title", "jsonAttribute");
            String strOptString = jsonAsset.optString("title");
            if (strOptString == null || strOptString.length() == 0 || Intrinsics.areEqual(strOptString, "null")) {
                throw new p61("Native Ad json has not required attributes");
            }
            Intrinsics.checkNotNull(strOptString);
            this.f9712a.getClass();
            arrayList.add(new la0.a(strOptString, j82.a("url", jsonAsset)));
        }
        if (arrayList.isEmpty()) {
            throw new p61("Native Ad json has not required attributes");
        }
        return new la0(strA, arrayList);
    }
}
