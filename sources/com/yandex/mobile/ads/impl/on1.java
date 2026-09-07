package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class on1 {
    public static nn1 a(String readyResponse) throws JSONException {
        Intrinsics.checkNotNullParameter(readyResponse, "readyResponse");
        JSONObject jSONObject = new JSONObject(xj.b(readyResponse));
        HashMap map = new HashMap();
        String string = jSONObject.getString("body");
        JSONObject jSONObject2 = jSONObject.getJSONObject("headers");
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String string2 = jSONObject2.getString(next);
            Intrinsics.checkNotNull(next);
            Intrinsics.checkNotNull(string2);
            map.put(next, string2);
        }
        Intrinsics.checkNotNull(string);
        return new nn1(string, map);
    }
}
