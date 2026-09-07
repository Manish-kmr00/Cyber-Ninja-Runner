package com.pubmatic.sdk.webrendering.mraid;

import com.pubmatic.sdk.common.POBError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
class d implements f {
    d() {
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public boolean a() {
        return true;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public String b() {
        return "createCalendarEvent";
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public POBError a(JSONObject jSONObject, m mVar, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        if (jSONObjectOptJSONObject == null) {
            return new POBError(1009, "Invalid MRAID command for createcalendarevent");
        }
        mVar.createCalendarEvent(jSONObjectOptJSONObject, z);
        return null;
    }
}
