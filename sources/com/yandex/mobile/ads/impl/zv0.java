package com.yandex.mobile.ads.impl;

import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class zv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mn2 f10853a;

    private zv0(mn2 mn2Var) {
        this.f10853a = mn2Var;
    }

    public final void a() {
        hp0 hp0Var = hp0.c;
        oo2.a(this.f10853a);
        JSONObject jSONObject = new JSONObject();
        zn2.a(jSONObject, "interactionType", hp0Var);
        this.f10853a.j().a("adUserInteraction", jSONObject);
    }

    public final void b() {
        oo2.a(this.f10853a);
        this.f10853a.j().a("bufferFinish");
    }

    public final void c() {
        oo2.a(this.f10853a);
        this.f10853a.j().a("bufferStart");
    }

    public final void d() {
        oo2.a(this.f10853a);
        this.f10853a.j().a("complete");
    }

    public final void e() {
        oo2.a(this.f10853a);
        this.f10853a.j().a(EventConstants.FIRST_QUARTILE);
    }

    public final void f() {
        oo2.a(this.f10853a);
        this.f10853a.j().a("midpoint");
    }

    public final void g() {
        oo2.a(this.f10853a);
        this.f10853a.j().a("pause");
    }

    public final void h() {
        oo2.a(this.f10853a);
        this.f10853a.j().a("resume");
    }

    public final void i() {
        oo2.a(this.f10853a);
        this.f10853a.j().a("skipped");
    }

    public final void j() {
        oo2.a(this.f10853a);
        this.f10853a.j().a(EventConstants.THIRD_QUARTILE);
    }

    public static zv0 a(mn2 mn2Var) {
        if (mn2Var.m()) {
            if (!mn2Var.h()) {
                if (!mn2Var.k()) {
                    if (mn2Var.j().d() == null) {
                        zv0 zv0Var = new zv0(mn2Var);
                        mn2Var.j().a(zv0Var);
                        return zv0Var;
                    }
                    throw new IllegalStateException("MediaEvents already exists for AdSession");
                }
                throw new IllegalStateException("AdSession is finished");
            }
            throw new IllegalStateException("AdSession is started");
        }
        throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
    }

    public final void a(float f, float f2) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            oo2.a(this.f10853a);
            JSONObject jSONObject = new JSONObject();
            zn2.a(jSONObject, "duration", Float.valueOf(f));
            zn2.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
            zn2.a(jSONObject, com.ironsource.b9.i.P, Float.valueOf(to2.a().d()));
            this.f10853a.j().a("start", jSONObject);
            return;
        }
        throw new IllegalArgumentException("Invalid Media volume");
    }

    public final void a(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            oo2.a(this.f10853a);
            JSONObject jSONObject = new JSONObject();
            zn2.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
            zn2.a(jSONObject, com.ironsource.b9.i.P, Float.valueOf(to2.a().d()));
            this.f10853a.j().a("volumeChange", jSONObject);
            return;
        }
        throw new IllegalArgumentException("Invalid Media volume");
    }
}
