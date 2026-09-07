package com.pubmatic.sdk.webrendering.mraid;

import com.pubmatic.sdk.common.POBError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
class k implements f {
    k() {
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public boolean a() {
        return false;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public String b() {
        return "setOrientationProperties";
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public POBError a(JSONObject jSONObject, m mVar, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        if (jSONObjectOptJSONObject == null) {
            return new POBError(1009, "Invalid MRAID command for orientation event");
        }
        mVar.setOrientation(jSONObjectOptJSONObject.optBoolean("allowOrientationChange", false), jSONObjectOptJSONObject.optString("forceOrientation", null), z);
        return null;
    }
}
