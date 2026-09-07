package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.playon.bridge.Ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n7 implements n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f559a;

    private n7(List list) {
        this.f559a = list;
    }

    public static n7 a(m8 m8Var, n7 n7Var, p7 p7Var, com.applovin.impl.sdk.k kVar) {
        try {
            List listB = n7Var != null ? n7Var.b() : new ArrayList();
            Iterator it = m8Var.a("Verification").iterator();
            while (it.hasNext()) {
                m7 m7VarA = m7.a((m8) it.next(), p7Var, kVar);
                if (m7VarA != null) {
                    listB.add(m7VarA);
                }
            }
            return new n7(listB);
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("VastAdVerifications", "Error occurred while initializing", th);
            }
            kVar.E().a("VastAdVerifications", th);
            return null;
        }
    }

    public List b() {
        return this.f559a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n7) {
            return this.f559a.equals(((n7) obj).f559a);
        }
        return false;
    }

    public int hashCode() {
        return this.f559a.hashCode();
    }

    public String toString() {
        return "VastAdVerification{verifications='" + this.f559a + "'}";
    }

    static n7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, Ad.ADVERIFICATIONS, new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            m7 m7VarA = m7.a(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), kVar);
            if (m7VarA != null) {
                arrayList.add(m7VarA);
            }
        }
        return new n7(arrayList);
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (this.f559a != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f559a.iterator();
            while (it.hasNext()) {
                jSONArray.put(((m7) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, Ad.ADVERIFICATIONS, jSONArray);
        }
        return jSONObject;
    }
}
