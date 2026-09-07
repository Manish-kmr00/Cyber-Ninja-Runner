package com.json;

import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class wo extends e {
    private final String i = kp.f3842a;

    wo(int i) {
        this.g = i;
    }

    @Override // com.json.e
    public String a() {
        return kp.f3842a;
    }

    @Override // com.json.e
    public String a(ArrayList<zb> arrayList, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = IronSourceNetworkBridge.jsonObjectInit();
        }
        this.f = jSONObject;
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
        return a(jSONArray);
    }

    @Override // com.json.e
    public String c() {
        return "outcome";
    }
}
