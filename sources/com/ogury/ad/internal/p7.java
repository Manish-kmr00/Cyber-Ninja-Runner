package com.ogury.ad.internal;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class p7 {
    public static final JSONObject a(Pair<String, ? extends Object>... details) throws JSONException {
        Intrinsics.checkNotNullParameter(details, "details");
        JSONObject jSONObject = new JSONObject();
        for (Pair<String, ? extends Object> pair : details) {
            jSONObject.putOpt(pair.component1(), pair.component2());
        }
        return jSONObject;
    }

    public static final JSONObject b(Pair<String, ? extends Object>... details) throws JSONException {
        Intrinsics.checkNotNullParameter(details, "details");
        JSONObject jSONObject = new JSONObject();
        for (Pair<String, ? extends Object> pair : details) {
            jSONObject.putOpt(pair.component1(), pair.component2());
        }
        return jSONObject;
    }
}
