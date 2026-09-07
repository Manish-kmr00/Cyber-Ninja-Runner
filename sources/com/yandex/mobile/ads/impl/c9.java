package com.yandex.mobile.ads.impl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class c9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rf1 f8579a;
    private final rf1 b;
    private final boolean c;
    private final zu d;
    private final uk0 e;

    private c9() {
        zu zuVar = zu.c;
        uk0 uk0Var = uk0.c;
        rf1 rf1Var = rf1.c;
        this.d = zuVar;
        this.e = uk0Var;
        this.f8579a = rf1Var;
        this.b = rf1Var;
        this.c = false;
    }

    public static c9 a() {
        return new c9();
    }

    public final boolean b() {
        return rf1.c == this.f8579a;
    }

    public final boolean c() {
        return rf1.c == this.b;
    }

    public final JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        zn2.a(jSONObject, "impressionOwner", this.f8579a);
        zn2.a(jSONObject, "mediaEventsOwner", this.b);
        zn2.a(jSONObject, "creativeType", this.d);
        zn2.a(jSONObject, "impressionType", this.e);
        zn2.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.c));
        return jSONObject;
    }
}
