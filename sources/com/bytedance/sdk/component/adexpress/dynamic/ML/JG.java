package com.bytedance.sdk.component.adexpress.dynamic.ML;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.Og.Wx;
import com.facebook.internal.NativeProtocol;
import com.json.b9;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class JG {
    private static HashMap<String, String> SD;
    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.ZZv JG;
    private com.bytedance.sdk.component.adexpress.dynamic.ZZv.KZx KZx;
    private KZx ML;
    private JSONObject Og;
    private pA ZZv;
    private JSONObject pA;

    static {
        HashMap<String, String> map = new HashMap<>();
        SD = map;
        map.put("subtitle", "description");
        SD.put("source", "source|app.app_name");
        SD.put("screenshot", "dynamic_creative.screenshot");
    }

    public JG(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.pA = jSONObject;
        this.Og = jSONObject2;
        this.KZx = new com.bytedance.sdk.component.adexpress.dynamic.ZZv.KZx(jSONObject2);
        this.ZZv = pA.pA(jSONObject3);
        this.JG = com.bytedance.sdk.component.adexpress.dynamic.ZZv.ZZv.pA(jSONObject4);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh pA(double d, int i, double d2, String str, Wx wx) {
        JSONObject jSONObjectJsonObjectInit;
        this.KZx.pA();
        try {
            jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(this.JG.Og);
        } catch (JSONException unused) {
            jSONObjectJsonObjectInit = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVarPA = pA(ZZv.pA(this.pA, jSONObjectJsonObjectInit), (com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh) null);
        pA(omhVarPA);
        ML ml = new ML(d, i, d2, str, wx);
        ML.pA pAVar = new ML.pA();
        pAVar.pA = this.ZZv.pA;
        pAVar.Og = this.ZZv.Og;
        pAVar.KZx = 0.0f;
        ml.pA(pAVar);
        ml.pA(omhVarPA, 0.0f, 0.0f);
        ml.pA();
        if (ml.pA.ZZv == 65536.0f) {
            return null;
        }
        return ml.pA.JG;
    }

    private void pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        int iPA;
        if (omhVar == null) {
            return;
        }
        if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx() != null) {
            iPA = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().DX();
        } else {
            iPA = com.bytedance.sdk.component.adexpress.ZZv.omh.pA(com.bytedance.sdk.component.adexpress.ZZv.pA());
        }
        float fMin = this.ZZv.KZx ? this.ZZv.pA : Math.min(this.ZZv.pA, com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), iPA));
        if (this.ZZv.Og == 0.0f) {
            omhVar.ML(fMin);
            omhVar.SGo().ML().SGo("auto");
            omhVar.JG(0.0f);
        } else {
            omhVar.ML(fMin);
            omhVar.JG(this.ZZv.KZx ? this.ZZv.Og : Math.min(this.ZZv.Og, com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA()))));
            omhVar.SGo().ML().SGo("fixed");
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh pA(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.equals(strOptString, "custom-component-vessel")) {
            int iOptInt = jSONObject.optInt("componentId");
            if (this.JG != null) {
                KZx kZx = new KZx();
                this.ML = kZx;
                JSONObject jSONObjectPA = kZx.pA(this.JG.pA, iOptInt, jSONObject);
                if (jSONObjectPA != null) {
                    jSONObject = jSONObjectPA;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVarPA = pA(jSONObject);
        omhVarPA.pA(omhVar);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null) {
            omhVarPA.pA((List<com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh>) null);
            return omhVarPA;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(strOptString, "tag-group")) {
                    length = omhVarPA.SGo().ML().Wo();
                } else {
                    length = jSONArrayOptJSONArray2.length();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVarPA2 = pA(jSONArrayOptJSONArray2.optJSONObject(i2), omhVarPA);
                    if (com.bytedance.sdk.component.adexpress.ZZv.Og() && "skip-with-time".equals(omhVarPA.SGo().Og()) && !b9.h.T.equals(omhVarPA.BF()) && !TextUtils.isEmpty(omhVarPA.BF())) {
                        omhVarPA2.KZx(omhVarPA.BF());
                    }
                    arrayList.add(omhVarPA2);
                    arrayList3.add(omhVarPA2);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            omhVarPA.pA(arrayList);
        }
        if (arrayList2.size() > 0) {
            omhVarPA.Og(arrayList2);
        }
        return omhVarPA;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh pA(JSONObject jSONObject) {
        String strPA;
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        Bzk.pA(strOptString, jSONObjectOptJSONObject);
        JSONObject jSONObjectPA = Bzk.pA(strOptString, Bzk.pA(jSONObject.optJSONArray("sceneValues")), jSONObjectOptJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar = new com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh();
        if (TextUtils.isEmpty(strOptString2)) {
            omhVar.Og(String.valueOf(omhVar.hashCode()));
        } else {
            omhVar.Og(strOptString2);
        }
        if (jSONObjectOptJSONObject != null) {
            Og(omhVar);
            omhVar.KZx((float) jSONObjectOptJSONObject.optDouble(VastAttributes.HORIZONTAL_POSITION));
            omhVar.ZZv((float) jSONObjectOptJSONObject.optDouble(VastAttributes.VERTICAL_POSITION));
            omhVar.ML((float) jSONObjectOptJSONObject.optDouble("width"));
            omhVar.JG((float) jSONObjectOptJSONObject.optDouble("height"));
            omhVar.SD(jSONObjectOptJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.ML ml = new com.bytedance.sdk.component.adexpress.dynamic.ZZv.ML();
            ml.pA(strOptString);
            ml.Og(jSONObjectOptJSONObject.optString("data"));
            ml.KZx(jSONObjectOptJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgPA = com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG.pA(jSONObjectOptJSONObject);
            ml.pA(jgPA);
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgPA2 = com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG.pA(jSONObjectPA);
            if (jgPA2 == null) {
                ml.Og(jgPA);
            } else {
                ml.Og(jgPA2);
            }
            pA(jgPA);
            pA(jgPA2);
            if (TextUtils.equals(strOptString, "video-image-budget") && (jSONObject2 = this.Og) != null) {
                pA(ml, jSONObject2.optInt("image_mode"));
            }
            String strOg = ml.Og();
            com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML = ml.ML();
            if (SD.containsKey(strOg) && !jgML.dC()) {
                jgML.vZF(SD.get(strOg));
            }
            if (jgML.dC()) {
                strPA = ml.KZx();
            } else {
                strPA = pA(ml.KZx());
            }
            if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
                if (TextUtils.equals(strOg, "star") || TextUtils.equals(strOg, "text_star")) {
                    strPA = pA("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(strOg, "score-count") || TextUtils.equals(strOg, "score-count-type-1") || TextUtils.equals(strOg, "score-count-type-2")) {
                    strPA = pA("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(strOg) && jgPA.ka()) {
                    strPA = pA("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(pA()) && (TextUtils.equals("logo-union", strOptString) || TextUtils.equals("logo", strOptString))) {
                ml.Og(strPA + "adx:" + pA());
            } else {
                ml.Og(strPA);
            }
            omhVar.pA(ml);
        }
        return omhVar;
    }

    private void Og(com.bytedance.sdk.component.adexpress.dynamic.ZZv.omh omhVar) {
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.KZx kZx;
        Object objPA;
        Object objPA2;
        Object objPA3;
        Object objPA4;
        if (omhVar == null || (kZx = this.KZx) == null || (objPA = kZx.pA("image.0.url")) == null) {
            return;
        }
        String strValueOf = String.valueOf(objPA);
        if (TextUtils.isEmpty(strValueOf) || (objPA2 = this.KZx.pA("title")) == null) {
            return;
        }
        String strValueOf2 = String.valueOf(objPA2);
        if (TextUtils.isEmpty(strValueOf2) || (objPA3 = this.KZx.pA("description")) == null) {
            return;
        }
        String strValueOf3 = String.valueOf(objPA3);
        if (TextUtils.isEmpty(strValueOf3) || (objPA4 = this.KZx.pA("icon")) == null) {
            return;
        }
        String strValueOf4 = String.valueOf(objPA4);
        if (TextUtils.isEmpty(strValueOf4)) {
            return;
        }
        Object objPA5 = this.KZx.pA("app.app_name");
        Object objPA6 = this.KZx.pA("source");
        if (objPA5 == null && objPA6 == null) {
            return;
        }
        if (objPA5 == null) {
            objPA5 = objPA6;
        }
        String strValueOf5 = String.valueOf(objPA5);
        if (TextUtils.isEmpty(strValueOf5)) {
            return;
        }
        omhVar.pA(UnifiedMediationParams.KEY_IMAGE_URL, strValueOf);
        omhVar.pA("title", strValueOf2);
        omhVar.pA("description", strValueOf3);
        omhVar.pA("icon", strValueOf4);
        omhVar.pA(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, strValueOf5);
        omhVar.pA(true);
    }

    private void pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.ML ml, int i) {
        int iLastIndexOf;
        if (i == 5 || i == 15 || i == 50 || i == 154) {
            ml.pA("video");
            String strPA = Bzk.pA("video");
            ml.ML().vZF(strPA);
            String strPA2 = Bzk.pA("video", "clickArea");
            if (!TextUtils.isEmpty(strPA2)) {
                ml.ML().DX(strPA2);
                ml.SD().DX(strPA2);
            }
            ml.SD().vZF(strPA);
            ml.Og(strPA);
            ml.ML().mY();
            return;
        }
        ml.pA("image");
        String strPA3 = Bzk.pA("image");
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jgML = ml.ML();
        jgML.vZF(strPA3);
        ml.SD().vZF(strPA3);
        String strPA4 = Bzk.pA("image", "clickArea");
        if (!TextUtils.isEmpty(strPA4)) {
            jgML.DX(strPA4);
            ml.SD().DX(strPA4);
        }
        JSONObject jSONObjectBDQ = jgML.BDQ();
        if (jSONObjectBDQ != null) {
            jgML.BF(jSONObjectBDQ.optString("imageLottieTosPath"));
            jgML.WV(jSONObjectBDQ.optBoolean("animationsLoop"));
            jgML.du(jSONObjectBDQ.optInt("lottieAppNameMaxLength"));
            jgML.roi(jSONObjectBDQ.optInt("lottieAdDescMaxLength"));
            jgML.eG(jSONObjectBDQ.optInt("lottieAdTitleMaxLength"));
        }
        ml.Og(strPA3);
        if (strPA3 != null && (iLastIndexOf = strPA3.lastIndexOf(".")) > 0) {
            String strSubstring = strPA3.substring(0, iLastIndexOf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", pA(strSubstring + ".width"));
                jSONObject.put("height", pA(strSubstring + ".height"));
            } catch (JSONException unused) {
            }
            ml.KZx(jSONObject.toString());
        }
        jgML.Tsy();
    }

    private String pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.KZx.Og(str2)) {
                String strValueOf = String.valueOf(this.KZx.pA(str2));
                if (!TextUtils.isEmpty(strValueOf)) {
                    return strValueOf;
                }
            }
        }
        return "";
    }

    private String pA() {
        com.bytedance.sdk.component.adexpress.dynamic.ZZv.KZx kZx = this.KZx;
        if (kZx == null) {
            return "";
        }
        return String.valueOf(kZx.pA("adx_name"));
    }

    private void pA(com.bytedance.sdk.component.adexpress.dynamic.ZZv.JG jg) {
        if (jg == null) {
            return;
        }
        String strMc = jg.Mc();
        if (com.bytedance.sdk.component.adexpress.ZZv.Og()) {
            String strKZx = com.bytedance.sdk.component.adexpress.ZZv.omh.KZx(com.bytedance.sdk.component.adexpress.ZZv.pA());
            if ("zh".equals(strKZx)) {
                strKZx = "cn";
            }
            if (!TextUtils.isEmpty(strKZx) && jg.JG() != null) {
                String strOptString = jg.JG().optString(strKZx);
                if (!TextUtils.isEmpty(strOptString)) {
                    strMc = strOptString;
                }
            }
        }
        if (TextUtils.isEmpty(strMc)) {
            return;
        }
        int iIndexOf = strMc.indexOf("{{");
        int iIndexOf2 = strMc.indexOf("}}");
        if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf2 < iIndexOf) {
            jg.WV(strMc);
            return;
        }
        String strPA = pA(strMc.substring(iIndexOf + 2, iIndexOf2));
        StringBuilder sb = new StringBuilder(strMc.substring(0, iIndexOf));
        if (!TextUtils.isEmpty(strPA)) {
            sb.append(strPA);
        }
        sb.append(strMc.substring(iIndexOf2 + 2));
        jg.WV(sb.toString());
    }

    static class pA {
        boolean KZx;
        float Og;
        float pA;

        public static pA pA(JSONObject jSONObject) {
            pA pAVar = new pA();
            if (jSONObject != null) {
                pAVar.pA = (float) jSONObject.optDouble("width");
                pAVar.Og = (float) jSONObject.optDouble("height");
                pAVar.KZx = jSONObject.optBoolean("isLandscape");
            }
            return pAVar;
        }
    }
}
