package com.bytedance.sdk.openadsdk.Sn.KZx;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.json.fe;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class KZx {

    public static class pA {
        public final JSONObject Og;
        public final String pA;

        public pA(String str, JSONObject jSONObject) {
            this.pA = str;
            this.Og = jSONObject;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DeviceRequestsHelper.DEVICE_INFO_PARAM);
            if (jSONObjectOptJSONObject != null) {
                try {
                    jSONObjectOptJSONObject.put(fe.Q0, com.bytedance.sdk.openadsdk.XT.pA.Og.pA.pA().Og());
                    jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, jSONObjectOptJSONObject);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static Og pA() {
        return ZZv.pA();
    }
}
