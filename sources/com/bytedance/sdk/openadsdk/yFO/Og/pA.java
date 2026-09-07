package com.bytedance.sdk.openadsdk.yFO.Og;

import android.text.TextUtils;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    private List<C0259pA> KZx;
    private List<C0259pA> Og;
    private String pA;

    public void pA(String str) {
        this.pA = str;
    }

    public void pA(List<C0259pA> list) {
        this.Og = list;
    }

    public void Og(List<C0259pA> list) {
        this.KZx = list;
    }

    public String pA() {
        return this.pA;
    }

    public List<C0259pA> Og() {
        return this.Og;
    }

    public List<C0259pA> KZx() {
        return this.KZx;
    }

    public static pA Og(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
            pA pAVar = new pA();
            pAVar.pA(jSONObjectJsonObjectInit.optString("version"));
            JSONArray jSONArrayOptJSONArray = jSONObjectJsonObjectInit.optJSONArray("resources");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    C0259pA c0259pAPA = C0259pA.pA(jSONArrayOptJSONArray.optJSONObject(i));
                    if (c0259pAPA != null) {
                        if (c0259pAPA.KZx == 1) {
                            arrayList.add(c0259pAPA);
                        } else if (c0259pAPA.KZx == 2 && arrayList2.size() < 10) {
                            arrayList2.add(c0259pAPA);
                        }
                    }
                }
            }
            pAVar.pA(arrayList);
            pAVar.Og(arrayList2);
            return pAVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.yFO.Og.pA$pA, reason: collision with other inner class name */
    public static class C0259pA {
        private int KZx;
        private String Og;
        private String pA;

        public static C0259pA pA(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0259pA c0259pA = new C0259pA();
            c0259pA.pA = jSONObject.optString("url");
            c0259pA.Og = jSONObject.optString("md5");
            c0259pA.KZx = jSONObject.optInt("type");
            return c0259pA;
        }

        public String pA() {
            return this.pA;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0259pA) {
                String str2 = this.pA;
                if (str2 != null) {
                    C0259pA c0259pA = (C0259pA) obj;
                    if (str2.equals(c0259pA.pA) && (str = this.Og) != null && str.equals(c0259pA.Og)) {
                        return true;
                    }
                }
                return false;
            }
            return super.equals(obj);
        }
    }
}
