package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
class h5 extends g5 {
    h5(com.applovin.impl.sdk.k kVar) {
        super("TaskApiSubmitData", kVar);
    }

    private void b(JSONObject jSONObject) {
        com.applovin.impl.sdk.l lVarB = this.f424a.B();
        Map mapO = lVarB.o();
        k7.a("platform", "type", mapO);
        k7.a("api_level", "sdk_version", mapO);
        JsonUtils.putObject(jSONObject, DeviceRequestsHelper.DEVICE_INFO_PARAM, new JSONObject(mapO));
        Map mapE = lVarB.E();
        k7.a("sdk_version", "applovin_sdk_version", mapE);
        k7.a("ia", "installed_at", mapE);
        JsonUtils.putObject(jSONObject, "app_info", new JSONObject(mapE));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d(this.b, "Submitting user data...");
        }
        Map mapC = r0.c(this.f424a);
        JSONObject jSONObject = new JSONObject();
        b(jSONObject);
        if (((Boolean) this.f424a.a(v4.u5)).booleanValue() || ((Boolean) this.f424a.a(v4.o5)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) mapC);
            mapC = null;
        }
        a(mapC, jSONObject);
    }

    class a extends j6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            h5.this.a(jSONObject);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            r0.a(i, this.f424a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        this.f424a.p0().a(v4.f, JsonUtils.getString(jSONObject2, "device_id", ""));
        this.f424a.p0().a(v4.j, JsonUtils.getString(jSONObject2, "device_token", ""));
        r0.a(jSONObject2, this.f424a);
    }

    private void a(Map map, JSONObject jSONObject) {
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f424a).b(r0.b("2.0/device", this.f424a)).a(r0.a("2.0/device", this.f424a)).b(map).a(jSONObject).c("POST").b(((Boolean) this.f424a.a(v4.B5)).booleanValue()).a((Object) new JSONObject()).a(((Integer) this.f424a.a(v4.X2)).intValue()).a(s4.a.a(((Integer) this.f424a.a(v4.m5)).intValue())).a(), this.f424a);
        aVar.c(v4.q0);
        aVar.b(v4.r0);
        this.f424a.r0().a(aVar);
    }
}
