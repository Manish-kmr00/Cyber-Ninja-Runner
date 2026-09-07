package io.appmetrica.analytics.impl;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class Y8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Un f11432a;

    public Y8(Un un) {
        this.f11432a = un;
    }

    public final void a(int i, long j) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        Un un = this.f11432a;
        synchronized (un) {
            jSONObjectOptJSONObject = un.f11384a.a().optJSONObject("numbers_of_type");
        }
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        jSONObjectOptJSONObject.put(String.valueOf(i), j);
        this.f11432a.a(jSONObjectOptJSONObject);
    }
}
