package com.bytedance.sdk.openadsdk.core.omh.pA;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.BSW.ML.KZx;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.IG;
import com.bytedance.sdk.openadsdk.core.WV;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.DX;
import com.bytedance.sdk.openadsdk.core.model.eG;
import com.bytedance.sdk.openadsdk.core.model.oX;
import com.bytedance.sdk.openadsdk.core.model.vZF;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class Og {
    private static String Og = "";
    public static String pA = "https://pag_open_icon_id/appicon.png";

    public static boolean Og() {
        return true;
    }

    public static String pA() {
        return Og;
    }

    public static JSONObject pA(float f, float f2, boolean z, yFO yfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", f);
            jSONObject2.put("height", f2);
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            if ((yfo instanceof vZF) && ((vZF) yfo).PF()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject.put("choose_ui_data", jSONObject3);
                com.bytedance.sdk.openadsdk.core.model.pA.C0245pA c0245pAPUz = ((vZF) yfo).pUz();
                JSONObject jSONObjectOg = c0245pAPUz.Og();
                if (TextUtils.isEmpty(c0245pAPUz.Bzk())) {
                    jSONObjectOg.put("data", Og(c0245pAPUz));
                }
                jSONObject3.put("tpl_info", jSONObjectOg);
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("creatives", jSONArray);
                for (yFO yfo2 : ((vZF) yfo).tfE()) {
                    JSONObject jSONObjectPA = pA(false, yfo2);
                    if (jSONObjectPA != null) {
                        jSONObjectPA.put("template_Plugin", Og(yfo2.CIG()));
                        jSONObjectPA.put("diff_template_Plugin", pA(yfo2.CIG()));
                        jSONArray.put(jSONObjectPA);
                    }
                }
                return jSONObject;
            }
            jSONObject.put(Reporting.Key.CREATIVE, pA(false, yfo));
            jSONObject.put("template_Plugin", Og(yfo.CIG()));
            jSONObject.put("diff_template_Plugin", pA(yfo.CIG()));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject pA(float f, float f2, boolean z, yFO yfo, String str, KZx kZx) {
        Og = "";
        JSONObject jSONObjectJO = null;
        if (yfo == null) {
            return null;
        }
        try {
            jSONObjectJO = yfo.jO();
            pA(jSONObjectJO, yfo, str);
            JSONObject jSONObjectOg = IG.Og(yfo);
            jSONObjectOg.put(POBConstants.KEY_LANGUAGE, WV.Og());
            jSONObjectJO.put("xSetting", jSONObjectOg);
            jSONObjectJO.put("xAdInfo", pA(str, Og(yfo), yfo));
            JSONObject jSONObject = new JSONObject();
            IG.Og(jSONObject);
            jSONObject.put("platform", "android");
            jSONObjectJO.put("xAppInfo", jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", f);
            jSONObject2.put("height", f2);
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObjectJO.put("xSize", jSONObject2);
            kZx.pA("adv3");
            eG eGVarFQ = yfo.FQ();
            if (eGVarFQ != null) {
                String strZZv = eGVarFQ.ZZv();
                if (!TextUtils.isEmpty(strZZv)) {
                    jSONObjectJO.put("xTemplate", PangleNetworkBridge.jsonObjectInit(strZZv));
                    Og = "getTemplate success by local data";
                    kZx.Og("local");
                } else {
                    String strPA = com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA().pA("adv3", eGVarFQ.pA(), eGVarFQ.Og());
                    if (!TextUtils.isEmpty(strPA)) {
                        jSONObjectJO.put("xTemplate", PangleNetworkBridge.jsonObjectInit(strPA));
                        Og = "getTemplate success by db data";
                        kZx.Og("local");
                    } else {
                        String str2 = "local db data is null id is " + eGVarFQ.pA() + " md5 is " + eGVarFQ.Og();
                        Og = str2;
                        kZx.pA(3, str2, "net");
                    }
                }
            }
        } catch (Exception e) {
            String str3 = "load template exception " + e.getMessage();
            Og = str3;
            kZx.pA(3, str3, "net");
        }
        return jSONObjectJO;
    }

    private static void pA(JSONObject jSONObject, yFO yfo, String str) {
        com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf;
        if (yfo == null || jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("h265_video")) {
                jSONObject.remove("h265_video");
            }
            if (!jSONObject.has("video") || (ogBf = yfo.Bf()) == null) {
                return;
            }
            JSONObject jSONObjectXT = ogBf.XT();
            if (jSONObjectXT != null) {
                if ("open_ad".equals(str)) {
                    jSONObjectXT.put("video_duration", aBv.ZZv().BF(String.valueOf(yfo.Wf())));
                } else {
                    jSONObjectXT.put("video_duration", ogBf.JG() * ((double) ogBf.TX()));
                }
            }
            jSONObject.put("video", jSONObjectXT);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static JSONObject pA(String str, JSONObject jSONObject, yFO yfo) {
        if (yfo == null) {
            return jSONObject;
        }
        try {
            if ("open_ad".equals(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, Bzk.Og().JG());
                int iSD = Bzk.Og().SD();
                if (iSD != 0) {
                    int iDu = yfo.du();
                    if (9 == iDu) {
                        jSONObject2.put("app_icon", pA);
                    } else if (10 == iDu) {
                        jSONObject2.put("app_icon", "@".concat(String.valueOf(iSD)));
                    }
                }
                jSONObject.put("open_app_info", jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject pA(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject3;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(UserMetadata.KEYDATA_FILENAME);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (jSONObject.has(strOptString)) {
                        jSONObject3.put(strOptString, jSONObject.opt(strOptString));
                    }
                }
                jSONObject3.put("xSetting", jSONObject.opt("xSetting"));
                jSONObject3.put("xAdInfo", jSONObject.opt("xAdInfo"));
                jSONObject3.put("xAppInfo", jSONObject.opt("xAppInfo"));
                jSONObject3.put("xSize", jSONObject.opt("xSize"));
                jSONObject3.put("xTemplate", jSONObject.opt("xTemplate"));
                return jSONObject3;
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static JSONObject Og(yFO yfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            IG.pA(jSONObject, yfo);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static String pA(yFO.pA pAVar) {
        if (pAVar == null) {
            return "";
        }
        return pAVar.SGo();
    }

    private static String Og(yFO.pA pAVar) {
        com.bytedance.sdk.component.adexpress.pA.KZx.Og ogKZx;
        if (pAVar == null) {
            return "";
        }
        String strBzk = pAVar.Bzk();
        return (!TextUtils.isEmpty(strBzk) || (ogKZx = com.bytedance.sdk.component.adexpress.pA.Og.Og.KZx(pAVar.JG())) == null) ? strBzk : ogKZx.ML();
    }

    public static JSONObject pA(boolean z, yFO yfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", yfo.gy());
            if (yfo.fJy() != null) {
                if (yfo.fJy() != null && !TextUtils.isEmpty(yfo.fJy().pA())) {
                    jSONObject.put("icon", yfo.fJy().pA());
                } else {
                    jSONObject.put("icon", "");
                }
            }
            JSONArray jSONArray = new JSONArray();
            if (yfo.IIF() != null) {
                for (int i = 0; i < yfo.IIF().size(); i++) {
                    DX dx = yfo.IIF().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", dx.KZx());
                    jSONObject2.put("width", dx.Og());
                    jSONObject2.put("url", dx.pA());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", yfo.RS());
            jSONObject.put("interaction_type", yfo.JBA());
            jSONObject.put("interaction_method", yfo.XT());
            jSONObject.put("is_compliance_template", Og());
            jSONObject.put("title", yfo.SXO());
            jSONObject.put("description", yfo.fw());
            jSONObject.put("source", yfo.HSv());
            JSONObject jSONObject3 = new JSONObject();
            oX oXVarSGo = yfo.SGo();
            if (oXVarSGo == null) {
                oXVarSGo = new oX();
            }
            jSONObject3.put("ceiling_time", oXVarSGo.pA());
            jSONObject3.put("ceiling_ratio", oXVarSGo.Og());
            jSONObject3.put("expand_ratio", oXVarSGo.KZx());
            jSONObject.put("interaction_params", jSONObject3);
            if (yfo.Wo() != null) {
                jSONObject.put("comment_num", yfo.Wo().ML());
                jSONObject.put("score", yfo.Wo().ZZv());
                jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, yfo.Wo().JG());
                jSONObject.put("app", yfo.Wo().omh());
            }
            com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = yfo.Bf();
            if (ogBf != null) {
                JSONObject jSONObjectXT = ogBf.XT();
                jSONObjectXT.put("video_duration", ogBf.JG() * ((double) ogBf.TX()));
                jSONObject.put("video", jSONObjectXT);
            }
            if (yfo.CIG() != null) {
                jSONObject.put("dynamic_creative", yfo.CIG().BSW());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String pA(yFO yfo, String str) {
        List<DX> listIIF;
        if (yfo != null && (listIIF = yfo.IIF()) != null && listIIF.size() > 0) {
            for (DX dx : listIIF) {
                if (dx != null && TextUtils.equals(str, dx.pA())) {
                    return dx.SD();
                }
            }
        }
        return null;
    }

    public static Map<String, String> pA(yFO yfo) {
        HashMap map = null;
        if (yfo == null) {
            return null;
        }
        List<DX> listIIF = yfo.IIF();
        if (listIIF != null && listIIF.size() > 0) {
            map = new HashMap();
            for (DX dx : listIIF) {
                if (dx != null) {
                    map.put(dx.pA(), dx.SD());
                }
            }
            DX dxFJy = yfo.fJy();
            if (dxFJy != null) {
                map.put(dxFJy.pA(), dxFJy.SD());
            }
        }
        return map;
    }
}
