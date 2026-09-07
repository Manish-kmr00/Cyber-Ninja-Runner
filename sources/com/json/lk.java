package com.json;

import com.json.mediationsdk.logger.IronLog;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
class lk extends e {
    private final String i = "https://o-sdk.mediation.unity3d.com/mediation?adUnit=2";
    private final String j = "super.dwh.mediation_events";
    private final String k = cc.Q;
    private final String l = "data";

    lk(int i) {
        this.g = i;
    }

    @Override // com.json.e
    public String a() {
        return "https://o-sdk.mediation.unity3d.com/mediation?adUnit=2";
    }

    @Override // com.json.e
    public String a(ArrayList<zb> arrayList, JSONObject jSONObject) {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        if (jSONObject == null) {
            jSONObject = IronSourceNetworkBridge.jsonObjectInit();
        }
        this.f = jSONObject;
        try {
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<zb> it = arrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectA = a(it.next());
                    if (jSONObjectA != null) {
                        jSONArray.put(jSONObjectA);
                    }
                }
            }
            jSONObjectJsonObjectInit.put(cc.Q, "super.dwh.mediation_events");
            jSONObjectJsonObjectInit.put("data", a(jSONArray));
            return jSONObjectJsonObjectInit.toString();
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    @Override // com.json.e
    public String c() {
        return "ironbeast";
    }
}
