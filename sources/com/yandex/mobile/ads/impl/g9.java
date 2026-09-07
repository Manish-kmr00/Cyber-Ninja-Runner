package com.yandex.mobile.ads.impl;

import android.webkit.WebView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.pubmatic.sdk.crashanalytics.POBCrashAnalyticsConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ao2 f8978a;
    private p3 b;
    private zv0 c;
    private int d;
    private long e;

    public g9() {
        g();
        this.f8978a = new ao2(null);
    }

    public void a() {
    }

    public void b() {
        this.f8978a.clear();
    }

    public final p3 c() {
        return this.b;
    }

    public final zv0 d() {
        return this.c;
    }

    public final void b(String str, long j) {
        if (j < this.e || this.d == 3) {
            return;
        }
        this.d = 3;
        no2.a(this.f8978a.get(), str);
    }

    public final void e() {
        no2.a(this.f8978a.get());
    }

    public final void f() {
        no2.b(this.f8978a.get());
    }

    public final void g() {
        this.e = System.nanoTime();
        this.d = 1;
    }

    public final void a(float f) {
        no2.a(this.f8978a.get(), f);
    }

    final void a(WebView webView) {
        this.f8978a = new ao2(webView);
    }

    public final void a(p3 p3Var) {
        this.b = p3Var;
    }

    public final void a(c9 c9Var) {
        no2.a(this.f8978a.get(), c9Var.d());
    }

    public final void a(zv0 zv0Var) {
        this.c = zv0Var;
    }

    public void a(mn2 mn2Var, d9 d9Var) {
        a(mn2Var, d9Var, null);
    }

    protected final void a(mn2 mn2Var, d9 d9Var, JSONObject jSONObject) {
        String strI = mn2Var.i();
        JSONObject jSONObject2 = new JSONObject();
        zn2.a(jSONObject2, "environment", "app");
        zn2.a(jSONObject2, "adSessionType", d9Var.a());
        zn2.a(jSONObject2, POBCrashAnalyticsConstants.DEVICE_INFO_KEY, pn2.a());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zn2.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        zn2.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, d9Var.f().b());
        zn2.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, d9Var.f().c());
        zn2.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        zn2.a(jSONObject4, "libraryVersion", "1.3.26-Yandex");
        zn2.a(jSONObject4, RemoteConfigConstants.RequestFieldKey.APP_ID, io2.a().b().getApplicationContext().getPackageName());
        zn2.a(jSONObject2, "app", jSONObject4);
        if (d9Var.b() != null) {
            zn2.a(jSONObject2, "contentUrl", d9Var.b());
        }
        if (d9Var.c() != null) {
            zn2.a(jSONObject2, "customReferenceData", d9Var.c());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (wa2 wa2Var : d9Var.g()) {
            zn2.a(jSONObject5, wa2Var.b(), wa2Var.c());
        }
        no2.a(this.f8978a.get(), strI, jSONObject2, jSONObject5, jSONObject);
    }

    public final void a(String str) {
        no2.a(this.f8978a.get(), str, (JSONObject) null);
    }

    public final void a(String str, long j) {
        if (j >= this.e) {
            this.d = 2;
            no2.a(this.f8978a.get(), str);
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        no2.a(this.f8978a.get(), str, jSONObject);
    }

    public final void a(JSONObject jSONObject) {
        no2.b(this.f8978a.get(), jSONObject);
    }

    public final void a(boolean z) {
        if (this.f8978a.get() != null) {
            no2.b(this.f8978a.get(), z ? "foregrounded" : "backgrounded");
        }
    }
}
