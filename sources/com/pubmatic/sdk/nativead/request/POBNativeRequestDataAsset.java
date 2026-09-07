package com.pubmatic.sdk.nativead.request;

import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.pubmatic.sdk.nativead.POBNativeLogConstants;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeDataAssetType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class POBNativeRequestDataAsset extends POBBaseNativeRequestAsset {
    private final POBNativeDataAssetType c;
    private int d;

    public POBNativeRequestDataAsset(int i, boolean z, POBNativeDataAssetType pOBNativeDataAssetType) {
        super(i, z);
        this.c = pOBNativeDataAssetType;
    }

    public int getLength() {
        return this.d;
    }

    @Override // com.pubmatic.sdk.nativead.request.POBBaseNativeRequestAsset
    public JSONObject getRTBJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", getId());
            jSONObject.put("required", isRequired() ? 1 : 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", this.c.getDataAssetTypeValue());
            jSONObject2.put(POBNativeConstants.NATIVE_LENGTH, this.d);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e) {
            POBLog.error("POBNativeReqDataAsset", String.format(POBNativeLogConstants.NATIVE_JSON_EXCEPTION, "POBNativeReqDataAsset") + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    public POBNativeDataAssetType getType() {
        return this.c;
    }

    public void setLength(int i) {
        this.d = i;
    }
}
