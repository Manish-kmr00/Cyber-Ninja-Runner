package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f439a;
    private final String b;
    private final List c;

    public h8(JSONObject jSONObject) {
        this.f439a = JsonUtils.getString(jSONObject, "user_type", "all");
        this.b = JsonUtils.getString(jSONObject, CommonUrlParts.DEVICE_TYPE, "all");
        this.c = JsonUtils.getStringList(jSONObject, "segments", null);
    }

    public String a() {
        return this.f439a;
    }

    public String b() {
        return this.b;
    }

    public List c() {
        return this.c;
    }
}
