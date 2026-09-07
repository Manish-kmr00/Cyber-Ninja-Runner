package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.T;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.fyber.inneractive.sdk.response.b {
    @Override // com.fyber.inneractive.sdk.response.b
    public final void a(String str, T t) {
        try {
            ((i) this.f2320a).M = new JSONObject(str).getString("adm");
        } catch (JSONException e) {
            com.fyber.inneractive.sdk.dv.handler.e.a(t != null ? t.b : null, com.fyber.inneractive.sdk.dv.enums.a.Parse, null, null, e.getLocalizedMessage());
        }
    }

    @Override // com.fyber.inneractive.sdk.response.b
    public final com.fyber.inneractive.sdk.response.e a() {
        return new i();
    }
}
