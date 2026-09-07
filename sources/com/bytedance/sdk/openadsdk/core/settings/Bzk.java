package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class Bzk {
    public static final Bzk pA = new Bzk("");
    private final HashMap<String, pA> Og = new HashMap<>();

    public Bzk(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    pA pAVar = new pA(jSONObjectOptJSONObject);
                    this.Og.put(pAVar.pA, pAVar);
                }
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("MediationInitConfigs", e.getMessage());
        }
    }

    public static class pA {
        public int KZx;
        public String ML;
        public String Og;
        public int ZZv;
        public final String pA;

        public pA(JSONObject jSONObject) {
            this.pA = jSONObject.optString("name");
            this.Og = jSONObject.optString("app_id");
            this.KZx = jSONObject.optInt("init_thread", 2);
            this.ZZv = jSONObject.optInt("request_after_init", 2);
            this.ML = jSONObject.optString("class_name");
        }
    }
}
