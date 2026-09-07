package com.bytedance.adsdk.ugeno.ZZv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Og {
    private List<pA> Og;
    private pA pA;

    public pA pA() {
        return this.pA;
    }

    public List<pA> Og() {
        return this.Og;
    }

    public static class pA {
        private Map<String, String> KZx;
        private String Og;
        private String pA = "global";

        public String pA() {
            return this.pA;
        }

        public void pA(String str) {
            this.pA = str;
        }

        public String Og() {
            return this.Og;
        }

        public void Og(String str) {
            this.Og = str;
        }

        public Map<String, String> KZx() {
            return this.KZx;
        }

        public void pA(Map<String, String> map) {
            this.KZx = map;
        }

        public String toString() {
            return "Action{scheme='" + this.pA + "', name='" + this.Og + "', params=" + this.KZx + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static Og pA(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        Og og = new Og();
        String strOptString = jSONObject.optString(DebugKt.DEBUG_PROPERTY_VALUE_ON);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        og.pA = omh.pA(strOptString, jSONObject2);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            pA pAVarPA = omh.pA(jSONArrayOptJSONArray.optString(i), jSONObject2);
            if (pAVarPA != null) {
                arrayList.add(pAVarPA);
            }
        }
        og.Og = arrayList;
        return og;
    }
}
