package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.safedk.android.utils.SdksMapping;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class u5 extends g5 {
    private final q0.e g;

    public u5(q0.e eVar, com.applovin.impl.sdk.k kVar) {
        super("TaskFetchMediationDebuggerInfo", kVar, true);
        this.g = eVar;
    }

    protected Map e() {
        HashMap map = new HashMap();
        map.put("sdk_version", AppLovinSdk.VERSION);
        if (!((Boolean) this.f424a.a(v4.a5)).booleanValue()) {
            map.put("sdk_key", this.f424a.j0());
        }
        Map mapE = this.f424a.B().E();
        map.put("package_name", String.valueOf(mapE.get("package_name")));
        map.put("app_version", String.valueOf(mapE.get("app_version")));
        Map mapL = this.f424a.B().L();
        map.put("platform", String.valueOf(mapL.get("platform")));
        map.put("os", String.valueOf(mapL.get("os")));
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map mapE = e();
        JSONObject jSONObjectA = a(a());
        if (((Boolean) this.f424a.a(v4.r5)).booleanValue() || ((Boolean) this.f424a.a(v4.o5)).booleanValue()) {
            JsonUtils.putAll(jSONObjectA, (Map<String, ?>) mapE);
            mapE = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f424a).c("POST").b(i3.i(this.f424a)).a(i3.h(this.f424a)).b(mapE).a(jSONObjectA).a((Object) new JSONObject()).c(((Long) this.f424a.a(o3.k7)).intValue()).a(s4.a.a(((Integer) this.f424a.a(v4.h5)).intValue())).a(), this.f424a, d());
        aVar.c(o3.g7);
        aVar.b(o3.h7);
        this.f424a.r0().a(aVar);
    }

    class a extends j6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, boolean z) {
            super(aVar, kVar, z);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            u5.this.g.a(str, jSONObject, i);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            u5.this.g.a(str, i, str2, jSONObject);
        }
    }

    private JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJsonArrayIfValid(jSONObject, SdksMapping.KEY_INSTALLED_MEDIATION_ADAPTERS, t3.b(this.f424a));
        JsonUtils.putBoolean(jSONObject, "is_tablet", AppLovinSdkUtils.isTablet(context));
        v.a aVarF = this.f424a.B().f();
        JsonUtils.putStringIfValid(jSONObject, "dnt_code", aVarF.b().b());
        JsonUtils.putStringIfValid(jSONObject, "idfa", aVarF.a());
        Map mapL0 = this.f424a.l0();
        if (!CollectionUtils.isEmpty(mapL0)) {
            JsonUtils.putJSONObject(jSONObject, "segments", new JSONObject(mapL0));
        }
        return jSONObject;
    }
}
