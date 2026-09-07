package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Collections;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class s6 extends o6 {
    protected s6(String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
    }

    private l4 b(JSONObject jSONObject) {
        Map<String, String> mapEmptyMap;
        String string;
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        r0.c(jSONObject2, this.f424a);
        r0.b(jSONObject, this.f424a);
        r0.a(jSONObject, this.f424a);
        try {
            mapEmptyMap = JsonUtils.toStringMap((JSONObject) jSONObject2.get("params"));
        } catch (Throwable unused) {
            mapEmptyMap = Collections.emptyMap();
        }
        try {
            string = jSONObject2.getString("result");
        } catch (Throwable unused2) {
            string = "network_timeout";
        }
        return l4.a(string, mapEmptyMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        l4 l4VarB = b(jSONObject);
        a(l4VarB);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Pending reward handled: " + l4VarB);
        }
    }

    protected abstract void a(l4 l4Var);

    @Override // com.applovin.impl.o6
    protected int g() {
        return ((Integer) this.f424a.a(v4.d1)).intValue();
    }

    protected abstract boolean h();

    @Override // java.lang.Runnable
    public void run() {
        a(e(), new a());
    }

    class a implements q0.e {
        a() {
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            if (s6.this.h()) {
                com.applovin.impl.sdk.o oVar = s6.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    s6 s6Var = s6.this;
                    s6Var.c.b(s6Var.b, "Reward validation succeeded with code " + i + " but task was cancelled already");
                }
                com.applovin.impl.sdk.o oVar2 = s6.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    s6 s6Var2 = s6.this;
                    s6Var2.c.b(s6Var2.b, "Response: " + jSONObject);
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.o oVar3 = s6.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                s6 s6Var3 = s6.this;
                s6Var3.c.a(s6Var3.b, "Reward validation succeeded with code " + i + " and response: " + jSONObject);
            }
            s6.this.c(jSONObject);
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            if (s6.this.h()) {
                com.applovin.impl.sdk.o oVar = s6.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    s6 s6Var = s6.this;
                    s6Var.c.b(s6Var.b, "Reward validation failed with error code " + i + " but task was cancelled already");
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.o oVar2 = s6.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                s6 s6Var2 = s6.this;
                s6Var2.c.b(s6Var2.b, "Reward validation failed with code " + i + " and error: " + str2);
            }
            s6.this.a(i);
        }
    }
}
