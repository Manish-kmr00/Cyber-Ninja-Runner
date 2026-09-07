package com.pubmatic.sdk.nativead.request;

import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.pubmatic.sdk.nativead.POBNativeLogConstants;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeImageAssetType;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class POBNativeRequestImageAsset extends POBBaseNativeRequestAsset {
    private final POBNativeImageAssetType c;
    private final int d;
    private final int e;
    private List f;

    public POBNativeRequestImageAsset(int i, boolean z, POBNativeImageAssetType pOBNativeImageAssetType, int i2, int i3) {
        super(i, z);
        this.c = pOBNativeImageAssetType;
        this.d = i2;
        this.e = i3;
        this.f = POBNativeConstants.MIMES;
    }

    public List<String> getMimes() {
        return this.f;
    }

    public int getMinimumHeight() {
        return this.e;
    }

    public int getMinimumWidth() {
        return this.d;
    }

    @Override // com.pubmatic.sdk.nativead.request.POBBaseNativeRequestAsset
    public JSONObject getRTBJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", getId());
            jSONObject.put("required", isRequired() ? 1 : 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", this.c.getImageAssetTypeValue());
            jSONObject2.put(POBNativeConstants.NATIVE_IMAGE_MIN_WIDTH, this.d);
            jSONObject2.put(POBNativeConstants.NATIVE_IMAGE_MIN_HEIGHT, this.e);
            if (!this.f.isEmpty()) {
                jSONObject2.put("mimes", new JSONArray((Collection) this.f));
            }
            jSONObject.put("img", jSONObject2);
        } catch (JSONException e) {
            POBLog.error("POBNativeReqIMGAsset", String.format(POBNativeLogConstants.NATIVE_JSON_EXCEPTION, "POBNativeReqIMGAsset") + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    public POBNativeImageAssetType getType() {
        return this.c;
    }

    public void setMimes(List<String> list) {
        this.f = list;
    }
}
