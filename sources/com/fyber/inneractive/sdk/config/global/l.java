package com.fyber.inneractive.sdk.config.global;

import com.fyber.inneractive.sdk.util.IAlog;
import com.json.tr;
import com.pubmatic.sdk.common.models.POBProfileInfo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1704a = new HashMap();

    public static l a(JSONObject jSONObject) throws JSONException {
        l lVar = new l();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("features");
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
            q qVar = new q();
            qVar.b = jSONObject2.getString("id");
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                qVar.f1706a = new o(jSONObjectOptJSONObject);
            } else {
                IAlog.a("RemoteFeature fromJson. feature %s has no params!", qVar.b);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray(tr.d);
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    b bVar = new b();
                    bVar.f1696a = jSONObject3.getString("id");
                    bVar.b = jSONObject3.optInt("perc", 10);
                    JSONArray jSONArray = jSONObject3.getJSONArray("variants");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                        k kVar = new k();
                        kVar.b = jSONObject4.getString("id");
                        kVar.c = jSONObject4.getInt("perc");
                        JSONObject jSONObjectOptJSONObject2 = jSONObject4.optJSONObject("params");
                        if (jSONObjectOptJSONObject2 != null) {
                            kVar.f1706a = new o(jSONObjectOptJSONObject2);
                        }
                        bVar.c.add(kVar);
                    }
                    b.a(bVar, jSONObject3.optJSONObject(POBProfileInfo.COUNTRY_FILTERING_ALLOW_MODE), true);
                    b.a(bVar, jSONObject3.optJSONObject(POBProfileInfo.COUNTRY_FILTERING_BLOCK_MODE), false);
                    qVar.c.put(bVar.f1696a, bVar);
                }
            }
            lVar.f1704a.put(qVar.b, qVar);
        }
        return lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        return this.f1704a.equals(((l) obj).f1704a);
    }

    public final int hashCode() {
        return this.f1704a.hashCode();
    }

    public final String toString() {
        return String.format("remoteConfig - features: %s", this.f1704a.values());
    }
}
