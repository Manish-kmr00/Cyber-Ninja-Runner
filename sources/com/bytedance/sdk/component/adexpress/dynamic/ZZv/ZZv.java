package com.bytedance.sdk.component.adexpress.dynamic.ZZv;

import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ZZv {
    public String KZx;
    public String Og;
    public String ZZv;
    public List<pA> pA;

    public static class pA {
        public JSONObject Og;
        public int pA;
    }

    public static ZZv pA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ZZv zZv = new ZZv();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    pA pAVar = new pA();
                    pAVar.pA = jSONObjectOptJSONObject.optInt("id");
                    pAVar.Og = PangleNetworkBridge.jsonObjectInit(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(pAVar);
                }
            }
        } catch (JSONException unused) {
        }
        zZv.pA = arrayList;
        zZv.Og = jSONObject.optString("diff_data");
        zZv.KZx = jSONObject.optString("style_diff");
        zZv.ZZv = jSONObject.optString("tag_diff");
        return zZv;
    }
}
