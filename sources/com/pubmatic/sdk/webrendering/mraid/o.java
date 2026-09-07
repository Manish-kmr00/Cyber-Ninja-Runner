package com.pubmatic.sdk.webrendering.mraid;

import com.pubmatic.sdk.common.POBError;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class o implements f {
    o() {
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public boolean a() {
        return true;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public String b() {
        return MraidJsMethods.PLAY_VIDEO;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public POBError a(JSONObject jSONObject, m mVar, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        if (jSONObjectOptJSONObject == null) {
            return new POBError(1009, "Invalid MRAID command for playVideo event");
        }
        String strOptString = jSONObjectOptJSONObject.optString("url", null);
        if (strOptString == null) {
            return new POBError(1009, "Invalid MRAID Url for playVideo event");
        }
        mVar.playVideo(strOptString, z);
        return null;
    }
}
