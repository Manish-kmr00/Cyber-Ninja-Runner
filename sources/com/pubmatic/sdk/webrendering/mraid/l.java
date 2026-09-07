package com.pubmatic.sdk.webrendering.mraid;

import com.pubmatic.sdk.common.POBError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
class l implements f {
    l() {
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public boolean a() {
        return true;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public String b() {
        return "storePicture";
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public POBError a(JSONObject jSONObject, m mVar, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        if (jSONObjectOptJSONObject == null) {
            return new POBError(1009, "Invalid MRAID command for storepicture event");
        }
        mVar.storePicture(jSONObjectOptJSONObject.optString("storePicture", jSONObjectOptJSONObject.optString("url")), z);
        return null;
    }
}
