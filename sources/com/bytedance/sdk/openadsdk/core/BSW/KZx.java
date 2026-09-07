package com.bytedance.sdk.openadsdk.core.BSW;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.WV;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class KZx {
    private static String pA = "";

    public static boolean pA(int i) {
        return i == 10 || i == 9;
    }

    public static JSONObject pA(yFO yfo, String str) {
        JSONObject jSONObjectJO = yfo.jO();
        try {
            jSONObjectJO.put("show_dislike", yfo.uQ());
            jSONObjectJO.put(POBConstants.KEY_LANGUAGE, WV.Og());
            if ("open_ad".equals(str)) {
                JSONObject jSONObject = new JSONObject();
                String strJG = Bzk.Og().JG();
                int iSD = Bzk.Og().SD();
                jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, strJG);
                jSONObject.put("app_icon_id", "@".concat(String.valueOf(iSD)));
                jSONObjectJO.put("open_app_info", jSONObject);
            }
            jSONObjectJO.put("os", "Android");
            JSONArray jSONArrayKZx = KZx(yfo);
            if (jSONArrayKZx != null) {
                jSONObjectJO.put("dpa_data", jSONArrayKZx);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("UgenUtils", "parseUGenDataInfo exception", th.getMessage());
        }
        return jSONObjectJO;
    }

    private static JSONArray KZx(yFO yfo) {
        try {
            yFO.pA pAVarCIG = yfo.CIG();
            if (pAVarCIG == null) {
                return null;
            }
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(pAVarCIG.BSW());
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("original_price", Double.valueOf(jSONObjectJsonObjectInit.optDouble("original_price", 0.0d)));
            jSONObject.putOpt("price_unit", jSONObjectJsonObjectInit.optString("price_unit"));
            jSONObject.putOpt(FirebaseAnalytics.Param.DISCOUNT, Double.valueOf(jSONObjectJsonObjectInit.optDouble(FirebaseAnalytics.Param.DISCOUNT, 0.0d)));
            jSONObject.putOpt("product_name", jSONObjectJsonObjectInit.optString("dpa_product_name"));
            jSONObject.putOpt("description", jSONObjectJsonObjectInit.optString("dpa_description"));
            JSONArray jSONArrayOptJSONArray = jSONObjectJsonObjectInit.optJSONArray("dpa_images");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                jSONObject.putOpt("image", jSONArrayOptJSONArray.get(0));
            }
            jSONObject.putOpt("brand_name", jSONObjectJsonObjectInit.optString("dpa_brand_name"));
            jSONObject.putOpt("sale_price_i18n", Integer.valueOf(jSONObjectJsonObjectInit.optInt("sale_price_i18n")));
            jSONObject.putOpt("real_price", Double.valueOf(jSONObjectJsonObjectInit.optDouble("real_price", 0.0d)));
            jSONObject.put("button_text", yfo.gy());
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArrayOptJSONArray2 = jSONObjectJsonObjectInit.optJSONArray("dpa_related_products");
            if (jSONArrayOptJSONArray2 != null) {
                jSONArray.put(jSONObject);
                for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i);
                        jSONObject2.put("button_text", yfo.gy());
                        jSONArray.put(jSONObject2);
                    } catch (Throwable unused) {
                    }
                }
            }
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static boolean pA(yFO yfo) {
        return yfo != null && yfo.du() == 7;
    }

    public static String pA() {
        return pA;
    }

    public static boolean Og(yFO yfo) {
        return yfo != null && yfo.du() == 10;
    }

    public static JSONObject pA(yFO yfo, com.bytedance.sdk.openadsdk.core.BSW.ML.KZx kZx) {
        JSONObject jSONObjectJsonObjectInit;
        kZx.pA(Reporting.Key.CLICK_SOURCE_TYPE_AD);
        String strABv = "";
        pA = "";
        JSONObject jSONObject = null;
        try {
            yFO.pA pAVarCIG = yfo.CIG();
            if (pAVarCIG != null) {
                strABv = pAVarCIG.aBv();
                if (TextUtils.isEmpty(strABv) && !TextUtils.isEmpty(pAVarCIG.oX()) && !TextUtils.isEmpty(pAVarCIG.JG())) {
                    strABv = com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA().pA(Reporting.Key.CLICK_SOURCE_TYPE_AD, pAVarCIG.JG(), pAVarCIG.oX());
                }
            }
            if (!TextUtils.isEmpty(strABv)) {
                try {
                    jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strABv);
                    try {
                        try {
                            pA = "getTemplate success";
                            kZx.Og("local");
                            return jSONObjectJsonObjectInit;
                        } catch (Throwable th) {
                            jSONObject = jSONObjectJsonObjectInit;
                            th = th;
                            String str = "get template error " + th.getMessage();
                            pA = str;
                            kZx.pA(2, str, "local");
                            return jSONObject;
                        }
                    } catch (JSONException unused) {
                        String strConcat = "parse json exception data is ".concat(String.valueOf(strABv));
                        pA = strConcat;
                        kZx.pA(2, strConcat, "local");
                        return null;
                    }
                } catch (JSONException unused2) {
                    jSONObjectJsonObjectInit = null;
                }
            } else {
                String str2 = "local data is null id is " + pAVarCIG.JG() + " md5 is " + pAVarCIG.oX();
                pA = str2;
                kZx.pA(3, str2, "net");
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
