package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.c0;
import com.fyber.inneractive.sdk.util.d0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class Q implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UnitDisplayType f1679a;

    @Override // com.fyber.inneractive.sdk.util.c0
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        d0.a(jSONObject, "unitDisplayType", this.f1679a);
        return jSONObject;
    }
}
