package com.digitalturbine.ignite.authenticator.parsers;

import android.text.TextUtils;
import com.digitalturbine.ignite.authenticator.events.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    public static com.digitalturbine.ignite.authenticator.b a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.digitalturbine.ignite.authenticator.logger.a.b("%s : empty one dt", "OneDTParser");
            return new com.digitalturbine.ignite.authenticator.b("", -1L);
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("data");
            if (jSONObjectOptJSONObject != null && "onedtid".equalsIgnoreCase(jSONObjectOptJSONObject.optString("propertyName", ""))) {
                return new com.digitalturbine.ignite.authenticator.b(jSONObjectOptJSONObject.optString("propertyValue", ""), jSONObjectOptJSONObject.optLong("refreshTime", -1L));
            }
        } catch (Exception e) {
            com.digitalturbine.ignite.authenticator.events.b.a(d.ONE_DT_PARSE_ERROR, e);
            com.digitalturbine.ignite.authenticator.logger.a.b("%s : failed parse one dt", "OneDTParser");
        }
        return new com.digitalturbine.ignite.authenticator.b("", -1L);
    }
}
