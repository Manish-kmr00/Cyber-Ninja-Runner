package com.pubmatic.sdk.nativead.request;

import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.pubmatic.sdk.nativead.POBNativeLogConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class POBNativeRequestTitleAsset extends POBBaseNativeRequestAsset {
    private final int c;

    public POBNativeRequestTitleAsset(int i, boolean z, int i2) {
        super(i, z);
        this.c = i2;
    }

    public int getLength() {
        return this.c;
    }

    @Override // com.pubmatic.sdk.nativead.request.POBBaseNativeRequestAsset
    public JSONObject getRTBJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", getId());
            jSONObject.put("required", isRequired() ? 1 : 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(POBNativeConstants.NATIVE_LENGTH, this.c);
            jSONObject.put("title", jSONObject2);
        } catch (JSONException e) {
            POBLog.error("POBNativeReqTitleAsset", String.format(POBNativeLogConstants.NATIVE_JSON_EXCEPTION, "POBNativeReqTitleAsset") + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }
}
