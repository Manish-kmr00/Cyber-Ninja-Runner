package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m7 implements n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f508a;
    private final List b;
    private final String c;
    private final Set d;

    private m7(String str, List list, String str2, Set set) {
        this.f508a = str;
        this.b = list;
        this.c = str2;
        this.d = set;
    }

    public static m7 a(m8 m8Var, p7 p7Var, com.applovin.impl.sdk.k kVar) {
        try {
            String str = (String) m8Var.a().get("vendor");
            m8 m8VarB = m8Var.b("VerificationParameters");
            String strD = m8VarB != null ? m8VarB.d() : null;
            List listA = m8Var.a("JavaScriptResource");
            ArrayList arrayList = new ArrayList(listA.size());
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                s7 s7VarA = s7.a((m8) it.next(), kVar);
                if (s7VarA != null) {
                    arrayList.add(s7VarA);
                }
            }
            HashMap map = new HashMap();
            x7.a(m8Var, map, p7Var, kVar);
            return new m7(str, arrayList, strD, (Set) map.get("verificationNotExecuted"));
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("VastAdVerification", "Error occurred while initializing", th);
            }
            kVar.E().a("VastAdVerification", th);
            return null;
        }
    }

    public Set b() {
        return this.d;
    }

    public List c() {
        return this.b;
    }

    public String d() {
        return this.f508a;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m7 m7Var = (m7) obj;
        String str = this.f508a;
        if (str == null ? m7Var.f508a != null : !str.equals(m7Var.f508a)) {
            return false;
        }
        List list = this.b;
        if (list == null ? m7Var.b != null : !list.equals(m7Var.b)) {
            return false;
        }
        String str2 = this.c;
        if (str2 == null ? m7Var.c != null : !str2.equals(m7Var.c)) {
            return false;
        }
        Set set = this.d;
        Set set2 = m7Var.d;
        if (set != null) {
            return set.equals(set2);
        }
        return set2 == null;
    }

    public int hashCode() {
        String str = this.f508a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.b;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set set = this.d;
        return iHashCode3 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "VastAdVerification{vendorId='" + this.f508a + "'javascriptResources='" + this.b + "'verificationParameters='" + this.c + "'errorEventTrackers='" + this.d + "'}";
    }

    public static m7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "vendor_id", null);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "javascript_resources", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            s7 s7VarA = s7.a(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), kVar);
            if (s7VarA != null) {
                arrayList.add(s7VarA);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, POBNativeConstants.NATIVE_VERIFICATION_PARAMETERS, null);
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "error_event_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            v7 v7VarA = v7.a(JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null), kVar);
            if (v7VarA != null) {
                hashSet.add(v7VarA);
            }
        }
        return new m7(string, arrayList, string2, hashSet);
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "vendor_id", this.f508a);
        if (this.b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                jSONArray.put(((s7) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "javascript_resources", jSONArray);
        }
        JsonUtils.putString(jSONObject, POBNativeConstants.NATIVE_VERIFICATION_PARAMETERS, this.c);
        if (this.d != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.d.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((v7) it2.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "error_event_trackers", jSONArray2);
        }
        return jSONObject;
    }
}
