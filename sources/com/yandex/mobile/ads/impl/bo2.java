package com.yandex.mobile.ads.impl;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class bo2 implements co2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f8527a;
    private final go2 b;

    public bo2(go2 go2Var) {
        this.b = go2Var;
    }

    public final void a() {
        this.b.a(new ko2(this));
    }

    public final JSONObject b() {
        return this.f8527a;
    }

    public final void a(JSONObject jSONObject) {
        this.f8527a = jSONObject;
    }

    public final void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.a(new po2(this, hashSet, jSONObject, j));
    }

    public final void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.a(new so2(this, hashSet, jSONObject, j));
    }
}
