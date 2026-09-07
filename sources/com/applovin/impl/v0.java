package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class v0 extends u0 {
    public v0(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        super(jSONObject, kVar);
    }

    public List d() {
        w0 w0VarA;
        JSONArray jSONArray = JsonUtils.getJSONArray(this.b, "transitions", null);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject != null && (w0VarA = w0.a(jSONObject, this.f704a)) != null) {
                arrayList.add(w0VarA);
            }
        }
        return arrayList;
    }

    public String e() {
        return b("message");
    }

    public String f() {
        return b("title");
    }

    @Override // com.applovin.impl.u0
    public String toString() {
        return "ConsentFlowState{id=" + b() + ", type=" + c() + ", title=" + f() + ", message=" + e() + ", actions=" + d() + "}";
    }
}
