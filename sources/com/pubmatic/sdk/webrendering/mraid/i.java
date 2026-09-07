package com.pubmatic.sdk.webrendering.mraid;

import com.pubmatic.sdk.common.POBError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
class i implements f {
    i() {
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public boolean a() {
        return true;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public String b() {
        return "open";
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public POBError a(JSONObject jSONObject, m mVar, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        if (jSONObjectOptJSONObject == null) {
            return new POBError(1009, "Invalid MRAID command for open() event");
        }
        String strOptString = jSONObjectOptJSONObject.optString("url", null);
        if (strOptString == null) {
            return new POBError(1009, "Invalid MRAID Url for open() event");
        }
        mVar.open(strOptString, z);
        return null;
    }
}
