package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f562a;
    private final String b;
    private final h8 c;
    private final List d;
    private final List e;
    private boolean f = false;

    o(JSONObject jSONObject, Map map, MaxAdFormat maxAdFormat, com.applovin.impl.sdk.k kVar) {
        this.f562a = JsonUtils.getString(jSONObject, "name", "");
        this.b = JsonUtils.getString(jSONObject, "experiment", null);
        this.c = a(jSONObject);
        this.d = a("bidders", jSONObject, map, maxAdFormat, kVar);
        this.e = a(com.json.mediationsdk.d.h, jSONObject, map, maxAdFormat, kVar);
    }

    public List a() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.f562a;
    }

    public h8 d() {
        return this.c;
    }

    public List e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    private h8 a(JSONObject jSONObject) {
        return new h8(JsonUtils.getJSONObject(jSONObject, "targeting"));
    }

    private List a(String str, JSONObject jSONObject, Map map, MaxAdFormat maxAdFormat, com.applovin.impl.sdk.k kVar) {
        b3 b3Var;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, str, new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null && (b3Var = (b3) map.get(JsonUtils.getString(jSONObject2, "adapter_class", ""))) != null) {
                if (b3Var.D()) {
                    this.f = true;
                }
                arrayList.add(new f8(jSONObject2, maxAdFormat, b3Var, kVar));
            }
        }
        return arrayList;
    }
}
