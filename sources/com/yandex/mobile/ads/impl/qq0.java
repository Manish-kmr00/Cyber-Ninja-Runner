package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class qq0 {
    public static HashMap a(JSONObject jsonObject) {
        Object obj;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        HashMap map = new HashMap();
        Iterator<String> itKeys = jsonObject.keys();
        Intrinsics.checkNotNull(itKeys);
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Intrinsics.checkNotNull(key);
            Intrinsics.checkNotNullParameter(jsonObject, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                obj = jsonObject.get(key);
            } catch (JSONException unused) {
                obj = null;
            }
            if (obj != null) {
                if (obj instanceof JSONObject) {
                    map.put(key, a((JSONObject) obj));
                } else {
                    map.put(key, obj);
                }
            }
        }
        return map;
    }
}
