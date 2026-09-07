package com.ogury.ad.internal;

import io.bidmachine.iab.vast.tags.VastAttributes;
import io.ktor.http.ContentDisposition;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class r9 {
    public static q9 a(JSONObject zoneJson) {
        Intrinsics.checkNotNullParameter(zoneJson, "zoneJson");
        q9 q9Var = new q9();
        String strOptString = zoneJson.optString("url", "");
        Intrinsics.checkNotNullParameter(strOptString, "<set-?>");
        q9Var.f7391a = strOptString;
        String strOptString2 = zoneJson.optString("content", "");
        Intrinsics.checkNotNullParameter(strOptString2, "<set-?>");
        q9Var.b = strOptString2;
        String strOptString3 = zoneJson.optString("webViewId", zoneJson.optString("id", ""));
        Intrinsics.checkNotNullParameter(strOptString3, "<set-?>");
        q9Var.c = strOptString3;
        JSONObject jSONObjectOptJSONObject = zoneJson.optJSONObject(ContentDisposition.Parameters.Size);
        q9Var.e = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optInt("width", -1) : -1;
        JSONObject jSONObjectOptJSONObject2 = zoneJson.optJSONObject(ContentDisposition.Parameters.Size);
        q9Var.d = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optInt("height", -1) : -1;
        JSONObject jSONObjectOptJSONObject3 = zoneJson.optJSONObject(com.ironsource.b9.h.L);
        q9Var.g = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt(VastAttributes.HORIZONTAL_POSITION, -1) : -1;
        JSONObject jSONObjectOptJSONObject4 = zoneJson.optJSONObject(com.ironsource.b9.h.L);
        q9Var.f = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optInt(VastAttributes.VERTICAL_POSITION, -1) : -1;
        q9Var.h = zoneJson.optBoolean("enableTracking", false);
        q9Var.i = zoneJson.optBoolean("keepAlive", false);
        q9Var.j = zoneJson.optBoolean("isLandingPage", false);
        return q9Var;
    }
}
