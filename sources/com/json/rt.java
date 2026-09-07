package com.json;

import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class rt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f4240a;

    public rt(JSONObject jSONObject) {
        this.f4240a = jSONObject == null ? IronSourceNetworkBridge.jsonObjectInit() : jSONObject;
    }

    public boolean a() {
        return this.f4240a.optBoolean("uxt", false);
    }

    public boolean b() {
        return this.f4240a.optBoolean(b9.a.o, false);
    }

    public boolean c() {
        return this.f4240a.optBoolean(b9.a.p, false);
    }

    public boolean d() {
        return this.f4240a.optBoolean(b9.a.l, false);
    }

    public boolean e() {
        return this.f4240a.optBoolean(b9.a.n, false);
    }
}
