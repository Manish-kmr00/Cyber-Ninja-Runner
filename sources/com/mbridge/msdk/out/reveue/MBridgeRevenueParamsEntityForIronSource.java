package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class MBridgeRevenueParamsEntityForIronSource extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForIronSource(String str, String str2) {
        super(str, str2);
        setMediationName("IronSource");
    }

    @Override // com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity
    public void setDspInfo(String str, String str2) {
        super.setDspInfo(str, str2);
    }

    public void setIronSourceImpressionDataString(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setMediationUnitId(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = "{" + str2 + "}";
        try {
            setSourceData(str3, str3);
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str3);
            setNetworkName(jSONObjectJsonObjectInit.optString(ImpressionData.IMPRESSION_DATA_KEY_AD_NETWORK, ""));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("instanceName", jSONObjectJsonObjectInit.optString("instanceName", ""));
            jSONObject.put("instanceId", jSONObjectJsonObjectInit.optString("instanceId", ""));
            setNetworkInfo(jSONObject);
            setAdType(jSONObjectJsonObjectInit.optString("adUnit", ""));
            setRevenue(jSONObjectJsonObjectInit.optString("revenue", ""));
            setPrecision(jSONObjectJsonObjectInit.optString("precision", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
