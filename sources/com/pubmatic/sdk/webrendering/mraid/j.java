package com.pubmatic.sdk.webrendering.mraid;

import com.pubmatic.sdk.common.POBError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
class j implements f {
    j() {
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public boolean a() {
        return true;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public String b() {
        return "resize";
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public POBError a(JSONObject jSONObject, m mVar, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        if (jSONObjectOptJSONObject == null) {
            return new POBError(1009, "Invalid MRAID command for orientation event");
        }
        mVar.resize(jSONObjectOptJSONObject.optInt("width", 0), jSONObjectOptJSONObject.optInt("height", 0), jSONObjectOptJSONObject.optInt("offsetX", 0), jSONObjectOptJSONObject.optInt("offsetY", 0), jSONObjectOptJSONObject.optBoolean("allowOffscreen", false), z);
        return null;
    }
}
