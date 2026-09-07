package com.yandex.mobile.ads.impl;

import android.util.Log;
import io.bidmachine.unified.UnifiedMediationParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class y92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10714a;
    private final Float b;
    private final boolean c = true;
    private final kj1 d;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f10714a);
            if (this.f10714a) {
                jSONObject.put(UnifiedMediationParams.KEY_SKIP_OFFSET, this.b);
            }
            jSONObject.put("autoPlay", this.c);
            jSONObject.put(com.ironsource.b9.h.L, this.d);
        } catch (JSONException e) {
            Log.e("OMIDLIB", "VastProperties: JSON error", e);
        }
        return jSONObject;
    }

    private y92(boolean z, Float f, kj1 kj1Var) {
        this.f10714a = z;
        this.b = f;
        this.d = kj1Var;
    }

    public static y92 a(kj1 kj1Var) {
        return new y92(false, null, kj1Var);
    }

    public static y92 a(float f, kj1 kj1Var) {
        return new y92(true, Float.valueOf(f), kj1Var);
    }
}
