package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class u7 implements n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f711a;
    private String b;

    private u7() {
    }

    public static u7 a(m8 m8Var, u7 u7Var, com.applovin.impl.sdk.k kVar) {
        if (m8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (u7Var == null) {
            try {
                u7Var = new u7();
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("VastSystemInfo", "Error occurred while initializing", th);
                }
                kVar.E().a("VastSystemInfo", th);
                return null;
            }
        }
        if (!StringUtils.isValidString(u7Var.f711a)) {
            String strD = m8Var.d();
            if (StringUtils.isValidString(strD)) {
                u7Var.f711a = strD;
            }
        }
        if (!StringUtils.isValidString(u7Var.b)) {
            String str = (String) m8Var.a().get("version");
            if (StringUtils.isValidString(str)) {
                u7Var.b = str;
            }
        }
        return u7Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u7)) {
            return false;
        }
        u7 u7Var = (u7) obj;
        String str = this.f711a;
        if (str == null ? u7Var.f711a != null : !str.equals(u7Var.f711a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = u7Var.b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        return str3 == null;
    }

    public int hashCode() {
        String str = this.f711a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.f711a + "', version='" + this.b + "'}";
    }

    public static u7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        u7 u7Var = new u7();
        u7Var.f711a = JsonUtils.getString(jSONObject, "name", null);
        u7Var.b = JsonUtils.getString(jSONObject, "version", null);
        return u7Var;
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "name", this.f711a);
        JsonUtils.putString(jSONObject, "version", this.b);
        return jSONObject;
    }
}
