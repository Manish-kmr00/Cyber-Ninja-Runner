package com.json;

import com.json.mediationsdk.logger.IronLog;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class sk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4424a;
    private JSONObject b;
    private String c;
    private String d;

    public sk(JSONObject jSONObject) {
        this.f4424a = jSONObject.optString(b9.f.b);
        this.b = jSONObject.optJSONObject(b9.f.c);
        this.c = jSONObject.optString("success");
        this.d = jSONObject.optString(b9.f.e);
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.f4424a;
    }

    public JSONObject c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public JSONObject e() {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            jSONObjectJsonObjectInit.put(b9.f.b, this.f4424a);
            jSONObjectJsonObjectInit.put(b9.f.c, this.b);
            jSONObjectJsonObjectInit.put("success", this.c);
            jSONObjectJsonObjectInit.put(b9.f.e, this.d);
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObjectJsonObjectInit;
    }
}
