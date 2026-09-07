package com.json;

import com.json.mediationsdk.logger.IronLog;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class uv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4509a = "errMsg";

    public static JSONObject a(String str, String str2) {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            jSONObjectJsonObjectInit.put("errMsg", str);
            jSONObjectJsonObjectInit.put("adViewId", str2);
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObjectJsonObjectInit;
    }
}
