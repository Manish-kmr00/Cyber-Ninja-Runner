package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class v1 {
    public static w1 a(String errorResponseBody) {
        Intrinsics.checkNotNullParameter(errorResponseBody, "errorResponseBody");
        w1 w1Var = new w1();
        w1.a aVar = new w1.a();
        if (StringsKt.isBlank(errorResponseBody)) {
            Intrinsics.checkNotNullParameter("UNDEFINED", "<set-?>");
            Intrinsics.checkNotNullParameter("undefined error", "<set-?>");
            aVar.f7427a = "undefined error";
        } else if (e3.a(errorResponseBody)) {
            JSONObject jSONObject = new JSONObject(errorResponseBody);
            if (jSONObject.has("error")) {
                Intrinsics.checkNotNullParameter(jSONObject.getJSONObject("error").optString("type", "UNSPECIFIED"), "<set-?>");
                String strOptString = jSONObject.getJSONObject("error").optString("message", "unspecified error");
                Intrinsics.checkNotNullParameter(strOptString, "<set-?>");
                aVar.f7427a = strOptString;
            } else {
                Intrinsics.checkNotNullParameter("UNDEFINED", "<set-?>");
                Intrinsics.checkNotNullParameter("\"error\" key not found", "<set-?>");
                aVar.f7427a = "\"error\" key not found";
            }
        } else {
            Intrinsics.checkNotNullParameter("UNDEFINED", "<set-?>");
            Intrinsics.checkNotNullParameter(errorResponseBody, "<set-?>");
            aVar.f7427a = errorResponseBody;
        }
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        w1Var.f7426a = aVar;
        return w1Var;
    }
}
