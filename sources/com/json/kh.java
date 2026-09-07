package com.json;

import android.util.Base64;
import com.json.mediationsdk.logger.IronLog;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class kh implements vf {
    @Override // com.json.vf
    public String a(Map<String, Object> map) {
        try {
            return String.format("%s=%s", "data", Base64.encodeToString(IronSourceNetworkBridge.jsonObjectInit().put(cc.Q, cc.R).put("data", new JSONObject(map)).toString().getBytes(), 2));
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }
}
