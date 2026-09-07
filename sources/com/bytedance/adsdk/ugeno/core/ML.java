package com.bytedance.adsdk.ugeno.core;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidEnvironmentProperties;
import com.smaato.sdk.video.vast.model.Ad;
import io.bidmachine.iab.vast.tags.VastTagName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ML {
    private JSONObject JG;
    private String KZx;
    private String ML;
    private JSONObject Og;
    private boolean SD;
    private JSONObject ZZv;
    private JSONObject pA;

    public ML(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public ML(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null) {
            if (jSONObject.has("body")) {
                this.pA = jSONObject.optJSONObject("body");
            } else {
                this.pA = jSONObject.optJSONObject("main_template");
            }
            this.Og = jSONObject.optJSONObject("sub_templates");
            if (jSONObject.has(Constants.REFERRER_API_META)) {
                jSONObjectOptJSONObject = jSONObject.optJSONObject(Constants.REFERRER_API_META);
            } else {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
            }
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has("body")) {
                    this.SD = true;
                    String strOptString = jSONObjectOptJSONObject.optString("version");
                    this.KZx = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.KZx = MraidEnvironmentProperties.VERSION;
                    }
                } else {
                    this.KZx = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has(Ad.AD_TYPE)) {
                    this.ML = jSONObjectOptJSONObject.optString(Ad.AD_TYPE);
                }
            } else if (jSONObject.has("body")) {
                this.KZx = MraidEnvironmentProperties.VERSION;
                this.SD = true;
            }
            this.ZZv = jSONObject2;
            this.JG = jSONObject3;
        }
    }

    public pA pA() {
        return pA(this.pA, (pA) null);
    }

    public String Og() {
        return this.KZx;
    }

    public List<pA> KZx() {
        if (this.Og == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.Og.keys();
        while (itKeys.hasNext()) {
            pA pAVarPA = pA(this.Og.optJSONObject(itKeys.next()), (pA) null);
            if (pAVarPA != null) {
                arrayList.add(pAVarPA);
            }
        }
        return arrayList;
    }

    private pA pA(JSONObject jSONObject, pA pAVar) {
        String strOptString;
        String strOptString2;
        pA pAVarPA;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("type")) {
            strOptString = jSONObject.optString("type");
        } else {
            strOptString = jSONObject.optString("name");
        }
        String strOptString3 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
        pA pAVar2 = new pA();
        pAVar2.pA = strOptString3;
        if (!this.SD || !TextUtils.equals(VastTagName.VIDEO, strOptString)) {
            pAVar2.Og = strOptString;
        } else {
            pAVar2.Og = strOptString + "V3";
        }
        pAVar2.KZx = jSONObject2;
        pAVar2.JG = pAVar;
        pAVar2.SD = this.KZx;
        pAVar2.omh = this.ML;
        if (jSONObject2.has("i18n")) {
            pAVar2.ZZv = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            pA(jSONObject, pAVar2.KZx);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObject.has("type")) {
                    strOptString2 = jSONObject.optString("type");
                } else {
                    strOptString2 = jSONObject.optString("name");
                }
                String strPA = com.bytedance.adsdk.ugeno.KZx.Og.pA(jSONObjectOptJSONObject.optString("id"), this.ZZv);
                if (TextUtils.equals(strOptString2, "Template")) {
                    JSONObject jSONObject3 = this.Og;
                    if (jSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObject3.optJSONObject(strPA);
                        pAVarPA = pA(jSONObjectOptJSONObject, pAVar2);
                    } else {
                        pAVarPA = null;
                    }
                } else {
                    pAVarPA = pA(jSONObjectOptJSONObject, pAVar2);
                }
                if (pAVarPA != null) {
                    pAVar2.pA(pAVarPA);
                }
            }
        }
        return pAVar2;
    }

    public boolean ZZv() {
        return this.SD;
    }

    private void pA(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.JG == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.JG.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("targetProps");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObjectOptJSONObject.opt(next);
                    if (TextUtils.equals(next, "events") && jSONObject3.has("events")) {
                        if (objOpt instanceof JSONArray) {
                            com.bytedance.adsdk.ugeno.SD.Og.pA(jSONObject3.optJSONArray("events"), (JSONArray) objOpt);
                        }
                    } else {
                        jSONObject3.put(next, objOpt);
                    }
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", jSONArrayOptJSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    public static boolean pA(pA pAVar) {
        return (pAVar == null || pAVar.KZx == null) ? false : true;
    }

    public static class pA {
        private pA JG;
        private JSONObject KZx;
        private List<pA> ML;
        private String Og;
        private String SD;
        private JSONObject ZZv;
        private String omh;
        private String pA;

        public String pA() {
            return this.pA;
        }

        public String Og() {
            return this.SD;
        }

        public String KZx() {
            return this.Og;
        }

        public void pA(String str) {
            this.Og = str;
        }

        public JSONObject ZZv() {
            return this.KZx;
        }

        public List<pA> ML() {
            return this.ML;
        }

        public void pA(pA pAVar) {
            if (this.ML == null) {
                this.ML = new ArrayList();
            }
            this.ML.add(pAVar);
        }

        public JSONObject JG() {
            return this.ZZv;
        }

        public String toString() {
            return "UGNode{id='" + this.pA + "', name='" + this.Og + "'}";
        }
    }
}
