package com.pubmatic.sdk.webrendering.mraid;

import com.pubmatic.sdk.common.POBError;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
class g implements f {
    g() {
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public boolean a() {
        return false;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public String b() {
        return MraidJsMethods.USE_CUSTOM_CLOSE;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public POBError a(JSONObject jSONObject, m mVar, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        if (jSONObjectOptJSONObject == null) {
            return new POBError(1009, "Invalid MRAID command for useCustomClose event");
        }
        mVar.useCustomClose(jSONObjectOptJSONObject.optBoolean("shouldUseCustomClose", false));
        return null;
    }
}
