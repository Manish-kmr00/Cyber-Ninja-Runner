package com.pubmatic.sdk.webrendering.mraid;

import com.pubmatic.sdk.common.POBError;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
class e implements f {
    e() {
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public boolean a() {
        return false;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public String b() {
        return "close";
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public POBError a(JSONObject jSONObject, m mVar, boolean z) {
        mVar.close();
        return null;
    }
}
