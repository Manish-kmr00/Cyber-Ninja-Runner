package com.pubmatic.sdk.webrendering.mraid;

import com.pubmatic.sdk.common.POBError;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class q implements f {
    q() {
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public boolean a() {
        return false;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public String b() {
        return MraidJsMethods.UNLOAD;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.f
    public POBError a(JSONObject jSONObject, m mVar, boolean z) {
        mVar.unload();
        return null;
    }
}
