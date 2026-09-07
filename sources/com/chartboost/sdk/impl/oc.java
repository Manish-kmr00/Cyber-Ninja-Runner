package com.chartboost.sdk.impl;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class oc implements pc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f1101a;
    public final xc b;

    public oc(xc xcVar) {
        this.b = xcVar;
    }

    @Override // com.chartboost.sdk.impl.pc.b
    public JSONObject a() {
        return this.f1101a;
    }

    public void b() {
        this.b.b(new cd(this));
    }

    @Override // com.chartboost.sdk.impl.pc.b
    public void a(JSONObject jSONObject) {
        this.f1101a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new jd(this, hashSet, jSONObject, j));
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.b.b(new gd(this, hashSet, jSONObject, j));
    }
}
