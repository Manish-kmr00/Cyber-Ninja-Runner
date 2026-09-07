package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.json.cc;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.i0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.Campaign;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DomainCampaignEx extends Campaign {
    private static final String JSON_KEY_AD_TRACKING_DLE = "D+S8+FxXJFPsYFc3+F5/Hv==";
    private static final String JSON_KEY_AD_TRACKING_DLS = "D+S8+FxXJFPsYFc3+bfTD+zT";
    private static final String JSON_KEY_AD_TRACKING_I = "D+S8+FQ/hbxtY7M=";
    public static final String KEY_BIND_ID = "bind_id";
    public static final String KEY_GH_ID = "gh_id";
    public static final String KEY_GH_PATH = "gh_path";
    private static String TAG = "DomainCampaignEx";
    private String bindId;
    private String ghId;
    private String ghPath;

    public static JSONObject campaignToJsonObject(JSONObject jSONObject, CampaignEx campaignEx) throws JSONException {
        return jSONObject;
    }

    public static JSONObject object2TrackingStr(JSONObject jSONObject, j jVar) {
        if (jSONObject == null || jVar == null) {
            return null;
        }
        try {
            if (jVar.v() != null) {
                jSONObject.put(i0.a(JSON_KEY_AD_TRACKING_DLS), CampaignEx.processNativeVideoTrackingArray2Json(jVar.v()));
            }
            if (jVar.u() != null) {
                jSONObject.put(i0.a(JSON_KEY_AD_TRACKING_DLE), CampaignEx.processNativeVideoTrackingArray2Json(jVar.u()));
            }
            if (jVar.w() != null) {
                jSONObject.put(i0.a(JSON_KEY_AD_TRACKING_I), CampaignEx.processNativeVideoTrackingArray2Json(jVar.w()));
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("DomainCampaignEx", e.getMessage(), e);
            }
        }
        return jSONObject;
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, CampaignEx campaignEx) {
        String strOptString = jSONObject.optString(KEY_GH_ID);
        if (!TextUtils.isEmpty(strOptString)) {
            campaignEx.setGhId(strOptString);
            String strOptString2 = jSONObject.optString(KEY_GH_PATH);
            if (!TextUtils.isEmpty(strOptString2)) {
                campaignEx.setGhPath(i0.a(strOptString2));
            }
            campaignEx.setBindId(jSONObject.optString(KEY_BIND_ID));
        }
        return campaignEx;
    }

    public static CampaignEx parseCampaignWithBackData(JSONObject jSONObject, CampaignEx campaignEx) {
        String strOptString = jSONObject.optString(KEY_GH_ID);
        if (!TextUtils.isEmpty(strOptString)) {
            campaignEx.setGhId(strOptString);
            String strOptString2 = jSONObject.optString(KEY_GH_PATH);
            if (!TextUtils.isEmpty(strOptString2)) {
                campaignEx.setGhPath(i0.a(strOptString2));
            }
            campaignEx.setBindId(jSONObject.optString(KEY_BIND_ID));
        }
        return campaignEx;
    }

    protected static String replaceValueByKey(CampaignUnit campaignUnit, CampaignEx campaignEx, String str) {
        if (campaignUnit == null || TextUtils.isEmpty(str) || campaignEx == null) {
            return str;
        }
        try {
            HashMap<String, String> rks = campaignUnit.getRks();
            if (rks != null) {
                rks.entrySet().iterator();
                for (Map.Entry<String, String> entry : rks.entrySet()) {
                    str = str.replaceAll("\\{" + entry.getKey() + "\\}", entry.getValue());
                }
            }
            HashMap<String, String> aks = campaignEx.getAks();
            if (aks != null) {
                aks.entrySet().iterator();
                for (Map.Entry<String, String> entry2 : aks.entrySet()) {
                    str = str.replaceAll("\\{" + entry2.getKey() + "\\}", entry2.getValue());
                }
            }
            HashMap<String, String> epMap = campaignUnit.getEpMap();
            if (epMap != null) {
                for (Map.Entry<String, String> entry3 : epMap.entrySet()) {
                    str = str.replaceAll("\\{" + entry3.getKey() + "\\}", entry3.getValue());
                }
            }
            return str.replaceAll("\\{c\\}", URLEncoder.encode(campaignUnit.assembCParams(), cc.N));
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                o0.b("DomainCampaignEx", th.getMessage(), th);
            }
            return str;
        }
    }

    public static j trackingStr2Object(JSONObject jSONObject, j jVar) {
        if (jSONObject == null || jVar == null) {
            return null;
        }
        try {
            jVar.u(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(i0.a(JSON_KEY_AD_TRACKING_DLS))));
            jVar.t(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(i0.a(JSON_KEY_AD_TRACKING_DLE))));
            jVar.v(CampaignEx.processNativeVideoTrackingArray(jSONObject.optJSONArray(i0.a(JSON_KEY_AD_TRACKING_I))));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                o0.b("DomainCampaignEx", e.getMessage(), e);
            }
        }
        return jVar;
    }

    @Deprecated
    public String getBindId() {
        return this.bindId;
    }

    public String getGhId() {
        return this.ghId;
    }

    public String getGhPath() {
        return this.ghPath;
    }

    public boolean needShowIDialog(CampaignEx campaignEx) {
        return false;
    }

    public void setBindId(String str) {
        this.bindId = str;
    }

    public void setGhId(String str) {
        this.ghId = str;
    }

    public void setGhPath(String str) {
        this.ghPath = str;
    }
}
