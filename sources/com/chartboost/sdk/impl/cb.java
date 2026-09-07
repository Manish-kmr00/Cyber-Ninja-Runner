package com.chartboost.sdk.impl;

import io.bidmachine.unified.UnifiedMediationParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f991a;
    public final Float b;
    public final boolean c;
    public final i8 d;

    public cb(boolean z, Float f, boolean z2, i8 i8Var) {
        this.f991a = z;
        this.b = f;
        this.c = z2;
        this.d = i8Var;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f991a);
            if (this.f991a) {
                jSONObject.put(UnifiedMediationParams.KEY_SKIP_OFFSET, this.b);
            }
            jSONObject.put("autoPlay", this.c);
            jSONObject.put(com.ironsource.b9.h.L, this.d);
        } catch (JSONException e) {
            bd.a("VastProperties: JSON error", e);
        }
        return jSONObject;
    }

    public static cb a(boolean z, i8 i8Var) {
        ld.a(i8Var, "Position is null");
        return new cb(false, null, z, i8Var);
    }

    public static cb a(float f, boolean z, i8 i8Var) {
        ld.a(i8Var, "Position is null");
        return new cb(true, Float.valueOf(f), z, i8Var);
    }
}
