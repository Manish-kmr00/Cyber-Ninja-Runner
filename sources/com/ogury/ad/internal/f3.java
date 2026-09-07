package com.ogury.ad.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.ogury.ad.common.OguryMediation;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f3 {
    public static final void a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            Intrinsics.checkNotNullParameter(jSONObject2, "<this>");
            if (jSONObject2.length() == 0) {
                return;
            }
            jSONObject.put(str, jSONObject2);
        }
    }

    public static final JSONObject a(b4 b4Var) throws JSONException {
        Intrinsics.checkNotNullParameter(b4Var, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(POBConstants.KEY_AT, b4Var.f7268a);
        a(jSONObject, SDKAnalyticsEvents.PARAMETER_SESSION_ID, b4Var.b);
        a(jSONObject, "event_id", b4Var.c);
        a(jSONObject, "event", b4Var.d);
        JSONObject jSONObject2 = b4Var.e;
        a(jSONObject, "details", jSONObject2 != null ? jSONObject2.toString() : null);
        y1 y1Var = b4Var.f;
        String str = y1Var != null ? y1Var.f7446a : null;
        JSONObject jSONObject3 = y1Var != null ? y1Var.b : null;
        String string = jSONObject3 != null ? jSONObject3.toString() : null;
        JSONObject jSONObject4 = new JSONObject();
        a(jSONObject4, "type", str);
        a(jSONObject4, "content", string);
        a(jSONObject, "error", jSONObject4);
        x1 x1Var = b4Var.h;
        a(jSONObject, Reporting.Key.CLICK_SOURCE_TYPE_AD, a(new k(null, x1Var != null ? x1Var.f7438a : null, x1Var != null ? x1Var.b : null, x1Var != null ? x1Var.c : null, null)));
        OguryMediation oguryMediation = b4Var.j;
        String name = oguryMediation != null ? oguryMediation.getName() : null;
        OguryMediation oguryMediation2 = b4Var.j;
        String version = oguryMediation2 != null ? oguryMediation2.getVersion() : null;
        JSONObject jSONObject5 = new JSONObject();
        a(jSONObject5, "name", name);
        a(jSONObject5, "version", version);
        a(jSONObject, "mediation", jSONObject5);
        String str2 = b4Var.g;
        JSONObject jSONObject6 = new JSONObject();
        a(jSONObject6, "id", str2);
        a(jSONObject, "ad_unit", jSONObject6);
        a(jSONObject, "dispatch", b4Var.i.f7381a);
        return jSONObject;
    }

    public static final JSONObject a(k kVar) throws JSONException {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, "ad_unit_id", kVar.f7334a);
        a(jSONObject2, "campaign_id", kVar.b);
        a(jSONObject2, "creative_id", kVar.c);
        JSONArray jSONArray = kVar.d;
        if (jSONArray != null && jSONArray.length() != 0) {
            jSONObject2.put("extras", jSONArray);
        }
        u1 u1Var = kVar.e;
        if (u1Var != null) {
            jSONObject = new JSONObject();
            a(jSONObject, "creative_id", u1Var.f7409a);
            a(jSONObject, "region", u1Var.b);
        } else {
            jSONObject = null;
        }
        a(jSONObject2, "dsp", jSONObject);
        return jSONObject2;
    }

    public static final void a(JSONObject jSONObject, String str, String str2) {
        if (str2 == null || StringsKt.isBlank(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }
}
