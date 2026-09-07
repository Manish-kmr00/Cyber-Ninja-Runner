package com.chartboost.sdk.impl;

import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zb f988a;

    public c7(zb zbVar) {
        this.f988a = zbVar;
    }

    public void a(x6 x6Var) {
        ld.a(x6Var, "InteractionType is null");
        ld.a(this.f988a);
        JSONObject jSONObject = new JSONObject();
        vc.a(jSONObject, "interactionType", x6Var);
        this.f988a.f().a("adUserInteraction", jSONObject);
    }

    public void b() {
        ld.a(this.f988a);
        this.f988a.f().a("bufferStart");
    }

    public void c() {
        ld.a(this.f988a);
        this.f988a.f().a("complete");
    }

    public void d() {
        ld.a(this.f988a);
        this.f988a.f().a(EventConstants.FIRST_QUARTILE);
    }

    public void e() {
        ld.a(this.f988a);
        this.f988a.f().a("midpoint");
    }

    public void f() {
        ld.a(this.f988a);
        this.f988a.f().a("pause");
    }

    public void g() {
        ld.a(this.f988a);
        this.f988a.f().a("resume");
    }

    public void h() {
        ld.a(this.f988a);
        this.f988a.f().a("skipped");
    }

    public void i() {
        ld.a(this.f988a);
        this.f988a.f().a(EventConstants.THIRD_QUARTILE);
    }

    public void a() {
        ld.a(this.f988a);
        this.f988a.f().a("bufferFinish");
    }

    public final void b(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public void c(float f) {
        b(f);
        ld.a(this.f988a);
        JSONObject jSONObject = new JSONObject();
        vc.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        vc.a(jSONObject, com.ironsource.b9.i.P, Float.valueOf(pd.c().b()));
        this.f988a.f().a("volumeChange", jSONObject);
    }

    public final void a(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    public static c7 a(p pVar) {
        zb zbVar = (zb) pVar;
        ld.a(pVar, "AdSession is null");
        ld.f(zbVar);
        ld.c(zbVar);
        ld.b(zbVar);
        ld.h(zbVar);
        c7 c7Var = new c7(zbVar);
        zbVar.f().a(c7Var);
        return c7Var;
    }

    public void a(g8 g8Var) {
        ld.a(g8Var, "PlayerState is null");
        ld.a(this.f988a);
        JSONObject jSONObject = new JSONObject();
        vc.a(jSONObject, "state", g8Var);
        this.f988a.f().a("playerStateChange", jSONObject);
    }

    public void a(float f, float f2) {
        a(f);
        b(f2);
        ld.a(this.f988a);
        JSONObject jSONObject = new JSONObject();
        vc.a(jSONObject, "duration", Float.valueOf(f));
        vc.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        vc.a(jSONObject, com.ironsource.b9.i.P, Float.valueOf(pd.c().b()));
        this.f988a.f().a("start", jSONObject);
    }
}
