package com.chartboost.sdk.impl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e8 f1111a;
    public final e8 b;
    public final boolean c;
    public final q3 d;
    public final n6 e;

    public q(q3 q3Var, n6 n6Var, e8 e8Var, e8 e8Var2, boolean z) {
        this.d = q3Var;
        this.e = n6Var;
        this.f1111a = e8Var;
        if (e8Var2 == null) {
            this.b = e8.NONE;
        } else {
            this.b = e8Var2;
        }
        this.c = z;
    }

    public static q a(q3 q3Var, n6 n6Var, e8 e8Var, e8 e8Var2, boolean z) {
        ld.a(q3Var, "CreativeType is null");
        ld.a(n6Var, "ImpressionType is null");
        ld.a(e8Var, "Impression owner is null");
        ld.a(e8Var, q3Var, n6Var);
        return new q(q3Var, n6Var, e8Var, e8Var2, z);
    }

    public boolean b() {
        return e8.NATIVE == this.b;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        vc.a(jSONObject, "impressionOwner", this.f1111a);
        vc.a(jSONObject, "mediaEventsOwner", this.b);
        vc.a(jSONObject, "creativeType", this.d);
        vc.a(jSONObject, "impressionType", this.e);
        vc.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.c));
        return jSONObject;
    }

    public boolean a() {
        return e8.NATIVE == this.f1111a;
    }
}
