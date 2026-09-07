package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import com.safedk.android.internal.partials.MintegralNetworkBridge;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class MBridgeRevenueParamsEntityForAdmob extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForAdmob(String str, String str2) {
        super(str, str2);
        setMediationName("Admob");
    }

    @Override // com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity
    public void setAdType(String str) {
        super.setAdType(str);
    }

    public void setAdmobResponseInfo(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            setSourceData(str, str);
            JSONObject jSONObjectOptJSONObject = MintegralNetworkBridge.jsonObjectInit(str).optJSONObject("Loaded Adapter Response");
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("Credentials");
                if (jSONObjectOptJSONObject2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, jSONObjectOptJSONObject2.get(next) + "");
                    }
                    setNetworkInfo(jSONObject);
                }
                setNetworkName(jSONObjectOptJSONObject.optString("Ad Source Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAdmobRevenueInfo(int i, long j, String str) {
        setRevenue(j + "");
        setPrecision(i + "");
        setCurrency(str);
    }

    @Override // com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity
    public void setDspInfo(String str, String str2) {
        super.setDspInfo(str, str2);
    }
}
