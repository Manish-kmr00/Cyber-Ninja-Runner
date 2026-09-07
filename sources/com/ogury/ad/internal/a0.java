package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class a0 {
    public static void a(String errorResponse) throws JSONException, d9 {
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
        JSONObject jSONObject = new JSONObject(errorResponse);
        if (jSONObject.has("error")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("error");
            y5 y5Var = new y5(null, 7);
            Intrinsics.checkNotNullParameter(jSONObject2.optString("type", ""), "<set-?>");
            String strOptString = jSONObject2.optString("message", "");
            Intrinsics.checkNotNullParameter(strOptString, "<set-?>");
            y5Var.f7450a = strOptString;
            throw new d9(y5Var, b9.PARSING_ERROR);
        }
    }
}
