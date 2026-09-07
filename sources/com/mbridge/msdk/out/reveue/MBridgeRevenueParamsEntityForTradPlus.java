package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import com.json.ao;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class MBridgeRevenueParamsEntityForTradPlus extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForTradPlus(String str, String str2) {
        super(str, str2);
        setMediationName("TradPlus");
    }

    @Override // com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity
    public void setDspInfo(String str, String str2) {
        super.setDspInfo(str, str2);
    }

    public void setTradPlusAdInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String strReplace = str.replace("\"", "\\\"").replace("----------------------\n", "{\"").replaceAll("(?<!\"):(?!\")", "\":\"").replace("\n", "\",\"");
                JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(strReplace.endsWith("\"") ? (strReplace + "}").replace(",\"}", "}") : strReplace + "\"}");
                setAdType(jSONObjectJsonObjectInit.optInt("placementAdType") + "");
                setMediationUnitId(jSONObjectJsonObjectInit.optString("tpAdUnitId"));
                setNetworkName(jSONObjectJsonObjectInit.optString(ao.f3531a));
                setBidType(Boolean.valueOf(jSONObjectJsonObjectInit.optBoolean("isBiddingNetwork", false)));
                setRevenue(jSONObjectJsonObjectInit.optString("ecpm", ""));
                setPrecision(jSONObjectJsonObjectInit.optString("ecpmPrecision", ""));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("instanceName", jSONObjectJsonObjectInit.optString(ao.f3531a, ""));
                jSONObject.put("instanceId", jSONObjectJsonObjectInit.optString("adSourceId", ""));
                setNetworkInfo(jSONObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setSourceData(str, str);
    }
}
