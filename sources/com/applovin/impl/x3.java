package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f742a;
    private final String b;

    public x3(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        this.f742a = JsonUtils.getString(jSONObject, "id", "");
        this.b = JsonUtils.getString(jSONObject, "price", null);
    }

    public String a() {
        return this.f742a;
    }

    public String b() {
        return this.b;
    }
}
