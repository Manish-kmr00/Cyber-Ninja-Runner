package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class o6 extends g5 {
    protected o6(String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
    }

    protected abstract void a(JSONObject jSONObject);

    void a(JSONObject jSONObject, q0.e eVar) {
        Map mapC = r0.c(this.f424a);
        if (((Boolean) this.f424a.a(v4.v5)).booleanValue() || ((Boolean) this.f424a.a(v4.o5)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) mapC);
            mapC = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f424a).b(r0.b(f(), this.f424a)).a(r0.a(f(), this.f424a)).b(mapC).a(jSONObject).c("POST").b(((Boolean) this.f424a.a(v4.E5)).booleanValue()).a((Object) new JSONObject()).a(g()).a(s4.a.a(((Integer) this.f424a.a(v4.n5)).intValue())).a(), this.f424a, eVar);
        aVar.c(v4.q0);
        aVar.b(v4.r0);
        this.f424a.r0().a(aVar);
    }

    protected JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        String strE = this.f424a.x0().e();
        if (((Boolean) this.f424a.a(v4.y3)).booleanValue() && StringUtils.isValidString(strE)) {
            JsonUtils.putString(jSONObject, "cuid", strE);
        }
        if (((Boolean) this.f424a.a(v4.A3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.f424a.v());
        }
        if (((Boolean) this.f424a.a(v4.C3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.f424a.i0());
        }
        a(jSONObject);
        return jSONObject;
    }

    protected abstract String f();

    protected abstract int g();

    class a extends j6 {
        final /* synthetic */ q0.e m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, q0.e eVar) {
            super(aVar, kVar);
            this.m = eVar;
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            this.m.a(str, jSONObject, i);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            this.m.a(str, i, str2, jSONObject);
        }
    }

    protected void a(int i) {
        r0.a(i, this.f424a);
    }
}
