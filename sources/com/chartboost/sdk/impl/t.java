package com.chartboost.sdk.impl;

import android.webkit.WebView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.pubmatic.sdk.crashanalytics.POBCrashAnalyticsConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1139a;
    public qc b;
    public k c;
    public c7 d;
    public a e;
    public long f;

    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public t(String str) {
        a();
        this.f1139a = str;
        this.b = new qc(null);
    }

    public void a() {
        this.f = id.b();
        this.e = a.AD_STATE_IDLE;
    }

    public void b() {
        this.b.clear();
    }

    public k c() {
        return this.c;
    }

    public c7 d() {
        return this.d;
    }

    public boolean e() {
        return this.b.get() != null;
    }

    public void f() {
        nd.a().a(h(), this.f1139a);
    }

    public void g() {
        nd.a().b(h(), this.f1139a);
    }

    public WebView h() {
        return this.b.get();
    }

    public void i() {
        a((JSONObject) null);
    }

    public void j() {
    }

    public void a(float f) {
        nd.a().a(h(), this.f1139a, f);
    }

    public void b(String str, long j) {
        if (j >= this.f) {
            this.e = a.AD_STATE_VISIBLE;
            nd.a().b(h(), this.f1139a, str);
        }
    }

    public void a(WebView webView) {
        this.b = new qc(webView);
    }

    public void b(boolean z) {
        if (e()) {
            nd.a().a(h(), this.f1139a, z ? "locked" : "unlocked");
        }
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public void a(q qVar) {
        nd.a().a(h(), this.f1139a, qVar.c());
    }

    public void a(c7 c7Var) {
        this.d = c7Var;
    }

    public void a(zb zbVar, r rVar) {
        a(zbVar, rVar, null);
    }

    public void a(zb zbVar, r rVar, JSONObject jSONObject) {
        String strE = zbVar.e();
        JSONObject jSONObject2 = new JSONObject();
        vc.a(jSONObject2, "environment", "app");
        vc.a(jSONObject2, "adSessionType", rVar.a());
        vc.a(jSONObject2, POBCrashAnalyticsConstants.DEVICE_INFO_KEY, nc.d());
        vc.a(jSONObject2, "deviceCategory", ec.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        vc.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        vc.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, rVar.f().a());
        vc.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, rVar.f().b());
        vc.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        vc.a(jSONObject4, "libraryVersion", "1.5.3-Chartboost");
        vc.a(jSONObject4, RemoteConfigConstants.RequestFieldKey.APP_ID, md.b().a().getApplicationContext().getPackageName());
        vc.a(jSONObject2, "app", jSONObject4);
        if (rVar.b() != null) {
            vc.a(jSONObject2, "contentUrl", rVar.b());
        }
        if (rVar.c() != null) {
            vc.a(jSONObject2, "customReferenceData", rVar.c());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (fb fbVar : rVar.g()) {
            vc.a(jSONObject5, fbVar.b(), fbVar.c());
        }
        nd.a().a(h(), strE, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(String str) {
        a(str, (JSONObject) null);
    }

    public void a(String str, long j) {
        if (j >= this.f) {
            a aVar = this.e;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.e = aVar2;
                nd.a().b(h(), this.f1139a, str);
            }
        }
    }

    public void a(String str, JSONObject jSONObject) {
        nd.a().a(h(), this.f1139a, str, jSONObject);
    }

    public void a(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        vc.a(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        nd.a().a(h(), jSONObject);
    }

    public void a(JSONObject jSONObject) {
        nd.a().b(h(), this.f1139a, jSONObject);
    }

    public void a(boolean z) {
        if (e()) {
            nd.a().c(h(), this.f1139a, z ? "foregrounded" : "backgrounded");
        }
    }
}
