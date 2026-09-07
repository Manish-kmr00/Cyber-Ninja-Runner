package com.ogury.ad.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.ogury.ad.common.OguryMediation;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e4 {
    public static ArrayList a(String str) {
        if (str == null) {
            return new ArrayList();
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                b4 b4VarA = a(jSONObject);
                if (b4VarA != null) {
                    arrayList.add(b4VarA);
                }
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static b4 a(JSONObject jSONObject) {
        OguryMediation oguryMediation;
        y1 y1Var;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(Reporting.Key.CLICK_SOURCE_TYPE_AD);
            x1 x1Var = jSONObjectOptJSONObject != null ? new x1(jSONObjectOptJSONObject.optString("campaign_id", ""), jSONObjectOptJSONObject.optString("creative_id", ""), jSONObjectOptJSONObject.optJSONArray("extras")) : null;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mediation");
            if (jSONObjectOptJSONObject2 != null) {
                String strOptString = jSONObjectOptJSONObject2.optString("name", "");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String strOptString2 = jSONObjectOptJSONObject2.optString("version", "");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                oguryMediation = new OguryMediation(strOptString, strOptString2);
            } else {
                oguryMediation = null;
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("error");
            if (jSONObjectOptJSONObject3 != null) {
                String strOptString3 = jSONObjectOptJSONObject3.optString("content");
                Intrinsics.checkNotNull(strOptString3);
                JSONObject jSONObject2 = strOptString3.length() > 0 ? new JSONObject(strOptString3) : null;
                String string = jSONObjectOptJSONObject3.getString("type");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                y1Var = new y1(string, jSONObject2);
            } else {
                y1Var = null;
            }
            String strOptString4 = jSONObject.optString("details");
            Intrinsics.checkNotNull(strOptString4);
            JSONObject jSONObject3 = strOptString4.length() > 0 ? new JSONObject(strOptString4) : null;
            long j = jSONObject.getLong(POBConstants.KEY_AT);
            String string2 = jSONObject.getString(SDKAnalyticsEvents.PARAMETER_SESSION_ID);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = jSONObject.getString("event_id");
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = jSONObject.getString("event");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            String string5 = jSONObject.getJSONObject("ad_unit").getString("id");
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return new b4(j, string2, string3, string4, jSONObject3, y1Var, string5, x1Var, p1.DEFERRED_DISPATCH, oguryMediation);
        } catch (JSONException unused) {
            return null;
        }
    }
}
